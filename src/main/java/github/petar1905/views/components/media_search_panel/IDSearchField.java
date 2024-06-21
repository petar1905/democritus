package github.petar1905.views.components.media_search_panel;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JTextField;
import github.petar1905.auxillary.classes.swing.Field;
import github.petar1905.auxillary.classes.swing.listeners.ModelSearchListener;
import github.petar1905.exceptions.MediaException;
import github.petar1905.models.Media;
import github.petar1905.views.SingleMediaView;


class IDSearchListener extends ModelSearchListener<Media> {

    public IDSearchListener(JTextField field) {
        super(null, field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Media media = new Media(Integer.parseInt(field.getText()));
            SingleMediaView view = new SingleMediaView(media);
            view.setVisible(true);
        } catch (SQLException | MediaException e1) {
            e1.printStackTrace();
        }
    }
    
}


class IDSearchField extends Field {
    public IDSearchField() {
        super("Search by ID", "", true);
        this.setListener(new IDSearchListener(textField));
    }
    
}
