use `code_connected`;
CREATE TABLE `blogposts` (
`id`  INTEGER NOT NULL PRIMARY KEY,
`body`VARCHAR(250),
`comment_id` INT,
`profile_id`INT
);