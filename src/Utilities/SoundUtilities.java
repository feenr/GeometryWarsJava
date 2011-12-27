
package Utilities;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.JApplet;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundUtilities extends JApplet{
    public void init(){
        AudioClip testClip = getAudioClip(getCodeBase(), "");
        testClip.loop();
    }
    
    public static void playSound(String fileName){
        try{
            //AudioClip clip = Applet.newAudioClip(getClass().getResource(fileName));
            //InputStream in = new FileInputStream(fileName);
            
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            InputStream resourceAsStream = cl.getResourceAsStream(fileName);
            AudioStream as = new AudioStream(resourceAsStream);
            AudioPlayer.player.start(as);
            
        } catch (Exception e){
            System.out.println("Sound Error: "+fileName);
            e.printStackTrace();
        }
    }
    public static void loopSound(String fileName){
        try{
            //AudioClip clip = Applet.newAudioClip(getClass().getResource(fileName));
            //InputStream in = new FileInputStream(fileName);
            //System.out.println("1");
            //AudioStream as = new AudioStream(in);
            //System.out.println("2");
            //AudioPlayer.player.start(as);
            //System.out.println("3");
            //clip.loop();
        } catch (Exception e){
            System.out.println("Sound Error");
            e.printStackTrace();
        }
    }
}
