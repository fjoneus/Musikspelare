package Proj6;

import java.util.ArrayList;
import java.util.Arrays;

public class HashTable {
	private static Object[] theArray;
	private static Object[] theArrayArtist;
	private static int theSize = 1000;
	private static int amountOfArtists;
	private static int amountOfObjects;

	public HashTable() {
		theArray = new Object[theSize];
		theArrayArtist = new Object[theSize];
		amountOfArtists = 0;
		amountOfObjects = 0;
	}

	public HashTable(int x) {
		theSize = x;
		theArray = new Object[theSize];
		theArrayArtist = new Object[theSize];
		amountOfArtists = 0;
		amountOfObjects = 0;

	}

	public void addSong(ItemSong x) {
		if (amountOfObjects == theArray.length) {
			theArray = Arrays.copyOf(theArray, theSize * 2);
			theSize = theSize * 2;
		}

		theArray[hashCode(x.getSongTitle())] = x;
		amountOfObjects++;

		if (theArrayArtist[hashCode(x.getArtistName())] != null) {
			ItemArtist artistobj = (ItemArtist) theArrayArtist[hashCode(x.getArtistName())];
			artistobj.theArrayList.add(x);
			artistobj.songs += "\n" + x.getSongTitle();

		} else {
			ItemArtist artist = new ItemArtist(x.getSongTitle(), x.getArtistName(), x);
			theArrayArtist[hashCode(x.getArtistName())] = artist;
			amountOfArtists++;
		}

	}

	public ArrayList find(String x) {
		int hash = hashCode(x);
		ArrayList arr = new ArrayList();

		if (theArray[hash] != null) {
			arr.add((ItemSong) theArray[hash]);
			return arr;
		} else if (theArrayArtist[hash] != null) {
			ItemArtist temp = (ItemArtist) theArrayArtist[hash];
			return temp.theArrayList;
		}

		return null;

	}

	public static int hashCode(String x) {
		char[] temp = x.toCharArray();
		int hash = 3;
		for (int i = 1; i < temp.length + 1; i++) {
			hash += (int) (Math.pow((int) temp[i - 1] * 7, i % 3));

		}
		return hash % theSize;

	}

	public static void main(String[] args) {

		HashTable hash = new HashTable();

		hash.addSong(new ItemSong("Eminem", "Love the way you lie", "/asdaölsdfklö", 2.201));
		hash.addSong(new ItemSong("Eminem", "Lose Yourself", "/asdaölkslö", 2.205));
		hash.addSong(new ItemSong("Thåström", "Kom Hem", "/asdaölkslö", 3.205));
		hash.addSong(new ItemSong("Eminem", "Rap God", "/asdaölkslö", 3.105));
		hash.addSong(new ItemSong("Ronny & Ragge", "Sug Kuk", "/asdaölkslö", 3.305));
		hash.addSong(new ItemSong("Post Malone", "21 Rockstar", "/asdaölkslö", 2.405));
		hash.addSong(new ItemSong("Avicii", "Levels", "/asdaölkslö", 1.405));
		hash.addSong(new ItemSong("Foo Fighters", "The Pretender", "/asdaölkslö", 2.205));
		hash.addSong(new ItemSong("Avicii", "Wake Me Up", "/asdaölkslö", 3.215));
		hash.addSong(new ItemSong("Avicii", "Without You", "/asdaölkslö", 3.225));
		hash.addSong(new ItemSong("Avicii", "Lonely Together", "/asdaölkslö", 3.333));

		System.out.println("--------------------------");
		for (Object i : theArrayArtist) {
			if (i != null)
				System.out.println(i);
		}
		System.out.println("--------------------------");

		System.out.println("--------------------------");
		System.out.println("Soundtracks: " + amountOfObjects);
		System.out.println("--------------------------");
		System.out.println("Artists: " + amountOfArtists);

	}

}
