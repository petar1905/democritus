USE democritus;
DELIMITER $$

CREATE TRIGGER check_quantity_before_update
BEFORE UPDATE ON media_details
FOR EACH ROW
BEGIN
    IF NEW.quantity < 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: quantity cannot be less than 0';
    END IF;
END$$

DELIMITER ;