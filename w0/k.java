package w0;

import Dc.s;
import Ic.h;
import M0.a;
import Mc.H;
import O.B;
import O.l;
import P.A;
import P0.A0;
import P0.I;
import P0.d0;
import P0.f;
import P0.m;
import Q0.n;
import android.os.Trace;
import android.view.KeyEvent;
import android.view.autofill.AutofillManager;
import androidx.collection.D;
import androidx.collection.G;
import androidx.collection.S;
import androidx.compose.ui.focus.FocusOwnerImpl.modifier.1;
import g0.e;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.q;
import r0.p;
import s0.b;
import x0.c;

public final class k implements j {
    public final s a;
    public final H b;
    public final h c;
    public final h d;
    public final n e;
    public final u f;
    public final g g;
    public final v h;
    public final FocusOwnerImpl.modifier.1 i;
    public D j;
    public final G k;
    public u l;

    public k(H h0, s s0, H h1, h h2, h h3, n n0) {
        this.a = s0;
        this.b = h1;
        this.c = h2;
        this.d = h3;
        this.e = n0;
        this.f = new u(2, 6, null);
        this.g = new g(h0, new h(0, this, k.class, "invalidateOwnerFocusState", "invalidateOwnerFocusState()V", 0, 29), new l(0, 3, k.class, this, "rootState", "getRootState()Landroidx/compose/ui/focus/FocusState;"), new n(0, 7, k.class, this, "activeFocusTargetNode", "getActiveFocusTargetNode()Landroidx/compose/ui/focus/FocusTargetNode;"));
        v v0 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
        S.b();
        this.h = v0;
        this.i = new FocusOwnerImpl.modifier.1(this);
        this.k = new G(1);
    }

