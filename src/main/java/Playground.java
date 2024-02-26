import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;



public class Playground {
    public static void main(String[] args) {
        try {
            // Specify the path to the audio file
            File audioFile = new File("./media/rain.wav");

            // Get an audio input stream from the file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // Get a clip resource
            Clip clip = AudioSystem.getClip();

            // Open the audio stream in the clip
            clip.open(audioStream);

            // Start playing the audio
            clip.start();
            System.out.println("Playing audio");

            // Keep the program running till the audio is playing
            while (!clip.isRunning())
                Thread.sleep(10);
            while (clip.isRunning())
                Thread.sleep(10);

            // Close the clip once the playback is complete
            clip.close();
            System.out.println("Audio playback complete");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    

