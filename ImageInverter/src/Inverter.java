import java.awt.image.BufferedImage;

public class Inverter implements Runnable{
    private final BufferedImage imagen;
    private final int inicioFila;
    private final int finFila;

    public Inverter(BufferedImage imagen, int inicioFila, int finFila) {
        this.imagen = imagen;
        this.inicioFila = inicioFila;
        this.finFila = finFila;
    }

    @Override
    public void run() {

        for (int y = inicioFila; y < finFila; y++) {
            for (int x = 0; x < imagen.getWidth()/2; x++) {
                int temp = imagen.getRGB(x, y);
                imagen.setRGB(x, y, imagen.getRGB(imagen.getWidth() - x - 1, y));
                imagen.setRGB(imagen.getWidth() - x - 1, y, temp);
            }
        }
    }

}