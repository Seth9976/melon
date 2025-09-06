package j8;

import G.I0;
import X7.e;
import a8.a;
import java.util.Arrays;

public abstract class b {
    public static final int[] a;
    public static final int[][] b;
    public static final int[][] c;
    public static final int[][] d;
    public static final int[][] e;

    static {
        b.a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 0x1F, 0x20, 33, 34, 35, -1, -1, -1, -1, -1};
        b.b = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
        b.c = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
        b.d = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 0x20, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 0x30, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 0x20, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 0x72, -1, -1}, new int[]{6, 34, 62, 90, 0x76, -1, -1}, new int[]{6, 26, 50, 74, 98, 0x7A, -1}, new int[]{6, 30, 54, 78, 102, 0x7E, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 0x86, -1}, new int[]{6, 34, 60, 86, 0x70, 0x8A, -1}, new int[]{6, 30, 58, 86, 0x72, 0x8E, -1}, new int[]{6, 34, 62, 90, 0x76, 0x92, -1}, new int[]{6, 30, 54, 78, 102, 0x7E, 150}, new int[]{6, 24, 50, 76, 102, 0x80, 0x9A}, new int[]{6, 28, 54, 80, 106, 0x84, 0x9E}, new int[]{6, 0x20, 58, 84, 110, 0x88, 0xA2}, new int[]{6, 26, 54, 82, 110, 0x8A, 0xA6}, new int[]{6, 30, 58, 86, 0x72, 0x8E, 170}};
        b.e = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    }

    public static int a(I0 i00, boolean z) {
        int v = i00.b;
        int v1 = i00.c;
        int v2 = z ? v1 : v;
        if(!z) {
            v = v1;
        }
        byte[][] arr2_b = (byte[][])i00.d;
        int v4 = 0;
        for(int v3 = 0; v3 < v2; ++v3) {
            int v5 = -1;
            int v7 = 0;
            for(int v6 = 0; v6 < v; ++v6) {
                int v8 = z ? arr2_b[v3][v6] : arr2_b[v6][v3];
                if(v8 == v5) {
                    ++v7;
                }
                else {
                    if(v7 >= 5) {
                        v4 += v7 - 2;
                    }
                    v7 = 1;
                    v5 = v8;
                }
            }
            if(v7 >= 5) {
                v4 = v7 - 2 + v4;
            }
        }
        return v4;
    }

    public static void b(a a0, int v, i8.b b0, int v1, I0 i00) {
        int v36;
        boolean z2;
        int v15;
        byte[][] arr2_b = (byte[][])i00.d;
        int v2 = i00.b;
        int v3 = i00.c;
        for(int v4 = 0; v4 < arr2_b.length; ++v4) {
            Arrays.fill(arr2_b[v4], -1);
        }
        int v5 = b.b[0].length;
        b.e(0, 0, i00);
        int v6 = v2 - v5;
        b.e(v6, 0, i00);
        b.e(0, v6, i00);
        b.d(0, 7, i00);
        b.d(v2 - 8, 7, i00);
        b.d(0, v2 - 8, i00);
        b.f(7, 0, i00);
        b.f(v3 - 8, 0, i00);
        b.f(7, v3 - 7, i00);
        if(i00.u(8, v3 - 8) == 0) {
            throw new e();  // 初始化器: Ljava/lang/Exception;-><init>()V
        }
        i00.v(8, v3 - 8, 1);
        int v7 = b0.a;
        if(v7 >= 2) {
            int[] arr_v = b.d[v7 - 1];
            for(int v8 = 0; v8 < arr_v.length; ++v8) {
                int v9 = arr_v[v8];
                if(v9 >= 0) {
                    int v10 = arr_v.length;
                    int v11 = 0;
                    while(v11 < v10) {
                        int v12 = arr_v[v11];
                        if(v12 < 0 || !b.g(i00.u(v12, v9))) {
                            v15 = v10;
                        }
                        else {
                            int v13 = v12 - 2;
                            int v14 = v9 - 2;
                            v15 = v10;
                            for(int v16 = 0; v16 < 5; v16 = v17 + 1) {
                                int[] arr_v1 = b.c[v16];
                                int v17 = v16;
                                for(int v18 = 0; v18 < 5; ++v18) {
                                    i00.v(v13 + v18, v14 + v17, arr_v1[v18]);
                                }
                            }
                        }
                        ++v11;
                        v10 = v15;
                    }
                }
            }
        }
        for(int v19 = 8; v19 < v2 - 8; ++v19) {
            int v20 = (v19 + 1) % 2;
            if(b.g(i00.u(v19, 6))) {
                i00.v(v19, 6, v20);
            }
            if(b.g(i00.u(6, v19))) {
                i00.v(6, v19, v20);
            }
        }
        int v21 = 1;
        a a1 = new a();
        if(v1 < 0 || v1 >= 8) {
            throw new e("Invalid mask pattern");  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
        }
        if(v != 1) {
            v21 = 2;
            switch(v) {
                case 2: {
                    v21 = 0;
                    break;
                }
                case 3: {
                    v21 = 3;
                    break;
                }
                case 4: {
                    break;
                }
                default: {
                    throw null;
                }
            }
        }
        int v22 = v21 << 3 | v1;
        a1.b(v22, 5);
        a1.b(b.c(v22, 0x537), 10);
        a a2 = new a();
        a2.b(0x5412, 15);
        if(a1.b != a2.b) {
            throw new IllegalArgumentException("Sizes don\'t match");
        }
        for(int v23 = 0; true; ++v23) {
            int[] arr_v2 = a1.a;
            if(v23 >= arr_v2.length) {
                break;
            }
            arr_v2[v23] ^= a2.a[v23];
        }
        if(a1.b != 15) {
            throw new e("should not happen but we got: " + a1.b);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
        }
        for(int v24 = 0; true; ++v24) {
            int v25 = a1.b;
            if(v24 >= v25) {
                break;
            }
            boolean z = a1.d(v25 - 1 - v24);
            int[] arr_v3 = b.e[v24];
            i00.w(arr_v3[0], arr_v3[1], z);
            if(v24 < 8) {
                i00.w(v2 - v24 - 1, 8, z);
            }
            else {
                i00.w(8, v3 + v24 - 15, z);
            }
        }
        if(v7 >= 7) {
            a a3 = new a();
            a3.b(v7, 6);
            a3.b(b.c(v7, 0x1F25), 12);
            if(a3.b != 18) {
                throw new e("should not happen but we got: " + a3.b);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
            }
            int v26 = 17;
            for(int v27 = 0; v27 < 6; ++v27) {
                for(int v28 = 0; v28 < 3; ++v28) {
                    boolean z1 = a3.d(v26);
                    --v26;
                    int v29 = v3 - 11 + v28;
                    i00.w(v27, v29, z1);
                    i00.w(v29, v27, z1);
                }
            }
        }
        int v30 = v2 - 1;
        int v31 = v3 - 1;
        int v32 = 0;
        int v33 = -1;
        while(v30 > 0) {
            if(v30 == 6) {
                v30 = 5;
            }
            while(v31 >= 0 && v31 < v3) {
                for(int v34 = 0; v34 < 2; ++v34) {
                    int v35 = v30 - v34;
                    if(b.g(i00.u(v35, v31))) {
                        if(v32 < a0.b) {
                            z2 = a0.d(v32);
                            ++v32;
                        }
                        else {
                            z2 = false;
                        }
                        switch(v1) {
                            case 0: {
                                v36 = v31 + v35 & 1;
                                break;
                            }
                            case 1: {
                                v36 = v31 & 1;
                                break;
                            }
                            case 2: {
                                v36 = v35 % 3;
                                break;
                            }
                            case 3: {
                                v36 = (v31 + v35) % 3;
                                break;
                            }
                            case 4: {
                                v36 = v35 / 3 + v31 / 2 & 1;
                                break;
                            }
                            case 5: {
                                v36 = v31 * v35 % 3 + (v31 * v35 & 1);
                                break;
                            }
                            case 6: {
                                v36 = v31 * v35 % 3 + (v31 * v35 & 1) & 1;
                                break;
                            }
                            case 7: {
                                v36 = v31 * v35 % 3 + (v31 + v35 & 1) & 1;
                                break;
                            }
                            default: {
                                throw new IllegalArgumentException("Invalid mask pattern: " + v1);
                            }
                        }
                        if(v36 == 0) {
                            z2 = !z2;
                        }
                        i00.w(v35, v31, z2);
                    }
                }
                v31 += v33;
            }
            v33 = -v33;
            v31 += v33;
            v30 -= 2;
        }
        if(v32 != a0.b) {
            throw new e("Not all bits consumed: " + v32 + '/' + a0.b);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
        }
    }

    public static int c(int v, int v1) {
        if(v1 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int v2 = Integer.numberOfLeadingZeros(v1);
        int v3;
        for(v3 = v << 0x1F - v2; 0x20 - Integer.numberOfLeadingZeros(v3) >= 0x20 - v2; v3 ^= v1 << 0x20 - Integer.numberOfLeadingZeros(v3) - (0x20 - v2)) {
        }
        return v3;
    }

    public static void d(int v, int v1, I0 i00) {
        for(int v2 = 0; v2 < 8; ++v2) {
            int v3 = v + v2;
            if(!b.g(i00.u(v3, v1))) {
                throw new e();  // 初始化器: Ljava/lang/Exception;-><init>()V
            }
            i00.v(v3, v1, 0);
        }
    }

    public static void e(int v, int v1, I0 i00) {
        for(int v2 = 0; v2 < 7; ++v2) {
            int[] arr_v = b.b[v2];
            for(int v3 = 0; v3 < 7; ++v3) {
                i00.v(v + v3, v1 + v2, arr_v[v3]);
            }
        }
    }

    public static void f(int v, int v1, I0 i00) {
        for(int v2 = 0; v2 < 7; ++v2) {
            int v3 = v1 + v2;
            if(!b.g(i00.u(v, v3))) {
                throw new e();  // 初始化器: Ljava/lang/Exception;-><init>()V
            }
            i00.v(v, v3, 0);
        }
    }

    public static boolean g(int v) {
        return v == -1;
    }
}

