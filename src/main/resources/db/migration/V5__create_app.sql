CREATE TABLE applications
(
    id SERIAL PRIMARY KEY,
    creator text,
    owner text,
    applicationType text,
    description text,
    dateCreated Date,
    dateChanged Date,
    price float
);