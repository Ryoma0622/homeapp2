CREATE TABLE `User`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `user_id` varchar(12) UNIQUE NOT NULL,
    `password` varchar(255) NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    `is_deleted` INT DEFAULT 0,
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)