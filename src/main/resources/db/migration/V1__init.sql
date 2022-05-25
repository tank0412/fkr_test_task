CREATE TABLE users (
	id bigint primary key,
	login varchar(100) unique not null,
	role integer not null,
	password varchar(100) not null
);

CREATE TABLE book (
	id bigint primary key,
	title varchar(100) unique not null
);

CREATE TABLE author (
	id bigint primary key,
	name varchar(20) unique not null,
	surname varchar(20) unique not null
);

CREATE TABLE book_author (
    author_id bigint references author(id),
    book_id bigint references book(id)
);