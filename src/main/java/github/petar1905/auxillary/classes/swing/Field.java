package github.petar1905.auxillary.classes.swing;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lombok.Getter;

public class Field extends JPanel {
    private UpdateButton updateButton;
    protected @Getter JTextField textField;

    public Field(String labelText, String defaultText, boolean hasButton) {
        super();
        JLabel label = new JLabel(labelText);
        this.add(label);
        this.textField = new JTextField(defaultText, 16);
        this.add(textField);
        this.updateButton = new UpdateButton();

        if (hasButton) {
            this.add(updateButton);
        }
    }

    public Field(String labelText, String defaultText) {
        this(labelText, defaultText, false);
    }

    public Field(String labelText, ActionListener listener, String defaultText) {
        this(labelText, defaultText);
        setListener(listener);
    }

    public void setListener(ActionListener listener) {
        updateButton.setListener(listener);
    }

    public String getText() {
        return textField.getText();
    }
}
