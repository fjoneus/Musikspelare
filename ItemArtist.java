

import java.util.ArrayList;

public class ItemArtist {
	
	public String songs;
	public  ArrayList<ItemSong> theArrayList;
	private String ArtistName;
	
	public ItemArtist(String s, String a, ItemSong x) {
		songs = s;
		ArtistName = a;
		theArrayList = new ArrayList<ItemSong>();
		theArrayList.add(x);
		
	}
	
	public String getArtist() {
		return ArtistName;
	}
    public String getArtistSongs() {
    	return songs;	
    }
    
    public String toString() {
		return "----------------\n"+ ArtistName + " Tracks: "+ "\n\n"+ songs + "\n----------------\n";
    	
    }
    
}
