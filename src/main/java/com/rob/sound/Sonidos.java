package com.rob.sound;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Roberto Esteban
 */
public class Sonidos {

    public static boolean SOUND = true;

    public static void playSound(URL urlSonido) {
        if (SOUND) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(urlSonido);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                Logger.getLogger(Sonidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
