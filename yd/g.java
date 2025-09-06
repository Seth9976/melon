package yd;

import com.iloen.melon.constants.AddPosition;
import zd.M;

public abstract class g {
    public static final int[] a;
    public static final int[] b;

    static {
        int[] arr_v = new int[M.values().length];
        try {
            arr_v[109] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[73] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        g.a = arr_v;
        int[] arr_v1 = new int[AddPosition.values().length];
        try {
            arr_v1[0] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v1[1] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v1[2] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        g.b = arr_v1;
    }
}

