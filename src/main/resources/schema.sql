create schema netology;
use netology;

create table if not exists CUSTOMERS
(
    id           int          not null,
    name         varchar(150) not null,
    surname      varchar(150) not null,
    age          int check (age > 0),
    phone_number varchar(12) default 0,
    primary key (id)
);

create table if not exists ORDERS
(
    id           int          not null,
    date         timestamp    not null default now(),
    customer_id  int          not null,
    product_name varchar(255) not null,
    amount       int check ( amount > 0 ),
    primary key (id),
    foreign key (customer_id) references CUSTOMERS (id)
);