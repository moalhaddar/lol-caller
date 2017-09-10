
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class AudioTes {
	public static void clickSound(String a) throws LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException {
		/*String k=a;
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		clip.drain();
		clip=null;
		audioInputStream=null;*/
		
		URL url = AudioTes.class.getResource(a);
		Clip clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(url));
		clip.start();
		
	}
}
