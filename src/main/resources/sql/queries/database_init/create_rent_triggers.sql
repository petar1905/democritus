USE democritus;
DELIMITER $$

CREATE TRIGGER decrement_quantity_after_insert
AFTER INSERT ON rents
FOR EACH ROW
BEGIN
    UPDATE media_details
    SET quantity = quantity - 1
    WHERE media_id = NEW.media_id;
END$$

CREATE TRIGGER increment_quantity_after_delete
AFTER DELETE ON rents
FOR EACH ROW
BEGIN
    UPDATE media_details
    SET quantity = quantity + 1
    WHERE media_id = OLD.media_id;
END$$

DELIMITER ;