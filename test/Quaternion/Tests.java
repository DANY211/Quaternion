package Quaternion;

import Vector.QuaternionVector;
import com.sun.xml.internal.ws.util.QNameMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void conjugation() {
        assertEquals(new Quaternion(-16.1, -4, -3.01, 13), new Quaternion(-16.1, 4, 3.01, -13).conjugation());
        assertEquals(new Quaternion(1, -1, 1, -1), new Quaternion(1, 1, -1, 1).conjugation());
        assertEquals(new Quaternion(269, -11.025, -345, 99.99), new Quaternion(269, 11.025, 345, -99.99).conjugation());
    }

    @Test
    public void multiplyNum() {
        assertEquals(new Quaternion(3.5, 0, 35, -21), new Quaternion(1, 0, 10, -6).multiplyNum(3.5));
        assertEquals(new Quaternion(234, 234, 234,234), new Quaternion(1, 1, 1, 1).multiplyNum(234));
        assertEquals(new Quaternion(0, 1.6261, -592.365, 232.0677),new Quaternion(0, 0.07, -25.5, 9.99).multiplyNum(23.23));
    }

    @Test
    public void plus() {
        assertEquals(new Quaternion(10, 5.55, -10, 2.22), new Quaternion(10, 0, -10, 0).plus(new Quaternion(0, 5.55, 0, 2.22)));
        assertEquals(new Quaternion(30, 3, 0, -0.25), new Quaternion(15, 1.5, 4, 0.5).plus(new Quaternion(15, 1.5, -4, -0.75)));
        assertEquals(new Quaternion(25.5, -12, 44, -23), new Quaternion(12.75, -32, 22, -1).plus(new Quaternion(12.75, 20, 22, -22)));
    }

    @Test
    public void minus() {
        assertEquals(new Quaternion(10, -5.55, -10, -2.22), new Quaternion(10, 0, -10, 0).minus(new Quaternion(0, 5.55, 0, 2.22)));
        assertEquals(new Quaternion(30, 3, 8, -0.25), new Quaternion(45, 4.5, 4, 0.5).minus(new Quaternion(15, 1.5, -4, 0.75)));
        assertEquals(new Quaternion(25.5, -12, 44, -23), new Quaternion(38, -32, 88, -1).minus(new Quaternion(12.5, -20, 22, -22)));
    }

    @Test
    public void multiply() {
        assertEquals(new Quaternion(0, 32.9, 0, 77.1), new Quaternion(10, 0, -10, 0).multiply(new Quaternion(0, 5.5, 0, 2.21)));
        assertEquals(new Quaternion(683.875, 140, -122.625, 17.25), new Quaternion(45, 4.5, 4, 0.5).multiply(new Quaternion(15, 1.5, -4, 0.75)));
        assertEquals(new Quaternion(25.5,-12.0, 66.0, 21.0), new Quaternion(38, -32, 88, -1).minus(new Quaternion(12.5, -20, 22, -22)));
    }

    @Test
    public void abs() {
        assertEquals(16.67409967584457, new Quaternion(10, -3, 13.0, -0.16).abs(), 1e-10);
        assertEquals( 24.26932219902319, new Quaternion(12, -11, 18, 0).abs(), 1e-10);
        assertEquals( 13.997574789941291826453479279833, new Quaternion(-0.5, -4, -7.5, -11.11).abs(), 1e-10);
    }

    @Test
    public void normalization(){
        assertEquals(new Quaternion(100, 9,169,0.0256), new Quaternion(10, -3, 13.0, -0.16).normalization());
        assertEquals(new Quaternion(0, 1,25,261.1456), new Quaternion(0, -1, 5, -16.16).normalization());
        assertEquals(new Quaternion(225, 81,289,1), new Quaternion(-15, -9, -17, 1).normalization());

    }

    @Test
    public void divideOnNumber() {
        assertEquals(new Quaternion(0.25, 4, -1, -4.04), new Quaternion(1, 16, -4, -16.16).divideOnNumber(4));
        assertEquals(new Quaternion(1.92, -1, 2.02, 1.6), new Quaternion(24, -12.5, 25.25, 20).divideOnNumber(12.5));
        assertEquals(new Quaternion(8.9108910891089108910891089108911, -17.326732673267326732673267326733,4.950495049504950495049504950495 ,-0.00990099009900990099009900990099 ), new Quaternion(-180, 350, -100.00, 0.20).divideOnNumber(-20.20));
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