package github.petar1905.auxillary.classes.swing.listeners;

import javax.swing.JTextField;
import github.petar1905.models.Rent;

public abstract class RentUpdateListener extends ModelUpdateListener<Rent> {
    public RentUpdateListener(Rent rent, JTextField field) {
        super(rent, field);
    }
    
}
