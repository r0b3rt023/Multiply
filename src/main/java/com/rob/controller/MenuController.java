package com.rob.controller;

import com.rob.sound.Sonidos;
import com.rob.utilidades.Utils;
import com.rob.view.DialogConfiguracion;
import com.rob.view.DialogGitHub;
import com.rob.view.GUIJuego;
import com.rob.view.GUIMenu;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Roberto Esteban
 */
public class MenuController implements ActionListener, ChangeListener, ItemListener {

    private final GUIMenu menuGUI;
    
    private DialogGitHub gitHubDialog;
    private DialogConfiguracion configDialog;

    public MenuController() {
        this.menuGUI = new GUIMenu(this);
    }
    
    public void iniciarVentana() {
        this.menuGUI.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuGUI.getBotonModo1()) {
            new JuegoController(GUIJuego.MODO_1).iniciarVentana();
            this.menuGUI.dispose();
        } else if(e.getSource() == menuGUI.getBotonModo2()) {
            new JuegoController(GUIJuego.MODO_2).iniciarVentana();
            this.menuGUI.dispose();
        } else if(e.getSource() == menuGUI.getBotonModo3()) {
            new JuegoController(GUIJuego.MODO_3).iniciarVentana();
            this.menuGUI.dispose();
        } else if(e.getSource() == menuGUI.getBotonConfiguracion()) {
            configDialog = new DialogConfiguracion(menuGUI, true);
            configDialog.setVisible(true);
        } else if(e.getSource() == menuGUI.getBotonGitHub()) {
            gitHubDialog = new DialogGitHub(menuGUI, true);
            gitHubDialog.setVisible(true);
        } else if(e.getSource() == gitHubDialog.getBotonCopiar()) {
            Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipBoard.setContents(new StringSelection(this.gitHubDialog.getTextoCajaRepo()), null);
            gitHubDialog.setTextoLabelCopiado("Enlace copiado al portapapeles");
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == this.configDialog.getSliderNumMult()) {
            Utils.NUMERO_MULTIPLIACIONES = this.configDialog.getSliderNumMult().getValue();
            this.configDialog.setNumMultiplicaciones(Utils.NUMERO_MULTIPLIACIONES);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == configDialog.getBotonSonido()) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                configDialog.getBotonSonido().setIcon(new ImageIcon(getClass().getResource(Utils.ICONO_SONIDO_ON)));
                Sonidos.SOUND = true;
            } else {
                configDialog.getBotonSonido().setIcon(new ImageIcon(getClass().getResource(Utils.ICONO_SONIDO_OFF)));
                Sonidos.SOUND = false;
            }
        }
    }

}
