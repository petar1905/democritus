USE democritus;

CREATE TABLE rents (
    id INT PRIMARY KEY AUTO_INCREMENT,
    media_id INT NOT NULL,
    user_id INT NOT NULL,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    FOREIGN KEY (media_id) REFERENCES media(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
);