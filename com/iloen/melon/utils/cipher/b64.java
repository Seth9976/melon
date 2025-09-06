package com.iloen.melon.utils.cipher;

public final class b64 {
    public static final byte[] a;
    public static final byte[] b;

    static {
        b64.a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 0x4F, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 120, 0x79, 0x7A, 0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 0x2F};
        b64.b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 0x3F, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 0x1F, 0x20, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 0x2F, 0x30, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    public static char[] b64decode_str(byte[] arr_b, int v) {
        byte[] arr_b1 = new byte[4];
        byte[] arr_b2 = new byte[3];
        byte[] arr_b3 = new byte[v];
        if(arr_b[0] == 0) {
            return new char[]{'E', 'R', 'R', 'O', 'R', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};
        }
        for(int v2 = 0; v2 < 4; ++v2) {
            if(v2 < 3) {
                arr_b2[v2] = 0;
            }
            arr_b1[v2] = 0;
        }
        int v4 = 0;
        int v5 = 0;
    alab1:
        for(int v3 = 0; v3 < v; ++v3) {
            int v6 = arr_b[v3];
            if(v6 == 61) {
                switch(v4) {
                    case 0: {
                        break alab1;
                    }
                    case 1: {
                        byte b2 = (byte)(arr_b1[0] << 2);
                        arr_b2[0] = b2;
                        arr_b3[v5] = b2;
                        ++v5;
                        break alab1;
                    }
                    case 2: {
                        byte b3 = (byte)(arr_b1[0] << 2);
                        arr_b2[0] = b3;
                        int v10 = arr_b1[1];
                        byte b4 = (byte)(b3 | ((byte)(v10 >> 4 & 15)));
                        arr_b2[0] = b4;
                        arr_b2[1] = (byte)(v10 << 4 & 15);
                        int v11 = v5 + 1;
                        arr_b3[v5] = b4;
                        v5 += 2;
                        arr_b3[v11] = arr_b2[1];
                        break alab1;
                    }
                    default: {
                        byte b = (byte)(arr_b1[0] << 2);
                        arr_b2[0] = b;
                        int v7 = arr_b1[1];
                        byte b1 = (byte)(b | ((byte)(v7 >> 4 & 15)));
                        arr_b2[0] = b1;
                        arr_b2[1] = (byte)(v7 << 4);
                        int v8 = arr_b1[2];
                        arr_b2[1] = (byte)(((byte)(v7 << 4)) | ((byte)(v8 >> 2 & 0x3F)));
                        arr_b2[2] = (byte)(v8 << 6);
                        arr_b3[v5] = b1;
                        int v9 = v5 + 2;
                        arr_b3[v5 + 1] = arr_b2[1];
                        v5 += 3;
                        arr_b3[v9] = arr_b2[2];
                        break alab1;
                    }
                }
            }
            if(v6 >= 0 && v6 <= 0x7F) {
                byte b5 = b64.b[v6];
                if(b5 >= 0) {
                    arr_b1[v4] = b5;
                    if(v4 + 1 > 3) {
                        byte b6 = (byte)(arr_b1[0] << 2);
                        arr_b2[0] = b6;
                        int v12 = arr_b1[1];
                        byte b7 = (byte)(b6 | ((byte)(v12 >> 4 & 15)));
                        arr_b2[0] = b7;
                        arr_b2[1] = (byte)(v12 << 4);
                        int v13 = arr_b1[2];
                        arr_b2[1] = (byte)(((byte)(v12 << 4)) | ((byte)(v13 >> 2 & 0x3F)));
                        arr_b2[2] = (byte)(v13 << 6);
                        arr_b2[2] = (byte)(((byte)(v13 << 6)) | arr_b1[3]);
                        arr_b3[v5] = b7;
                        int v14 = v5 + 2;
                        arr_b3[v5 + 1] = arr_b2[1];
                        v5 += 3;
                        arr_b3[v14] = arr_b2[2];
                        for(int v15 = 0; v15 < 4; ++v15) {
                            if(v15 < 3) {
                                arr_b2[v15] = 0;
                            }
                            arr_b1[v15] = 0;
                        }
                        v4 = 0;
                    }
                    else {
                        ++v4;
                    }
                }
            }
        }
        arr_b3[v5] = 0;
        char[] arr_c = new char[v5 + 1];
        arr_c[0] = (char)v5;
        for(int v1 = 0; v1 < v5; ++v1) {
            arr_c[v1 + 1] = (char)arr_b3[v1];
        }
        return arr_c;
    }

