package e8;

import X7.b;
import X7.c;
import d5.t;

public abstract class h extends t {
    public static final int[] i;
    public static final int[] j;
    public static final int[] k;
    public static final int[][] l;
    public static final int[][] m;

    static {
        h.i = new int[]{1, 1, 1};
        h.j = new int[]{1, 1, 1, 1, 1};
        h.k = new int[]{1, 1, 1, 1, 1, 1};
        int[][] arr2_v = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        h.l = arr2_v;
        int[][] arr2_v1 = new int[20][];
        h.m = arr2_v1;
        System.arraycopy(arr2_v, 0, arr2_v1, 0, 10);
        for(int v = 10; v < 20; ++v) {
            int[] arr_v = h.l[v - 10];
            int[] arr_v1 = new int[arr_v.length];
            for(int v1 = 0; v1 < arr_v.length; ++v1) {
                arr_v1[v1] = arr_v[arr_v.length - v1 - 1];
            }
            h.m[v] = arr_v1;
        }
    }

    public static boolean u(String s) {
        int v = s.length();
        return v != 0 && h.v(s.subSequence(0, v - 1)) == Character.digit(s.charAt(v - 1), 10);
    }

    public static int v(CharSequence charSequence0) {
        int v = charSequence0.length();
        int v1 = v - 1;
        int v2 = 0;
        while(v1 >= 0) {
            int v3 = charSequence0.charAt(v1);
            if(v3 - 0x30 < 0 || v3 - 0x30 > 9) {
                throw c.a ? new b() : b.c;  // 初始化器: Ljava/lang/Exception;-><init>()V
            }
            v2 += v3 - 0x30;
            v1 -= 2;
        }
        int v4 = v2 * 3;
        for(int v5 = v - 2; v5 >= 0; v5 -= 2) {
            int v6 = charSequence0.charAt(v5);
            if(v6 - 0x30 < 0 || v6 - 0x30 > 9) {
                throw c.a ? new b() : b.c;  // 初始化器: Ljava/lang/Exception;-><init>()V
            }
            v4 += v6 - 0x30;
        }
        return (1000 - v4) % 10;
    }
}

