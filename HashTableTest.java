import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


import org.junit.jupiter.api.Test;

class HashTableTest {
	
	private HashTable hashTest = new HashTable();
	

	@Test
	void findTest() {
		ItemSong song1	= new ItemSong("Eminem", "Lose Yourself", "Eminem-LoseYourself.wav", 2.30);
		ItemSong song2	= new ItemSong("Eminem", "River", "Eminem-River.wav", 2.35);
		ItemSong song3	= new ItemSong("Avicii", "Levels", "Avicii-Levels.wav", 3.30);	
		ItemSong song4	= new ItemSong("Avicii", "Hey Brother", "Avicii-HeyBrother.wav", 5.20);
		
			hashTest.addSong(song1);
			hashTest.addSong(song2);
			hashTest.addSong(song3);
			hashTest.addSong(song4);
			
			ArrayList<ItemSong> test = hashTest.find("River");
			
			assertEquals(test, hashTest.find("River"), "Check that we don't delete a song with find()");
			assertNull(hashTest.find("no song in the list"));
		
	}
	
	@Test
	void hashCodeTest() {
		
		assertEquals(2629, hashTest.hashCode("Levels"), "Check that we got an specific int for every song");
		assertEquals(-1, hashTest.hashCode(null), "hashCode() return -1 when string is null, don't get an array position");
			
	}
}
