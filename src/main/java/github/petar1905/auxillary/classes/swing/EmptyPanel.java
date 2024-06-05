package github.petar1905.auxillary.classes.swing;

import javax.swing.JPanel;

public class EmptyPanel {
    private static EmptyPanel singleInstance = null;
    public JPanel panel;

    private EmptyPanel() {
        this.panel = new JPanel();
    }

    public static synchronized EmptyPanel getInstance() {
        if (singleInstance == null) {
            singleInstance = new EmptyPanel();
        }
        return singleInstance;
    }
}