    public final boolean b(boolean z) {
        u u0 = this.l;
        if(u0 != null) {
            this.g(null);
            u0.m0(t.a, t.d);
            if(!u0.getNode().isAttached()) {
                a.b("visitAncestors called on an unattached node");
            }
            p p0 = u0.getNode().getParent$ui_release();
            I i0 = f.v(u0);
            while(i0 != null) {
                if((((p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0x400) != 0) {
                    while(p0 != null) {
                        if((p0.getKindSet$ui_release() & 0x400) != 0) {
                            e e0 = null;
                            p p1 = p0;
                            while(p1 != null) {
                                if(p1 instanceof u) {
                                    ((u)p1).m0(t.b, t.d);
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
                                        goto label_36;
                                    }
                                    continue;
                                }
                            label_36:
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
        return true;
    }

    public final boolean c(int v, boolean z, boolean z1) {
        boolean z2 = true;
        if(z) {
            this.b(true);
        }
        else {
            int v1 = w0.f.t(this.f, v).ordinal();
            switch(v1) {
                case 0: {
                    this.b(false);
                    goto label_11;
                }
                case 1: {
                    break;
                }
                default: {
                    if(v1 != 2 && v1 != 3) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            z2 = false;
        }
    label_11:
        if(z2 && z1) {
            this.c.invoke();
        }
        return z2;
    }

    public final boolean d(KeyEvent keyEvent0, we.a a0) {
        m m0;
        p p3;
        p p6;
        u u0 = this.f;
        Trace.beginSection("FocusOwnerImpl:dispatchKeyEvent");
        try {
            if(this.g.f) {
                System.out.println("FocusRelatedWarning: Dispatching key event while focus system is invalidated.");
                return false;
            }
            if(!this.h(keyEvent0)) {
                return false;
            }
            u u1 = w0.f.g(u0);
            if(u1 == null) {
            label_29:
                if(u1 == null) {
                label_77:
                    if(!u0.getNode().isAttached()) {
                        a.b("visitAncestors called on an unattached node");
                    }
                    p p5 = u0.getNode().getParent$ui_release();
                    I i1 = f.v(u0);
                alab1:
                    while(true) {
                        p6 = null;
                        if(i1 == null) {
                            break;
                        }
                        if((((p)i1.b0.f).getAggregateChildKindSet$ui_release() & 0x2000) != 0) {
                            while(p5 != null) {
                                if((p5.getKindSet$ui_release() & 0x2000) != 0) {
                                    p6 = p5;
                                    e e1 = null;
                                    while(p6 != null) {
                                        if(p6 instanceof H0.f) {
                                            break alab1;
                                        }
                                        if((p6.getKindSet$ui_release() & 0x2000) != 0 && p6 instanceof P0.n) {
                                            p p7 = ((P0.n)p6).b;
                                            int v2 = 0;
                                            while(p7 != null) {
                                                if((p7.getKindSet$ui_release() & 0x2000) != 0) {
                                                    ++v2;
                                                    if(v2 == 1) {
                                                        p6 = p7;
                                                    }
                                                    else {
                                                        if(e1 == null) {
                                                            e1 = new e(new p[16]);
                                                        }
                                                        if(p6 != null) {
                                                            e1.b(p6);
                                                            p6 = null;
                                                        }
                                                        e1.b(p7);
                                                    }
                                                }
                                                p7 = p7.getChild$ui_release();
                                            }
                                            if(v2 != 1) {
                                                p6 = f.f(e1);
                                            }
                                        }
                                        else {
                                            p6 = f.f(e1);
                                        }
                                    }
                                }
                                p5 = p5.getParent$ui_release();
                            }
                        }
                        i1 = i1.u();
                        if(i1 != null) {
                            d0 d01 = i1.b0;
                            if(d01 != null) {
                                p5 = (A0)d01.e;
                                continue;
                            }
                        }
                        p5 = null;
                    }
                    m0 = ((H0.f)p6) == null ? null : ((p)(((H0.f)p6))).getNode();
                }
                else {
                    if(!u1.getNode().isAttached()) {
                        a.b("visitAncestors called on an unattached node");
                    }
                    p p2 = u1.getNode();
                    I i0 = f.v(u1);
                alab2:
                    while(true) {
                        p3 = null;
                        if(i0 == null) {
                            break;
                        }
                        if((((p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0x2000) != 0) {
                            while(p2 != null) {
                                if((p2.getKindSet$ui_release() & 0x2000) != 0) {
                                    e e0 = null;
                                    p3 = p2;
                                    while(p3 != null) {
                                        if(p3 instanceof H0.f) {
                                            break alab2;
                                        }
                                        if((p3.getKindSet$ui_release() & 0x2000) != 0 && p3 instanceof P0.n) {
                                            p p4 = ((P0.n)p3).b;
                                            int v1 = 0;
                                            while(p4 != null) {
                                                if((p4.getKindSet$ui_release() & 0x2000) != 0) {
                                                    ++v1;
                                                    if(v1 == 1) {
                                                        p3 = p4;
                                                    }
                                                    else {
                                                        if(e0 == null) {
                                                            e0 = new e(new p[16]);
                                                        }
                                                        if(p3 != null) {
                                                            e0.b(p3);
                                                            p3 = null;
                                                        }
                                                        e0.b(p4);
                                                    }
                                                }
                                                p4 = p4.getChild$ui_release();
                                            }
                                            if(v1 != 1) {
                                                p3 = f.f(e0);
                                            }
                                        }
                                        else {
                                            p3 = f.f(e0);
                                        }
                                    }
                                }
                                p2 = p2.getParent$ui_release();
                            }
                        }
                        i0 = i0.u();
                        if(i0 != null) {
                            d0 d00 = i0.b0;
                            if(d00 != null) {
                                p2 = (A0)d00.e;
                                continue;
                            }
                        }
                        p2 = null;
                    }
                    if(((H0.f)p3) != null) {
                        m0 = ((p)(((H0.f)p3))).getNode();
                        goto label_125;
                    }
                    goto label_77;
                }
            }
            else {
                if(!u1.getNode().isAttached()) {
                    a.b("visitLocalDescendants called on an unattached node");
                }
                p p0 = u1.getNode();
                if((p0.getAggregateChildKindSet$ui_release() & 0x2400) == 0) {
                    m0 = null;
                }
                else {
                    p p1 = p0.getChild$ui_release();
                    m0 = null;
                    while(p1 != null) {
                        if((p1.getKindSet$ui_release() & 0x2400) != 0) {
                            if((p1.getKindSet$ui_release() & 0x400) != 0) {
                                break;
                            }
                            m0 = p1;
                        }
                        p1 = p1.getChild$ui_release();
                    }
                }
                if(m0 == null) {
                    goto label_29;
                }
            }
        label_125:
            if(m0 != null) {
                if(!m0.getNode().isAttached()) {
                    a.b("visitAncestors called on an unattached node");
                }
                p p8 = m0.getNode().getParent$ui_release();
                I i2 = f.v(m0);
                Collection collection0 = null;
                while(i2 != null) {
                    if((((p)i2.b0.f).getAggregateChildKindSet$ui_release() & 0x2000) != 0) {
                        while(p8 != null) {
                            if((p8.getKindSet$ui_release() & 0x2000) != 0) {
                                p p9 = p8;
                                e e2 = null;
                                while(p9 != null) {
                                    if(p9 instanceof H0.f) {
                                        if(collection0 == null) {
                                            collection0 = new ArrayList();
                                        }
                                        ((List)collection0).add(p9);
                                    }
                                    else if((p9.getKindSet$ui_release() & 0x2000) != 0 && p9 instanceof P0.n) {
                                        p p10 = ((P0.n)p9).b;
                                        int v3 = 0;
                                        while(p10 != null) {
                                            if((p10.getKindSet$ui_release() & 0x2000) != 0) {
                                                ++v3;
                                                if(v3 == 1) {
                                                    p9 = p10;
                                                }
                                                else {
                                                    if(e2 == null) {
                                                        e2 = new e(new p[16]);
                                                    }
                                                    if(p9 != null) {
                                                        e2.b(p9);
                                                        p9 = null;
                                                    }
                                                    e2.b(p10);
                                                }
                                            }
                                            p10 = p10.getChild$ui_release();
                                        }
                                        if(v3 != 1) {
                                            goto label_161;
                                        }
                                        continue;
                                    }
                                label_161:
                                    p9 = f.f(e2);
                                }
                            }
                            p8 = p8.getParent$ui_release();
                        }
                    }
                    i2 = i2.u();
                    if(i2 != null) {
                        d0 d02 = i2.b0;
                        if(d02 != null) {
                            p8 = (A0)d02.e;
                            continue;
                        }
                    }
                    p8 = null;
                }
                if(collection0 != null) {
                    int v4 = collection0.size() - 1;
                    if(v4 >= 0) {
                        while(true) {
                            if(((H0.f)((List)collection0).get(v4)).A(keyEvent0)) {
                                return true;
                            }
                            if(v4 - 1 < 0) {
                                break;
                            }
                            --v4;
                        }
                    }
                }
                p p11 = m0.getNode();
                e e3 = null;
                while(p11 != null) {
                    if(p11 instanceof H0.f) {
                        if(((H0.f)p11).A(keyEvent0)) {
                            return true;
                        }
                    }
                    else if((p11.getKindSet$ui_release() & 0x2000) != 0 && p11 instanceof P0.n) {
                        p p12 = ((P0.n)p11).b;
                        int v5 = 0;
                        while(p12 != null) {
                            if((p12.getKindSet$ui_release() & 0x2000) != 0) {
                                ++v5;
                                if(v5 == 1) {
                                    p11 = p12;
                                }
                                else {
                                    if(e3 == null) {
                                        e3 = new e(new p[16]);
                                    }
                                    if(p11 != null) {
                                        e3.b(p11);
                                        p11 = null;
                                    }
                                    e3.b(p12);
                                }
                            }
                            p12 = p12.getChild$ui_release();
                        }
                        if(v5 != 1) {
                            goto label_207;
                        }
                        continue;
                    }
                label_207:
                    p11 = f.f(e3);
                }
                if(((Boolean)a0.invoke()).booleanValue()) {
                    return true;
                }
                p p13 = m0.getNode();
                e e4 = null;
                while(p13 != null) {
                    if(p13 instanceof H0.f) {
                        if(((H0.f)p13).K(keyEvent0)) {
                            return true;
                        }
                    }
                    else if((p13.getKindSet$ui_release() & 0x2000) != 0 && p13 instanceof P0.n) {
                        p p14 = ((P0.n)p13).b;
                        int v6 = 0;
                        while(p14 != null) {
                            if((p14.getKindSet$ui_release() & 0x2000) != 0) {
                                ++v6;
                                if(v6 == 1) {
                                    p13 = p14;
                                }
                                else {
                                    if(e4 == null) {
                                        e4 = new e(new p[16]);
                                    }
                                    if(p13 != null) {
                                        e4.b(p13);
                                        p13 = null;
                                    }
                                    e4.b(p14);
                                }
                            }
                            p14 = p14.getChild$ui_release();
                        }
                        if(v6 != 1) {
                            goto label_237;
                        }
                        continue;
                    }
                label_237:
                    p13 = f.f(e4);
                }
                if(collection0 != null) {
                    int v7 = collection0.size();
                    for(int v8 = 0; v8 < v7; ++v8) {
                        if(((H0.f)((List)collection0).get(v8)).K(keyEvent0)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        finally {
            Trace.endSection();
        }
    }

    public final Boolean e(int v, c c0, we.k k0) {
        w0.p p1;
        w0.p p0;
        u u0 = this.f;
        u u1 = w0.f.g(u0);
        int v1 = 4;
        n n0 = this.e;
        if(u1 == null) {
            u1 = null;
        }
        else {
            r1.m m0 = (r1.m)n0.get();
            w0.n n1 = u1.n0();
            switch(v) {
                case 1: {
                    p0 = n1.b;
                    break;
                }
                case 2: {
                    p0 = n1.c;
                    break;
                }
                case 3: {
                    switch(m0.ordinal()) {
                        case 0: {
                            p1 = n1.h;
                            break;
                        }
                        case 1: {
                            p1 = n1.i;
                            break;
                        }
                        default: {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                    }
                    if(p1 == w0.p.b) {
                        p1 = null;
                    }
                    p0 = p1 == null ? n1.f : p1;
                    break;
                }
                case 4: {
                    switch(m0.ordinal()) {
                        case 0: {
                            p1 = n1.i;
                            break;
                        }
                        case 1: {
                            p1 = n1.h;
                            break;
                        }
                        default: {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                    }
                    if(p1 == w0.p.b) {
                        p1 = null;
                    }
                    p0 = p1 == null ? n1.g : p1;
                    break;
                }
                case 5: {
                    p0 = n1.d;
                    break;
                }
                case 6: {
                    p0 = n1.e;
                    break;
                }
                case 7: {
                label_42:
                    w0.a a0 = new w0.a(v);
                    w0.f.o(u1);
                    k k1 = (k)((Q0.u)f.w(u1)).getFocusOwner();
                    u u2 = k1.l;
                    if(v == 7) {
                        ((we.k)n1.j).invoke(a0);
                    }
                    else {
                        ((we.k)n1.k).invoke(a0);
                    }
                    if(a0.b) {
                        p0 = w0.p.c;
                    }
                    else {
                        p0 = u2 == k1.l ? w0.p.b : w0.p.d;
                    }
                    break;
                }
                default: {
                    if(v != 8) {
                        throw new IllegalStateException("invalid FocusDirection");
                    }
                    goto label_42;
                }
            }
            if(q.b(p0, w0.p.c)) {
                return null;
            }
            if(q.b(p0, w0.p.d)) {
                u u3 = w0.f.g(u0);
                return u3 == null ? null : ((Boolean)k0.invoke(u3));
            }
            if(!q.b(p0, w0.p.b)) {
                return Boolean.valueOf(p0.a(k0));
            }
        }
        r1.m m1 = (r1.m)n0.get();
        F.g g0 = new F.g(u1, this, k0);
        switch(v) {
            case 1: 
            case 2: {
                return v == 1 ? Boolean.valueOf(w0.f.k(u0, g0)) : Boolean.valueOf(w0.f.a(u0, g0));
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                return w0.f.F(v, g0, u0, c0);
            }
            case 7: {
                int v2 = m1.ordinal();
                if(v2 != 0) {
                    if(v2 != 1) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    v1 = 3;
                }
                u u4 = w0.f.g(u0);
                return u4 == null ? null : w0.f.F(v1, g0, u4, c0);
            }
            case 8: {
                u u5 = null;
                u u6 = w0.f.g(u0);
                boolean z = false;
                if(u6 != null) {
                    if(!u6.getNode().isAttached()) {
                        a.b("visitAncestors called on an unattached node");
                    }
                    p p2 = u6.getNode().getParent$ui_release();
                    I i0 = f.v(u6);
                label_84:
                    while(i0 != null) {
                        if((((p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0x400) != 0) {
                            while(p2 != null) {
                                if((p2.getKindSet$ui_release() & 0x400) != 0) {
                                    p p3 = p2;
                                    e e0 = null;
                                    while(p3 != null) {
                                        if(!(p3 instanceof u)) {
                                            if((p3.getKindSet$ui_release() & 0x400) != 0 && p3 instanceof P0.n) {
                                                p p4 = ((P0.n)p3).b;
                                                int v3 = 0;
                                                while(p4 != null) {
                                                    if((p4.getKindSet$ui_release() & 0x400) != 0) {
                                                        ++v3;
                                                        if(v3 == 1) {
                                                            p3 = p4;
                                                        }
                                                        else {
                                                            if(e0 == null) {
                                                                e0 = new e(new p[16]);
                                                            }
                                                            if(p3 != null) {
                                                                e0.b(p3);
                                                                p3 = null;
                                                            }
                                                            e0.b(p4);
                                                        }
                                                    }
                                                    p4 = p4.getChild$ui_release();
                                                }
                                                if(v3 != 1) {
                                                    goto label_113;
                                                }
                                                continue;
                                            }
                                        }
                                        else if(((u)p3).n0().a) {
                                            u5 = (u)p3;
                                            break label_84;
                                        }
                                    label_113:
                                        p3 = f.f(e0);
                                    }
                                }
                                p2 = p2.getParent$ui_release();
                            }
                        }
                        i0 = i0.u();
                        if(i0 != null) {
                            d0 d00 = i0.b0;
                            if(d00 != null) {
                                p2 = (A0)d00.e;
                                continue;
                            }
                        }
                        p2 = null;
                    }
                }
                if(u5 != null && !u5.equals(u0)) {
                    z = ((Boolean)g0.invoke(u5)).booleanValue();
                }
                return Boolean.valueOf(z);
            }
            default: {
                throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + d.a(v)).toString());
            }
        }
    }

    public final boolean f(int v) {
        kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        h0.a = Boolean.FALSE;
        this.h.getClass();
        u u0 = this.l;
        Boolean boolean0 = this.e(v, ((c)this.d.invoke()), new B(h0, v, 3));
        if(!q.b(boolean0, Boolean.TRUE) || u0 == this.l) {
            if(boolean0 == null || h0.a == null) {
                return false;
            }
            if(!boolean0.equals(Boolean.TRUE) || !q.b(h0.a, Boolean.TRUE)) {
                if(v != 1 && v != 2) {
                    d d0 = new d(v);
                    return ((Boolean)this.b.invoke(d0)).booleanValue();
                }
                else if(this.c(v, false, false)) {
                    Boolean boolean1 = this.e(v, null, new A(v, 2));
                    return boolean1 == null ? false : boolean1.booleanValue();
                }
                return false;
            }
        }
        return true;
    }

    public final void g(u u0) {
        u u1 = this.l;
        this.l = u0;
        Object[] arr_object = this.k.a;
        int v = this.k.b;
        for(int v1 = 0; v1 < v; ++v1) {
            s0.c c0 = (s0.c)arr_object[v1];
            c0.getClass();
            if(u1 != null) {
                I i0 = f.v(u1);
                if(i0 != null) {
                    X0.l l0 = i0.w();
                    if(l0 != null && l0.a.b(X0.k.g)) {
                        ((AutofillManager)c0.a.b).notifyViewExited(c0.c, i0.b);
                    }
                }
            }
            if(u0 != null) {
                I i1 = f.v(u0);
                if(i1 != null) {
                    X0.l l1 = i1.w();
                    if(l1 != null && l1.a.b(X0.k.g)) {
                        int v2 = i1.b;
                        b b0 = new b(c0, v2);
                        c0.d.a.z(v2, b0);
                    }
                }
            }
        }
    }

    public final boolean h(KeyEvent keyEvent0) {
        int v55;
        int v29;
        int v18;
        long[] arr_v8;
        long[] arr_v7;
        long[] arr_v6;
        int v13;
        long v = H0.e.J(keyEvent0);
        int v1 = H0.e.K(keyEvent0);
        int v2 = 0;
        if(v1 == 2) {
            D d0 = this.j;
            if(d0 == null) {
                d0 = new D(3);
                this.j = d0;
            }
            int v3 = Long.hashCode(v);
            int v4 = v3 * 0xCC9E2D51 ^ v3 * 0xCC9E2D51 << 16;
            int v5 = d0.c;
            int v6 = v4 >>> 7 & v5;
            int v7 = 0;
            while(true) {
                int v8 = (v6 & 7) << 3;
                long v9 = d0.a[v6 >> 3] >>> v8 | d0.a[(v6 >> 3) + 1] << 0x40 - v8 & -((long)v8) >> 0x3F;
                long v10 = v9 ^ ((long)(v4 & 0x7F)) * 0x101010101010101L;
                for(long v11 = v10 - 0x101010101010101L & ~v10 & 0x8080808080808080L; v11 != 0L; v11 &= v11 - 1L) {
                    int v12 = v6 + (Long.numberOfTrailingZeros(v11) >> 3) & v5;
                    if(d0.b[v12] == v) {
                        v13 = v12;
                        d0.b[v13] = v;
                        return true;
                    }
                }
                if((v9 & ~v9 << 6 & 0x8080808080808080L) == 0L) {
                    goto label_124;
                }
                else {
                    int v14 = d0.b(v4 >>> 7);
                    if(d0.e == 0 && (d0.a[v14 >> 3] >> ((v14 & 7) << 3) & 0xFFL) != 0xFEL) {
                        if(d0.c <= 8 || Long.compareUnsigned(((long)d0.d) * 0x20L, ((long)d0.c) * 25L) > 0) {
                            v18 = v4 >>> 7;
                            long[] arr_v2 = d0.a;
                            long[] arr_v3 = d0.b;
                            int v31 = d0.c;
                            d0.c(S.c(d0.c));
                            long[] arr_v4 = d0.a;
                            long[] arr_v5 = d0.b;
                            int v32 = d0.c;
                            int v33 = 0;
                            while(v33 < v31) {
                                if((arr_v2[v33 >> 3] >> ((v33 & 7) << 3) & 0xFFL) < 0x80L) {
                                    long v34 = arr_v3[v33];
                                    int v35 = Long.hashCode(v34);
                                    int v36 = v35 * 0xCC9E2D51 ^ v35 * 0xCC9E2D51 << 16;
                                    arr_v6 = arr_v4;
                                    int v37 = d0.b(v36 >>> 7);
                                    arr_v7 = arr_v2;
                                    arr_v8 = arr_v3;
                                    int v38 = (v37 & 7) << 3;
                                    long v39 = arr_v6[v37 >> 3] & ~(0xFFL << v38) | ((long)(v36 & 0x7F)) << v38;
                                    arr_v6[v37 >> 3] = v39;
                                    arr_v6[(v37 - 7 & v32) + (v32 & 7) >> 3] = v39;
                                    arr_v5[v37] = v34;
                                }
                                else {
                                    arr_v6 = arr_v4;
                                    arr_v7 = arr_v2;
                                    arr_v8 = arr_v3;
                                }
                                ++v33;
                                arr_v4 = arr_v6;
                                arr_v2 = arr_v7;
                                arr_v3 = arr_v8;
                            }
                        }
                        else {
                            long[] arr_v = d0.a;
                            int v15 = d0.c;
                            long[] arr_v1 = d0.b;
                            for(int v16 = 0; v16 < v15 + 7 >> 3; ++v16) {
                                long v17 = arr_v[v16] & 0x8080808080808080L;
                                arr_v[v16] = 0xFEFEFEFEFEFEFEFEL & ~v17 + (v17 >>> 7);
                            }
                            v18 = v4 >>> 7;
                            int v19 = je.n.k0(arr_v);
                            arr_v[v19 - 1] |= 0xFF00000000000000L;
                            arr_v[v19] = arr_v[0];
                            int v20 = 0;
                            while(v20 != v15) {
                                int v21 = (v20 & 7) << 3;
                                long v22 = arr_v[v20 >> 3] >> v21 & 0xFFL;
                                if(v22 != 0x80L && v22 == 0xFEL) {
                                    int v23 = Long.hashCode(arr_v1[v20]);
                                    int v24 = v23 * 0xCC9E2D51 ^ v23 * 0xCC9E2D51 << 16;
                                    int v25 = d0.b(v24 >>> 7);
                                    int v26 = v24 >>> 7 & v15;
                                    if((v25 - v26 & v15) / 8 == (v20 - v26 & v15) / 8) {
                                        arr_v[v20 >> 3] = arr_v[v20 >> 3] & ~(0xFFL << v21) | ((long)(v24 & 0x7F)) << v21;
                                        arr_v[arr_v.length - 1] = arr_v[0] & 0xFFFFFFFFFFFFFFL | 0x8000000000000000L;
                                        ++v20;
                                    }
                                    else {
                                        long v27 = arr_v[v25 >> 3];
                                        int v28 = (v25 & 7) << 3;
                                        if((v27 >> v28 & 0xFFL) == 0x80L) {
                                            arr_v[v25 >> 3] = v27 & ~(0xFFL << v28) | ((long)(v24 & 0x7F)) << v28;
                                            arr_v[v20 >> 3] = arr_v[v20 >> 3] & ~(0xFFL << v21) | 0x80L << v21;
                                            arr_v1[v25] = arr_v1[v20];
                                            arr_v1[v20] = 0L;
                                            v29 = v20;
                                        }
                                        else {
                                            arr_v[v25 >> 3] = ((long)(v24 & 0x7F)) << v28 | v27 & ~(0xFFL << v28);
                                            long v30 = arr_v1[v25];
                                            arr_v1[v25] = arr_v1[v20];
                                            arr_v1[v20] = v30;
                                            v29 = v20 - 1;
                                        }
                                        arr_v[arr_v.length - 1] = arr_v[0] & 0xFFFFFFFFFFFFFFL | 0x8000000000000000L;
                                        v20 = v29 + 1;
                                    }
                                }
                                else {
                                    ++v20;
                                }
                            }
                            d0.e = S.a(d0.c) - d0.d;
                        }
                        v14 = d0.b(v18);
                    }
                    v13 = v14;
                    ++d0.d;
                    int v40 = d0.e;
                    long[] arr_v9 = d0.a;
                    long v41 = arr_v9[v13 >> 3];
                    int v42 = (v13 & 7) << 3;
                    if((v41 >> v42 & 0xFFL) == 0x80L) {
                        v2 = true;
                    }
                    d0.e = v40 - v2;
                    int v43 = d0.c;
                    long v44 = v41 & ~(0xFFL << v42) | ((long)(v4 & 0x7F)) << v42;
                    arr_v9[v13 >> 3] = v44;
                    arr_v9[(v13 - 7 & v43) + (v43 & 7) >> 3] = v44;
                }
                d0.b[v13] = v;
                return true;
            label_124:
                v7 += 8;
                v6 = v6 + v7 & v5;
            }
        }
        if(v1 == 1) {
            if(this.j == null || !this.j.a(v)) {
                return false;
            }
            D d1 = this.j;
            if(d1 != null) {
                int v45 = Long.hashCode(v);
                int v46 = v45 * 0xCC9E2D51 ^ v45 * 0xCC9E2D51 << 16;
                int v47 = d1.c;
                int v48 = v46 >>> 7;
                while(true) {
                    int v49 = v48 & v47;
                    int v50 = (v49 & 7) << 3;
                    long v51 = d1.a[(v49 >> 3) + 1] << 0x40 - v50 & -((long)v50) >> 0x3F | d1.a[v49 >> 3] >>> v50;
                    long v52 = ((long)(v46 & 0x7F)) * 0x101010101010101L ^ v51;
                    long v53 = ~v52 & v52 - 0x101010101010101L & 0x8080808080808080L;
                    while(v53 != 0L) {
                        int v54 = (Long.numberOfTrailingZeros(v53) >> 3) + v49 & v47;
                        if(d1.b[v54] == v) {
                            v55 = v54;
                            goto label_149;
                        }
                        v53 &= v53 - 1L;
                    }
                    if((v51 & ~v51 << 6 & 0x8080808080808080L) == 0L) {
                        v2 += 8;
                        v48 = v49 + v2;
                        continue;
                    }
                    else {
                        v55 = -1;
                    }
                label_149:
                    if(v55 >= 0) {
                        --d1.d;
                        long[] arr_v10 = d1.a;
                        int v56 = d1.c;
                        int v57 = (v55 & 7) << 3;
                        long v58 = arr_v10[v55 >> 3] & ~(0xFFL << v57) | 0xFEL << v57;
                        arr_v10[v55 >> 3] = v58;
                        arr_v10[(v55 - 7 & v56) + (v56 & 7) >> 3] = v58;
                        return true;
                    }
                    return true;
                }
                return false;
            }
        }
        return true;
    }
}

