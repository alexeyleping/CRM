CREATE TABLE customers
(
    id SERIAL PRIMARY KEY,
    name text,
    creatTime timestamp,
    dateOfChangeCustomer date,
    email text,
    address text,
    city text,
    country text,
    phoneNumber text
);
CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    name text,
    login text,
    password text,
    creatTime timestamp,
    dateOfChangeUser date,
    email text,
    address text,
    city text,
    country text,
    phoneNumber text,
    role text
);
CREATE TABLE applications
(
    id SERIAL PRIMARY KEY,
    creator text,
    owner text,
    applicationType text,
    description text,
    dateCreated text,
    dateChanged text,
    price text,
    phoneNumber text,
    users_id integer references users(id),
    customers_id integer references customers(id)
);
CREATE TABLE role
(
    id SERIAL PRIMARY KEY,
    name text
);
CREATE TABLE user_role
(
    users_id bigserial references users (id) not null,
    role_id bigserial references role (id) not null,
    constraint user_role_pkey primary key (users_id, role_id)
);






