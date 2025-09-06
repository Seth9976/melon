package V4;

import A1.f;
import Ac.X3;
import Cc.N1;
import Cc.e0;
import Cc.h0;
import D2.K;
import D2.U0;
import D2.o0;
import D2.v;
import D4.n;
import D4.q;
import De.I;
import Df.l;
import G4.a;
import G4.c;
import Ge.p0;
import Ge.q0;
import Ge.s0;
import I.L;
import J0.H;
import J2.o;
import M.y;
import N0.M;
import Nc.A;
import Nc.D;
import Nc.Y;
import Nc.o1;
import Nc.p1;
import P0.h;
import P0.i;
import U.J0;
import U.f0;
import U4.F;
import Vc.E;
import Vc.r;
import Y.Q;
import Y.S;
import a1.t;
import ad.T;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.os.Trace;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.RemoteViews;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkMigration9To10;
import bd.d;
import cd.r2;
import cd.s2;
import com.iloen.melon.custom.l1;
import com.iloen.melon.player.trackzero.SinglePlayer;
import df.j;
import e.k;
import e1.x;
import i.n.i.b.a.s.e.M3;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import je.p;
import ke.b;
import qf.e;
import r0.g;

public abstract class u {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static long f;
    public static Method g;
    public static Method h;
    public static Method i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;

    public static final List A(c c0) {
        int v = F.l(c0, "id");
        int v1 = F.l(c0, "seq");
        int v2 = F.l(c0, "from");
        int v3 = F.l(c0, "to");
        b b0 = k.l();
        while(c0.j0()) {
            b0.add(new n(((int)c0.getLong(v)), ((int)c0.getLong(v1)), c0.S(v2), c0.S(v3)));
        }
        return p.I0(k.h(b0));
    }

