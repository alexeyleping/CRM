CREATE TABLE customer
(
    id SERIAL PRIMARY KEY,
    name text,
    dateOdCreationCustomer text,
    dateOfChangeCustomer text,
    emailAddress text,
    address text,
    city text,
    country text,
    phoneNumber text
);
CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    name text,
    dateOdCreationUser text,
    dateOfChangeUser text,
    emailAddress text,
    address text,
    city text,
    country text,
    phoneNumber text
);


