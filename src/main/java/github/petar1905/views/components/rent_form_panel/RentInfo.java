package github.petar1905.views.components.rent_form_panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import github.petar1905.models.Rent;

public class RentInfo extends JPanel {
    public RentInfo(Rent rent) {
        super();
        this.add(new UserField(rent.getUser()));
        this.add(new MediaField(rent.getMedia()));
        String startDateFormat = String.format("Start Date: %s", rent.getStartDate());
        this.add(new JLabel(startDateFormat));
        String endDateFormat = String.format("End Date: %s", rent.getEndDate());
        this.add(new JLabel(endDateFormat));

    }
}
