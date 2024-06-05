package github.petar1905.views.components.media_form_panel;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import github.petar1905.models.Media;

class ImageField extends JPanel {
    public ImageField(Media media) {
        super();
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix matrix;
        Image image;
        try {
            matrix = qrCodeWriter.encode(Integer.toString(media.getId()), BarcodeFormat.QR_CODE, 300, 300);
            image = MatrixToImageWriter.toBufferedImage(matrix);
            ImageIcon icon = new ImageIcon(image);
            this.add(new JLabel(icon));
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
