ALTER TABLE `airbnb`.`accounts`
CHANGE COLUMN `last_update_date` `last_updated_date` DATETIME NULL DEFAULT NULL ,
CHANGE COLUMN `create_by` `created_by` VARCHAR(255) NULL DEFAULT NULL ,
CHANGE COLUMN `last_update_by` `last_updated_by` VARCHAR(255) NULL DEFAULT NULL ,
CHANGE COLUMN `deleted` `deleted` BIT(1) NULL DEFAULT false ,
ADD COLUMN `version` BIGINT(20) NULL AFTER `deleted`;