    public static char[] b64encode_str(byte[] arr_b, int v) {
        byte[] arr_b3;
        int v1;
        byte[] arr_b1 = new byte[3];
        byte[] arr_b2 = new byte[4];
        if(v % 3 == 0) {
            v1 = v / 3 * 4;
        }
        else if(v % 3 > 0) {
            v1 = (v / 3 + 1) * 4;
        }
        else {
            v1 = 0;
        }
        char[] arr_c = new char[v1 + 1];
        char[] arr_c1 = new char[v1 + 1];
        for(int v2 = 0; v2 < v1; ++v2) {
            arr_c[v2] = '\u0000';
            arr_c1[v2] = '\u0000';
        }
        if(arr_b == null || v < 0) {
            arr_c1[0] = 'E';
            arr_c1[0] = 'R';
            arr_c1[0] = 'R';
            arr_c1[0] = 'O';
            arr_c1[0] = 'R';
            return arr_c1;
        }
        for(int v3 = 0; v3 < 4; ++v3) {
            if(v3 < 3) {
                arr_b2[v3] = 0;
                arr_b1[v3] = 0;
            }
            else {
                arr_b2[v3] = 0;
            }
        }
        int v5 = 0;
        int v6 = 0;
        for(int v4 = 0; true; ++v4) {
            arr_b3 = b64.a;
            if(v4 >= v) {
                break;
            }
            arr_b1[v5] = arr_b[v4];
            if(v5 + 1 > 2) {
                int v7 = arr_b3[((byte)(arr_b1['\u0000'] >> 2 & 0x3F))];
                arr_b2['\u0000'] = v7;
                int v8 = arr_b3[((byte)((arr_b1['\u0000'] << 4 | arr_b1[1] >> 4 & 15) & 0x3F))];
                arr_b2[1] = v8;
                int v9 = arr_b3[((byte)((arr_b1[1] << 2 | arr_b1[2] >> 6 & 3) & 0x3F))];
                arr_b2[2] = v9;
                int v10 = arr_b3[((byte)(arr_b1[2] & 0x3F))];
                arr_b2[3] = v10;
                arr_c[v6] = (char)v7;
                arr_c[v6 + 1] = (char)v8;
                int v11 = v6 + 3;
                arr_c[v6 + 2] = (char)v9;
                v6 += 4;
                arr_c[v11] = (char)v10;
                for(int v12 = '\u0000'; v12 < 4; ++v12) {
                    if(v12 < 3) {
                        arr_b2[v12] = '\u0000';
                        arr_b1[v12] = '\u0000';
                    }
                    else {
                        arr_b2[v12] = '\u0000';
                    }
                }
                v5 = '\u0000';
            }
            else {
                ++v5;
            }
        }
        if(v5 > 0) {
            switch(v5) {
                case 1: {
                    int v13 = arr_b3[((byte)(arr_b1['\u0000'] >> 2 & 0x3F))];
                    arr_b2['\u0000'] = v13;
                    int v14 = arr_b3[((byte)(arr_b1['\u0000'] << 4 & 0x3F))];
                    arr_b2[1] = v14;
                    arr_c[v6] = (char)v13;
                    arr_c[v6 + 1] = (char)v14;
                    int v15 = v6 + 3;
                    arr_c[v6 + 2] = '=';
                    v6 += 4;
                    arr_c[v15] = '=';
                    break;
                }
                case 2: {
                    int v16 = arr_b3[((byte)(arr_b1['\u0000'] >> 2 & 0x3F))];
                    arr_b2['\u0000'] = v16;
                    int v17 = arr_b3[((byte)((arr_b1[1] >> 4 & 15 | arr_b1['\u0000'] << 4) & 0x3F))];
                    arr_b2[1] = v17;
                    int v18 = arr_b3[((byte)(arr_b1[1] << 2 & 0x3F))];
                    arr_b2[2] = v18;
                    arr_c[v6] = (char)v16;
                    arr_c[v6 + 1] = (char)v17;
                    int v19 = v6 + 3;
                    arr_c[v6 + 2] = (char)v18;
                    v6 += 4;
                    arr_c[v19] = '=';
                }
            }
        }
        arr_c[v6] = '\u0000';
        if(v6 != v1) {
            arr_c1['\u0000'] = 'E';
            arr_c1['\u0000'] = 'R';
            arr_c1['\u0000'] = 'R';
            arr_c1['\u0000'] = 'O';
            arr_c1['\u0000'] = 'R';
            return arr_c1;
        }
        for(int v20 = '\u0000'; v20 < v6; ++v20) {
            arr_c1[v20] = arr_c[v20];
        }
        return arr_c1;
    }
}

