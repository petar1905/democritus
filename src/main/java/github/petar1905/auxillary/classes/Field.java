package github.petar1905.auxillary.classes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class PropertyUpdateActionListener implements ActionListener {
    private JTextField field;
    private String property;

    public PropertyUpdateActionListener(JTextField field, String property) {
        this.field = field;
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
    public Field(String labelText, String property, String defaultText) {
        super();
        JLabel label = new JLabel(labelText);
        this.add(label);
        String textToAdd;
        try {
            textToAdd = AppProperties.getInstance().getProperty(property, defaultText);
            JTextField textField = new JTextField(textToAdd, 16);
            this.add(textField);
            JButton updateButton = new JButton("Update");
            ActionListener actionListener = new PropertyUpdateActionListener(textField, property);
            updateButton.addActionListener(actionListener);
            this.add(updateButton);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
