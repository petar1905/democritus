package github.petar1905.auxillary.classes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lombok.Getter;


class PropertyUpdateActionListener extends FieldListener {
    private String property;

    public PropertyUpdateActionListener(JTextField field, String property) {
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

public abstract class Field extends JPanel {
    private UpdateButton updateButton;
    private @Getter JTextField textField;

    public Field(String labelText, String defaultText) {
        super();
        JLabel label = new JLabel(labelText);
        this.add(label);
        this.textField = new JTextField(defaultText, 16);
        this.add(textField);
        this.updateButton = new UpdateButton();
        this.add(updateButton);
    }

    public Field(String labelText, ActionListener listener, String defaultText) {
        this(labelText, defaultText);
        setListener(listener);
    }

    public Field(String labelText, String property, String defaultText) {
        this(labelText, defaultText);
        ActionListener listener = new PropertyUpdateActionListener(textField, property);
        setListener(listener);
    }

    public void setListener(ActionListener listener) {
        updateButton.setListener(listener);
    }
}
