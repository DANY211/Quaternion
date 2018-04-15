package QuaternionUtilites;

import org.junit.Test;
import Vector.QuaternionVector;
import Quaternion.Quaternion;

import static org.junit.Assert.assertEquals;

public class Tests {
    @Test
    public void getQuaternion() {
            QuaternionVector v;
            Double w;
            v = new QuaternionVector(1, 0, 0);
            w = 0.0;
            assertEquals(new Quaternion(1, 0, 0, 0),
                    QuaternionUtilites.getQuaternion(w, v));
            v = new QuaternionVector(-2, -3, -7);
            w = 0.5;
            assertEquals(new Quaternion(0.9689124217106447, -0.06284066849134874,
                            -0.0942610027370231, -0.21994233971972058),
                    QuaternionUtilites.getQuaternion(w, v));
    }

    @Test
    public void getAxis() {
        assertEquals(new Quaternion(1, 2, 3, 4).getVectorPart(), QuaternionUtilites.getAxis(new Quaternion(1, 2, 3, 4)));
    }

    @Test
    public void getAngle() {
        assertEquals(new Quaternion(1, 2, 3, 4).getScalarPart(), QuaternionUtilites.getAngle(new Quaternion(1, 2, 3, 4)), 1e-10);
    }
}