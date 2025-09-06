package e8;

import d5.w;

public final class b extends w {
    public static final char[] g;
    public static final char[] h;
    public static final char[] i;
    public static final char j;

    static {
        char[] arr_c = {'A', 'B', 'C', 'D'};
        b.g = arr_c;
        b.h = new char[]{'T', 'N', '*', 'E'};
        b.i = new char[]{'/', ':', '+', '.'};
        b.j = arr_c[0];
    }

    @Override  // d5.w
    public final boolean[] w(String s) {
        int v = b.j;
        if(s.length() >= 2) {
            int v1 = Character.toUpperCase(s.charAt(0));
            int v2 = Character.toUpperCase(s.charAt(s.length() - 1));
            boolean z = a.u(((char)v1), b.g);
            boolean z1 = a.u(((char)v2), b.g);
            boolean z2 = a.u(((char)v1), b.h);
            boolean z3 = a.u(((char)v2), b.h);
            if(z) {
                if(!z1) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + s);
                }
                goto label_18;
            }
            if(z2) {
                if(!z3) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + s);
                }
                goto label_18;
            }
            if(z1 || z3) {
                throw new IllegalArgumentException("Invalid start/end guards: " + s);
            }
        }
        s = ((char)v) + s + ((char)v);
    label_18:
        int v3 = 20;
        for(int v4 = 1; v4 < s.length() - 1; ++v4) {
            if(Character.isDigit(s.charAt(v4)) || s.charAt(v4) == 45 || s.charAt(v4) == 36) {
                v3 += 9;
            }
            else {
                if(!a.u(s.charAt(v4), b.i)) {
                    throw new IllegalArgumentException("Cannot encode : \'" + s.charAt(v4) + '\'');
                }
                v3 += 10;
                continue;
            }
        }
        boolean[] arr_z = new boolean[s.length() - 1 + v3];
        int v5 = 0;
        int v6 = 0;
        while(v5 < s.length()) {
            int v7 = Character.toUpperCase(s.charAt(v5));
            if(v5 == 0 || v5 == s.length() - 1) {
                switch(v7) {
                    case 42: {
                        v7 = 67;
                        break;
                    }
                    case 69: {
                        v7 = 68;
                        break;
                    }
                    case 78: {
                        v7 = 66;
                        break;
                    }
                    case 84: {
                        v7 = 65;
                    }
                }
            }
            int v8 = 0;
            while(true) {
                int v9 = 0;
                char[] arr_c = a.i;
                if(v8 < arr_c.length) {
                    if(v7 == arr_c[v8]) {
                        v9 = a.j[v8];
                    }
                    else {
                        ++v8;
                        continue;
                    }
                }
                break;
            }
            int v10 = 0;
            boolean z4 = true;
            int v11 = 0;
            while(v11 < 7) {
                arr_z[v6] = z4;
                ++v6;
                if((v9 >> 6 - v11 & 1) != 0 && v10 != 1) {
                    ++v10;
                }
                else {
                    z4 = !z4;
                    ++v11;
                    v10 = 0;
                }
            }
            if(v5 < s.length() - 1) {
                arr_z[v6] = false;
                ++v6;
            }
            ++v5;
        }
        return arr_z;
    }
}

