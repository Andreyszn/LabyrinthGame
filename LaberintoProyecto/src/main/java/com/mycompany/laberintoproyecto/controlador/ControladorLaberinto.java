/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laberintoproyecto.controlador;

import com.mycompany.laberintoproyecto.modelo.AreaJuego;
import com.mycompany.laberintoproyecto.vista.GUIGanada;
import com.mycompany.laberintoproyecto.vista.GUILaberinto;
import com.mycompany.laberintoproyecto.vista.GUIPerdida;
import com.mycompany.laberintoproyecto.vista.PanelLaberinto;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Andrey
 */
public class ControladorLaberinto implements KeyListener {

    private GUILaberinto guiLaberinto;
    private PanelLaberinto panelLaberinto;
    private AreaJuego areaJuego;
    private GUIGanada guiGanada;
    private GUIPerdida guiPerdida;

    public ControladorLaberinto(GUILaberinto guiLaberinto) {
        this.guiLaberinto = guiLaberinto;
        this.areaJuego = new AreaJuego();
    }

    public void iniciar() {
        areaJuego.iniciar();
    }

    public void setPanelLaberinto(PanelLaberinto panelLaberinto) {
        this.panelLaberinto = panelLaberinto;
    }

    public void verificarColisionPremio() {
        areaJuego.comprobarPremio();
    }

    public boolean comprobarGano() {
        return areaJuego.comprobarGanada();
    }

    public boolean comprobarPerdida() {
        return areaJuego.comprobarPerdida();
    }

    public void setGuiGanar(GUIGanada guiGanada) {
        this.guiGanada = guiGanada;
    }

    public void mostrarGano() {
        guiGanada.setVisible(true);
    }

    public void setGuiPerder(GUIPerdida guiPerdida) {
        this.guiPerdida = guiPerdida;
    }

    public void mostrarPerdio() {
        guiPerdida.setVisible(true);
    }

    public void moverEnemigos() {
        areaJuego.moverEnemigo();
        panelLaberinto.repaint();
    }

    public void dibujar(Graphics g) {
        areaJuego.dibujar(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                areaJuego.caminar("arriba");
                break;
            case KeyEvent.VK_A:
                areaJuego.caminar("izquierda");
                break;
            case KeyEvent.VK_S:
                areaJuego.caminar("abajo");
                break;
            case KeyEvent.VK_D:
                areaJuego.caminar("derecha");
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
