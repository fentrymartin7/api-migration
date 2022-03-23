-- create player card table --
create table if not exists player_cards(
id serial primary key,
name varchar(30) not null,
pos varchar(1) not null check (pos='G' or pos='F' or pos='C'),
draft_year integer not null check (draft_year>1947 and draft_year<2022),
points integer not null check (points>-1),
rebounds integer not null check (rebounds>-1),
assists integer not null check (assists>-1)
);

-- create table of NBA teams --
create table if not exists teams(
name varchar(30) unique primary key
);

-- add data to the teams table --
insert into teams(name) 
values
('76ers'),
('Bucks'),
('Bulls'),
('Cavaliers'),
('Celtics'),
('Clippers'),
('Grizzlies'),
('Hawks'),
('Heat'),
('Hornets'),
('Jazz'),
('Kings'),
('Knicks'),
('Lakers'),
('Magic'),
('Mavericks'),
('Nets'),
('Nuggets'),
('Pacers'),
('Pelicans'),
('Pistons'),
('Raptors'),
('Rockets'),
('Spurs'),
('Suns'),
('Thunder'),
('Timberwolves'),
('Trailblazers'),
('Warriors'),
('Wizards');

-- insert data into player_cards table --
insert into player_cards(name,pos,draft_year,points,rebounds,assists)
values
('Michael Jordan','G',1984,32292,6672,5633),
('Kobe Bryant','G',1996,33643,7047,6306),
('Allen Iverson','G',1996,24368,3394,5624),
('Shaquille O''Neal','C',1992,28596,13099,3026),
('LeBron James','F',2003,36873,10164,10011),
('Dwayne Wade','G',2003,23165,4933,5701),
('Dirk Nowitzki','F',1998,31560,11489,3651),
('Steve Nash','G',1996,17387,3642,10335),
('Jason Kidd','G',1994,17529,8725,12091),
('Carmelo Anthony','F',2003,28205,7774,3415),
('Larry Bird','G',1978,21791,8974,5695),
('Hakeem Olajuwon', 'C',1984,26946,13748,3058);

-- create a table for player and team relationship --
create table if not exists player_teams_played_for(
team_name varchar(30) references teams(name),
player_id integer references player_cards(id) 
);

-- add player/team relationship data --
insert into player_teams_played_for values
('Bulls',1),('Wizards',1),
('Lakers',2),
('76ers',3),('Nuggets',3),('Pistons',3),('Grizzlies',3),
('Lakers',4),('Magic',4),('Heat',4),('Suns',4),('Cavaliers',4),('Celtics',4),
('Lakers',5),('Cavaliers',5),('Heat',5),
('Heat',6),('Bulls',6),('Cavaliers',6),
('Mavericks',7),
('Suns',8),('Mavericks',8),('Lakers',8),
('Suns',9),('Nets',9),('Mavericks',9),
('Nuggets',10),('Knicks',10),('Thunder',10),('Rockets',10),('Trailblazers',10),('Lakers',10),
('Celtics',11),
('Rockets',12),('Raptors',12);


