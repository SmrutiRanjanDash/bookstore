DROP TABLE IF EXISTS TBL_BOOKS;

CREATE TABLE TBL_BOOKS (
                           id INT AUTO_INCREMENT  PRIMARY KEY,
                           name VARCHAR(25) NOT NULL,
                           description VARCHAR(250) NOT NULL,
                           author VARCHAR(25) DEFAULT NULL,
                           type VARCHAR(25) DEFAULT NULL,
                           price VARCHAR(25) DEFAULT NULL,
                           isbn VARCHAR(25) DEFAULT NULL
);

