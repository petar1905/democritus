SELECT
i.name,
j.egn_number,
j.gsm_number,
j.address,
j.description
FROM users i WHERE id = ?
LEFT JOIN user_details j ON j.user_id = i.id;