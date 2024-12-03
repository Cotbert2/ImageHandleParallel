import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ConcurrenteRowPerPixel {

    public static void main(String[] args) throws Exception{
        File inputFile = new File("/Users/mateo/Univeristy/paralela/ImageHandleParallel/img/6.jpg");
        BufferedImage image = ImageIO.read(inputFile);
        int width = image.getWidth();
        int height = image.getHeight();
        long startTime = System.currentTimeMillis();

        int numThread = 4;
        Thread[] threads = new Thread[numThread];

        int rowsPerThread = height / numThread;
        int endRow;

        for (int i = 0; i < numThread; i++) {
            int startRow = i * rowsPerThread;

            if(i == numThread - 1){
                endRow = height;
            }else{
                endRow = startRow + rowsPerThread;
            }

            threads[i] = new Thread(new Invert(image, startRow, endRow));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long endTime = System.nanoTime();
        File outputFile = new File("/Users/mateo/Univeristy/paralela/ImageHandleParallel/output/x3.jpg");
        ImageIO.write(image, "jpg", outputFile);
        System.out.println("Proceso secuencial completado en " + (endTime - startTime) + " milisegundos");
    }

}
