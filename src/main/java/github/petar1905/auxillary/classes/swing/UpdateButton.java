package github.petar1905.auxillary.classes.swing;

import java.awt.event.ActionListener;
import javax.swing.JButton;

class UpdateButton extends JButton {
    private ActionListener listener;

    public UpdateButton() {
        super("Update");
        this.addActionListener(listener);
    }

    public UpdateButton(String label) {
        super(label);
        this.addActionListener(listener);
    }

    public void setListener(ActionListener listener) {
        this.removeActionListener(this.listener);
        this.listener = listener;
        this.addActionListener(this.listener);
    }
}
