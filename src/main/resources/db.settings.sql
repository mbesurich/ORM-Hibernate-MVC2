drop table cars;
drop table users;



CREATE TABLE IF NOT EXISTS users
(
    id        INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email     VARCHAR(255) NOT NULL
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS cars
(
    id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(255) NOT NULL,
    series INT NOT NULL
)
    ENGINE = InnoDB;
