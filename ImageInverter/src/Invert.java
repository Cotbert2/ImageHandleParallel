import java.awt.image.BufferedImage;
import java.nio.Buffer;


public class Invert implements Runnable{

    private final BufferedImage image;
    private final int startRow;
    private final int endRow;

    public Invert(BufferedImage image, int startRow, int endRow) {
        this.image = image;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public void run() {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0 ; y < height; y ++) {
            for (int x = 0 ; x < width/2; x++){
                int temp = image.getRGB(x,y);
                image.setRGB(x,y,image.getRGB(width - x - 1, y));
                image.setRGB(width - x - 1, y, temp);
            }
        }

    }
}
