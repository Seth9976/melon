package androidx.lifecycle;

public abstract class g {
    public static final int[] a;

    static {
        int[] arr_v = new int[r.values().length];
        try {
            arr_v[r.ON_CREATE.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[r.ON_START.ordinal()] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[r.ON_RESUME.ordinal()] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[r.ON_PAUSE.ordinal()] = 4;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[r.ON_STOP.ordinal()] = 5;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[r.ON_DESTROY.ordinal()] = 6;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[r.ON_ANY.ordinal()] = 7;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        g.a = arr_v;
    }
}

