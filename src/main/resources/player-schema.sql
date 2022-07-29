DROP TABLE IF EXISTS `player` CASCADE;
create table `player` (
		`id` INTEGER UNIQUE PRIMARY KEY AUTO_INCREMENT,
        `name` VARCHAR(255) NOT NULL,
        `position` VARCHAR(255),
        `age` INTEGER,
        `nationality` VARCHAR(255)
);
        