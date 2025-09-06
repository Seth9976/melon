package g4;

import e3.p;
import java.util.regex.Pattern;

public final class a {
    public final p a;
    public final StringBuilder b;
    public static final Pattern c;
    public static final Pattern d;

    static {
        a.c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
        a.d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    }

    public a() {
        this.a = new p();
        this.b = new StringBuilder();
    }

    public static String a(p p0, StringBuilder stringBuilder0) {
        boolean z = false;
        stringBuilder0.setLength(0);
        int v = p0.b;
        int v1 = p0.c;
        while(v < v1 && !z) {
            int v2 = (char)p0.a[v];
            if((v2 < 65 || v2 > 90) && (v2 < 97 || v2 > 0x7A) && (v2 < 0x30 || v2 > 57) && (v2 != 35 && v2 != 45 && v2 != 46 && v2 != 0x5F)) {
                z = true;
            }
            else {
                ++v;
                stringBuilder0.append(((char)v2));
            }
        }
        p0.H(v - p0.b);
        return stringBuilder0.toString();
    }

    public static String b(p p0, StringBuilder stringBuilder0) {
        a.c(p0);
        if(p0.a() == 0) {
            return null;
        }
        String s = a.a(p0, stringBuilder0);
        return "".equals(s) ? "" + ((char)p0.u()) : s;
    }

    public static void c(p p0) {
    alab1:
        while(true) {
            for(boolean z = true; true; z = false) {
                if(p0.a() <= 0 || !z) {
                    break alab1;
                }
                int v = p0.b;
                byte[] arr_b = p0.a;
                int v1 = arr_b[v];
                if(((char)v1) == 9 || ((char)v1) == 10 || ((char)v1) == 12 || ((char)v1) == 13 || ((char)v1) == 0x20) {
                    p0.H(1);
                    break;
                }
                int v2 = p0.c;
                int v3 = v + 2;
                if(v3 <= v2 && v1 == 0x2F && arr_b[v + 1] == 42) {
                    while(v3 + 1 < v2) {
                        if(((char)arr_b[v3]) == 42 && ((char)arr_b[v3 + 1]) == 0x2F) {
                            v3 += 2;
                            v2 = v3;
                        }
                        else {
                            ++v3;
                        }
                    }
                    p0.H(v2 - p0.b);
                    break;
                }
            }
        }
    }
}

