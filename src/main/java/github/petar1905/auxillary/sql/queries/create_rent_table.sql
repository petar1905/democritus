USE democritus;

CREATE TABLE rents (
    media_id INT NOT NULL,
    user_id INT NOT NULL,
    start_date DATETIME,
    end_date DATETIME,
    FOREIGN KEY (media_id) REFERENCES media(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);