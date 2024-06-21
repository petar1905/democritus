package github.petar1905.views.components.media_form_panel;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JTextField;

import github.petar1905.auxillary.classes.Database;
import github.petar1905.auxillary.classes.swing.Field;
import github.petar1905.auxillary.classes.swing.listeners.MediaUpdateListener;
import github.petar1905.exceptions.MediaException;
import github.petar1905.models.Media;

class YearUpdateListener extends MediaUpdateListener {
    public YearUpdateListener(Media media, JTextField field) {
        super(media, field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            model.setYear(Integer.parseInt(field.getText()));
            Database.getInstance().connection.commit();
        } catch (IOException | SQLException | MediaException e1) {
            e1.printStackTrace();
        }
    } 
}

class YearField extends Field {
    public YearField(Media media) {
        super("Year", Integer.toString(media.getYear()), true);
        this.setListener(new YearUpdateListener(media, getTextField()));
    }
}
