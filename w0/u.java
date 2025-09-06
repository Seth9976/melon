package w0;

import G0.b;
import G0.c;
import Ic.h;
import M0.a;
import O0.d;
import P0.A0;
import P0.I;
import P0.d0;
import P0.f;
import P0.l;
import P0.m;
import P0.n0;
import Q0.k0;
import android.os.Trace;
import androidx.compose.runtime.O0;
import g0.e;
import gd.k4;
import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import r0.p;
import we.n;

public final class u extends p implements d, l, m, n0 {
    public final n a;
    public boolean b;
    public boolean c;
    public final int d;

    public u(int v, int v1, n n0) {
        if((v1 & 1) != 0) {
            v = 1;
        }
        if((v1 & 2) != 0) {
            n0 = null;
        }
        super();
        this.a = n0;
        this.d = v;
    }

    @Override  // r0.p
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    public final void m0(t t0, t t1) {
        k k0 = (k)((Q0.u)f.w(this)).getFocusOwner();
        u u0 = k0.l;
        if(!t0.equals(t1)) {
            n n0 = this.a;
            if(n0 != null) {
                n0.invoke(t0, t1);
            }
        }
        p p0 = this.getNode();
        if(!this.getNode().isAttached()) {
            a.b("visitAncestors called on an unattached node");
        }
        p p1 = this.getNode();
        I i0 = f.v(this);
    label_11:
        while(i0 != null) {
            if((((p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0x1400) != 0) {
                while(p1 != null) {
                    if((p1.getKindSet$ui_release() & 0x1400) != 0) {
                        if(p1 != p0 && (p1.getKindSet$ui_release() & 0x400) != 0) {
                            break label_11;
                        }
                        if((p1.getKindSet$ui_release() & 0x1000) != 0) {
                            p p2 = p1;
                            e e0 = null;
                            while(p2 != null) {
                                if(!(p2 instanceof w0.e)) {
                                    if((p2.getKindSet$ui_release() & 0x1000) != 0 && p2 instanceof P0.n) {
                                        p p3 = ((P0.n)p2).b;
                                        int v = 0;
                                        while(p3 != null) {
                                            if((p3.getKindSet$ui_release() & 0x1000) != 0) {
                                                ++v;
                                                if(v == 1) {
                                                    p2 = p3;
                                                }
                                                else {
                                                    if(e0 == null) {
                                                        e0 = new e(new p[16]);
                                                    }
                                                    if(p2 != null) {
                                                        e0.b(p2);
                                                        p2 = null;
                                                    }
                                                    e0.b(p3);
                                                }
                                            }
                                            p3 = p3.getChild$ui_release();
                                        }
                                        if(v != 1) {
                                            goto label_42;
                                        }
                                        continue;
                                    }
                                }
                                else if(u0 == k0.l) {
                                    ((w0.e)p2).r(t1);
                                }
                            label_42:
                                p2 = f.f(e0);
                            }
                        }
                    }
                    p1 = p1.getParent$ui_release();
                }
            }
            i0 = i0.u();
            if(i0 != null) {
                d0 d00 = i0.b0;
                if(d00 != null) {
                    p1 = (A0)d00.e;
                    continue;
                }
            }
            p1 = null;
        }
    }

    public final w0.n n0() {
        boolean z;
        w0.n n0 = new w0.n();  // 初始化器: Ljava/lang/Object;-><init>()V
        n0.a = true;
        n0.b = w0.p.b;
        n0.c = w0.p.b;
        n0.d = w0.p.b;
        n0.e = w0.p.b;
        n0.f = w0.p.b;
        n0.g = w0.p.b;
        n0.h = w0.p.b;
        n0.i = w0.p.b;
        n0.j = w0.m.g;
        n0.k = w0.m.h;
        int v = this.d;
        if(v == 1) {
            z = true;
        }
        else if(v == 0) {
            z = (((G0.a)((O0)((c)(((b)f.i(this, k0.m)))).a).getValue()).a == 1 ? 1 : 0) ^ 1;
        }
        else if(v == 2) {
            z = false;
        }
        else {
            throw new IllegalStateException("Unknown Focusability");
        }
        n0.a = z;
        p p0 = this.getNode();
        if(!this.getNode().isAttached()) {
            a.b("visitAncestors called on an unattached node");
        }
        p p1 = this.getNode();
        I i0 = f.v(this);
    label_27:
        while(i0 != null) {
            if((((p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0xC00) != 0) {
                while(p1 != null) {
                    if((p1.getKindSet$ui_release() & 0xC00) != 0) {
                        if(p1 != p0 && (p1.getKindSet$ui_release() & 0x400) != 0) {
                            break label_27;
                        }
                        if((p1.getKindSet$ui_release() & 0x800) != 0) {
                            p p2 = p1;
                            e e0 = null;
                            while(p2 != null) {
                                if(p2 instanceof o) {
                                    ((o)p2).X(n0);
                                }
                                else if((p2.getKindSet$ui_release() & 0x800) != 0 && p2 instanceof P0.n) {
                                    p p3 = ((P0.n)p2).b;
                                    int v1 = 0;
                                    while(p3 != null) {
                                        if((p3.getKindSet$ui_release() & 0x800) != 0) {
                                            ++v1;
                                            if(v1 == 1) {
                                                p2 = p3;
                                            }
                                            else {
                                                if(e0 == null) {
                                                    e0 = new e(new p[16]);
                                                }
                                                if(p2 != null) {
                                                    e0.b(p2);
                                                    p2 = null;
                                                }
                                                e0.b(p3);
                                            }
                                        }
                                        p3 = p3.getChild$ui_release();
                                    }
                                    if(v1 != 1) {
                                        goto label_57;
                                    }
                                    continue;
                                }
                            label_57:
                                p2 = f.f(e0);
                            }
                        }
                    }
                    p1 = p1.getParent$ui_release();
                }
            }
            i0 = i0.u();
            if(i0 != null) {
                d0 d00 = i0.b0;
                if(d00 != null) {
                    p1 = (A0)d00.e;
                    continue;
                }
            }
            p1 = null;
        }
        return n0;
    }

    public final t o0() {
        if(!this.isAttached()) {
            return t.d;
        }
        k k0 = (k)((Q0.u)f.w(this)).getFocusOwner();
        u u0 = k0.l;
        if(u0 == null) {
            return t.d;
        }
        if(this == u0) {
            k0.getClass();
            return t.a;
        }
        if(u0.isAttached()) {
            if(!u0.getNode().isAttached()) {
                a.b("visitAncestors called on an unattached node");
            }
            p p0 = u0.getNode().getParent$ui_release();
            I i0 = f.v(u0);
            while(i0 != null) {
                if((((p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0x400) != 0) {
                    while(p0 != null) {
                        if((p0.getKindSet$ui_release() & 0x400) != 0) {
                            p p1 = p0;
                            e e0 = null;
                            while(p1 != null) {
                                if(p1 instanceof u) {
                                    if(this == ((u)p1)) {
                                        return t.b;
                                    }
                                }
                                else if((p1.getKindSet$ui_release() & 0x400) != 0 && p1 instanceof P0.n) {
                                    p p2 = ((P0.n)p1).b;
                                    int v = 0;
                                    while(p2 != null) {
                                        if((p2.getKindSet$ui_release() & 0x400) != 0) {
                                            ++v;
                                            if(v == 1) {
                                                p1 = p2;
                                            }
                                            else {
                                                if(e0 == null) {
                                                    e0 = new e(new p[16]);
                                                }
                                                if(p1 != null) {
                                                    e0.b(p1);
                                                    p1 = null;
                                                }
                                                e0.b(p2);
                                            }
                                        }
                                        p2 = p2.getChild$ui_release();
                                    }
                                    if(v != 1) {
                                        goto label_42;
                                    }
                                    continue;
                                }
                            label_42:
                                p1 = f.f(e0);
                            }
                        }
                        p0 = p0.getParent$ui_release();
                    }
                }
                i0 = i0.u();
                if(i0 != null) {
                    d0 d00 = i0.b0;
                    if(d00 != null) {
                        p0 = (A0)d00.e;
                        continue;
                    }
                }
                p0 = null;
            }
        }
        return t.d;
    }

    @Override  // r0.p
    public final void onAttach() {
    }

    @Override  // r0.p
    public final void onDetach() {
        switch(this.o0().ordinal()) {
            case 0: 
            case 2: {
                k k0 = (k)((Q0.u)f.w(this)).getFocusOwner();
                k0.c(8, true, false);
                g g0 = k0.g;
                if(!g0.f) {
                    h h0 = new h(0, g0, g.class, "invalidateNodes", "invalidateNodes()V", 0, 28);
                    g0.a.invoke(h0);
                    g0.f = true;
                }
            }
        }
    }

    public final void p0() {
        switch(this.o0().ordinal()) {
            case 0: 
            case 2: {
                H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                f.r(this, new k4(13, h0, this));
                Object object0 = h0.a;
                if(object0 != null) {
                    if(!((w0.l)object0).c()) {
                        ((k)((Q0.u)f.w(this)).getFocusOwner()).c(8, true, true);
                    }
                    return;
                }
                q.m("focusProperties");
                throw null;
            }
        }
    }

    public final boolean q0(int v) {
        boolean z = false;
        Trace.beginSection("FocusTransactions:requestFocus");
        try {
            if(this.n0().a) {
                switch(w0.f.v(this, v).ordinal()) {
                    case 0: {
                        z = w0.f.w(this);
                        goto label_12;
                    }
                    case 2: {
                        z = true;
                        goto label_12;
                    }
                    case 1: 
                    case 3: {
                        goto label_12;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            goto label_14;
        }
        catch(Throwable throwable0) {
        }
        Trace.endSection();
        throw throwable0;
    label_12:
        Trace.endSection();
        return z;
    label_14:
        Trace.endSection();
        return false;
    }

    public static boolean r0(u u0) {
        return u0.q0(7);
    }

    @Override  // P0.n0
    public final void y() {
        this.p0();
    }
}

