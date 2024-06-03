package github.petar1905.auxillary.classes;

import javax.swing.*;

public class View extends JFrame {
    private JPanel root;
    private View(JPanel leftPanel) {
        super();
        root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.X_AXIS));
        root.add(leftPanel);
        root.add(Box.createHorizontalGlue());
        this.add(root);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setResizable(false);
    }

    private View(JPanel leftPanel, JPanel centerPanel) {
        this(leftPanel);
        root.add(centerPanel);
        root.add(Box.createHorizontalGlue());

    }

    public View(JPanel leftPanel, JPanel centerPanel, JPanel rightPanel) {
        this(leftPanel, centerPanel);
        root.add(rightPanel);
    }
}
