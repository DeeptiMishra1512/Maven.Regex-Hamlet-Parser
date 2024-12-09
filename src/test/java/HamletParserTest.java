import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        HamletParser parser = new HamletParser();
        String originalText = parser.getHamletData();
        //checking if before replacing the string if file contains the original string Horatio
        assertTrue(hamletText.contains("Hamlet"));

        //Calling method to replace Horatio with "Tariq"
        parser.patternMatcherMethod();

        //Storing the file data in new String variable and
        //checking if new data has Horatio string , assert should be false
        //assert to check if new data contains "Tariq" should be true
        String changedText = parser.getHamletData();
        System.out.println(changedText);
        assertFalse(changedText.contains("Hamlet"));
        assertTrue(changedText.contains("Leon"));

    }

    @Test
    public void testChangeHoratioToTariq() {
    HamletParser parser = new HamletParser();
    String originalText = parser.getHamletData();
    //checking if before replacing the string if file contains the original string Horatio
    assertTrue(hamletText.contains("Horatio"));

        //Calling method to replace Horatio with "Tariq"
         parser.patternMatcherMethod();

        //Storing the file data in new String variable and
        //checking if new data has Horatio string , assert should be false
        //assert to check if new data contains "Tariq" should be true
    String changedText = parser.getHamletData();
    System.out.println(changedText);
    assertFalse(changedText.contains("Horatio"));
    assertTrue(changedText.contains("Tariq"));

    }

    @Test
    public void testFindHoratio() {
    //HamletParser Parser = new HamletParser();
   // String originalText = Parser.getHamletData();

    assertTrue(hamletText.contains("Horatio"));

    }

    @Test
    public void testFindHamlet() {

        //HamletParser parser = new HamletParser();
        //String originalText = parser.getHamletData();

        // Check if "Hamlet" is present in the original text
        assertTrue(hamletText.contains("Hamlet"));

    }
}