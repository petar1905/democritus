SELECT
i.name,
i.author,
j.year
j.genre,
j.description,
j.quantity
FROM media i WHERE id = ?
LEFT JOIN media_details j ON j.user_id = i.id;

/* TODO Select image */