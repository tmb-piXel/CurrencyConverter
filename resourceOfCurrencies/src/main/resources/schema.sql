CREATE TABLE currency
(
 id serial,
 numcode INT NOT NULL,
 charcode varchar(3) NOT NULL,
 nominal INT NOT NULL,
 name varchar(50) NOT NULL
);