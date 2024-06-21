package github.petar1905.views.components.new_rent_panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import github.petar1905.auxillary.classes.Database;
import github.petar1905.exceptions.RentException;
import github.petar1905.models.Media;
import github.petar1905.models.Rent;
import github.petar1905.models.User;
import github.petar1905.views.components.media_list_panel.ScrollableMediaList;

class RentCreationListener implements ActionListener {
    private DateField startDateField, endDateField;
    private ScrollableMediaList mediaList;
    private User user;
    private JLabel prompt;
    
    public RentCreationListener(
        DateField startDateField, 
        DateField endDateField, 
        ScrollableMediaList mediaList, 
        User user,
        JLabel prompt 
    ) {
        this.startDateField = startDateField;
        this.endDateField = endDateField;
        this.mediaList = mediaList;
        this.user = user;
        this.prompt = prompt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Media selectedMedia = mediaList.getModelList().getSelectedValue();
            new Rent(
                user, 
                selectedMedia, 
                startDateField.getDate(), 
                endDateField.getDate()
            );

            String format = "%s has successfully rented %s!";
            this.prompt.setText(String.format(format, user.getName(), selectedMedia.getName()));
            Database.getInstance().connection.commit();
        } catch (SQLException | IOException | RentException | ParseException e1) {
            e1.printStackTrace();
        }
    }
    
}

public class NewRentForm extends JPanel {
    public NewRentForm(User user, Media[] selectableMedia) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ScrollableMediaList mediaList = new ScrollableMediaList(selectableMedia);
        this.add(mediaList);
        DateField startDateField = new DateField(false);
        this.add(startDateField);
        DateField endDateField = new DateField(false);
        this.add(endDateField);
        
        JLabel prompt = new JLabel();
        JButton rentButton = new JButton("Rent");
        rentButton.addActionListener(new RentCreationListener(startDateField, endDateField, mediaList, user, prompt));
        this.add(rentButton);
        this.add(prompt);
    }
}
