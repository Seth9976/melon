package N4;

import android.widget.ImageView.ScaleType;

public abstract class i {
    public static final int[] a;

    static {
        int[] arr_v = new int[ImageView.ScaleType.values().length];
        i.a = arr_v;
        try {
            arr_v[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            i.a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
    }
}

