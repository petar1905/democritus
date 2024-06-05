package github.petar1905.views;

import github.petar1905.auxillary.classes.EmptyPanel;
import github.petar1905.auxillary.classes.swing.View;
import github.petar1905.models.Media;
import github.petar1905.views.components.media_list_panel.ScrollableMediaList;

public class MediaListView extends View {
    public MediaListView(Media[] mediaList) {
        super(
            EmptyPanel.getInstance().panel, 
            new ScrollableMediaList(mediaList), 
            EmptyPanel.getInstance().panel
        );
        this.setTitle("Media List");
    }
    
}
