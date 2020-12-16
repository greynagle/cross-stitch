import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JPanel {

    public void paint(Graphics g) {
        Image img = null;
        try {
            img = combiningImages();
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(img, 0,0,this);
    }

    private Image combiningImages() throws IOException {
//        BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);

        File path = new File("./images/");

        // load source images
        BufferedImage image = ImageIO.read(new File(path, "image.png"));
        BufferedImage overlay = ImageIO.read(new File(path, "overlay.png"));

// create the new image, canvas size is the max. of both image sizes
        int w = Math.max(image.getWidth(), overlay.getWidth());
        int h = Math.max(image.getHeight(), overlay.getHeight());

        return new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new Test());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}