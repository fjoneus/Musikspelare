

import java.io.*;
import java.util.*;

public class ReadSongsFromFile{
	private static ArrayList<String> randomarray;
	
	public static HashTable initHashTable() {
		randomarray = new ArrayList<String>();
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
			randomarray.add(title);
			
		}
		text.close();
		}catch(Exception e){System.out.println("Can't find file");}
		
		return x;
	}
	
	public static String[] getRandomArray() {
		String[] arr = new String[randomarray.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (String) randomarray.get(i);
			System.out.println(randomarray.get(i));
		}
		return arr;
		
	}
	
	
}
