/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laberintoproyecto.modelo;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Andrey
 */
public class AreaJuego {

    private Laberinto laberinto;
    private Principal personaje;
    private Enemigo enemigo;
    private Enemigo enemigo2;
    private Enemigo enemigo3;
    private Enemigo enemigo4;
    private ArrayList<Personaje> premios;
    private int coordenadasX[] = {0, 36, 72, 108, 144, 180, 216, 252, 288, 324, 360, 396, 432, 468, 504, 542, 578, 614, 650, 686, 722, 758, 794, 830, 866, 902};
    private int coordenadasY[] = {0, 36, 72, 108, 144, 180, 216, 252, 288, 324, 360, 396, 432, 468, 504};

    public AreaJuego() {
        laberinto = new Laberinto();
        premios = new ArrayList<>();
    }

    public void iniciar() {
        personaje = new Principal(1, 1, 5, 35, new ImageIcon("./src/main/resources/img/Personaje.gif"), 3, 1);
        premios.add(new Personaje(1, 8, 295, 35, new ImageIcon("./src/main/resources/img/Premio.png")));
        premios.add(new Personaje(1, 21, 758, 35, new ImageIcon("./src/main/resources/img/Premio.png")));
        premios.add(new Personaje(6, 8, 293, 215, new ImageIcon("./src/main/resources/img/Premio.png")));
        enemigo = new Enemigo(4, 5, 35, 135, new ImageIcon("./src/main/resources/img/Enemigo.gif"));
        enemigo2 = new Enemigo(4, 13, 25, 125, new ImageIcon("./src/main/resources/img/Enemigo.gif"));
        enemigo3 = new Enemigo(4, 17, 250, 240, new ImageIcon("./src/main/resources/img/Enemigo.gif"));
        enemigo4 = new Enemigo(4, 22, 15, 95, new ImageIcon("./src/main/resources/img/Enemigo.gif"));

    }

    public void dibujar(Graphics g) {
        personaje.dibujar(g);
        enemigo.dibujar(g);
        enemigo2.dibujar(g);
        enemigo3.dibujar(g);
        enemigo4.dibujar(g);

        for (int elemento = 0; elemento < premios.size(); elemento++) {
            premios.get(elemento).dibujar(g);
        }
    }

    public void moverEnemigo() {
        enemigo.mover();
        if ((isValido(enemigo.getFila(), enemigo.getColumna())) && (laberinto.getCelda(enemigo.getFila(), enemigo.getColumna()) == 1)) {
            enemigo.setX(coordenadasX[enemigo.getColumna()]);
            enemigo.setY(coordenadasY[enemigo.getFila()]);
        }

        enemigo2.mover();
        if ((isValido(enemigo2.getFila(), enemigo2.getColumna())) && (laberinto.getCelda(enemigo2.getFila(), enemigo2.getColumna()) == 1 || laberinto.getCelda(enemigo2.getFila(), enemigo2.getColumna()) == 0)) {
            enemigo2.setX(coordenadasX[enemigo2.getColumna()]);
            enemigo2.setY(coordenadasY[enemigo2.getFila()]);
        }

        enemigo3.mover();
        if ((isValido(enemigo3.getFila(), enemigo3.getColumna())) && (laberinto.getCelda(enemigo3.getFila(), enemigo3.getColumna()) == 1)) {
            enemigo3.setX(coordenadasX[enemigo3.getColumna()]);
            enemigo3.setY(coordenadasY[enemigo3.getFila()]);
        }

        enemigo4.mover();
        if ((isValido(enemigo4.getFila(), enemigo4.getColumna())) && (laberinto.getCelda(enemigo4.getFila(), enemigo4.getColumna()) == 1 || laberinto.getCelda(enemigo4.getFila(), enemigo4.getColumna()) == 0)) {
            enemigo4.setX(coordenadasX[enemigo4.getColumna()]);
            enemigo4.setY(coordenadasY[enemigo4.getFila()]);
        }
    }

    public void caminar(String direccion) {
        int filaDestino = personaje.getFila();
        int columnaDestino = personaje.getColumna();

        switch (direccion) {
            case "arriba":
                filaDestino--;
                break;
            case "abajo":
                filaDestino++;
                break;
            case "derecha":
                columnaDestino++;
                break;
            case "izquierda":
                columnaDestino--;
                break;
        }
        if ((isValido(filaDestino, columnaDestino)) && (laberinto.getCelda(filaDestino, columnaDestino) == 1 || laberinto.getCelda(filaDestino, columnaDestino) == 2) || laberinto.getCelda(filaDestino, columnaDestino) == 3) {
            isColision(enemigo, enemigo2, enemigo3, enemigo4);
            isFuego(filaDestino, columnaDestino);
            comprobarGanada();
            comprobarPerdida();
            comprobarPremio();
            personaje.setFila(filaDestino);
            personaje.setColumna(columnaDestino);
            personaje.setX(coordenadasX[columnaDestino]);
            personaje.setY(coordenadasY[filaDestino]);
        }
    }

    public boolean isValido(int filaDestino, int columnaDestino) {
        if ((filaDestino >= 0) && (filaDestino < 15) && columnaDestino >= 0 && columnaDestino < 26) {
            return true;
        }
        return false;
    }

    public boolean isFuego(int filaDestino, int columnaDestino) {
        if (laberinto.getCelda(filaDestino, columnaDestino) == 2) {
            disminuirVidas();
            return true;
        }
        return false;
    }

    public boolean isColision(Enemigo enemigo, Enemigo enemigo2, Enemigo enemigo3, Enemigo enemigo4) {
        if ((personaje.getFila() == enemigo.getFila() && personaje.getColumna() == enemigo.getColumna()) || (personaje.getFila() == enemigo2.getFila() && personaje.getColumna() == enemigo2.getColumna()) || (personaje.getFila() == enemigo3.getFila() && personaje.getColumna() == enemigo3.getColumna()) || (personaje.getFila() == enemigo4.getFila() && personaje.getColumna() == enemigo4.getColumna())) {
            disminuirVidas();
            return true;
        }
        return false;
    }

    public void disminuirVidas() {
        int vidas = personaje.getVidas();
        if (vidas > 0) {
            vidas--;
            personaje.setVidas(vidas);
        }
    }

    public boolean comprobarPremio() {
        int premioSumado = personaje.getPremio();
        for (int elemento = 0; elemento < premios.size(); elemento++) {
            Personaje premio = premios.get(elemento);
            if (premio.getFila() == personaje.getFila() && premio.getColumna() == personaje.getColumna()) {
                premios.remove(elemento);
                premioSumado++;
                personaje.setPremio(premioSumado);
                return true;
            }
        }
        return false;
    }

    public boolean comprobarGanada() {
        if (laberinto.getCelda(personaje.getFila(), personaje.getColumna()) == 3) {
            if (premios.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean comprobarPerdida() {
        if (personaje.getVidas() == 0) {
            return true;
        }
        return false;
    }

}
