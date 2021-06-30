import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;

import static org.junit.Assert.*;

public class ModelTest {
    private static Model model;

    @BeforeClass
    public static void runTest() {
        model = new Model();
    }

    @Test
    public void testHiddennNumberIsHigher() throws NoSuchFieldException, IllegalAccessException {
        Field field = model.getClass().getDeclaredField("hiddenNumber");
        field.setAccessible(true);
        field.set(model, 50);
        assertEquals(1, model.guessingOfNumber(40));
    }

    @Test
    public void testHiddennNumberIsLower() throws NoSuchFieldException, IllegalAccessException {
        Field field = model.getClass().getDeclaredField("hiddenNumber");
        field.setAccessible(true);
        field.set(model, 50);
        assertEquals(-1, model.guessingOfNumber(90));
    }

    @Test
    public void testHiddennNumberIsEqual() throws NoSuchFieldException, IllegalAccessException {
        Field field = model.getClass().getDeclaredField("hiddenNumber");
        field.setAccessible(true);
        field.set(model, 50);
        assertEquals(0, model.guessingOfNumber(50));
    }

    @Test
    public void testGetLowerLimit() throws NoSuchFieldException, IllegalAccessException {
        Field field = model.getClass().getDeclaredField("lowerLimit");
        field.setAccessible(true);
        field.set(model, 10);
        assertEquals(10, model.getLowerLimit());
    }

    @Test
    public void testGetHigherLimit() throws NoSuchFieldException, IllegalAccessException {
        Field field = model.getClass().getDeclaredField("higherLimit");
        field.setAccessible(true);
        field.set(model, 110);
        assertEquals(110, model.getHigherLimit());
    }

    @Test
    public void testGetHiddenNumber() throws NoSuchFieldException, IllegalAccessException {
        Field field = model.getClass().getDeclaredField("hiddenNumber");
        field.setAccessible(true);
        field.set(model, 77);
        assertEquals(77, model.getHiddenNumber());
    }

    @Test
    public void testSetPrimaryLimitsForLowerOne() throws NoSuchFieldException, IllegalAccessException {
        Field field = model.getClass().getDeclaredField("lowerLimit");
        field.setAccessible(true);
        model.setPrimaryLimits(23, 89);
        assertEquals(23, field.get(model));
    }

    @Test
    public void testSetPrimaryLimitsForHigherOne() throws NoSuchFieldException, IllegalAccessException {
        Field field = model.getClass().getDeclaredField("higherLimit");
        field.setAccessible(true);
        model.setPrimaryLimits(23, 89);
        assertEquals(89, field.get(model));
    }

    @Test
    public void testGetAttempts() throws NoSuchFieldException, IllegalAccessException {
        Field field = model.getClass().getDeclaredField("attempts");
        field.setAccessible(true);
        LinkedHashSet<Integer> test = new LinkedHashSet();
        test.add(12);
        test.add(20);
        field.set(model, test);
        assertEquals("[12, 20]", model.getAttempts());
    }

    @Test
    public void testSetHiddenNumber() throws NoSuchFieldException, IllegalAccessException {
        Field field = model.getClass().getDeclaredField("hiddenNumber");
        field.setAccessible(true);
        model.setPrimaryLimits(GlobalConstants.PRIMARY_MIN_BARRIER, GlobalConstants.PRIMARY_MAX_BARRIER);
        model.setHiddenNumber();
        assertTrue(GlobalConstants.PRIMARY_MIN_BARRIER < (int)field.get(model) && GlobalConstants.PRIMARY_MAX_BARRIER > (int)field.get(model));
    }
}