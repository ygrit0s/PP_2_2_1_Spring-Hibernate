CREATE TABLE IF NOT EXISTS `mydb`.`user` (
                    `id` BIGINT NOT NULL AUTO_INCREMENT,
                    `name` VARCHAR(32) NULL,
                    `lastName` VARCHAR(32) NULL,
                    `age` INT NULL,
                    PRIMARY KEY (`id`));