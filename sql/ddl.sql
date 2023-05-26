drop table if exists member CASCADE;
CREATE TABLE member (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        userid varchar(100),
                        password varchar(255),
                        name varchar(30),
                        email varchar(255),
                        phonenumber varchar(50)
) AUTO_INCREMENT=1;

CREATE TABLE post (
    postid INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
--     userid BIGINT,
    title VARCHAR(255),
    content TEXT,
    created_date TIMESTAMP,
--     FOREIGN KEY (userid) REFERENCES member(id)
) AUTO_INCREMENT=1;

CREATE TABLE comment (
    comment_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    userid BIGINT,
    postid INT UNSIGNED,
    content TEXT,
    created_data TIMESTAMP,
    FOREIGN KEY (userid) REFERENCES member(id),
    FOREIGN KEY (postid) REFERENCES post(postid)
) AUTO_INCREMENT=1;