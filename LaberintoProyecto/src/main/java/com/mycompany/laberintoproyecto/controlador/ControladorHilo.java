/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laberintoproyecto.controlador;

/**
 *
 * @author Andrey
 */
public class ControladorHilo extends Thread {

    private ControladorLaberinto controladorLaberinto;
    private boolean estado;

    public ControladorHilo(ControladorLaberinto controladorLaberinto) {
        this.controladorLaberinto = controladorLaberinto;
        estado = true;
    }

    public void activar() {
        estado = true;
    }

    public void run() {
        while (true) {
            try {
                if (estado) {
                    controladorLaberinto.moverEnemigos();
                    controladorLaberinto.verificarColisionPremio();

                    if (controladorLaberinto.comprobarGano()) {
                        estado = false;
                        controladorLaberinto.mostrarGano();
                    } else {
                        if (controladorLaberinto.comprobarPerdida()) {
                            estado = false;
                            controladorLaberinto.mostrarPerdio();
                        }
                    }
                }

                sleep(150);

            } catch (InterruptedException ex) {
                System.out.println("" + ex);
            }
        }
    }
}
