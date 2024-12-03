
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
public class Main {
    public static void main(String[] args) throws Exception{
        File inputFile = new File("/Users/mateo/Univeristy/paralela/ImageHandleParallel/img/6.jpg");
        BufferedImage image = ImageIO.read(inputFile);
        int width = image.getWidth();
        int height = image.getHeight();
        long startTime = System.currentTimeMillis();

        for (int y = 0 ; y < height; y ++) {
            for (int x = 0 ; x < width/2; x++){
                int temp = image.getRGB(x,y);
                image.setRGB(x,y,image.getRGB(width - x - 1, y));
                image.setRGB(width - x - 1, y, temp);
            }
        }

        long endTime = System.nanoTime();
        File outputFile = new File("/Users/mateo/Univeristy/paralela/ImageHandleParallel/output/output_secuencial5.jpg");
        ImageIO.write(image, "jpg", outputFile);
        System.out.println("Proceso secuencial completado en " + (endTime - startTime) + " milisegundos");
    }
}