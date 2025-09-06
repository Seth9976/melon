package H8;

import N5.c;
import N5.f;
import Q0.o0;
import Q5.n;
import Q5.u;
import Tf.o;
import Ve.f0;
import Ve.g0;
import Ve.h0;
import Y3.d;
import a1.B;
import a1.C;
import a1.D;
import a1.U;
import a1.g;
import a1.h;
import a1.z;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.m0;
import androidx.lifecycle.q0;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import e3.x;
import i.n.i.b.a.s.e.B5;
import i.n.i.b.a.s.e.E3;
import i.n.i.b.a.s.e.E7;
import i.n.i.b.a.s.e.F3;
import i.n.i.b.a.s.e.L7;
import i.n.i.b.a.s.e.T4;
import i.n.i.b.a.s.e.i7;
import i5.b;
import ie.j;
import ie.k;
import java.text.Bidi;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import je.m;
import je.p;
import je.w;
import jf.l;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.flow.MutableStateFlow;
import lf.e0;
import qf.e;
import we.a;

public final class i implements f, d, C, T4, j, l {
    public final int a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;

    public i() {
        this.a = 3;
        super();
    }

    public i(De.d d0, a a0, a a1, a a2) {
        this.a = 5;
        q.g(d0, "viewModelClass");
        super();
        this.b = d0;
        this.c = (r)a0;
        this.d = a1;
        this.e = (r)a2;
    }

    public i(H8.q q0, H8.q q1, e e0, ArrayList arrayList0) {
        this.a = 11;
        super();
        this.c = q0;
        this.d = q1;
        this.e = e0;
        this.f = arrayList0;
        this.b = q0;
    }

    public i(Q5.j j0, String s, c c0, N5.e e0, u u0) {
        this.a = 1;
        super();
        this.b = j0;
        this.c = s;
        this.d = c0;
        this.e = e0;
        this.f = u0;
    }

