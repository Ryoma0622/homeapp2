CREATE TABLE `user`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `user_id` varchar(12) UNIQUE NOT NULL,
    `password` varchar(255) NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    `is_deleted` INT DEFAULT 0,
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);

CREATE TABLE `user_role`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `user_id` varchar(12) UNIQUE NOT NULL,
    `role_id` int(11) NOT NULL ,
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);

CREATE TABLE `role`
(
    `id`   int(11) NOT NULL,
    `name` varchar(12) UNIQUE NOT NULL,
    PRIMARY KEY (`id`)
);