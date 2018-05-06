
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
	private File file;
	private boolean playPush;
	
	
	/**
	 * Constructor -> Extracts the songName from the Item object and creates the AudioInputStream
	 */
	public MusicPlayer(Item x) {
		
		try {
			File file = new File(x.getFileName());   //Create the File object that holds the path to the file
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
			if(playPush == true) {
				resume();
			}
			else {
				try {
					song = AudioSystem.getClip();
					song.open(songFile);
					//song.setMicrosecondPosition(currentPos);
					song.start();
					playPush = true;
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
	}
	
	public void resume() {
		song.start();
	}
	
	/**
	 * Saves the current position and stops the Clip.
	 */
	public void pause(){
		song.stop();
	}
	
	/**
	 * Stops the Clip.
	 */
	public void stop(){
		song.stop();
		song.setMicrosecondPosition(0);
	}
	
	/**
	 * 
	 * @param x Takes a double as in parameter. Stops the song, sets the currentPos to x and plays the song.  
	 */
	public void setTime(double x) {
		song.stop();
		long currentPos = (long) x*1000000;
		song.setMicrosecondPosition(currentPos);
		play();
	}
	
	/**
	 * 
	 * @return Returns the Current position in the song in seconds.
	 */
	public int getCurrentPos() {
		return (int) song.getMicrosecondPosition()/1000000;
	}
	
	/**
	 * 
	 * @return Returns the songs length in seconds
	 */
	public int getSongLength() {
		return (int) song.getMicrosecondLength()/1000000;
	}
	
	public static void main(String[] args) {
		
		MusicPlayer test = new MusicPlayer("Bamse.wav");
		test.play();
		
		Scanner scanner = new Scanner(System.in);
		
		scanner.next();
		test.pause();
		
		scanner.next();
		System.out.println(test.getCurrentPos());
		System.out.println(test.getSongLength());
		
		scanner.next();
		
		scanner.close();
	}
	
}

