package Q0;

import N0.g0;
import P0.I;
import P0.j0;
import U4.x;
import X0.h;
import X0.i;
import X0.k;
import X0.l;
import X0.p;
import a1.M;
import a1.Q;
import a1.V;
import a1.e;
import a1.g;
import a1.v;
import android.content.ClipDescription;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TtsSpan.VerbatimBuilder;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo.RangeInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.collection.F;
import androidx.collection.K;
import androidx.collection.O;
import androidx.collection.W;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import c2.b;
import d2.c;
import d2.d;
import d2.f;
import d5.m;
import i.n.i.b.a.s.e.M3;
import ie.H;
import j2.a;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import je.w;
import l1.n;
import l1.q;

public final class y extends f {
    public final int b;
    public final b c;

    public y(b b0, int v) {
        this.b = v;
        this.c = b0;
        super();
    }

    @Override  // d2.f
    public void a(int v, d d0, String s, Bundle bundle0) {
        if(this.b != 0) {
            return;
        }
        ((C)this.c).a(v, d0, s, bundle0);
    }

    @Override  // d2.f
    public final d b(int v) {
        d d2;
        u u2;
        F f7;
        int v42;
        boolean z10;
        boolean z9;
        boolean z7;
        boolean z6;
        I i3;
        l l6;
        boolean z5;
        boolean z4;
        boolean z3;
        C c2;
        i i2;
        AccessibilityNodeInfo accessibilityNodeInfo5;
        AccessibilityNodeInfo accessibilityNodeInfo4;
        CharSequence charSequence0;
        ArrayList arrayList1;
        i i1;
        l l4;
        Resources resources1;
        AccessibilityNodeInfo accessibilityNodeInfo3;
        p p4;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        C c1;
        l l2;
        androidx.collection.y y1;
        u u1;
        AccessibilityNodeInfo accessibilityNodeInfo1;
        s s0;
        b b0 = this.c;
        if(this.b != 0) {
            return new d(AccessibilityNodeInfo.obtain(((a)b0).i(v).a));
        }
        u u0 = ((C)b0).a;
        j j0 = u0.getViewTreeOwners();
        if(j0 == null) {
            s0 = null;
        }
        else {
            t t0 = j0.a.getLifecycle();
            s0 = t0 == null ? null : t0.b();
        }
        if(s0 == s.a) {
        label_698:
            c2 = (C)b0;
            d2 = null;
        }
        else {
            AccessibilityNodeInfo accessibilityNodeInfo0 = AccessibilityNodeInfo.obtain();
            d d0 = new d(accessibilityNodeInfo0);
            Q0 q00 = (Q0)((C)b0).j().b(v);
            if(q00 == null) {
                goto label_698;
            }
            else {
                p p0 = q00.a;
                if(v == -1) {
                    ViewParent viewParent0 = u0.getParentForAccessibility();
                    d0.b = -1;
                    accessibilityNodeInfo0.setParent((viewParent0 instanceof View ? ((View)viewParent0) : null));
                    goto label_32;
                }
                else {
                    p p1 = p0.j();
                    Integer integer0 = p1 == null ? null : p1.g;
                    if(integer0 != null) {
                        int v1 = integer0.intValue();
                        if(v1 == u0.getSemanticsOwner().a().g) {
                            v1 = -1;
                        }
                        d0.b = v1;
                        accessibilityNodeInfo0.setParent(u0, v1);
                    label_32:
                        d0.c = v;
                        accessibilityNodeInfo0.setSource(u0, v);
                        d0.k(((C)b0).b(q00));
                        androidx.collection.y y0 = C.M;
                        W w0 = ((C)b0).s;
                        Resources resources0 = u0.getContext().getResources();
                        d0.l("android.view.View");
                        l l0 = p0.d;
                        l l1 = p0.d;
                        K k0 = l0.a;
                        if(k0.c(X0.s.C)) {
                            d0.l("android.widget.EditText");
                        }
                        if(k0.c(X0.s.y)) {
                            d0.l("android.widget.TextView");
                        }
                        Object object0 = k0.g(X0.s.v);
                        if(object0 == null) {
                            object0 = null;
                        }
                        if(((i)object0) != null) {
                            int v2 = ((i)object0).a;
                            if(p0.e || p.h(4, p0).isEmpty()) {
                                switch(v2) {
                                    case 2: {
                                        accessibilityNodeInfo0.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", "Switch");
                                        break;
                                    }
                                    case 4: {
                                        accessibilityNodeInfo0.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", "Tab");
                                        break;
                                    }
                                    default: {
                                        String s1 = N.x(v2);
                                        if(v2 != 5 || p0.m() || l0.c) {
                                            d0.l(s1);
                                        }
                                    }
                                }
                            }
                        }
                        accessibilityNodeInfo0.setPackageName("com.iloen.melon");
                        accessibilityNodeInfo0.setImportantForAccessibility(N.p(p0));
                        List list0 = p.h(4, p0);
                        int v3 = list0.size();
                        for(int v4 = 0; true; ++v4) {
                            accessibilityNodeInfo1 = d0.a;
                            if(v4 >= v3) {
                                break;
                            }
                            p p2 = (p)list0.get(v4);
                            if(((C)b0).j().a(p2.g)) {
                                u1.i i0 = (u1.i)u0.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(p2.c);
                                int v5 = p2.g;
                                if(v5 != -1) {
                                    if(i0 == null) {
                                        accessibilityNodeInfo1.addChild(u0, v5);
                                    }
                                    else {
                                        accessibilityNodeInfo1.addChild(i0);
                                    }
                                }
                            }
                        }
                        if(v == ((C)b0).k) {
                            d0.h(true);
                            d0.b(c.i);
                        }
                        else {
                            d0.h(false);
                            d0.b(c.h);
                        }
                        g g0 = Q0.F.e(p0);
                        if(g0 == null) {
                            u1 = u0;
                            c1 = (C)b0;
                            accessibilityNodeInfo2 = accessibilityNodeInfo0;
                            y1 = y0;
                            p4 = p0;
                            accessibilityNodeInfo3 = accessibilityNodeInfo1;
                            resources1 = resources0;
                            l4 = l0;
                            l2 = l1;
                            i1 = (i)object0;
                            charSequence0 = null;
                        }
                        else {
                            u0.getFontFamilyResolver();
                            r1.c c0 = u0.getDensity();
                            m m0 = ((C)b0).F;
                            u1 = u0;
                            y1 = y0;
                            List list1 = g0.a;
                            SpannableString spannableString0 = new SpannableString(g0.b);
                            String s2 = g0.b;
                            ArrayList arrayList0 = g0.c;
                            l2 = l1;
                            if(arrayList0 != null) {
                                int v6 = arrayList0.size();
                                for(int v7 = 0; v7 < v6; ++v7) {
                                    Object object1 = arrayList0.get(v7);
                                    int v8 = ((e)object1).b;
                                    int v9 = ((e)object1).c;
                                    long v10 = ((M)((e)object1).a).a.b();
                                    long v11 = ((M)((e)object1).a).b;
                                    e1.s s3 = ((M)((e)object1).a).d;
                                    e1.y y2 = ((M)((e)object1).a).c;
                                    q q0 = ((M)((e)object1).a).j;
                                    h1.b b1 = ((M)((e)object1).a).k;
                                    long v12 = ((M)((e)object1).a).l;
                                    l1.l l3 = ((M)((e)object1).a).m;
                                    l1.p p3 = ((M)((e)object1).a).a;
                                    if(!y0.s.d(v10, p3.b())) {
                                        p3 = v10 == 16L ? n.a : new l1.c(v10);
                                    }
                                    df.d.J(spannableString0, p3.b(), v8, v9);
                                    df.d.K(spannableString0, v11, c0, v8, v9);
                                    if(y2 != null || s3 != null) {
                                        spannableString0.setSpan(new StyleSpan(e1.b.x((s3 == null ? 0 : s3.a), (y2 == null ? e1.y.f : y2))), v8, v9, 33);
                                    }
                                    if(l3 != null) {
                                        int v13 = l3.a;
                                        if((v13 | 1) == v13) {
                                            spannableString0.setSpan(new UnderlineSpan(), v8, v9, 33);
                                        }
                                        if((v13 | 2) == v13) {
                                            spannableString0.setSpan(new StrikethroughSpan(), v8, v9, 33);
                                        }
                                    }
                                    if(q0 != null) {
                                        spannableString0.setSpan(new ScaleXSpan(q0.a), v8, v9, 33);
                                    }
                                    df.d.L(spannableString0, b1, v8, v9);
                                    if(v12 != 16L) {
                                        spannableString0.setSpan(new BackgroundColorSpan(y0.M.z(v12)), v8, v9, 33);
                                    }
                                }
                            }
                            c1 = (C)b0;
                            accessibilityNodeInfo2 = accessibilityNodeInfo0;
                            p4 = p0;
                            accessibilityNodeInfo3 = accessibilityNodeInfo1;
                            resources1 = resources0;
                            l4 = l0;
                            i1 = (i)object0;
                            int v14 = s2.length();
                            w w1 = w.a;
                            if(list1 == null) {
                                arrayList1 = w1;
                            }
                            else {
                                arrayList1 = new ArrayList(list1.size());
                                int v15 = list1.size();
                                for(int v16 = 0; v16 < v15; ++v16) {
                                    Object object2 = list1.get(v16);
                                    e e0 = (e)object2;
                                    if(e0.a instanceof a1.W && a1.i.b(0, v14, e0.b, e0.c)) {
                                        arrayList1.add(object2);
                                    }
                                }
                            }
                            int v17 = arrayList1.size();
                            for(int v18 = 0; v18 < v17; ++v18) {
                                e e1 = (e)arrayList1.get(v18);
                                a1.W w2 = (a1.W)e1.a;
                                int v19 = e1.b;
                                int v20 = e1.c;
                                if(!(w2 instanceof a1.W)) {
                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                }
                                spannableString0.setSpan(new TtsSpan.VerbatimBuilder(w2.a).build(), v19, v20, 33);
                            }
                            int v21 = s2.length();
                            if(list1 != null) {
                                w1 = new ArrayList(list1.size());
                                int v22 = list1.size();
                                for(int v23 = 0; v23 < v22; ++v23) {
                                    Object object3 = list1.get(v23);
                                    e e2 = (e)object3;
                                    if(e2.a instanceof V && a1.i.b(0, v21, e2.b, e2.c)) {
                                        ((ArrayList)w1).add(object3);
                                    }
                                }
                            }
                            int v24 = w1.size();
                            for(int v25 = 0; v25 < v24; ++v25) {
                                e e3 = (e)w1.get(v25);
                                V v26 = (V)e3.a;
                                int v27 = e3.b;
                                int v28 = e3.c;
                                WeakHashMap weakHashMap0 = (WeakHashMap)m0.b;
                                URLSpan uRLSpan0 = weakHashMap0.get(v26);
                                if(uRLSpan0 == null) {
                                    uRLSpan0 = new URLSpan(v26.a);
                                    weakHashMap0.put(v26, uRLSpan0);
                                }
                                spannableString0.setSpan(uRLSpan0, v27, v28, 33);
                            }
                            List list2 = g0.a(s2.length());
                            int v29 = list2.size();
                            for(int v30 = 0; v30 < v29; ++v30) {
                                e e4 = (e)list2.get(v30);
                                int v31 = e4.b;
                                Object object4 = e4.a;
                                int v32 = e4.c;
                                if(v31 != v32) {
                                    if(((a1.w)object4) instanceof v) {
                                        ((a1.w)object4).getClass();
                                        kotlin.jvm.internal.q.e(object4, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
                                        e e5 = new e(((v)object4), v31, v32);
                                        WeakHashMap weakHashMap1 = (WeakHashMap)m0.c;
                                        URLSpan uRLSpan1 = weakHashMap1.get(e5);
                                        if(uRLSpan1 == null) {
                                            uRLSpan1 = new URLSpan(((v)object4).a);
                                            weakHashMap1.put(e5, uRLSpan1);
                                        }
                                        spannableString0.setSpan(uRLSpan1, v31, v32, 33);
                                    }
                                    else {
                                        WeakHashMap weakHashMap2 = (WeakHashMap)m0.d;
                                        i1.e e6 = weakHashMap2.get(e4);
                                        if(e6 == null) {
                                            e6 = new i1.e(((a1.w)object4));
                                            weakHashMap2.put(e4, e6);
                                        }
                                        spannableString0.setSpan(e6, v31, v32, 33);
                                    }
                                }
                            }
                            charSequence0 = (SpannableString)C.B(spannableString0);
                        }
                        d0.q(charSequence0);
                        X0.w w3 = X0.s.I;
                        if(k0.c(w3)) {
                            accessibilityNodeInfo4 = accessibilityNodeInfo2;
                            accessibilityNodeInfo4.setContentInvalid(true);
                            Object object5 = k0.g(w3);
                            if(object5 == null) {
                                object5 = null;
                            }
                            accessibilityNodeInfo5 = accessibilityNodeInfo3;
                            accessibilityNodeInfo5.setError(((CharSequence)object5));
                        }
                        else {
                            accessibilityNodeInfo4 = accessibilityNodeInfo2;
                            accessibilityNodeInfo5 = accessibilityNodeInfo3;
                        }
                        String s4 = Q0.F.d(p4, resources1);
                        if(Build.VERSION.SDK_INT >= 30) {
                            P1.b.m(accessibilityNodeInfo5, s4);
                        }
                        else {
                            accessibilityNodeInfo5.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", s4);
                        }
                        accessibilityNodeInfo5.setCheckable(Q0.F.c(p4));
                        Object object6 = k0.g(X0.s.G);
                        if(object6 == null) {
                            object6 = null;
                        }
                        if(((Z0.a)object6) != null) {
                            if(((Z0.a)object6) == Z0.a.a) {
                                accessibilityNodeInfo5.setChecked(true);
                            }
                            else if(((Z0.a)object6) == Z0.a.b) {
                                accessibilityNodeInfo5.setChecked(false);
                            }
                        }
                        Object object7 = k0.g(X0.s.F);
                        if(object7 == null) {
                            object7 = null;
                        }
                        if(((Boolean)object7) == null) {
                            i2 = i1;
                        }
                        else {
                            boolean z = ((Boolean)object7).booleanValue();
                            if(i1 == null) {
                                i2 = null;
                                accessibilityNodeInfo5.setChecked(z);
                            }
                            else {
                                i2 = i1;
                                if(i2.a == 4) {
                                    accessibilityNodeInfo5.setSelected(z);
                                }
                                else {
                                    accessibilityNodeInfo5.setChecked(z);
                                }
                            }
                        }
                        if(!l4.c || p.h(4, p4).isEmpty()) {
                            Object object8 = k0.g(X0.s.a);
                            if(object8 == null) {
                                object8 = null;
                            }
                            d0.o((((List)object8) == null ? null : ((String)je.p.m0(((List)object8)))));
                        }
                        Object object9 = k0.g(X0.s.w);
                        if(object9 == null) {
                            object9 = null;
                        }
                        if(((String)object9) != null) {
                            for(p p5 = p4; true; p5 = p5.j()) {
                                boolean z1 = false;
                                if(p5 == null) {
                                    break;
                                }
                                l l5 = p5.d;
                                X0.w w4 = X0.t.a;
                                if(l5.a.c(w4)) {
                                    z1 = ((Boolean)l5.d(w4)).booleanValue();
                                    break;
                                }
                            }
                            if(z1) {
                                accessibilityNodeInfo4.setViewIdResourceName(((String)object9));
                            }
                        }
                        Object object10 = k0.g(X0.s.h);
                        if(object10 == null) {
                            object10 = null;
                        }
                        if(((H)object10) != null) {
                            if(Build.VERSION.SDK_INT >= 28) {
                                accessibilityNodeInfo5.setHeading(true);
                            }
                            else {
                                d0.i(2, true);
                            }
                        }
                        accessibilityNodeInfo4.setPassword(k0.c(X0.s.H));
                        accessibilityNodeInfo4.setEditable(k0.c(X0.s.K));
                        Object object11 = k0.g(X0.s.L);
                        if(object11 == null) {
                            object11 = null;
                        }
                        accessibilityNodeInfo5.setMaxTextLength((((Integer)object11) == null ? -1 : ((int)(((Integer)object11)))));
                        accessibilityNodeInfo5.setEnabled(Q0.F.a(p4));
                        X0.w w5 = X0.s.k;
                        accessibilityNodeInfo5.setFocusable(k0.c(w5));
                        if(accessibilityNodeInfo4.isFocusable()) {
                            accessibilityNodeInfo5.setFocused(((Boolean)l4.d(w5)).booleanValue());
                            if(accessibilityNodeInfo4.isFocused()) {
                                d0.a(2);
                                c2 = c1;
                                c2.l = v;
                            }
                            else {
                                c2 = c1;
                                d0.a(1);
                            }
                        }
                        else {
                            c2 = c1;
                        }
                        accessibilityNodeInfo5.setVisibleToUser(!N.o(p4));
                        Object object12 = k0.g(X0.s.j);
                        if(object12 == null) {
                            object12 = null;
                        }
                        if(((X0.g)object12) != null) {
                            accessibilityNodeInfo4.setLiveRegion(1);
                        }
                        accessibilityNodeInfo5.setClickable(false);
                        Object object13 = k0.g(k.b);
                        if(object13 == null) {
                            object13 = null;
                        }
                        if(((X0.a)object13) != null) {
                            Object object14 = k0.g(X0.s.F);
                            if(object14 == null) {
                                object14 = null;
                            }
                            boolean z2 = kotlin.jvm.internal.q.b(object14, Boolean.TRUE);
                            if(i2 == null) {
                                z3 = false;
                            }
                            else if(i2.a == 4) {
                                z3 = true;
                            }
                            else {
                                z3 = false;
                            }
                            if(z3) {
                                z5 = true;
                            }
                            else {
                                if(i2 == null) {
                                    z4 = false;
                                }
                                else if(i2.a == 3) {
                                    z4 = true;
                                }
                                else {
                                    z4 = false;
                                }
                                z5 = z4;
                            }
                            accessibilityNodeInfo5.setClickable(!z5 || !z2);
                            if(Q0.F.a(p4) && accessibilityNodeInfo4.isClickable()) {
                                d0.b(new c(16, ((X0.a)object13).a));
                            }
                        }
                        accessibilityNodeInfo5.setLongClickable(false);
                        Object object15 = k0.g(k.c);
                        if(object15 == null) {
                            object15 = null;
                        }
                        if(((X0.a)object15) != null) {
                            accessibilityNodeInfo5.setLongClickable(true);
                            if(Q0.F.a(p4)) {
                                d0.b(new c(0x20, ((X0.a)object15).a));
                            }
                        }
                        Object object16 = k0.g(k.p);
                        if(object16 == null) {
                            object16 = null;
                        }
                        if(((X0.a)object16) != null) {
                            d0.b(new c(0x4000, ((X0.a)object16).a));
                        }
                        if(Q0.F.a(p4)) {
                            Object object17 = k0.g(k.j);
                            if(object17 == null) {
                                object17 = null;
                            }
                            if(((X0.a)object17) != null) {
                                d0.b(new c(0x200000, ((X0.a)object17).a));
                            }
                            Object object18 = k0.g(k.o);
                            if(object18 == null) {
                                object18 = null;
                            }
                            if(((X0.a)object18) != null) {
                                d0.b(new c(0x1020054, ((X0.a)object18).a));
                            }
                            Object object19 = k0.g(k.q);
                            if(object19 == null) {
                                object19 = null;
                            }
                            if(((X0.a)object19) != null) {
                                d0.b(new c(0x10000, ((X0.a)object19).a));
                            }
                            Object object20 = k0.g(k.r);
                            if(object20 == null) {
                                object20 = null;
                            }
                            if(((X0.a)object20) != null && accessibilityNodeInfo4.isFocused()) {
                                ClipDescription clipDescription0 = u1.getClipboardManager().a.getPrimaryClipDescription();
                                if((clipDescription0 == null ? false : clipDescription0.hasMimeType("text/*"))) {
                                    d0.b(new c(0x8000, ((X0.a)object20).a));
                                }
                            }
                        }
                        String s5 = C.k(p4);
                        if(s5 == null || s5.length() == 0) {
                            l6 = l2;
                        }
                        else {
                            accessibilityNodeInfo4.setTextSelection(c2.i(p4), c2.h(p4));
                            Object object21 = k0.g(k.i);
                            if(object21 == null) {
                                object21 = null;
                            }
                            d0.b(new c(0x20000, (((X0.a)object21) == null ? null : ((X0.a)object21).a)));
                            d0.a(0x100);
                            d0.a(0x200);
                            accessibilityNodeInfo5.setMovementGranularities(11);
                            Object object22 = k0.g(X0.s.a);
                            if(object22 == null) {
                                object22 = null;
                            }
                            if(((List)object22) != null && !((List)object22).isEmpty() || !k0.c(k.a)) {
                                l6 = l2;
                            }
                            else {
                                l6 = l2;
                                if(l6.a.c(X0.s.C)) {
                                    Object object23 = l6.a.g(w5);
                                    if(object23 == null) {
                                        object23 = null;
                                    }
                                    if(kotlin.jvm.internal.q.b(object23, Boolean.TRUE)) {
                                        i3 = p4.c.u();
                                        goto label_430;
                                    }
                                    else {
                                        z6 = true;
                                    }
                                }
                                else {
                                    for(i3 = p4.c.u(); true; i3 = i3.u()) {
                                    label_430:
                                        if(i3 == null) {
                                            i3 = null;
                                            break;
                                        }
                                        l l7 = i3.w();
                                        if(l7 != null && l7.c && l7.a.c(X0.s.C)) {
                                            break;
                                        }
                                    }
                                    if(i3 == null) {
                                        z6 = false;
                                    }
                                    else {
                                        l l8 = i3.w();
                                        if(l8 == null) {
                                            z7 = false;
                                        }
                                        else {
                                            Object object24 = l8.a.g(X0.s.k);
                                            if(object24 == null) {
                                                object24 = null;
                                            }
                                            z7 = kotlin.jvm.internal.q.b(object24, Boolean.TRUE);
                                        }
                                        z6 = z7 ? false : true;
                                    }
                                }
                                if(!z6) {
                                    accessibilityNodeInfo5.setMovementGranularities(accessibilityNodeInfo5.getMovementGranularities() | 20);
                                }
                            }
                        }
                        int v33 = Build.VERSION.SDK_INT;
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add("androidx.compose.ui.semantics.id");
                        CharSequence charSequence1 = d0.g();
                        if(charSequence1 != null && charSequence1.length() != 0 && k0.c(k.a)) {
                            arrayList2.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
                        }
                        if(l6.a.c(X0.s.w)) {
                            arrayList2.add("androidx.compose.ui.semantics.testTag");
                        }
                        accessibilityNodeInfo5.setAvailableExtraData(arrayList2);
                        Object object25 = l6.a.g(X0.s.c);
                        if(object25 == null) {
                            object25 = null;
                        }
                        if(((h)object25) != null) {
                            float f = ((h)object25).a;
                            Ce.d d1 = ((h)object25).b;
                            X0.w w6 = k.h;
                            if(l6.a.c(w6)) {
                                d0.l("android.widget.SeekBar");
                            }
                            else {
                                d0.l("android.widget.ProgressBar");
                            }
                            if(((h)object25) != h.d) {
                                accessibilityNodeInfo5.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(1, d1.a, d1.b, f));
                            }
                            if(l6.a.c(w6) && Q0.F.a(p4)) {
                                float f1 = d1.b;
                                float f2 = d1.a;
                                if(f1 < f2) {
                                    f1 = f2;
                                }
                                if(f < f1) {
                                    d0.b(c.j);
                                }
                                float f3 = d1.a;
                                float f4 = d1.b;
                                if(f3 > f4) {
                                    f3 = f4;
                                }
                                if(f > f3) {
                                    d0.b(c.k);
                                }
                            }
                        }
                        if(Q0.F.a(p4)) {
                            Object object26 = p4.d.a.g(k.h);
                            if(object26 == null) {
                                object26 = null;
                            }
                            if(((X0.a)object26) != null) {
                                d0.b(new c(0x102003D, ((X0.a)object26).a));
                            }
                        }
                        Object object27 = p4.i().a.g(X0.s.f);
                        if(object27 == null) {
                            object27 = null;
                        }
                        if(((X0.b)object27) == null) {
                            ArrayList arrayList3 = new ArrayList();
                            Object object28 = p4.i().a.g(X0.s.e);
                            if(object28 == null) {
                                object28 = null;
                            }
                            if(object28 != null) {
                                List list3 = p.h(4, p4);
                                int v34 = list3.size();
                                for(int v35 = 0; v35 < v34; ++v35) {
                                    p p6 = (p)list3.get(v35);
                                    if(p6.i().a.c(X0.s.F)) {
                                        arrayList3.add(p6);
                                    }
                                }
                            }
                            if(!arrayList3.isEmpty()) {
                                boolean z8 = H0.e.x(arrayList3);
                                d0.m(B6.f.d((z8 ? 1 : arrayList3.size()), (z8 ? arrayList3.size() : 1), 0, false));
                            }
                        }
                        else {
                            d0.m(B6.f.d(((X0.b)object27).a, ((X0.b)object27).b, 0, false));
                        }
                        H0.e.V(p4, d0);
                        Object object29 = l6.a.g(X0.s.s);
                        if(object29 == null) {
                            object29 = null;
                        }
                        X0.a a0 = (X0.a)a.a.z(l6, k.d);
                        if(((X0.j)object29) != null && a0 != null) {
                            Object object30 = p4.i().a.g(X0.s.f);
                            if(object30 == null) {
                                object30 = null;
                            }
                            if(object30 == null) {
                                Object object31 = p4.i().a.g(X0.s.e);
                                if(object31 == null) {
                                    object31 = null;
                                }
                                z9 = object31 == null ? false : true;
                            }
                            else {
                                z9 = true;
                            }
                            if(!z9) {
                                d0.l("android.widget.HorizontalScrollView");
                            }
                            if(((Number)((X0.j)object29).a().invoke()).floatValue() > 0.0f) {
                                d0.p(true);
                            }
                            if(Q0.F.a(p4)) {
                                if(C.p(((X0.j)object29))) {
                                    d0.b(c.j);
                                    d0.b((Q0.F.f(p4) ? c.q : c.s));
                                }
                                if(C.o(((X0.j)object29))) {
                                    d0.b(c.k);
                                    d0.b((Q0.F.f(p4) ? c.s : c.q));
                                }
                            }
                        }
                        X0.j j1 = (X0.j)a.a.z(p4.k(), X0.s.t);
                        if(j1 != null && a0 != null) {
                            Object object32 = p4.i().a.g(X0.s.f);
                            if(object32 == null) {
                                object32 = null;
                            }
                            if(object32 == null) {
                                Object object33 = p4.i().a.g(X0.s.e);
                                if(object33 == null) {
                                    object33 = null;
                                }
                                z10 = object33 == null ? false : true;
                            }
                            else {
                                z10 = true;
                            }
                            if(!z10) {
                                d0.l("android.widget.ScrollView");
                            }
                            if(((Number)j1.a().invoke()).floatValue() > 0.0f) {
                                d0.p(true);
                            }
                            if(Q0.F.a(p4)) {
                                if(C.p(j1)) {
                                    d0.b(c.j);
                                    d0.b(c.r);
                                }
                                if(C.o(j1)) {
                                    d0.b(c.k);
                                    d0.b(c.p);
                                }
                            }
                        }
                        if(v33 >= 29) {
                            N.f(p4, d0);
                        }
                        CharSequence charSequence2 = (CharSequence)a.a.z(p4.k(), X0.s.d);
                        if(v33 >= 28) {
                            accessibilityNodeInfo5.setPaneTitle(charSequence2);
                        }
                        else {
                            accessibilityNodeInfo5.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence2);
                        }
                        if(Q0.F.a(p4)) {
                            X0.a a1 = (X0.a)a.a.z(p4.k(), k.s);
                            if(a1 != null) {
                                d0.b(new c(0x40000, a1.a));
                            }
                            X0.a a2 = (X0.a)a.a.z(p4.k(), k.t);
                            if(a2 != null) {
                                d0.b(new c(0x80000, a2.a));
                            }
                            X0.a a3 = (X0.a)a.a.z(p4.k(), k.u);
                            if(a3 != null) {
                                d0.b(new c(0x100000, a3.a));
                            }
                            X0.w w7 = k.w;
                            if(p4.k().a.c(w7)) {
                                List list4 = (List)p4.k().d(w7);
                                if(list4.size() < y1.b) {
                                    W w8 = new W(0);
                                    F f5 = O.a();
                                    if(E.a.a(w0.c, v, w0.a) >= 0) {
                                        F f6 = (F)w0.c(v);
                                        androidx.collection.y y3 = new androidx.collection.y();
                                        int[] arr_v = y1.a;
                                        int v37 = y1.b;
                                        for(int v36 = 0; v36 < v37; ++v36) {
                                            y3.a(arr_v[v36]);
                                        }
                                        ArrayList arrayList4 = new ArrayList();
                                        int v38 = list4.size();
                                        int v39 = 0;
                                        while(v39 < v38) {
                                            X0.e e7 = (X0.e)list4.get(v39);
                                            kotlin.jvm.internal.q.d(f6);
                                            if(f6.d(e7.a()) >= 0) {
                                                String s6 = e7.a();
                                                int v40 = f6.d(s6);
                                                if(v40 >= 0) {
                                                    int v41 = f6.c[v40];
                                                    v42 = v39;
                                                    w8.d(v41, e7.a());
                                                    f5.g(v41, e7.a());
                                                    int[] arr_v1 = y3.a;
                                                    int v43 = y3.b;
                                                    f7 = f6;
                                                    int v44 = 0;
                                                    while(true) {
                                                        if(v44 < v43) {
                                                            if(v41 == arr_v1[v44]) {
                                                                break;
                                                            }
                                                            else {
                                                                ++v44;
                                                                continue;
                                                            }
                                                        }
                                                        v44 = -1;
                                                        break;
                                                    }
                                                    if(v44 >= 0) {
                                                        y3.e(v44);
                                                    }
                                                    d0.b(new c(v41, e7.a()));
                                                    goto label_642;
                                                }
                                                E.a.e(("There is no key " + s6 + " in the map"));
                                                throw null;
                                            }
                                            else {
                                                v42 = v39;
                                                f7 = f6;
                                                arrayList4.add(e7);
                                            }
                                        label_642:
                                            v39 = v42 + 1;
                                            f6 = f7;
                                        }
                                        int v45 = arrayList4.size();
                                        for(int v46 = 0; v46 < v45; ++v46) {
                                            X0.e e8 = (X0.e)arrayList4.get(v46);
                                            int v47 = y3.c(v46);
                                            w8.d(v47, e8.a());
                                            f5.g(v47, e8.a());
                                            d0.b(new c(v47, e8.a()));
                                        }
                                    }
                                    else {
                                        int v48 = list4.size();
                                        for(int v49 = 0; v49 < v48; ++v49) {
                                            X0.e e9 = (X0.e)list4.get(v49);
                                            int v50 = y1.c(v49);
                                            w8.d(v50, e9.a());
                                            f5.g(v50, e9.a());
                                            d0.b(new c(v50, e9.a()));
                                        }
                                    }
                                    c2.r.d(v, w8);
                                    w0.d(v, f5);
                                    goto label_671;
                                }
                                StringBuilder stringBuilder0 = new StringBuilder("Can\'t have more than ");
                                throw new IllegalStateException(x.g(y1.b, " custom actions for one widget", stringBuilder0));
                            }
                        }
                    label_671:
                        boolean z11 = Q0.F.g(p4, resources1);
                        if(Build.VERSION.SDK_INT >= 28) {
                            accessibilityNodeInfo5.setScreenReaderFocusable(z11);
                        }
                        else {
                            d0.i(1, z11);
                        }
                        int v51 = c2.B.d(v);
                        if(v51 == -1) {
                            u2 = u1;
                        }
                        else {
                            u1.i i4 = N.v(u1.getAndroidViewsHandler$ui_release(), v51);
                            if(i4 == null) {
                                u2 = u1;
                                accessibilityNodeInfo5.setTraversalBefore(u2, v51);
                            }
                            else {
                                accessibilityNodeInfo5.setTraversalBefore(i4);
                                u2 = u1;
                            }
                            c2.a(v, d0, c2.D, null);
                        }
                        int v52 = c2.C.d(v);
                        if(v52 != -1) {
                            u1.i i5 = N.v(u2.getAndroidViewsHandler$ui_release(), v52);
                            if(i5 != null) {
                                accessibilityNodeInfo5.setTraversalAfter(i5);
                                c2.a(v, d0, c2.E, null);
                            }
                        }
                        d2 = d0;
                        goto label_700;
                    }
                    M0.a.c(("semanticsNode " + v + " has null parent"));
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
    label_700:
        if(c2.o) {
            if(v == c2.k) {
                c2.m = d2;
            }
            if(v == c2.l) {
                c2.n = d2;
            }
        }
        return d2;
    }

    @Override  // d2.f
    public final d c(int v) {
        if(this.b != 0) {
            a a0 = (a)this.c;
            int v1 = v == 2 ? a0.h : a0.i;
            return v1 == 0x80000000 ? null : this.b(v1);
        }
        C c0 = (C)this.c;
        switch(v) {
            case 1: {
                return c0.l == 0x80000000 ? null : this.b(c0.l);
            }
            case 2: {
                return this.b(c0.k);
            }
            default: {
                throw new IllegalArgumentException("Unknown focus type: " + v);
            }
        }
    }

    @Override  // d2.f
    public final boolean d(int v, int v1, Bundle bundle0) {
        int v16;
        int v15;
        Q0.b b4;
        Q0.b b2;
        long v10;
        X0.a a16;
        X0.a a7;
        X0.a a9;
        Float float0;
        float f4;
        float f3;
        Boolean boolean0;
        b b0 = this.c;
        boolean z = true;
        if(this.b != 0) {
            View view0 = ((a)b0).f;
            if(v != -1) {
                switch(v1) {
                    case 1: {
                        return ((a)b0).n(v);
                    }
                    case 2: {
                        return ((a)b0).a(v);
                    }
                    case 0x40: {
                        AccessibilityManager accessibilityManager0 = ((a)b0).e;
                        if(accessibilityManager0.isEnabled() && accessibilityManager0.isTouchExplorationEnabled()) {
                            int v2 = ((a)b0).h;
                            if(v2 != v) {
                                if(v2 != 0x80000000) {
                                    ((a)b0).h = 0x80000000;
                                    view0.invalidate();
                                    ((a)b0).o(v2, 0x10000);
                                }
                                ((a)b0).h = v;
                                view0.invalidate();
                                ((a)b0).o(v, 0x8000);
                                return true;
                            }
                        }
                        break;
                    }
                    case 0x80: {
                        if(((a)b0).h == v) {
                            ((a)b0).h = 0x80000000;
                            view0.invalidate();
                            ((a)b0).o(v, 0x10000);
                            return true;
                        }
                        break;
                    }
                    default: {
                        return ((a)b0).j(v, v1, bundle0);
                    }
                }
                return false;
            }
            return view0.performAccessibilityAction(v1, bundle0);
        }
        C c0 = (C)b0;
        u u0 = c0.a;
        Q0 q00 = (Q0)c0.j().b(v);
        if(q00 != null) {
            p p0 = q00.a;
            if(p0 != null) {
                int v3 = p0.g;
                l l0 = p0.d;
                K k0 = l0.a;
                switch(v1) {
                    case 0x40: {
                        if(c0.d.isEnabled() && c0.d.isTouchExplorationEnabled()) {
                            int v17 = c0.k;
                            if(v17 != v) {
                                if(v17 != 0x80000000) {
                                    C.u(c0, v17, 0x10000, null, 12);
                                }
                                c0.k = v;
                                u0.invalidate();
                                C.u(c0, v, 0x8000, null, 12);
                                return z;
                            }
                        }
                        break;
                    }
                    case 0x80: {
                        if(c0.k == v) {
                            c0.k = 0x80000000;
                            c0.m = null;
                            u0.invalidate();
                            C.u(c0, v, 0x10000, null, 12);
                            return true;
                        }
                        break;
                    }
                    default: {
                        if(v1 != 0x100 && v1 != 0x200) {
                            switch(v1) {
                                case 0x4000: {
                                    Object object47 = k0.g(k.p);
                                    Object object48 = object47 == null ? null : object47;
                                    if(((X0.a)object48) != null) {
                                        we.a a18 = (we.a)((X0.a)object48).b;
                                        return a18 == null ? false : ((Boolean)a18.invoke()).booleanValue();
                                    }
                                    break;
                                }
                                case 0x20000: {
                                    z = c0.A(p0, (bundle0 == null ? -1 : bundle0.getInt("ACTION_ARGUMENT_SELECTION_START_INT", -1)), (bundle0 == null ? -1 : bundle0.getInt("ACTION_ARGUMENT_SELECTION_END_INT", -1)), false);
                                    if(!z) {
                                        return z;
                                    }
                                    C.u(c0, c0.q(v3), 0, null, 12);
                                    return true;
                                }
                                default: {
                                    if(Q0.F.a(p0)) {
                                        switch(v1) {
                                            case 1: {
                                                Object object11 = k0.g(k.v);
                                                Object object12 = object11 == null ? null : object11;
                                                if(((X0.a)object12) != null) {
                                                    we.a a5 = (we.a)((X0.a)object12).b;
                                                    return a5 == null ? false : ((Boolean)a5.invoke()).booleanValue();
                                                }
                                                break;
                                            }
                                            case 2: {
                                                Object object13 = k0.g(X0.s.k);
                                                if(kotlin.jvm.internal.q.b((object13 == null ? null : object13), Boolean.TRUE)) {
                                                    ((w0.k)u0.getFocusOwner()).c(8, false, true);
                                                    return true;
                                                }
                                                break;
                                            }
                                            case 16: {
                                                Object object0 = k0.g(k.b);
                                                if(object0 == null) {
                                                    object0 = null;
                                                }
                                                if(((X0.a)object0) == null) {
                                                    boolean0 = null;
                                                }
                                                else {
                                                    we.a a0 = (we.a)((X0.a)object0).b;
                                                    boolean0 = a0 == null ? null : ((Boolean)a0.invoke());
                                                }
                                                C.u(c0, v, 1, null, 12);
                                                return boolean0 == null ? false : boolean0.booleanValue();
                                            label_56:
                                                if(v1 == 0x1020038 || v1 == 0x1020039 || v1 == 0x102003A || v1 == 0x102003B) {
                                                    goto label_108;
                                                }
                                                else {
                                                    switch(v1) {
                                                        case 0x1020046: {
                                                            Object object3 = k0.g(k.x);
                                                            Object object4 = object3 == null ? null : object3;
                                                            if(((X0.a)object4) != null) {
                                                                we.a a1 = (we.a)((X0.a)object4).b;
                                                                return a1 == null ? false : ((Boolean)a1.invoke()).booleanValue();
                                                            }
                                                            break;
                                                        }
                                                        case 0x1020047: {
                                                            Object object5 = k0.g(k.z);
                                                            Object object6 = object5 == null ? null : object5;
                                                            if(((X0.a)object6) != null) {
                                                                we.a a2 = (we.a)((X0.a)object6).b;
                                                                return a2 == null ? false : ((Boolean)a2.invoke()).booleanValue();
                                                            }
                                                            break;
                                                        }
                                                        case 0x1020048: {
                                                            Object object7 = k0.g(k.y);
                                                            Object object8 = object7 == null ? null : object7;
                                                            if(((X0.a)object8) != null) {
                                                                we.a a3 = (we.a)((X0.a)object8).b;
                                                                return a3 == null ? false : ((Boolean)a3.invoke()).booleanValue();
                                                            }
                                                            break;
                                                        }
                                                        case 0x1020049: {
                                                            Object object9 = k0.g(k.A);
                                                            Object object10 = object9 == null ? null : object9;
                                                            if(((X0.a)object10) != null) {
                                                                we.a a4 = (we.a)((X0.a)object10).b;
                                                                return a4 == null ? false : ((Boolean)a4.invoke()).booleanValue();
                                                            }
                                                            break;
                                                        }
                                                        default: {
                                                            W w0 = (W)c0.r.c(v);
                                                            if(w0 != null) {
                                                                CharSequence charSequence0 = (CharSequence)w0.c(v1);
                                                                if(charSequence0 != null) {
                                                                    Object object1 = k0.g(k.w);
                                                                    Object object2 = object1 == null ? null : object1;
                                                                    if(((List)object2) != null) {
                                                                        int v4 = ((List)object2).size();
                                                                        for(int v5 = 0; v5 < v4; ++v5) {
                                                                            X0.e e0 = (X0.e)((List)object2).get(v5);
                                                                            if(kotlin.jvm.internal.q.b(e0.a, charSequence0)) {
                                                                                return ((Boolean)e0.b.invoke()).booleanValue();
                                                                            }
                                                                        }
                                                                        return false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                break;
                                            }
                                            case 0x20: {
                                                Object object14 = k0.g(k.c);
                                                Object object15 = object14 == null ? null : object14;
                                                if(((X0.a)object15) != null) {
                                                    we.a a6 = (we.a)((X0.a)object15).b;
                                                    return a6 == null ? false : ((Boolean)a6.invoke()).booleanValue();
                                                }
                                                break;
                                            }
                                            case 0x1000: 
                                            case 0x2000: {
                                            label_108:
                                                if(v1 == 0x1000 || v1 == 0x2000) {
                                                    Object object16 = k0.g(X0.s.c);
                                                    if(object16 == null) {
                                                        object16 = null;
                                                    }
                                                    Object object17 = k0.g(k.h);
                                                    if(object17 == null) {
                                                        object17 = null;
                                                    }
                                                    if(((h)object16) != null) {
                                                        Ce.d d0 = ((h)object16).b;
                                                        if(((X0.a)object17) != null) {
                                                            float f = d0.b;
                                                            float f1 = d0.a;
                                                            float f2 = f < f1 ? f1 : f;
                                                            if(f1 <= f) {
                                                                f = f1;
                                                            }
                                                            int v6 = ((h)object16).c;
                                                            if(v6 > 0) {
                                                                f3 = f2 - f;
                                                                f4 = (float)(v6 + 1);
                                                            }
                                                            else {
                                                                f3 = f2 - f;
                                                                f4 = 20.0f;
                                                            }
                                                            float f5 = f3 / f4;
                                                            if(v1 == 0x2000) {
                                                                f5 = -f5;
                                                            }
                                                            we.k k1 = (we.k)((X0.a)object17).b;
                                                            return k1 == null ? false : ((Boolean)k1.invoke(((float)(((h)object16).a + f5)))).booleanValue();
                                                        }
                                                    }
                                                }
                                                long v7 = g0.e(((P0.v)p0.c.b0.c)).b();
                                                ArrayList arrayList0 = new ArrayList();
                                                Object object18 = k0.g(k.B);
                                                if(object18 == null) {
                                                    object18 = null;
                                                }
                                                if(((X0.a)object18) == null) {
                                                    float0 = null;
                                                }
                                                else {
                                                    we.k k2 = (we.k)((X0.a)object18).b;
                                                    float0 = k2 == null || !((Boolean)k2.invoke(arrayList0)).booleanValue() ? null : ((Float)arrayList0.get(0));
                                                }
                                                Object object19 = k0.g(k.d);
                                                if(object19 == null) {
                                                    object19 = null;
                                                }
                                                if(((X0.a)object19) != null) {
                                                    ie.f f6 = ((X0.a)object19).b;
                                                    Object object20 = k0.g(X0.s.s);
                                                    if(object20 == null) {
                                                        object20 = null;
                                                    }
                                                    if(((X0.j)object20) == null || v1 != 0x1020039 && v1 != 0x102003B && v1 != 0x1000 && v1 != 0x2000) {
                                                    label_177:
                                                        Object object23 = k0.g(X0.s.t);
                                                        if(object23 == null) {
                                                            object23 = null;
                                                        }
                                                        if(((X0.j)object23) != null && (v1 == 0x1020038 || v1 == 0x102003A || v1 == 0x1000 || v1 == 0x2000)) {
                                                            float f8 = float0 == null ? Float.intBitsToFloat(((int)(0xFFFFFFFFL & v7))) : ((float)float0);
                                                            if(v1 == 0x1020038 || v1 == 0x2000) {
                                                                f8 = -f8;
                                                            }
                                                            if(((X0.j)object23).c) {
                                                                f8 = -f8;
                                                            }
                                                            if(C.n(((X0.j)object23), f8)) {
                                                                X0.w w2 = k.x;
                                                                if(!k0.c(w2) && !k0.c(k.z)) {
                                                                    return ((we.n)f6) == null ? false : ((Boolean)((we.n)f6).invoke(0.0f, f8)).booleanValue();
                                                                }
                                                                if(f8 > 0.0f) {
                                                                    Object object24 = k0.g(k.z);
                                                                    a9 = (X0.a)(object24 == null ? null : object24);
                                                                }
                                                                else {
                                                                    Object object25 = k0.g(w2);
                                                                    a9 = (X0.a)(object25 == null ? null : object25);
                                                                }
                                                                if(a9 != null) {
                                                                    we.a a10 = (we.a)a9.b;
                                                                    return a10 == null ? false : ((Boolean)a10.invoke()).booleanValue();
                                                                }
                                                            }
                                                        }
                                                    }
                                                    else {
                                                        float f7 = float0 == null ? Float.intBitsToFloat(((int)(v7 >> 0x20))) : ((float)float0);
                                                        if(v1 == 0x1020039 || v1 == 0x2000) {
                                                            f7 = -f7;
                                                        }
                                                        if(((X0.j)object20).c) {
                                                            f7 = -f7;
                                                        }
                                                        if(Q0.F.f(p0) && (v1 == 0x1020039 || v1 == 0x102003B)) {
                                                            f7 = -f7;
                                                        }
                                                        if(C.n(((X0.j)object20), f7)) {
                                                            X0.w w1 = k.y;
                                                            if(!k0.c(w1) && !k0.c(k.A)) {
                                                                return ((we.n)f6) == null ? false : ((Boolean)((we.n)f6).invoke(f7, 0.0f)).booleanValue();
                                                            }
                                                            if(f7 > 0.0f) {
                                                                Object object21 = k0.g(k.A);
                                                                a7 = (X0.a)(object21 == null ? null : object21);
                                                            }
                                                            else {
                                                                Object object22 = k0.g(w1);
                                                                a7 = (X0.a)(object22 == null ? null : object22);
                                                            }
                                                            if(a7 != null) {
                                                                we.a a8 = (we.a)a7.b;
                                                                return a8 == null ? false : ((Boolean)a8.invoke()).booleanValue();
                                                            }
                                                        }
                                                        else {
                                                            goto label_177;
                                                        }
                                                    }
                                                }
                                                break;
                                            }
                                            case 0x8000: {
                                                Object object26 = k0.g(k.r);
                                                Object object27 = object26 == null ? null : object26;
                                                if(((X0.a)object27) != null) {
                                                    we.a a11 = (we.a)((X0.a)object27).b;
                                                    return a11 == null ? false : ((Boolean)a11.invoke()).booleanValue();
                                                }
                                                break;
                                            }
                                            case 0x10000: {
                                                Object object28 = k0.g(k.q);
                                                Object object29 = object28 == null ? null : object28;
                                                if(((X0.a)object29) != null) {
                                                    we.a a12 = (we.a)((X0.a)object29).b;
                                                    return a12 == null ? false : ((Boolean)a12.invoke()).booleanValue();
                                                }
                                                break;
                                            }
                                            case 0x40000: {
                                                Object object30 = k0.g(k.s);
                                                Object object31 = object30 == null ? null : object30;
                                                if(((X0.a)object31) != null) {
                                                    we.a a13 = (we.a)((X0.a)object31).b;
                                                    return a13 == null ? false : ((Boolean)a13.invoke()).booleanValue();
                                                }
                                                break;
                                            }
                                            case 0x80000: {
                                                Object object32 = k0.g(k.t);
                                                Object object33 = object32 == null ? null : object32;
                                                if(((X0.a)object33) != null) {
                                                    we.a a14 = (we.a)((X0.a)object33).b;
                                                    return a14 == null ? false : ((Boolean)a14.invoke()).booleanValue();
                                                }
                                                break;
                                            }
                                            case 0x100000: {
                                                Object object34 = k0.g(k.u);
                                                Object object35 = object34 == null ? null : object34;
                                                if(((X0.a)object35) != null) {
                                                    we.a a15 = (we.a)((X0.a)object35).b;
                                                    return a15 == null ? false : ((Boolean)a15.invoke()).booleanValue();
                                                }
                                                break;
                                            }
                                            case 0x200000: {
                                                String s = bundle0 == null ? null : bundle0.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
                                                Object object36 = k0.g(k.j);
                                                Object object37 = object36 == null ? null : object36;
                                                if(((X0.a)object37) != null) {
                                                    we.k k3 = (we.k)((X0.a)object37).b;
                                                    if(k3 != null) {
                                                        if(s == null) {
                                                            s = "";
                                                        }
                                                        return ((Boolean)k3.invoke(new g(s))).booleanValue();
                                                    }
                                                }
                                                break;
                                            }
                                            case 0x1020036: {
                                                p p1 = p0.j();
                                                if(p1 != null) {
                                                    Object object38 = p1.d.a.g(k.d);
                                                    if(object38 == null) {
                                                        object38 = null;
                                                    }
                                                    a16 = (X0.a)object38;
                                                    goto label_241;
                                                }
                                                while(true) {
                                                    a16 = null;
                                                label_241:
                                                    if(p1 == null || a16 != null) {
                                                        break;
                                                    }
                                                    p1 = p1.j();
                                                    if(p1 == null) {
                                                        continue;
                                                    }
                                                    Object object39 = p1.d.a.g(k.d);
                                                    if(object39 == null) {
                                                        object39 = null;
                                                    }
                                                    a16 = (X0.a)object39;
                                                    goto label_241;
                                                }
                                                if(p1 != null) {
                                                    K k4 = p1.d.a;
                                                    x0.c c1 = g0.e(((P0.v)p1.c.b0.c));
                                                    N0.v v8 = ((P0.v)p1.c.b0.c).X();
                                                    long v9 = 0L;
                                                    x0.c c2 = c1.h((v8 == null ? 0L : ((j0)v8).j0(0L)));
                                                    j0 j00 = p0.c();
                                                    if(j00 == null) {
                                                        v10 = 0L;
                                                    }
                                                    else {
                                                        if(!j00.h()) {
                                                            j00 = null;
                                                        }
                                                        v10 = j00 == null ? 0L : j00.j0(0L);
                                                    }
                                                    j0 j01 = p0.c();
                                                    if(j01 != null) {
                                                        v9 = j01.c;
                                                    }
                                                    x0.c c3 = e.k.d(v10, e1.n.E(v9));
                                                    Object object40 = k4.g(X0.s.s);
                                                    if(object40 == null) {
                                                        object40 = null;
                                                    }
                                                    Object object41 = k4.g(X0.s.t);
                                                    Object object42 = object41 == null ? null : object41;
                                                    float f9 = c3.a - c2.a;
                                                    float f10 = c3.c - c2.c;
                                                    if(Math.signum(f9) != Math.signum(f10)) {
                                                        f9 = 0.0f;
                                                    }
                                                    else if(Math.abs(f9) >= Math.abs(f10)) {
                                                        f9 = f10;
                                                    }
                                                    if(((X0.j)object40) != null && ((X0.j)object40).c) {
                                                        f9 = -f9;
                                                    }
                                                    if(Q0.F.f(p0)) {
                                                        f9 = -f9;
                                                    }
                                                    float f11 = c3.b - c2.b;
                                                    float f12 = c3.d - c2.d;
                                                    if(Math.signum(f11) != Math.signum(f12)) {
                                                        f12 = 0.0f;
                                                    }
                                                    else if(Math.abs(f11) < Math.abs(f12)) {
                                                        f12 = f11;
                                                    }
                                                    if(((X0.j)object42) != null && ((X0.j)object42).c) {
                                                        f12 = -f12;
                                                    }
                                                    if(a16 != null) {
                                                        we.n n0 = (we.n)a16.b;
                                                        return n0 == null ? false : ((Boolean)n0.invoke(f9, f12)).booleanValue();
                                                    }
                                                }
                                                break;
                                            }
                                            case 0x102003D: {
                                                if(bundle0 != null && bundle0.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                                                    Object object43 = k0.g(k.h);
                                                    Object object44 = object43 == null ? null : object43;
                                                    if(((X0.a)object44) != null) {
                                                        we.k k5 = (we.k)((X0.a)object44).b;
                                                        return k5 == null ? false : ((Boolean)k5.invoke(bundle0.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))).booleanValue();
                                                    }
                                                }
                                                break;
                                            }
                                            case 0x1020054: {
                                                Object object45 = k0.g(k.o);
                                                Object object46 = object45 == null ? null : object45;
                                                if(((X0.a)object46) != null) {
                                                    we.a a17 = (we.a)((X0.a)object46).b;
                                                    return a17 == null ? false : ((Boolean)a17.invoke()).booleanValue();
                                                }
                                                break;
                                            }
                                            default: {
                                                goto label_56;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else if(bundle0 != null) {
                            int v11 = bundle0.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
                            boolean z1 = bundle0.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
                            if(c0.u == null || v3 != ((int)c0.u)) {
                                c0.t = -1;
                                c0.u = v3;
                            }
                            String s1 = C.k(p0);
                            if(s1 != null && s1.length() != 0) {
                                String s2 = C.k(p0);
                                if(s2 == null || s2.length() == 0) {
                                label_378:
                                    b4 = null;
                                }
                                else {
                                    switch(v11) {
                                        case 1: {
                                            Locale locale0 = u0.getContext().getResources().getConfiguration().locale;
                                            if(Q0.b.e == null) {
                                                Q0.b b1 = new Q0.b(0);
                                                b1.d = BreakIterator.getCharacterInstance(locale0);
                                                Q0.b.e = b1;
                                            }
                                            b2 = Q0.b.e;
                                            kotlin.jvm.internal.q.e(b2, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
                                            b2.y(s2);
                                            b4 = b2;
                                            break;
                                        }
                                        case 2: {
                                            Locale locale1 = u0.getContext().getResources().getConfiguration().locale;
                                            if(Q0.b.f == null) {
                                                Q0.b b3 = new Q0.b(1);
                                                b3.d = BreakIterator.getWordInstance(locale1);
                                                Q0.b.f = b3;
                                            }
                                            b2 = Q0.b.f;
                                            kotlin.jvm.internal.q.e(b2, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator");
                                            b2.y(s2);
                                            b4 = b2;
                                            break;
                                        }
                                        case 8: {
                                            if(Q0.e.c == null) {
                                                Q0.e.c = new Q0.e(0, false);  // 初始化器: LQ0/a;-><init>(IZ)V
                                            }
                                            b2 = Q0.e.c;
                                            kotlin.jvm.internal.q.e(b2, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator");
                                            b2.a = s2;
                                            b4 = b2;
                                            break;
                                        }
                                        case 4: 
                                        case 16: {
                                            if(k0.c(k.a)) {
                                                Q q0 = N.m(l0);
                                                if(q0 == null) {
                                                    b4 = null;
                                                }
                                                else {
                                                    if(v11 == 4) {
                                                        if(Q0.c.d == null) {
                                                            Q0.c.d = new Q0.c(0, false);  // 初始化器: LQ0/a;-><init>(IZ)V
                                                        }
                                                        b2 = Q0.c.d;
                                                        kotlin.jvm.internal.q.e(b2, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator");
                                                        b2.a = s2;
                                                        b2.c = q0;
                                                    }
                                                    else {
                                                        if(Q0.d.e == null) {
                                                            Q0.d d1 = new Q0.d(0, false);  // 初始化器: LQ0/a;-><init>(IZ)V
                                                            new Rect();
                                                            Q0.d.e = d1;
                                                        }
                                                        b2 = Q0.d.e;
                                                        kotlin.jvm.internal.q.e(b2, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
                                                        b2.a = s2;
                                                        b2.c = q0;
                                                        b2.d = p0;
                                                    }
                                                    b4 = b2;
                                                }
                                            }
                                            else {
                                                goto label_378;
                                            }
                                            break;
                                        }
                                        default: {
                                            goto label_378;
                                        }
                                    }
                                }
                                if(b4 != null) {
                                    int v12 = c0.h(p0);
                                    if(v12 == -1) {
                                        v12 = v1 == 0x100 ? s1.length() : 0;
                                    }
                                    int[] arr_v = v1 == 0x100 ? b4.s(v12) : b4.f(v12);
                                    if(arr_v != null) {
                                        int v13 = arr_v[0];
                                        int v14 = arr_v[1];
                                        if(!z1 || k0.c(X0.s.a) || !k0.c(X0.s.C)) {
                                            v15 = v1 == 0x100 ? v13 : v14;
                                            v16 = v15;
                                        }
                                        else {
                                            v15 = c0.i(p0);
                                            if(v15 == -1) {
                                                v15 = v1 == 0x100 ? v14 : v13;
                                            }
                                            v16 = v1 == 0x100 ? v14 : v13;
                                        }
                                        c0.y = new z(p0, (v1 == 0x100 ? 0x200 : 0x100), v11, v13, v14, SystemClock.uptimeMillis());
                                        c0.A(p0, v15, v16, true);
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}

