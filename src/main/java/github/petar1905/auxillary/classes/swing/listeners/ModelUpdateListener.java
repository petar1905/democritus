package github.petar1905.auxillary.classes.swing.listeners;

import javax.swing.JTextField;

public abstract class ModelUpdateListener<E> extends FieldListener {
    protected E model;

    public ModelUpdateListener(E model, JTextField field) {
        super(field);
        this.model = model;
    }
    
}
