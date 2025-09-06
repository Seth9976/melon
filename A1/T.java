package a1;

import A0.e;
import U4.x;
import android.graphics.Typeface;
import android.os.LocaleList;
import android.text.Html;
import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.session.legacy.V;
import e.k;
import e1.B;
import e1.i;
import e1.j;
import e1.u;
import e1.y;
import h1.b;
import i.n.i.b.a.s.e.Ga;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.List;
import je.p;
import je.w;
import kotlin.jvm.internal.q;
import l1.l;
import r1.c;
import r1.m;
import y0.P;

public abstract class t {
    public static final r a;

    static {
        t.a = new r();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static a a(String s, U u0, long v, c c0, i i0, int v1, int v2) {
        return new a(new i1.c(s, u0, w.a, w.a, i0, c0), v1, 1, v);
    }

    public static final long b(int v, int v1) {
        if(v < 0 || v1 < 0) {
            g1.a.a(("start and end cannot be negative. [start: " + v + ", end: " + v1 + ']'));
        }
        return ((long)v1) & 0xFFFFFFFFL | ((long)v) << 0x20;
    }

    public static final long c(int v, long v1) {
        int v2 = 0;
        int v3 = ((int)(v1 >> 0x20)) >= 0 ? ((int)(v1 >> 0x20)) : 0;
        if(v3 > v) {
            v3 = v;
        }
        if(((int)(0xFFFFFFFFL & v1)) >= 0) {
            v2 = (int)(0xFFFFFFFFL & v1);
        }
        if(v2 <= v) {
            v = v2;
        }
        return v3 != ((int)(v1 >> 0x20)) || v != ((int)(0xFFFFFFFFL & v1)) ? t.b(v3, v) : v1;
    }

    // This method was un-flattened
    public static final int d(int v, List list0) {
        int v5;
        int v4;
        int v1 = ((A)p.s0(list0)).c;
        if(v > ((A)p.s0(list0)).c) {
            g1.a.a(("Index " + v + " should be less or equal than last line\'s end " + v1));
        }
        int v2 = list0.size() - 1;
        int v3 = 0;
        while(true) {
            if(v3 > v2) {
                v4 = -(v3 + 1);
                break;
            }
            v4 = v3 + v2 >>> 1;
            A a0 = (A)list0.get(v4);
            if(a0.b > v) {
                v5 = 1;
            }
            else if(a0.c <= v) {
                v5 = -1;
                v3 = v4 + 1;
                continue;
            }
            if(v5 <= 0) {
                break;
            }
            v2 = v4 - 1;
        }
        if(v4 >= 0 && v4 < list0.size()) {
            return v4;
        }
        StringBuilder stringBuilder0 = x.n(v4, "Found paragraph index ", " should be in range [0, ");
        stringBuilder0.append(list0.size());
        stringBuilder0.append(").\nDebug info: index=");
        stringBuilder0.append(v);
        stringBuilder0.append(", paragraphs=[");
        stringBuilder0.append(t1.a.a(list0, null, h.h, 0x1F));
        stringBuilder0.append(']');
        g1.a.a(stringBuilder0.toString());
        return v4;
    }

    // This method was un-flattened
    public static final int e(int v, List list0) {
        int v4;
        int v1 = list0.size() - 1;
        int v2 = 0;
        while(v2 <= v1) {
            int v3 = v2 + v1 >>> 1;
            A a0 = (A)list0.get(v3);
            if(a0.d > v) {
                v4 = 1;
            }
            else if(a0.e <= v) {
                v4 = -1;
                v2 = v3 + 1;
                continue;
            }
            if(v4 > 0) {
                v1 = v3 - 1;
                continue;
            }
            return v3;
        }
        return -(v2 + 1);
    }

    // This method was un-flattened
    public static final int f(ArrayList arrayList0, float f) {
        int v3;
        if(Float.compare(f, 0.0f) <= 0) {
            return 0;
        }
        if(f >= ((A)p.s0(arrayList0)).g) {
            return k.s(arrayList0);
        }
        int v = arrayList0.size() - 1;
        int v1 = 0;
        while(v1 <= v) {
            int v2 = v1 + v >>> 1;
            A a0 = (A)arrayList0.get(v2);
            if(a0.f > f) {
                v3 = 1;
            }
            else if(a0.g <= f) {
                v3 = -1;
                v1 = v2 + 1;
                continue;
            }
            if(v3 > 0) {
                v = v2 - 1;
                continue;
            }
            return v2;
        }
        return -(v1 + 1);
    }

    public static final void g(ArrayList arrayList0, long v, we.k k0) {
        int v1 = t.d(T.e(v), arrayList0);
        int v2 = arrayList0.size();
        while(v1 < v2) {
            A a0 = (A)arrayList0.get(v1);
            if(a0.b >= T.d(v)) {
                break;
            }
            if(a0.b != a0.c) {
                k0.invoke(a0);
            }
            ++v1;
        }
    }

    public static g h(String s, S s1, int v) {
        e1.A a1;
        e1.A a0;
        M m0;
        Spanned spanned0 = Html.fromHtml(("<ContentHandlerReplacementTag />" + s), 0x3F, null, t.a);
        d d0 = new d(spanned0.length());
        d0.c(spanned0);
        Object[] arr_object = spanned0.getSpans(0, d0.a.length(), Object.class);
        for(int v1 = 0; v1 < arr_object.length; ++v1) {
            Object object0 = arr_object[v1];
            long v2 = t.b(spanned0.getSpanStart(object0), spanned0.getSpanEnd(object0));
            int v3 = (int)(v2 >> 0x20);
            int v4 = (int)(v2 & 0xFFFFFFFFL);
            if(!(object0 instanceof AbsoluteSizeSpan)) {
                ArrayList arrayList0 = d0.c;
                int v5 = 3;
                if(object0 instanceof AlignmentSpan) {
                    Layout.Alignment layout$Alignment0 = ((AlignmentSpan)object0).getAlignment();
                    switch((layout$Alignment0 == null ? -1 : s.a[layout$Alignment0.ordinal()])) {
                        case 1: {
                            v5 = 5;
                            break;
                        }
                        case 2: {
                            break;
                        }
                        case 3: {
                            v5 = 6;
                            break;
                        }
                        default: {
                            v5 = 0x80000000;
                        }
                    }
                    arrayList0.add(new a1.c(new D(v5, null, 510), v3, v4, 8));
                }
                else if(object0 instanceof a1.k) {
                    O o0 = new O(((a1.k)object0).b);
                    arrayList0.add(new a1.c(((a1.k)object0).a, v3, v4, o0));
                }
                else if(object0 instanceof BackgroundColorSpan) {
                    d0.a(new M(0L, 0L, null, null, null, null, null, 0L, null, null, null, y0.M.c(((BackgroundColorSpan)object0).getBackgroundColor()), null, null, 0xF7FF), v3, v4);
                }
                else if(object0 instanceof o) {
                    long v6 = n.a;
                    int v7 = ((o)object0).b;
                    if((v6 & 0xFF00000000L) == 0L) {
                        r1.i.a("Cannot perform operation for Unspecified type.");
                    }
                    long v8 = u.M(v6 & 0xFF00000000L, r1.o.c(v6) * ((float)v7));
                    arrayList0.add(new a1.c(new D(0, new l1.r(v8, v8), 503), v3, v4, 8));
                    arrayList0.add(new a1.c(((o)object0).a, v3, v4, 8));
                }
                else if(object0 instanceof ForegroundColorSpan) {
                    d0.a(new M(y0.M.c(((ForegroundColorSpan)object0).getForegroundColor()), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFE), v3, v4);
                }
                else if(object0 instanceof RelativeSizeSpan) {
                    d0.a(new M(0L, u.M(0x200000000L, ((RelativeSizeSpan)object0).getSizeChange()), null, null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFD), v3, v4);
                }
                else if(object0 instanceof StrikethroughSpan) {
                    d0.a(new M(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, l.d, null, 0xEFFF), v3, v4);
                }
                else if(object0 instanceof StyleSpan) {
                    switch(((StyleSpan)object0).getStyle()) {
                        case 1: {
                            m0 = new M(0L, 0L, y.i, null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFB);
                            break;
                        }
                        case 2: {
                            m0 = new M(0L, 0L, null, new e1.s(1), null, null, null, 0L, null, null, null, 0L, null, null, 0xFFF7);
                            break;
                        }
                        case 3: {
                            e1.s s2 = new e1.s(1);
                            m0 = new M(0L, 0L, y.i, s2, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFF3);
                            break;
                        }
                        default: {
                            m0 = null;
                        }
                    }
                    if(m0 != null) {
                        d0.a(m0, v3, v4);
                    }
                }
                else if(object0 instanceof SubscriptSpan) {
                    d0.a(new M(0L, 0L, null, null, null, null, null, 0L, new l1.a(-0.5f), null, null, 0L, null, null, 0xFEFF), v3, v4);
                }
                else if(object0 instanceof SuperscriptSpan) {
                    d0.a(new M(0L, 0L, null, null, null, null, null, 0L, new l1.a(0.5f), null, null, 0L, null, null, 0xFEFF), v3, v4);
                }
                else if(object0 instanceof TypefaceSpan) {
                    String s3 = ((TypefaceSpan)object0).getFamily();
                    if(q.b(s3, "cursive")) {
                        a0 = j.e;
                    }
                    else if(q.b(s3, "monospace")) {
                        a0 = j.d;
                    }
                    else if(q.b(s3, "sans-serif")) {
                        a0 = j.b;
                    }
                    else if(q.b(s3, "serif")) {
                        a0 = j.c;
                    }
                    else {
                        String s4 = ((TypefaceSpan)object0).getFamily();
                        if(s4 == null || s4.length() == 0) {
                            a1 = null;
                        }
                        else {
                            Typeface typeface0 = Typeface.create(s4, 0);
                            Typeface typeface1 = Typeface.DEFAULT;
                            if(q.b(typeface0, typeface1) || q.b(typeface0, Typeface.create(typeface1, 0))) {
                                typeface0 = null;
                            }
                            if(typeface0 != null) {
                                a1 = new B(new Ga(typeface0, 8));
                            }
                        }
                        a0 = a1;
                    }
                    d0.a(new M(0L, 0L, null, null, null, a0, null, 0L, null, null, null, 0L, null, null, 0xFFDF), v3, v4);
                }
                else if(object0 instanceof UnderlineSpan) {
                    d0.a(new M(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, l.c, null, 0xEFFF), v3, v4);
                }
                else if(object0 instanceof URLSpan) {
                    String s5 = ((URLSpan)object0).getURL();
                    if(s5 != null) {
                        arrayList0.add(new a1.c(new v(s5, ((v & 2) == 0 ? s1 : null)), v3, v4, 8));
                    }
                }
            }
        }
        return d0.h();
    }

    public static final U i(U u0, m m0) {
        b b1;
        M m1 = u0.a;
        l1.p p0 = m1.a.equals(l1.n.a) ? N.d : m1.a;
        long v = (m1.b & 0xFF00000000L) == 0L ? N.a : m1.b;
        y y0 = m1.c == null ? y.f : m1.c;
        e1.s s0 = new e1.s((m1.d == null ? 0 : m1.d.a));
        e1.t t0 = new e1.t((m1.e == null ? 0xFFFF : m1.e.a));
        j j0 = m1.f;
        if(j0 == null) {
            j0 = j.a;
        }
        String s1 = m1.g == null ? "" : m1.g;
        long v1 = (m1.h & 0xFF00000000L) == 0L ? N.b : m1.h;
        l1.a a0 = new l1.a((m1.i == null ? 0.0f : m1.i.a));
        l1.q q0 = m1.j == null ? l1.q.c : m1.j;
        b b0 = m1.k;
        if(b0 == null) {
            V v2 = h1.c.a;
            v2.getClass();
            LocaleList localeList0 = LocaleList.getDefault();
            synchronized(((e3.h)v2.c)) {
                b1 = (b)v2.b;
                if(b1 == null || localeList0 != ((LocaleList)v2.a)) {
                    int v4 = localeList0.size();
                    ArrayList arrayList0 = new ArrayList(v4);
                    for(int v5 = 0; v5 < v4; ++v5) {
                        arrayList0.add(new h1.a(localeList0.get(v5)));
                    }
                    b1 = new b(arrayList0);
                    v2.a = localeList0;
                    v2.b = b1;
                }
            }
            b0 = b1;
        }
        long v6 = m1.l == 16L ? N.c : m1.l;
        l l0 = m1.m == null ? l.b : m1.m;
        P p1 = m1.n == null ? P.d : m1.n;
        e e0 = m1.o;
        if(e0 == null) {
            e0 = A0.h.b;
        }
        M m2 = new M(p0, v, y0, s0, t0, j0, s1, v1, a0, q0, b0, v6, l0, p1, e0);
        D d0 = u0.b;
        int v7 = d0.a;
        int v8 = 5;
        if(v7 == 0x80000000) {
            v7 = 5;
        }
        int v9 = d0.b;
        if(v9 == 3) {
            switch(m0.ordinal()) {
                case 0: {
                    return new U(m2, new D(v7, 4, ((d0.c & 0xFF00000000L) == 0L ? E.a : d0.c), (d0.d == null ? l1.r.c : d0.d), d0.e, d0.f, (d0.g == 0 ? l1.e.b : d0.g), (d0.h == 0x80000000 ? 1 : d0.h), (d0.i == null ? l1.t.c : d0.i)), u0.c);
                }
                case 1: {
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
        else {
            if(v9 == 0x80000000) {
                switch(m0.ordinal()) {
                    case 0: {
                        return new U(m2, new D(v7, 1, ((d0.c & 0xFF00000000L) == 0L ? E.a : d0.c), (d0.d == null ? l1.r.c : d0.d), d0.e, d0.f, (d0.g == 0 ? l1.e.b : d0.g), (d0.h == 0x80000000 ? 1 : d0.h), (d0.i == null ? l1.t.c : d0.i)), u0.c);
                    }
                    case 1: {
                        return new U(m2, new D(v7, 2, ((d0.c & 0xFF00000000L) == 0L ? E.a : d0.c), (d0.d == null ? l1.r.c : d0.d), d0.e, d0.f, (d0.g == 0 ? l1.e.b : d0.g), (d0.h == 0x80000000 ? 1 : d0.h), (d0.i == null ? l1.t.c : d0.i)), u0.c);
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            v8 = v9;
        }
        return new U(m2, new D(v7, v8, ((d0.c & 0xFF00000000L) == 0L ? E.a : d0.c), (d0.d == null ? l1.r.c : d0.d), d0.e, d0.f, (d0.g == 0 ? l1.e.b : d0.g), (d0.h == 0x80000000 ? 1 : d0.h), (d0.i == null ? l1.t.c : d0.i)), u0.c);
    }
}

