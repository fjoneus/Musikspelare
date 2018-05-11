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

import org.junit.jupiter.api.Test;

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
	 * Creates a Clip object true AudioSystem, uses the open and start method from
	 * Clip to play the songFile. If the song has been on pause the song will start
	 * playing from currentPosition
	 * 
	 * @exception Catches
	 *                all the exceptions and prints them
	 */
	public void play() {

		if (stopped == true) {
			resume();
			stopped = false;
		} else {
			try {
				if (!queue.isEmpty() && active == false) {
					song = AudioSystem.getClip();
					songFile = queue.peek();
					song.open(AudioSystem.getAudioInputStream(new File(queue.pollFirst().getSongFilePath()).getAbsoluteFile()));
					song.start();
					active = true;
				}
			} catch (Exception e) {
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
	public void pause() {
		song.stop();
		stopped = true;
	}

	/**
	 * Stops the Clip.
	 */
	public void stop() {		
		song.stop();
		song.setMicrosecondPosition(0);
		stopped = true;
		active = false;
	
	}
	
	
	/**
	 * Stops the song, and plays it. This will trigger the play method to get the
	 * next in song queue
	 */
	public void nextSong() {
		if (active)
			stop();
		
		stopped = false; //Overwrite the stop(); method that sets stop to true. This is so the play method dosen't resume instead of playing next song in queue.   
		play();
	}
	
	/**
	 * Terminate closes the songs "Clip object".
	 */
	public void terminate() {
		song.close();
		stopped = false;
		active = false;
	}

	/**
	 * 
	 * @param x
	 *            Takes a double as in parameter. Stops the song, sets the
	 *            currentPos to x and plays the song.
	 */
	public void setTime(double x) {
		song.stop();
		long currentPos = (long) x * 1000000;
		song.setMicrosecondPosition(currentPos);
		if(!isStopped())
		resume();
	}

	/**
	 * 
	 * @return Returns the Current position in the song in seconds.
	 */
	public int getCurrentPos() {
		return (int) song.getMicrosecondPosition() / 1000000;
	}

	/**
	 * 
	 * @return Returns the songs length as a String
	 */
	public int getSongLength() {
		return (int) song.getMicrosecondLength() / 1000000;
	}

	public String timeToString(int secs) {
		String time;
		int min = (int) secs / 60;
		int sec = secs % 60;
		if (sec < 10)
			time = min + ":" + "0" + sec;
		else
			time = min + ":" + sec;
		return time;
	}

	/**
	 * 
	 * @param x
	 *            Takes an ItemSong as input and adds the song to queue
	 */
	public void addSongToQueue(ItemSong x) {		
		queue.add(x);
	}

	/**
	 * 
	 * @param x
	 *            Takes an ItemSong and adds the song first in the queue.
	 */
	public void addSongFirstInQueue(ItemSong x) {
		queue.addFirst(x);
	}


	public void setVolume(double vol) {
		if (active && !stopped) {
			if (vol < 0)
				vol = 0;
			else if (vol > 100)
				vol = 100;
			FloatControl volume = (FloatControl) song.getControl(FloatControl.Type.MASTER_GAIN);
			float dB = (float) (Math.log(vol / 100) / Math.log(10.0) * 20.0);
			volume.setValue(dB);
		}

	}

	public ArrayDeque<ItemSong> getQueue() {
		return queue;
	}

	public ItemSong getCurrentSong() {
		return songFile;
	}

	public boolean isStopped() {
		return stopped;
	}
	
	public boolean isActive() {
		return active;
	}

}
	
