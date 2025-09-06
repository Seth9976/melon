package i.n.i.b.a.s.e;

import java.math.RoundingMode;

public abstract class sc {
    public static final int[] a;

    static {
        int[] arr_v = new int[RoundingMode.values().length];
        sc.a = arr_v;
        try {
            arr_v[RoundingMode.UNNECESSARY.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            sc.a[RoundingMode.DOWN.ordinal()] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            sc.a[RoundingMode.FLOOR.ordinal()] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            sc.a[RoundingMode.UP.ordinal()] = 4;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            sc.a[RoundingMode.CEILING.ordinal()] = 5;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            sc.a[RoundingMode.HALF_DOWN.ordinal()] = 6;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            sc.a[RoundingMode.HALF_UP.ordinal()] = 7;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            sc.a[RoundingMode.HALF_EVEN.ordinal()] = 8;
        }
        catch(NoSuchFieldError unused_ex) {
        }
    }
}

