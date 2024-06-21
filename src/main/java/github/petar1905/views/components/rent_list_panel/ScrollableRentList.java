package github.petar1905.views.components.rent_list_panel;

import github.petar1905.auxillary.classes.swing.ScrollableModelList;
import github.petar1905.models.Rent;

public class ScrollableRentList extends ScrollableModelList<Rent> {
    public ScrollableRentList(Rent[] rents) {
        super(rents);
        this.setListener(new RentListMouseListener(this.getModelList()));
    }
}