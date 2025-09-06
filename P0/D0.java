package P0;

import G.j0;
import G.x;
import Ic.h;
import Q0.n;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.datepicker.p;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.interfaces.StringProviderImpl;
import d5.t;
import e1.m;
import ie.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import je.w;
import je.y;
import kotlin.jvm.internal.q;
import m9.l;
import n1.a;
import n1.b;
import n1.e;
import n1.g;
import n1.i;
import n1.j;
import n1.k;
import n1.u;
import oc.H;
import q8.d;
import r0.o;
import rd.x0;

public final class d0 {
    public final int a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public Object i;

    public d0() {
        this.a = 3;
        super();
    }

    public d0(I i0) {
        this.a = 0;
        super();
        this.b = i0;
        v v0 = new v(i0);
        this.c = v0;
        this.d = v0;
        this.e = v0.h0;
        this.f = v0.h0;
    }

    public d0(n n0, h h0) {
        this.a = 4;
        super();
        this.b = n0;
        this.c = h0;
        e e0 = new e(5, new j(this, 4));
        this.d = e0;
        e e1 = new e(2, new j(this, 1));
        this.e = e1;
        e e2 = new e(3, new j(this, 2));
        this.f = e2;
        Set set0 = je.n.A0(new i[]{e0, e2});
        Collection collection0 = w.a;
        Collection collection1 = a.e ? m.E(new e(1, new j(this, 0))) : collection0;
        LinkedHashSet linkedHashSet0 = je.I.K(set0, collection1);
        Set set1 = y.a;
        LinkedHashSet linkedHashSet1 = je.I.K(linkedHashSet0, (k.c ? m.E(new e(4, new j(this, 3))) : set1));
        if(b.c) {
            set1 = m.E(e1);
        }
        LinkedHashSet linkedHashSet2 = je.I.K(linkedHashSet1, set1);
        this.g = linkedHashSet2;
        if(u.a) {
            e e3 = new e(0, new j(this, 5));
            j j0 = new j(this, 6);
            g g0 = new g(kotlin.jvm.internal.I.a.b(j0.class), j0);
            j j1 = new j(this, 7);
            collection0 = je.n.A0(new i[]{e3, g0, new g(kotlin.jvm.internal.I.a.b(x.class), j1)});
        }
        LinkedHashSet linkedHashSet3 = je.I.K(linkedHashSet2, collection0);
        this.h = linkedHashSet3;
        this.i = je.I.K(linkedHashSet3, m.E(e1));
    }

    public d0(Context context0) {
        this.a = 1;
        super();
        TypedArray typedArray0 = context0.obtainStyledAttributes(m.A(context0, 0x7F040401, p.class.getCanonicalName()).data, d6.a.C);  // attr:materialCalendarStyle
        this.b = androidx.recyclerview.widget.b.e(context0, typedArray0.getResourceId(4, 0));
        this.h = androidx.recyclerview.widget.b.e(context0, typedArray0.getResourceId(2, 0));
        this.c = androidx.recyclerview.widget.b.e(context0, typedArray0.getResourceId(3, 0));
        this.d = androidx.recyclerview.widget.b.e(context0, typedArray0.getResourceId(5, 0));
        ColorStateList colorStateList0 = e1.n.r(context0, typedArray0, 7);
        this.e = androidx.recyclerview.widget.b.e(context0, typedArray0.getResourceId(9, 0));
        this.f = androidx.recyclerview.widget.b.e(context0, typedArray0.getResourceId(8, 0));
        this.g = androidx.recyclerview.widget.b.e(context0, typedArray0.getResourceId(10, 0));
        Paint paint0 = new Paint();
        this.i = paint0;
        paint0.setColor(colorStateList0.getDefaultColor());
        typedArray0.recycle();
    }

    public d0(StringProviderImpl stringProviderImpl0, sd.x x0, sd.x x1, sd.y y0, sd.y y1, sd.x x2, sd.y y2) {
        this.a = 5;
        super();
        this.b = stringProviderImpl0;
        this.c = x0;
        this.d = x1;
        this.e = y0;
        this.f = y1;
        this.g = x2;
        this.h = y2;
        this.i = d3.g.Q(new p8.e(11));
    }

    public d0(String s, String s1, ArrayList arrayList0, String s2, String s3, String s4, String s5, DevelopmentPlatformProvider developmentPlatformProvider0) {
        this.a = 2;
        super();
        this.b = s;
        this.c = s1;
        this.d = arrayList0;
        this.e = s2;
        this.f = s3;
        this.g = s4;
        this.h = s5;
        this.i = developmentPlatformProvider0;
    }

