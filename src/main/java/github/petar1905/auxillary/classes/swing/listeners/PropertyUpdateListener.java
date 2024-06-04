package github.petar1905.auxillary.classes.swing.listeners;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JTextField;
import github.petar1905.auxillary.classes.AppProperties;

public class PropertyUpdateListener extends FieldListener {
    private String property;

    public PropertyUpdateListener(JTextField field, String property) {
        super(field);
        this.property = property;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            AppProperties.getInstance().setProperty(property, field.getText());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}