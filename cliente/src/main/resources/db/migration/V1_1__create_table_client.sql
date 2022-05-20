CREATE TABLE cliente (
     id serial PRIMARY KEY,
     name varchar(100) NOT NULL,
     taxpayerId varchar(100) UNIQUE
);