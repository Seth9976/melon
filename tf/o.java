package Tf;

import C8.a;
import Ce.e;
import Ce.g;
import Fc.b;
import Sf.p;
import e.k;
import h7.u0;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import je.n;
import kotlin.jvm.internal.q;

public abstract class o extends v {
    public static boolean A0(String s, char c) {
        q.g(s, "<this>");
        return s.length() > 0 && u0.u(s.charAt(o.B0(s)), c, false);
    }

    public static int B0(CharSequence charSequence0) {
        q.g(charSequence0, "<this>");
        return charSequence0.length() - 1;
    }

    public static final int C0(CharSequence charSequence0, String s, int v, boolean z) {
        q.g(charSequence0, "<this>");
        q.g(s, "string");
        return z || !(charSequence0 instanceof String) ? o.D0(charSequence0, s, v, charSequence0.length(), z, false) : ((String)charSequence0).indexOf(s, v);
    }

    public static final int D0(CharSequence charSequence0, CharSequence charSequence1, int v, int v1, boolean z, boolean z1) {
        e e0;
        if(z1) {
            int v3 = o.B0(charSequence0);
            if(v > v3) {
                v = v3;
            }
            if(v1 < 0) {
                v1 = 0;
            }
            e0 = new e(v, v1, -1);
        }
        else {
            if(v < 0) {
                v = 0;
            }
            int v2 = charSequence0.length();
            if(v1 > v2) {
                v1 = v2;
            }
            e0 = new g(v, v1, 1);  // 初始化器: LCe/e;-><init>(III)V
        }
        int v4 = e0.c;
        int v5 = e0.b;
        int v6 = e0.a;
        if(!(charSequence0 instanceof String) || !(charSequence1 instanceof String)) {
            if(v4 > 0 && v6 <= v5 || v4 < 0 && v5 <= v6) {
                for(int v8 = v6; true; v8 += v4) {
                    if(o.M0(charSequence1, z, 0, charSequence0, v8, charSequence1.length())) {
                        return v8;
                    }
                    if(v8 == v5) {
                        break;
                    }
                }
            }
        }
        else if(v4 > 0 && v6 <= v5 || v4 < 0 && v5 <= v6) {
            for(int v7 = v6; true; v7 += v4) {
                if(v.m0(0, v7, ((String)charSequence1).length(), ((String)charSequence1), ((String)charSequence0), z)) {
                    return v7;
                }
                if(v7 == v5) {
                    break;
                }
            }
        }
        return -1;
    }

    public static int E0(CharSequence charSequence0, char c, int v, int v1) {
        if((v1 & 2) != 0) {
            v = 0;
        }
        q.g(charSequence0, "<this>");
        return charSequence0 instanceof String ? ((String)charSequence0).indexOf(((int)c), v) : o.G0(charSequence0, new char[]{c}, v, false);
    }

    public static int F0(CharSequence charSequence0, String s, int v, boolean z, int v1) {
        if((v1 & 2) != 0) {
            v = 0;
        }
        if((v1 & 4) != 0) {
            z = false;
        }
        return o.C0(charSequence0, s, v, z);
    }

    public static final int G0(CharSequence charSequence0, char[] arr_c, int v, boolean z) {
        q.g(charSequence0, "<this>");
        if(!z && arr_c.length == 1 && charSequence0 instanceof String) {
            return ((String)charSequence0).indexOf(n.t0(arr_c), v);
        }
        if(v < 0) {
            v = 0;
        }
        int v1 = o.B0(charSequence0);
        if(v <= v1) {
            while(true) {
                int v2 = charSequence0.charAt(v);
                for(int v3 = 0; v3 < arr_c.length; ++v3) {
                    if(u0.u(arr_c[v3], ((char)v2), z)) {
                        return v;
                    }
                }
                if(v == v1) {
                    break;
                }
                ++v;
            }
        }
        return -1;
    }

    public static boolean H0(CharSequence charSequence0) {
        q.g(charSequence0, "<this>");
        for(int v = 0; v < charSequence0.length(); ++v) {
            if(!u0.K(charSequence0.charAt(v))) {
                return false;
            }
        }
        return true;
    }

