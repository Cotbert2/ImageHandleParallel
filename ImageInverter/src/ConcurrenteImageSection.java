import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
public class ConcurrenteImageSection {
    public static void main(String[] args) {

        try {
            File archivo = new File("/Users/mateo/Univeristy/paralela/ImageHandleParallel/output/x3.jpg");
            BufferedImage imagen = ImageIO.read(archivo);

            int altura = imagen.getHeight();
            int ancho = imagen.getWidth();

            int numeroHilos = 6;
            Thread[] hilos = new Thread[numeroHilos];

            int filasPorHilo = altura / numeroHilos;
            int finFila;

            long inicio = System.nanoTime();

            for (int i = 0; i < numeroHilos; i++) {
                int inicioFila = i * filasPorHilo;

                if (i == numeroHilos - 1) {
                    finFila = altura;
                } else {
                    finFila = inicioFila + filasPorHilo;
                }

                hilos[i] = new Thread(new FlipImage(imagen, inicioFila, finFila));
                hilos[i].start();
            }

            for (Thread hilo : hilos) {
                hilo.join();
            }

            File archivoSalida = new File("/Users/mateo/Univeristy/paralela/ImageHandleParallel/output/concurrente_section5.jpg");
            ImageIO.write(imagen, "jpg", archivoSalida);

            long fin = System.nanoTime();

            System.out.println("Imagen procesada y guardada como 'imagen_gris_conc.png'");
            System.out.println("Tiempo de ejecución: " + (fin - inicio)  + " ns");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
