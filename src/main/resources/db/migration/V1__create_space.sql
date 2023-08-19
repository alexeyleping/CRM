CREATE TABLE if not exists customer
(
    id      uuid primary key,
    name    varchar(255),
    created date,
    change  date,
    email   varchar(255),
    address varchar(255),
    city    varchar(255),
    country varchar(255),
    phone   varchar(255)
);
CREATE TABLE if not exists appuser
(
    id       uuid primary key,
    username varchar(255),
    password text,
    created  date,
    change   date,
    email    varchar(255),
    address  varchar(255),
    city     varchar(255),
    country  varchar(255),
    phone    varchar(255)
);
CREATE TABLE if not exists application
(
    id           uuid primary key,
    number       SERIAL,
    creator      varchar(255),
    owner        varchar(255),
    type         varchar(255),
    description  varchar(255),
    created      date,
    change       date,
    price        varchar(255),
    phone        varchar(255),
    users_id     uuid references appuser (id),
    customers_id uuid references customer (id)
);
CREATE TABLE if not exists approle
(
    id       uuid primary key,
    namerole varchar(255)
);

create table if not exists appuser_approle
(
    appuser_id uuid references appuser (id),
    approle_id uuid references approle (id),
    CONSTRAINT appuser_approle_pkey PRIMARY KEY (appuser_id, approle_id)
);

insert into appuser
values ('3ba8bcc4-cafe-11ed-afa1-0242ac120002', 'admin',
        '$2a$12$RPb3mUhFdzlAgvvmYBdP/.iLCYfLbp1baJl.nh./jn9E03/61gnga');
insert into appuser
values ('504d9da6-e9d1-11ed-a05b-0242ac120003', 'manager',
        '$2a$12$RPb3mUhFdzlAgvvmYBdP/.iLCYfLbp1baJl.nh./jn9E03/61gnga');
insert into approle
values ('64863d7e-cafe-11ed-afa1-0242ac120002', 'ROLE_ADMIN');
insert into approle
values ('504da508-e9d1-11ed-a05b-0242ac120003', 'ROLE_MANAGER');
insert into appuser_approle
values ('3ba8bcc4-cafe-11ed-afa1-0242ac120002', '64863d7e-cafe-11ed-afa1-0242ac120002');
insert into appuser_approle
values ('504d9da6-e9d1-11ed-a05b-0242ac120003', '504da508-e9d1-11ed-a05b-0242ac120003');
INSERT INTO public.customer(id, name, created, change, email, address, city, country, phone)
VALUES ('e007ce9c-3e5b-11ee-be56-0242ac120002', 'Gazprom', '1900-01-01', '1900-01-01', 'mail@mail.com', 'Adr', 'Moscow',
        'Russia', '9423532');
INSERT INTO public.customer(id, name, created, change, email, address, city, country, phone)
VALUES ('e007d126-3e5b-11ee-be56-0242ac120002', 'Sibneft', '1900-01-01', '1900-01-01', 'mail@mail.com', 'Adr', 'Moscow',
        'Russia', '9423532');
INSERT INTO public.application(id, "number", creator, owner, type, description, created, change, price, phone,
                               appuser_id, customer_id)
VALUES ('743fb43a-3e5c-11ee-be56-0242ac120002', 2, 'manager', 'manager', 'OPEN', 'desc', '1900-01-01', '1900-01-01',
        '1500', '9379992', '504d9da6-e9d1-11ed-a05b-0242ac120003', 'e007d126-3e5b-11ee-be56-0242ac120002');
INSERT INTO public.application(id, "number", creator, owner, type, description, created, change, price, phone,
                               appuser_id, customer_id)
VALUES ('743fb098-3e5c-11ee-be56-0242ac120002', 1, 'admin', 'admin', 'OPEN', 'desc', '1900-01-01', '1900-01-01', '1500',
        '9379992', '3ba8bcc4-cafe-11ed-afa1-0242ac120002', 'e007ce9c-3e5b-11ee-be56-0242ac120002');

