import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ModelTest {
    private static Model model;

    @BeforeClass
    public static void runTest() {
        model = new Model();
        try {
            Field field = model.getClass().getDeclaredField("hiddenNumber");
            field.setAccessible(true);
            field.set(model, 50);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHiddennNumberIsHigher() {
        assertEquals(1, model.guessingOfNumber(40));
    }

    @Test
    public void testHiddennNumberIsLower() {
        assertEquals(-1, model.guessingOfNumber(90));
    }

    @Test
    public void testHiddennNumberIsEqual() {
        assertEquals(0, model.guessingOfNumber(50));
    }
}