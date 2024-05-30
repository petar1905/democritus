package github.petar1905.views;

import javax.swing.*;

public class View extends JFrame {
    private JPanel root;
    private View(JPanel centerPanel) {
        super();
        root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.LINE_AXIS));
        root.add(centerPanel);
        root.add(Box.createHorizontalGlue());
        this.add(root);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
    }

    private View(JPanel centerPanel, JPanel secondaryPanel) {
        this(centerPanel);
        root.add(secondaryPanel);
        root.add(Box.createHorizontalGlue());

    }

    public View(JPanel centerPanel, JPanel leftPanel, JPanel rightPanel) {
        this(centerPanel, leftPanel);
        root.add(rightPanel);
    }
}
