package github.petar1905.views.components.media_search_panel;
import javax.swing.JButton;
import github.petar1905.exceptions.MediaException;
import github.petar1905.models.Media;
import github.petar1905.services.MediaService;
import github.petar1905.views.MediaListView;
import java.awt.event.*;
import java.sql.SQLException;

class AllMediaListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Media[] media = MediaService.getInstance().getAllMedia();
            MediaListView view = new MediaListView(media);
            view.setVisible(true);
        } catch (SQLException | MediaException e1) {
            e1.printStackTrace();
        }

    }
}

class AllMediaButton extends JButton {
    public AllMediaButton() {
        super("All Media");
        this.addActionListener(new AllMediaListener());
    }
}
