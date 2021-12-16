package com.rob.view;

import com.rob.utilidades.Utils;
import com.rob.controller.MenuController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

/**
 *
 * @author Roberto Esteban
 */
public class GUIMenu extends javax.swing.JFrame {

    private final MenuController menuController;

    public GUIMenu(MenuController menuController) {
        this.menuController = menuController;
        initComponents();
        setFrame();
    }

    private void setFrame() {
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Utils.COLOR_FONDO_APP);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.panelMenu.setBackground(Utils.COLOR_FONDO_APP);
        setPanelHeader();
        setPanelModoDeJuego();
        setPanelBotonesAyuda();
        setFooter();
    }

    private void setPanelHeader() {
    	//Configuro el fondo del panel
        this.panelHeader.setBackground(Utils.COLOR_FONDO_APP);
        this.panelTitulo.setBackground(Utils.COLOR_FONDO_APP);
        this.panelConfig.setBackground(Utils.COLOR_FONDO_APP);
        this.panelGitHub.setBackground(Utils.COLOR_FONDO_APP);
        //Configuro el boton de configuración
        this.botonConfiguracion.setText("");
        this.botonConfiguracion.setIcon(new ImageIcon(getClass().getResource(Utils.ICONO_CONFIGURACION)));
        this.botonConfiguracion.setBorderPainted(false);
        this.botonConfiguracion.setContentAreaFilled(false);
        this.botonConfiguracion.setFocusPainted(false);
        this.botonConfiguracion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.botonConfiguracion.addActionListener(menuController);
        //Configuro el boton de GitHub
        this.botonGitHub.setText("");
        this.botonGitHub.setIcon(new ImageIcon(getClass().getResource(Utils.ICONO_GITHUB)));
        this.botonGitHub.setBorderPainted(false);
        this.botonGitHub.setContentAreaFilled(false);
        this.botonGitHub.setFocusPainted(false);
        this.botonGitHub.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.botonGitHub.addActionListener(menuController);
        //Configuro el titulo
        this.labelTitulo.setText("");
        this.labelTitulo.setIcon(new ImageIcon(getClass().getResource(Utils.ICONO_TITULO)));
    }

    private void setPanelModoDeJuego() {
        this.panelModos.setBackground(Utils.COLOR_FONDO_APP);
        //Configuro los elementos del panel
        for (AbstractButton boton : Collections.list(grupoModosDeJuego.getElements())) {
            ((JButton) boton).setBackground(Utils.COLOR_BOTONES_OPCIONES_HOVER);
            ((JButton) boton).setFocusPainted(false);
            ((JButton) boton).setFont(Utils.FUENTE_BOTONES_MENU);
            ((JButton) boton).setForeground(Utils.COLOR_TEXTO_BOTONES);
            ((JButton) boton).addActionListener(menuController);
        }
    }

    private void setPanelBotonesAyuda() {
        this.panelAyudas.setBackground(Utils.COLOR_FONDO_APP);
        //Configuro los elementos del panel
        for (Component label : Arrays.asList(panelAyudas.getComponents())) {
            ((JLabel) label).setText("");
            ((JLabel) label).setIcon(new ImageIcon(getClass().getResource(Utils.ICONO_INTERROGACION)));
        }
        UIManager.put("ToolTip.background", Utils.COLOR_TOOLTIP);
        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.font", new Font("Ebrina", Font.BOLD, 18));
        labelAyuda1.setToolTipText("<html>" + "Adivinar el resultado de la multiplicación"
                + "<br><br> Ejemplo: 3 x 4 = ?" + "</html>");
        labelAyuda2.setToolTipText("<html>" + "Adivinar uno de los número de la multiplicación"
                + "<br><br> Ejemplo: 3 x ? = 12" + "</html>");
        labelAyuda3.setToolTipText("<html>" + "Adivinar los dos números de la multiplicación"
                + "<br><br> Ejemplo: ? x ? = 12" + "</html>");
    }

    private void setFooter() {
        this.labelFooter.setText("Aplicación desarrollada para fines educativos por Roberto Esteban Sinovas");
        this.labelFooter.setForeground(Color.BLACK);
        this.labelFooter.setFont(new Font("Ebrina", Font.BOLD, 12));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotonesAyuda = new javax.swing.ButtonGroup();
        grupoModosDeJuego = new javax.swing.ButtonGroup();
        panelMenu = new javax.swing.JPanel();
        panelAyudas = new javax.swing.JPanel();
        labelAyuda1 = new javax.swing.JLabel();
        labelAyuda2 = new javax.swing.JLabel();
        labelAyuda3 = new javax.swing.JLabel();
        panelModos = new javax.swing.JPanel();
        botonModo1 = new javax.swing.JButton();
        botonModo2 = new javax.swing.JButton();
        botonModo3 = new javax.swing.JButton();
        panelHeader = new javax.swing.JPanel();
        panelGitHub = new javax.swing.JPanel();
        botonGitHub = new javax.swing.JButton();
        panelConfig = new javax.swing.JPanel();
        botonConfiguracion = new javax.swing.JButton();
        panelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelFooter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setLayout(new java.awt.BorderLayout(20, 0));

        panelAyudas.setLayout(new java.awt.GridLayout(0, 1, 0, 25));

        labelAyuda1.setText("jLabel1");
        panelAyudas.add(labelAyuda1);

        labelAyuda2.setText("jLabel2");
        panelAyudas.add(labelAyuda2);

        labelAyuda3.setText("jLabel3");
        panelAyudas.add(labelAyuda3);

        panelMenu.add(panelAyudas, java.awt.BorderLayout.LINE_END);

        panelModos.setLayout(new java.awt.GridLayout(0, 1, 0, 25));

        botonModo1.setText("MODO 1");
        grupoModosDeJuego.add(botonModo1);
        panelModos.add(botonModo1);

        botonModo2.setText("MODO 2");
        grupoModosDeJuego.add(botonModo2);
        panelModos.add(botonModo2);

        botonModo3.setText("MODO 3");
        grupoModosDeJuego.add(botonModo3);
        panelModos.add(botonModo3);

        panelMenu.add(panelModos, java.awt.BorderLayout.CENTER);

        panelHeader.setLayout(new java.awt.BorderLayout(10, 0));

        botonGitHub.setText("jButton1");
        panelGitHub.add(botonGitHub);

        panelHeader.add(panelGitHub, java.awt.BorderLayout.LINE_START);

        botonConfiguracion.setText("jButton1");
        panelConfig.add(botonConfiguracion);

        panelHeader.add(panelConfig, java.awt.BorderLayout.LINE_END);

        panelTitulo.setLayout(new java.awt.BorderLayout());

        labelTitulo.setFont(new java.awt.Font("Ebrima", 1, 48)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("MULTIPLY");
        panelTitulo.add(labelTitulo, java.awt.BorderLayout.PAGE_END);

        panelHeader.add(panelTitulo, java.awt.BorderLayout.CENTER);

        labelFooter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFooter.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelHeader, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 182, Short.MAX_VALUE)
                        .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 133, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(labelFooter)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBotonModo1() {
        return botonModo1;
    }

    public JButton getBotonModo2() {
        return botonModo2;
    }

    public JButton getBotonModo3() {
        return botonModo3;
    }

    public JButton getBotonConfiguracion() {
        return botonConfiguracion;
    }

    public JButton getBotonGitHub() {
        return botonGitHub;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConfiguracion;
    private javax.swing.JButton botonGitHub;
    private javax.swing.JButton botonModo1;
    private javax.swing.JButton botonModo2;
    private javax.swing.JButton botonModo3;
    private javax.swing.ButtonGroup grupoBotonesAyuda;
    private javax.swing.ButtonGroup grupoModosDeJuego;
    private javax.swing.JLabel labelAyuda1;
    private javax.swing.JLabel labelAyuda2;
    private javax.swing.JLabel labelAyuda3;
    private javax.swing.JLabel labelFooter;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelAyudas;
    private javax.swing.JPanel panelConfig;
    private javax.swing.JPanel panelGitHub;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelModos;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables
}
