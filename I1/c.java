package i1;

import a1.C;
import a1.D;
import a1.F;
import a1.G;
import a1.H;
import a1.M;
import a1.U;
import a1.m;
import android.graphics.Typeface;
import android.os.LocaleList;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.LeadingMarginSpan.Standard;
import android.text.style.ScaleXSpan;
import androidx.compose.runtime.b1;
import androidx.media3.session.legacy.V;
import b1.e;
import d1.f;
import d1.g;
import d1.k;
import e1.i;
import e1.j;
import e1.s;
import e1.y;
import h1.a;
import h1.b;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import l1.l;
import l1.p;
import l1.q;
import l1.r;
import l1.t;
import r1.o;
import y0.O;
import y0.P;
import y0.T;

public final class c implements C {
    public final String a;
    public final U b;
    public final List c;
    public final List d;
    public final i e;
    public final r1.c f;
    public final d g;
    public final CharSequence h;
    public final e i;
    public V j;
    public final boolean k;
    public final int l;

    public c(String s, U u0, List list0, List list1, i i0, r1.c c0) {
        int v63;
        int v62;
        int v60;
        Spannable spannable1;
        float f14;
        float f13;
        float f12;
        f f11;
        int v48;
        long v41;
        int v38;
        D d4;
        int v37;
        int v36;
        int v27;
        M m4;
        Collection collection1;
        ArrayList arrayList3;
        D d3;
        float f9;
        float f8;
        D d2;
        float f7;
        boolean z3;
        List list2;
        M m1;
        p p1;
        Object object0;
        Locale locale0;
        int v1;
        this.a = s;
        this.b = u0;
        this.c = list0;
        this.d = list1;
        this.e = i0;
        this.f = c0;
        float f = c0.b();
        d d0 = new d(1);  // 初始化器: Landroid/text/TextPaint;-><init>(I)V
        d0.density = f;
        d0.b = l.b;
        d0.c = 3;
        d0.d = P.d;
        this.g = d0;
        b1 b10 = (b1)h.a.b;
        if(b10 == null) {
            b10 = i1.i.a;
        }
        this.k = ((Boolean)b10.getValue()).booleanValue();
        int v = u0.b.b;
        b b0 = u0.a.k;
        switch(v) {
            case 1: {
                v1 = 0;
                goto label_38;
            }
            case 2: {
                v1 = 1;
                goto label_38;
            }
            case 3: {
            label_27:
                if(b0 == null) {
                    locale0 = Locale.getDefault();
                }
                else {
                    locale0 = ((a)b0.a.get(0)).a;
                    if(locale0 == null) {
                        locale0 = Locale.getDefault();
                    }
                }
                if(TextUtils.getLayoutDirectionFromLocale(locale0) == 1) {
                    break;
                }
                else {
                    v1 = 2;
                }
                goto label_38;
            }
            case 4: {
                v1 = 2;
                goto label_38;
            }
            case 5: {
                break;
            }
            default: {
                if(v != 0x80000000) {
                    throw new IllegalStateException("Invalid TextDirection.");
                }
                goto label_27;
            }
        }
        v1 = 3;
    label_38:
        this.l = v1;
        O.h h0 = new O.h(this, 1);
        t t0 = u0.b.i == null ? t.c : u0.b.i;
        d0.setFlags((t0.b ? d0.getFlags() | 0x80 : d0.getFlags() & 0xFFFFFF7F));
        int v2 = t0.a;
        if(v2 == 1) {
            d0.setFlags(d0.getFlags() | 0x40);
            d0.setHinting(0);
        }
        else if(v2 == 2) {
            d0.getFlags();
            d0.setHinting(1);
        }
        else if(v2 == 3) {
            d0.getFlags();
            d0.setHinting(0);
        }
        else {
            d0.getFlags();
        }
        M m0 = u0.a;
        int v3 = list0.size();
        for(int v4 = 0; true; ++v4) {
            object0 = null;
            if(v4 >= v3) {
                break;
            }
            Object object1 = list0.get(v4);
            if(((a1.e)object1).a instanceof M) {
                object0 = object1;
                break;
            }
        }
        long v5 = m0.b;
        String s1 = m0.g;
        b b1 = m0.k;
        p p0 = m0.a;
        q q0 = m0.j;
        long v6 = m0.h;
        long v7 = o.b(v5);
        if(r1.p.a(v7, 0x100000000L)) {
            d0.setTextSize(c0.B(v5));
        }
        else if(r1.p.a(v7, 0x200000000L)) {
            d0.setTextSize(o.c(v5) * d0.getTextSize());
        }
        j j0 = m0.f;
        if(j0 != null || m0.d != null || m0.c != null) {
            d0.setTypeface(((Typeface)h0.invoke(j0, (m0.c == null ? y.f : m0.c), new s((m0.d == null ? 0 : m0.d.a)), new e1.t((m0.e == null ? 0xFFFF : m0.e.a)))));
        }
        if(b1 == null) {
            p1 = p0;
        }
        else {
            V v8 = h1.c.a;
            v8.getClass();
            LocaleList localeList0 = LocaleList.getDefault();
            e3.h h1 = (e3.h)v8.c;
            __monitor_enter(h1);
            try {
                b b2 = (b)v8.b;
                if(b2 != null && localeList0 == ((LocaleList)v8.a)) {
                    goto label_108;
                }
                else {
                    int v9 = localeList0.size();
                    ArrayList arrayList0 = new ArrayList(v9);
                    for(int v10 = 0; v10 < v9; ++v10) {
                        arrayList0.add(new a(localeList0.get(v10)));
                    }
                    p1 = p0;
                    b2 = new b(arrayList0);
                    v8.a = localeList0;
                    v8.b = b2;
                    goto label_106;
                }
                goto label_110;
            }
            catch(Throwable throwable0) {
            }
            __monitor_exit(h1);
            throw throwable0;
        label_106:
            __monitor_exit(h1);
            goto label_110;
        label_108:
            __monitor_exit(h1);
            p1 = p0;
        label_110:
            if(!b1.equals(b2)) {
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, b1));
                for(Object object2: b1.a) {
                    arrayList1.add(((a)object2).a);
                }
                Locale[] arr_locale = (Locale[])arrayList1.toArray(new Locale[0]);
                d0.setTextLocales(new LocaleList(((Locale[])Arrays.copyOf(arr_locale, arr_locale.length))));
            }
        }
        if(s1 != null && !s1.equals("")) {
            d0.setFontFeatureSettings(s1);
        }
        if(q0 != null && !q0.equals(q.c)) {
            d0.setTextScaleX(d0.getTextScaleX() * q0.a);
            d0.setTextSkewX(d0.getTextSkewX() + q0.b);
        }
        d0.d(p1.b());
        d0.c(p1.c(), 0x7FC000007FC00000L, p1.a());
        d0.f(m0.n);
        d0.g(m0.m);
        d0.e(m0.o);
        if(r1.p.a(o.b(v6), 0x100000000L) && o.c(v6) != 0.0f) {
            float f1 = d0.getTextSize();
            float f2 = d0.getTextScaleX() * f1;
            float f3 = c0.B(v6);
            if(f2 != 0.0f) {
                d0.setLetterSpacing(f3 / f2);
            }
        }
        else if(r1.p.a(o.b(v6), 0x200000000L)) {
            d0.setLetterSpacing(o.c(v6));
        }
        long v11 = m0.l;
        l1.a a0 = m0.i;
        boolean z = object0 != null && r1.p.a(o.b(v6), 0x100000000L) && o.c(v6) != 0.0f;
        long v12 = y0.s.g;
        boolean z1 = !y0.s.d(v11, v12) && !y0.s.d(v11, y0.s.f);
        boolean z2 = a0 != null && Float.compare(a0.a, 0.0f) != 0;
        if(z || z1 || z2) {
            if(!z) {
                v6 = o.c;
            }
            m1 = new M(0L, 0L, null, null, null, null, null, v6, (z2 ? a0 : null), null, null, (z1 ? v11 : v12), null, null, 0xF67F);
        }
        else {
            m1 = null;
        }
        if(m1 == null) {
            list2 = this.c;
        }
        else {
            int v13 = this.c.size();
            list2 = new ArrayList(v13 + 1);
            for(int v14 = 0; v14 < v13 + 1; ++v14) {
                ((ArrayList)list2).add((v14 == 0 ? new a1.e(m1, 0, this.a.length()) : ((a1.e)this.c.get(v14 - 1))));
            }
        }
        String s2 = this.a;
        float f4 = this.g.getTextSize();
        U u1 = this.b;
        List list3 = this.d;
        r1.c c1 = this.f;
        CharSequence charSequence0 = s2;
        if(!list2.isEmpty() || !list3.isEmpty() || !kotlin.jvm.internal.q.b(u1.b.d, r.c) || (u1.b.c & 0xFF00000000L) != 0L) {
            Spannable spannable0 = charSequence0 instanceof Spannable ? ((Spannable)charSequence0) : new SpannableString(charSequence0);
            D d1 = u1.b;
            if(kotlin.jvm.internal.q.b(u1.a.m, l.c)) {
                df.d.M(spannable0, i1.b.a, 0, s2.length());
            }
            H h2 = u1.c;
            if(h2 == null) {
                z3 = false;
            }
            else {
                G g0 = h2.a;
                z3 = g0 == null ? false : g0.a;
            }
            if(!z3 || d1.f != null) {
                l1.i i1 = d1.f == null ? l1.i.c : d1.f;
                float f6 = df.d.H(d1.c, f4, c1);
                if(!Float.isNaN(f6)) {
                    spannable0.setSpan(new d1.h(f6, (spannable0.length() != 0 && Tf.o.I0(spannable0) != 10 ? spannable0.length() : spannable0.length() + 1), (i1.b & 1) > 0, (i1.b & 16) > 0, i1.a, false), 0, spannable0.length(), 33);
                }
            }
            else {
                float f5 = df.d.H(d1.c, f4, c1);
                if(!Float.isNaN(f5)) {
                    spannable0.setSpan(new g(f5), 0, spannable0.length(), 33);
                }
            }
            r r0 = d1.d;
            if(r0 == null) {
                f7 = f4;
                d2 = d1;
            }
            else {
                long v15 = r0.a;
                long v16 = r0.b;
                f7 = f4;
                if(o.a(v15, 0x100000000L) && o.a(v16, 0x100000000L) || (v15 & 0xFF00000000L) == 0L) {
                    d2 = d1;
                }
                else if((v16 & 0xFF00000000L) != 0L) {
                    long v17 = o.b(v15);
                    d2 = d1;
                    if(r1.p.a(v17, 0x100000000L)) {
                        f8 = c1.B(v15);
                    }
                    else {
                        f8 = r1.p.a(v17, 0x200000000L) ? o.c(v15) * f7 : 0.0f;
                    }
                    long v18 = o.b(v16);
                    if(r1.p.a(v18, 0x100000000L)) {
                        f9 = c1.B(v16);
                    }
                    else {
                        f9 = r1.p.a(v18, 0x200000000L) ? o.c(v16) * f7 : 0.0f;
                    }
                    spannable0.setSpan(new LeadingMarginSpan.Standard(((int)(((float)Math.ceil(f8)))), ((int)(((float)Math.ceil(f9))))), 0, spannable0.length(), 33);
                }
                else {
                    d2 = d1;
                }
            }
            ArrayList arrayList2 = new ArrayList(list2.size());
            Collection collection0 = list2;
            int v19 = collection0.size();
            for(int v20 = 0; v20 < v19; ++v20) {
                a1.e e0 = (a1.e)list2.get(v20);
                if(e0.a instanceof M && (((M)e0.a).f != null || ((M)e0.a).d != null || ((M)e0.a).c != null || ((M)e0.a).e != null)) {
                    arrayList2.add(e0);
                }
            }
            M m2 = u1.a.f != null || u1.a.d != null || u1.a.c != null || u1.a.e != null ? new M(0L, 0L, u1.a.c, u1.a.d, u1.a.e, u1.a.f, null, 0L, null, null, null, 0L, null, null, 0xFFC3) : null;
            F.C c2 = new F.C(7, spannable0, h0);
            if(arrayList2.size() <= 1) {
                if(!arrayList2.isEmpty()) {
                    M m3 = (M)((a1.e)arrayList2.get(0)).a;
                    if(m2 != null) {
                        m3 = m2.c(m3);
                    }
                    c2.invoke(m3, ((a1.e)arrayList2.get(0)).b, ((a1.e)arrayList2.get(0)).c);
                }
                d3 = d2;
                goto label_286;
            }
            else {
                int v21 = arrayList2.size();
                int[] arr_v = new int[v21 * 2];
                int v22 = arrayList2.size();
                for(int v23 = 0; v23 < v22; ++v23) {
                    Object object3 = arrayList2.get(v23);
                    arr_v[v23] = ((a1.e)object3).b;
                    arr_v[v23 + v21] = ((a1.e)object3).c;
                }
                d3 = d2;
                if(v21 * 2 > 1) {
                    Arrays.sort(arr_v);
                }
                if(v21 * 2 == 0) {
                    throw new NoSuchElementException("Array is empty.");
                }
                int v24 = arr_v[0];
                int v25 = 0;
                while(v25 < v21 * 2) {
                    int v26 = arr_v[v25];
                    if(v26 == v24) {
                        arrayList3 = arrayList2;
                        collection1 = collection0;
                        m4 = m2;
                        v27 = v25;
                    }
                    else {
                        int v28 = arrayList2.size();
                        collection1 = collection0;
                        M m5 = m2;
                        for(int v29 = 0; v29 < v28; ++v29) {
                            a1.e e1 = (a1.e)arrayList2.get(v29);
                            if(e1.b != e1.c && a1.i.b(v24, v26, e1.b, e1.c)) {
                                M m6 = (M)e1.a;
                                if(m5 != null) {
                                    m6 = m5.c(m6);
                                }
                                m5 = m6;
                            }
                        }
                        arrayList3 = arrayList2;
                        m4 = m2;
                        v27 = v25;
                        if(m5 != null) {
                            c2.invoke(m5, v24, v26);
                        }
                        v24 = v26;
                    }
                    v25 = v27 + 1;
                    collection0 = collection1;
                    m2 = m4;
                    arrayList2 = arrayList3;
                }
            label_286:
                int v30 = collection0.size();
                int v31 = 0;
                int v32 = 0;
                while(v31 < v30) {
                    a1.e e2 = (a1.e)list2.get(v31);
                    Object object4 = e2.a;
                    if(object4 instanceof M) {
                        int v33 = e2.b;
                        int v34 = e2.c;
                        if(v33 < 0 || v33 >= spannable0.length() || v34 <= v33 || v34 > spannable0.length()) {
                            goto label_345;
                        }
                        else {
                            l1.a a1 = ((M)object4).i;
                            long v35 = ((M)object4).h;
                            p p2 = ((M)object4).a;
                            if(a1 == null) {
                                v36 = v30;
                            }
                            else {
                                v36 = v30;
                                spannable0.setSpan(new d1.a(a1.a, 0), v33, v34, 33);
                            }
                            v37 = v32;
                            df.d.J(spannable0, p2.b(), v33, v34);
                            y0.o o0 = p2.c();
                            float f10 = p2.a();
                            if(o0 != null) {
                                if(o0 instanceof T) {
                                    df.d.J(spannable0, ((T)o0).a, v33, v34);
                                }
                                else {
                                    spannable0.setSpan(new k1.d(((O)o0), f10), v33, v34, 33);
                                }
                            }
                            l l0 = ((M)object4).m;
                            if(l0 != null) {
                                spannable0.setSpan(new k((l0.a | 1) == l0.a, (l0.a | 2) == l0.a), v33, v34, 33);
                            }
                            d4 = d3;
                            df.d.K(spannable0, ((M)object4).b, c1, v33, v34);
                            String s3 = ((M)object4).g;
                            if(s3 == null) {
                                v38 = v31;
                            }
                            else {
                                v38 = v31;
                                spannable0.setSpan(new d1.b(s3, 0), v33, v34, 33);
                            }
                            q q1 = ((M)object4).j;
                            if(q1 != null) {
                                spannable0.setSpan(new ScaleXSpan(q1.a), v33, v34, 33);
                                spannable0.setSpan(new d1.a(q1.b, 1), v33, v34, 33);
                            }
                            df.d.L(spannable0, ((M)object4).k, v33, v34);
                            long v39 = ((M)object4).l;
                            if(v39 != 16L) {
                                spannable0.setSpan(new BackgroundColorSpan(y0.M.z(v39)), v33, v34, 33);
                            }
                            P p3 = ((M)object4).n;
                            if(p3 == null) {
                                v41 = v35;
                            }
                            else {
                                int v40 = y0.M.z(p3.a);
                                v41 = v35;
                                spannable0.setSpan(new d1.j(Float.intBitsToFloat(((int)(p3.b >> 0x20))), Float.intBitsToFloat(((int)(p3.b & 0xFFFFFFFFL))), (p3.c == 0.0f ? 1.401298E-45f : p3.c), v40), v33, v34, 33);
                            }
                            A0.e e3 = ((M)object4).o;
                            if(e3 != null) {
                                spannable0.setSpan(new k1.c(e3), v33, v34, 33);
                            }
                            if(r1.p.a(o.b(v41), 0x100000000L) || r1.p.a(o.b(v41), 0x200000000L)) {
                                v37 = 1;
                            }
                        }
                    }
                    else {
                    label_345:
                        v36 = v30;
                        v37 = v32;
                        d4 = d3;
                        v38 = v31;
                    }
                    v31 = v38 + 1;
                    d3 = d4;
                    v32 = v37;
                    v30 = v36;
                }
                if(v32 != 0) {
                    int v42 = collection0.size();
                    int v43 = 0;
                    while(v43 < v42) {
                        a1.e e4 = (a1.e)list2.get(v43);
                        a1.b b3 = (a1.b)e4.a;
                        if(b3 instanceof M) {
                            int v44 = e4.b;
                            int v45 = e4.c;
                            if(v44 < 0 || v44 >= spannable0.length() || v45 <= v44 || v45 > spannable0.length()) {
                                v48 = v43;
                            }
                            else {
                                long v46 = ((M)b3).h;
                                long v47 = o.b(v46);
                                v48 = v43;
                                if(r1.p.a(v47, 0x100000000L)) {
                                    f11 = new f(c1.B(v46));
                                }
                                else if(r1.p.a(v47, 0x200000000L)) {
                                    f11 = new d1.e(o.c(v46));
                                }
                                else {
                                    f11 = null;
                                }
                                if(f11 != null) {
                                    spannable0.setSpan(f11, v44, v45, 33);
                                }
                            }
                            v43 = v48 + 1;
                        }
                        else {
                            ++v43;
                        }
                    }
                }
                r r1 = d3.d;
                if(r1 == null) {
                    f13 = 0.0f;
                }
                else {
                    long v49 = r1.a;
                    long v50 = o.b(v49);
                    if(r1.p.a(v50, 0x100000000L)) {
                        f12 = c1.B(v49);
                    }
                    else {
                        f12 = r1.p.a(v50, 0x200000000L) ? o.c(v49) * f7 : 0.0f;
                    }
                    f13 = f12;
                }
                int v51 = collection0.size();
                int v52 = 0;
                while(v52 < v51) {
                    a1.e e5 = (a1.e)list2.get(v52);
                    m m7 = e5.a instanceof m ? ((m)e5.a) : null;
                    if(m7 == null) {
                        f14 = f7;
                    }
                    else {
                        f14 = f7;
                        float f15 = df.d.G(m7.a, f14, c1);
                        float f16 = df.d.G(m7.b, f14, c1);
                        if(!Float.isNaN(f15) && !Float.isNaN(f16)) {
                            spannable1 = spannable0;
                            df.d.M(spannable1, new k1.b(f15, f15, f16, c1, f13), e5.b, e5.c);
                            goto label_408;
                        }
                    }
                    spannable1 = spannable0;
                label_408:
                    ++v52;
                    spannable0 = spannable1;
                    f7 = f14;
                }
                int v53 = list3.size();
                for(int v54 = 0; v54 < v53; ++v54) {
                    a1.e e6 = (a1.e)list3.get(v54);
                    F f17 = (F)e6.a;
                    int v55 = e6.b;
                    int v56 = e6.c;
                    Object[] arr_object = spannable0.getSpans(v55, v56, v2.t.class);
                    for(int v57 = 0; v57 < arr_object.length; ++v57) {
                        spannable0.removeSpan(((v2.t)arr_object[v57]));
                    }
                    long v58 = f17.b;
                    float f18 = o.c(f17.a);
                    long v59 = o.b(f17.a);
                    if(r1.p.a(v59, 0x100000000L)) {
                        v60 = 0;
                    }
                    else {
                        v60 = r1.p.a(v59, 0x200000000L) ? 1 : 2;
                    }
                    float f19 = o.c(v58);
                    long v61 = o.b(v58);
                    if(r1.p.a(v61, 0x100000000L)) {
                        v62 = 0;
                    }
                    else {
                        v62 = r1.p.a(v61, 0x200000000L) ? 1 : 2;
                    }
                    float f20 = c1.W();
                    float f21 = c1.b();
                    switch(f17.c) {
                        case 1: {
                            v63 = 0;
                            break;
                        }
                        case 2: {
                            v63 = 1;
                            break;
                        }
                        case 3: {
                            v63 = 2;
                            break;
                        }
                        case 4: {
                            v63 = 3;
                            break;
                        }
                        case 5: {
                            v63 = 4;
                            break;
                        }
                        case 6: {
                            v63 = 5;
                            break;
                        }
                        case 7: {
                            v63 = 6;
                            break;
                        }
                        default: {
                            throw new IllegalStateException("Invalid PlaceholderVerticalAlign");
                        }
                    }
                    spannable0.setSpan(new d1.i(f18, v60, v62, f19, f21 * f20, v63), v55, v56, 33);
                }
                charSequence0 = spannable0;
            }
        }
        this.h = charSequence0;
        this.i = new e(charSequence0, this.g, this.l);
    }

    @Override  // a1.C
    public final boolean b() {
        if(!(this.j == null ? false : this.j.q())) {
            if(!this.k) {
                b1 b10 = (b1)h.a.b;
                if(b10 == null) {
                    b10 = i1.i.a;
                }
                return ((Boolean)b10.getValue()).booleanValue();
            }
            return false;
        }
        return true;
    }

    @Override  // a1.C
    public final float c() {
        return this.i.c();
    }

    @Override  // a1.C
    public final float d() {
        float f;
        e e0 = this.i;
        TextPaint textPaint0 = e0.b;
        if(!Float.isNaN(e0.e)) {
            return e0.e;
        }
        BreakIterator breakIterator0 = BreakIterator.getLineInstance(textPaint0.getTextLocale());
        int v = e0.a.length();
        breakIterator0.setText(new b1.b(e0.a, v));
        PriorityQueue priorityQueue0 = new PriorityQueue(10, new E1.a(9));
        int v1 = breakIterator0.next();
        int v2 = 0;
        while(v1 != -1) {
            if(priorityQueue0.size() < 10) {
                priorityQueue0.add(new ie.m(v2, v1));
            }
            else {
                ie.m m0 = (ie.m)priorityQueue0.peek();
                if(m0 != null && ((Number)m0.b).intValue() - ((Number)m0.a).intValue() < v1 - v2) {
                    priorityQueue0.poll();
                    priorityQueue0.add(new ie.m(v2, v1));
                }
            }
            v2 = v1;
            v1 = breakIterator0.next();
        }
        if(priorityQueue0.isEmpty()) {
            f = 0.0f;
        }
        else {
            Iterator iterator0 = priorityQueue0.iterator();
            if(!iterator0.hasNext()) {
                throw new NoSuchElementException();
            }
            Object object0 = iterator0.next();
            float f1;
            for(f1 = Layout.getDesiredWidth(e0.b(), ((Number)((ie.m)object0).a).intValue(), ((Number)((ie.m)object0).b).intValue(), textPaint0); iterator0.hasNext(); f1 = Math.max(f1, Layout.getDesiredWidth(e0.b(), ((Number)((ie.m)object1).a).intValue(), ((Number)((ie.m)object1).b).intValue(), textPaint0))) {
                Object object1 = iterator0.next();
            }
            f = f1;
        }
        e0.e = f;
        return f;
    }
}

