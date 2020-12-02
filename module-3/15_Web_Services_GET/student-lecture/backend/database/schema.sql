BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, comments, cards, boards;

CREATE TABLE users (
	user_id serial,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE boards (
    id serial PRIMARY KEY,
    title varchar NOT NULL,
    background_color varchar(8) NOT NULL
);

CREATE TABLE cards (
    id serial PRIMARY KEY,
    board_id int REFERENCES boards(id),
    title varchar,
    description varchar,
    avatar varchar,
    creation_date date,
    status varchar,
    tag varchar
);

CREATE TABLE comments (
    id serial PRIMARY KEY,
    card_id int REFERENCES cards(id),
    author varchar,
    body varchar,
    posted_on TIMESTAMP
);



COMMIT TRANSACTION;
