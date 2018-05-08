import java.io.*;
import java.util.*;

public class ReadSongsFromFile{
	
	public static HashTable initHashTable() {
		
		String[] arrayString;
		String oneline;
		HashTable x = new HashTable();
		File songs = new File("songs.txt");
		try {
		Scanner text = new Scanner(songs);
		
		while(text.hasNext()){
			
			oneline = text.nextLine();
			arrayString = oneline.split("\t");
			String artist = arrayString[0];
			String title = arrayString[1];
			String filename = arrayString[2];
			double lenght = Double.parseDouble(arrayString[3]);
			x.addSong(new ItemSong(artist,title,filename,lenght)); 
		}
		text.close();
		}catch(Exception e){System.out.println("Can't find file");}
		
		return x;
	}
}	
