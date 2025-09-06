package g8;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public abstract class b {
    public static final byte[] a;
    public static final byte[] b;
    public static final byte[] c;
    public static final byte[] d;
    public static final Charset e;

    static {
        b.a = new byte[]{0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 0x2F, 43, 37, 42, 61, 94, 0, 0x20, 0, 0, 0};
        b.b = new byte[]{59, 60, 62, 0x40, 91, 92, 93, 0x5F, 0x60, 0x7E, 33, 13, 9, 44, 58, 10, 45, 46, 36, 0x2F, 34, 0x7C, 42, 40, 41, 0x3F, 0x7B, 0x7D, 39, 0};
        byte[] arr_b = new byte[0x80];
        b.c = arr_b;
        b.d = new byte[0x80];
        b.e = StandardCharsets.ISO_8859_1;
        Arrays.fill(arr_b, -1);
        for(int v1 = 0; true; ++v1) {
            byte[] arr_b1 = b.a;
            if(v1 >= arr_b1.length) {
                break;
            }
            int v2 = arr_b1[v1];
            if(v2 > 0) {
                b.c[v2] = (byte)v1;
            }
        }
        Arrays.fill(b.d, -1);
        for(int v = 0; true; ++v) {
            byte[] arr_b2 = b.b;
            if(v >= arr_b2.length) {
                break;
            }
            int v3 = arr_b2[v];
            if(v3 > 0) {
                b.d[v3] = (byte)v;
            }
        }
    }

    public static void a(byte[] arr_b, int v, int v1, StringBuilder stringBuilder0) {
        if(v == 1 && v1 == 0) {
            stringBuilder0.append('Α');
        }
        else if(v % 6 == 0) {
            stringBuilder0.append('Μ');
        }
        else {
            stringBuilder0.append('΅');
        }
        int v2 = 0;
        if(v >= 6) {
            char[] arr_c = new char[5];
            int v3;
            for(v3 = 0; v - v3 >= 6; v3 += 6) {
                long v4 = 0L;
                for(int v5 = 0; v5 < 6; ++v5) {
                    v4 = (v4 << 8) + ((long)(arr_b[v3 + v5] & 0xFF));
                }
                for(int v6 = 0; v6 < 5; ++v6) {
                    arr_c[v6] = (char)(((int)(v4 % 900L)));
                    v4 /= 900L;
                }
                for(int v7 = 4; v7 >= 0; --v7) {
                    stringBuilder0.append(arr_c[v7]);
                }
            }
            v2 = v3;
        }
        while(v2 < v) {
            stringBuilder0.append(((char)(arr_b[v2] & 0xFF)));
            ++v2;
        }
    }

    public static void b(int v, int v1, String s, StringBuilder stringBuilder0) {
        StringBuilder stringBuilder1 = new StringBuilder(v1 / 3 + 1);
        BigInteger bigInteger0 = BigInteger.valueOf(900L);
        BigInteger bigInteger1 = BigInteger.valueOf(0L);
        for(int v2 = 0; v2 < v1; v2 += v3) {
            stringBuilder1.setLength(0);
            int v3 = Math.min(44, v1 - v2);
            BigInteger bigInteger2 = new BigInteger("1" + s.substring(v + v2, v + v2 + v3));
            do {
                stringBuilder1.append(((char)bigInteger2.mod(bigInteger0).intValue()));
                bigInteger2 = bigInteger2.divide(bigInteger0);
            }
            while(!bigInteger2.equals(bigInteger1));
            for(int v4 = stringBuilder1.length() - 1; v4 >= 0; --v4) {
                stringBuilder0.append(stringBuilder1.charAt(v4));
            }
        }
    }

    public static int c(String s, int v, int v1, StringBuilder stringBuilder0, int v2) {
        int v11;
        StringBuilder stringBuilder1 = new StringBuilder(v1);
        int v3 = v2;
        int v4 = 0;
        while(true) {
            int v5 = v + v4;
            int v6 = s.charAt(v5);
            byte[] arr_b = b.c;
            byte[] arr_b1 = b.d;
            switch(v3) {
                case 0: {
                label_14:
                    if(b.e(((char)v6))) {
                        if(v6 == 0x20) {
                            stringBuilder1.append('\u001A');
                        }
                        else {
                            stringBuilder1.append(((char)(v6 - 65)));
                        }
                        break;
                    }
                    else if(b.d(((char)v6))) {
                        stringBuilder1.append('\u001B');
                        v3 = 1;
                        continue;
                    }
                    else if(arr_b[v6] == -1) {
                        stringBuilder1.append('\u001D');
                        stringBuilder1.append(((char)arr_b1[v6]));
                        break;
                    }
                    else {
                        stringBuilder1.append('\u001C');
                        v3 = 2;
                        continue;
                    }
                    goto label_31;
                }
                case 1: {
                label_31:
                    if(b.d(((char)v6))) {
                        if(v6 == 0x20) {
                            stringBuilder1.append('\u001A');
                        }
                        else {
                            stringBuilder1.append(((char)(v6 - 97)));
                        }
                        break;
                    }
                    else if(b.e(((char)v6))) {
                        stringBuilder1.append('\u001B');
                        stringBuilder1.append(((char)(v6 - 65)));
                        break;
                    }
                    else if(arr_b[v6] == -1) {
                        stringBuilder1.append('\u001D');
                        stringBuilder1.append(((char)arr_b1[v6]));
                        break;
                    }
                    else {
                        stringBuilder1.append('\u001C');
                        v3 = 2;
                        continue;
                    }
                    goto label_48;
                }
                case 2: {
                label_48:
                    int v7 = arr_b[v6];
                    if(v7 != -1) {
                        stringBuilder1.append(((char)v7));
                    }
                    else if(b.e(((char)v6))) {
                        stringBuilder1.append('\u001C');
                        v3 = 0;
                        continue;
                    }
                    else if(b.d(((char)v6))) {
                        stringBuilder1.append('\u001B');
                        v3 = 1;
                        continue;
                    }
                    else if(v5 + 1 >= v1 || arr_b1[s.charAt(v5 + 1)] == -1) {
                        stringBuilder1.append('\u001D');
                        stringBuilder1.append(((char)arr_b1[v6]));
                    }
                    else {
                        stringBuilder1.append('\u0019');
                        v3 = 3;
                        continue;
                    }
                    break;
                }
                default: {
                    if(arr_b1[v6] == -1) {
                        stringBuilder1.append('\u001D');
                        v3 = 0;
                        continue;
                    }
                    else {
                        stringBuilder1.append(((char)arr_b1[v6]));
                        break;
                    }
                    goto label_14;
                }
            }
            ++v4;
            if(v4 >= v1) {
                break;
            }
        }
        int v8 = stringBuilder1.length();
        int v10 = 0;
        for(int v9 = 0; v9 < v8; ++v9) {
            if(v9 % 2 == 0) {
                v11 = stringBuilder1.charAt(v9);
            }
            else {
                v11 = (char)(stringBuilder1.charAt(v9) + v10 * 30);
                stringBuilder0.append(((char)v11));
            }
            v10 = v11;
        }
        if(v8 % 2 != 0) {
            stringBuilder0.append(((char)(v10 * 30 + 29)));
        }
        return v3;
    }

    public static boolean d(char c) {
        return c == 0x20 || c >= 97 && c <= 0x7A;
    }

    public static boolean e(char c) {
        return c == 0x20 || c >= 65 && c <= 90;
    }
}