    public i(g g0, U u0, List list0, r1.c c0, e1.i i0) {
        List list6;
        ArrayList arrayList3;
        String s1;
        this.a = 4;
        super();
        this.b = g0;
        this.c = list0;
        z z0 = new z(this, 1);
        this.d = d3.g.P(k.c, z0);
        z z1 = new z(this, 0);
        this.e = d3.g.P(k.c, z1);
        D d0 = u0.b;
        ArrayList arrayList0 = g0.d;
        String s = g0.b;
        w w0 = w.a;
        List list1 = arrayList0 == null ? w0 : p.J0(arrayList0, new a1.f(1));
        ArrayList arrayList1 = new ArrayList();
        m m0 = new m();
        int v = list1.size();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            a1.e e0 = (a1.e)list1.get(v1);
            a1.e e1 = a1.e.a(e0, d0.a(((D)e0.a)), 0, 14);
            Object object0 = e1.a;
            int v3 = e1.c;
            int v4 = e1.b;
            while(v2 < v4 && !m0.isEmpty()) {
                a1.e e2 = (a1.e)m0.last();
                int v5 = e2.c;
                Object object1 = e2.a;
                if(v4 < v5) {
                    arrayList1.add(new a1.e(object1, v2, v4));
                    v2 = v4;
                }
                else {
                    arrayList1.add(new a1.e(object1, v2, v5));
                    v2 = e2.c;
                    while(!m0.isEmpty() && v2 == ((a1.e)m0.last()).c) {
                        m0.removeLast();
                    }
                }
            }
            if(v2 < v4) {
                arrayList1.add(new a1.e(d0, v2, v4));
                v2 = v4;
            }
            a1.e e3 = (a1.e)m0.k();
            if(e3 == null) {
                m0.addLast(new a1.e(object0, v4, v3));
            }
            else {
                int v6 = e3.c;
                Object object2 = e3.a;
                int v7 = e3.b;
                if(v7 == v4 && v6 == v3) {
                    m0.removeLast();
                    m0.addLast(new a1.e(((D)object2).a(((D)object0)), v4, v3));
                }
                else if(v7 == v6) {
                    arrayList1.add(new a1.e(object2, v7, v6));
                    m0.removeLast();
                    m0.addLast(new a1.e(object0, v4, v3));
                }
                else {
                    if(v6 < v3) {
                        throw new IllegalArgumentException();
                    }
                    m0.addLast(new a1.e(((D)object2).a(((D)object0)), v4, v3));
                }
            }
        }
        while(v2 <= s.length() && !m0.isEmpty()) {
            a1.e e4 = (a1.e)m0.last();
            int v8 = e4.c;
            arrayList1.add(new a1.e(e4.a, v2, v8));
            while(!m0.isEmpty() && v8 == ((a1.e)m0.last()).c) {
                m0.removeLast();
            }
            v2 = v8;
        }
        if(v2 < s.length()) {
            arrayList1.add(new a1.e(d0, v2, s.length()));
        }
        if(arrayList1.isEmpty()) {
            arrayList1.add(new a1.e(d0, 0, 0));
        }
        ArrayList arrayList2 = new ArrayList(arrayList1.size());
        int v9 = arrayList1.size();
        int v10 = 0;
        while(v10 < v9) {
            a1.e e5 = (a1.e)arrayList1.get(v10);
            int v11 = e5.b;
            int v12 = e5.c;
            if(v11 == v12) {
                s1 = "";
            }
            else {
                s1 = s.substring(v11, v12);
                q.f(s1, "substring(...)");
            }
            List list2 = a1.i.a(g0, v11, v12, h.g);
            if(list2 == null) {
                list2 = w0;
            }
            g g1 = new g(s1, list2);
            D d1 = (D)e5.a;
            if(d1.b == 0x80000000) {
                arrayList3 = arrayList1;
                d1 = new D(d1.a, d0.b, d1.c, d1.d, d1.e, d1.f, d1.g, d1.h, d1.i);
            }
            else {
                arrayList3 = arrayList1;
            }
            D d2 = d0.a(d1);
            U u1 = new U(u0.a, d2);
            List list3 = g1.a;
            List list4 = list3 == null ? w0 : list3;
            List list5 = (List)this.c;
            ArrayList arrayList4 = new ArrayList(list5.size());
            int v13 = list5.size();
            int v14 = 0;
            while(v14 < v13) {
                a1.e e6 = (a1.e)list5.get(v14);
                int v15 = e6.b;
                int v16 = e6.c;
                if(a1.i.b(v11, v12, v15, v16)) {
                    if(v11 > v15 || v16 > v12) {
                        g1.a.a("placeholder can not overlap with paragraph.");
                    }
                    list6 = list5;
                    arrayList4.add(new a1.e(e6.a, v15 - v11, v16 - v11));
                }
                else {
                    list6 = list5;
                }
                ++v14;
                list5 = list6;
            }
            arrayList2.add(new B(new i1.c(s1, u1, list4, arrayList4, i0, c0), v11, v12));
            ++v10;
            arrayList1 = arrayList3;
        }
        this.f = arrayList2;
    }

    public i(SharedPreferences sharedPreferences0, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor0) {
        this.a = 7;
        super();
        this.e = new ArrayDeque();
        this.b = sharedPreferences0;
        this.c = "topic_operation_queue";
        this.d = ",";
        this.f = scheduledThreadPoolExecutor0;
    }

    public i(Layout layout0) {
        this.a = 6;
        super();
        this.b = layout0;
        ArrayList arrayList0 = new ArrayList();
        int v1 = 0;
        do {
            int v2 = o.E0(((Layout)this.b).getText(), '\n', v1, 4);
            v1 = v2 >= 0 ? v2 + 1 : ((Layout)this.b).getText().length();
            arrayList0.add(v1);
        }
        while(v1 < ((Layout)this.b).getText().length());
        this.c = arrayList0;
        int v3 = arrayList0.size();
        ArrayList arrayList1 = new ArrayList(v3);
        for(int v = 0; v < v3; ++v) {
            arrayList1.add(null);
        }
        this.d = arrayList1;
        this.e = new boolean[((ArrayList)this.c).size()];
        ((ArrayList)this.c).size();
    }

    public i(LocalContentDatabase_Impl localContentDatabase_Impl0) {
        this.a = 0;
        super();
        this.b = localContentDatabase_Impl0;
        this.c = new Eb.f(2);
        this.d = new H8.h(0);
        this.e = new H8.h(1);
        this.f = new H8.h(2);
    }

    public i(e4.c c0, HashMap hashMap0, HashMap hashMap1, HashMap hashMap2) {
        this.a = 8;
        super();
        this.b = c0;
        this.e = hashMap1;
        this.f = hashMap2;
        this.d = Collections.unmodifiableMap(hashMap0);
        TreeSet treeSet0 = new TreeSet();
        int v = 0;
        c0.d(treeSet0, false);
        long[] arr_v = new long[treeSet0.size()];
        for(Object object0: treeSet0) {
            arr_v[v] = (long)(((Long)object0));
            ++v;
        }
        this.c = arr_v;
    }

    public i(i7 i70, HashMap hashMap0, HashMap hashMap1, HashMap hashMap2) {
        this.a = 9;
        super();
        this.b = i70;
        this.e = hashMap1;
        this.f = hashMap2;
        this.d = Collections.unmodifiableMap(hashMap0);
        TreeSet treeSet0 = new TreeSet();
        int v = 0;
        i70.h(treeSet0, false);
        long[] arr_v = new long[treeSet0.size()];
        for(Object object0: treeSet0) {
            arr_v[v] = (long)(((Long)object0));
            ++v;
        }
        this.c = arr_v;
    }

    public i(b b0) {
        this.a = 10;
        super();
        this.b = p.Q0(b0.a);
        this.c = p.Q0(b0.b);
        this.d = p.Q0(b0.c);
        this.e = p.Q0(b0.d);
        this.f = p.Q0(b0.e);
    }

    public i(Map map0) {
        this.a = 2;
        q.g(map0, "initialState");
        super();
        this.b = je.C.a0(map0);
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new o0(this, 1);
    }

    public i(m6.e e0) {
        this.a = 12;
        super();
        this.b = (ViewGroup)e0;
        this.c = (ViewGroup)(((View)e0));
        ((View)e0).setWillNotDraw(false);
        new Path();
        new Paint(7);
        Paint paint0 = new Paint(1);
        this.d = paint0;
        paint0.setColor(0);
    }

    public i(nf.g g0, e0 e00, ie.e e0, Integer integer0, String s) {
        this.a = 13;
        q.g(e00, "kind");
        super();
        this.b = g0;
        this.c = e00;
        this.d = e0;
        this.e = integer0;
        this.f = s;
    }

    public void A(int v) {
        ((Paint)this.d).setColor(v);
        ((ViewGroup)this.c).invalidate();
    }

    public void B(m6.d d0) {
        ViewGroup viewGroup0 = (ViewGroup)this.c;
        if(d0 == null) {
            this.e = null;
        }
        else {
            m6.d d1 = (m6.d)this.e;
            if(d1 == null) {
                this.e = new m6.d(d0);
            }
            else {
                d1.a = d0.a;
                d1.b = d0.b;
                d1.c = d0.c;
            }
            if(d0.c + 0.0001f >= e2.a.A(d0.a, d0.b, viewGroup0.getWidth(), viewGroup0.getHeight())) {
                ((m6.d)this.e).c = 3.402823E+38f;
            }
        }
        viewGroup0.invalidate();
    }

    @Override  // i.n.i.b.a.s.e.T4
    public int a() {
        return ((long[])this.c).length;
    }

    @Override  // i.n.i.b.a.s.e.T4
    public int a(long v) {
        long[] arr_v = (long[])this.c;
        int v1 = L7.g(arr_v, v, false);
        return v1 >= arr_v.length ? -1 : v1;
    }

    @Override  // i.n.i.b.a.s.e.T4
    public long a(int v) {
        return ((long[])this.c)[v];
    }

    @Override  // i.n.i.b.a.s.e.T4
    public List b(long v) {
        i7 i70 = (i7)this.b;
        Map map0 = (Map)this.d;
        HashMap hashMap0 = (HashMap)this.e;
        HashMap hashMap1 = (HashMap)this.f;
        ArrayList arrayList0 = new ArrayList();
        i70.e(v, i70.h, arrayList0);
        TreeMap treeMap0 = new TreeMap();
        i70.g(v, false, i70.h, treeMap0);
        i70.f(v, map0, hashMap0, i70.h, treeMap0);
        List list0 = new ArrayList();
        for(Object object0: arrayList0) {
            Pair pair0 = (Pair)object0;
            String s = (String)hashMap1.get(pair0.second);
            if(s != null) {
                byte[] arr_b = Base64.decode(s, 0);
                Bitmap bitmap0 = BitmapFactory.decodeByteArray(arr_b, 0, arr_b.length);
                E7 e70 = (E7)hashMap0.get(pair0.first);
                e70.getClass();
                ((ArrayList)list0).add(new F3(null, null, null, bitmap0, e70.c, 0, e70.e, e70.b, 0, 0x80000000, -3.402823E+38f, e70.f, e70.g, false, 0xFF000000, e70.j, 0.0f, null, null));
            }
        }
        for(Object object1: treeMap0.entrySet()) {
            E7 e71 = (E7)hashMap0.get(((Map.Entry)object1).getKey());
            e71.getClass();
            E3 e30 = (E3)((Map.Entry)object1).getValue();
            CharSequence charSequence0 = e30.a;
            charSequence0.getClass();
            SpannableStringBuilder spannableStringBuilder0 = (SpannableStringBuilder)charSequence0;
            B5[] arr_b5 = (B5[])spannableStringBuilder0.getSpans(0, spannableStringBuilder0.length(), B5.class);
            for(int v1 = 0; v1 < arr_b5.length; ++v1) {
                B5 b50 = arr_b5[v1];
                spannableStringBuilder0.replace(spannableStringBuilder0.getSpanStart(b50), spannableStringBuilder0.getSpanEnd(b50), "");
            }
            for(int v2 = 0; v2 < spannableStringBuilder0.length(); ++v2) {
                if(spannableStringBuilder0.charAt(v2) == 0x20) {
                    int v3;
                    for(v3 = v2 + 1; v3 < spannableStringBuilder0.length() && spannableStringBuilder0.charAt(v3) == 0x20; ++v3) {
                    }
                    int v4 = v3 - (v2 + 1);
                    if(v4 > 0) {
                        spannableStringBuilder0.delete(v2, v4 + v2);
                    }
                }
            }
            if(spannableStringBuilder0.length() > 0 && spannableStringBuilder0.charAt(0) == 0x20) {
                spannableStringBuilder0.delete(0, 1);
            }
            for(int v5 = 0; v5 < spannableStringBuilder0.length() - 1; ++v5) {
                if(spannableStringBuilder0.charAt(v5) == 10 && spannableStringBuilder0.charAt(v5 + 1) == 0x20) {
                    spannableStringBuilder0.delete(v5 + 1, v5 + 2);
                }
            }
            if(spannableStringBuilder0.length() > 0 && spannableStringBuilder0.charAt(spannableStringBuilder0.length() - 1) == 0x20) {
                spannableStringBuilder0.delete(spannableStringBuilder0.length() - 1, spannableStringBuilder0.length());
            }
            for(int v6 = 0; v6 < spannableStringBuilder0.length() - 1; ++v6) {
                if(spannableStringBuilder0.charAt(v6) == 0x20 && spannableStringBuilder0.charAt(v6 + 1) == 10) {
                    spannableStringBuilder0.delete(v6, v6 + 1);
                }
            }
            if(spannableStringBuilder0.length() > 0 && spannableStringBuilder0.charAt(spannableStringBuilder0.length() - 1) == 10) {
                spannableStringBuilder0.delete(spannableStringBuilder0.length() - 1, spannableStringBuilder0.length());
            }
            e30.e = e71.c;
            e30.f = e71.d;
            e30.g = e71.e;
            e30.h = e71.b;
            e30.l = e71.f;
            e30.k = e71.i;
            e30.j = e71.h;
            e30.p = e71.j;
            e30.s = e71.k;
            ((ArrayList)list0).add(e30.a());
        }
        return list0;
    }

    @Override  // a1.C
    public boolean b() {
        ArrayList arrayList0 = (ArrayList)this.f;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            if(((B)arrayList0.get(v1)).a.b()) {
                return true;
            }
        }
        return false;
    }

    @Override  // a1.C
    public float c() {
        return ((Number)((j)this.e).getValue()).floatValue();
    }

    @Override  // a1.C
    public float d() {
        return ((Number)((j)this.d).getValue()).floatValue();
    }

    public void e(n5.f f0, Class class0) {
        ((ArrayList)this.e).add(new ie.m(f0, class0));
    }

    public void f(q5.a a0, Class class0) {
        ((ArrayList)this.c).add(new ie.m(a0, class0));
    }

    public Bidi g(int v) {
        Bidi bidi0;
        Layout layout0 = (Layout)this.b;
        ArrayList arrayList0 = (ArrayList)this.c;
        ArrayList arrayList1 = (ArrayList)this.d;
        boolean[] arr_z = (boolean[])this.e;
        if(arr_z[v]) {
            return (Bidi)arrayList1.get(v);
        }
        int v1 = v == 0 ? 0 : ((Number)arrayList0.get(v - 1)).intValue();
        int v2 = ((Number)arrayList0.get(v)).intValue();
        int v3 = v2 - v1;
        char[] arr_c = (char[])this.f;
        if(arr_c == null || arr_c.length < v3) {
            arr_c = new char[v3];
        }
        char[] arr_c1 = arr_c;
        TextUtils.getChars(layout0.getText(), v1, v2, arr_c1, 0);
        if(Bidi.requiresBidi(arr_c1, 0, v3)) {
            bidi0 = new Bidi(arr_c1, 0, null, 0, v3, (layout0.getParagraphDirection(layout0.getLineForOffset(this.s(v))) == -1 ? 1 : 0));
            if(bidi0.getRunCount() == 1) {
                bidi0 = null;
            }
        }
        else {
            bidi0 = null;
        }
        arrayList1.set(v, bidi0);
        arr_z[v] = true;
        if(bidi0 != null) {
            char[] arr_c2 = (char[])this.f;
            arr_c1 = arr_c1 == arr_c2 ? null : arr_c2;
        }
        this.f = arr_c1;
        return bidi0;
    }

    @Override  // Y3.d
    public List getCues(long v) {
        e4.c c0 = (e4.c)this.b;
        Map map0 = (Map)this.d;
        HashMap hashMap0 = (HashMap)this.e;
        HashMap hashMap1 = (HashMap)this.f;
        ArrayList arrayList0 = new ArrayList();
        c0.g(v, c0.h, arrayList0);
        TreeMap treeMap0 = new TreeMap();
        c0.i(v, false, c0.h, treeMap0);
        c0.h(v, map0, hashMap0, c0.h, treeMap0);
        List list0 = new ArrayList();
        for(Object object0: arrayList0) {
            Pair pair0 = (Pair)object0;
            String s = (String)hashMap1.get(pair0.second);
            if(s != null) {
                byte[] arr_b = Base64.decode(s, 0);
                Bitmap bitmap0 = BitmapFactory.decodeByteArray(arr_b, 0, arr_b.length);
                e4.e e0 = (e4.e)hashMap0.get(pair0.first);
                e0.getClass();
                ((ArrayList)list0).add(new d3.b(null, null, null, bitmap0, e0.c, 0, e0.e, e0.b, 0, 0x80000000, -3.402823E+38f, e0.f, e0.g, false, 0xFF000000, e0.j, 0.0f));
            }
        }
        for(Object object1: treeMap0.entrySet()) {
            e4.e e1 = (e4.e)hashMap0.get(((Map.Entry)object1).getKey());
            e1.getClass();
            d3.a a0 = (d3.a)((Map.Entry)object1).getValue();
            CharSequence charSequence0 = a0.a;
            charSequence0.getClass();
            SpannableStringBuilder spannableStringBuilder0 = (SpannableStringBuilder)charSequence0;
            e4.a[] arr_a = (e4.a[])spannableStringBuilder0.getSpans(0, spannableStringBuilder0.length(), e4.a.class);
            for(int v1 = 0; v1 < arr_a.length; ++v1) {
                e4.a a1 = arr_a[v1];
                spannableStringBuilder0.replace(spannableStringBuilder0.getSpanStart(a1), spannableStringBuilder0.getSpanEnd(a1), "");
            }
            for(int v2 = 0; v2 < spannableStringBuilder0.length(); ++v2) {
                if(spannableStringBuilder0.charAt(v2) == 0x20) {
                    int v3;
                    for(v3 = v2 + 1; v3 < spannableStringBuilder0.length() && spannableStringBuilder0.charAt(v3) == 0x20; ++v3) {
                    }
                    int v4 = v3 - (v2 + 1);
                    if(v4 > 0) {
                        spannableStringBuilder0.delete(v2, v4 + v2);
                    }
                }
            }
            if(spannableStringBuilder0.length() > 0 && spannableStringBuilder0.charAt(0) == 0x20) {
                spannableStringBuilder0.delete(0, 1);
            }
            for(int v5 = 0; v5 < spannableStringBuilder0.length() - 1; ++v5) {
                if(spannableStringBuilder0.charAt(v5) == 10 && spannableStringBuilder0.charAt(v5 + 1) == 0x20) {
                    spannableStringBuilder0.delete(v5 + 1, v5 + 2);
                }
            }
            if(spannableStringBuilder0.length() > 0 && spannableStringBuilder0.charAt(spannableStringBuilder0.length() - 1) == 0x20) {
                spannableStringBuilder0.delete(spannableStringBuilder0.length() - 1, spannableStringBuilder0.length());
            }
            for(int v6 = 0; v6 < spannableStringBuilder0.length() - 1; ++v6) {
                if(spannableStringBuilder0.charAt(v6) == 0x20 && spannableStringBuilder0.charAt(v6 + 1) == 10) {
                    spannableStringBuilder0.delete(v6, v6 + 1);
                }
            }
            if(spannableStringBuilder0.length() > 0 && spannableStringBuilder0.charAt(spannableStringBuilder0.length() - 1) == 10) {
                spannableStringBuilder0.delete(spannableStringBuilder0.length() - 1, spannableStringBuilder0.length());
            }
            a0.e = e1.c;
            a0.f = e1.d;
            a0.g = e1.e;
            a0.h = e1.b;
            a0.l = e1.f;
            a0.k = e1.i;
            a0.j = e1.h;
            a0.p = e1.j;
            ((ArrayList)list0).add(a0.a());
        }
        return list0;
    }

    @Override  // Y3.d
    public long getEventTime(int v) {
        return ((long[])this.c)[v];
    }

    @Override  // Y3.d
    public int getEventTimeCount() {
        return ((long[])this.c).length;
    }

    @Override  // Y3.d
    public int getNextEventTimeIndex(long v) {
        long[] arr_v = (long[])this.c;
        int v1 = x.a(arr_v, v, false);
        return v1 >= arr_v.length ? -1 : v1;
    }

    @Override  // ie.j
    public Object getValue() {
        m0 m00 = (m0)this.f;
        if(m00 == null) {
            q0 q00 = (q0)((a)(((r)this.c))).invoke();
            androidx.lifecycle.o0 o00 = (androidx.lifecycle.o0)((a)this.d).invoke();
            S2.c c0 = (S2.c)((a)(((r)this.e))).invoke();
            q.g(q00, "store");
            q.g(o00, "factory");
            q.g(c0, "extras");
            o9.b b0 = new o9.b(q00, o00, c0);
            De.d d0 = (De.d)this.b;
            q.g(d0, "modelClass");
            String s = d0.l();
            if(s == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            m0 m01 = b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
            this.f = m01;
            return m01;
        }
        return m00;
    }

    public static i h(SharedPreferences sharedPreferences0, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor0) {
        i i0 = new i(sharedPreferences0, scheduledThreadPoolExecutor0);
        synchronized(((ArrayDeque)i0.e)) {
            ((ArrayDeque)i0.e).clear();
            String s = ((SharedPreferences)i0.b).getString(((String)i0.c), "");
            if(!TextUtils.isEmpty(s) && s.contains(((String)i0.d))) {
                String[] arr_s = s.split(((String)i0.d), -1);
                if(arr_s.length == 0) {
                    Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                }
                for(int v1 = 0; v1 < arr_s.length; ++v1) {
                    String s1 = arr_s[v1];
                    if(!TextUtils.isEmpty(s1)) {
                        ((ArrayDeque)i0.e).add(s1);
                    }
                }
                return i0;
            }
            return i0;
        }
    }

    public void i(Canvas canvas0) {
        Paint paint0 = (Paint)this.d;
        ViewGroup viewGroup0 = (ViewGroup)this.b;
        ViewGroup viewGroup1 = (ViewGroup)this.c;
        m6.d d0 = (m6.d)this.e;
        if(d0 == null || d0.c == 3.402823E+38f) {
            ((m6.e)viewGroup0).c(canvas0);
            if(Color.alpha(paint0.getColor()) != 0) {
                canvas0.drawRect(0.0f, 0.0f, ((float)viewGroup1.getWidth()), ((float)viewGroup1.getHeight()), paint0);
            }
        }
        else {
            ((m6.e)viewGroup0).c(canvas0);
            if(Color.alpha(paint0.getColor()) != 0) {
                canvas0.drawRect(0.0f, 0.0f, ((float)viewGroup1.getWidth()), ((float)viewGroup1.getHeight()), paint0);
            }
        }
        Drawable drawable0 = (Drawable)this.f;
        if(drawable0 != null && ((m6.d)this.e) != null) {
            Rect rect0 = drawable0.getBounds();
            float f = ((m6.d)this.e).a - ((float)rect0.width()) / 2.0f;
            float f1 = ((m6.d)this.e).b - ((float)rect0.height()) / 2.0f;
            canvas0.translate(f, f1);
            ((Drawable)this.f).draw(canvas0);
            canvas0.translate(-f, -f1);
        }
    }

    public float j(int v, boolean z) {
        Layout layout0 = (Layout)this.b;
        int v1 = layout0.getLineEnd(layout0.getLineForOffset(v));
        if(v > v1) {
            v = v1;
        }
        return z ? layout0.getPrimaryHorizontal(v) : layout0.getSecondaryHorizontal(v);
    }

    @Override  // jf.l
    public void k() {
        ((H8.q)this.c).k();
        H8.q q0 = (H8.q)this.d;
        e e0 = (e)this.e;
        vf.a a0 = new vf.a(((Ne.b)p.E0(((ArrayList)this.f))));
        ((HashMap)q0.b).put(e0, a0);
    }

    @Override  // jf.l
    public jf.m l(e e0) {
        return ((H8.q)this.b).l(e0);
    }

    @Override  // jf.l
    public l m(qf.b b0, e e0) {
        return ((H8.q)this.b).m(b0, e0);
    }

    @Override  // jf.l
    public void n(e e0, qf.b b0, e e1) {
        ((H8.q)this.b).n(e0, b0, e1);
    }

    @Override  // jf.l
    public void o(e e0, Object object0) {
        ((H8.q)this.b).o(e0, object0);
    }

    @Override  // jf.l
    public void p(e e0, vf.f f0) {
        ((H8.q)this.b).p(e0, f0);
    }

    public float q(int v, boolean z, boolean z1) {
        boolean z4;
        int v15;
        int v13;
        int v1 = v;
        Layout layout0 = (Layout)this.b;
        if(!z1) {
            return this.j(v, z);
        }
        int v2 = b1.f.d(layout0, v1, true);
        int v3 = layout0.getLineStart(v2);
        int v4 = layout0.getLineEnd(v2);
        if(v1 != v3 && v1 != v4) {
            return this.j(v, z);
        }
        if(v1 != 0 && v1 != layout0.getText().length()) {
            int v5 = this.r(v1, true);
            boolean z2 = layout0.getParagraphDirection(layout0.getLineForOffset(this.s(v5))) == -1;
            int v6 = this.w(v4, v3);
            int v7 = this.s(v5);
            Bidi bidi0 = this.g(v5);
            Bidi bidi1 = bidi0 == null ? null : bidi0.createLineBidi(v3 - v7, v6 - v7);
            if(bidi1 != null && bidi1.getRunCount() != 1) {
                int v8 = bidi1.getRunCount();
                b1.d[] arr_d = new b1.d[v8];
                for(int v9 = 0; v9 < v8; ++v9) {
                    arr_d[v9] = new b1.d(bidi1.getRunStart(v9) + v3, bidi1.getRunLimit(v9) + v3, bidi1.getRunLevel(v9) % 2 == 1);
                }
                int v10 = bidi1.getRunCount();
                byte[] arr_b = new byte[v10];
                for(int v11 = 0; v11 < v10; ++v11) {
                    arr_b[v11] = (byte)bidi1.getRunLevel(v11);
                }
                Bidi.reorderVisually(arr_b, 0, arr_d, 0, v8);
                if(v1 == v3) {
                    for(int v12 = 0; true; ++v12) {
                        v13 = -1;
                        if(v12 >= v8) {
                            break;
                        }
                        if(arr_d[v12].a == v1) {
                            v13 = v12;
                            break;
                        }
                    }
                    boolean z3 = z || z2 == arr_d[v13].c ? !z2 : z2;
                    if(v13 == 0 && z3) {
                        return layout0.getLineLeft(v2);
                    }
                    if(v13 == v8 - 1 && !z3) {
                        return layout0.getLineRight(v2);
                    }
                    return z3 ? layout0.getPrimaryHorizontal(arr_d[v13 - 1].a) : layout0.getPrimaryHorizontal(arr_d[v13 + 1].a);
                }
                if(v1 > v6) {
                    v1 = this.w(v1, v3);
                }
                for(int v14 = 0; true; ++v14) {
                    v15 = -1;
                    if(v14 >= v8) {
                        break;
                    }
                    if(arr_d[v14].b == v1) {
                        v15 = v14;
                        break;
                    }
                }
                if(z || z2 == arr_d[v15].c) {
                    z4 = z2;
                }
                else if(!z2) {
                    z4 = true;
                }
                else {
                    z4 = false;
                }
                if(v15 == 0 && z4) {
                    return layout0.getLineLeft(v2);
                }
                if(v15 == v8 - 1 && !z4) {
                    return layout0.getLineRight(v2);
                }
                return z4 ? layout0.getPrimaryHorizontal(arr_d[v15 - 1].b) : layout0.getPrimaryHorizontal(arr_d[v15 + 1].b);
            }
            if(z || z2 == layout0.isRtlCharAt(v3)) {
                z2 = !z2;
            }
            if(v1 == v3) {
                return z2 ? layout0.getLineLeft(v2) : layout0.getLineRight(v2);
            }
            return z2 ? layout0.getLineRight(v2) : layout0.getLineLeft(v2);
        }
        return this.j(v, z);
    }

    public int r(int v, boolean z) {
        ArrayList arrayList0 = (ArrayList)this.c;
        int v1 = e.k.g(arrayList0, v);
        int v2 = v1 >= 0 ? v1 + 1 : -(v1 + 1);
        return !z || v2 <= 0 || v != ((Number)arrayList0.get(v2 - 1)).intValue() ? v2 : v2 - 1;
    }

    public int s(int v) {
        return v == 0 ? 0 : ((Number)((ArrayList)this.c).get(v - 1)).intValue();
    }

    public m6.d t() {
        m6.d d0 = (m6.d)this.e;
        if(d0 == null) {
            return null;
        }
        m6.d d1 = new m6.d(d0);
        if(d1.c == 3.402823E+38f) {
            float f = d1.a;
            float f1 = d1.b;
            ViewGroup viewGroup0 = (ViewGroup)this.c;
            d1.c = e2.a.A(f, f1, viewGroup0.getWidth(), viewGroup0.getHeight());
        }
        return d1;
    }

    @Override
    public String toString() {
        switch(this.a) {
            case 3: {
                StringBuilder stringBuilder0 = new StringBuilder("KmVersionRequirement(kind=");
                h0 h00 = (h0)this.b;
                if(h00 != null) {
                    stringBuilder0.append(h00);
                    stringBuilder0.append(", level=");
                    g0 g00 = (g0)this.c;
                    if(g00 != null) {
                        stringBuilder0.append(g00);
                        stringBuilder0.append(", version=");
                        f0 f00 = (f0)this.f;
                        if(f00 != null) {
                            stringBuilder0.append(f00);
                            stringBuilder0.append(", errorCode=");
                            stringBuilder0.append(((Integer)this.d));
                            stringBuilder0.append(", message=");
                            return androidx.appcompat.app.o.r(stringBuilder0, ((String)this.e), ')');
                        }
                        q.m("version");
                        throw null;
                    }
                    q.m("level");
                    throw null;
                }
                q.m("kind");
                throw null;
            }
            case 13: {
                String s = (String)this.f;
                StringBuilder stringBuilder1 = new StringBuilder("since ");
                stringBuilder1.append(((nf.g)this.b));
                stringBuilder1.append(' ');
                stringBuilder1.append(((ie.e)this.d));
                Integer integer0 = (Integer)this.e;
                String s1 = "";
                stringBuilder1.append((integer0 == null ? "" : " error " + integer0));
                if(s != null) {
                    s1 = ": " + s;
                }
                stringBuilder1.append(s1);
                return stringBuilder1.toString();
            }
            default: {
                return super.toString();
            }
        }
    }

    public List u(List list0) {
        StringBuilder stringBuilder0 = Y.p("SELECT * FROM local_contents WHERE data in (");
        a.a.k(list0.size(), stringBuilder0);
        stringBuilder0.append(")");
        return (List)E9.w.N(((LocalContentDatabase_Impl)this.b), true, false, new H8.c(stringBuilder0.toString(), 5, list0));
    }

    public boolean v() {
        if(((m6.e)(((ViewGroup)this.b))).d()) {
            m6.d d0 = (m6.d)this.e;
            return d0 == null || d0.c == 3.402823E+38f;
        }
        return false;
    }

    public int w(int v, int v1) {
        while(v > v1) {
            int v2 = ((Layout)this.b).getText().charAt(v - 1);
            if(v2 != 10 && v2 != 0x20 && v2 != 5760 && (q.h(v2, 0x2000) < 0 || q.h(v2, 0x200A) > 0 || v2 == 0x2007) && v2 != 0x205F && v2 != 0x3000) {
                return v;
            }
            --v;
        }
        return v;
    }

    public void x(N5.a a0, N5.h h0) {
        u u0 = (u)this.f;
        Q5.j j0 = (Q5.j)this.b;
        if(a0 == null) {
            throw new NullPointerException("Null event");
        }
        String s = (String)this.c;
        N5.e e0 = (N5.e)this.e;
        if(e0 == null) {
            throw new NullPointerException("Null transformer");
        }
        c c0 = (c)this.d;
        V5.c c1 = u0.c;
        Q5.j j1 = j0.b(a0.c);
        Q5.h h1 = new Q5.h();  // 初始化器: Ljava/lang/Object;-><init>()V
        h1.h = new HashMap();
        h1.f = u0.a.f();
        h1.g = u0.b.f();
        h1.a = s;
        h1.e = new n(c0, ((byte[])e0.apply(a0.b)));
        h1.c = a0.a;
        N5.b b0 = a0.d;
        if(b0 != null) {
            h1.d = b0.a;
        }
        D5.a a1 = new D5.a(((V5.a)c1), j1, h0, h1.b(), 3);
        ((V5.a)c1).b.execute(a1);
    }

    public void y(Object object0, String s) {
        q.g(s, "key");
        ((LinkedHashMap)this.b).put(s, object0);
        MutableStateFlow mutableStateFlow0 = (MutableStateFlow)((LinkedHashMap)this.d).get(s);
        if(mutableStateFlow0 != null) {
            mutableStateFlow0.setValue(object0);
        }
        MutableStateFlow mutableStateFlow1 = (MutableStateFlow)((LinkedHashMap)this.e).get(s);
        if(mutableStateFlow1 != null) {
            mutableStateFlow1.setValue(object0);
        }
    }

    public void z(Drawable drawable0) {
        this.f = drawable0;
        ((ViewGroup)this.c).invalidate();
    }
}