    public static final q B(a a0, String s, boolean z) {
        q q0;
        c c0 = a0.l0("PRAGMA index_xinfo(`" + s + "`)");
        try {
            int v = F.l(c0, "seqno");
            int v1 = F.l(c0, "cid");
            int v2 = F.l(c0, "name");
            int v3 = F.l(c0, "desc");
            if(v != -1 && v1 != -1 && v2 != -1 && v3 != -1) {
                LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                LinkedHashMap linkedHashMap1 = new LinkedHashMap();
                while(c0.j0()) {
                    if(((int)c0.getLong(v1)) >= 0) {
                        int v4 = (int)c0.getLong(v);
                        String s1 = c0.S(v2);
                        String s2 = c0.getLong(v3) <= 0L ? "ASC" : "DESC";
                        linkedHashMap0.put(v4, s1);
                        linkedHashMap1.put(v4, s2);
                    }
                }
                Iterable iterable0 = p.J0(linkedHashMap0.entrySet(), new f(1));
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
                for(Object object0: iterable0) {
                    arrayList0.add(((String)((Map.Entry)object0).getValue()));
                }
                List list0 = p.P0(arrayList0);
                Iterable iterable1 = p.J0(linkedHashMap1.entrySet(), new f(2));
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, iterable1));
                for(Object object1: iterable1) {
                    arrayList1.add(((String)((Map.Entry)object1).getValue()));
                }
                q0 = new q(s, z, list0, p.P0(arrayList1));
                goto label_38;
            }
            goto label_40;
        }
        catch(Throwable throwable0) {
        }
        try {
            throw throwable0;
        }
        catch(Throwable throwable1) {
            x.y(c0, throwable0);
            throw throwable1;
        }
    label_38:
        x.y(c0, null);
        return q0;
    label_40:
        x.y(c0, null);
        return null;
    }

    public static LinkedHashSet C(e e0, Collection collection0, Collection collection1, Me.e e1, l l0, tf.k k0, boolean z) {
        if(e0 != null) {
            if(collection0 != null) {
                if(e1 != null) {
                    if(l0 != null) {
                        if(k0 != null) {
                            LinkedHashSet linkedHashSet0 = new LinkedHashSet();
                            k0.h(e0, collection0, collection1, e1, new af.a(l0, linkedHashSet0, z));
                            return linkedHashSet0;
                        }
                        u.a(17);
                        throw null;
                    }
                    u.a(16);
                    throw null;
                }
                u.a(15);
                throw null;
            }
            u.a(13);
            throw null;
        }
        u.a(12);
        throw null;
    }

    public static LinkedHashSet D(e e0, AbstractCollection abstractCollection0, Collection collection0, Me.e e1, l l0, tf.k k0) {
        if(e0 != null) {
            if(e1 != null) {
                if(l0 != null) {
                    if(k0 != null) {
                        return u.C(e0, abstractCollection0, collection0, e1, l0, k0, false);
                    }
                    u.a(5);
                    throw null;
                }
                u.a(4);
                throw null;
            }
            u.a(3);
            throw null;
        }
        u.a(0);
        throw null;
    }

    public static LinkedHashSet E(e e0, Collection collection0, AbstractCollection abstractCollection0, j j0, l l0, tf.k k0) {
        if(e0 != null) {
            if(collection0 != null) {
                if(j0 != null) {
                    if(l0 != null) {
                        if(k0 != null) {
                            return u.C(e0, collection0, abstractCollection0, j0, l0, k0, true);
                        }
                        u.a(11);
                        throw null;
                    }
                    u.a(10);
                    throw null;
                }
                u.a(9);
                throw null;
            }
            u.a(7);
            throw null;
        }
        u.a(6);
        throw null;
    }

    public static final void F(RecyclerView recyclerView0) {
        int v = recyclerView0.getContext().getResources().getDimensionPixelSize(0x7F070057);  // dimen:bottom_tab_height
        int v1 = recyclerView0.getContext().getResources().getDimensionPixelSize(0x7F070315);  // dimen:mini_player_height
        recyclerView0.setPadding(0, recyclerView0.getPaddingTop(), 0, v1 + v);
        recyclerView0.setClipToPadding(false);
    }

    public static final B2.n G(float f) {
        return u.w(u.J(B2.l.a, f), f);
    }

    public static String H(String s) [...] // 潜在的解密器

    public static final Class I(ClassLoader classLoader0, String s) {
        kotlin.jvm.internal.q.g(s, "fqName");
        try {
            return Class.forName(s, false, classLoader0);
        }
        catch(ClassNotFoundException unused_ex) {
            return null;
        }
    }

    public static final B2.n J(B2.n n0, float f) {
        return n0.b(new J2.u(new O2.b(f)));
    }

    public abstract void K(byte[] arg1, int arg2, int arg3);

    public static void a(int v) {
        Object[] arr_object = new Object[(v == 18 ? 2 : 3)];
        switch(v) {
            case 1: 
            case 7: 
            case 13: {
                arr_object[0] = "membersFromSupertypes";
                break;
            }
            case 2: 
            case 8: 
            case 14: {
                arr_object[0] = "membersFromCurrent";
                break;
            }
            case 3: 
            case 9: 
            case 15: {
                arr_object[0] = "classDescriptor";
                break;
            }
            case 4: 
            case 10: 
            case 16: {
                arr_object[0] = "errorReporter";
                break;
            }
            case 5: 
            case 11: 
            case 17: {
                arr_object[0] = "overridingUtil";
                break;
            }
            case 18: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            }
            case 20: {
                arr_object[0] = "annotationClass";
                break;
            }
            default: {
                arr_object[0] = "name";
            }
        }
        arr_object[1] = v == 18 ? "resolveOverrides" : "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        switch(v) {
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                arr_object[2] = "resolveOverridesForStaticMembers";
                break;
            }
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: {
                arr_object[2] = "resolveOverrides";
                break;
            }
            case 18: {
                break;
            }
            case 19: 
            case 20: {
                arr_object[2] = "getAnnotationParameterByName";
                break;
            }
            default: {
                arr_object[2] = "resolveOverridesForNonStaticMembers";
            }
        }
        String s = String.format((v == 18 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalArgumentException illegalArgumentException0 = v == 18 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalArgumentException0;
    }

    public static final void b(String s, String s1, float f, float f1, String s2, long v, we.a a0, we.k k0, androidx.compose.runtime.l l0, int v1) {
        d d0;
        b0 b04;
        int v7;
        int v6;
        r0.n n1;
        Context context1;
        T t0;
        r0.q q1;
        SinglePlayer singlePlayer1;
        int v4;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x2028314F);
        int v2 = v1 | (p0.g(s) ? 4 : 2) | (p0.g(s1) ? 0x20 : 16) | (p0.d(f) ? 0x100 : 0x80) | (p0.d(f1) ? 0x800 : 0x400) | (p0.g(s2) ? 0x4000 : 0x2000) | (p0.f(v) ? 0x20000 : 0x10000) | (p0.i(a0) ? 0x100000 : 0x80000) | 0xC00000 | (p0.i(k0) ? 0x4000000 : 0x2000000);
        if(p0.Q(v2 & 1, (v2 & 0x2492493) != 0x2492492)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            b0 b00 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(b00 == v3) {
                b00 = w.s(null);
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v3) {
                b01 = w.s(Boolean.TRUE);
                p0.l0(b01);
            }
            b0 b02 = p0.N();
            if(b02 == v3) {
                b02 = w.s(Boolean.FALSE);
                p0.l0(b02);
            }
            b0 b03 = p0.N();
            if(b03 == v3) {
                b03 = U4.x.d(0x7FFFFFFF, p0);
            }
            SinglePlayer singlePlayer0 = p0.N();
            if(singlePlayer0 == v3) {
                singlePlayer0 = new SinglePlayer(context0);
                p0.l0(singlePlayer0);
            }
            Lc.c c0 = new Lc.c(15, a0);
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(n0, c0);
            boolean z = p0.i(context0);
            boolean z1 = p0.i(singlePlayer0);
            Object object0 = p0.N();
            if(((v2 & 14) == 4 | z | z1 | ((v2 & 0xE000000) == 0x4000000 ? 1 : 0)) != 0 || object0 == v3) {
                q1 = q0;
                v4 = v2 & 14;
                n1 = n0;
                t0 = new T(s, context0, singlePlayer0, k0, b03, b01, b02, 1);
                context1 = context0;
                singlePlayer1 = singlePlayer0;
                p0.l0(t0);
            }
            else {
                v4 = v2 & 14;
                singlePlayer1 = singlePlayer0;
                q1 = q0;
                t0 = object0;
                context1 = context0;
                n1 = n0;
            }
            r0.q q2 = androidx.compose.ui.layout.a.d(q1, t0);
            M m0 = M.p.d(r0.d.a, false);
            int v5 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h0);
            }
            w.x(p0, q3, P0.j.d);
            r0.q q4 = androidx.compose.foundation.layout.d.o(n1, f, f1);
            boolean z2 = p0.i(singlePlayer1);
            E e0 = p0.N();
            if(z2 || e0 == v3) {
                e0 = new E(singlePlayer1, 1);
                p0.l0(e0);
            }
            androidx.compose.ui.viewinterop.a.a(e0, q4, null, p0, 0, 4);
            if(((Boolean)b02.getValue()).booleanValue()) {
                v6 = 0;
                v7 = v4;
                b04 = b00;
                p0.a0(-2057031539);
            }
            else {
                p0.a0(0x85A213F9);
                r0.q q5 = androidx.compose.foundation.layout.d.o(n1, f, f1);
                v6 = 0;
                v7 = v4;
                b04 = b00;
                androidx.compose.foundation.q.c(L5.c.a(((Drawable)b00.getValue()), p0), "", q5, null, N0.j.b, 0.0f, null, p0, 0x6030, 104);
            }
            p0.p(false);
            p0.p(true);
            boolean z3 = p0.i(context1);
            bd.c c1 = p0.N();
            if((v2 & 0x70) == 0x20 || z3 || c1 == v3) {
                c1 = new bd.c(context1, s1, b04, null);
                p0.l0(c1);
            }
            J.d(p0, s1, c1);
            boolean z4 = p0.i(singlePlayer1);
            if((v2 & 0x70000) == 0x20000) {
                v6 = 1;
            }
            Object object1 = p0.N();
            if((z4 | (v2 & 0xE000) == 0x4000 | (v7 == 4 ? 1 : 0) | v6) != 0 || object1 == v3) {
                d0 = new d(singlePlayer1, s2, s, v, null);
                p0.l0(d0);
            }
            else {
                d0 = object1;
            }
            J.d(p0, s, d0);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new bd.a(s, s1, f, f1, s2, v, a0, k0, v1);
        }
    }

    public static final void c(r0.q q0, A a0, androidx.compose.runtime.l l0, int v) {
        kotlin.jvm.internal.q.g(a0, "uiState");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x4979DA27);
        int v1 = (p0.i(a0) ? 0x20 : 16) | v;
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            g g0 = r0.d.m;
            y y0 = M.w.a(M.j.c, g0, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            w.x(p0, y0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q1, h3);
            r0.n n0 = r0.n.a;
            a.a.e(androidx.compose.foundation.layout.a.l(n0, 16.0f, 0.0f, 2), a0.a, p0, 6);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 11.0f));
            r0.q q2 = androidx.compose.foundation.layout.a.l(n0, 16.0f, 0.0f, 2);
            y y1 = M.w.a(M.j.h(8.0f), g0, p0, 6);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q3, h3);
            p0.a0(0x55D27AB9);
            for(Object object0: p.K0(2, a0.b)) {
                D.a(n0, ((Nc.E)object0), p0, 6);
            }
            A7.d.s(p0, false, true, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Gd.p(q0, a0, v, 26);
        }
    }

    public static final void d(r0.q q0, p1 p10, androidx.compose.runtime.l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x1CCBF04F);
        int v1 = (p0.g(q0) ? 4 : 2) | v | (p0.g(p10) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q1 = r0.a.a(q0, new o1(p10, 0));
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            w.x(p0, y0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q2, h3);
            if(p10 == null) {
                p0.a0(0x7DA04FC0);
            }
            else {
                p0.a0(0x7DA04FC1);
                r0.n n0 = r0.n.a;
                r0.q q3 = androidx.compose.foundation.layout.a.d(1.0f, n0, false);
                M m0 = M.p.d(r0.d.a, false);
                int v3 = p0.P;
                i0 i01 = p0.m();
                r0.q q4 = r0.a.d(p0, q3);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m0, h0);
                w.x(p0, i01, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h2);
                }
                w.x(p0, q4, h3);
                com.google.firebase.b.f(6, p0, p10.b, androidx.compose.foundation.layout.d.c);
                r0.q q5 = androidx.compose.foundation.layout.d.n(androidx.compose.foundation.layout.a.n(n0, 0.0f, 6.0f, 6.0f, 0.0f, 9), 24.0f);
                r0.q q6 = r0.a.a((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, r0.d.c), new o1(p10, 1));
                j5.n.b(0x7F080309, H0.e.Y(p0, 0x7F130BB4), q6, null, null, null, p0, 6, 0xFF8);  // drawable:common_btn_play_01
                l1.y(p0, true, n0, 6.0f, p0);
                long v4 = e0.T(p0, 0x7F06016D);  // color:gray900s
                N1.b(p10.a, null, v4, 15.0f, null, null, 0L, null, 22.0f, 2, false, 2, 0, null, null, p0, 0xC00, 0xC36, 0x1D3F2);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Y(q0, p10, v, 10);
        }
    }

    public static final void e(r r0, androidx.compose.runtime.l l0, int v) {
        String s3;
        String s2;
        kotlin.jvm.internal.q.g(r0, "uiState");
        String s = r0.a;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x7248A03A);
        int v1 = v | (p0.g(r0) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            if(s.length() > 0) {
                if(s.length() > 10) {
                    String s1 = s.substring(0, 10);
                    kotlin.jvm.internal.q.f(s1, "substring(...)");
                    s2 = s1 + "...";
                }
                else {
                    s2 = s;
                }
                s3 = String.format("", Arrays.copyOf(new Object[]{s2}, 1));
            }
            else {
                s3 = "";
            }
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 190.0f);
            r0.i i0 = r0.d.a;
            M m0 = M.p.d(i0, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            w.x(p0, m0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q1, h3);
            r0.q q2 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.q.f(e0.M(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.c, 20.0f, 0.0f, 2), 0x7F06048A, 8.0f), e0.T(p0, 0x7F06013E), y0.M.a), 0.0f, 22.0f, 1);  // color:transparent
            y y0 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q3, h3);
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            y y1 = M.w.a(M.j.e, r0.d.m, p0, 6);
            int v4 = p0.P;
            i0 i02 = p0.m();
            r0.q q4 = r0.a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q4, h3);
            N1.b(s3, null, e0.T(p0, 0x7F06016D), 16.0f, null, null, 0L, new l1.k(3), 22.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F2);  // color:gray900s
            A7.d.v(n0, 2.0f, p0, true);
            r0.q q5 = r0.a.a(androidx.compose.foundation.layout.a.k(e0.M(n0, 0x7F060154, 100.0f), 20.0f, 10.0f), new Vc.q(r0, 1));  // color:gray200s_support_high_contrast
            M m1 = M.p.d(i0, false);
            int v5 = p0.P;
            i0 i03 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i03, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q6, h3);
            N1.b("", null, e0.T(p0, 0x7F06016D), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray900s
            p0.p(true);
            p0.p(true);
            if(s.length() > 0) {
                p0.a0(0x6F2893DB);
                long v6 = e0.T(p0, 0x7F06015D);  // color:gray500s_support_high_contrast
                r0.q q7 = androidx.compose.foundation.layout.a.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.c), 0.0f, 12.0f, 32.0f, 0.0f, 9);
                boolean z = p0.f(v6);
                h0 h00 = p0.N();
                if(z || h00 == androidx.compose.runtime.k.a) {
                    h00 = new h0(v6, 15);
                    p0.l0(h00);
                }
                N1.b("", r0.a.a(androidx.compose.ui.draw.a.c(q7, h00), new Vc.q(r0, 0)), v6, 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
            }
            else {
                p0.a0(0x6EF303CE);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.a(r0, v, 25);
        }
    }

    public static final void f(boolean z, l1.j j0, Q q0, androidx.compose.runtime.l l0, int v) {
        float f;
        ((androidx.compose.runtime.p)l0).c0(0xAFDBA8B8);
        int v1 = (v & 6) == 0 ? (((androidx.compose.runtime.p)l0).h(z) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).g(j0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).i(q0) ? 0x100 : 0x80);
        }
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            boolean z1 = ((androidx.compose.runtime.p)l0).g(q0);
            Y.J j1 = ((androidx.compose.runtime.p)l0).N();
            V v2 = androidx.compose.runtime.k.a;
            if((v1 & 14) == 4 || z1 || j1 == v2) {
                j1 = new Y.J(q0, z);
                ((androidx.compose.runtime.p)l0).l0(j1);
            }
            boolean z2 = ((androidx.compose.runtime.p)l0).i(q0);
            S s0 = ((androidx.compose.runtime.p)l0).N();
            if((v1 & 14) == 4 || z2 || s0 == v2) {
                s0 = new S(q0, z);
                ((androidx.compose.runtime.p)l0).l0(s0);
            }
            boolean z3 = a1.T.f(q0.m().b);
            long v3 = z ? q0.m().b >> 0x20 : q0.m().b & 0xFFFFFFFFL;
            f0 f00 = q0.d;
            if(f00 == null) {
                f = 0.0f;
            }
            else {
                J0 j00 = f00.d();
                if(j00 == null) {
                    f = 0.0f;
                }
                else {
                    a1.Q q1 = j00.a;
                    if(((int)v3) >= 0) {
                        a1.y y0 = q1.b;
                        if(q1.a.a.b.length() == 0) {
                            f = 0.0f;
                        }
                        else {
                            int v4 = Math.min(y0.d(((int)v3)), Math.min(y0.b - 1, y0.f - 1));
                            if(((int)v3) <= y0.c(v4, false)) {
                                y0.m(v4);
                                int v5 = t.e(v4, y0.h);
                                a1.A a0 = (a1.A)y0.h.get(v5);
                                int v6 = v4 - a0.d;
                                f = a0.a.d.e(v6) - a0.a.d.g(v6);
                            }
                            else {
                                f = 0.0f;
                            }
                        }
                    }
                    else {
                        f = 0.0f;
                    }
                }
            }
            boolean z4 = ((androidx.compose.runtime.p)l0).i(j1);
            L l1 = ((androidx.compose.runtime.p)l0).N();
            if(z4 || l1 == v2) {
                l1 = new L(j1, 3);
                ((androidx.compose.runtime.p)l0).l0(l1);
            }
            I.j(s0, z, j0, z3, 0L, f, H.a(r0.n.a, j1, l1), ((androidx.compose.runtime.p)l0), v1 << 3 & 0x3F0);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new Y.f(z, j0, q0, v);
        }
    }

    public static final void g(s2 s20, androidx.compose.runtime.l l0, int v) {
        kotlin.jvm.internal.q.g(s20, "uiState");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x93515D2C);
        int v1 = (p0.g(s20) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 49.0f), new r2());  // 初始化器: Ljava/lang/Object;-><init>()V
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            r0.q q2 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.j(n0, 49.0f, 0.0f, 2), 2), 20.0f, 0.0f, 2);
            long v3 = e0.T(p0, 0x7F06016D);  // color:gray900s
            long v4 = e0.T(p0, 0x7F06016D);  // color:gray900s
            Cc.E.a(q2, s20.a, s20.b, "<b>REPLACETEXT</b>", 0, 28.0f, v3, v4, e1.y.i, 1, 0, e1.y.i, 0.0f, null, "TitleSlot", p0, 0x36030C06, 0x30030, 0x7410);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Zc.c(s20, v, 26);
        }
    }

    public static final int h(int v, int v1, int v2, boolean z) {
        if(v1 >= v2) {
            return z ? 0 : v2 - v1;
        }
        if(!z) {
            if(v1 <= v) {
                return v - v1;
            }
        }
        else if(v2 - v1 > v) {
            return v;
        }
        if(z) {
            if(v1 <= v) {
                return v - v1;
            }
        }
        else if(v2 - v1 > v) {
            return v;
        }
        return z ? v2 - v1 : 0;
    }

    public static final void i(U0 u00, RemoteViews remoteViews0, B2.n n0, o0 o00) {
        boolean z3;
        boolean z2;
        int v3;
        Context context0 = u00.a;
        kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        kotlin.jvm.internal.H h1 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        kotlin.jvm.internal.H h2 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        kotlin.jvm.internal.H h3 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        kotlin.jvm.internal.H h4 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        h4.a = B2.u.a;
        kotlin.jvm.internal.H h5 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        kotlin.jvm.internal.H h6 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        kotlin.jvm.internal.H h7 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        kotlin.jvm.internal.H h8 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        v v0 = new v(h5, h0, h1, u00.a, remoteViews0, o00, h2, h4, h3, u00, h7, h6, h8);
        n0.foldIn(ie.H.a, v0);
        J2.u u0 = (J2.u)h0.a;
        o o0 = (o)h1.a;
        int v1 = o00.a;
        int v2 = 0;
        if(o00.b == -1) {
            if(u0 != null) {
                u.k(remoteViews0, u0, v1);
            }
            if(o0 == null) {
                goto label_66;
            }
            u.j(remoteViews0, o0, v1);
        }
        else if(Build.VERSION.SDK_INT < 0x1F) {
            O2.f f0 = u0 == null ? null : u0.a;
            O2.f f1 = o0 == null ? null : o0.a;
            if(u.y(f0) || u.y(f1)) {
                boolean z = f0 instanceof O2.d || f0 instanceof O2.c;
                boolean z1 = f1 instanceof O2.d || f1 instanceof O2.c;
                if(z && z1) {
                    v3 = 0x7F0D0845;  // layout:size_match_match
                }
                else if(z) {
                    v3 = 0x7F0D0846;  // layout:size_match_wrap
                }
                else {
                    v3 = z1 ? 0x7F0D0847 : 0x7F0D0848;  // layout:size_wrap_match
                }
                int v4 = B.a.R(remoteViews0, u00, 0x7F0A0A8F, v3, null);  // id:sizeViewStub
                O2.e e0 = O2.e.a;
                O2.d d0 = O2.d.a;
                O2.c c0 = O2.c.a;
                if(f0 instanceof O2.b) {
                    DisplayMetrics displayMetrics0 = context0.getResources().getDisplayMetrics();
                    remoteViews0.setInt(v4, "setWidth", ((int)TypedValue.applyDimension(1, ((O2.b)f0).a, displayMetrics0)));
                }
                else {
                    if(((kotlin.jvm.internal.q.b(f0, c0) ? true : kotlin.jvm.internal.q.b(f0, d0)) ? true : kotlin.jvm.internal.q.b(f0, e0))) {
                        z2 = true;
                    }
                    else if(f0 != null) {
                        z2 = false;
                    }
                    else {
                        z2 = true;
                    }
                    if(!z2) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                if(f1 instanceof O2.b) {
                    DisplayMetrics displayMetrics1 = context0.getResources().getDisplayMetrics();
                    remoteViews0.setInt(v4, "setHeight", ((int)TypedValue.applyDimension(1, ((O2.b)f1).a, displayMetrics1)));
                }
                else {
                    if(((kotlin.jvm.internal.q.b(f1, c0) ? true : kotlin.jvm.internal.q.b(f1, d0)) ? true : kotlin.jvm.internal.q.b(f1, e0))) {
                        z3 = true;
                    }
                    else if(f1 != null) {
                        z3 = false;
                    }
                    else {
                        z3 = true;
                    }
                    if(!z3) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
        }
        else {
            throw new IllegalStateException("There is currently no valid use case where a complex view is used on Android S");
        }
    label_66:
        C2.b b0 = (C2.b)h5.a;
        if(b0 != null) {
            C2.a a0 = b0.a;
            int v5 = u00.m == null ? v1 : ((int)u00.m);
            try {
                if(u00.f) {
                    remoteViews0.setOnClickFillInIntent(v5, E2.k.e(a0, u00, v5, E2.e.g));
                }
                else {
                    remoteViews0.setOnClickPendingIntent(v5, E2.k.f(a0, u00, v5, E2.e.h));
                }
                goto label_77;
            }
            catch(Throwable throwable0) {
            }
            Log.e("GlanceAppWidget", "Unrecognized Action: " + a0, throwable0);
        }
    label_77:
        O2.f f2 = (O2.f)h3.a;
        if(f2 != null) {
            if(Build.VERSION.SDK_INT >= 0x1F) {
                D2.u.a.a(remoteViews0, v1, f2);
            }
            else {
                Log.w("GlanceAppWidget", "Cannot set the rounded corner of views before Api 31.");
            }
        }
        J2.q q0 = (J2.q)h2.a;
        if(q0 != null) {
            Resources resources0 = context0.getResources();
            float f3 = Q1.c.k(q0.a.b, resources0) + q0.a.a;
            float f4 = Q1.c.k(q0.b.b, resources0) + q0.b.a;
            float f5 = Q1.c.k(q0.c.b, resources0) + q0.c.a;
            float f6 = Q1.c.k(q0.d.b, resources0) + q0.d.a;
            float f7 = Q1.c.k(q0.e.b, resources0) + q0.e.a;
            float f8 = Q1.c.k(q0.f.b, resources0) + q0.f.a;
            float f9 = u00.c ? f7 : f4;
            if(!u00.c) {
                f4 = f7;
            }
            DisplayMetrics displayMetrics2 = context0.getResources().getDisplayMetrics();
            int v6 = (int)TypedValue.applyDimension(1, f3 + f9, displayMetrics2);
            int v7 = (int)TypedValue.applyDimension(1, f5, displayMetrics2);
            int v8 = (int)TypedValue.applyDimension(1, f6 + f4, displayMetrics2);
            int v9 = (int)TypedValue.applyDimension(1, f8, displayMetrics2);
            remoteViews0.setViewPadding(o00.a, v6, v7, v8, v9);
        }
        if(h7.a != null) {
            throw new ClassCastException();
        }
        K k0 = (K)h6.a;
        K2.b b1 = (K2.b)h8.a;
        if(b1 != null) {
            Object object0 = b1.a.a.get(K2.c.a);
            Object object1 = object0 == null ? null : object0;
            if(((List)object1) != null) {
                remoteViews0.setContentDescription(v1, p.q0(((List)object1), null, null, null, null, 0x3F));
            }
        }
        switch(((B2.u)h4.a).ordinal()) {
            case 0: {
                break;
            }
            case 1: {
                v2 = 4;
                break;
            }
            case 2: {
                v2 = 8;
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        remoteViews0.setViewVisibility(v1, v2);
    }

    public static final void j(RemoteViews remoteViews0, o o0, int v) {
        O2.f f0 = o0.a;
        int v1 = Build.VERSION.SDK_INT;
        O2.c c0 = O2.c.a;
        O2.e e0 = O2.e.a;
        if(v1 < 0x1F) {
            if(!k.A(new O2.f[]{e0, O2.d.a, c0}).contains(f0)) {
                throw new IllegalArgumentException("Using a height of " + f0 + " requires a complex layout before API 31");
            }
            return;
        }
        if(v1 < 33 && k.A(new O2.f[]{e0, c0}).contains(f0)) {
            return;
        }
        D2.u.a.b(remoteViews0, v, f0);
    }

    public static final void k(RemoteViews remoteViews0, J2.u u0, int v) {
        O2.f f0 = u0.a;
        int v1 = Build.VERSION.SDK_INT;
        O2.c c0 = O2.c.a;
        O2.e e0 = O2.e.a;
        if(v1 < 0x1F) {
            if(!k.A(new O2.f[]{e0, O2.d.a, c0}).contains(f0)) {
                throw new IllegalArgumentException("Using a width of " + f0 + " requires a complex layout before API 31");
            }
            return;
        }
        if(v1 < 33 && k.A(new O2.f[]{e0, c0}).contains(f0)) {
            return;
        }
        D2.u.a.c(remoteViews0, v, f0);
    }

    public static int l(Context context0, String s) {
        int v4;
        int v = Process.myPid();
        int v1 = Process.myUid();
        if(context0.checkPermission(s, v, v1) != -1) {
            String s1 = AppOpsManager.permissionToOp(s);
            if(s1 != null) {
                int v2 = Process.myUid();
                Class class0 = AppOpsManager.class;
                if(v2 != v1 || !Objects.equals("com.iloen.melon", "com.iloen.melon")) {
                    v4 = ((AppOpsManager)context0.getSystemService(class0)).noteProxyOpNoThrow(s1, "com.iloen.melon");
                }
                else {
                    if(Build.VERSION.SDK_INT < 29) {
                        return ((AppOpsManager)context0.getSystemService(class0)).noteProxyOpNoThrow(s1, "com.iloen.melon") == 0 ? 0 : -2;
                    }
                    AppOpsManager appOpsManager0 = (AppOpsManager)context0.getSystemService(class0);
                    int v3 = 1;
                    v4 = appOpsManager0 == null ? 1 : appOpsManager0.checkOpNoThrow(s1, Binder.getCallingUid(), "com.iloen.melon");
                    if(v4 == 0) {
                        String s2 = N1.f.a(context0);
                        if(appOpsManager0 != null) {
                            v3 = appOpsManager0.checkOpNoThrow(s1, v1, s2);
                        }
                        return v3 == 0 ? 0 : -2;
                    }
                }
                return v4 == 0 ? 0 : -2;
            }
            return 0;
        }
        return -1;
    }

    public static final s m(Context context0, U4.a a0) {
        androidx.room.A a2;
        kotlin.jvm.internal.q.g(context0, "context");
        f5.a a1 = new f5.a(a0.c);
        Context context1 = context0.getApplicationContext();
        kotlin.jvm.internal.q.f(context1, "context.applicationContext");
        androidx.room.Q q0 = a1.a;
        kotlin.jvm.internal.q.f(q0, "workTaskExecutor.serialTaskExecutor");
        U4.k k0 = a0.d;
        boolean z = context0.getResources().getBoolean(0x7F050010);  // bool:workmanager_test_configuration
        kotlin.jvm.internal.q.g(k0, "clock");
        Class class0 = WorkDatabase.class;
        if(z) {
            a2 = new androidx.room.A(context1, class0, null);
            a2.i = true;
        }
        else {
            a2 = E9.w.o(context1, class0, "androidx.work.workdb");
            a2.h = new X3(context1, 12);
        }
        a2.f = q0;
        V4.a a3 = new V4.a(k0);
        a2.d.add(a3);
        a2.a(new B4.a[]{V4.d.f});
        a2.a(new B4.a[]{new V4.g(context1, 2, 3)});
        a2.a(new B4.a[]{V4.d.g});
        a2.a(new B4.a[]{V4.d.h});
        a2.a(new B4.a[]{new V4.g(context1, 5, 6)});
        a2.a(new B4.a[]{V4.d.i});
        a2.a(new B4.a[]{V4.d.j});
        a2.a(new B4.a[]{V4.d.k});
        a2.a(new B4.a[]{new WorkMigration9To10(context1)});
        a2.a(new B4.a[]{new V4.g(context1, 10, 11)});
        a2.a(new B4.a[]{V4.d.b});
        a2.a(new B4.a[]{V4.d.c});
        a2.a(new B4.a[]{V4.d.d});
        a2.a(new B4.a[]{V4.d.e});
        a2.a(new B4.a[]{new V4.g(context1, 21, 22)});
        a2.p = false;
        a2.q = true;
        androidx.room.H h0 = a2.b();
        Context context2 = context0.getApplicationContext();
        kotlin.jvm.internal.q.f(context2, "context.applicationContext");
        b5.j j0 = new b5.j(context2, a1);
        V4.f f0 = new V4.f(context0.getApplicationContext(), a0, a1, ((WorkDatabase)h0));
        List list0 = (List)V4.t.b.c(context0, a0, a1, ((WorkDatabase)h0), j0, f0);
        return new s(context0.getApplicationContext(), a0, a1, ((WorkDatabase)h0), list0, f0, j0);
    }

    public static final B2.n n(B2.n n0) {
        return u.o(n0).b(new o(O2.d.a));
    }

    public static final B2.n o(B2.n n0) {
        return n0.b(new J2.u(O2.d.a));
    }

    public static Pe.S p(e e0, Me.e e1) {
        if(e0 != null) {
            if(e1 != null) {
                Collection collection0 = e1.s();
                if(collection0.size() != 1) {
                    return null;
                }
                Object object0 = collection0.iterator().next();
                for(Object object1: ((Pe.i)object0).F()) {
                    Pe.S s0 = (Pe.S)object1;
                    if(s0.getName().equals(e0)) {
                        return s0;
                    }
                    if(false) {
                        break;
                    }
                }
                return null;
            }
            u.a(20);
            throw null;
        }
        u.a(19);
        throw null;
    }

    public static final De.d q(De.e e0) {
        Me.e e1;
        if(e0 instanceof De.d) {
            return (De.d)e0;
        }
        if(!(e0 instanceof De.y)) {
            throw new s0("Cannot calculate JVM erasure for type: " + e0);
        }
        De.w w0 = q0.d[0];
        Object object0 = ((q0)(((De.y)e0))).b.invoke();
        kotlin.jvm.internal.q.f(object0, "getValue(...)");
        Iterator iterator0 = ((List)object0).iterator();
        while(true) {
            e1 = null;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object1 = iterator0.next();
            kotlin.jvm.internal.q.e(((De.x)object1), "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            Me.h h0 = ((p0)(((De.x)object1))).a.w().e();
            if(h0 instanceof Me.e) {
                e1 = (Me.e)h0;
            }
            if(e1 != null && e1.getKind() != Me.f.b && e1.getKind() != Me.f.e) {
                e1 = object1;
                break;
            }
        }
        De.x x0 = (De.x)e1;
        if(x0 == null) {
            x0 = (De.x)p.m0(((List)object0));
        }
        return x0 == null ? kotlin.jvm.internal.I.a.b(Object.class) : u.r(x0);
    }

    public static final De.d r(De.x x0) {
        De.e e0 = x0.d();
        if(e0 == null) {
            throw new s0("Cannot calculate JVM erasure for type: " + x0);
        }
        return u.q(e0);
    }

    public static SharedPreferences s(Context context0) {
        Context context1 = context0.getApplicationContext();
        if(context1 != null) {
            context0 = context1;
        }
        return context0.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    public static final Bundle t(Bundle bundle0, String s) {
        kotlin.jvm.internal.q.g(s, "key");
        Bundle bundle1 = bundle0.getBundle(s);
        if(bundle1 == null) {
            throw new IllegalArgumentException("No valid saved state was found for the key \'" + s + "\'. It may be missing, null, or not of the expected type. This can occur if the value was saved with a different type or if the saved state was modified unexpectedly.");
        }
        return bundle1;
    }

    public static void u(String s, Exception exception0) {
        if(exception0 instanceof InvocationTargetException) {
            Throwable throwable0 = exception0.getCause();
            throw throwable0 instanceof RuntimeException ? ((RuntimeException)throwable0) : new RuntimeException(throwable0);
        }
        Log.v("Trace", "Unable to call " + s + " via reflection", exception0);
    }

    public static final boolean v(a1.g g0) {
        int v = g0.b.length();
        List list0 = g0.a;
        if(list0 != null) {
            int v1 = list0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                a1.e e0 = (a1.e)list0.get(v2);
                if(e0.a instanceof a1.w && a1.i.b(0, v, e0.b, e0.c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final B2.n w(B2.n n0, float f) {
        return n0.b(new o(new O2.b(f)));
    }

    public static boolean x() {
        if(Build.VERSION.SDK_INT >= 29) {
            return M4.a.c();
        }
        try {
            Class class0 = Trace.class;
            if(u.g == null) {
                u.f = class0.getField("TRACE_TAG_APP").getLong(null);
                u.g = class0.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean)u.g.invoke(null, u.f)).booleanValue();
        }
        catch(Exception exception0) {
        }
        u.u("isTagEnabled", exception0);
        return false;
    }

    public static final boolean y(O2.f f0) {
        if(f0 instanceof O2.b) {
            return true;
        }
        if(!((kotlin.jvm.internal.q.b(f0, O2.c.a) ? true : kotlin.jvm.internal.q.b(f0, O2.d.a)) ? true : kotlin.jvm.internal.q.b(f0, O2.e.a)) && f0 != null) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return false;
    }

    public static final boolean z(Q q0, boolean z) {
        f0 f00 = q0.d;
        if(f00 != null) {
            N0.v v0 = f00.c();
            if(v0 != null) {
                x0.c c0 = Q1.c.a0(v0);
                long v1 = q0.l(z);
                float f = Float.intBitsToFloat(((int)(v1 >> 0x20)));
                if(c0.a <= f && f <= c0.c) {
                    float f1 = Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL)));
                    return c0.b <= f1 && f1 <= c0.d;
                }
            }
        }
        return false;
    }
}

