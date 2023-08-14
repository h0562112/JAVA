DROP TABLE IF EXISTS employees;
CREATE TABLE  employees (
  `id` INT NOT NULL AUTO_INCREMENT, 
  `employeeid` VARCHAR(255) NOT NULL,
  `name`       VARCHAR(255) NOT NULL,
  `birthday`   DATETIME  NULL,
  `email`      VARCHAR(255) NOT NULL, 
  `picture`      LONGTEXT, 
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) 
); 