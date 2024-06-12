package github.petar1905.auxillary.classes.swing;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import github.petar1905.auxillary.classes.swing.listeners.ModelListMouseListener;
import lombok.Getter;

public class ScrollableModelList<E> extends JPanel {
    private @Getter ModelList<E> modelList;
    public ScrollableModelList(E[] models) {
        super();
        this.modelList = new ModelList<E>(models);
        JScrollPane scrollPane = new JScrollPane(this.modelList);
        this.add(scrollPane);
    }

    public ScrollableModelList(E[] models, MouseListener listener) {
        super();
        this.modelList = new ModelList<E>(models, listener);
        JScrollPane scrollPane = new JScrollPane(this.modelList);
        this.add(scrollPane);
    }

    public void setModels(E[] models) {
        modelList.setModels(models);
    }

    public void setListener(ModelListMouseListener<E> listener) {
        modelList.setListener(listener);
    }
}