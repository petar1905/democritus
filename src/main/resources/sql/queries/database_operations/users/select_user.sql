SELECT name,
egn_number, gsm_number,
address, description
FROM users
LEFT JOIN user_details ON user_id = id
WHERE id = ?