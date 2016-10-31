package readerTests;

import static org.junit.Assert.*;

import org.junit.Test;
import reader.Util;

public class UtilTest {

	@Test
	public void shouldRemoveSpacesFromInput() {
		String input = " 0 1,  1  0  ";
		input = Util.normalize(input);
		assertEquals("input should have no spaces", "01,10", input);
	}
	
	@Test
	public void shouldReturnAge() {
		int age = Util.getAge("5,10");
		assertEquals("age should be 10", 10, age);
	}

}
