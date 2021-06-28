import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticsTest {
    private static Arithmetics a;
    private double delta = 0.0000000000000001;

    @BeforeAll
    public static void runT() {
        a = new Arithmetics();
    }

    @Test
    public void testAdd() {
        double res = a.add(3, 7);
        Assert.assertEquals(10, res, delta);
    }

    @Test
    public void testMult() {
        double res = a.mult(3, 7);
        Assert.assertEquals(21, res, delta);
    }

    @Test
    public void testDeduct() {
        double res = a.deduct(3, 7);
        Assert.assertEquals(-4, res, delta);
    }

    @Test
    public void testDiv() {
        double res = a.div(21, 7);
        Assert.assertEquals(3, res, delta);
    }

    @Test
    public void testDivException() {
        assertThrows(ArithmeticException.class, () -> a.div(10.0, 0));
    }

    @Test
    public void testN() {
        assertTimeout(ofMillis(10), () -> a.div(100000.0, 10.0));
    }
}