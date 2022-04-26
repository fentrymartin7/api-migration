# API Migration(Project 1)

## Project Description

This is an application that allows users to create an account and view a collection of basketball trading cards for easy management and access to player statistics. This application was containerized using Docker and ships logs to Grafana, using Promtail, to easily navigate through different logging event information. Prometheus is also used to create visuals for monitoring the performance of the application using different metrics. 

## Technologies Used

* Maven
* Docker
* Git
* Log4J
* Spring Boot
* Spring Data
* Loki
* Grafana
* PostgreSQL

## Features

Current features:
* As a customer, I can register for a customer account.
* As a customer, I can log in using username and password.
* As a customer, I am able to view any available cards.
* As a customer, I am able to view all the cards I own.
* As a customer, I can search for cards by id, name, position, or certain statistics.
* As an admin, I can add, update and delete cards.
* As an admin, I can view a list of users.
* As an admin, I can add, update and delete users.
* JWT for login/register

Future Features:
* As a customer, I can purchase cards.
* As a user, I can search cards by a variety of combinations of criteria.
* Password hashing

## Getting Started
   
* Clone project repository
> `git clone https://github.com/030722-VA-SRE/Fentry-Martin.git`
* Create enviornment variables for your own database credentials(DB_URL,DB_USER,DB_PASS)
* Navigate to repository on local device. Then navigate to project1 folder
> `cd project1`
* Run docker-compose.yml to package and containerize
> `docker-compose up -d`

## Usage

Use Postman or web browser to send requests 
* Login
> localhost:8080/auth/login
* Register
> localhost:8080/auth/register
* Get all cards
> localhost:8080/cards
* Get/create/update/delete card by id
> localhost:8080/cards/{id}
* Get card by name
> localhost:8080/cards/{name}
* Get user list
> localhost:8080/users
* Get/create/update/delete user by id
> localhost:8080/users/{id}
* All POST, PUT, and DELETE requests can only be performed when logged in as admin. After login, copy JWT token from response header into Authorization in request header.
* Use grafana to view logs and metrics using Loki and Prometheus
> localhost:3000
