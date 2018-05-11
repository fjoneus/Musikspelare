
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
			//artistobj.songs += "\n" + x.getSongTitle();

		} else {
			ItemArtist artist = new ItemArtist(x.getSongTitle(), x.getArtistName(), x);
			theArrayArtist[hashCode(x.getArtistName())] = artist;
			amountOfArtists++;
		}

	}

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

	public static int hashCode(String x) {
		char[] temp = x.toCharArray();
		int hash = 3;
		for (int i = 1; i < temp.length + 1; i++) {
			hash += (int) (Math.pow((int) temp[i - 1] * 7, i % 3));

		}
		return hash % theSize;

	}
}
