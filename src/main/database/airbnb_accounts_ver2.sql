ALTER TABLE `airbnb`.`accounts`
ADD COLUMN `create_by` VARCHAR(255) NULL AFTER `last_update_date`,
ADD COLUMN `last_update_by` VARCHAR(255) NULL AFTER `create_by`,
ADD COLUMN `deleted` BIT(1) NOT NULL AFTER `last_update_by`,
CHANGE COLUMN `created_at` `created_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ,
CHANGE COLUMN `updated_at` `last_update_date` DATETIME NULL DEFAULT NULL ;
