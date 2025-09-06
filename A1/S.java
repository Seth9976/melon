package a1;

import android.text.Layout.Alignment;

public abstract class s {
    public static final int[] a;

    static {
        int[] arr_v = new int[Layout.Alignment.values().length];
        try {
            arr_v[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        s.a = arr_v;
    }
}

