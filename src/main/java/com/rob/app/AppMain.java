package com.rob.app;

import com.rob.controller.MenuController;
import com.rob.utilidades.Utils;

/**
 *
 * @author Roberto Esteban
 */
public class AppMain {

    public static void main(String[] args) {
    	//Registro la fuente Gagalin e inicio el juego
        Utils utilidades = new Utils();
        utilidades.registrarFuenteGagalin();
        new MenuController().iniciarVentana();

    }

}
