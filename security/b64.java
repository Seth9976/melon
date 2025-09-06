package security;

public final class b64 {
    static final int ENCODE_SIZE = 3;
    static final int MAX_CAP = 0x1000;
    static final byte[] basis_64;
    static final byte[] index_64;

    static {
        b64.basis_64 = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 0x4F, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 120, 0x79, 0x7A, 0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 0x2F};
        b64.index_64 = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 0x3F, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 0x1F, 0x20, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 0x2F, 0x30, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    public static char[] b64decode_str(byte[] arr_b, int v) {
        int v10;
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
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
    alab1:
        while(true) {
            if(v3 < v) {
                int v6 = arr_b[v3];
                if(v6 == 61) {
                    switch(v4) {
                        case 0: {
                            break;
                        }
                        case 1: {
                            byte b2 = (byte)(arr_b1[0] << 2);
                            arr_b2[0] = b2;
                            arr_b3[v5] = b2;
                            v10 = v5 + 1;
                            break alab1;
                        }
                        case 2: {
                            byte b3 = (byte)(arr_b1[0] << 2);
                            arr_b2[0] = b3;
                            int v11 = arr_b1[1];
                            byte b4 = (byte)(b3 | ((byte)(v11 >> 4 & 15)));
                            arr_b2[0] = b4;
                            arr_b2[1] = (byte)(v11 << 4 & 15);
                            int v12 = v5 + 1;
                            arr_b3[v5] = b4;
                            v5 += 2;
                            arr_b3[v12] = arr_b2[1];
                            break;
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
                        }
                    }
                }
                else {
                    if(v6 >= 0 && v6 <= 0x7F) {
                        byte b5 = b64.index_64[v6];
                        if(b5 >= 0) {
                            arr_b1[v4] = b5;
                            if(v4 + 1 > 3) {
                                byte b6 = (byte)(arr_b1[0] << 2);
                                arr_b2[0] = b6;
                                int v13 = arr_b1[1];
                                byte b7 = (byte)(b6 | ((byte)(v13 >> 4 & 15)));
                                arr_b2[0] = b7;
                                arr_b2[1] = (byte)(v13 << 4);
                                int v14 = arr_b1[2];
                                arr_b2[1] = (byte)(((byte)(v13 << 4)) | ((byte)(v14 >> 2 & 0x3F)));
                                arr_b2[2] = (byte)(v14 << 6);
                                arr_b2[2] = (byte)(((byte)(v14 << 6)) | arr_b1[3]);
                                arr_b3[v5] = b7;
                                arr_b3[v5 + 1] = arr_b2[1];
                                arr_b3[v5 + 2] = arr_b2[2];
                                for(int v15 = 0; v15 < 4; ++v15) {
                                    if(v15 < 3) {
                                        arr_b2[v15] = 0;
                                    }
                                    arr_b1[v15] = 0;
                                }
                                v4 = 0;
                                v5 += 3;
                            }
                            else {
                                ++v4;
                            }
                        }
                    }
                    ++v3;
                    continue;
                }
            }
            v10 = v5;
            break;
        }
        arr_b3[v10] = 0;
        char[] arr_c = new char[v10 + 1];
        arr_c[0] = (char)v10;
        for(int v1 = 0; v1 < v10; ++v1) {
            arr_c[v1 + 1] = (char)arr_b3[v1];
        }
        return arr_c;
    }

    public static char[] b64encode_str(byte[] arr_b, int v) {
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
        for(int v4 = 0; v4 < v; ++v4) {
            arr_b1[v5] = arr_b[v4];
            if(v5 + 1 > 2) {
                int v7 = b64.basis_64[((byte)(arr_b1[0] >> 2 & 0x3F))];
                arr_b2[0] = v7;
                int v8 = b64.basis_64[((byte)((arr_b1[0] << 4 | arr_b1[1] >> 4 & 15) & 0x3F))];
                arr_b2[1] = v8;
                int v9 = b64.basis_64[((byte)((arr_b1[1] << 2 | arr_b1[2] >> 6 & 3) & 0x3F))];
                arr_b2[2] = v9;
                int v10 = b64.basis_64[((byte)(arr_b1[2] & 0x3F))];
                arr_b2[3] = v10;
                arr_c[v6] = (char)v7;
                arr_c[v6 + 1] = (char)v8;
                arr_c[v6 + 2] = (char)v9;
                arr_c[v6 + 3] = (char)v10;
                for(int v11 = 0; v11 < 4; ++v11) {
                    if(v11 < 3) {
                        arr_b2[v11] = 0;
                        arr_b1[v11] = 0;
                    }
                    else {
                        arr_b2[v11] = 0;
                    }
                }
                v6 += 4;
                v5 = 0;
            }
            else {
                ++v5;
            }
        }
        if(v5 > 0) {
            switch(v5) {
                case 1: {
                    int v12 = b64.basis_64[((byte)(arr_b1[0] >> 2 & 0x3F))];
                    arr_b2[0] = v12;
                    int v13 = b64.basis_64[((byte)(arr_b1[0] << 4 & 0x3F))];
                    arr_b2[1] = v13;
                    arr_c[v6] = (char)v12;
                    arr_c[v6 + 1] = (char)v13;
                    int v14 = v6 + 3;
                    arr_c[v6 + 2] = '=';
                    v6 += 4;
                    arr_c[v14] = '=';
                    break;
                }
                case 2: {
                    int v15 = b64.basis_64[((byte)(arr_b1[0] >> 2 & 0x3F))];
                    arr_b2[0] = v15;
                    int v16 = b64.basis_64[((byte)((arr_b1[1] >> 4 & 15 | arr_b1[0] << 4) & 0x3F))];
                    arr_b2[1] = v16;
                    int v17 = b64.basis_64[((byte)(arr_b1[1] << 2 & 0x3F))];
                    arr_b2[2] = v17;
                    arr_c[v6] = (char)v15;
                    arr_c[v6 + 1] = (char)v16;
                    int v18 = v6 + 3;
                    arr_c[v6 + 2] = (char)v17;
                    v6 += 4;
                    arr_c[v18] = '=';
                }
            }
        }
        arr_c[v6] = '\u0000';
        if(v6 != v1) {
            System.out.println("11111111111111111111111111111");
            System.out.println("idst = [" + v6 + "]");
            System.out.println("EnLen = [" + v1 + "]");
            arr_c1[0] = 'E';
            arr_c1[0] = 'R';
            arr_c1[0] = 'R';
            arr_c1[0] = 'O';
            arr_c1[0] = 'R';
            return arr_c1;
        }
        for(int v19 = 0; v19 < v6; ++v19) {
            arr_c1[v19] = arr_c[v19];
        }
        return arr_c1;
    }
}

