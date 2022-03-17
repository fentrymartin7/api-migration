-- create player card table --

create table if not exists player_cards(
id serial primary key,
name varchar(30)
pos varchar(1),
draft_year integer,
points integer,
assists integer,
rebounds integer
);

insert into player_cards(name,pos,draft_year,career_points,career_rebounds,career_assists)
values
('Michael Jordan','G',1984,32292,6672,5633),
('Kobe Bryant','G',1996,33643,7047,6306),
('Allen Iverson','G',1996,24368,3394,5624),
('Shaquille O''neal','C',1992,28596,13099,3026),
('LeBron James','F',2003,36873,10164,10011),
('Dwayne Wade','G',2003,23165,4933,5701),
('Dirk Nowitzki','F',1998,31560,11489,3651),
('Steve Nash','G',1996,17387,3642,10335),
('Jason Kidd','G',1994,17529,8725,12091),
('Carmelo Anthony','F',2003,28205,7774,3415),
('Larry Bird','G',1978,21791,8974,5695),
('Hakeem Olajuwon', 'C',1984,26946,13748,3058);

