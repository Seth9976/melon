package M6;

import sun.misc.Unsafe;

public abstract class k {
    public static boolean a(Unsafe unsafe0, h h0, long v, e e0, e e1) {
        do {
            if(unsafe0.compareAndSwapObject(h0, v, e0, e1)) {
                return true;
            }
        }
        while(unsafe0.getObject(h0, v) == e0);
        return false;
    }
}

