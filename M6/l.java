package M6;

import sun.misc.Unsafe;

public abstract class l {
    public static boolean a(Unsafe unsafe0, h h0, long v, Object object0, Object object1) {
        do {
            if(unsafe0.compareAndSwapObject(h0, v, object0, object1)) {
                return true;
            }
        }
        while(unsafe0.getObject(h0, v) == object0);
        return false;
    }
}

