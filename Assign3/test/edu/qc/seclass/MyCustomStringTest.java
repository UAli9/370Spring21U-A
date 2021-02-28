package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test (expected = NullPointerException.class)
    //Testing for the nullpointer exception
    public void testCountNumbers2() {

        mycustomstring.setString(null);
        mycustomstring.countNumbers();
    }

    @Test
    //Testing if current string is empty, it should return 0
    public void testCountNumbers3() {

        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    //Testing if we get 0 when there are no digits
    public void testCountNumbers4() {

        mycustomstring.setString("Hi my name is Slim Shady");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    //Testing if it recognizes the number in the middle of string
    public void testCountNumbers5() {
        mycustomstring.setString("I have 500 dollars in total");
        assertEquals(1, mycustomstring.countNumbers());
    }

    @Test
    //Testing if it notes the multiple digits being on different intervals
    public void testCountNumbers6() {
        mycustomstring.setString("We know that 2 added with 1 gives us 3");
        assertEquals(3, mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test
    //Testing to see if we get a string of characters where n=2 and startFromEnd is set to false
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("This is how we do it");
        assertEquals("hsi o ed t", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));;
    }

    @Test
    //Testing to see if we get a string of characters where n=2 and startFromEnd is set to true
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString("This is how we do it in NY");
        assertEquals("Ti shww oi nN", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));;
    }

    @Test
    //Testing to see if we get a string of characters where n=6 and startFromEnd is set to false
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString("Okay, lets try not to be repetitive");
        assertEquals(" ttet", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, false));
    }

    @Test
    //Testing to see if we get a string of characters where n=6 and startFromEnd is set to true
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("Okay, lets try not to be repetitive with this all");
        assertEquals("keytrtii", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, true));
    }

    @Test
    //Testing to see if we get empty string returned when the string is empty
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test(expected=NullPointerException.class)
    //Testing fot NullPointerException when string is null
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false);
    }

    @Test(expected= IllegalArgumentException.class)
    //Testing to see if IllegalArgumentException is thrown when n is equal to 0 and length of string is 3
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("Low");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }

    @Test(expected= IllegalArgumentException.class)
    //Testing to see if IllegalArgumentException is thrown when string is 6 characters long
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("Biggie");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true);
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        mycustomstring.setString("so we do this");
        assertEquals("s", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(13, false));
    }

    @Test
    //Testing on odd string length with an odd n
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("Batman is a superhero");
        assertEquals("a pr", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, false));
    }

    @Test
    //Testing on even string length with an even n
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("Real Madrid are champion");
        assertEquals("d n", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(8, false));
    }

    @Test
    //Testing on even string length with odd n
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString("algorithms are complicated");
        assertEquals("irl", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(7, true));
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test
    //Testing on a string from start position being 1 to end position being 12
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("thi3 i3 c00l");
        mycustomstring.convertDigitsToNamesInSubstring(1, 12);
        assertEquals("thiThree iThree cZeroZerol", mycustomstring.getString());
    }

    @Test
    //Testing to see if we get correct result when start and end positions are chosen from the middle of the string
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("I hav3 5 ch0colate");
        mycustomstring.convertDigitsToNamesInSubstring(5, 14);
        assertEquals("I havThree Five chZerocolate", mycustomstring.getString());
    }

    @Test
    //Testing to see if a string of all digits gets converted correctly
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("12345");
        mycustomstring.convertDigitsToNamesInSubstring(1, 5);
        assertEquals("OneTwoThreeFourFive", mycustomstring.getString());
    }

    @Test(expected=IllegalArgumentException.class)
    //Testing to see if IllegalArgumentException is thrown when startPosition is greater than endPosition
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString("We still rollin with this");
        mycustomstring.convertDigitsToNamesInSubstring(9, 2);
    }

    @Test(expected=MyIndexOutOfBoundsException.class)
    //Testing to see if MyIndexOutOfBoundsException gets thrown when positions are out of bounds
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("Not quite sure");
        mycustomstring.convertDigitsToNamesInSubstring(15, 20);
    }

    @Test
    //Testing to see if we get correct output when start and end position is the same
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("Th1s");
        mycustomstring.convertDigitsToNamesInSubstring(3, 3);
    }

    @Test(expected = NullPointerException.class)
    //Testing to see if NullPointerException is thrown when string is null and startPosition < endPosition
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(2, 3);
    }

}
