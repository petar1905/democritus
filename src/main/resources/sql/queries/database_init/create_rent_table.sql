USE democritus;

CREATE TABLE rents (
    media_id INT NOT NULL,
    user_id INT NOT NULL,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    FOREIGN KEY (media_id) REFERENCES media(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    PRIMARY KEY (media_id, user_id)
);