package github.petar1905.auxillary.classes.swing.listeners;

import javax.swing.JTextField;

public abstract class ModelSearchListener<E> extends FieldListener {
    protected E[] models;

    public ModelSearchListener(E[] models, JTextField field) {
        super(field);
        this.models = models;
    }
}