import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Concurrente {

    public static void main(String[] args) throws Exception{
        File inputFile = new File("/Users/mateo/Univeristy/paralela/ImageHandleParallel/img/6.jpg");
        BufferedImage image = ImageIO.read(inputFile);
        int width = image.getWidth();
        int height = image.getHeight();
        long startTime = System.currentTimeMillis();

        for (int y = 0 ; y < height; y ++) {
            new ImageThread(width, image, y).start();
        }

        long endTime = System.nanoTime();
        File outputFile = new File("/Users/mateo/Univeristy/paralela/ImageHandleParallel/output/output_concurrente5.jpg");
        ImageIO.write(image, "jpg", outputFile);
        System.out.println("Proceso secuencial completado en " + (endTime - startTime) + " milisegundos");
    }

}
