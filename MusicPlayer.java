
/**
 * This music player can take in a file from an object. Extract the file name (source of the file), and find the file. 
 * The player hold all the necessary methods for play, pause and so on.
 * 
 * 
 * @author fjoneus
 *
 */

import java.util.*;
import java.io.*;
import javax.sound.sampled.*;

public class MusicPlayer {

	private AudioInputStream songFile;
	private Clip song;
	private long currentPos;
	private File file;
	
	/**
	 * Constructor -> Extracts the songName from the Item object and creates the AudioInputStream
	 */
	public MusicPlayer(String x) {
		
		try {
			//File file = new File(x.getSongFile());   //Create the File object that holds the path to the file
			file = new File(x);
			songFile = AudioSystem.getAudioInputStream(file.getAbsoluteFile()); //Set the "private songFile" so it can be used later in the program. AudioSystem returns a AudioInputStream object
			}
			catch(Exception e) {
				System.out.println(e);
			}
	}
	
	/**
	 * Creates a Clip object true AudioSystem, uses the open and start method from Clip to play the songFile. 
	 * If the song has been on pause the song will start playing from currentPosition 
	 * @exception Catches all the exceptions and prints them
	 */
	public void play() {
		try {
			
			if(currentPos > 0) {
				
				song.setMicrosecondPosition(currentPos);
				song.start();

			}
			else {
				song = AudioSystem.getClip();
				song.open(songFile);
				song.start();
			}
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Saves the current position and stops the Clip.
	 */
	public void pause(){
		currentPos = song.getMicrosecondPosition();
		song.stop();
	}
	
	
	/**
	 * Stops the Clip.
	 */
	public void stop(){
		song.stop();
	}
	
	public static void main(String[] args) {
		
		MusicPlayer test = new MusicPlayer("Bamse.wav");
		test.play();
		
		Scanner scanner = new Scanner(System.in);
		
		scanner.next();
		test.pause();
		
		scanner.next();
		test.play();
		
		scanner.close();
	}
	
}

