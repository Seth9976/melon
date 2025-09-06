package e8;

import U4.x;
import a8.b;
import d5.w;
import java.util.ArrayList;
import java.util.EnumMap;
import k8.Y;

public final class g extends w {
    public final int g;
    public static final int[] h;
    public static final int[] i;
    public static final int[][] j;

    static {
        g.h = new int[]{1, 1, 1, 1};
        g.i = new int[]{3, 1, 1};
        g.j = new int[][]{new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    }

    public g(int v) {
        this.g = v;
        super();
    }

    public static void Y(boolean[] arr_z, int v, int[] arr_v) {
        int v1 = 0;
        while(v1 < arr_v.length) {
            arr_z[v] = arr_v[v1] != 0;
            ++v1;
            ++v;
        }
    }

    public static int Z(int v, String s) {
        int v1 = s.length() - 1;
        int v2 = 0;
        int v3 = 1;
        while(v1 >= 0) {
            v2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(s.charAt(v1)) * v3;
            ++v3;
            v3 = v3 <= v ? v3 + 1 : 1;
            --v1;
        }
        return v2 % 0x2F;
    }

    public static int a0(int v, String s) {
        int v1 = s.length();
        if(v < v1) {
            int v2 = s.charAt(v);
            if(v2 == 0xF1) {
                return 4;
            }
            if(v2 >= 0x30 && v2 <= 57) {
                if(v + 1 < v1) {
                    int v3 = s.charAt(v + 1);
                    return v3 < 0x30 || v3 > 57 ? 2 : 3;
                }
                return 2;
            }
        }
        return 1;
    }

    public static void b0(int v, int[] arr_v) {
        for(int v1 = 0; true; ++v1) {
            int v2 = 1;
            if(v1 >= 9) {
                break;
            }
            if((1 << 8 - v1 & v) != 0) {
                v2 = 2;
            }
            arr_v[v1] = v2;
        }
    }

    public static void c0(int v, int[] arr_v) {
        for(int v1 = 0; true; ++v1) {
            int v2 = 1;
            if(v1 >= 9) {
                break;
            }
            if((1 << 8 - v1 & v) == 0) {
                v2 = 0;
            }
            arr_v[v1] = v2;
        }
    }

    @Override  // d5.w
    public final b p(String s, int v, EnumMap enumMap0) {
        switch(this.g) {
            case 0: {
                if(v != 9) {
                    throw new IllegalArgumentException("Can only encode ITF, but got " + x.C(v));
                }
                return super.p(s, 9, enumMap0);
            }
            case 1: {
                if(v != 5) {
                    throw new IllegalArgumentException("Can only encode CODE_128, but got " + x.C(v));
                }
                return super.p(s, 5, enumMap0);
            }
            case 2: {
                if(v != 3) {
                    throw new IllegalArgumentException("Can only encode CODE_39, but got " + x.C(v));
                }
                return super.p(s, 3, enumMap0);
            }
            default: {
                if(v != 4) {
                    throw new IllegalArgumentException("Can only encode CODE_93, but got " + x.C(v));
                }
                return super.p(s, 4, enumMap0);
            }
        }
    }

    @Override  // d5.w
    public final boolean[] w(String s) {
        int v25;
        int v22;
        switch(this.g) {
            case 0: {
                int v4 = s.length();
                if(v4 % 2 != 0) {
                    throw new IllegalArgumentException("The length of the input should be even");
                }
                if(v4 > 80) {
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + v4);
                }
                boolean[] arr_z1 = new boolean[v4 * 9 + 9];
                int v5 = w.o(arr_z1, 0, g.h, true);
                for(int v6 = 0; v6 < v4; v6 += 2) {
                    int v7 = Character.digit(s.charAt(v6), 10);
                    int v8 = Character.digit(s.charAt(v6 + 1), 10);
                    int[] arr_v1 = new int[10];
                    for(int v9 = 0; v9 < 5; ++v9) {
                        arr_v1[v9 * 2] = g.j[v7][v9];
                        arr_v1[v9 * 2 + 1] = g.j[v8][v9];
                    }
                    v5 += w.o(arr_z1, v5, arr_v1, true);
                }
                w.o(arr_z1, v5, g.i, true);
                return arr_z1;
            }
            case 1: {
                int[][] arr2_v = c.i;
                int v10 = s.length();
                if(v10 <= 0 || v10 > 80) {
                    throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + v10);
                }
                for(int v11 = 0; v11 < v10; ++v11) {
                    int v12 = s.charAt(v11);
                    if(v12 != 0xF1 && v12 != 0xF2 && v12 != 0xF3 && v12 != 0xF4 && v12 > 0x7F) {
                        throw new IllegalArgumentException("Bad character in input: " + ((char)v12));
                    }
                }
                ArrayList arrayList0 = new ArrayList();
                int v13 = 1;
                int v14 = 0;
                int v15 = 0;
                int v16 = 0;
                while(v14 < v10) {
                    int v17 = 99;
                    int v18 = g.a0(v14, s);
                    if(v18 == 2) {
                    label_94:
                        v17 = 100;
                    }
                    else if(v18 == 1) {
                        if(v14 < s.length()) {
                            int v19 = s.charAt(v14);
                            if(v19 >= 0x20 && (v16 != 101 || v19 >= 0x60)) {
                                goto label_94;
                            }
                            else {
                                v17 = 101;
                                goto label_95;
                            }
                        }
                        else {
                            goto label_94;
                        }
                        goto label_75;
                    }
                    else {
                    label_75:
                        if(v16 != 99) {
                            if(v16 != 100) {
                                if(v18 == 4) {
                                    v18 = g.a0(v14 + 1, s);
                                }
                                if(v18 != 3) {
                                    v17 = 100;
                                }
                            }
                            else if(v18 != 4) {
                                switch(g.a0(v14 + 2, s)) {
                                    case 1: 
                                    case 2: {
                                        goto label_87;
                                    }
                                    case 4: {
                                        if(g.a0(v14 + 3, s) != 3) {
                                            goto label_87;
                                        }
                                        break;
                                    }
                                    default: {
                                        int v20 = v14 + 4;
                                        int v21;
                                        while((v21 = g.a0(v20, s)) == 3) {
                                            v20 += 2;
                                        }
                                        if(v21 == 2) {
                                            goto label_87;
                                        }
                                    }
                                }
                            }
                            else {
                            label_87:
                                v17 = 100;
                            }
                        }
                    }
                label_95:
                    if(v17 == v16) {
                        switch(s.charAt(v14)) {
                            case 0xF1: {
                                v22 = 102;
                                break;
                            }
                            case 0xF2: {
                                v22 = 97;
                                break;
                            }
                            case 0xF3: {
                                v22 = 0x60;
                                break;
                            }
                            case 0xF4: {
                                v22 = v16 == 101 ? 101 : 100;
                                break;
                            }
                            default: {
                                switch(v16) {
                                    case 100: {
                                        v22 = s.charAt(v14) - 0x20;
                                        break;
                                    }
                                    case 101: {
                                        int v23 = s.charAt(v14);
                                        int v24 = v23 - 0x20;
                                        v22 = v24 >= 0 ? v24 : v23 + 0x40;
                                        break;
                                    }
                                    default: {
                                        v22 = Integer.parseInt(s.substring(v14, v14 + 2));
                                        ++v14;
                                    }
                                }
                            }
                        }
                        ++v14;
                    }
                    else {
                        if(v16 == 0) {
                            switch(v17) {
                                case 100: {
                                    v25 = 104;
                                    break;
                                }
                                case 101: {
                                    v25 = 103;
                                    break;
                                }
                                default: {
                                    v25 = 105;
                                }
                            }
                        }
                        else {
                            v25 = v17;
                        }
                        v16 = v17;
                        v22 = v25;
                    }
                    arrayList0.add(arr2_v[v22]);
                    v15 += v22 * v13;
                    if(v14 != 0) {
                        ++v13;
                    }
                }
                arrayList0.add(arr2_v[v15 % 103]);
                arrayList0.add(arr2_v[106]);
                int v26 = 0;
                for(Object object0: arrayList0) {
                    int[] arr_v2 = (int[])object0;
                    for(int v27 = 0; v27 < arr_v2.length; ++v27) {
                        v26 += arr_v2[v27];
                    }
                }
                boolean[] arr_z2 = new boolean[v26];
                int v28 = 0;
                for(Object object1: arrayList0) {
                    v28 += w.o(arr_z2, v28, ((int[])object1), true);
                }
                return arr_z2;
            }
            case 2: {
                int[] arr_v3 = c.j;
                int v29 = s.length();
                if(v29 > 80) {
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + v29);
                }
                for(int v30 = 0; v30 < v29; ++v30) {
                    if("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(s.charAt(v30)) < 0) {
                        int v31 = s.length();
                        StringBuilder stringBuilder1 = new StringBuilder();
                        for(int v32 = 0; v32 < v31; ++v32) {
                            int v33 = s.charAt(v32);
                            switch(v33) {
                                case 0: {
                                    stringBuilder1.append("%U");
                                    break;
                                }
                                case 0x20: 
                                case 45: 
                                case 46: {
                                    stringBuilder1.append(((char)v33));
                                    break;
                                }
                                case 0x40: {
                                    stringBuilder1.append("%V");
                                    break;
                                }
                                case 0x60: {
                                    stringBuilder1.append("%W");
                                    break;
                                }
                                default: {
                                    if(v33 <= 26) {
                                        stringBuilder1.append('$');
                                        stringBuilder1.append(((char)(v33 + 0x40)));
                                    }
                                    else if(v33 < 0x20) {
                                        stringBuilder1.append('%');
                                        stringBuilder1.append(((char)(v33 + 38)));
                                    }
                                    else if(v33 <= 44 || v33 == 0x2F || v33 == 58) {
                                        stringBuilder1.append('/');
                                        stringBuilder1.append(((char)(v33 + 0x20)));
                                    }
                                    else if(v33 <= 57) {
                                        stringBuilder1.append(((char)v33));
                                    }
                                    else if(v33 <= 0x3F) {
                                        stringBuilder1.append('%');
                                        stringBuilder1.append(((char)(v33 + 11)));
                                    }
                                    else if(v33 <= 90) {
                                        stringBuilder1.append(((char)v33));
                                    }
                                    else if(v33 <= 0x5F) {
                                        stringBuilder1.append('%');
                                        stringBuilder1.append(((char)(v33 - 16)));
                                    }
                                    else if(v33 <= 0x7A) {
                                        stringBuilder1.append('+');
                                        stringBuilder1.append(((char)(v33 - 0x20)));
                                    }
                                    else {
                                        if(v33 > 0x7F) {
                                            throw new IllegalArgumentException("Requested content contains a non-encodable character: \'" + s.charAt(v32) + "\'");
                                        }
                                        stringBuilder1.append('%');
                                        stringBuilder1.append(((char)(v33 - 43)));
                                    }
                                    break;
                                }
                            }
                        }
                        s = stringBuilder1.toString();
                        v29 = s.length();
                        if(v29 > 80) {
                            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + v29 + " (extended full ASCII mode)");
                        }
                        break;
                    }
                }
                int[] arr_v4 = new int[9];
                int v34 = v29 + 25;
                for(int v35 = 0; v35 < v29; ++v35) {
                    g.b0(arr_v3["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(s.charAt(v35))], arr_v4);
                    for(int v36 = 0; v36 < 9; ++v36) {
                        v34 += arr_v4[v36];
                    }
                }
                boolean[] arr_z3 = new boolean[v34];
                g.b0(0x94, arr_v4);
                int v37 = w.o(arr_z3, 0, arr_v4, true);
                int[] arr_v5 = {1};
                int v38 = w.o(arr_z3, v37, arr_v5, false) + v37;
                for(int v39 = 0; v39 < v29; ++v39) {
                    g.b0(arr_v3["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(s.charAt(v39))], arr_v4);
                    int v40 = w.o(arr_z3, v38, arr_v4, true) + v38;
                    v38 = w.o(arr_z3, v40, arr_v5, false) + v40;
                }
                g.b0(0x94, arr_v4);
                w.o(arr_z3, v38, arr_v4, true);
                return arr_z3;
            }
            default: {
                int v = s.length();
                if(v > 80) {
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + v);
                }
                int v1 = 9;
                int[] arr_v = new int[9];
                g.c0(d.i[0x2F], arr_v);
                boolean[] arr_z = new boolean[(s.length() + 4) * 9 + 1];
                g.Y(arr_z, 0, arr_v);
                for(int v2 = 0; v2 < v; ++v2) {
                    g.c0(d.i["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(s.charAt(v2))], arr_v);
                    g.Y(arr_z, v1, arr_v);
                    v1 += 9;
                }
                int v3 = g.Z(20, s);
                g.c0(d.i[v3], arr_v);
                g.Y(arr_z, v1, arr_v);
                StringBuilder stringBuilder0 = Y.p(s);
                stringBuilder0.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(v3));
                g.c0(d.i[g.Z(15, stringBuilder0.toString())], arr_v);
                g.Y(arr_z, v1 + 9, arr_v);
                g.c0(d.i[0x2F], arr_v);
                g.Y(arr_z, v1 + 18, arr_v);
                arr_z[v1 + 27] = true;
                return arr_z;
            }
        }
    }
}

