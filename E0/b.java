package e0;

public abstract class b {
    public static final int[] a;

    static {
        b.a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 0x1F, 0x20, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 0x2F, 0x30};
    }

    public static boolean a(int v, int v1) {
        if(v == 0) {
            throw null;
        }
        return v == v1;
    }

    public static int b(int v) {
        if(v == 0) {
            throw null;
        }
        return v - 1;
    }

    public static int[] c(int v) {
        int[] arr_v = new int[v];
        System.arraycopy(b.a, 0, arr_v, 0, v);
        return arr_v;
    }
}

