package e8;

import d5.t;

public abstract class a extends t {
    public static final char[] i;
    public static final int[] j;

    static {
        a.i = "0123456789-$:/.+ABCD".toCharArray();
        a.j = new int[]{3, 6, 9, 0x60, 18, 66, 33, 36, 0x30, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    }

    public static boolean u(char c, char[] arr_c) {
        for(int v = 0; v < arr_c.length; ++v) {
            if(arr_c[v] == c) {
                return true;
            }
        }
        return false;
    }
}

