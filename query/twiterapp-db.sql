CREATE DATABASE twiterdb;

USE twiterdb;

CREATE TABLE tbl_user
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    gender VARCHAR(255),
    department VARCHAR(255),
    dob DATE
);

CREATE TABLE tbl_tweet
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    message VARCHAR(255),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    foreign key (user_id) references tbl_user(id)
);

CREATE TABLE tbl_follow
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    follow_user_id INT NOT NULL,
    foreign key (user_id) references tbl_user(id),
	foreign key (follow_user_id) references tbl_user(id)
);


insert into tbl_user (name, gender, department, dob) values ('Rishi', 'female', 'APD','1982-01-01');
insert into tbl_user (name, gender, department, dob) values ('John', 'male', 'APD','1982-01-01');
insert into tbl_user (name, gender, department, dob) values ('Harry', 'male', 'APD','1982-01-01');
insert into tbl_user (name, gender, department, dob) values ('Ram', 'male', 'APD','1982-01-01');
insert into tbl_user (name, gender, department, dob) values ('kavita', 'female', 'APD','1982-01-01');
insert into tbl_user (name, gender, department, dob) values ('RamMohan', 'male', 'APD','1982-01-01');
insert into tbl_user (name, gender, department, dob) values ('Hui', 'female', 'APD','1982-01-01');
