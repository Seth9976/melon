package com.iloen.melon.utils;

import De.t;
import S2.c;
import android.graphics.Color;
import androidx.fragment.app.l0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import com.iloen.melon.analytics.ClickLog;
import com.iloen.melon.custom.L0;
import com.iloen.melon.utils.log.LogU.Companion;
import d5.s;
import ge.b;
import hd.O1;
import java.util.ArrayList;
import java.util.HashMap;
import k8.i;
import k8.n;
import k8.o;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;
import tg.U;

public abstract class a {
    public static final int a = 3;

    public static int a(int v) {
        switch(v) {
            case 0: {
                return 2;
            }
            case 1: {
                return 3;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 5;
            }
            case 4: {
                return 6;
            }
            case 5: {
                return 7;
            }
            case 6: {
                return 8;
            }
            case 7: {
                return 9;
            }
            case 8: {
                return 10;
            }
            case 9: {
                return 11;
            }
            case 16: {
                return 12;
            }
            case 17: {
                return 13;
            }
            case 18: {
                return 14;
            }
            case 19: {
                return 15;
            }
            case 20: {
                return 16;
            }
            case 21: {
                return 17;
            }
            case 0x20: {
                return 18;
            }
            case 33: {
                return 19;
            }
            case 34: {
                return 20;
            }
            case 35: {
                return 21;
            }
            case 36: {
                return 22;
            }
            case 37: {
                return 23;
            }
            case 38: {
                return 24;
            }
            case 39: {
                return 25;
            }
            case 40: {
                return 26;
            }
            default: {
                return 1;
            }
        }
    }

    public static int b(int v) {
        int v1 = 1;
        if(v != 1 && v != 2) {
            v1 = 3;
            switch(v) {
                case 3: {
                    break;
                }
                case 4: {
                    return 4;
                }
                default: {
                    throw null;
                }
            }
        }
        return v1;
    }

    public static float c(float f, float f1, float f2, float f3) [...] // Inlined contents

    public static int d(int v, int v1, int v2, ArrayList arrayList0) {
        arrayList0.add(v);
        return v1 + v2;
    }

    public static t e(Class class0, String s, String s1, int v, J j0) {
        return j0.g(new z(class0, s, s1, v));
    }

    public static androidx.fragment.app.a f(l0 l00, String s, l0 l01) {
        q.f(l00, s);
        return new androidx.fragment.app.a(l01);
    }

    public static b g(o o0, int v) {
        return ge.a.a(new n(o0, v));
    }

    public static b h(o o0, k8.q q0, int v) {
        return ge.a.a(new i(o0, q0, v, 1));
    }

    public static Object i(int v, ArrayList arrayList0) {
        return arrayList0.get(arrayList0.size() - v);
    }

    public static Object j(U u0, String s, Class class0, String s1) {
        q.g(u0, s);
        Object object0 = u0.b(class0);
        q.f(object0, s1);
        return object0;
    }

    public static String k(int v, String s, StringBuilder stringBuilder0) [...] // 潜在的解密器

    public static String l(O1 o10, int v, String s) {
        String s1 = o10.d().getString(v);
        q.f(s1, s);
        return s1;
    }

    public static String m(StringBuilder stringBuilder0, String s) [...] // Inlined contents

    public static StringBuilder n(String s, String s1, String s2) {
        StringBuilder stringBuilder0 = new StringBuilder(s);
        stringBuilder0.append(s1);
        stringBuilder0.append(s2);
        return stringBuilder0;
    }

    public static StringBuilder o(String s, String s1, String s2, String s3, String s4) {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(s);
        stringBuilder0.append(s1);
        stringBuilder0.append(s2);
        stringBuilder0.append(s3);
        stringBuilder0.append(s4);
        return stringBuilder0;
    }

    public static o9.b p(c c0, String s, q0 q00, o0 o00, c c1) {
        q.g(c0, s);
        return new o9.b(q00, o00, c1);
    }

    public static void q(int v, int v1, int v2, HashMap hashMap0, String s) {
        hashMap0.put(s, Color.rgb(v, v1, v2));
    }

    public static void r(int v, String s, String s1) {
        e3.b.D(s1, s + v);
    }

    public static void s(long v, String s, String s1, StringBuilder stringBuilder0) {
        stringBuilder0.append(s);
        stringBuilder0.append(v);
        stringBuilder0.append(s1);
    }

    public static void t(s s0) {
        new ClickLog(s0).a();
    }

    public static void u(Object object0, String s, String s1, L0 l00, boolean z) {
        l00.a(object0 + s + s1, z);
    }

    public static void v(String s, String s1, Companion logU$Companion0, String s2) {
        logU$Companion0.w(s2, s + s1);
    }

    public static void w(String s, String s1, String s2) {
        e3.b.D(s2, s + s1);
    }

    public static void x(HashMap hashMap0, String s, Integer integer0, int v, String s1) {
        hashMap0.put(s, integer0);
        hashMap0.put(s1, v);
    }

    public static String y(int v) {
        switch(v) {
            case 1: {
                return "READING_CONTENT_HEAD_HTTP_HEADER";
            }
            case 2: {
                return "CONTENT_HEAD_DATA_COMPLETE";
            }
            case 3: {
                return "READING_CONTENT_TAIL_HTTP_HEADER";
            }
            case 4: {
                return "READING_CONTENT_TAIL_DATA";
            }
            case 5: {
                return "CONTENT_TAIL_DATA_COMPLETE";
            }
            default: {
                return "null";
            }
        }
    }
}

