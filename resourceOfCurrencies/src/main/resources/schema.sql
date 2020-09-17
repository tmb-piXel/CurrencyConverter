CREATE TABLE currency
(
    id_currency serial,
    numcode INT NOT NULL,
    charcode varchar(3) NOT NULL,
    nominal INT NOT NULL,
    name varchar(50) NOT NULL,
    primary key(id_currency)
);

create table rate
(
    id serial,
    charcode varchar(3) not null,
    value varchar(10) not null,
    date_add date not null,
    primary key(id)
);