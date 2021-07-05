import org.junit.BeforeClass;
import org.junit.Test;


import static org.junit.Assert.*;

public class NoteTest {
    private static Note note;

    @BeforeClass
    public static void run(){
        note = new Note();
        note.setLastName("Dudchenko");
        note.setName("Liudmila");
        note.setIndex("83002");
        note.setCity("Kyiv");
        note.setStreet("Shevchenko");
        note.setHome("3A");
        note.setFlat("15");
    }

    @Test
    public void testFormLastNameAndFirstLetterOfName(){
        note.formLastNameAndFirstLetterOfName();
        assertEquals("Dudchenko L", note.getFullName());
    }

    @Test
    public void testformFullAdress(){
        note.formFullAdress();
        assertEquals("83002, Kyiv, Shevchenko, 3A, 15", note.getFullAddress());
    }

}