CREATE TABLE customers
(
    id SERIAL PRIMARY KEY,
    name text,
    dateOfCreationCustomer date,
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
    dateOfCreationUser date,
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





