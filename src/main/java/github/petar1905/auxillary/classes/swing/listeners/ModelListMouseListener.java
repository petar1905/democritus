package github.petar1905.auxillary.classes.swing.listeners;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import github.petar1905.auxillary.classes.swing.ModelList;
import lombok.Getter;

public class ModelListMouseListener<E> implements MouseInputListener {
    private @Getter ModelList<E> parent;

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
