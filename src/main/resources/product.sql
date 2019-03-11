BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `Product` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`name`	TEXT NOT NULL,
	`price`	NUMERIC NOT NULL
);
INSERT INTO `Product` (name,price) VALUES ('Bread',20.5);
INSERT INTO `Product` (name,price) VALUES ('Jam',80);
INSERT INTO `Product` (name,price) VALUES ('Butter',100);
INSERT INTO `Product` (name,price) VALUES ('Cheese',120);
COMMIT;