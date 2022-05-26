CREATE TABLE buyBook (
	id bigint primary key,
    bookId bigint references book(id),
    amount integer not null,
    userId bigint references users(id)
);