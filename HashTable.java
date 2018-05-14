
import java.util.ArrayList;
import java.lang.*;

import java.util.Arrays;

public class HashTable {
	private static Object[] theArray;
	private static Object[] theArrayArtist;
	private static int theSize = 10000;
	private static int amountOfArtists;
	private static int amountOfObjects;

	
	/**
	 * This constructs a HashTable containing two arrays of the size 10000
	 */
	public HashTable() {
		theArray = new Object[theSize];
		theArrayArtist = new Object[theSize];
		amountOfArtists = 0;
		amountOfObjects = 0;
	}
	/**
	 * 	This constructs a HashTable containing two arrays 
	 * @param x is the size of both the arrays
	 */
	public HashTable(int x) {
		theSize = x;
		theArray = new Object[theSize];
		theArrayArtist = new Object[theSize];
		amountOfArtists = 0;
		amountOfObjects = 0;

	}

		/**
		 * addSong takes a ItemSong(see for details) and add to both theArray and to theArrayArtist as a ItemSong
		 * @param x, Take a ItemSong as input parameter, and is added to both Arrays for songs and artists
		 */
	public void addSong(ItemSong x) {

		if(x == null)
			throw new IllegalArgumentException("Not the right type of object");
		
		try {

			if (amountOfObjects == theArray.length) {
				theArray = Arrays.copyOf(theArray, theSize * 2);
				theSize = theSize * 2;
			}

			theArray[hashCode(x.getSongTitle())] = x;
			amountOfObjects++;

			if (theArrayArtist[hashCode(x.getArtistName())] != null) {
				ItemArtist artistobj = (ItemArtist) theArrayArtist[hashCode(x.getArtistName())];
				artistobj.theArrayList.add(x);

			} else {
				ItemArtist artist = new ItemArtist(x.getSongTitle(), x.getArtistName(), x);
				theArrayArtist[hashCode(x.getArtistName())] = artist;
				amountOfArtists++;
			}
		} catch (Exception e) {
			System.out.println("Wrong input");
		}
	}
	/**
	 * This method takes an string as input parameter and uses the method hashCode() to get the code of the string 
	 * looking for
	 * @param x, Takes a string , can be both artistname or songname
	 * @return return an ArrayList with eighter a ItemSongs or an ItemArtist
	 */

	public ArrayList<ItemSong> find(String x) {
		int hash = hashCode(x);
		ArrayList<ItemSong> arr = new ArrayList<ItemSong>();

		if (theArray[hash] != null) {
			arr.add((ItemSong) theArray[hash]);
			return arr;
		} else if (theArrayArtist[hash] != null) {
			ItemArtist temp = (ItemArtist) theArrayArtist[hash];
			return temp.theArrayList;
		}

		return null;

	}

	/**
	 * This method generate a hashcode of the string witch is given as input parameter
	 * @param x, Takes a string as input parameter and make a code of it.
	 * @return An int witch is made with the input parameter and uses modulus the size of the ArrayList
	 */
	public static int hashCode(String x) {
		if (x == null) {
			return -1;
		}
		char[] temp = x.toCharArray();
		int hash = 3;
		for (int i = 1; i < temp.length + 1; i++) {
			hash += (int) (Math.pow((int) temp[i - 1] * 7, i % 3));

		}
		return hash % theSize;

	}
}