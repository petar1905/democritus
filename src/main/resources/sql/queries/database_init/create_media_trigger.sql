CREATE TRIGGER IF NOT EXISTS delete_media_trigger BEFORE DELETE ON media FOR EACH ROW BEGIN DELETE FROM media_details WHERE media_id = OLD.id; DELETE FROM rents WHERE media_id = OLD.id; END;