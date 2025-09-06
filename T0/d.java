package t0;

import Ic.h;
import P0.j0;
import Q0.N;
import Q0.P0;
import Q0.u;
import S1.b;
import T0.a;
import X0.i;
import X0.k;
import X0.l;
import X0.p;
import X0.s;
import a1.Q;
import a1.g;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.collection.K;
import androidx.collection.m;
import androidx.collection.n;
import androidx.collection.z;
import androidx.lifecycle.D;
import androidx.lifecycle.f;
import i.n.i.b.a.s.e.u9;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import oe.c;
import r1.o;

public final class d implements View.OnAttachStateChangeListener, f {
    public final u a;
    public final h b;
    public a c;
    public final ArrayList d;
    public final long e;
    public t0.a f;
    public boolean g;
    public final Channel h;
    public final Handler i;
    public z j;
    public long k;
    public final z l;
    public P0 m;
    public boolean n;
    public final u9 o;

    public d(u u0, h h0) {
        this.a = u0;
        this.b = h0;
        this.d = new ArrayList();
        this.e = 100L;
        this.f = t0.a.a;
        this.g = true;
        this.h = ChannelKt.Channel$default(1, null, null, 6, null);
        this.i = new Handler(Looper.getMainLooper());
        q.e(n.a, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.intObjectMapOf>");
        this.j = n.a;
        this.l = new z();
        p p0 = u0.getSemanticsOwner().a();
        q.e(n.a, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.intObjectMapOf>");
        this.m = new P0(p0, n.a);
        this.o = new u9(this, 18);
    }

    public final Object a(c c0) {
        d d1;
        ChannelIterator channelIterator1;
        d d0;
        ChannelIterator channelIterator0;
        t0.c c1;
        if(c0 instanceof t0.c) {
            c1 = (t0.c)c0;
            int v = c1.E;
            if((v & 0x80000000) == 0) {
                c1 = new t0.c(this, c0);
            }
            else {
                c1.E = v ^ 0x80000000;
            }
        }
        else {
            c1 = new t0.c(this, c0);
        }
        Object object0 = c1.B;
        ne.a a0 = ne.a.a;
        switch(c1.E) {
            case 0: {
                d5.n.D(object0);
                channelIterator0 = this.h.iterator();
                d0 = this;
                goto label_26;
            }
            case 1: {
                channelIterator1 = c1.w;
                d1 = c1.r;
                d5.n.D(object0);
                goto label_34;
            }
            case 2: {
                channelIterator1 = c1.w;
                d1 = c1.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        do {
            channelIterator0 = channelIterator1;
            d0 = d1;
        label_26:
            c1.r = d0;
            c1.w = channelIterator0;
            c1.E = 1;
            Object object1 = channelIterator0.hasNext(c1);
            if(object1 == a0) {
                return a0;
            }
            channelIterator1 = channelIterator0;
            object0 = object1;
            d1 = d0;
        label_34:
            if(!((Boolean)object0).booleanValue()) {
                return H.a;
            }
            channelIterator1.next();
            if(d1.e()) {
                d1.f();
            }
            if(!d1.n) {
                d1.n = true;
                d1.i.post(d1.o);
            }
            c1.r = d1;
            c1.w = channelIterator1;
            c1.E = 2;
        }
        while(DelayKt.delay(d1.e, c1) != a0);
        return a0;
    }

    public final void b(p p0, we.n n0) {
        p0.getClass();
        List list0 = p.h(4, p0);
        int v = list0.size();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = list0.get(v1);
            if(this.d().a(((p)object0).g)) {
                n0.invoke(v2, object0);
                ++v2;
            }
        }
    }

    public final m d() {
        if(this.g) {
            this.g = false;
            this.j = N.k(this.a.getSemanticsOwner());
            this.k = System.currentTimeMillis();
        }
        return this.j;
    }

    public final boolean e() {
        return this.c != null;
    }

    public final void f() {
        a a0 = this.c;
        if(a0 != null) {
            Object object0 = a0.a;
            if(Build.VERSION.SDK_INT >= 29) {
                ArrayList arrayList0 = this.d;
                if(!arrayList0.isEmpty()) {
                    int v = arrayList0.size();
                    for(int v1 = 0; v1 < v; ++v1) {
                        e e0 = (e)arrayList0.get(v1);
                        switch(e0.c.ordinal()) {
                            case 0: {
                                I7.c c0 = e0.d;
                                if(c0 != null) {
                                    ViewStructure viewStructure0 = (ViewStructure)c0.b;
                                    if(Build.VERSION.SDK_INT >= 29) {
                                        b.e(((ContentCaptureSession)object0), viewStructure0);
                                    }
                                }
                                break;
                            }
                            case 1: {
                                AutofillId autofillId0 = a0.a(((long)e0.a));
                                if(autofillId0 != null && Build.VERSION.SDK_INT >= 29) {
                                    b.f(((ContentCaptureSession)object0), autofillId0);
                                }
                            }
                        }
                    }
                    if(Build.VERSION.SDK_INT >= 29) {
                        b.h(((ContentCaptureSession)object0), a0.b.getAutofillId(), new long[]{0x8000000000000000L});
                    }
                    arrayList0.clear();
                }
            }
        }
    }

    public final void g(p p0, P0 p00) {
        this.b(p0, new B2.p(24, p00, this));
        List list0 = p.h(4, p0);
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            p p1 = (p)list0.get(v1);
            m m0 = this.d();
            int v2 = p1.g;
            if(m0.a(v2)) {
                z z0 = this.l;
                if(z0.a(v2)) {
                    Object object0 = z0.b(v2);
                    if(object0 == null) {
                        throw Y.d("node not present in pruned tree before this change");
                    }
                    this.g(p1, ((P0)object0));
                    continue;
                }
            }
        }
    }

    public final void i(int v, String s) {
        int v1 = Build.VERSION.SDK_INT;
        if(v1 >= 29) {
            a a0 = this.c;
            if(a0 != null) {
                AutofillId autofillId0 = a0.a(((long)v));
                if(autofillId0 == null) {
                    throw Y.d("Invalid content capture ID");
                }
                if(v1 >= 29) {
                    b.g(((ContentCaptureSession)a0.a), autofillId0, s);
                }
            }
        }
    }

    public final void j(int v, p p0) {
        I7.c c0;
        if(!this.e()) {
            return;
        }
        K k0 = p0.d.a;
        Object object0 = k0.g(s.A);
        j0 j00 = null;
        if(object0 == null) {
            object0 = null;
        }
        if(this.f == t0.a.a && q.b(((Boolean)object0), Boolean.TRUE)) {
            Object object1 = k0.g(k.l);
            if(object1 == null) {
                object1 = null;
            }
            if(((X0.a)object1) != null) {
                we.k k1 = (we.k)((X0.a)object1).b;
                if(k1 != null) {
                    Boolean boolean0 = (Boolean)k1.invoke(Boolean.FALSE);
                }
            }
        }
        else if(this.f == t0.a.b && q.b(((Boolean)object0), Boolean.FALSE)) {
            Object object2 = k0.g(k.l);
            if(object2 == null) {
                object2 = null;
            }
            if(((X0.a)object2) != null) {
                we.k k2 = (we.k)((X0.a)object2).b;
                if(k2 != null) {
                    Boolean boolean1 = (Boolean)k2.invoke(Boolean.TRUE);
                }
            }
        }
        int v1 = p0.g;
        a a0 = this.c;
        if(a0 == null) {
            c0 = null;
        }
        else if(Build.VERSION.SDK_INT >= 29) {
            AutofillId autofillId0 = this.a.getAutofillId();
            p p1 = p0.j();
            int v2 = p0.g;
            if(p1 == null) {
            label_36:
                I7.c c1 = new I7.c(b.d(((ContentCaptureSession)a0.a), autofillId0, ((long)v2)), 22);
                ViewStructure viewStructure0 = (ViewStructure)c1.b;
                l l0 = p0.d;
                K k3 = l0.a;
                if(k3.c(s.H)) {
                    c0 = null;
                }
                else {
                    Bundle bundle0 = viewStructure0.getExtras();
                    if(bundle0 != null) {
                        bundle0.putLong("android.view.contentcapture.EventTimestamp", this.k);
                        bundle0.putInt("android.view.ViewStructure.extra.EXTRA_VIEW_NODE_INDEX", v);
                    }
                    Object object3 = k3.g(s.w);
                    if(object3 == null) {
                        object3 = null;
                    }
                    if(((String)object3) != null) {
                        viewStructure0.setId(v2, null, null, ((String)object3));
                    }
                    Object object4 = k3.g(s.m);
                    if(object4 == null) {
                        object4 = null;
                    }
                    if(((Boolean)object4) != null) {
                        viewStructure0.setClassName("android.widget.ViewGroup");
                    }
                    Object object5 = k3.g(s.y);
                    if(object5 == null) {
                        object5 = null;
                    }
                    if(((List)object5) != null) {
                        viewStructure0.setClassName("android.widget.TextView");
                        viewStructure0.setText(t1.a.a(((List)object5), "\n", null, 62));
                    }
                    Object object6 = k3.g(s.C);
                    if(object6 == null) {
                        object6 = null;
                    }
                    if(((g)object6) != null) {
                        viewStructure0.setClassName("android.widget.EditText");
                        viewStructure0.setText(((g)object6));
                    }
                    Object object7 = k3.g(s.a);
                    if(object7 == null) {
                        object7 = null;
                    }
                    if(((List)object7) != null) {
                        viewStructure0.setContentDescription(t1.a.a(((List)object7), "\n", null, 62));
                    }
                    Object object8 = k3.g(s.v);
                    if(object8 == null) {
                        object8 = null;
                    }
                    if(((i)object8) != null) {
                        String s = N.x(((i)object8).a);
                        if(s != null) {
                            viewStructure0.setClassName(s);
                        }
                    }
                    Q q0 = N.m(l0);
                    if(q0 != null) {
                        float f = q0.a.g.b();
                        viewStructure0.setTextStyle(q0.a.g.W() * (f * o.c(q0.a.b.a.b)), 0, 0, 0);
                    }
                    p p2 = p0.j();
                    x0.c c2 = x0.c.e;
                    if(p2 != null) {
                        j0 j01 = p0.c();
                        if(j01 != null) {
                            if(j01.h()) {
                                j00 = j01;
                            }
                            if(j00 != null) {
                                c2 = P0.f.t(p2.a, 8).f(j00, true);
                            }
                        }
                    }
                    viewStructure0.setDimens(((int)c2.a), ((int)c2.b), 0, 0, ((int)(c2.c - c2.a)), ((int)(c2.d - c2.b)));
                    c0 = c1;
                }
            }
            else {
                autofillId0 = a0.a(((long)p1.g));
                if(autofillId0 == null) {
                    c0 = null;
                    goto label_100;
                }
                goto label_36;
            }
        }
        else {
            c0 = null;
        }
    label_100:
        if(c0 != null) {
            e e0 = new e(v1, this.k, t0.f.a, c0);
            this.d.add(e0);
        }
        this.b(p0, new F.e(this, 23));
    }

    public final void k(p p0) {
        if(this.e()) {
            e e0 = new e(p0.g, this.k, t0.f.b, null);
            this.d.add(e0);
            List list0 = p.h(4, p0);
            int v = list0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                this.k(((p)list0.get(v1)));
            }
        }
    }

    @Override  // androidx.lifecycle.f
    public final void onStart(D d0) {
        this.c = (a)this.b.invoke();
        this.j(-1, this.a.getSemanticsOwner().a());
        this.f();
    }

    @Override  // androidx.lifecycle.f
    public final void onStop(D d0) {
        this.k(this.a.getSemanticsOwner().a());
        this.f();
        this.c = null;
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view0) {
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view0) {
        this.i.removeCallbacks(this.o);
        this.c = null;
    }
}

