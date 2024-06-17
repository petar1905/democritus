package github.petar1905.views.components.media_list_panel;

import github.petar1905.exceptions.MediaException;
import github.petar1905.models.Media;
import github.petar1905.views.SingleMediaView;
import github.petar1905.views.components.main_menu.MainMenuButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;



class NewMediaButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Media media;
        try {
            media = new Media();
            SingleMediaView view = new SingleMediaView(media);
            view.setVisible(true);
        } catch (SQLException | MediaException e1) {
            e1.printStackTrace();
        }
    }
}

public class NewMediaButton extends MainMenuButton {
    public NewMediaButton() {
        super();
        this.setText("New Media");
        this.addActionListener(new NewMediaButtonListener());
    }
}
