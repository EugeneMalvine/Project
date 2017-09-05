CREATE TABLE `userlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARACTER SET = utf8;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARACTER SET = utf8;

CREATE TABLE list (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  userlists INTEGER(11) NOT NULL
)
  ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

CREATE TABLE `notes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `checkmark` int(11) NOT NULL,
  `listsid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARACTER SET = utf8;

CREATE TABLE `contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(255) NOT NULL ,
  `lastname` VARCHAR(255) ,
  `birthday` VARCHAR(255) ,
  `email` VARCHAR(255) ,
  `userid` INT(11)  ,
  PRIMARY KEY (`id`)
  )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

create table persistent_logins (
  username VARCHAR(64) NOT NULL ,
  series VARCHAR(64) NOT NULL PRIMARY KEY,
  token VARCHAR(64) NOT NULL ,
  last_used TIMESTAMP NOT NULL
)