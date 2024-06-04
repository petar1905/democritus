package github.petar1905.auxillary.classes.swing;

import github.petar1905.auxillary.classes.swing.listeners.PropertyUpdateListener;

public class PropertyField extends Field {
    public PropertyField(String labelText, String property, String defaultText) {
        super(labelText, defaultText);
        PropertyUpdateListener listener = new PropertyUpdateListener(textField, property);
        setListener(listener);
    }
}
