import java.util.ArrayList;
 
public class ItemArtist {
   
    public String[] songs;
    public  ArrayList<ItemSong> theArrayList;
    private String ArtistName;
    public int songsamount=0;
   
    public ItemArtist(String s, String a, ItemSong x) {
        songs = new String[30];
        songs[songsamount] = s;
        ArtistName = a;
        theArrayList = new ArrayList<ItemSong>();
        theArrayList.add(x);
       
    }
   
    public String getArtist() {
        return ArtistName;
    }
    public String[] getArtistSongs() {
        return songs;  
    }
   
   
}