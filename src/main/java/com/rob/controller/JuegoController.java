package com.rob.controller;

import com.rob.utilidades.Utils;
import com.rob.sound.Sonidos;
import com.rob.view.DialogPuntuacion;
import com.rob.view.GUIJuego;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Roberto Esteban
 */
public class JuegoController implements ActionListener {

    private final GUIJuego juegoGUI;
    private DialogPuntuacion puntuacionDialog;

    private final List<Integer> listaNumOpciones = new ArrayList<>();
    private final Random randomNum = new Random();

    private final Timer cronoSolucionCorrecta = new Timer(1000, this);
    private final Timer cronoSolucionErronea = new Timer(1000, this);
    private final Timer cronoPuntuacion = new Timer(15, this);

    private Integer num1;
    private Integer num2;
    private Integer resultado;
    private Integer numeroElejido;

    private Integer puntuacion = 0;
    private Integer sizeLetraPuntuacion = 12;
    private final Integer puntosASumar = 10;
    private final Integer puntosARestar = 5;

    private Integer multiplicacionActual = 1;

    private boolean timerActivado = false;
    private boolean acierto = false;

    private boolean numUnoElejido = false;

    public JuegoController(Integer modoDeJuego) {
        this.juegoGUI = new GUIJuego(this, modoDeJuego);
        this.juegoGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                juegoGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new MenuController().iniciarVentana();
            }
        });
        //Configuro el cronometro
        this.cronoSolucionCorrecta.setInitialDelay(0);
        this.cronoSolucionErronea.setInitialDelay(0);
        this.cronoPuntuacion.setInitialDelay(0);
        //Preparo el juego
        cargarNuevosNumeros();
        juegoGUI.setLabelNumPuntuacion(String.valueOf(puntuacion));
    }

    private void cargarNuevosNumeros() {
        borrarBotones();
        generarNumerosOperaciones();
        generarNumerosOpciones();
        generarBotones();
        this.juegoGUI.setLabelNumeroMultipliacionActual(multiplicacionActual);
    }

    private void borrarBotones() {
        this.juegoGUI.getPanelBotones().removeAll();
    }

    private void generarNumerosOperaciones() {
        //Genero los numeros de la multiplicación
        num1 = randomNum.nextInt(10) + 1;
        num2 = randomNum.nextInt(10) + 1;
        resultado = num1 * num2;

        if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_1) {
            juegoGUI.getBotonNum1().setText(String.valueOf(num1));
            juegoGUI.getBotonNum2().setText(String.valueOf(num2));
        } else if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_2) {
            juegoGUI.getBotonNum1().setText(String.valueOf(num1));
            juegoGUI.getBotonRespuesta().setText(String.valueOf(resultado));
        } else if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_3) {
            juegoGUI.getBotonRespuesta().setText(String.valueOf(resultado));
        }
    }

    private void generarNumerosOpciones() {
        listaNumOpciones.clear();
        if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_1) {
            listaNumOpciones.add(resultado);
            while (listaNumOpciones.size() != 10) {
                int numToAdd = randomNum.nextInt(100) + 1;
                while (listaNumOpciones.contains(numToAdd)) {
                    numToAdd = randomNum.nextInt(100) + 1;
                }
                listaNumOpciones.add(numToAdd);
            }
        } else if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_2 || juegoGUI.getModoDeJuego() == GUIJuego.MODO_3) {
            for (int i = 1; i <= 10; i++) {
                listaNumOpciones.add(i);
            }
        }

    }

    private void generarBotones() {
        Collections.shuffle(listaNumOpciones);
        for (Integer numBoton : listaNumOpciones) {
            juegoGUI.getPanelBotones().add(crearBotonSoluciones(numBoton));
        }
    }

    private JButton crearBotonSoluciones(Integer numBoton) {
        // <editor-fold defaultstate="collapsed" desc="Generacion de un boton para seleccionar">
        JButton botonToAdd = new JButton(String.valueOf(numBoton));
        botonToAdd.setFont(Utils.FUENTE_BOTONES_SOLUCIONES);
        botonToAdd.setBackground(Utils.COLOR_BOTONES_OPCIONES);
        botonToAdd.setForeground(Utils.COLOR_TEXTO_BOTONES);
        botonToAdd.setFocusPainted(false);
        botonToAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_1 && !timerActivado) {
                    numeroElejido = numBoton;
                    if (numBoton == resultado) {
                        acierto();
                    } else {
                        error();
                    }
                }
            }
        });
        botonToAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_2 && !timerActivado) {
                    numeroElejido = numBoton;
                    if (numBoton == num2) {
                        acierto();
                    } else {
                        error();
                    }
                }
            }
        });
        botonToAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_3 && !timerActivado) {
                    if (!numUnoElejido) {
                        juegoGUI.setNumeroBoton1(numBoton);
                        num1 = numBoton;
                        numUnoElejido = true;
                    } else {
                        juegoGUI.setNumeroBoton2(numBoton);
                        num2 = numBoton;
                        if (num1 * num2 == resultado) {
                            acierto();
                        } else {
                            error();
                        }
                        numUnoElejido = false;
                    }
                }
            }
        });
        botonToAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonToAdd.setBackground(Utils.COLOR_BOTONES_OPCIONES_HOVER);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonToAdd.setBackground(Utils.COLOR_BOTONES_OPCIONES);
            }
        });
        return botonToAdd;
    }// </editor-fold> 

    private void acierto() {
        acierto = true;
        cronoSolucionCorrecta.start();
        cronoPuntuacion.start();
    }

    private void error() {
        acierto = false;
        cronoSolucionErronea.start();
        cronoPuntuacion.start();
    }

    private void estiloSolucionCorrecta() {
        Sonidos.playSound(getClass().getResource(Utils.SONIDO_CORRECTO));
        if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_1) {
            this.juegoGUI.setNumeroBotonRespuesta(resultado);
            this.juegoGUI.getBotonRespuesta().setForeground(Utils.COLOR_RESPUESTA_CORRECTA);
        } else if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_2) {
            this.juegoGUI.setNumeroBoton2(num2);
            this.juegoGUI.getBotonNum2().setForeground(Utils.COLOR_RESPUESTA_CORRECTA);
        } else if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_3) {
            //Numero 1
            this.juegoGUI.setNumeroBoton1(num1);
            this.juegoGUI.getBotonNum1().setForeground(Utils.COLOR_RESPUESTA_CORRECTA);
            //Numero 2
            this.juegoGUI.setNumeroBoton2(num2);
            this.juegoGUI.getBotonNum2().setForeground(Utils.COLOR_RESPUESTA_CORRECTA);
        }
    }

    private void estiloSolucionErronea() {
        Sonidos.playSound(getClass().getResource(Utils.SONIDO_ERROR));
        juegoGUI.vibrarPantalla();
        if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_1) {
            this.juegoGUI.setNumeroBotonRespuesta(numeroElejido);
            this.juegoGUI.getBotonRespuesta().setForeground(Utils.COLOR_RESPUESTA_ERRONEA);
        } else if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_2) {
            this.juegoGUI.setNumeroBoton2(numeroElejido);
            this.juegoGUI.getBotonNum2().setForeground(Utils.COLOR_RESPUESTA_ERRONEA);
        } else if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_3) {
            //Numero 1
            this.juegoGUI.setNumeroBoton1(num1);
            this.juegoGUI.getBotonNum1().setForeground(Utils.COLOR_RESPUESTA_ERRONEA);
            //Numero 2
            this.juegoGUI.setNumeroBoton2(num2);
            this.juegoGUI.getBotonNum2().setForeground(Utils.COLOR_RESPUESTA_ERRONEA);
        }
    }

    private void solucionReiniciar() {
        if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_1) {
            this.juegoGUI.getBotonRespuesta().setText("?");
            this.juegoGUI.getBotonRespuesta().setForeground(Utils.COLOR_TEXTO_BOTONES);
        } else if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_2) {
            this.juegoGUI.getBotonNum2().setText("?");
            this.juegoGUI.getBotonNum2().setForeground(Utils.COLOR_TEXTO_BOTONES);
        } else if (juegoGUI.getModoDeJuego() == GUIJuego.MODO_3) {
            //Numero 1
            this.juegoGUI.getBotonNum1().setText("?");
            this.juegoGUI.getBotonNum1().setForeground(Utils.COLOR_TEXTO_BOTONES);
            //Numero 2
            this.juegoGUI.getBotonNum2().setText("?");
            this.juegoGUI.getBotonNum2().setForeground(Utils.COLOR_TEXTO_BOTONES);
        }
    }

    private void sumarPuntos() {
        puntuacion += puntosASumar;
        juegoGUI.setLabelNumPuntuacion(String.valueOf(puntuacion));
    }

    private void restarPuntos() {
        if (puntuacion != 0) {
            puntuacion -= puntosARestar;
            juegoGUI.setLabelNumPuntuacion(String.valueOf(puntuacion));
        }
    }

    private void finalDelJuego() {
        String textoPuntuacion;
        int maxPuntos = Utils.NUMERO_MULTIPLIACIONES * 10;
        double puntuacionFinal = (double) maxPuntos / puntuacion;
        puntuacionFinal = Math.round(puntuacionFinal * 100.0) / 100.0;
        System.out.println(puntuacionFinal);
        if (puntuacionFinal == 1) { //Maxima puntacion
            textoPuntuacion = "¡Enhorabuena! Has obtenido la máxima puntuacion";
        } else if (puntuacionFinal > 1 && puntuacionFinal <= 1.33) { //Muy buena puntuacion (de 9 a 7)
            textoPuntuacion = "¡Genial! Muy bien";
        } else if (puntuacionFinal > 1.33 && puntuacionFinal <= 2) { // Buena puntuacion (de un 7 a un 5)
            textoPuntuacion = "¡Bien! Sigue así";
        } else if (puntuacionFinal > 2 && puntuacionFinal <= 4) { //Baja (de un 5 a un 3)
            textoPuntuacion = "¡Vas por el buen camino!";
        } else { //Muy mala (de 3 para abajo)
            textoPuntuacion = "Intentalo de nuevo";
        }
        puntuacionDialog = new DialogPuntuacion(juegoGUI, true, puntuacion);
        puntuacionDialog.setLabelTextoPuntuacion(textoPuntuacion);
        puntuacionDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cronoSolucionCorrecta) {
            if (!timerActivado) {
                estiloSolucionCorrecta();
                timerActivado = true;
            } else {
                cronoSolucionCorrecta.stop();
                timerActivado = false;
                multiplicacionActual++;
                if (multiplicacionActual > Utils.NUMERO_MULTIPLIACIONES) {
                    sumarPuntos();
                    finalDelJuego();
                } else {
                    solucionReiniciar();
                    sumarPuntos();
                    cargarNuevosNumeros();
                }
            }
        } else if (e.getSource() == this.cronoSolucionErronea) {
            if (!timerActivado) {
                estiloSolucionErronea();
                timerActivado = true;
            } else {
                solucionReiniciar();
                restarPuntos();
                cronoSolucionErronea.stop();
                timerActivado = false;
            }
        } else if (e.getSource() == this.cronoPuntuacion) {
            int sizeLetra = juegoGUI.getLabelMasPuntuacion().getFont().getSize();
            if (timerActivado) {
                if (sizeLetra <= 45) {
                    if (acierto) {
                        juegoGUI.setLabelMasPuntuacion("+" + String.valueOf(puntosASumar));
                        juegoGUI.getLabelMasPuntuacion().setFont(new Font("Ebrina", Font.BOLD, sizeLetraPuntuacion++));
                    } else {
                        if (puntuacion != 0) {
                            juegoGUI.setLabelMasPuntuacion("-" + String.valueOf(puntosARestar));
                            juegoGUI.getLabelMasPuntuacion().setFont(new Font("Ebrina", Font.BOLD, sizeLetraPuntuacion++));
                        }
                    }
                }
            } else {
                juegoGUI.setLabelMasPuntuacion("");
                sizeLetraPuntuacion = 12;
                juegoGUI.getLabelMasPuntuacion().setFont(new Font("Ebrina", Font.BOLD, sizeLetraPuntuacion));
                cronoPuntuacion.stop();
            }
        } else if (e.getSource() == this.puntuacionDialog.getBotonMenu()) {
            new MenuController().iniciarVentana();
            this.puntuacionDialog.dispose();
            this.juegoGUI.dispose();
        } else if (e.getSource() == this.puntuacionDialog.getBotonVolverJugar()) {
            new JuegoController(juegoGUI.getModoDeJuego()).iniciarVentana();
            this.puntuacionDialog.dispose();
            this.juegoGUI.dispose();
        }
    }

    public void iniciarVentana() {
        this.juegoGUI.setVisible(true);
    }
}
