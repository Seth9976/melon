package d1;

import android.text.Layout.Alignment;

public abstract class d {
    public static final int[] a;

    static {
        int[] arr_v = new int[Layout.Alignment.values().length];
        try {
            arr_v[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        d.a = arr_v;
    }
}

