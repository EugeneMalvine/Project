DROP TABLE IF EXISTS `userlist`;
CREATE TABLE IF NOT EXISTS `userlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS list;
CREATE TABLE IF NOT EXISTS list (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  userlists INT(11) NOT NULL
);

DROP TABLE IF EXISTS notes;
CREATE TABLE IF NOT EXISTS `notes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `checkmark` int(11) NOT NULL,
  `listsid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE  IF EXISTS contact;
CREATE TABLE IF NOT EXISTS `contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(255) NOT NULL ,
  `lastname` VARCHAR(255) ,
  `birthday` VARCHAR(255) ,
  `email` VARCHAR(255) ,
  `userid` INT(11)  ,
  PRIMARY KEY (`id`)
  );

DROP TABLE IF EXISTS persistent_logins;
create table IF NOT EXISTS persistent_logins (
  username VARCHAR(64) NOT NULL ,
  series VARCHAR(64) NOT NULL PRIMARY KEY,
  token VARCHAR(64) NOT NULL ,
  last_used TIMESTAMP NOT NULL
);