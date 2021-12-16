package com.rob.view;

import com.rob.utilidades.Utils;
import com.rob.controller.JuegoController;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.Collections;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Roberto Esteban
 */
public class GUIJuego extends javax.swing.JFrame {

    public static final Integer MODO_1 = 1;
    public static final Integer MODO_2 = 2;
    public static final Integer MODO_3 = 3;

    private final Integer modoDeJuego;

    private final JuegoController juegoController;

    public GUIJuego(JuegoController juegoController, Integer modoDeJuego) {
        this.juegoController = juegoController;
        this.modoDeJuego = modoDeJuego;
        initComponents();
        setFrame();
    }

    private void setFrame() {
        //Configuro el color de los paneles
        this.getContentPane().setBackground(Utils.COLOR_FONDO_APP);
        this.panelPrincipal.setBackground(Utils.COLOR_FONDO_APP);
        //Configuro el resto de los componentes
        setPanelBotones();
        setPanelOperaciones();
        setPanelPuntuacion();
        setPanelNumeroMulti();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.pack();
    }

    private void setPanelBotones() {
        this.panelBotones.setLayout(new GridLayout(2, 0, 5, 5));
        this.panelBotones.setBackground(Utils.COLOR_FONDO_APP);
    }

    private void setPanelOperaciones() {
        this.panelOperaciones.setBackground(Utils.COLOR_PANEL_OPERACION);
        //Configuro los elementos del panel
        for (AbstractButton boton : Collections.list(this.grupoBotones.getElements())) {
            ((JButton) boton).setBorderPainted(false);
            ((JButton) boton).setFocusPainted(false);
            ((JButton) boton).setForeground(Utils.COLOR_TEXTO_BOTONES);
            ((JButton) boton).setContentAreaFilled(false);
            ((JButton) boton).setFont(Utils.FUENTE_BOTONES_OPERACION);
        }
    }

    private void setPanelPuntuacion() {
        this.panelPuntuacion.setBackground(Utils.COLOR_FONDO_APP);
        //Configuro los elementos del panel
        this.labelPuntuacion.setFont(new Font("Ebrina", Font.BOLD, 26));
        this.labelPuntuacion.setForeground(Color.BLACK);
        this.labelNumPuntuacion.setFont(new Font("Ebrina", Font.BOLD, 35));
        this.labelNumPuntuacion.setForeground(Color.BLACK);
    }

    private void setPanelNumeroMulti() {
        this.panelTotalMulti.setBackground(Utils.COLOR_FONDO_APP);
        //Configuro los elementos del panel
        this.labelMultiplicacionTotal.setText(String.valueOf(Utils.NUMERO_MULTIPLIACIONES));
        this.labelMultiplicacionTotal.setFont(new Font("Ebrina", Font.BOLD, 32));
        this.labelMultiplicacionTotal.setForeground(Color.BLACK);
        this.labelMultiplicacionActual.setText("0");
        this.labelMultiplicacionActual.setFont(new Font("Ebrina", Font.BOLD, 32));
        this.labelMultiplicacionActual.setForeground(Color.BLACK);
        this.labelBarra.setFont(new Font("Ebrina", Font.BOLD, 32));
        this.labelBarra.setForeground(Color.BLACK);
    }

    public void vibrarPantalla() {
        int distanciaX = 5; //Distancia a mover en horizontal
        int distanciaY = -10; //Distancia a mover en vertical
        Point posicionFrame = this.getLocationOnScreen(); //Posción actual del frame

        Point poscion1 = new Point(posicionFrame.x + distanciaX, posicionFrame.y + distanciaY);
        Point posicion2 = new Point(posicionFrame.x - distanciaX, posicionFrame.y - distanciaY);

        //Alterno la posicion del Frame para hacer que "vibre"
        for (int i = 0; i < 40; i++) {
            this.setLocation(poscion1);
            this.setLocation(posicion2);
        }
        //Restauro la posición del Frame
        this.setLocation(posicionFrame);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        panelOperaciones = new javax.swing.JPanel();
        botonNum1 = new javax.swing.JButton();
        botonPor = new javax.swing.JButton();
        botonNum2 = new javax.swing.JButton();
        botonIgual = new javax.swing.JButton();
        botonRespuesta = new javax.swing.JButton();
        panelPuntuacion = new javax.swing.JPanel();
        labelPuntuacion = new javax.swing.JLabel();
        labelNumPuntuacion = new javax.swing.JLabel();
        panelTotalMulti = new javax.swing.JPanel();
        labelMultiplicacionActual = new javax.swing.JLabel();
        labelBarra = new javax.swing.JLabel();
        labelMultiplicacionTotal = new javax.swing.JLabel();
        labelMasPuntuacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );

        panelOperaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panelOperaciones.setLayout(new java.awt.GridLayout(1, 0));

