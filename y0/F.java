package y0;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;

public abstract class f {
    public static final int[] a;
    public static final int[] b;

    static {
        int[] arr_v = new int[Paint.Style.values().length];
        try {
            arr_v[Paint.Style.STROKE.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        int[] arr_v1 = new int[Paint.Cap.values().length];
        try {
            arr_v1[Paint.Cap.BUTT.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v1[Paint.Cap.ROUND.ordinal()] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v1[Paint.Cap.SQUARE.ordinal()] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        f.a = arr_v1;
        int[] arr_v2 = new int[Paint.Join.values().length];
        try {
            arr_v2[Paint.Join.MITER.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v2[Paint.Join.BEVEL.ordinal()] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v2[Paint.Join.ROUND.ordinal()] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        f.b = arr_v2;
    }
}

