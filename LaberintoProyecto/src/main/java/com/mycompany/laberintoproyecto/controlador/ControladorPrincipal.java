/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laberintoproyecto.controlador;

import com.mycompany.laberintoproyecto.vista.GUIGanada;
import com.mycompany.laberintoproyecto.vista.GUIHistoria;
import com.mycompany.laberintoproyecto.vista.GUIInstrucciones;
import com.mycompany.laberintoproyecto.vista.GUILaberinto;
import com.mycompany.laberintoproyecto.vista.GUIPerdida;
import com.mycompany.laberintoproyecto.vista.GUIPrincipal;
import com.mycompany.laberintoproyecto.vista.PanelLaberinto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andrey
 */
public class ControladorPrincipal implements ActionListener {

    private GUIPrincipal guiPrincipal;
    private GUIInstrucciones guiInstrucciones;
    private GUIHistoria guiHistoria;
    private GUILaberinto guiLaberinto;
    private ControladorLaberinto controladorLaberinto;
    private PanelLaberinto panelLaberinto;
    private ControladorHilo controladorHilo;
    private GUIGanada guiGanada;
    private GUIPerdida guiPerdida;

    public ControladorPrincipal() {
        guiPrincipal = new GUIPrincipal(this);
        guiInstrucciones = new GUIInstrucciones();
        guiHistoria = new GUIHistoria();
        guiLaberinto = new GUILaberinto();
        guiGanada = new GUIGanada();
        guiPerdida = new GUIPerdida();
        controladorLaberinto = new ControladorLaberinto(guiLaberinto);
        controladorHilo = new ControladorHilo(controladorLaberinto);
        panelLaberinto = new PanelLaberinto();

        controladorLaberinto.setGuiGanar(guiGanada);
        controladorLaberinto.setGuiPerder(guiPerdida);

        guiPrincipal.escuchar(this);
        guiInstrucciones.escuchar(this);
        guiHistoria.escuchar(this);
        guiLaberinto.escuchar(this);
        guiGanada.escuchar(this);
        guiPerdida.escuchar(this);
        guiLaberinto.escucharTeclado(controladorLaberinto);

        panelLaberinto = guiLaberinto.getPanelLaberinto();
        controladorLaberinto.setPanelLaberinto(panelLaberinto);
        panelLaberinto.setControlador(controladorLaberinto);

        guiPrincipal.setLocation(425, 130);
        guiHistoria.setLocationRelativeTo(guiPrincipal);
        guiInstrucciones.setLocationRelativeTo(guiPrincipal);
        guiLaberinto.setLocationRelativeTo(guiPrincipal);
        guiGanada.setLocationRelativeTo(guiPrincipal);
        guiPerdida.setLocationRelativeTo(guiPrincipal);

        guiLaberinto.setFocusable(true);
        guiLaberinto.requestFocusInWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "play":
                guiPrincipal.setVisible(false);
                guiLaberinto.setVisible(true);
                guiGanada.setVisible(false);
                guiPerdida.setVisible(false);
                controladorLaberinto.iniciar();
                guiLaberinto.requestFocusInWindow();
                if (!controladorHilo.isAlive()) {
                    controladorHilo.start();
                } else {
                    controladorHilo.activar();
                }
                break;

            case "leaveplay":
                guiLaberinto.setVisible(false);
                guiPrincipal.setVisible(true);
                break;
            case "guide":
                guiPrincipal.setVisible(false);
                guiInstrucciones.setVisible(true);
                break;
            case "leaveguide":
                guiInstrucciones.setVisible(false);
                guiPrincipal.setVisible(true);
                break;
            case "history":
                guiPrincipal.setVisible(false);
                guiHistoria.setVisible(true);
                break;
            case "leavehistory":
                guiHistoria.setVisible(false);
                guiPrincipal.setVisible(true);
                break;
            case "leave":
                System.exit(0);
                break;
        }
    }
}
