package Nb;

import oc.M;

public abstract class r {
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
        try {
            arr_v[0] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        r.a = arr_v;
    }
}

