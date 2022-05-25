INSERT INTO Book VALUES (1, 'Мастер и Маргарита', 0, 100, 107);
INSERT INTO Book VALUES (2, 'Преступление и наказание', 0, 200, 214);
INSERT INTO Book VALUES (3, 'Война и мир', 0, 250, 267.5);
INSERT INTO Book VALUES (4, 'Голова профессора Доуэля', 0, 99, 105.93);
INSERT INTO Book VALUES (5, 'Человек Амфибия', 0, 300, 321);
INSERT INTO Book VALUES (6, 'Прогулки по рекам и каналам Санкт-Петербурга', 1, 419, 448.33);

ALTER TABLE Author ADD COLUMN MiddleName varchar(20);
INSERT INTO Author VALUES (1, 'Булгаков', 'Михаил', 'Александрович');
INSERT INTO Author VALUES (2, 'Достоевский', 'Федор', 'Михайлович');
INSERT INTO Author VALUES (3, 'Толстой', 'Лев', 'Николаевич');
INSERT INTO Author VALUES (4, 'Беляев', 'Александр', 'Романович');
INSERT INTO Author VALUES (5, 'Бунатян', 'Галина', 'Георгиевна');
INSERT INTO Author VALUES (6, 'Чарная', 'Марина', 'Германовна');

--book_id, author_id,
INSERT INTO book_author VALUES(1, 1);
INSERT INTO book_author VALUES(2, 2);
INSERT INTO book_author VALUES(3, 3);
INSERT INTO book_author VALUES(4, 4);
INSERT INTO book_author VALUES(5, 4);
INSERT INTO book_author VALUES(6, 5);
INSERT INTO book_author VALUES(6, 6);
