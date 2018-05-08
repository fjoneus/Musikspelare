
package Proj6;

public class ItemSong {

	private double songLength;
	private String songTitle;
	private String artist;
	private String songFilePath;

	public ItemSong(String artist, String songTitle, String songFileName, double songLength) {

		this.artist = artist;
		this.songTitle = songTitle;
		this.songFilePath = songFileName;
		this.songLength = songLength;
	}

	public double getSongLength() {
		return songLength;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public String getArtistName() {
		return artist;
	}
	
	public String getSongFilePath() {
		return songFilePath;
	}

	public String toString() {
		return artist + " - " + songTitle;
	}
}
