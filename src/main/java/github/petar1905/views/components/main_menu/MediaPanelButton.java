package github.petar1905.views.components.main_menu;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;

import github.petar1905.auxillary.classes.Database;
import github.petar1905.views.MediaSearchView;

class MediaPanelButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Database.getInstance().initializeDatabase();
        } catch (SQLException | IOException e1) {
            e1.printStackTrace();
        }
        MediaSearchView view = new MediaSearchView();
        view.setVisible(true);
    } 
}



public class MediaPanelButton extends MainMenuButton {
    public MediaPanelButton() throws SQLException, IOException {
        super();
        this.setText("Insert/Edit Media");
        this.addActionListener(new MediaPanelButtonListener());
    }
}
