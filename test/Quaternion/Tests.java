package Quaternion;

import Vector.QuaternionVector;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void conjugation() {
        assertEquals(new Quaternion(-16.1, -4, -3.01, 13), new Quaternion(-16.1, 4, 3.01, -13).conjugation());
    }

    @Test
    public void multiplyNum() {
        assertEquals(new Quaternion(3.5, 0, 35, -21), new Quaternion(1, 0, 10, -6).multiplyNum(3.5));
    }

    @Test
    public void plus() {
        assertEquals(new Quaternion(10, 5.55, -10, 2.22), new Quaternion(10, 0, -10, 0).plus(new Quaternion(0, 5.55, 0, 2.22)));
    }

    @Test
    public void minus() {
        assertEquals(new Quaternion(10, -5.55, -10, -2.22), new Quaternion(10, 0, -10, 0).minus(new Quaternion(0, 5.55, 0, 2.22)));
    }

    @Test
    public void multiply() {
        assertEquals(new Quaternion(0, 32.9, 0, 77.1), new Quaternion(10, 0, -10, 0).multiply(new Quaternion(0, 5.5, 0, 2.21)));
    }

    @Test
    public void abs() {
        assertEquals(16.67409967584457, new Quaternion(10, -3, 13.0, -0.16).abs(), 1e-10);

    }

    @Test
    public void divideOnNumber() {
        assertEquals(new Quaternion(0.25, 4, -1, 4.04), new Quaternion(1, 16, -4, 16.16).divideOnNumber(4));
        try {
            new Quaternion(1000, -23.32, -0.088, 121).divideOnNumber(0);
            assertTrue(false);
        } catch (ArithmeticException e) {
            assertTrue(true);
        }

    }

    @Test
    public void inverse() {
        assertEquals(new Quaternion(0.25, -0.25, -0.25, -0.25), new Quaternion(1, 1, 1, 1).inverse());
        final Quaternion resQ = new Quaternion(10, -3, -11.0, 0.11).inverse();
        final Quaternion expQ = new Quaternion(0.043476, 0.0130428, 0.0478236, -0.000478236);
        assertEquals(expQ.getScalarPart(), resQ.getScalarPart(), 1e-7);
        assertEquals(expQ.getVectorPart().getX(), resQ.getVectorPart().getX(), 1e-7);
        assertEquals(expQ.getVectorPart().getY(), resQ.getVectorPart().getY(), 1e-7);
        assertEquals(expQ.getVectorPart().getZ(), resQ.getVectorPart().getZ(), 1e-7);
        assertEquals(new Quaternion(0, -0.1, 0, 0), new Quaternion(0, 10, 0, 0).inverse());
        try {
            new Quaternion(0, 0, 0, 0).inverse();
            assertTrue(false);
        } catch (ArithmeticException e) {
            assertTrue(true);
        }
    }

    @Test
    public void rational() {
        assertEquals(new Quaternion(0.5, 0.5, 0.5, 0.5), new Quaternion(1, 1, 1, 1).rational());
        try {
            new Quaternion(0, 0, 0, 0).rational();
            assertTrue(false);
        } catch (ArithmeticException e) {
            assertTrue(true);
        }
        final Quaternion exp = new Quaternion(0.65795169496, -0.19738550848, -0.72374687176, 0.06579517016);
        final Quaternion res = new Quaternion(10, -3, -11.0, 1).rational();
        assertEquals(exp.getScalarPart(), res.getScalarPart(), 1e-7);
        assertEquals(exp.getVectorPart().getX(), res.getVectorPart().getX(), 1e-7);
        assertEquals(exp.getVectorPart().getY(), res.getVectorPart().getY(), 1e-7);
        assertEquals(exp.getVectorPart().getZ(), res.getVectorPart().getZ(), 1e-7);
        assertEquals(new Quaternion(0, 0.6, 0, 0.8), new Quaternion(0, 6, 0, 8).rational());
    }

    @Test
    public void divide() {
        assertEquals(new Quaternion(1, 0, 0, 0), new Quaternion(1, 1, 1, 1).divide(new Quaternion(1, 1, 1, 1)));
        final Quaternion resQ = new Quaternion(5.2, -6, 2, 12.3).divide(new Quaternion(-5.5, 21, -2.3, -1));
        final Quaternion expQ = new Quaternion(-0.359133, -0.214621, -0.526323, -0.0717222);
        assertEquals(expQ.getScalarPart(), resQ.getScalarPart(), 1e-6);
        assertEquals(expQ.getVectorPart().getX(), resQ.getVectorPart().getX(), 1e-6);
        assertEquals(expQ.getVectorPart().getY(), resQ.getVectorPart().getY(), 1e-6);
        assertEquals(expQ.getVectorPart().getZ(), resQ.getVectorPart().getZ(), 1e-6);

    }

    @Test
    public void equals() {
        assertTrue(new Quaternion(1, 1, 1, 1).equals(new Quaternion(1, new QuaternionVector(1, 1, 1))));
        assertFalse(new Quaternion(1, 2, 3, 4).equals(new Quaternion(1, 2, 4, 4)));
    }

    @Test
    public void toStringTest() {
        assertEquals("1.0+1.0m+1.0n+1.0p", new Quaternion(1, 1, 1, 1).toString());

    }
}