BEGIN TRANSACTION;


CREATE TABLE customer (
    customer_id serial,
    name varchar NOT NULL,
    address varchar NOT NULL,
    phone varchar(15),
    CONSTRAINT pk_customer_id PRIMARY KEY (customer_id)
);


CREATE TABLE artist (
    artist_id serial,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    CONSTRAINT pk_artist_id PRIMARY KEY (artist_id)
);


CREATE TABLE art (
    art_code varchar(8),
    title varchar,
    artist_id int,
    CONSTRAINT pk_art_code PRIMARY KEY (art_code),
    CONSTRAINT fk_artist_id FOREIGN KEY (artist_id) REFERENCES artist (artist_id)
);

CREATE TABLE customer_purchase (
    customer_id int,
    art_code varchar(8),
    purchase_date date,
    price numeric(15,2) NOT NULL,
    CONSTRAINT pk_customer_id_art_code_purchase_date PRIMARY KEY (customer_id, art_code, purchase_date),
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
    CONSTRAINT fk_art_code FOREIGN KEY (art_code) REFERENCES art (art_code)
);






COMMIT;