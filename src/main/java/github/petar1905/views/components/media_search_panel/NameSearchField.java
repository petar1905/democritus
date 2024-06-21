package github.petar1905.views.components.media_search_panel;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JTextField;

import github.petar1905.auxillary.classes.swing.Field;
import github.petar1905.auxillary.classes.swing.listeners.ModelSearchListener;
import github.petar1905.exceptions.MediaException;
import github.petar1905.models.Media;
import github.petar1905.services.MediaService;
import github.petar1905.views.MediaListView;


class UserNameSearchListener extends ModelSearchListener<Media> {

    public UserNameSearchListener(JTextField field) {
        super(null, field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Media[] media = MediaService.getInstance().searchByNameRegex(field.getText());
            MediaListView view = new MediaListView(media);
            view.setVisible(true);
        } catch (SQLException | IOException | MediaException e1) {
            e1.printStackTrace();
        }
    }
    
}


class NameSearchField extends Field {
    public NameSearchField() {
        super("Search by name", "", true);
        this.setListener(new UserNameSearchListener(textField));
    }
    
}
