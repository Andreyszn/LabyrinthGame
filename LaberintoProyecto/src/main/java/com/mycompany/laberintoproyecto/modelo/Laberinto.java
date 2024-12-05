/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laberintoproyecto.modelo;

/**
 *
 * @author Andrey
 */
public class Laberinto {

    private int[][] laberinto;
    private Personaje personaje;
    private Enemigo enemigo;

    public Laberinto() {

        laberinto = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 0, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 2, 2, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 0, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 2, 2, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 2, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 2, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 2, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 2, 2, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 2, 2, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 1, 2, 2, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 2, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 4, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0}
        };
    }

    public int[][] getlaberinto() {
        return laberinto;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }
    
    public int getCelda (int fila, int columna) {
        return laberinto [fila] [columna];
    }

}
