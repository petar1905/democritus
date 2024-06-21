package github.petar1905.views;

import github.petar1905.auxillary.classes.swing.EmptyPanel;
import github.petar1905.auxillary.classes.swing.View;
import github.petar1905.views.components.media_search_panel.MediaSearchForm;

public class MediaSearchView extends View {
    public MediaSearchView() {
        super(
            EmptyPanel.getInstance().panel,
            new MediaSearchForm(),
            EmptyPanel.getInstance().panel
        );
        this.setTitle("Media List Options");
    }
}
