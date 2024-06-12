package github.petar1905.auxillary.classes.swing;

import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import github.petar1905.auxillary.classes.swing.listeners.ModelListMouseListener;

public class ModelList<E> extends JList<E> {
    private DefaultListModel<E> listModel;
    private ModelListMouseListener<E> listener;
    ModelList(E[] models) {
        super();
        listModel = new DefaultListModel<>();
        for (E model : models) {
            listModel.addElement(model);
        }
        this.setModel(listModel);
        this.listener = new ModelListMouseListener<E>(this);
        this.addMouseListener(listener);
    }

    ModelList(E[] models, MouseListener listener) {
        super();
        listModel = new DefaultListModel<>();
        for (E model : models) {
            listModel.addElement(model);
        }
        this.setModel(listModel);
        this.addMouseListener(listener);
    }

    public void setModels(E[] models) {
        listModel.removeAllElements();
        for (E model : models) {
            listModel.addElement(model);
        }
        this.setModel(listModel);
    }

    public void setListener(ModelListMouseListener<E> listener) {
        this.removeMouseListener(this.listener);
        this.listener = listener;
        this.addMouseListener(this.listener);
    }

}