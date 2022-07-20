create database Internet;

use Internet;

create table plans (
	id int,
    name varchar(100),
    velocity varchar(100),
    price float,
    discount float,
    primary key(id)
);

create table customers (
	id int,
    id_plan int,
    name varchar(100),
    surname varchar(100),
    birthdate date,
    state varchar(100),
    city varchar(100),
    primary key(id),
    KEY `plan_id_foreign` (`id_plan`),
	CONSTRAINT `plan_id_foreign` FOREIGN KEY (`id_plan`) REFERENCES `plans` (`id`)
);