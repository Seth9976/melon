package androidx.compose.ui.platform;

import B0.b;
import E4.e;
import E4.g;
import F0.a;
import I.L0;
import I.Y0;
import Q0.D0;
import Q0.O;
import Q0.Q;
import Q0.S;
import Q0.j;
import Q0.k0;
import Q0.n0;
import Q0.o0;
import Q0.p0;
import Q0.u;
import V0.c;
import V0.d;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.A;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.c1;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.m0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import ie.H;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\" \u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00010\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0002\u0010\u0003¨\u0006\t²\u0006\u000E\u0010\b\u001A\u00020\u00078\n@\nX\u008A\u008E\u0002"}, d2 = {"Landroidx/compose/runtime/l0;", "Landroidx/lifecycle/D;", "getLocalLifecycleOwner", "()Landroidx/compose/runtime/l0;", "getLocalLifecycleOwner$annotations", "()V", "LocalLifecycleOwner", "Landroid/content/res/Configuration;", "configuration", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class AndroidCompositionLocals_androidKt {
    public static final A a;
    public static final c1 b;
    public static final c1 c;
    public static final c1 d;
    public static final c1 e;
    public static final c1 f;

    static {
        AndroidCompositionLocals_androidKt.a = new A(O.g);
        AndroidCompositionLocals_androidKt.b = new c1(O.h);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        AndroidCompositionLocals_androidKt.c = new c1(O.i);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        AndroidCompositionLocals_androidKt.d = new c1(O.j);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        AndroidCompositionLocals_androidKt.e = new c1(O.k);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        AndroidCompositionLocals_androidKt.f = new c1(O.l);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
    }

    public static final void a(u u0, n n0, l l0, int v) {
        b0 b01;
        LinkedHashMap linkedHashMap0;
        p p0 = (p)l0;
        p0.c0(1396852028);
        int v1 = (p0.i(u0) ? 4 : 2) | v | (p0.i(n0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = u0.getContext();
            b0 b00 = p0.N();
            V v2 = k.a;
            if(b00 == v2) {
                b00 = w.s(new Configuration(context0.getResources().getConfiguration()));
                p0.l0(b00);
            }
            Y0 y00 = p0.N();
            if(y00 == v2) {
                y00 = new Y0(b00, 1);
                p0.l0(y00);
            }
            u0.setConfigurationChangeObserver(y00);
            AndroidUriHandler androidUriHandler0 = p0.N();
            if(androidUriHandler0 == v2) {
                androidUriHandler0 = new AndroidUriHandler(context0);
                p0.l0(androidUriHandler0);
            }
            j j0 = u0.getViewTreeOwners();
            if(j0 == null) {
                throw new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
            }
            g g0 = j0.b;
            n0 n00 = p0.N();
            if(n00 == v2) {
                ViewParent viewParent0 = u0.getParent();
                q.e(viewParent0, "null cannot be cast to non-null type android.view.View");
                Object object0 = ((View)viewParent0).getTag(0x7F0A030D);  // id:compose_view_saveable_id_tag
                String s = object0 instanceof String ? ((String)object0) : null;
                if(s == null) {
                    s = String.valueOf(((View)viewParent0).getId());
                }
                String s1 = "i" + ':' + s;
                e e0 = g0.getSavedStateRegistry();
                Bundle bundle0 = e0.a(s1);
                if(bundle0 == null) {
                    linkedHashMap0 = null;
                }
                else {
                    linkedHashMap0 = new LinkedHashMap();
                    for(Object object1: bundle0.keySet()) {
                        ArrayList arrayList0 = bundle0.getParcelableArrayList(((String)object1));
                        q.e(arrayList0, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Any?> }");
                        linkedHashMap0.put(((String)object1), arrayList0);
                    }
                }
                b01 = b00;
                o0.j j1 = new o0.j(linkedHashMap0, Q0.l.j);
                boolean z = false;
                try {
                    e0.c(s1, new o0(j1, 0));
                    z = true;
                }
                catch(IllegalArgumentException unused_ex) {
                }
                n0 n01 = new n0(j1, new p0(z, e0, s1));
                p0.l0(n01);
                n00 = n01;
            }
            else {
                b01 = b00;
            }
            boolean z1 = p0.i(n00);
            b b0 = p0.N();
            if(z1 || b0 == v2) {
                b0 = new b(n00, 17);
                p0.l0(b0);
            }
            J.b(H.a, b0, p0);
            Object object2 = p0.N();
            if(object2 == v2) {
                object2 = Build.VERSION.SDK_INT < 0x1F || !((Vibrator)context0.getSystemService(Vibrator.class)).areAllPrimitivesSupported(new int[]{1, 7, 2}) ? new D0() : new F0.b(u0, 1);  // 初始化器: Ljava/lang/Object;-><init>()V
                p0.l0(object2);
            }
            Configuration configuration0 = (Configuration)b01.getValue();
            c c0 = p0.N();
            if(c0 == v2) {
                c0 = new c();
                p0.l0(c0);
            }
            Configuration configuration1 = p0.N();
            if(configuration1 == v2) {
                configuration1 = new Configuration();
                if(configuration0 != null) {
                    configuration1.setTo(configuration0);
                }
                p0.l0(configuration1);
            }
            Q q0 = p0.N();
            if(q0 == v2) {
                q0 = new Q(configuration1, c0);
                p0.l0(q0);
            }
            boolean z2 = p0.i(context0);
            Ld.p p1 = p0.N();
            if(z2 || p1 == v2) {
                p1 = new Ld.p(5, context0, q0);
                p0.l0(p1);
            }
            J.b(c0, p1, p0);
            d d0 = p0.N();
            if(d0 == v2) {
                d0 = new d();
                p0.l0(d0);
            }
            S s2 = p0.N();
            if(s2 == v2) {
                s2 = new S(d0);
                p0.l0(s2);
            }
            boolean z3 = p0.i(context0);
            Ld.p p2 = p0.N();
            if(z3 || p2 == v2) {
                p2 = new Ld.p(6, context0, s2);
                p0.l0(p2);
            }
            J.b(d0, p2, p0);
            boolean z4 = ((Boolean)p0.k(k0.v)).booleanValue();
            boolean z5 = u0.getScrollCaptureInProgress$ui_release();
            Configuration configuration2 = (Configuration)b01.getValue();
            w.b(new m0[]{AndroidCompositionLocals_androidKt.a.a(configuration2), AndroidCompositionLocals_androidKt.b.a(context0), Q2.e.a.a(j0.a), AndroidCompositionLocals_androidKt.e.a(g0), o0.k.a.a(n00), AndroidCompositionLocals_androidKt.f.a(u0), AndroidCompositionLocals_androidKt.c.a(c0), AndroidCompositionLocals_androidKt.d.a(d0), k0.v.a(Boolean.valueOf(((boolean)(z4 | z5)))), k0.l.a(((a)object2))}, m0.c.e(0x57B729FC, p0, new L0(u0, androidUriHandler0, n0, 2)), p0, 56);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n02 = p0.t();
        if(n02 != null) {
            n02.d = new B2.p(u0, n0, v, 13);
        }
    }

    public static final void b(String s) {
        throw new IllegalStateException(("CompositionLocal " + s + " not present").toString());
    }

    public static final c1 c() {
        return AndroidCompositionLocals_androidKt.b;
    }

    @NotNull
    public static final l0 getLocalLifecycleOwner() {
        return Q2.e.a;
    }
}

