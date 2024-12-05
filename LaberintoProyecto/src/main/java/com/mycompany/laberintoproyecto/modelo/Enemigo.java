/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laberintoproyecto.modelo;

import javax.swing.ImageIcon;

/**
 *
 * @author Andrey
 */
public class Enemigo extends Personaje {

    private int direccion;

    public Enemigo(int fila, int columna, int x, int y, ImageIcon imagen) {
        super(fila, columna, x, y, imagen);
        this.direccion = direccion;
    }

    public void mover() {

        if (direccion == 0) {
            if (fila > 4) {
                fila--;
            } else {
                direccion = 1;
            }
        } else if (direccion == 1) {
            if (fila < 13) {
                fila++;
            } else {
                direccion = 0;
            }
        }
    }
}
