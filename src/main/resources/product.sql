BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `Product` (
	`id`	INTEGER,
	`name`	TEXT,
	`price`	NUMERIC,
	PRIMARY KEY(`id`)
);
INSERT INTO `Product` (id,name,price) VALUES (1,'Bread',20.5);
INSERT INTO `Product` (id,name,price) VALUES (2,'Jam',80);
INSERT INTO `Product` (id,name,price) VALUES (3,'Butter',100);
INSERT INTO `Product` (id,name,price) VALUES (4,'Cheese',120);
COMMIT;