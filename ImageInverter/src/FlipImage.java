/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.image.BufferedImage;

/**
 *
 * @author andrespillajo
 */
public class FlipImage implements Runnable{
    private final BufferedImage imagen;
    private final int inicioFila;
    private final int finFila;

    public FlipImage(BufferedImage imagen, int inicioFila, int finFila) {
        this.imagen = imagen;
        this.inicioFila = inicioFila;
        this.finFila = finFila;
    }

    @Override
    public void run() {
//        for (int y = inicioFila; y < finFila; y++) {
//            for (int x = 0; x < imagen.getWidth(); x++) {
//                int pixel = imagen.getRGB(x, y);
//
//                // Operaciones de bits para obtener componentes de color.
//                int rojo = (pixel >> 16) & 0xff; // Desplazar 16 bits y obtener los últimos 8 bits.
//                int verde = (pixel >> 8) & 0xff; // Desplazar 8 bits y obtener los últimos 8 bits.
//                int azul = pixel & 0xff;        // Obtiene los últimos 8 bits.
//
//                // Calcular promedio para escala de grises
//                int gris = (rojo + verde + azul) / 3;
//
//                // Nuevo color en escala de grises
//                int nuevoPixel = (gris << 16) | (gris << 8) | gris;
//
//                imagen.setRGB(x, y, nuevoPixel);
//            }
//        }


        /*
        *         for (int y = 0 ; y < height; y ++) {
            for (int x = 0 ; x < width/2; x++){
                int temp = image.getRGB(x,y);
                image.setRGB(x,y,image.getRGB(width - x - 1, y));
                image.setRGB(width - x - 1, y, temp);
            }
        }
        * */

        for (int y = inicioFila; y < finFila; y ++) {
            for (int x = 0 ; x < imagen.getWidth()/2; x++){
                int temp = imagen.getRGB(x,y);
                imagen.setRGB(x,y,imagen.getRGB(imagen.getWidth() - x - 1, y));
                imagen.setRGB(imagen.getWidth() - x - 1, y, temp);
            }
        }
    }

}
