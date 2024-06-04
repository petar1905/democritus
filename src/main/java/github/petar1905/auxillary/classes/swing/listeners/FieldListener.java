package github.petar1905.auxillary.classes.swing.listeners;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

public abstract class FieldListener implements ActionListener {
    protected JTextField field;

    public FieldListener(JTextField field) {
        this.field = field;
    }
}
