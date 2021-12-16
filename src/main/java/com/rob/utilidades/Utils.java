package com.rob.utilidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Roberto Esteban
 */
public class Utils {

	 /**
	 * MULTIPLICACIONES A RESOLVER
	 */
    public static Integer NUMERO_MULTIPLIACIONES = 5;
	
    /**
     * COLORES
     */
    public static final Color COLOR_FONDO_APP = new Color(0, 184, 193);
    public static final Color COLOR_BOTONES_OPCIONES = new Color(209, 178, 113);
    public static final Color COLOR_BOTONES_OPCIONES_HOVER = new Color(216, 191, 139);
    public static final Color COLOR_PANEL_OPERACION = new Color(255, 255, 255);
    public static final Color COLOR_RESPUESTA_CORRECTA = new Color(49, 204, 46);
    public static final Color COLOR_RESPUESTA_ERRONEA = new Color(255, 0, 24);
    public static final Color COLOR_TEXTO_BOTONES = new Color(0, 0, 0);
    public static final Color COLOR_TOOLTIP = new Color(254, 217, 15);

    /**
     * ICONOS
     */
    public static final String ICONO_CORAZON = "/iconos/corazon.png";
    public static final String ICONO_CORAZON_ROTO = "/iconos/corazon_roto.png";
    public static final String ICONO_INTERROGACION = "/iconos/interrogacion.png";
    public static final String ICONO_CONFIGURACION = "/iconos/engranaje.png";
    public static final String ICONO_GITHUB = "/iconos/github.png";
    public static final String ICONO_TITULO = "/iconos/titulo.jpeg";
    public static final String ICONO_SONIDO_ON = "/iconos/sonido_on.png";
    public static final String ICONO_SONIDO_OFF = "/iconos/sonido_off.png";

    /**
     * SONIDOS/MÚSICA
     */
    public static final String SONIDO_ERROR = "/sound/error.wav";
    public static final String SONIDO_CORRECTO = "/sound/correcto.wav";

    /**
     * FUENTES
     */
    public final InputStream inputStreamGagalin = getClass().getResourceAsStream(Utils.RUTA_FUENTE_GAGALIN);
    public final InputStream inputStreamPrueba = getClass().getResourceAsStream(Utils.RUTA_FUENTE_PRUEBA);
    public static final String RUTA_FUENTE_GAGALIN = "/fonts/Gagalin-Regular.ttf";
    public static final String RUTA_FUENTE_PRUEBA = "/fonts/Grandstander-Black.otf";
    public static final Font FUENTE_BOTONES_SOLUCIONES = new Font("Ebrima", Font.BOLD, 110);
    public static final Font FUENTE_BOTONES_OPERACION = new Font("Ebrima", Font.BOLD, 150);
    public static final Font FUENTE_BOTONES_MENU = new Font("Ebrima", Font.BOLD, 35);

    /**
     * Registra la fuente para ser usada por la app
     */
    public void registrarFuenteGagalin() {
        Utils utilidades = new Utils();
        try {
            //Registro la nueva fuente
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, utilidades.inputStreamGagalin));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

}
