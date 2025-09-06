package jf;

import Df.m;
import Hf.B;
import Hf.c;
import Hf.x;
import Jf.k;
import Jf.l;
import Tf.o;
import ef.h;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.q;
import lf.T;

public final class f implements m {
    public static final f b;
    public static final f c;
    public static final f d;

    static {
        f.b = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        f.c = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        f.d = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static String[] a(String[] arr_s) {
        ArrayList arrayList0 = new ArrayList(arr_s.length);
        for(int v = 0; v < arr_s.length; ++v) {
            arrayList0.add("<init>(" + arr_s[v] + ")V");
        }
        return (String[])arrayList0.toArray(new String[0]);
    }

    @Override  // Df.m
    public x b(T t0, String s, B b0, B b1) {
        q.g(t0, "proto");
        q.g(s, "flexibleId");
        q.g(b0, "lowerBound");
        q.g(b1, "upperBound");
        if(!s.equals("kotlin.jvm.PlatformType")) {
            return l.c(k.m, new String[]{s, b0.toString(), b1.toString()});
        }
        return t0.j(of.k.g) ? new h(b0, b1) : c.f(b0, b1);
    }

    public static jf.k c(String s) {
        yf.c c0;
        q.g(s, "representation");
        int v = s.charAt(0);
        yf.c[] arr_c = yf.c.values();
        for(int v1 = 0; true; ++v1) {
            c0 = null;
            if(v1 >= arr_c.length) {
                break;
            }
            yf.c c1 = arr_c[v1];
            if(c1.c().charAt(0) == v) {
                c0 = c1;
                break;
            }
        }
        if(c0 != null) {
            return new j(c0);
        }
        switch(v) {
            case 76: {
                o.A0(s, ';');
                break;
            }
            case 86: {
                return new j(null);
            }
            case 91: {
                String s1 = s.substring(1);
                q.f(s1, "substring(...)");
                return new jf.h(f.c(s1));
            }
        }
        String s2 = s.substring(1, s.length() - 1);
        q.f(s2, "substring(...)");
        return new i(s2);
    }

    public static i d(String s) {
        q.g(s, "internalName");
        return new i(s);
    }

    public static LinkedHashSet e(String s, String[] arr_s) {
        q.g(s, "internalName");
        q.g(arr_s, "signatures");
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        for(int v = 0; v < arr_s.length; ++v) {
            linkedHashSet0.add(s + '.' + arr_s[v]);
        }
        return linkedHashSet0;
    }

    public static LinkedHashSet f(String s, String[] arr_s) {
        q.g(arr_s, "signatures");
        return f.e(("java/lang/" + s), ((String[])Arrays.copyOf(arr_s, arr_s.length)));
    }

    public static LinkedHashSet g(String s, String[] arr_s) {
        return f.e(("java/util/" + s), ((String[])Arrays.copyOf(arr_s, arr_s.length)));
    }

    public static String h(jf.k k0) {
        q.g(k0, "type");
        if(k0 instanceof jf.h) {
            return "[" + f.h(((jf.h)k0).i);
        }
        if(k0 instanceof j) {
            yf.c c0 = ((j)k0).i;
            if(c0 != null) {
                String s = c0.c();
                return s == null ? "V" : s;
            }
            return "V";
        }
        if(!(k0 instanceof i)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return androidx.appcompat.app.o.r(new StringBuilder("L"), ((i)k0).i, ';');
    }
}

