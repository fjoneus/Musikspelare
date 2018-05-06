
 
public class ItemSong {
 
    private double songLength;
    private String songTitle;
    private String artist;
    private String songFilePath;
 
    public ItemSong(String artist, String songTitle, String songFilePath, double songLength) {
 
        this.artist = artist;
        this.songTitle = songTitle;
        this.songFilePath = songFilePath;
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
 
    public String toString() {
        return artist + " - " + songTitle + " - " + songLength;
    }
}