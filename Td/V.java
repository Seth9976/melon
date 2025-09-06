package td;

import oc.M;

public abstract class v {
    public static final int[] a;

    static {
        int[] arr_v = new int[M.values().length];
        try {
            arr_v[1] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[2] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        v.a = arr_v;
    }
}

