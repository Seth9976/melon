package com.iloen.melon.utils.cipher;

import java.lang.reflect.Array;
import java.security.InvalidKeyException;

public final class Rijndael_Algorithm {
    public static final int[] a;
    public static final int[] b;
    public static final byte[] c;
    public static final byte[] d;
    public static final int[] e;
    public static final int[] f;
    public static final int[] g;
    public static final int[] h;
    public static final int[] i;
    public static final int[] j;
    public static final int[] k;
    public static final int[] l;
    public static final int[] m;
    public static final int[] n;
    public static final int[] o;
    public static final int[] p;
    public static final byte[] q;
    public static final int[][][] r;
    public static final char[] s;

    static {
        Rijndael_Algorithm.r = new int[][][]{new int[][]{new int[]{0, 0}, new int[]{1, 3}, new int[]{2, 2}, new int[]{3, 1}}, new int[][]{new int[]{0, 0}, new int[]{1, 5}, new int[]{2, 4}, new int[]{3, 3}}, new int[][]{new int[]{0, 0}, new int[]{1, 7}, new int[]{3, 5}, new int[]{4, 4}}};
        Rijndael_Algorithm.s = new char[]{'O', '\'', 'c', '\u0017', '(', 'ò', '&', '\u008A', 'ù', 'Á', 'k', '±', 'ý', 'u', '­', '`', 'é', 'P', 'Ã', '\u001C', 'f', 'E', '\u0004', '~', '\u0015', '\u0012', '\u0087', 'v', '\u0084', 'D', 'o', '×'};
        int[] arr_v = new int[0x100];
        Rijndael_Algorithm.a = arr_v;
        Rijndael_Algorithm.b = new int[0x100];
        Rijndael_Algorithm.c = new byte[0x100];
        Rijndael_Algorithm.d = new byte[0x100];
        Rijndael_Algorithm.e = new int[0x100];
        Rijndael_Algorithm.f = new int[0x100];
        Rijndael_Algorithm.g = new int[0x100];
        Rijndael_Algorithm.h = new int[0x100];
        Rijndael_Algorithm.i = new int[0x100];
        Rijndael_Algorithm.j = new int[0x100];
        Rijndael_Algorithm.k = new int[0x100];
        Rijndael_Algorithm.l = new int[0x100];
        Rijndael_Algorithm.m = new int[0x100];
        Rijndael_Algorithm.n = new int[0x100];
        Rijndael_Algorithm.o = new int[0x100];
        Rijndael_Algorithm.p = new int[0x100];
        Rijndael_Algorithm.q = new byte[30];
        arr_v[0] = 1;
        for(int v = 1; v < 0x100; ++v) {
            int v1 = Rijndael_Algorithm.a[v - 1];
            int v2 = v1 ^ v1 << 1;
            Rijndael_Algorithm.a[v] = (v2 & 0x100) == 0 ? v1 ^ v1 << 1 : v2 ^ 283;
        }
        for(int v3 = 1; v3 < 0xFF; ++v3) {
            Rijndael_Algorithm.b[Rijndael_Algorithm.a[v3]] = v3;
        }
        byte[][] arr2_b = {new byte[]{1, 1, 1, 1, 1, 0, 0, 0}, new byte[]{0, 1, 1, 1, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 1, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1, 1, 1, 1}, new byte[]{1, 0, 0, 0, 1, 1, 1, 1}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1}, new byte[]{1, 1, 1, 0, 0, 0, 1, 1}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1}};
        Class class0 = Byte.TYPE;
        byte[][] arr2_b1 = (byte[][])Array.newInstance(class0, new int[]{0x100, 8});
        arr2_b1[1][7] = 1;
        for(int v4 = 2; v4 < 0x100; ++v4) {
            int v5 = Rijndael_Algorithm.a[0xFF - Rijndael_Algorithm.b[v4]];
            for(int v6 = 0; v6 < 8; ++v6) {
                arr2_b1[v4][v6] = (byte)(v5 >>> 7 - v6 & 1);
            }
        }
        byte[][] arr2_b2 = (byte[][])Array.newInstance(class0, new int[]{0x100, 8});
        for(int v7 = 0; v7 < 0x100; ++v7) {
            for(int v8 = 0; v8 < 8; ++v8) {
                arr2_b2[v7][v8] = new byte[]{0, 1, 1, 0, 0, 0, 1, 1}[v8];
                for(int v9 = 0; v9 < 8; ++v9) {
                    byte[] arr_b = arr2_b2[v7];
                    arr_b[v8] = (byte)(arr_b[v8] ^ arr2_b[v8][v9] * arr2_b1[v7][v9]);
                }
            }
        }
        for(int v10 = 0; v10 < 0x100; ++v10) {
            Rijndael_Algorithm.c[v10] = (byte)(arr2_b2[v10][0] << 7);
            for(int v11 = 1; v11 < 8; ++v11) {
                Rijndael_Algorithm.c[v10] = (byte)(Rijndael_Algorithm.c[v10] ^ arr2_b2[v10][v11] << 7 - v11);
            }
            Rijndael_Algorithm.d[Rijndael_Algorithm.c[v10] & 0xFF] = (byte)v10;
        }
        byte[][] arr2_b3 = {new byte[]{2, 1, 1, 3}, new byte[]{3, 2, 1, 1}, new byte[]{1, 3, 2, 1}, new byte[]{1, 1, 3, 2}};
        byte[][] arr2_b4 = (byte[][])Array.newInstance(class0, new int[]{4, 8});
        for(int v12 = 0; v12 < 4; ++v12) {
            for(int v13 = 0; v13 < 4; ++v13) {
                arr2_b4[v12][v13] = arr2_b3[v12][v13];
            }
            arr2_b4[v12][v12 + 4] = 1;
        }
        byte[][] arr2_b5 = (byte[][])Array.newInstance(class0, new int[]{4, 4});
        for(int v14 = 0; v14 < 4; ++v14) {
            int v15 = arr2_b4[v14][v14];
            if(v15 == 0) {
                int v16;
                for(v16 = v14 + 1; arr2_b4[v16][v14] == 0 && v16 < 4; ++v16) {
                }
                if(v16 == 4) {
                    throw new RuntimeException("G matrix is not invertible");
                }
                for(int v17 = 0; v17 < 8; ++v17) {
                    byte[] arr_b1 = arr2_b4[v14];
                    byte b = arr_b1[v17];
                    byte[] arr_b2 = arr2_b4[v16];
                    arr_b1[v17] = arr_b2[v17];
                    arr_b2[v17] = b;
                }
                v15 = arr2_b4[v14][v14];
            }
            for(int v18 = 0; v18 < 8; ++v18) {
                byte[] arr_b3 = arr2_b4[v14];
                int v19 = arr_b3[v18];
                if(v19 != 0) {
                    arr_b3[v18] = (byte)Rijndael_Algorithm.a[(Rijndael_Algorithm.b[v19 & 0xFF] + 0xFF - Rijndael_Algorithm.b[v15 & 0xFF]) % 0xFF];
                }
            }
            for(int v20 = 0; v20 < 4; ++v20) {
                if(v14 != v20) {
                    for(int v21 = v14 + 1; v21 < 8; ++v21) {
                        byte[] arr_b4 = arr2_b4[v20];
                        int v22 = arr_b4[v21];
                        int v23 = arr2_b4[v14][v21];
                        int v24 = arr_b4[v14];
                        arr_b4[v21] = (byte)(v22 ^ (v23 == 0 || v24 == 0 ? 0 : Rijndael_Algorithm.a[(Rijndael_Algorithm.b[v23 & 0xFF] + Rijndael_Algorithm.b[v24 & 0xFF]) % 0xFF]));
                    }
                    arr2_b4[v20][v14] = 0;
                }
            }
        }
        for(int v25 = 0; v25 < 4; ++v25) {
            for(int v26 = 0; v26 < 4; ++v26) {
                arr2_b5[v25][v26] = arr2_b4[v25][v26 + 4];
            }
        }
        for(int v27 = 0; v27 < 0x100; ++v27) {
            int v28 = Rijndael_Algorithm.c[v27];
            Rijndael_Algorithm.e[v27] = Rijndael_Algorithm.b(v28, arr2_b3[0]);
            Rijndael_Algorithm.f[v27] = Rijndael_Algorithm.b(v28, arr2_b3[1]);
            Rijndael_Algorithm.g[v27] = Rijndael_Algorithm.b(v28, arr2_b3[2]);
            Rijndael_Algorithm.h[v27] = Rijndael_Algorithm.b(v28, arr2_b3[3]);
            int v29 = Rijndael_Algorithm.d[v27];
            Rijndael_Algorithm.i[v27] = Rijndael_Algorithm.b(v29, arr2_b5[0]);
            Rijndael_Algorithm.j[v27] = Rijndael_Algorithm.b(v29, arr2_b5[1]);
            Rijndael_Algorithm.k[v27] = Rijndael_Algorithm.b(v29, arr2_b5[2]);
            Rijndael_Algorithm.l[v27] = Rijndael_Algorithm.b(v29, arr2_b5[3]);
            Rijndael_Algorithm.m[v27] = Rijndael_Algorithm.b(v27, arr2_b5[0]);
            Rijndael_Algorithm.n[v27] = Rijndael_Algorithm.b(v27, arr2_b5[1]);
            Rijndael_Algorithm.o[v27] = Rijndael_Algorithm.b(v27, arr2_b5[2]);
            Rijndael_Algorithm.p[v27] = Rijndael_Algorithm.b(v27, arr2_b5[3]);
        }
        Rijndael_Algorithm.q[0] = 1;
        int v30 = 1;
        for(int v31 = 1; v31 < 30; ++v31) {
            v30 = v30 == 0 ? 0 : Rijndael_Algorithm.a[(Rijndael_Algorithm.b[v30 & 0xFF] + 25) % 0xFF];
            Rijndael_Algorithm.q[v31] = (byte)v30;
        }
    }

    public static byte[] Encrypt(byte[] arr_b, int v, int v1, int v2) {
        int v9;
        Object object0;
        int v7;
        String s;
        byte[] arr_b1 = new byte[v1 + 0x80];
        for(int v3 = 0; v3 < v1 + 0x80; ++v3) {
            arr_b1[v3] = 0;
        }
        char[] arr_c = new char[0x20];
        byte[] arr_b2 = new byte[16];
        byte[] arr_b3 = new byte[16];
        if(v1 >= 16 && v2 >= 0 && v2 <= 0x40) {
            int v4 = v2 & 1;
            int v5 = 0x40 - (v2 >> 1);
            int v6 = v4 > 0 ? 17 : 16;
            if(v5 >= ((byte)v6)) {
                s = "O\'c\u0017(ò&\u008AùÁk±ýu­`éPÃ\u001CfE\u0004~\u0015\u0012\u0087v\u0084Do×".substring(v2 >> 1, (v2 >> 1) + ((byte)v6) + 1);
            }
            else {
                s = "O\'c\u0017(ò&\u008AùÁk±ýu­`éPÃ\u001CfE\u0004~\u0015\u0012\u0087v\u0084Do×".substring(v2 >> 1, v5);
                s.concat("O\'c\u0017(ò&\u008AùÁk±ýu­`éPÃ\u001CfE\u0004~\u0015\u0012\u0087v\u0084Do×".substring(0, ((byte)v6) - v5 + 1));
            }
            char[] arr_c1 = s.toCharArray();
            if(v4 > 0) {
                arr_c[0] = Rijndael_Algorithm.a(arr_c1[0] & 15);
                v7 = 1;
            }
            else {
                v7 = 0;
            }
            while(v4 < ((byte)v6)) {
                int v8 = v7 + 1;
                arr_c[v7] = Rijndael_Algorithm.a(arr_c1[v4] >> 4);
                v7 += 2;
                arr_c[v8] = Rijndael_Algorithm.a(arr_c1[v4] & 15);
                ++v4;
            }
            try {
                object0 = Rijndael_Algorithm.makeKey(new String(arr_c).getBytes(), 16);
                v9 = 0;
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
                return "MAKEKEY ERROR".getBytes();
            }
            do {
                for(int v10 = 0; v10 < 16; ++v10) {
                    arr_b2[v10] = 0;
                }
                for(int v11 = 0; v11 < 16; ++v11) {
                    arr_b3[v11] = 0;
                }
                if(v - v9 >= 16) {
                    int v12 = v9;
                    int v13 = 0;
                    while(v13 < 16) {
                        arr_b2[v13] = arr_b[v12];
                        ++v13;
                        ++v12;
                    }
                }
                else {
                    int v14 = v9;
                    for(int v15 = 0; v15 < 16; ++v15) {
                        if(v14 < v) {
                            arr_b2[v15] = arr_b[v14];
                            ++v14;
                        }
                        else {
                            arr_b2[v15] = 0;
                        }
                    }
                }
                arr_b3 = Rijndael_Algorithm.blockEncrypt(arr_b2, 0, object0, 16);
                int v16 = v9;
                for(int v17 = 0; v17 < 16; ++v17) {
                    arr_b1[v16] = arr_b3[v17];
                    ++v16;
                }
                v9 += 16;
            }
            while(v9 < v);
            return arr_b1;
        }
        return "WRONG INPUT DATA".getBytes();
    }

    public static byte[] Encrypt_String(byte[] arr_b, int v) {
        int v3;
        int v1 = 0;
        int v2 = 16;
        if(v >= 16) {
            if(v % 16 == 0) {
                v2 = 16 * (v / 16);
            }
            else if(v % 16 > 0) {
                v2 = 16 * (v / 16 + 1);
            }
            else {
                v2 = 0;
            }
        }
        if(v2 % 3 == 0) {
            v3 = v2 / 3 * 4;
        }
        else if(v2 % 3 > 0) {
            v3 = (v2 / 3 + 1) * 4;
        }
        else {
            v3 = 0;
        }
        byte[] arr_b1 = new byte[v2];
        for(int v4 = 0; v4 < v2; ++v4) {
            arr_b1[v4] = 0;
        }
        byte[] arr_b2 = new byte[v];
        for(int v5 = 0; v5 < v; ++v5) {
            arr_b2[v5] = arr_b[v5];
        }
        byte[] arr_b3 = Rijndael_Algorithm.Encrypt(arr_b2, v, v2, 0);
        byte[] arr_b4 = new byte[v2];
        for(int v6 = 0; v6 < v2; ++v6) {
            arr_b4[v6] = 0;
        }
        for(int v7 = 0; v7 < v2; ++v7) {
            arr_b4[v7] = arr_b3[v7];
        }
        new char[v3];
        char[] arr_c = b64.b64encode_str(arr_b4, v2);
        byte[] arr_b5 = new byte[v3];
        for(int v8 = 0; v8 < v3; ++v8) {
            arr_b5[v8] = 0;
        }
        while(v1 < v3) {
            byte b = (byte)arr_c[v1];
            arr_b5[v1] = b;
            if(b >= 0 && b <= 0x7F) {
                ++v1;
                continue;
            }
            return new byte[]{69, 82, 82, 0x4F, 82, 0};
        }
        return arr_b5;
    }

    public static final char[] MakeCipherKey(char[] arr_c, int v) {
        int v6;
        int v4;
        char[] arr_c1 = new char[v];
        int v1 = -1;
        for(int v2 = 0; v2 < v; ++v2) {
            int v3 = arr_c[v1 + 1];
            v1 += 2;
            if(v3 >= 0x30 && v3 <= 57) {
                v4 = v3 - 0x30;
            }
            else if(v3 < 97 || v3 > 102) {
                if(v3 < 65 || v3 > 70) {
                    return new char[]{'\u0000', '\u0000'};
                }
                v4 = v3 - 55;
            }
            else {
                v4 = v3 - 87;
            }
            int v5 = arr_c[v1];
            if(v5 >= 0x30 && v5 <= 57) {
                v6 = v5 - 0x30;
            }
            else if(v5 < 97 || v5 > 102) {
                if(v5 < 65 || v5 > 70) {
                    return new char[]{'\u0000', '\u0000'};
                }
                v6 = v5 - 55;
            }
            else {
                v6 = v5 - 87;
            }
            arr_c1[v2] = (char)(v4 << 4 ^ v6);
        }
        return arr_c1;
    }

    public static void Print_Usage() {
    }

    public static char a(int v) {
        return (v & 15) < 10 ? ((char)((v & 15) + 0x30)) : ((char)((v & 15) + 87));
    }

    public static final int b(int v, byte[] arr_b) {
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        int[] arr_v = Rijndael_Algorithm.b;
        int v2 = arr_v[v & 0xFF];
        int v3 = arr_b[0];
        int[] arr_v1 = Rijndael_Algorithm.a;
        int v4 = v3 == 0 ? 0 : arr_v1[(arr_v[v3 & 0xFF] + v2) % 0xFF] & 0xFF;
        int v5 = arr_b[1];
        int v6 = v5 == 0 ? 0 : arr_v1[(arr_v[v5 & 0xFF] + v2) % 0xFF] & 0xFF;
        int v7 = arr_b[2];
        int v8 = v7 == 0 ? 0 : arr_v1[(arr_v[v7 & 0xFF] + v2) % 0xFF] & 0xFF;
        int v9 = arr_b[3];
        if(v9 != 0) {
            v1 = arr_v1[(v2 + arr_v[v9 & 0xFF]) % 0xFF] & 0xFF;
        }
        return v4 << 24 | v6 << 16 | v8 << 8 | v1;
    }

    public static byte[] blockEncrypt(byte[] arr_b, int v, Object object0) {
        int[][] arr2_v = (int[][])((Object[])object0)[0];
        int v1 = arr2_v.length - 1;
        int[] arr_v = arr2_v[0];
        int v2 = ((arr_b[v + 1] & 0xFF) << 16 | (arr_b[v] & 0xFF) << 24 | (arr_b[v + 2] & 0xFF) << 8 | arr_b[v + 3] & 0xFF) ^ arr_v[0];
        int v3 = ((arr_b[v + 5] & 0xFF) << 16 | (arr_b[v + 4] & 0xFF) << 24 | (arr_b[v + 6] & 0xFF) << 8 | arr_b[v + 7] & 0xFF) ^ arr_v[1];
        int v4 = ((arr_b[v + 9] & 0xFF) << 16 | (arr_b[v + 8] & 0xFF) << 24 | (arr_b[v + 10] & 0xFF) << 8 | arr_b[v + 11] & 0xFF) ^ arr_v[2];
        int v5 = arr_v[3] ^ ((arr_b[v + 12] & 0xFF) << 24 | (arr_b[v + 13] & 0xFF) << 16 | (arr_b[v + 14] & 0xFF) << 8 | arr_b[v + 15] & 0xFF);
        int v6 = 1;
        while(v6 < v1) {
            int[] arr_v1 = arr2_v[v6];
            int v7 = Rijndael_Algorithm.f[v3 >>> 16 & 0xFF] ^ Rijndael_Algorithm.e[v2 >>> 24 & 0xFF] ^ Rijndael_Algorithm.g[v4 >>> 8 & 0xFF] ^ Rijndael_Algorithm.h[v5 & 0xFF] ^ arr_v1[0];
            int v8 = Rijndael_Algorithm.f[v4 >>> 16 & 0xFF] ^ Rijndael_Algorithm.e[v3 >>> 24 & 0xFF] ^ Rijndael_Algorithm.g[v5 >>> 8 & 0xFF] ^ Rijndael_Algorithm.h[v2 & 0xFF] ^ arr_v1[1];
            int v9 = Rijndael_Algorithm.f[v5 >>> 16 & 0xFF] ^ Rijndael_Algorithm.e[v4 >>> 24 & 0xFF] ^ Rijndael_Algorithm.g[v2 >>> 8 & 0xFF] ^ Rijndael_Algorithm.h[v3 & 0xFF] ^ arr_v1[2];
            v5 = Rijndael_Algorithm.e[v5 >>> 24 & 0xFF] ^ Rijndael_Algorithm.f[v2 >>> 16 & 0xFF] ^ Rijndael_Algorithm.g[v3 >>> 8 & 0xFF] ^ Rijndael_Algorithm.h[v4 & 0xFF] ^ arr_v1[3];
            ++v6;
            v2 = v7;
            v3 = v8;
            v4 = v9;
        }
        int[] arr_v2 = arr2_v[v1];
        int v10 = arr_v2[0];
        byte b = (byte)(Rijndael_Algorithm.c[v2 >>> 24 & 0xFF] ^ v10 >>> 24);
        byte b1 = (byte)(Rijndael_Algorithm.c[v3 >>> 16 & 0xFF] ^ v10 >>> 16);
        byte b2 = (byte)(Rijndael_Algorithm.c[v4 >>> 8 & 0xFF] ^ v10 >>> 8);
        byte b3 = (byte)(v10 ^ Rijndael_Algorithm.c[v5 & 0xFF]);
        int v11 = arr_v2[1];
        byte b4 = (byte)(Rijndael_Algorithm.c[v3 >>> 24 & 0xFF] ^ v11 >>> 24);
        byte b5 = (byte)(Rijndael_Algorithm.c[v4 >>> 16 & 0xFF] ^ v11 >>> 16);
        byte b6 = (byte)(Rijndael_Algorithm.c[v5 >>> 8 & 0xFF] ^ v11 >>> 8);
        byte b7 = (byte)(Rijndael_Algorithm.c[v2 & 0xFF] ^ v11);
        int v12 = arr_v2[2];
        byte b8 = (byte)(Rijndael_Algorithm.c[v4 >>> 24 & 0xFF] ^ v12 >>> 24);
        byte b9 = (byte)(Rijndael_Algorithm.c[v5 >>> 16 & 0xFF] ^ v12 >>> 16);
        byte b10 = (byte)(Rijndael_Algorithm.c[v2 >>> 8 & 0xFF] ^ v12 >>> 8);
        byte b11 = (byte)(Rijndael_Algorithm.c[v3 & 0xFF] ^ v12);
        int v13 = arr_v2[3];
        return new byte[]{b, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, ((byte)(Rijndael_Algorithm.c[v5 >>> 24 & 0xFF] ^ v13 >>> 24)), ((byte)(Rijndael_Algorithm.c[v2 >>> 16 & 0xFF] ^ v13 >>> 16)), ((byte)(Rijndael_Algorithm.c[v3 >>> 8 & 0xFF] ^ v13 >>> 8)), ((byte)(Rijndael_Algorithm.c[v4 & 0xFF] ^ v13))};
    }

    public static byte[] blockEncrypt(byte[] arr_b, int v, Object object0, int v1) {
        int v4;
        if(v1 == 16) {
            return Rijndael_Algorithm.blockEncrypt(arr_b, v, object0);
        }
        int[][] arr2_v = (int[][])((Object[])object0)[0];
        int v3 = arr2_v.length - 1;
        switch(v1 / 4) {
            case 4: {
                v4 = 0;
                break;
            }
            case 6: {
                v4 = 1;
                break;
            }
            default: {
                v4 = 2;
            }
        }
        int[][] arr2_v1 = Rijndael_Algorithm.r[v4];
        int v5 = arr2_v1[1][0];
        int v6 = arr2_v1[2][0];
        int v7 = arr2_v1[3][0];
        int[] arr_v = new int[v1 / 4];
        int[] arr_v1 = new int[v1 / 4];
        byte[] arr_b1 = new byte[v1];
        int v8 = v;
        for(int v9 = 0; v9 < v1 / 4; ++v9) {
            int v10 = v8 + 3;
            int v11 = (arr_b[v8] & 0xFF) << 24 | (arr_b[v8 + 1] & 0xFF) << 16 | (arr_b[v8 + 2] & 0xFF) << 8;
            v8 += 4;
            arr_v1[v9] = (v11 | arr_b[v10] & 0xFF) ^ arr2_v[0][v9];
        }
        for(int v12 = 1; v12 < v3; ++v12) {
            for(int v13 = 0; v13 < v1 / 4; ++v13) {
                arr_v[v13] = Rijndael_Algorithm.e[arr_v1[v13] >>> 24 & 0xFF] ^ Rijndael_Algorithm.f[arr_v1[(v13 + v5) % (v1 / 4)] >>> 16 & 0xFF] ^ Rijndael_Algorithm.g[arr_v1[(v13 + v6) % (v1 / 4)] >>> 8 & 0xFF] ^ Rijndael_Algorithm.h[arr_v1[(v13 + v7) % (v1 / 4)] & 0xFF] ^ arr2_v[v12][v13];
            }
            System.arraycopy(arr_v, 0, arr_v1, 0, v1 / 4);
        }
        int v14 = 0;
        for(int v2 = 0; v2 < v1 / 4; ++v2) {
            int v15 = arr2_v[v3][v2];
            arr_b1[v14] = (byte)(Rijndael_Algorithm.c[arr_v1[v2] >>> 24 & 0xFF] ^ v15 >>> 24);
            arr_b1[v14 + 1] = (byte)(Rijndael_Algorithm.c[arr_v1[(v2 + v5) % (v1 / 4)] >>> 16 & 0xFF] ^ v15 >>> 16);
            int v16 = v14 + 3;
            arr_b1[v14 + 2] = (byte)(Rijndael_Algorithm.c[arr_v1[(v2 + v6) % (v1 / 4)] >>> 8 & 0xFF] ^ v15 >>> 8);
            v14 += 4;
            arr_b1[v16] = (byte)(v15 ^ Rijndael_Algorithm.c[arr_v1[(v2 + v7) % (v1 / 4)] & 0xFF]);
        }
        return arr_b1;
    }

    public static int blockSize() {
        return 16;
    }

    public static int getRounds(int v, int v1) {
        int v2 = 12;
        switch(v) {
            case 16: {
                switch(v1) {
                    case 16: {
                        return 10;
                    }
                    case 24: {
                        break;
                    }
                    default: {
                        v2 = 14;
                        break;
                    }
                }
                return (byte)v2;
            }
            case 24: {
                return v1 == 0x20 ? 14 : 12;
            }
            default: {
                return 14;
            }
        }
    }

    public static Object makeKey(byte[] arr_b) {
        return Rijndael_Algorithm.makeKey(arr_b, 16);
    }

    public static Object makeKey(byte[] arr_b, int v) {
        synchronized(Rijndael_Algorithm.class) {
            char[] arr_c = new char[arr_b.length];
            for(int v2 = 0; v2 < arr_b.length; ++v2) {
                arr_c[v2] = (char)arr_b[v2];
            }
            for(int v3 = 0; v3 < arr_b.length; ++v3) {
                arr_b[v3] = 0;
            }
            char[] arr_c1 = Rijndael_Algorithm.MakeCipherKey(arr_c, 16);
            if(arr_c1 != null) {
                if(arr_c1[0] == 0 && arr_c1.length == 0) {
                    throw new InvalidKeyException("BAD_KEY_MAT");
                }
                if(arr_c1.length != 16 && arr_c1.length != 24 && arr_c1.length != 0x20) {
                    throw new InvalidKeyException("Incorrect key length");
                }
                int v4 = Rijndael_Algorithm.getRounds(arr_c1.length, v);
                int[] arr_v = new int[2];
                arr_v[1] = v / 4;
                arr_v[0] = v4 + 1;
                Class class1 = Integer.TYPE;
                int[][] arr2_v = (int[][])Array.newInstance(class1, arr_v);
                int[][] arr2_v1 = (int[][])Array.newInstance(class1, new int[]{v4 + 1, v / 4});
                int v6 = (v4 + 1) * (v / 4);
                int v7 = arr_c1.length / 4;
                int[] arr_v1 = new int[v7];
                int v9 = 0;
                for(int v8 = 0; v8 < v7; ++v8) {
                    int v10 = v9 + 3;
                    int v11 = (arr_c1[v9] & 0xFF) << 24 | (arr_c1[v9 + 1] & 0xFF) << 16 | (arr_c1[v9 + 2] & 0xFF) << 8;
                    v9 += 4;
                    arr_v1[v8] = v11 | arr_c1[v10] & 0xFF;
                }
                int v12 = 0;
                int v13;
                for(v13 = 0; v12 < v7 && v13 < v6; ++v13) {
                    arr2_v[v13 / (v / 4)][v13 % (v / 4)] = arr_v1[v12];
                    arr2_v1[v4 - v13 / (v / 4)][v13 % (v / 4)] = arr_v1[v12];
                    ++v12;
                }
                for(int v14 = 0; v13 < v6; ++v14) {
                    int v15 = arr_v1[v7 - 1];
                    arr_v1[0] ^= (Rijndael_Algorithm.q[v14] & 0xFF) << 24 ^ (Rijndael_Algorithm.c[v15 >>> 24 & 0xFF] & 0xFF ^ ((Rijndael_Algorithm.c[v15 >>> 8 & 0xFF] & 0xFF) << 16 ^ (Rijndael_Algorithm.c[v15 >>> 16 & 0xFF] & 0xFF) << 24 ^ (Rijndael_Algorithm.c[v15 & 0xFF] & 0xFF) << 8));
                    if(v7 == 8) {
                        int v19 = 1;
                        for(int v18 = 0; v19 < 4; ++v18) {
                            arr_v1[v19] ^= arr_v1[v18];
                            ++v19;
                        }
                        int v20 = arr_v1[3];
                        arr_v1[4] ^= (Rijndael_Algorithm.c[v20 >>> 24 & 0xFF] & 0xFF) << 24 ^ (Rijndael_Algorithm.c[v20 & 0xFF] & 0xFF ^ (Rijndael_Algorithm.c[v20 >>> 8 & 0xFF] & 0xFF) << 8 ^ (Rijndael_Algorithm.c[v20 >>> 16 & 0xFF] & 0xFF) << 16);
                        int v22 = 5;
                        for(int v21 = 4; v22 < 8; ++v21) {
                            arr_v1[v22] ^= arr_v1[v21];
                            ++v22;
                        }
                    }
                    else {
                        int v16 = 1;
                        for(int v17 = 0; v16 < v7; ++v17) {
                            arr_v1[v16] ^= arr_v1[v17];
                            ++v16;
                        }
                    }
                    int v23 = 0;
                    while(v23 < v7 && v13 < v6) {
                        arr2_v[v13 / (v / 4)][v13 % (v / 4)] = arr_v1[v23];
                        arr2_v1[v4 - v13 / (v / 4)][v13 % (v / 4)] = arr_v1[v23];
                        ++v23;
                        ++v13;
                    }
                }
                for(int v5 = 1; v5 < v4; ++v5) {
                    for(int v24 = 0; v24 < v / 4; ++v24) {
                        int[] arr_v2 = arr2_v1[v5];
                        int v25 = arr_v2[v24];
                        arr_v2[v24] = Rijndael_Algorithm.p[v25 & 0xFF] ^ (Rijndael_Algorithm.m[v25 >>> 24 & 0xFF] ^ Rijndael_Algorithm.n[v25 >>> 16 & 0xFF] ^ Rijndael_Algorithm.o[v25 >>> 8 & 0xFF]);
                    }
                }
                return new Object[]{arr2_v, arr2_v1};
            }
        }
        throw new InvalidKeyException("Empty keyMaterial");
    }
}

