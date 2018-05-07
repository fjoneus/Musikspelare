package labbXtra;
import java.io.*;
import java.util.*;

public class ReadSongsFromFile{
	
	public static void main(String[] args) {
		
		String[] arrayString;
		String oneline;
		HashTable x = new HashTable();
		File songs = new File("C:\\Users\\Gukken TOAO\\eclipse-workspace\\LabbXtra\\src\\labbXtra\\songs.txt");
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
		
		}catch(Exception e){System.out.println("Can't find file");}
	}
}	
