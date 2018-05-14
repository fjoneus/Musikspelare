

public class ItemSong {

	private double songLength;
	private String songTitle;
	private String artist;
	private String songFilePath;

	/**
	 * This constructs a ItemSong witch contains an artist, songTitle, songFileName and songlength 
	 * @param artist, the name of the artist
	 * @param songTitle, the title of the song
	 * @param songFileName, the name of the songfile
	 * @param songLength, the length of the song
	 */
	public ItemSong(String artist, String songTitle, String songFileName, double songLength) {

		this.artist = artist;
		this.songTitle = songTitle;
		this.songFilePath = songFileName;
		this.songLength = songLength;
	}
	/**
	 * This returns the songlength
	 * @return this length of the song in the ItemSong
	 */
	public double getSongLength() {
		return songLength;
	}
	
	/**
	 *	This returns the songtitle
	 * @return This title of the song in the ItemSong
	 */
	public String getSongTitle() {
		return songTitle;
	}

	/**
	 *	This returns the artists name
	 * @return This name of the artist in the ItemSong
	 */
	public String getArtistName() {
		return artist;
	}
	
	/**
	 *	This returns the name of the file to the song
	 * @return The name of the file
	 */
	public String getSongFilePath() {
		return songFilePath;
	}
	/**
	 * This make it a string With only artist and songtitle
	 */
	public String toString() {
		return artist + " - " + songTitle;
	}
}