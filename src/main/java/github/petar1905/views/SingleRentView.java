package github.petar1905.views;
import github.petar1905.auxillary.classes.swing.ButtonContainer;
import github.petar1905.auxillary.classes.swing.EmptyPanel;
import github.petar1905.auxillary.classes.swing.View;
import github.petar1905.models.Rent;
import github.petar1905.views.components.rent_form_panel.DeleteRentButton;
import github.petar1905.views.components.rent_form_panel.RentInfo;

public class SingleRentView extends View {
    public SingleRentView(Rent rent) {
        super(
            EmptyPanel.getInstance().panel,
            new RentInfo(rent),
            new ButtonContainer(new DeleteRentButton(rent)) 
        );
        this.setTitle(String.format("Rent %s-%s", rent.getUser().getName(), rent.getMedia().getName()));
    }
}
