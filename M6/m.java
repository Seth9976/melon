package M6;

import sun.misc.Unsafe;

public abstract class m {
    public static boolean a(Unsafe unsafe0, q q0, long v, p p0, p p1) {
        do {
            if(unsafe0.compareAndSwapObject(q0, v, p0, p1)) {
                return true;
            }
        }
        while(unsafe0.getObject(q0, v) == p0);
        return false;
    }
}

