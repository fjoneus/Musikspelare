

import java.util.ArrayList;

public class ItemArtist {
	
	public String songs;
	public  ArrayList<ItemSong> theArrayList;
	private String ArtistName;
	
	
	/**
	 * This constructs an ItemArtist witch contains two strings, on for song and the other one for artistname
	 * It also contains an ItemSong witch atomaticly is added to an ArrayList  
	 * @param song, The name of the song
	 * @param artist, The name of the artist
	 * @param x, An ItemSong(See ItemSong docs for details)
	 */
	public ItemArtist(String song, String artist, ItemSong x) {
		songs = song;
		ArtistName = artist;
		theArrayList = new ArrayList<ItemSong>();
		theArrayList.add(x);
		
	}
	/**
	 * This returns an artistname
	 * @return the namen of the artist
	 */
	public String getArtist() {
		return ArtistName;
	}
	/**
	 * This return a song of an artist
	 * @return the songname 
	 */
    public String getArtistSongs() {
    	return songs;	
    }
    /**
     * Make a string of a ItemArtist, witch contains an artistname and a songname
     */
    public String toString() {
		return "----------------\n"+ ArtistName + " Tracks: "+ "\n\n"+ songs + "\n----------------\n";
    	
    }
    
}