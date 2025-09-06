package De;

public abstract class z {
    public static final int[] a;

    static {
        int[] arr_v = new int[B.values().length];
        try {
            arr_v[0] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[1] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[2] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        z.a = arr_v;
    }
}

