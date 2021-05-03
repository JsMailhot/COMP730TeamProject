import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
		Clip clip;
		
		public void setFile(String soundFileName) {
			try {
				File file = new File(soundFileName);
				AudioInputStream sound = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(sound);
			}
			catch(Exception e) {
				
			}
		}
		public void loop() {
			clip.loop(clip.LOOP_CONTINUOUSLY);
		}
		public void stop() {
			if(clip != null)
			{
				clip.stop();
				clip.close();
			}
		}
	    public void play() {
			if(clip != null)
			{
		    	clip.setFramePosition(0);
		    	clip.start();
			}
	    }
	}	
