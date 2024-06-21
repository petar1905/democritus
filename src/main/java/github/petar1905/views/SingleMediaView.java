package github.petar1905.views;

import github.petar1905.auxillary.classes.swing.ButtonContainer;
import github.petar1905.auxillary.classes.swing.View;
import github.petar1905.models.Media;
import github.petar1905.views.components.media_form_panel.DeleteMediaButton;
import github.petar1905.views.components.media_form_panel.MediaForm;
import github.petar1905.views.components.media_form_panel.RentersButton;

public class SingleMediaView extends View {

    public SingleMediaView(Media media) {
        super(
            new ButtonContainer(new RentersButton(media)), 
            new MediaForm(media), 
            new ButtonContainer(new DeleteMediaButton(media))
        );
        this.setTitle(String.format("Media %s", media.getName()));
    }
    
}
