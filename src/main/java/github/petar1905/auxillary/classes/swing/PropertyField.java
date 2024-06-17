package github.petar1905.auxillary.classes.swing;

import java.io.IOException;

import github.petar1905.auxillary.classes.AppProperties;
import github.petar1905.auxillary.classes.swing.listeners.PropertyUpdateListener;

public class PropertyField extends Field {
    public PropertyField(String labelText, String property, String defaultText) {
        super(labelText, AppProperties.getInstance().getProperty(property, ""));
        PropertyUpdateListener listener = new PropertyUpdateListener(textField, property);
        setListener(listener);
    }
}
