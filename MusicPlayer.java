

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

	private ItemSong songFile;
	private Clip song;
	private ArrayDeque<ItemSong> queue = new ArrayDeque<ItemSong>();
	private boolean stopped = false;
	private boolean active = false;
	
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
			
		if(stopped == true) {
			resume();
			stopped = false;
		}
		else {
			try {
				if(!queue.isEmpty() && active == false) {
					song = AudioSystem.getClip();
					songFile = queue.peek();
					song.open(AudioSystem.getAudioInputStream(new File(queue.pollFirst().getSongFilePath()).getAbsoluteFile()));
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
		stopped = true;
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
	public void addSongToQueue(ItemSong x) {
		if(stopped == true) {
			song.close();
			active = false;
			stopped = false;
		}
		
		//try {
			//File file = new File(x.getSongFilePath());   //Create the File object that holds the path to the file
			//songFile = AudioSystem.getAudioInputStream(file.getAbsoluteFile()); //Set the "private songFile" so it can be used later in the program. AudioSystem returns a AudioInputStream object
		//}
			//catch(Exception e) {
			//	System.out.println(e);
			//}
		
		queue.add(x);
	}
	
	/**
	 * 
	 * @param x Takes an ItemSong and adds the song first in the queue. 
	 */
	public void addSongFirstInQueue(ItemSong x) {
		
		//If a song has been stopped we have to set the label stopped to false, otherwise the play function will play both the 
		stopped = false;
				
		queue.addFirst(x);
		
		//If a song is playing and we whant to play a new one, close it and start the new one.
		if(active == true) {
		stop();
		stopped = false;
		}
		play();
	}
	
	/**
	 * Stops the song, and plays it. This will trigger the play method to get the next in song queue
	 */
	public void nextSong() {
		stop();
		stopped = false;
		play();
	}
	
	public ArrayDeque getQueue() {
		return queue;
	}
	
	public ItemSong getCurrentSong() {
		return songFile;
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
//		test.play();
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
