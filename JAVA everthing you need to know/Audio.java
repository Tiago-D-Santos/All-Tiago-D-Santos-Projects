/* import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;
public class Audio {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException,LineUnavailableException{
        Scanner scanner = new Scanner(System.in);
        File file = new File("Audio.wav");//must be an wav file
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        String reponse = scanner.next();//this is that it plays until this line finishes
    }
}
 */