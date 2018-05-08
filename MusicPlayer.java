
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
	private ArrayDeque<AudioInputStream> queue = new ArrayDeque<AudioInputStream>();
	private boolean active = true;
	
	
	/**
	 * Constructor -> Does nothing, just creates the MusicPlayer object
	 */
	public MusicPlayer() {
		
	}
	
	/**
	 * Creates a Clip object true AudioSystem, uses the open and start method from Clip to play the songFile. 
	 * If the song has been on pause the song will start playing from currentPosition 
	 * @exception Catches all the exceptions and prints them
	 */
	public void play() {
			
		if(active == false) {
			resume();
		}
		else {
			try {
				if(!queue.isEmpty()) {
					song = AudioSystem.getClip();
					song.open(queue.poll());
					song.start();
					active = true;
				}
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
		active = false;
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
	
	/**
	 * 
	 * @param x Takes an ItemSong as input and adds the song to queue 
	 */
	public void addSongToQueue(String x) {
		
		try {
			//File file = new File(x.getSongFilePath());   //Create the File object that holds the path to the file
			File file = new File(x);
			songFile = AudioSystem.getAudioInputStream(file.getAbsoluteFile()); //Set the "private songFile" so it can be used later in the program. AudioSystem returns a AudioInputStream object
		}
			catch(Exception e) {
				System.out.println(e);
			}
		
		queue.add(songFile);
	}
	
	/**
	 * Stops the song, and plays it. This will trigger the play method to get the next in song queue
	 */
	public void nextSong() {
		stop();
		active = true;
		play();
	}
	
	
//	public static void main(String[] args) {
//		
//		Scanner scanner = new Scanner(System.in);
//		
//		//Add song and play
//		MusicPlayer test = new MusicPlayer();
//		test.addSongToQueue("Avicii-AddictedToYou.wav");
//		test.addSongToQueue("Avicii-HeyBrother.wav");
//		test.play();
//		
//		
//		scanner.next();
//		test.stop();
//		
//		
//		scanner.next();
//		test.play();
//		
//		
//		scanner.next();
//		test.pause();
//		
//		scanner.next();
//		test.resume();
//		
//		scanner.next();
//		test.nextSong();
//		
//		//Keep the main alive
//		scanner.next();
//		scanner.close();
//		
//	}
}

