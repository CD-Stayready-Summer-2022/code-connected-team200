Create table if not exists `comments`(
	`id` INTEGER NOT NULL auto_increment PRIMARY KEY,
    `body` varchar(250),
    `profile_id` int,
    `blog_post_id` int
);

