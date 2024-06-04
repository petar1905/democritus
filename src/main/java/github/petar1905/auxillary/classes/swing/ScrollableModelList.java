package github.petar1905.auxillary.classes.swing;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.MouseInputListener;

class ModelListMouseListener<E> implements MouseInputListener {
    private ModelList<E> parent;

    public ModelListMouseListener(ModelList<E> parent) {
        this.parent = parent;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            System.out.println(parent.getSelectedValue().toString());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent arg0) {}

    @Override
    public void mouseMoved(MouseEvent arg0) {}
}

class ModelList<E> extends JList<E> {
    ModelList(E[] models) {
        super();
        DefaultListModel<E> listModel = new DefaultListModel<>();
        for (E model : models) {
            listModel.addElement(model);
        }
        this.setModel(listModel);
        ModelListMouseListener<E> listener = new ModelListMouseListener<E>(this);
        this.addMouseListener(listener);
    }

}

public class ScrollableModelList<E> extends JPanel {
    public ScrollableModelList(E[] models) {
        super();
        ModelList<E> modelList = new ModelList<E>(models);
        JScrollPane scrollPane = new JScrollPane(modelList);
        this.add(scrollPane);
    }
}