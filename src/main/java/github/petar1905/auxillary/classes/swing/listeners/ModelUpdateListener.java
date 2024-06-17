package github.petar1905.auxillary.classes.swing.listeners;

import javax.swing.JTextField;

import lombok.Getter;

public abstract class ModelUpdateListener<E> extends FieldListener {
    protected @Getter E model;

    public ModelUpdateListener(E model, JTextField field) {
        super(field);
        this.model = model;
    } 
}