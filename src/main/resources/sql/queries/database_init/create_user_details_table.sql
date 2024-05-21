CREATE TABLE IF NOT EXISTS user_details (
    user_id INT NOT NULL UNIQUE,
    egn_number VARCHAR(255),
    gsm_number VARCHAR(255),
    address VARCHAR(255),
    description VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id)
);