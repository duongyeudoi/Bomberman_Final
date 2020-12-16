package audio;

import sun.audio.AudioStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class PlayMusic {
    Clip clip;
    public void playMusic(String path) {
        try {
            File musicPath = new File(path);
            if (musicPath.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                //  JOptionPane.showMessageDialog(null,"Press OK");


            } else {
                System.out.println("Can't play music");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void stop() {
        clip.stop();
    }
}
