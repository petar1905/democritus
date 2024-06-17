package github.petar1905.views.components.media_list_panel;

import github.petar1905.auxillary.classes.swing.ScrollableModelList;
import github.petar1905.models.Media;

public class ScrollableMediaList extends ScrollableModelList<Media> {
    public ScrollableMediaList(Media[] media) {
        super(media);
        this.setListener(new MediaListMouseListener(this.getModelList()));
    }
}