use `code_connected`;
CREATE TABLE if NOT EXISTS `messages` (
    `id`  INTEGER NOT NULL auto_increment PRIMARY KEY,
    `date` DATE(),
    `sender_id` INT,
    `content` VARCHAR(250),
    `chat_id` INT

    );