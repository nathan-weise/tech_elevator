START TRANSACTION;

CREATE TABLE person (
    id serial,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    date_added date,
    CONSTRAINT pk_person PRIMARY KEY (id)
);


CREATE TABLE phone (
    id serial,
    number varchar(10) NOT NULL,
    person_id int NOT NULL,
    type varchar NOT NULL,
    other_description varchar,
    CONSTRAINT pk_phone PRIMARY KEY (id),
    CONSTRAINT fk_phone_person FOREIGN KEY (person_id) REFERENCES person (id),
    CONSTRAINT chk_type CHECK (type IN ('Home', 'Work', 'Mobile', 'Other')),
    CONSTRAINT chk_other_description CHECK (
        (type = 'Other' AND other_description IS NOT NULL) OR
        (type <> 'Other' AND other_description IS NULL)
    )
);

COMMIT;


INSERT INTO person (first_name, last_name, date_added)
VALUES ('David', 'Pfaltzgraff-Carlson', current_date);

INSERT INTO phone (number, person_id, type)
VALUES ('5135551212', 1, 'Home');

INSERT INTO phone (number, person_id, type, other_description)
VALUES ('5135551212', 1, 'Other', 'School');