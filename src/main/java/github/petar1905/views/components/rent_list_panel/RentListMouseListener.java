package github.petar1905.views.components.rent_list_panel;

import java.awt.event.MouseEvent;
import github.petar1905.auxillary.classes.swing.ModelList;
import github.petar1905.auxillary.classes.swing.listeners.ModelListMouseListener;
import github.petar1905.models.Rent;
import github.petar1905.views.SingleRentView;

public class RentListMouseListener extends ModelListMouseListener<Rent> {
    public RentListMouseListener(ModelList<Rent> parent) {
        super(parent);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            SingleRentView view = new SingleRentView(getParent().getSelectedValue());
            view.setVisible(true);
        }
    }
}
