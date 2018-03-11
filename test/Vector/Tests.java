package Vector;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    @Test
    public void equals() {
        assertTrue(new QuaternionVector(1, 1, 1).equals(new QuaternionVector(1, 1, 1)));
        assertFalse(new QuaternionVector(1, 2, 3).equals(new QuaternionVector(1, 2, 4)));
    }

    @Test
    public void toStringTest() {
        assertEquals("1.0m+1.0n+1.0p", new QuaternionVector(1, 1, 1).toString());
    }
}