    public static char I0(CharSequence charSequence0) {
        if(charSequence0.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence0.charAt(o.B0(charSequence0));
    }

    public static int J0(CharSequence charSequence0, char c, int v, int v1) {
        if((v1 & 2) != 0) {
            v = o.B0(charSequence0);
        }
        q.g(charSequence0, "<this>");
        if(!(charSequence0 instanceof String)) {
            char[] arr_c = {c};
            if(charSequence0 instanceof String) {
                return ((String)charSequence0).lastIndexOf(n.t0(arr_c), v);
            }
            int v2 = o.B0(charSequence0);
            if(v > v2) {
                v = v2;
            }
            while(-1 < v) {
                int v3 = charSequence0.charAt(v);
                if(u0.u(arr_c[0], ((char)v3), false)) {
                    return v;
                }
                --v;
            }
            return -1;
        }
        return ((String)charSequence0).lastIndexOf(((int)c), v);
    }

    public static int K0(CharSequence charSequence0, String s, int v, int v1) {
        if((v1 & 2) != 0) {
            v = o.B0(charSequence0);
        }
        q.g(charSequence0, "<this>");
        q.g(s, "string");
        return charSequence0 instanceof String ? ((String)charSequence0).lastIndexOf(s, v) : o.D0(charSequence0, s, v, 0, false, true);
    }

    public static String L0(int v, String s) {
        q.g(s, "<this>");
        if(v < 0) {
            throw new IllegalArgumentException("Desired length " + v + " is less than zero.");
        }
        if(v <= s.length()) {
            return s.subSequence(0, s.length()).toString();
        }
        StringBuilder stringBuilder0 = new StringBuilder(v);
        int v1 = v - s.length();
        if(1 <= v1) {
            for(int v2 = 1; true; ++v2) {
                stringBuilder0.append('0');
                if(v2 == v1) {
                    break;
                }
            }
        }
        stringBuilder0.append(s);
        return stringBuilder0.toString();
    }

    public static final boolean M0(CharSequence charSequence0, boolean z, int v, CharSequence charSequence1, int v1, int v2) {
        q.g(charSequence0, "<this>");
        q.g(charSequence1, "other");
        if(v1 >= 0 && v >= 0 && v <= charSequence0.length() - v2 && v1 <= charSequence1.length() - v2) {
            for(int v3 = 0; v3 < v2; ++v3) {
                if(!u0.u(charSequence0.charAt(v + v3), charSequence1.charAt(v1 + v3), z)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String N0(String s, String s1) [...] // 潜在的解密器

    public static String O0(String s, String s1) [...] // 潜在的解密器

    public static final void P0(int v) {
        if(v < 0) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + v).toString());
        }
    }

    public static final List Q0(int v, String s, CharSequence charSequence0) {
        o.P0(v);
        int v1 = o.C0(charSequence0, s, 0, false);
        if(v1 != -1 && v != 1) {
            List list0 = new ArrayList((v <= 0 || v > 10 ? 10 : v));
            int v2 = 0;
            do {
                ((ArrayList)list0).add(charSequence0.subSequence(v2, v1).toString());
                v2 = s.length() + v1;
                if(v > 0 && ((ArrayList)list0).size() == v - 1) {
                    break;
                }
                v1 = o.C0(charSequence0, s, v2, false);
            }
            while(v1 != -1);
            ((ArrayList)list0).add(charSequence0.subSequence(v2, charSequence0.length()).toString());
            return list0;
        }
        return k.z(charSequence0.toString());
    }

    public static List R0(CharSequence charSequence0, String[] arr_s, int v, int v1) {
        if((v1 & 4) != 0) {
            v = 0;
        }
        q.g(charSequence0, "<this>");
        if(arr_s.length == 1) {
            String s = arr_s[0];
            if(s.length() != 0) {
                return o.Q0(v, s, charSequence0);
            }
        }
        o.P0(v);
        c c0 = new c(charSequence0, v, new b(n.N(arr_s)));
        List list0 = new ArrayList(je.q.Q(10, new p(c0, 0)));
        for(Object object0: c0) {
            q.g(((g)object0), "range");
            ((ArrayList)list0).add(charSequence0.subSequence(((g)object0).a, ((g)object0).b + 1).toString());
        }
        return list0;
    }

    public static List S0(String s, char[] arr_c) {
        q.g(s, "<this>");
        if(arr_c.length == 1) {
            return o.Q0(0, String.valueOf(arr_c[0]), s);
        }
        o.P0(0);
        c c0 = new c(s, 0, new a(arr_c, 22));
        List list0 = new ArrayList(je.q.Q(10, new p(c0, 0)));
        for(Object object0: c0) {
            q.g(((g)object0), "range");
            ((ArrayList)list0).add(s.subSequence(((g)object0).a, ((g)object0).b + 1).toString());
        }
        return list0;
    }

    public static boolean T0(CharSequence charSequence0, String s) {
        q.g(s, "<this>");
        q.g(charSequence0, "prefix");
        return charSequence0 instanceof String ? v.r0(s, ((String)charSequence0), false) : o.M0(s, false, 0, charSequence0, 0, charSequence0.length());
    }

    public static boolean U0(String s, char c) {
        return s.length() > 0 && u0.u(s.charAt(0), c, false);
    }

    public static String V0(String s, g g0) {
        q.g(s, "<this>");
        q.g(g0, "range");
        String s1 = s.substring(g0.a, g0.b + 1);
        q.f(s1, "substring(...)");
        return s1;
    }

    public static String W0(char c, String s, String s1) {
        int v = o.E0(s, c, 0, 6);
        if(v == -1) {
            return s1;
        }
        String s2 = s.substring(v + 1, s.length());
        q.f(s2, "substring(...)");
        return s2;
    }

    public static String X0(String s, String s1) {
        q.g(s1, "delimiter");
        int v = o.F0(s, s1, 0, false, 6);
        if(v == -1) {
            return s;
        }
        String s2 = s.substring(s1.length() + v, s.length());
        q.f(s2, "substring(...)");
        return s2;
    }

    public static String Y0(char c, String s, String s1) {
        q.g(s, "<this>");
        q.g(s1, "missingDelimiterValue");
        int v = o.J0(s, c, 0, 6);
        if(v == -1) {
            return s1;
        }
        String s2 = s.substring(v + 1, s.length());
        q.f(s2, "substring(...)");
        return s2;
    }

    public static String Z0(String s, String s1, String s2) {
        q.g(s, "<this>");
        q.g(s2, "missingDelimiterValue");
        int v = o.K0(s, s1, 0, 6);
        if(v == -1) {
            return s2;
        }
        String s3 = s.substring(s1.length() + v, s.length());
        q.f(s3, "substring(...)");
        return s3;
    }

    public static String a1(String s, char c) {
        q.g(s, "<this>");
        q.g(s, "missingDelimiterValue");
        int v = o.E0(s, c, 0, 6);
        if(v == -1) {
            return s;
        }
        String s1 = s.substring(0, v);
        q.f(s1, "substring(...)");
        return s1;
    }

    public static String b1(String s, String s1) {
        q.g(s, "<this>");
        q.g(s, "missingDelimiterValue");
        int v = o.F0(s, s1, 0, false, 6);
        if(v == -1) {
            return s;
        }
        String s2 = s.substring(0, v);
        q.f(s2, "substring(...)");
        return s2;
    }

    public static String c1(char c, String s, String s1) {
        q.g(s, "<this>");
        q.g(s1, "missingDelimiterValue");
        int v = o.J0(s, c, 0, 6);
        if(v == -1) {
            return s1;
        }
        String s2 = s.substring(0, v);
        q.f(s2, "substring(...)");
        return s2;
    }

    public static String d1(int v, String s) {
        q.g(s, "<this>");
        if(v < 0) {
            throw new IllegalArgumentException(("Requested character count " + v + " is less than zero.").toString());
        }
        int v1 = s.length();
        if(v > v1) {
            v = v1;
        }
        String s1 = s.substring(0, v);
        q.f(s1, "substring(...)");
        return s1;
    }

    public static CharSequence e1(CharSequence charSequence0) {
        q.g(charSequence0, "<this>");
        int v = charSequence0.length() - 1;
        int v1 = 0;
        boolean z = false;
        while(v1 <= v) {
            boolean z1 = u0.K(charSequence0.charAt((z ? v : v1)));
            if(z) {
                if(!z1) {
                    break;
                }
                --v;
            }
            else if(z1) {
                ++v1;
            }
            else {
                z = true;
            }
        }
        return charSequence0.subSequence(v1, v + 1);
    }

    public static CharSequence f1(String s) {
        q.g(s, "<this>");
        int v = s.length() - 1;
        if(v >= 0) {
            while(true) {
                if(!u0.K(s.charAt(v))) {
                    return s.subSequence(0, v + 1);
                }
                if(v - 1 < 0) {
                    break;
                }
                --v;
            }
        }
        return "";
    }

    public static CharSequence g1(CharSequence charSequence0) {
        q.g(charSequence0, "<this>");
        int v = charSequence0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            if(!u0.K(charSequence0.charAt(v1))) {
                return charSequence0.subSequence(v1, charSequence0.length());
            }
        }
        return "";
    }

    public static boolean v0(CharSequence charSequence0, CharSequence charSequence1, boolean z) {
        q.g(charSequence0, "<this>");
        q.g(charSequence1, "other");
        return charSequence1 instanceof String ? o.F0(charSequence0, ((String)charSequence1), 0, z, 2) >= 0 : o.D0(charSequence0, charSequence1, 0, charSequence0.length(), z, false) >= 0;
    }

    public static boolean w0(CharSequence charSequence0, char c) {
        q.g(charSequence0, "<this>");
        return o.E0(charSequence0, c, 0, 2) >= 0;
    }

    public static String x0(int v, String s) {
        q.g(s, "<this>");
        if(v < 0) {
            throw new IllegalArgumentException(("Requested character count " + v + " is less than zero.").toString());
        }
        int v1 = s.length();
        if(v > v1) {
            v = v1;
        }
        String s1 = s.substring(v);
        q.f(s1, "substring(...)");
        return s1;
    }

    public static String y0(int v, String s) {
        q.g(s, "<this>");
        if(v < 0) {
            throw new IllegalArgumentException(androidx.appcompat.app.o.j(v, "Requested character count ", " is less than zero.").toString());
        }
        int v1 = s.length() - v;
        if(v1 < 0) {
            v1 = 0;
        }
        return o.d1(v1, s);
    }

    public static boolean z0(CharSequence charSequence0, String s) {
        q.g(charSequence0, "<this>");
        return charSequence0 instanceof String ? v.i0(((String)charSequence0), s, false) : o.M0(charSequence0, false, charSequence0.length() - s.length(), s, 0, s.length());
    }
}