    public static final void a(d0 d00, r0.p p0, P0.j0 j00) {
        for(r0.p p1 = p0.getParent$ui_release(); p1 != null; p1 = p1.getParent$ui_release()) {
            if(p1 == f0.a) {
                I i0 = ((I)d00.b).u();
                j00.n = i0 == null ? null : ((v)i0.b0.c);
                d00.d = j00;
                return;
            }
            if((p1.getKindSet$ui_release() & 2) != 0) {
                break;
            }
            p1.updateCoordinator$ui_release(j00);
        }
    }

    public static r0.p b(o o0, r0.p p0) {
        r0.p p1;
        if(o0 instanceof a0) {
            p1 = ((a0)o0).create();
            p1.setKindSet$ui_release(k0.g(p1));
        }
        else {
            c c0 = new c();  // 初始化器: Lr0/p;-><init>()V
            c0.setKindSet$ui_release(k0.e(o0));
            c0.a = o0;
            c0.c = new HashSet();
            p1 = c0;
        }
        if(p1.isAttached()) {
            M0.a.b("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        p1.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
        r0.p p2 = p0.getChild$ui_release();
        if(p2 != null) {
            p2.setParent$ui_release(p1);
            p1.setChild$ui_release(p2);
        }
        p0.setChild$ui_release(p1);
        p1.setParent$ui_release(p0);
        return p1;
    }

    public static r0.p c(r0.p p0) {
        if(p0.isAttached()) {
            if(!p0.isAttached()) {
                M0.a.b("autoInvalidateRemovedNode called on unattached node");
            }
            k0.b(p0, -1, 2);
            p0.runDetachLifecycle$ui_release();
            p0.markAsDetached$ui_release();
        }
        r0.p p1 = p0.getChild$ui_release();
        r0.p p2 = p0.getParent$ui_release();
        if(p1 != null) {
            p1.setParent$ui_release(p2);
            p0.setChild$ui_release(null);
        }
        if(p2 != null) {
            p2.setChild$ui_release(p1);
            p0.setParent$ui_release(null);
        }
        q.d(p2);
        return p2;
    }

    public String d(int v) {
        return ((StringProviderImpl)this.b).a(v);
    }

    public boolean e(int v) {
        return (v & ((r0.p)this.f).getAggregateChildKindSet$ui_release()) != 0;
    }

    public boolean f() {
        Iterable iterable0 = (List)((r)this.i).getValue();
        H h0 = (H)((sd.x)this.d).invoke();
        return h0 == null ? je.p.d0(iterable0, null) : je.p.d0(iterable0, h0.getId());
    }

    public void g() {
        P0.j0 j00 = (P0.j0)this.d;
        v v0 = (v)this.c;
        while(j00 != v0) {
            j00.b1();
            j00 = j00.m;
            q.d(j00);
        }
        v0.b1();
        for(r0.p p0 = (r0.p)this.f; p0 != null; p0 = p0.getChild$ui_release()) {
            p0.runAttachLifecycle$ui_release();
            if(p0.getInsertedNodeAwaitingAttachForInvalidation$ui_release()) {
                k0.a(p0);
            }
            if(p0.getUpdatedNodeAwaitingAttachForInvalidation$ui_release()) {
                k0.d(p0);
            }
            p0.setInsertedNodeAwaitingAttachForInvalidation$ui_release(false);
            p0.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(false);
        }
    }

    public void h() {
        for(r0.p p0 = (A0)this.e; p0 != null; p0 = p0.getParent$ui_release()) {
            if(p0.isAttached()) {
                p0.runDetachLifecycle$ui_release();
            }
        }
        P0.j0 j00 = (v)this.c;
        P0.j0 j01 = (P0.j0)this.d;
        while(j00 != j01) {
            q0 q00 = j00.b0;
            if(q00 != null) {
                q00.destroy();
            }
            j00.b0 = null;
            j00 = j00.n;
            q.d(j00);
        }
        q0 q01 = j01.b0;
        if(q01 != null) {
            q01.destroy();
        }
        j01.b0 = null;
    }

    public static void i(d0 d00, d d0, ActionKind actionKind0) {
        Playable playable0 = (Playable)((sd.x)d00.c).invoke();
        H h0 = (H)((sd.x)d00.d).invoke();
        if(h0 instanceof rc.a) {
            d0.c(new sd.q(actionKind0, d00, 0));
            d0.k(new l(11, ((rc.a)h0), d00));
            q8.c c0 = new q8.c();
            c0.a(new p8.e(12));
            ((LinkedHashMap)d0.g).putAll(c0.a);
            return;
        }
        if(h0 instanceof pc.d && t.k(((pc.d)h0))) {
            d0.c(new sd.q(actionKind0, d00, 1));
            d0.b(new sd.r(d00, playable0, 0));
            d0.k(new x0(15, playable0));
            d0.e(new x0(16, playable0));
            d0.d(new sd.r(d00, playable0, 1));
            return;
        }
        d0.c(new sd.q(actionKind0, d00, 2));
        d0.k(new x0(17, playable0));
        d0.e(new x0(14, playable0));
        q8.c c1 = new q8.c();
        c1.a(new p8.e(13));
        ((LinkedHashMap)d0.g).putAll(c1.a);
    }

    public void j(int v, g0.e e0, g0.e e1, r0.p p0, boolean z) {
        int v36;
        int v35;
        int v31;
        int v30;
        int v29;
        int v26;
        int v21;
        int v20;
        int[] arr_v5;
        int v19;
        int[] arr_v4;
        c0 c00 = (c0)this.i;
        if(c00 == null) {
            c00 = new c0(this, p0, v, e0, e1, z);
            this.i = c00;
        }
        else {
            c00.d = p0;
            c00.b = v;
            c00.e = e0;
            c00.f = e1;
            c00.c = z;
        }
        d0 d00 = (d0)c00.g;
        int v1 = e0.c - v;
        int v2 = e1.c - v;
        int v3 = (v1 + v2 + 1) / 2;
        P0.w w0 = new P0.w(v3 * 3);
        P0.w w1 = new P0.w(v3 * 4);
        w1.e(0, v1, 0, v2);
        int v4 = v3 * 2 + 1;
        int[] arr_v = new int[v4];
        int[] arr_v1 = new int[v4];
        int[] arr_v2 = new int[5];
        int v5;
        while((v5 = w1.b) != 0) {
            int[] arr_v3 = w1.a;
            w1.b = v5 - 1;
            int v6 = arr_v3[v5 - 1];
            w1.b = v5 - 2;
            int v7 = arr_v3[v5 - 2];
            w1.b = v5 - 3;
            int v8 = arr_v3[v5 - 3];
            w1.b = v5 - 4;
            int v9 = arr_v3[v5 - 4];
            int v10 = v8 - v9;
            int v11 = v6 - v7;
            if(v10 >= 1 && v11 >= 1) {
                int v12 = (v10 + v11 + 1) / 2;
                arr_v[v4 / 2 + 1] = v9;
                arr_v1[v4 / 2 + 1] = v8;
                int v13 = v11;
                int v14 = 0;
                while(v14 < v12) {
                    int v15 = v10 - v13;
                    arr_v4 = arr_v1;
                    int v16 = -v14;
                    int v17 = (Math.abs(v15) & 1) == 1 ? 1 : 0;
                    int v18 = v16;
                    while(v18 <= v14) {
                        if(v18 == v16) {
                            v19 = v18;
                            arr_v5 = arr_v2;
                        }
                        else {
                            if(v18 == v14) {
                                v19 = v18;
                                arr_v5 = arr_v2;
                            }
                            else {
                                v19 = v18;
                                arr_v5 = arr_v2;
                                if(arr_v[v18 + 1 + v4 / 2] > arr_v[v19 - 1 + v4 / 2]) {
                                    goto label_60;
                                }
                            }
                            v20 = arr_v[v19 - 1 + v4 / 2];
                            v21 = v20 + 1;
                            goto label_62;
                        }
                    label_60:
                        v20 = arr_v[v19 + 1 + v4 / 2];
                        v21 = v20;
                    label_62:
                        int v22 = v21 - v9 + v7 - v19;
                        int v23 = v21 == v20 ? 1 : 0;
                        int v24;
                        for(v24 = v22; v21 < v8 && v24 < v6 && c00.j(v21, v24); ++v24) {
                            ++v21;
                        }
                        arr_v[v4 / 2 + v19] = v21;
                        if(v17 == 0) {
                        label_81:
                            v26 = v10;
                        }
                        else {
                            int v25 = v15 - v19;
                            if(v25 >= v16 + 1 && v25 <= v14 - 1 && arr_v4[v4 / 2 + v25] <= v21) {
                                arr_v5[0] = v20;
                                arr_v5[1] = v22 - ((v14 == 0 ? 0 : 1) & v23);
                                arr_v5[2] = v21;
                                arr_v5[3] = v24;
                                arr_v5[4] = 0;
                                goto label_125;
                            }
                            else {
                                v26 = v10;
                                goto label_82;
                            }
                            goto label_81;
                        }
                    label_82:
                        v18 = v19 + 2;
                        arr_v2 = arr_v5;
                        v10 = v26;
                    }
                    arr_v5 = arr_v2;
                    int v27 = (v15 & 1) == 0 ? 1 : 0;
                    int v28 = v16;
                    while(v28 <= v14) {
                        if(v28 == v16) {
                            v29 = v27;
                        }
                        else {
                            if(v28 == v14) {
                                v29 = v27;
                            }
                            else {
                                v29 = v27;
                                if(arr_v4[v28 + 1 + v4 / 2] < arr_v4[v28 - 1 + v4 / 2]) {
                                    goto label_100;
                                }
                            }
                            v30 = arr_v4[v28 - 1 + v4 / 2];
                            v31 = v30 - 1;
                            goto label_102;
                        }
                    label_100:
                        v30 = arr_v4[v28 + 1 + v4 / 2];
                        v31 = v30;
                    label_102:
                        int v32 = v6 - (v8 - v31 - v28);
                        int v33 = v31 == v30 ? 1 : 0;
                        int v34 = v32;
                        while(true) {
                            if(v31 > v9 && v34 > v7) {
                                v35 = v34;
                                v36 = v28;
                                if(c00.j(v31 - 1, v35 - 1)) {
                                    --v31;
                                    v34 = v35 - 1;
                                    v28 = v36;
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }
                            v35 = v34;
                            v36 = v28;
                            break;
                        }
                        arr_v4[v4 / 2 + v36] = v31;
                        if(v29 != 0) {
                            int v37 = v15 - v36;
                            if(v37 >= v16 && v37 <= v14 && arr_v[v4 / 2 + v37] >= v31) {
                                arr_v5[0] = v31;
                                arr_v5[1] = v35;
                                arr_v5[2] = v30;
                                arr_v5[3] = v32 + ((v14 == 0 ? 0 : 1) & v33);
                                arr_v5[4] = 1;
                            label_125:
                                if(Math.min(arr_v5[2] - arr_v5[0], arr_v5[3] - arr_v5[1]) > 0) {
                                    int v38 = arr_v5[0];
                                    int v39 = arr_v5[1];
                                    int v40 = arr_v5[3] - v39;
                                    int v41 = arr_v5[2] - v38;
                                    if(v40 != v41) {
                                        v41 = Math.min(v41, v40);
                                        int v42 = arr_v5[4];
                                        int v43 = arr_v5[3];
                                        int v44 = arr_v5[1];
                                        int v45 = arr_v5[2];
                                        v39 += ((v43 - v44 <= v45 - arr_v5[0] ? 0 : 1) ^ 1 | (v42 == 0 ? 0 : 1)) ^ 1;
                                        v38 += ((v43 - v44 <= v45 - arr_v5[0] ? 0 : 1) | (v42 == 0 ? 0 : 1)) ^ 1;
                                    }
                                    w0.d(v38, v39, v41);
                                }
                                w1.e(v9, arr_v5[0], v7, arr_v5[1]);
                                w1.e(arr_v5[2], v8, arr_v5[3], v6);
                                goto label_151;
                            }
                        }
                        v28 = v36 + 2;
                        v27 = v29;
                    }
                    ++v14;
                    arr_v1 = arr_v4;
                    arr_v2 = arr_v5;
                }
            }
            arr_v4 = arr_v1;
            arr_v5 = arr_v2;
        label_151:
            arr_v1 = arr_v4;
            arr_v2 = arr_v5;
        }
        int v46 = w0.b;
        if(v46 % 3 != 0) {
            M0.a.b("Array size not a multiple of 3");
        }
        if(v46 > 3) {
            w0.f(0, v46 - 3);
        }
        w0.d(v1, v2, 0);
        int v47 = 0;
        int v48 = 0;
        int v49 = 0;
        while(v47 < w0.b) {
            int[] arr_v6 = w0.a;
            int v50 = arr_v6[v47];
            int v51 = arr_v6[v47 + 2];
            int v52 = v50 - v51;
            int v53 = arr_v6[v47 + 1] - v51;
            v47 += 3;
            while(v48 < v52) {
                r0.p p1 = ((r0.p)c00.d).getChild$ui_release();
                q.d(p1);
                if((p1.getKindSet$ui_release() & 2) != 0) {
                    P0.j0 j00 = p1.getCoordinator$ui_release();
                    q.d(j00);
                    P0.j0 j01 = j00.n;
                    P0.j0 j02 = j00.m;
                    q.d(j02);
                    if(j01 != null) {
                        j01.m = j02;
                    }
                    j02.n = j01;
                    d0.a(d00, ((r0.p)c00.d), j02);
                }
                c00.d = d0.c(p1);
                ++v48;
            }
            while(v49 < v53) {
                r0.p p2 = d0.b(((o)((g0.e)c00.f).a[c00.b + v49]), ((r0.p)c00.d));
                c00.d = p2;
                if(c00.c) {
                    r0.p p3 = p2.getChild$ui_release();
                    q.d(p3);
                    P0.j0 j03 = p3.getCoordinator$ui_release();
                    q.d(j03);
                    z z1 = f.g(((r0.p)c00.d));
                    if(z1 == null) {
                        ((r0.p)c00.d).updateCoordinator$ui_release(j03);
                    }
                    else {
                        B b0 = new B(((I)d00.b), z1);
                        ((r0.p)c00.d).updateCoordinator$ui_release(b0);
                        d0.a(d00, ((r0.p)c00.d), b0);
                        b0.n = j03.n;
                        b0.m = j03;
                        j03.n = b0;
                    }
                    ((r0.p)c00.d).markAsAttached$ui_release();
                    ((r0.p)c00.d).runAttachLifecycle$ui_release();
                    k0.a(((r0.p)c00.d));
                }
                else {
                    p2.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
                }
                ++v49;
            }
            while(v51 > 0) {
                r0.p p4 = ((r0.p)c00.d).getChild$ui_release();
                q.d(p4);
                c00.d = p4;
                int v54 = c00.b;
                o o0 = (o)((g0.e)c00.e).a[v54 + v48];
                o o1 = (o)((g0.e)c00.f).a[v54 + v49];
                if(!q.b(o0, o1)) {
                    d0.l(o0, o1, ((r0.p)c00.d));
                }
                ++v48;
                ++v49;
                --v51;
            }
        }
        r0.p p5 = ((A0)this.e).getParent$ui_release();
        int v55 = 0;
        while(p5 != null && p5 != f0.a) {
            v55 |= p5.getKindSet$ui_release();
            p5.setAggregateChildKindSet$ui_release(v55);
            p5 = p5.getParent$ui_release();
        }
    }

    public void k() {
        B b0;
        I i0 = (I)this.b;
        v v0 = (v)this.c;
        for(r0.p p0 = ((A0)this.e).getParent$ui_release(); p0 != null; p0 = p0.getParent$ui_release()) {
            z z0 = f.g(p0);
            if(z0 == null) {
                p0.updateCoordinator$ui_release(v0);
            }
            else {
                if(p0.getCoordinator$ui_release() == null) {
                    b0 = new B(i0, z0);
                    p0.updateCoordinator$ui_release(b0);
                }
                else {
                    P0.j0 j00 = p0.getCoordinator$ui_release();
                    q.e(j00, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    b0 = (B)j00;
                    z z1 = b0.h0;
                    b0.q1(z0);
                    if(z1 != p0) {
                        q0 q00 = b0.b0;
                        if(q00 != null) {
                            q00.invalidate();
                        }
                    }
                }
                v0.n = b0;
                b0.m = v0;
                v0 = b0;
            }
        }
        I i1 = i0.u();
        v0.n = i1 == null ? null : ((v)i1.b0.c);
        this.d = v0;
    }

    public static void l(o o0, o o1, r0.p p0) {
        if(o0 instanceof a0 && o1 instanceof a0) {
            q.e(p0, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
            ((a0)o1).update(p0);
            if(p0.isAttached()) {
                k0.d(p0);
                return;
            }
            p0.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
            return;
        }
        if(p0 instanceof c) {
            if(((c)p0).isAttached()) {
                ((c)p0).n0();
            }
            ((c)p0).a = o1;
            ((c)p0).setKindSet$ui_release(k0.e(o1));
            if(((c)p0).isAttached()) {
                ((c)p0).m0(false);
            }
            if(p0.isAttached()) {
                k0.d(p0);
                return;
            }
            p0.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
            return;
        }
        M0.a.b("Unknown Modifier.Node type");
    }

    @Override
    public String toString() {
        if(this.a != 0) {
            return super.toString();
        }
        StringBuilder stringBuilder0 = new StringBuilder("[");
        r0.p p0 = (r0.p)this.f;
        A0 a00 = (A0)this.e;
        if(p0 == a00) {
            stringBuilder0.append("]");
        }
        else {
            while(p0 != null && p0 != a00) {
                stringBuilder0.append(String.valueOf(p0));
                if(p0.getChild$ui_release() == a00) {
                    stringBuilder0.append("]");
                    break;
                }
                stringBuilder0.append(",");
                p0 = p0.getChild$ui_release();
            }
        }
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }
}

