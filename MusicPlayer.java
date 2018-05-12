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
	 * Creates a MusicPlayer object that can be used to play .wav music files. In the MusicPlayer class there are methods to be used for play, 
	 * pause, resume, stop and more. Note that this MusicPLayer uses an object called ItemSong that needs to hold the path to the .wav file.
	 * It can easily be modified to be used with other objects as long as it holds the information of the song file path. 
	 * The MusicPlayer needs a GUI or some sort of main program that runs all the time, otherwise the MusicPLayer will stop when the main program has finished.
	 */
	public MusicPlayer() {

	}

	/**
	 * Creates a Clip object true AudioSystem, uses the open and start method from
	 * Clip to play the songFile. If the song has been on pause the song will start
	 * playing from currentPosition
	 * 
	 * @exception catches all the exceptions and prints them.
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

	
	/**
	 * Resumes the song from the current position if it has been stopped or on pause. You can mainly use the play method
	 * sinse it will now when to call the resume method if there has been a song on pause or stop. 
	 */
	public void resume() {
			song.start();
			stopped = false;
			active = true;
	}
	

	/**
	 * Saves the current position of the Clip so it can be used later with play/resume and then pauses the Clip.
	 */
	public void pause() {
		song.stop();
		stopped = true;
		active = true;
	}

	/**
	 * Stops the Clip and sets the current position of the song to the beginning of the song.
	 */
	public void stop() {		
		song.stop();
		song.setMicrosecondPosition(0);
		stopped = true;
		active = false;
	}
	
	
	/**
	 * Stops the song if one is active and plays the next, This will trigger the play method to get the
	 * next song in queue.
	 */
	public void nextSong() {
		if (active)
			stop();
		
		stopped = false; //Overwrite the stop(); method that sets stop to true. This is so the play method dosen't resume instead of playing next song in queue.   
		play();
	}
	
	/**
	 * Terminate and closes the songs "Clip object". The data in the current song "Clip object" will be lost.
	 */
	public void terminate() {
		song.close();
		stopped = false;
		active = false;
	}

	/** 
	 * @param x sets current position of the song. 
	 * In detail, pauses the song, sets the current time and then resumes the song from the new position.
	 */
	public void setTime(double x) {
		song.stop();
		long currentPos = (long) x * 1000000;
		song.setMicrosecondPosition(currentPos);
		if(!isStopped())
		resume();
	}

	/**
	 * @return the current position of the song ("Clip") in seconds as int.
	 */
	public int getCurrentPos() {
		return (int) song.getMicrosecondPosition() / 1000000;
	}

	/**
	 * 
	 * @return the current songs length in seconds.  
	 */
	public int getSongLength() {
		return (int) song.getMicrosecondLength() / 1000000;
	}

	/**
	 * 
	 * @param secs converts the value to time in seconds and minutes.
	 * @return the conversion as a String if format min : sec. Note, if the seconds ar less then
	 * 10 it will add a zero in front of the seconds.
	 */
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
	 * @param x adds the object to the song queue. 
	 */
	public void addSongToQueue(ItemSong x) {		
		queue.add(x);
	}

	/**
	 * @param x adds the object first to the song queue. 
	 */
	public void addSongFirstInQueue(ItemSong x) {
		queue.addFirst(x);
	}

	/**
	 * 
	 * @param vol sets the volume.
	 */
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
	/**
	 * 
	 * @return the current queue.
	 */
	public ArrayDeque<ItemSong> getQueue() {
		return queue;
	}
	
	/**
	 * 
	 * @return the current object that is being used.
	 */
	public ItemSong getCurrentSong() {
		return songFile;
	}

	/**
	 * 
	 * @return true or false if the song is stopped or not. If a song is stopped it is stopped, or on pause. 
	 * Note that by default from start the method will return false.  
	 */
	public boolean isStopped() {
		return stopped;
	}
	
	/**
	 * 
	 * @return true or false if the song is active or not. A song is active if the song being played. 
	 */
	public boolean isActive() {
		return active;
	}
}
	
