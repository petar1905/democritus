package github.petar1905.views.components.new_rent_panel;

import java.sql.Date;
import java.text.ParseException;

import github.petar1905.auxillary.classes.DateUtilities;
import github.petar1905.auxillary.classes.swing.Field;

public class DateField extends Field {
    public DateField(boolean hasButton, String label) {
        super(label, "YYYY-MM-DD", hasButton);
    }

    public Date getDate() throws ParseException {
        return DateUtilities.dateFrom(this.getTextField().getText());
    }
}
