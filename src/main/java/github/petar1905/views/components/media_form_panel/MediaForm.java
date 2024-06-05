package github.petar1905.views.components.media_form_panel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import github.petar1905.models.Media;

public class MediaForm extends JPanel {
    public MediaForm(Media media) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new ImageField(media));
        this.add(new NameField(media));
        this.add(new AuthorField(media));
        this.add(new YearField(media));
        this.add(new GenreField(media));
        this.add(new DescriptionField(media));
        this.add(new QuantityField(media));
    }
}
