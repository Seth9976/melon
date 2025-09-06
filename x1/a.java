package x1;

import A0.c;
import Ac.A2;
import Ac.C0;
import Ac.J;
import Ac.R0;
import Af.p;
import B2.l;
import Cc.N1;
import Cc.e0;
import D2.B0;
import D2.G0;
import De.I;
import De.d;
import De.t;
import De.w;
import Ge.B;
import Ge.s;
import Ge.y;
import Hf.x;
import I.u0;
import J2.k;
import J2.o;
import Je.i;
import M.n0;
import M.p0;
import Me.N;
import Me.e;
import Me.f;
import Me.h;
import N0.M;
import Nc.h0;
import Nc.k0;
import Pe.S;
import Q.A;
import Tf.v;
import a1.T;
import a1.g;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.HandwritingGesture;
import androidx.car.app.SessionInfo;
import androidx.collection.L;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.i0;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.ResourceUtilsKt;
import df.F;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.j;
import j3.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import je.u;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import p0.m;
import pc.b;

public abstract class a {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;

    public static final int A(b b0) {
        switch(b0.ordinal()) {
            case 0: {
                return 0x7F080620;  // drawable:img_dj_malang_bg_1
            }
            case 1: {
                return 0x7F080621;  // drawable:img_dj_malang_bg_2
            }
            case 2: {
                return 0x7F080622;  // drawable:img_dj_malang_bg_3
            }
            case 3: {
                return 0x7F080623;  // drawable:img_dj_malang_bg_4
            }
            case 4: {
                return 0x7F080624;  // drawable:img_dj_malang_bg_5
            }
            case 5: {
                return 0x7F080625;  // drawable:img_dj_malang_bg_6
            }
            case 6: {
                return 0x7F080626;  // drawable:img_dj_malang_bg_7
            }
            case 7: {
                return 0x7F080627;  // drawable:img_dj_malang_bg_8
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static final int B(A a0) {
        return a0.e == u0.a ? ((int)(a0.e() & 0xFFFFFFFFL)) : ((int)(a0.e() >> 0x20));
    }

    public static final ArrayList C(d d0) {
        q.g(d0, "<this>");
        Ge.u0 u00 = ((y)((j)((B)d0).c).getValue()).k;
        w w0 = y.m[13];
        Object object0 = u00.invoke();
        q.f(object0, "getValue(...)");
        ArrayList arrayList0 = new ArrayList();
        for(Object object1: ((Collection)object0)) {
            if(((s)object1).n().Q() == null && ((s)object1) instanceof t) {
                arrayList0.add(object1);
            }
        }
        return arrayList0;
    }

    public static final F D(e e0) {
        F f0;
        e e1 = null;
        q.g(e0, "<this>");
        Iterator iterator0 = e0.g().w().f().iterator();
    alab1:
        while(true) {
            while(true) {
                f0 = null;
                if(!iterator0.hasNext()) {
                    break alab1;
                }
                Object object0 = iterator0.next();
                x x0 = (x)object0;
                if(i.y(x0)) {
                    break;
                }
                h h0 = x0.w().e();
                if(!tf.e.m(h0, f.a) && !tf.e.m(h0, f.c)) {
                    break;
                }
                q.e(h0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                e1 = (e)h0;
                break alab1;
            }
        }
        if(e1 == null) {
            return null;
        }
        p p0 = e1.t0();
        if(p0 instanceof F) {
            f0 = (F)p0;
        }
        return f0 == null ? a.D(e1) : f0;
    }

    public static I4.b E(c c0, SQLiteDatabase sQLiteDatabase0) {
        q.g(c0, "refHolder");
        I4.b b0 = (I4.b)c0.b;
        if(b0 != null && b0.a.equals(sQLiteDatabase0)) {
            return b0;
        }
        I4.b b1 = new I4.b(sQLiteDatabase0);
        c0.b = b1;
        return b1;
    }

    public static final Object F(oe.c c0) {
        n n0;
        ReceiveChannel receiveChannel0;
        L2.c c1;
        if(c0 instanceof L2.c) {
            c1 = (L2.c)c0;
            int v = c1.G;
            if((v & 0x80000000) == 0) {
                c1 = new L2.c(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                c1.G = v ^ 0x80000000;
            }
        }
        else {
            c1 = new L2.c(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = c1.E;
        ne.a a0 = ne.a.a;
        switch(c1.G) {
            case 0: {
                d5.n.D(object0);
                receiveChannel0 = ChannelKt.Channel$default(1, null, null, 6, null);
                AtomicBoolean atomicBoolean0 = new AtomicBoolean(false);
                J j0 = new J(27, atomicBoolean0, receiveChannel0);
                synchronized(m.b) {
                    m.h = je.p.z0(j0, ((Collection)m.h));
                }
                m.a();
                n0 = new n(j0, 6);
                try {
                    ChannelIterator channelIterator0 = receiveChannel0.iterator();
                    AtomicBoolean atomicBoolean1 = atomicBoolean0;
                    goto label_49;
                label_28:
                    channelIterator0 = c1.D;
                    receiveChannel0 = c1.B;
                    n0 = c1.w;
                    atomicBoolean1 = c1.r;
                    d5.n.D(object0);
                    while(true) {
                        if(!((Boolean)object0).booleanValue()) {
                            goto label_60;
                        }
                        H h0 = (H)channelIterator0.next();
                        atomicBoolean1.set(false);
                        synchronized(m.b) {
                            L l0 = m.i.h;
                            boolean z = l0 == null || !l0.h() ? false : true;
                        }
                        if(z) {
                            m.a();
                        }
                    label_49:
                        c1.r = atomicBoolean1;
                        c1.w = n0;
                        c1.B = receiveChannel0;
                        c1.D = channelIterator0;
                        c1.G = 1;
                        object0 = channelIterator0.hasNext(c1);
                        if(object0 != a0) {
                            continue;
                        }
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                goto label_28;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            ChannelsKt.cancelConsumed(receiveChannel0, throwable0);
            throw throwable0;
        label_60:
            ChannelsKt.cancelConsumed(receiveChannel0, null);
        }
        catch(Throwable throwable1) {
            n0.d();
            throw throwable1;
        }
        n0.d();
        return H.a;
    }

    public static boolean G(String s) {
        Set set0 = Collections.unmodifiableSet(T4.c.c);
        HashSet hashSet0 = new HashSet();
        for(Object object0: set0) {
            T4.e e0 = (T4.e)object0;
            if(((T4.c)e0).a.equals(s)) {
                hashSet0.add(e0);
            }
        }
        if(hashSet0.isEmpty()) {
            throw new RuntimeException("Unknown feature " + s);
        }
        for(Object object1: hashSet0) {
            if(((T4.c)(((T4.e)object1))).a() || ((T4.c)(((T4.e)object1))).b()) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public static boolean H(Context context0) {
        return ((UserManager)context0.getSystemService(UserManager.class)).isUserUnlocked();
    }

    public static final void I(View view0, Float float0, Float float1, Float float2, Float float3) {
        if(view0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
            if(viewGroup$LayoutParams0 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            if(float0 != null) {
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin = a.s(view0, float0.floatValue());
            }
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = a.s(view0, float1.floatValue());
            if(float2 != null) {
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin = a.s(view0, float2.floatValue());
            }
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).bottomMargin = a.s(view0, float3.floatValue());
        }
    }

    public static final void J(G0 g00) {
        ArrayList arrayList0 = g00.b;
        if(arrayList0.isEmpty()) {
        label_19:
            if(arrayList0.size() != 1) {
                k k1 = new k();
                u.U(k1.b, arrayList0);
                arrayList0.clear();
                arrayList0.add(k1);
            }
        }
        else {
            for(Object object0: arrayList0) {
                if(((B2.i)object0) instanceof D2.J) {
                    continue;
                }
                goto label_19;
            }
            for(Object object1: arrayList0) {
                q.e(((B2.i)object1), "null cannot be cast to non-null type androidx.glance.appwidget.EmittableSizeBox");
                ArrayList arrayList1 = ((D2.J)(((B2.i)object1))).b;
                if(arrayList1.size() != 1) {
                    k k0 = new k();
                    u.U(k0.b, arrayList1);
                    arrayList1.clear();
                    arrayList1.add(k0);
                }
            }
        }
        a.K(g00);
        a.R(g00);
    }

    public static final void K(B2.k k0) {
        ArrayList arrayList0 = k0.b;
        for(Object object0: arrayList0) {
            B2.i i0 = (B2.i)object0;
            if(i0 instanceof B2.k) {
                a.K(((B2.k)i0));
            }
        }
        o o0 = (o)k0.b().foldIn(null, D2.d.T);
        O2.f f0 = O2.e.a;
        if((o0 == null ? f0 : o0.a) instanceof O2.e && !arrayList0.isEmpty()) {
            for(Object object1: arrayList0) {
                o o1 = (o)((B2.i)object1).b().foldIn(null, D2.d.W);
                if((o1 == null ? null : o1.a) instanceof O2.d) {
                    k0.a(k0.b().b(new o(O2.d.a)));
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        J2.u u0 = (J2.u)k0.b().foldIn(null, D2.d.V);
        if(u0 != null) {
            f0 = u0.a;
        }
        if(f0 instanceof O2.e && !arrayList0.isEmpty()) {
            for(Object object2: arrayList0) {
                J2.u u1 = (J2.u)((B2.i)object2).b().foldIn(null, D2.d.X);
                if((u1 == null ? null : u1.a) instanceof O2.d) {
                    k0.a(V4.u.o(k0.b()));
                    return;
                }
                if(false) {
                    break;
                }
            }
        }
    }

    public static final long L(String s) {
        int v = s.length();
        int v1 = v <= 0 || !Tf.o.w0("+-", s.charAt(0)) ? 0 : 1;
        if(v - v1 > 16) {
            int v2 = v1;
            while(v1 < v) {
                int v3 = s.charAt(v1);
                if(v3 != 0x30) {
                    if(49 <= v3 && v3 < 58) {
                        goto label_11;
                    }
                    goto label_15;
                }
                else if(v2 == v1) {
                    ++v2;
                }
            label_11:
                ++v1;
            }
            if(v - v2 > 16) {
                return s.charAt(0) == 45 ? 0x8000000000000000L : 0x7FFFFFFFFFFFFFFFL;
            }
        }
    label_15:
        if(v.r0(s, "+", false) && v > 1) {
            int v4 = s.charAt(1);
            return 0x30 > v4 || v4 >= 58 ? Long.parseLong(s) : Long.parseLong(Tf.o.x0(1, s));
        }
        return Long.parseLong(s);
    }

    public static void M(long v, g g0, boolean z, B0.b b0) {
        if(z) {
            int v1 = (int)(v >> 0x20);
            int v2 = (int)(v & 0xFFFFFFFFL);
            int v3 = 10;
            int v4 = v1 <= 0 ? 10 : Character.codePointBefore(g0, v1);
            if(v2 < g0.b.length()) {
                v3 = Character.codePointAt(g0, v2);
            }
            if(y5.a.P(v4) && (y5.a.O(v3) || y5.a.N(v3))) {
                do {
                    v1 -= Character.charCount(v4);
                    if(v1 == 0) {
                        break;
                    }
                    v4 = Character.codePointBefore(g0, v1);
                }
                while(y5.a.P(v4));
                v = a1.t.b(v1, v2);
            }
            else if(y5.a.P(v3) && (y5.a.O(v4) || y5.a.N(v4))) {
                do {
                    v2 += Character.charCount(v3);
                    if(v2 == g0.b.length()) {
                        break;
                    }
                    v3 = Character.codePointAt(g0, v2);
                }
                while(y5.a.P(v3));
                v = a1.t.b(v1, v2);
            }
        }
        int v5 = (int)(0xFFFFFFFFL & v);
        b0.invoke(new W.o(new f1.g[]{new f1.v(v5, v5), new f1.e(T.c(v), 0)}));
    }

    public static void N(View view0, View.OnClickListener view$OnClickListener0) {
        if(view0 == null) {
            return;
        }
        view0.setOnClickListener(new Ad.s(1, new G(), view$OnClickListener0));  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static void O(Activity activity0, String s) {
        if(TextUtils.isEmpty(s)) {
            throw new com.gaa.sdk.base.e(1003);
        }
        Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse(("onestore://common/product/download_seedapp/" + s)));
        intent0.addFlags(0x10000000);
        activity0.startActivity(intent0);
    }

    public static final long P(int v, Uf.d d0) {
        q.g(d0, "unit");
        return d0.compareTo(Uf.d.d) > 0 ? a.Q(v, d0) : a.v(y5.a.v(v, d0, Uf.d.b));
    }

    public static final long Q(long v, Uf.d d0) {
        q.g(d0, "unit");
        long v1 = y5.a.v(0x3FFFFFFFFFFA14BFL, Uf.d.b, d0);
        return -v1 > v || v > v1 ? a.t(P4.a.k(y5.a.u(v, d0, Uf.d.c), 0xC000000000000001L, 0x3FFFFFFFFFFFFFFFL)) : a.v(y5.a.v(v, d0, Uf.d.b));
    }

    public static final void R(B2.k k0) {
        B0 b00 = B0.i;
        int v = 0;
        for(Object object0: k0.b) {
            if(v >= 0) {
                B2.i i0 = (B2.i)b00.invoke(((B2.i)object0));
                k0.b.set(v, i0);
                if(i0 instanceof B2.k) {
                    a.R(((B2.k)i0));
                }
                ++v;
                continue;
            }
            e.k.O();
            throw null;
        }
    }

    public static final LinkedHashMap S(B2.k k0) {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        int v = 0;
        for(Object object0: k0.b) {
            if(v >= 0) {
                B2.n n0 = ((B2.i)object0).b();
                ie.m m0 = n0.any(B0.g) ? ((ie.m)n0.foldIn(new ie.m(null, l.a), D2.d.N)) : new ie.m(null, n0);
                C2.b b0 = (C2.b)m0.a;
                B2.n n1 = (B2.n)m0.b;
                C2.a a0 = b0 == null ? null : b0.a;
                ie.m m1 = a0 instanceof C2.e ? new ie.m(a0, n1) : new ie.m(null, n1);
                C2.e e0 = (C2.e)m1.a;
                B2.n n2 = (B2.n)m1.b;
                if(e0 != null && !(((B2.i)object0) instanceof D2.J)) {
                    String s = e0.a + '+' + v;
                    C2.e e1 = new C2.e(s, e0.b);
                    ArrayList arrayList0 = linkedHashMap0.get(s);
                    if(arrayList0 == null) {
                        arrayList0 = new ArrayList();
                        linkedHashMap0.put(s, arrayList0);
                    }
                    arrayList0.add(e1);
                    ((B2.i)object0).a(n2.b(new C2.b(e1, 0)));
                }
                if(((B2.i)object0) instanceof B2.k) {
                    for(Object object1: a.S(((B2.k)(((B2.i)object0)))).entrySet()) {
                        String s1 = (String)((Map.Entry)object1).getKey();
                        List list0 = (List)((Map.Entry)object1).getValue();
                        ArrayList arrayList1 = linkedHashMap0.get(s1);
                        if(arrayList1 == null) {
                            arrayList1 = new ArrayList();
                            linkedHashMap0.put(s1, arrayList1);
                        }
                        arrayList1.addAll(list0);
                    }
                }
                ++v;
                continue;
            }
            e.k.O();
            throw null;
        }
        return linkedHashMap0;
    }

    public static void T(Parcel parcel0, Parcelable parcelable0) {
        if(parcelable0 != null) {
            parcel0.writeInt(1);
            parcelable0.writeToParcel(parcel0, 0);
            return;
        }
        parcel0.writeInt(0);
    }

    public static final void a(b0 b00, we.a a0, androidx.compose.runtime.l l0, int v) {
        q.g(b00, "text");
        q.g(a0, "onClick");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x5BC25EB8);
        int v1 = (p0.g(b00) ? 4 : 2) | v | (p0.i(a0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.layout.d.c(n0, 1.0f), new Ac.B(4, a0));
            C0 c00 = p0.N();
            if(c00 == androidx.compose.runtime.k.a) {
                c00 = new C0(10);
                p0.l0(c00);
            }
            r0.q q1 = X0.n.c(q0, false, c00);
            p0 p00 = n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q2, P0.j.d);
            androidx.compose.foundation.q.c(I.Q(0x7F080140, p0, 6), null, null, null, null, 0.0f, new y0.k(e0.T(p0, 0x7F06017A), 5), p0, 0x30, 60);  // drawable:btn_common_filter_14
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 4.0f));
            N1.b(((String)b00.getValue()), null, e0.T(p0, 0x7F06017C), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:green500s_support_high_contrast
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.i(b00, a0, v, 2);
        }
    }

    public static final void b(h0 h00, androidx.compose.runtime.l l0, int v) {
        q.g(h00, "uiState");
        ((androidx.compose.runtime.p)l0).c0(0x89E0F738);
        int v1 = (((androidx.compose.runtime.p)l0).g(h00) ? 0x20 : 16) | v;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            k0.a(androidx.compose.foundation.layout.a.l(r0.n.a, 16.0f, 0.0f, 2), h00.a, ((androidx.compose.runtime.p)l0), 0);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new C8.a(h00, v, 19);
        }
    }

    public static final void c(int v, y0.s s0, String s1, we.a a0, androidx.compose.runtime.l l0, int v1) {
        y0.s s3;
        y0.s s2;
        int v3;
        q.g(s1, "text");
        q.g(a0, "onClick");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(2109964780);
        int v2 = v1 | 16 | (p0.g(s1) ? 0x100 : 0x80) | (p0.i(a0) ? 0x800 : 0x400);
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            p0.V();
            if((v1 & 1) == 0 || p0.B()) {
                v3 = v2 & 0xFFFFFF8F;
                s2 = new y0.s(e0.T(p0, 0x7F060165));  // color:gray800s
            }
            else {
                p0.T();
                v3 = v2 & 0xFFFFFF8F;
                s2 = s0;
            }
            p0.q();
            Ac.B b0 = new Ac.B(5, a0);
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(n0, b0);
            C0 c00 = p0.N();
            if(c00 == androidx.compose.runtime.k.a) {
                c00 = new C0(9);
                p0.l0(c00);
            }
            r0.q q1 = X0.n.c(q0, false, c00);
            p0 p00 = n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            androidx.compose.runtime.w.x(p0, q2, P0.j.d);
            androidx.compose.foundation.q.c(I.Q(v, p0, 6), null, null, null, null, 0.0f, (s2 == null ? null : new y0.k(s2.a, 5)), p0, 0x30, 60);
            N1.b(s1, null, A7.d.g(n0, 4.0f, p0, 0x7F060165, p0), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 14 & v3 >> 6 | 0xC00, 0, 0x1FFF2);  // color:gray800s
            p0.p(true);
            s3 = s2;
        }
        else {
            p0.T();
            s3 = s0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.e(v, s3, s1, a0, v1);
        }
    }

    public static final void d(we.a a0, androidx.compose.runtime.l l0, int v) {
        q.g(a0, "onClick");
        ((androidx.compose.runtime.p)l0).c0(0xB9357707);
        int v1 = (((androidx.compose.runtime.p)l0).i(a0) ? 4 : 2) | v;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            C0.c c0 = I.Q(0x7F08019F, ((androidx.compose.runtime.p)l0), 6);  // drawable:btn_filter_allplay
            N0.m m0 = N0.j.g;
            Ac.B b0 = new Ac.B(6, a0);
            r0.q q0 = r0.a.a(r0.n.a, b0);
            C0 c00 = ((androidx.compose.runtime.p)l0).N();
            if(c00 == androidx.compose.runtime.k.a) {
                c00 = new C0(8);
                ((androidx.compose.runtime.p)l0).l0(c00);
            }
            androidx.compose.foundation.q.c(c0, "", X0.n.c(q0, false, c00), null, m0, 0.0f, null, ((androidx.compose.runtime.p)l0), 0x6000, 104);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new C8.j(v, 0, a0);
        }
    }

    public static final void e(b0 b00, we.a a0, androidx.compose.runtime.l l0, int v) {
        q.g(a0, "onClick");
        ((androidx.compose.runtime.p)l0).c0(1841023867);
        int v1 = (((androidx.compose.runtime.p)l0).g(b00) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(a0) ? 0x20 : 16);
        boolean z = true;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            C0.c c0 = I.Q((((Boolean)((O0)b00).getValue()).booleanValue() ? 0x7F0801A0 : 0x7F08019E), ((androidx.compose.runtime.p)l0), 0);  // drawable:btn_filter_allselect
            String s = ResourceUtilsKt.getString((((Boolean)((O0)b00).getValue()).booleanValue() ? 0x7F1310D9 : 0x7F130914), new Object[0]);  // string:unselect_selection "선택해제"
            N0.m m0 = N0.j.g;
            Ac.B b0 = new Ac.B(7, a0);
            r0.q q0 = r0.a.a(r0.n.a, b0);
            if((v1 & 14) != 4) {
                z = false;
            }
            R0 r00 = ((androidx.compose.runtime.p)l0).N();
            if(z || r00 == androidx.compose.runtime.k.a) {
                r00 = new R0(b00, 1);
                ((androidx.compose.runtime.p)l0).l0(r00);
            }
            androidx.compose.foundation.q.c(c0, s, X0.n.c(q0, false, r00), null, m0, 0.0f, null, ((androidx.compose.runtime.p)l0), 0x6000, 104);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new C8.i(b00, a0, v, 0);
        }
    }

    public static final void f(b0 b00, we.a a0, androidx.compose.runtime.l l0, int v) {
        q.g(b00, "checked");
        q.g(a0, "onClick");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xCA5F796C);
        int v1 = (p0.g(b00) ? 4 : 2) | v | (p0.i(a0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.layout.d.c(n0, 1.0f), new Ac.B(8, a0));
            R0 r00 = p0.N();
            if((v1 & 14) == 4 || r00 == androidx.compose.runtime.k.a) {
                r00 = new R0(b00, 2);
                p0.l0(r00);
            }
            r0.q q1 = X0.n.c(q0, false, r00);
            p0 p00 = n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q2, P0.j.d);
            androidx.compose.foundation.q.c(I.Q((((Boolean)b00.getValue()).booleanValue() ? 0x7F080126 : 0x7F080125), p0, 0), null, null, null, null, 0.0f, null, p0, 0x30, 0x7C);  // drawable:btn_common_check_17_on
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 3.0f));
            N1.b(ResourceUtilsKt.getString((((Boolean)b00.getValue()).booleanValue() ? 0x7F1310D9 : 0x7F130914), new Object[0]), null, e0.T(p0, (((Boolean)b00.getValue()).booleanValue() ? 0x7F06017C : 0x7F060165)), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:unselect_selection "선택해제"
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.i(b00, a0, v, 1);
        }
    }

    public static final void g(b1 b10, String[] arr_s, int v, float f, float f1, we.k k0, androidx.compose.runtime.l l0, int v1, int v2) {
        float f6;
        float f5;
        boolean z2;
        String s2;
        int v5;
        q.g(b10, "selectedPosition");
        q.g(k0, "onClick");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x979A403B);
        int v3 = (p0.g(b10) ? 4 : 2) | v1 | (p0.i(arr_s) ? 0x20 : 16);
        if((v2 & 4) != 0) {
            v3 |= 0x180;
        }
        else if((v1 & 0x180) == 0) {
            v3 |= (p0.e(v) ? 0x100 : 0x80);
        }
        if((v2 & 8) != 0) {
            v3 |= 0xC00;
        }
        else if((v1 & 0xC00) == 0) {
            v3 |= (p0.d(f) ? 0x800 : 0x400);
        }
        if((v2 & 16) != 0) {
            v3 |= 0x6000;
        }
        else if((v1 & 0x6000) == 0) {
            v3 |= (p0.d(f1) ? 0x4000 : 0x2000);
        }
        int v4 = v3 | (p0.i(k0) ? 0x20000 : 0x10000);
        if(p0.Q(v4 & 1, (74899 & v4) != 74898)) {
            v5 = (v2 & 4) == 0 ? v : 0;
            float f2 = (v2 & 8) == 0 ? f : 0.0f;
            float f3 = (v2 & 16) == 0 ? f1 : 74.0f;
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.o(n0, (r1.f.a(f2, 0.0f) ? ((float)(v5 == 1 ? 0xBA : 130)) : f2), 30.0f);
            r0.q q1 = androidx.compose.foundation.q.i(1.5f, e0.T(p0, 0x7F060152), q0, T.e.b(100.0f));  // color:gray200a
            boolean z = p0.i(arr_s);
            A2 a20 = p0.N();
            V v6 = androidx.compose.runtime.k.a;
            if(z || a20 == v6) {
                a20 = new A2(arr_s, 7);
                p0.l0(a20);
            }
            r0.q q2 = X0.n.c(q1, false, a20);
            M m0 = M.p.d(r0.d.a, false);
            int v7 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h0);
            }
            androidx.compose.runtime.w.x(p0, q3, P0.j.d);
            String s = arr_s[0];
            boolean z1 = ((Number)b10.getValue()).intValue() == 0;
            androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            r0.q q4 = b0.a(n0, r0.d.d);
            C8.d d0 = p0.N();
            if((v4 & 14) == 4 || d0 == v6) {
                d0 = new C8.d(b10, 1);
                p0.l0(d0);
            }
            r0.q q5 = X0.n.c(q4, false, d0);
            C8.c c0 = p0.N();
            if((v4 & 0x70000) == 0x20000 || c0 == v6) {
                c0 = new C8.c(0, k0);
                p0.l0(c0);
            }
            int v8 = v4 >> 6 & 0x380;
            a.h(s, z1, f3, q5, c0, p0, v8);
            if(v5 == 1) {
                p0.a0(0x447F5529);
                String s1 = arr_s[1];
                if(((Number)b10.getValue()).intValue() == 1) {
                    s2 = s1;
                    z2 = true;
                }
                else {
                    s2 = s1;
                    z2 = false;
                }
                r0.q q6 = b0.a(n0, r0.d.e);
                C8.d d1 = p0.N();
                if((v4 & 14) == 4 || d1 == v6) {
                    d1 = new C8.d(b10, 0);
                    p0.l0(d1);
                }
                r0.q q7 = X0.n.c(q6, false, d1);
                C8.c c1 = p0.N();
                if((v4 & 0x70000) == 0x20000 || c1 == v6) {
                    c1 = new C8.c(1, k0);
                    p0.l0(c1);
                }
                a.h(s2, z2, f3, q7, c1, p0, v8);
            }
            else {
                p0.a0(0x4433D42D);
            }
            p0.p(false);
            int v9 = v5 == 1 ? 2 : 1;
            String s3 = arr_s[v9];
            boolean z3 = ((Number)b10.getValue()).intValue() == v9;
            r0.q q8 = b0.a(n0, r0.d.f);
            boolean z4 = p0.e(v9);
            C8.e e0 = p0.N();
            if((v4 & 14) == 4 || z4 || e0 == v6) {
                e0 = new C8.e(v9, b10, 0);
                p0.l0(e0);
            }
            r0.q q9 = X0.n.c(q8, false, e0);
            boolean z5 = p0.e(v9);
            C8.f f4 = p0.N();
            if(z5 || (v4 & 0x70000) == 0x20000 || f4 == v6) {
                f4 = new C8.f(k0, v9, 0);
                p0.l0(f4);
            }
            a.h(s3, z3, f3, q9, f4, p0, v8);
            p0.p(true);
            f5 = f2;
            f6 = f3;
        }
        else {
            p0.T();
            v5 = v;
            f5 = f;
            f6 = f1;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.g(b10, arr_s, v5, f5, f6, k0, v1, v2);
        }
    }

    public static final void h(String s, boolean z, float f, r0.q q0, we.a a0, androidx.compose.runtime.l l0, int v) {
        long v3;
        ((androidx.compose.runtime.p)l0).c0(1400176020);
        int v1 = (v & 6) == 0 ? (((androidx.compose.runtime.p)l0).g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).h(z) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).d(f) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).g(q0) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).i(a0) ? 0x4000 : 0x2000);
        }
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 9363) != 9362)) {
            long v2 = e0.T(((androidx.compose.runtime.p)l0), (z ? 0x7F06017C : 0x7F060160));  // color:green500s_support_high_contrast
            r0.q q1 = androidx.compose.foundation.layout.d.c(androidx.compose.foundation.layout.d.q(q0, f), 1.0f);
            if(z) {
                v3 = A7.d.f(((androidx.compose.runtime.p)l0), 1244408660, 0x7F06017C, ((androidx.compose.runtime.p)l0), false);  // color:green500s_support_high_contrast
            }
            else {
                ((androidx.compose.runtime.p)l0).a0(0x4A2C349F);
                ((androidx.compose.runtime.p)l0).p(false);
                v3 = y0.s.f;
            }
            N1.b(s, androidx.compose.foundation.layout.d.u(r0.a.a(androidx.compose.foundation.q.i(1.5f, v3, q1, T.e.b(100.0f)), new Ac.B(9, a0)), 2), v2, 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, ((androidx.compose.runtime.p)l0), v1 & 14 | 0xC00, 0, 0x1FFF0);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new C8.h(s, z, f, q0, a0, v);
        }
    }

    public static Object i(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
        return parcel0.readInt() == 0 ? null : parcelable$Creator0.createFromParcel(parcel0);
    }

    public static final boolean j(String s) {
        int v = 0;
        while(v < s.length()) {
            int v1 = s.charAt(v);
            if(q.h(v1, 0x80) < 0 && !Character.isLetter(((char)v1))) {
                ++v;
                continue;
            }
            return true;
        }
        return false;
    }

    public static final long k(String s) {
        Uf.d d0;
        int v = s.length();
        if(v == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        int v1 = s.charAt(0) == 43 || s.charAt(0) == 45 ? 1 : 0;
        boolean z = v1 > 0 && Tf.o.U0(s, '-');
        if(v <= v1) {
            throw new IllegalArgumentException("No components");
        }
        if(s.charAt(v1) != 80) {
            throw new IllegalArgumentException();
        }
        int v2 = v1 + 1;
        if(v2 == v) {
            throw new IllegalArgumentException();
        }
        Enum enum0 = null;
        long v3 = 0L;
        boolean z1 = false;
        while(v2 < v) {
            if(s.charAt(v2) == 84) {
                if(!z1) {
                    ++v2;
                    if(v2 != v) {
                        z1 = true;
                        continue;
                    }
                }
                throw new IllegalArgumentException();
            }
            int v4;
            for(v4 = v2; v4 < s.length(); ++v4) {
                int v5 = s.charAt(v4);
                if((0x30 > v5 || v5 >= 58) && !Tf.o.w0("+-.", ((char)v5))) {
                    break;
                }
            }
            String s1 = s.substring(v2, v4);
            q.f(s1, "substring(...)");
            if(s1.length() == 0) {
                throw new IllegalArgumentException();
            }
            int v6 = s1.length() + v2;
            if(v6 < 0 || v6 >= s.length()) {
                throw new IllegalArgumentException("Missing unit for value " + s1);
            }
            int v7 = s.charAt(v6);
            if(z1) {
                switch(v7) {
                    case 72: {
                        d0 = Uf.d.f;
                        break;
                    }
                    case 77: {
                        d0 = Uf.d.e;
                        break;
                    }
                    case 83: {
                        d0 = Uf.d.d;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("Invalid duration ISO time unit: " + ((char)v7));
                    }
                }
            }
            else {
                if(v7 != 68) {
                    throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + ((char)v7));
                }
                d0 = Uf.d.g;
            }
            if(enum0 != null && enum0.compareTo(d0) <= 0) {
                throw new IllegalArgumentException("Unexpected order of duration components");
            }
            int v8 = Tf.o.E0(s1, '.', 0, 6);
            if(d0 != Uf.d.d || v8 <= 0) {
                v3 = Uf.b.h(v3, a.Q(a.L(s1), d0));
            }
            else {
                String s2 = s1.substring(0, v8);
                q.f(s2, "substring(...)");
                long v9 = Uf.b.h(v3, a.Q(a.L(s2), d0));
                String s3 = s1.substring(v8);
                q.f(s3, "substring(...)");
                double f = Double.parseDouble(s3);
                double f1 = y5.a.t(f, d0, Uf.d.b);
                if(Double.isNaN(f1)) {
                    throw new IllegalArgumentException("Duration value cannot be NaN.");
                }
                long v10 = ye.a.W(f1);
                v3 = Uf.b.h(v9, (0xC00000000005EB41L > v10 || v10 >= 0x3FFFFFFFFFFA14C0L ? a.u(ye.a.W(y5.a.t(f, d0, Uf.d.c))) : v10 << 1));
            }
            enum0 = d0;
            v2 = v6 + 1;
        }
        return z ? Uf.b.k(v3) : v3;
    }

    public static final void l(Animatable animatable0) {
        q.g(animatable0, "<this>");
        if(MelonSettingInfo.isLowMemoryMode()) {
            animatable0.stop();
            return;
        }
        animatable0.start();
    }

    public static final B2.n m(ArrayList arrayList0) {
        B2.n n0 = l.a;
        for(Object object0: arrayList0) {
            B2.n n1 = (B2.n)object0;
            if(n1 != null) {
                B2.n n2 = n0.b(n1);
                if(n2 != null) {
                    n0 = n2;
                }
            }
        }
        return n0;
    }

    public static final b0 n(K.l l0, androidx.compose.runtime.l l1, int v) {
        b0 b00 = ((androidx.compose.runtime.p)l1).N();
        V v1 = androidx.compose.runtime.k.a;
        if(b00 == v1) {
            b00 = androidx.compose.runtime.w.s(Boolean.FALSE);
            ((androidx.compose.runtime.p)l1).l0(b00);
        }
        boolean z = (v & 14 ^ 6) > 4 && ((androidx.compose.runtime.p)l1).g(l0) || (v & 6) == 4;
        K.e e0 = ((androidx.compose.runtime.p)l1).N();
        if(z || e0 == v1) {
            e0 = new K.e(l0, b00, null);
            ((androidx.compose.runtime.p)l1).l0(e0);
        }
        androidx.compose.runtime.J.d(((androidx.compose.runtime.p)l1), l0, e0);
        return b00;
    }

    public static final ArrayList o(ArrayList arrayList0, Collection collection0, Me.u u0) {
        q.g(collection0, "oldValueParameters");
        arrayList0.size();
        collection0.size();
        ArrayList arrayList1 = je.p.W0(arrayList0, collection0);
        ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
        for(Object object0: arrayList1) {
            Ne.h h0 = ((S)((ie.m)object0).b).getAnnotations();
            qf.e e0 = ((S)((ie.m)object0).b).getName();
            q.f(e0, "getName(...)");
            boolean z = ((S)((ie.m)object0).b).u1();
            x x0 = ((S)((ie.m)object0).b).j == null ? null : xf.d.j(u0).d().f(((x)((ie.m)object0).a));
            N n0 = ((S)((ie.m)object0).b).getSource();
            q.f(n0, "getSource(...)");
            arrayList2.add(new S(u0, null, ((S)((ie.m)object0).b).f, h0, e0, ((x)((ie.m)object0).a), z, ((S)((ie.m)object0).b).h, ((S)((ie.m)object0).b).i, x0, n0));
        }
        return arrayList2;
    }

    public static p p(String s, Collection collection0) {
        p p0;
        q.g(s, "message");
        q.g(collection0, "types");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, collection0));
        for(Object object0: collection0) {
            arrayList0.add(((x)object0).E());
        }
        Qf.f f0 = a.a.D(arrayList0);
        switch(f0.a) {
            case 0: {
                p0 = Af.o.b;
                break;
            }
            case 1: {
                p0 = (p)f0.get(0);
                break;
            }
            default: {
                p0 = new Af.a(s, ((p[])f0.toArray(new p[0])));
            }
        }
        return f0.a <= 1 ? p0 : new Af.l(p0);
    }

    public static Y6.c q(String s, String s1) {
        G7.a a0 = new G7.a(s, s1);
        Y6.b b0 = Y6.c.b(G7.a.class);
        b0.c = 1;
        b0.g = new Y6.a(a0);
        return b0.b();
    }

    public static SessionInfo r(Intent intent0) {
        Bundle bundle0 = intent0.getExtras();
        if(bundle0 == null) {
            throw new IllegalArgumentException("Expected the SessionInfo to be encoded in the bind intent extras, but the extras were null.");
        }
        Bundle bundle1 = bundle0.getBundle("androidx.car.app.extra.SESSION_INFO_BUNDLE");
        return new SessionInfo(bundle1.getInt("display-type"), bundle1.getString("session-id"));
    }

    public static final int s(View view0, float f) {
        Context context0 = view0.getContext();
        q.f(context0, "getContext(...)");
        return (int)TypedValue.applyDimension(1, f, context0.getResources().getDisplayMetrics());
    }

    public static final long t(long v) [...] // Inlined contents

    public static final long u(long v) {
        return -4611686018426L > v || v >= 4611686018427L ? a.t(P4.a.k(v, 0xC000000000000001L, 0x3FFFFFFFFFFFFFFFL)) : v * 1000000L << 1;
    }

    public static final long v(long v) [...] // Inlined contents

    // 去混淆评级： 低(20)
    public static boolean w(Object object0, Object object1) {
        return object0 == object1 || object0 != null && object0.equals(object1);
    }

    public static int x(HandwritingGesture handwritingGesture0, B0.b b0) {
        String s = handwritingGesture0.getFallbackText();
        if(s == null) {
            return 3;
        }
        b0.invoke(new f1.a(s, 1));
        return 5;
    }

    public static Y6.c y(String s, com.google.android.exoplayer2.upstream.cache.a a0) {
        Y6.b b0 = Y6.c.b(G7.a.class);
        b0.c = 1;
        b0.a(Y6.k.b(Context.class));
        b0.g = new B9.g(5, s, a0);
        return b0.b();
    }

    public static final long z(b b0) {
        q.g(b0, "<this>");
        switch(b0.ordinal()) {
            case 0: 
            case 4: {
                return 0xFF284BE5L;
            }
            case 1: 
            case 5: {
                return 0xFF7200E9L;
            }
            case 2: 
            case 6: {
                return 0xFFA11CD7L;
            }
            case 3: 
            case 7: {
                return 0xFF5C34FFL;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }
}

