SELECT
name, author, year, genre,
description, quantity
FROM media
LEFT JOIN media_details ON media_id = id
WHERE id = ?;

/* TODO Select image */