        botonNum1.setFont(new java.awt.Font("Ebrima", 1, 150)); // NOI18N
        botonNum1.setText("?");
        grupoBotones.add(botonNum1);
        panelOperaciones.add(botonNum1);

        botonPor.setFont(new java.awt.Font("Ebrima", 1, 150)); // NOI18N
        botonPor.setText("X");
        grupoBotones.add(botonPor);
        panelOperaciones.add(botonPor);

        botonNum2.setFont(new java.awt.Font("Ebrima", 1, 150)); // NOI18N
        botonNum2.setText("?");
        grupoBotones.add(botonNum2);
        panelOperaciones.add(botonNum2);

        botonIgual.setFont(new java.awt.Font("Ebrima", 1, 150)); // NOI18N
        botonIgual.setText("=");
        grupoBotones.add(botonIgual);
        panelOperaciones.add(botonIgual);

        botonRespuesta.setFont(new java.awt.Font("Ebrima", 1, 150)); // NOI18N
        botonRespuesta.setText("?");
        grupoBotones.add(botonRespuesta);
        panelOperaciones.add(botonRespuesta);

        labelPuntuacion.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        labelPuntuacion.setText("PUNTOS: ");

        labelNumPuntuacion.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        labelNumPuntuacion.setText("0");

        javax.swing.GroupLayout panelPuntuacionLayout = new javax.swing.GroupLayout(panelPuntuacion);
        panelPuntuacion.setLayout(panelPuntuacionLayout);
        panelPuntuacionLayout.setHorizontalGroup(
            panelPuntuacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPuntuacionLayout.createSequentialGroup()
                .addComponent(labelPuntuacion)
                .addGap(15, 15, 15)
                .addComponent(labelNumPuntuacion, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPuntuacionLayout.setVerticalGroup(
            panelPuntuacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(labelNumPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelTotalMulti.setLayout(new java.awt.GridLayout(1, 0, 25, 0));

        labelMultiplicacionActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMultiplicacionActual.setText("0");
        panelTotalMulti.add(labelMultiplicacionActual);

        labelBarra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBarra.setText("/");
        panelTotalMulti.add(labelBarra);

        labelMultiplicacionTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMultiplicacionTotal.setText("0");
        panelTotalMulti.add(labelMultiplicacionTotal);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelOperaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1075, Short.MAX_VALUE)
                    .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(panelPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelMasPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelTotalMulti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTotalMulti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPuntuacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMasPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(panelOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBotonNum1() {
        return botonNum1;
    }

    public Integer getNumeroBoton1() {
        return Integer.valueOf(botonNum1.getText());
    }

    public void setNumeroBoton1(Integer num) {
        botonNum1.setText(String.valueOf(num));
    }

    public JButton getBotonNum2() {
        return botonNum2;
    }

    public Integer getNumeroBoton2() {
        return Integer.valueOf(botonNum2.getText());
    }

    public void setNumeroBoton2(Integer num) {
        botonNum2.setText(String.valueOf(num));
    }

    public JButton getBotonRespuesta() {
        return botonRespuesta;
    }

    public Integer getNumeroBotonRespuesta() {
        return Integer.valueOf(botonRespuesta.getText());
    }

    public void setNumeroBotonRespuesta(Integer num) {
        botonRespuesta.setText(String.valueOf(num));
    }

    public JPanel getPanelBotones() {
        return panelBotones;
    }

    public JPanel getPanelOperaciones() {
        return panelOperaciones;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public JLabel getLabelNumPuntuacion() {
        return labelNumPuntuacion;
    }

    public void setLabelNumPuntuacion(String puntuacion) {
        this.labelNumPuntuacion.setText(puntuacion);
    }

    public JLabel getLabelMasPuntuacion() {
        return labelMasPuntuacion;
    }

    public void setLabelMasPuntuacion(String puntuacion) {
        this.labelMasPuntuacion.setText(puntuacion);
    }

    public Integer getModoDeJuego() {
        return modoDeJuego;
    }

    public Integer getLabelMultiplicacionActual() {
        return Integer.valueOf(labelMultiplicacionActual.getText());
    }

    public void setLabelNumeroMultipliacionActual(Integer num) {
        labelMultiplicacionActual.setText(String.valueOf(num));
    }

    public JuegoController getJuegoController() {
        return juegoController;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIgual;
    private javax.swing.JButton botonNum1;
    private javax.swing.JButton botonNum2;
    private javax.swing.JButton botonPor;
    private javax.swing.JButton botonRespuesta;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel labelBarra;
    private javax.swing.JLabel labelMasPuntuacion;
    private javax.swing.JLabel labelMultiplicacionActual;
    private javax.swing.JLabel labelMultiplicacionTotal;
    private javax.swing.JLabel labelNumPuntuacion;
    private javax.swing.JLabel labelPuntuacion;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelOperaciones;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelPuntuacion;
    private javax.swing.JPanel panelTotalMulti;
    // End of variables declaration//GEN-END:variables

}
