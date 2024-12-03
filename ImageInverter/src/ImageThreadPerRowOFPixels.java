import java.awt.image.BufferedImage;

public class ImageThreadPerRowOFPixels extends Thread{
    private int width;
    private BufferedImage image;
    private int y;

    public ImageThreadPerRowOFPixels(int width, BufferedImage image, int y) {
        super(y + "");
        this.width = width;
        this.image = image;
        this.y = y;
    }



    public void run(){
        for (int x = 0 ; x < width/2; x++){
            int temp = image.getRGB(x,y);
            image.setRGB(x,y,image.getRGB(width - x - 1, y));
            image.setRGB(width - x - 1, y, temp);
        }
    }
}
