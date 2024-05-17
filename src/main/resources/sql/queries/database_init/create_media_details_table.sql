USE democritus;

CREATE TABLE media_details (
    media_id INT NOT NULL UNIQUE,
    year INT,
    genre VARCHAR(25),
    description VARCHAR(255),
    quantity INT,
    picture MEDIUMBLOB,
    FOREIGN KEY (media_id) REFERENCES media(id)
);