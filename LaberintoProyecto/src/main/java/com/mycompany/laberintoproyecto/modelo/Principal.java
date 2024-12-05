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
public class Principal extends Personaje {

    private int vidas;
    private int premio;

    public Principal(int fila, int columna, int x, int y, ImageIcon imagen, int vidas, int premio) {
        super(fila, columna, x, y, imagen);
        this.vidas = vidas;
        this.premio = premio;
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
}
