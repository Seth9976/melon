package w0;

import F.g;
import M.x;
import M0.a;
import N0.g0;
import P0.A0;
import P0.I;
import P0.d0;
import P0.j0;
import P0.n;
import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.lazy.layout.i;
import androidx.compose.foundation.lazy.layout.l;
import androidx.compose.foundation.lazy.layout.m;
import g0.e;
import i.n.i.b.a.s.e.M3;
import java.util.Arrays;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import r0.p;
import we.k;
import x0.c;

public abstract class f {
    public static final int[] a;

    static {
        f.a = new int[2];
    }

    public static final Object A(u u0, int v, k k0) {
        Object object0;
        int v2;
        int v1;
        if(!u0.getNode().isAttached()) {
            a.b("visitAncestors called on an unattached node");
        }
        p p0 = u0.getNode().getParent$ui_release();
        I i0 = P0.f.v(u0);
    alab1:
        while(true) {
            p p1 = null;
            v1 = 0;
            v2 = 1;
            object0 = null;
            if(i0 == null) {
                break;
            }
            if((((p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0x400) != 0) {
                while(p0 != null) {
                    if((p0.getKindSet$ui_release() & 0x400) != 0) {
                        p1 = p0;
                        e e0 = null;
                        while(p1 != null) {
                            if(p1 instanceof u) {
                                break alab1;
                            }
                            if((p1.getKindSet$ui_release() & 0x400) != 0 && p1 instanceof n) {
                                p p2 = ((n)p1).b;
                                int v3 = 0;
                                while(p2 != null) {
                                    if((p2.getKindSet$ui_release() & 0x400) != 0) {
                                        ++v3;
                                        if(v3 == 1) {
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
                                if(v3 != 1) {
                                    p1 = P0.f.f(e0);
                                }
                            }
                            else {
                                p1 = P0.f.f(e0);
                            }
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
        if(((u)p1) == null || !q.b(((m)((u)p1).a(N0.f.a)), ((m)u0.a(N0.f.a)))) {
            m m0 = (m)u0.a(N0.f.a);
            if(m0 != null) {
                if(v == 5 || v == 6) {
                    v2 = 5;
                }
                else if(v != 3) {
                    switch(v) {
                        case 1: {
                            v2 = 2;
                            break;
                        }
                        case 2: {
                            break;
                        }
                        case 4: {
                            v2 = 3;
                            break;
                        }
                        default: {
                            throw new IllegalStateException("Unsupported direction for beyond bounds layout");
                        }
                    }
                }
                else {
                    v2 = 3;
                }
                if(m0.a.getItemCount() > 0 && m0.a.b() && m0.isAttached()) {
                    int v4 = m0.n0(v2) ? m0.a.d() : m0.a.c();
                    H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    I.a a0 = m0.b;
                    a0.getClass();
                    i i1 = new i(v4, v4);
                    a0.a.b(i1);
                    h0.a = i1;
                    int v5 = m0.a.a() * 2;
                    int v6 = m0.a.getItemCount();
                    if(v5 > v6) {
                        v5 = v6;
                    }
                    while(object0 == null && m0.m0(((i)h0.a), v2) && v1 < v5) {
                        int v7 = ((i)h0.a).a;
                        int v8 = ((i)h0.a).b;
                        if(m0.n0(v2)) {
                            ++v8;
                        }
                        else {
                            --v7;
                        }
                        I.a a1 = m0.b;
                        a1.getClass();
                        i i2 = new i(v7, v8);
                        a1.a.b(i2);
                        m0.b.a.j(((i)h0.a));
                        h0.a = i2;
                        ++v1;
                        P0.f.v(m0).l();
                        object0 = k0.invoke(new l(m0, h0, v2));
                    }
                    m0.b.a.j(((i)h0.a));
                    P0.f.v(m0).l();
                    return object0;
                }
                return k0.invoke(m.e);
            }
        }
        return null;
    }

    public static final boolean B(int v, g g0, u u0, c c0) {
        e e2;
        p p1;
        e e0 = new e(new u[16]);
        if(!u0.getNode().isAttached()) {
            a.b("visitChildren called on an unattached node");
        }
        e e1 = new e(new p[16]);
        p p0 = u0.getNode().getChild$ui_release();
        if(p0 == null) {
            P0.f.b(e1, u0.getNode());
        }
        else {
            e1.b(p0);
        }
    alab1:
        while(true) {
        alab2:
            while(true) {
                int v1 = e1.c;
                if(v1 == 0) {
                    break alab1;
                }
                p1 = (p)e1.k(v1 - 1);
                if((p1.getAggregateChildKindSet$ui_release() & 0x400) == 0) {
                    P0.f.b(e1, p1);
                }
                else {
                    while(true) {
                        if(p1 == null) {
                            continue alab1;
                        }
                        if((p1.getKindSet$ui_release() & 0x400) == 0) {
                            p1 = p1.getChild$ui_release();
                            continue;
                        }
                        e2 = null;
                    label_20:
                        if(p1 == null) {
                            break;
                        }
                        break alab2;
                    }
                }
            }
            if(!(p1 instanceof u)) {
                if((p1.getKindSet$ui_release() & 0x400) != 0 && p1 instanceof n) {
                    p p2 = ((n)p1).b;
                    int v2 = 0;
                    while(p2 != null) {
                        if((p2.getKindSet$ui_release() & 0x400) != 0) {
                            ++v2;
                            if(v2 == 1) {
                                p1 = p2;
                            }
                            else {
                                if(e2 == null) {
                                    e2 = new e(new p[16]);
                                }
                                if(p1 != null) {
                                    e2.b(p1);
                                    p1 = null;
                                }
                                e2.b(p2);
                            }
                        }
                        p2 = p2.getChild$ui_release();
                    }
                    if(v2 != 1) {
                        p1 = P0.f.f(e2);
                    }
                    goto label_20;
                }
            }
            else if(((u)p1).isAttached()) {
                e0.b(((u)p1));
            }
            p1 = P0.f.f(e2);
            goto label_20;
        }
        while(e0.c != 0) {
            u u1 = f.h(e0, c0, v);
            if(u1 == null) {
                break;
            }
            if(u1.n0().a) {
                return ((Boolean)g0.invoke(u1)).booleanValue();
            }
            if(f.l(v, g0, u1, c0)) {
                return true;
            }
            e0.j(u1);
        }
        return false;
    }

    public static final boolean C(u u0, u u1, int v, g g0) {
        e e1;
        p p1;
        if(u0.o0() != t.b) {
            throw new IllegalStateException("This function should only be used within a parent that has focus.");
        }
        u[] arr_u = new u[16];
        if(!u0.getNode().isAttached()) {
            a.b("visitChildren called on an unattached node");
        }
        e e0 = new e(new p[16]);
        p p0 = u0.getNode().getChild$ui_release();
        if(p0 == null) {
            P0.f.b(e0, u0.getNode());
        }
        else {
            e0.b(p0);
        }
        int v1 = 0;
    alab1:
        while(true) {
        alab2:
            while(true) {
                int v2 = e0.c;
                if(v2 == 0) {
                    break alab1;
                }
                p1 = (p)e0.k(v2 - 1);
                if((p1.getAggregateChildKindSet$ui_release() & 0x400) == 0) {
                    P0.f.b(e0, p1);
                }
                else {
                    while(true) {
                        if(p1 == null) {
                            continue alab1;
                        }
                        if((p1.getKindSet$ui_release() & 0x400) == 0) {
                            p1 = p1.getChild$ui_release();
                            continue;
                        }
                        e1 = null;
                    label_22:
                        if(p1 == null) {
                            break;
                        }
                        break alab2;
                    }
                }
            }
            if(p1 instanceof u) {
                if(arr_u.length < v1 + 1) {
                    Object[] arr_object = new Object[Math.max(v1 + 1, arr_u.length * 2)];
                    System.arraycopy(arr_u, 0, arr_object, 0, arr_u.length);
                    arr_u = arr_object;
                }
                arr_u[v1] = (u)p1;
                ++v1;
            }
            else if((p1.getKindSet$ui_release() & 0x400) != 0 && p1 instanceof n) {
                p p2 = ((n)p1).b;
                int v3 = 0;
                while(p2 != null) {
                    if((p2.getKindSet$ui_release() & 0x400) != 0) {
                        ++v3;
                        if(v3 == 1) {
                            p1 = p2;
                        }
                        else {
                            if(e1 == null) {
                                e1 = new e(new p[16]);
                            }
                            if(p1 != null) {
                                e1.b(p1);
                                p1 = null;
                            }
                            e1.b(p2);
                        }
                    }
                    p2 = p2.getChild$ui_release();
                }
                if(v3 != 1) {
                    p1 = P0.f.f(e1);
                }
                goto label_22;
            }
            p1 = P0.f.f(e1);
            goto label_22;
        }
        Arrays.sort(arr_u, 0, v1, w.a);
        if(v == 1) {
            Ce.g g1 = P4.a.K(0, v1);
            int v4 = g1.a;
            int v5 = g1.b;
            if(v4 > v5) {
                goto label_82;
            }
            boolean z = false;
            while(true) {
                if(z) {
                    u u2 = arr_u[v4];
                    if(!f.s(u2) || !f.k(u2, g0)) {
                        goto label_62;
                    }
                    return true;
                }
            label_62:
                if(q.b(arr_u[v4], u1)) {
                    z = true;
                }
                if(v4 == v5) {
                    goto label_82;
                }
                ++v4;
            }
        }
        if(v != 2) {
            throw new IllegalStateException("This function should only be used for 1-D focus search");
        }
        Ce.g g2 = P4.a.K(0, v1);
        int v6 = g2.a;
        int v7 = g2.b;
        if(v6 <= v7) {
            boolean z1 = false;
            while(true) {
                if(z1) {
                    u u3 = arr_u[v7];
                    if(f.s(u3) && f.a(u3, g0)) {
                        return true;
                    }
                }
                if(q.b(arr_u[v7], u1)) {
                    z1 = true;
                }
                if(v7 == v6) {
                    break;
                }
                --v7;
            }
        }
    label_82:
        if(v != 1 && u0.n0().a) {
            if(!u0.getNode().isAttached()) {
                a.b("visitAncestors called on an unattached node");
            }
            p p3 = u0.getNode().getParent$ui_release();
            I i0 = P0.f.v(u0);
            while(i0 != null) {
                if((((p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0x400) != 0) {
                    while(p3 != null) {
                        if((p3.getKindSet$ui_release() & 0x400) != 0) {
                            p p4 = p3;
                            e e2 = null;
                            while(p4 != null) {
                                if(p4 instanceof u) {
                                    return p4 == null ? false : ((Boolean)g0.invoke(u0)).booleanValue();
                                }
                                if((p4.getKindSet$ui_release() & 0x400) != 0 && p4 instanceof n) {
                                    p p5 = ((n)p4).b;
                                    int v8 = 0;
                                    while(p5 != null) {
                                        if((p5.getKindSet$ui_release() & 0x400) != 0) {
                                            ++v8;
                                            if(v8 == 1) {
                                                p4 = p5;
                                            }
                                            else {
                                                if(e2 == null) {
                                                    e2 = new e(new p[16]);
                                                }
                                                if(p4 != null) {
                                                    e2.b(p4);
                                                    p4 = null;
                                                }
                                                e2.b(p5);
                                            }
                                        }
                                        p5 = p5.getChild$ui_release();
                                    }
                                    if(v8 != 1) {
                                        p4 = P0.f.f(e2);
                                    }
                                }
                                else {
                                    p4 = P0.f.f(e2);
                                }
                            }
                        }
                        p3 = p3.getParent$ui_release();
                    }
                }
                i0 = i0.u();
                if(i0 != null) {
                    d0 d00 = i0.b0;
                    if(d00 != null) {
                        p3 = (A0)d00.e;
                        continue;
                    }
                }
                p3 = null;
            }
            return false;
        }
        return false;
    }

    public static final Integer D(int v) {
        switch(v) {
            case 1: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 17;
            }
            case 4: {
                return 66;
            }
            case 5: {
                return 33;
            }
            case 6: {
                return 130;
            }
            default: {
                return null;
            }
        }
    }

    public static final d E(int v) {
        switch(v) {
            case 1: {
                return new d(2);
            }
            case 2: {
                return new d(1);
            }
            case 17: {
                return new d(3);
            }
            case 33: {
                return new d(5);
            }
            case 66: {
                return new d(4);
            }
            case 130: {
                return new d(6);
            }
            default: {
                return null;
            }
        }
    }

    public static final Boolean F(int v, g g0, u u0, c c0) {
        int v1 = u0.o0().ordinal();
        if(v1 != 0) {
            switch(v1) {
                case 1: {
                    u u1 = f.n(u0);
                    if(u1 != null) {
                        switch(u1.o0().ordinal()) {
                            case 1: {
                                Boolean boolean0 = f.F(v, g0, u1, c0);
                                if(!q.b(boolean0, Boolean.FALSE)) {
                                    return boolean0;
                                }
                                if(c0 == null) {
                                    if(u1.o0() != t.b) {
                                        throw new IllegalStateException("Searching for active node in inactive hierarchy");
                                    }
                                    u u2 = f.g(u1);
                                    if(u2 == null) {
                                        throw new IllegalStateException("ActiveParent must have a focusedChild");
                                    }
                                    return Boolean.valueOf(f.l(v, g0, u0, f.j(u2)));
                                }
                                return Boolean.valueOf(f.l(v, g0, u0, c0));
                            }
                            case 0: 
                            case 2: {
                                if(c0 == null) {
                                    c0 = f.j(u1);
                                }
                                return Boolean.valueOf(f.l(v, g0, u0, c0));
                            }
                            case 3: {
                                throw new IllegalStateException("ActiveParent must have a focusedChild");
                            }
                            default: {
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                        }
                    }
                    throw new IllegalStateException("ActiveParent must have a focusedChild");
                }
                case 2: {
                    break;
                }
                case 3: {
                    if(u0.n0().a) {
                        return (Boolean)g0.invoke(u0);
                    }
                    return c0 == null ? Boolean.valueOf(f.i(u0, v, g0)) : Boolean.valueOf(f.B(v, g0, u0, c0));
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
        return Boolean.valueOf(f.i(u0, v, g0));
    }

    public static final boolean a(u u0, g g0) {
        int v = u0.o0().ordinal();
        if(v != 0) {
            switch(v) {
                case 1: {
                    u u1 = f.n(u0);
                    if(u1 != null) {
                        switch(u1.o0().ordinal()) {
                            case 1: {
                                return f.a(u1, g0) || f.m(u0, u1, 2, g0) || u1.n0().a && ((Boolean)g0.invoke(u1)).booleanValue();
                            }
                            case 0: 
                            case 2: {
                                return f.m(u0, u1, 2, g0);
                            }
                            case 3: {
                                throw new IllegalStateException("ActiveParent must have a focusedChild");
                            }
                            default: {
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                        }
                    }
                    throw new IllegalStateException("ActiveParent must have a focusedChild");
                }
                case 2: {
                    break;
                }
                case 3: {
                    if(!f.x(u0, g0)) {
                        return u0.n0().a ? ((Boolean)g0.invoke(u0)).booleanValue() : false;
                    }
                    return true;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
        return f.x(u0, g0);
    }

    public static final boolean b(c c0, c c1, c c2, int v) {
        float f8;
        boolean z = f.c(v, c2, c0);
        float f = c2.b;
        float f1 = c2.d;
        float f2 = c2.a;
        float f3 = c2.c;
        float f4 = c0.d;
        float f5 = c0.b;
        float f6 = c0.c;
        float f7 = c0.a;
        if(!z && f.c(v, c1, c0)) {
            switch(v) {
                case 3: {
                    if(f7 >= f3) {
                        goto label_19;
                    }
                    break;
                }
                case 4: {
                    if(f6 <= f2) {
                        goto label_19;
                    }
                    break;
                }
                case 5: {
                    if(f5 >= f1) {
                        goto label_19;
                    }
                    break;
                }
                case 6: {
                    if(f4 <= f) {
                    label_19:
                        switch(v) {
                            case 3: 
                            case 4: {
                                break;
                            }
                            case 5: {
                                f8 = f5 - c1.d;
                                goto label_24;
                            }
                            case 6: {
                                f8 = c1.b - f4;
                            label_24:
                                if(f8 < 0.0f) {
                                    f8 = 0.0f;
                                }
                                float f9 = v == 5 ? f5 - f : f1 - f4;
                                if(f9 < 1.0f) {
                                    f9 = 1.0f;
                                }
                                return f8 < f9;
                            }
                            default: {
                                throw new IllegalStateException("This function should only be used for 2-D focus search");
                            }
                        }
                    }
                    break;
                }
                default: {
                    throw new IllegalStateException("This function should only be used for 2-D focus search");
                }
            }
            return true;
        }
        return false;
    }

    public static final boolean c(int v, c c0, c c1) {
        switch(v) {
            case 3: 
            case 4: {
                return c0.d > c1.b && c0.b < c1.d;
            }
            case 5: 
            case 6: {
                return c0.c > c1.a && c0.a < c1.c;
            }
            default: {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
        }
    }

    public static final c d(View view0, Q0.u u0) {
        view0.getLocationInWindow(f.a);
        int v = f.a[0];
        int v1 = f.a[1];
        u0.getLocationInWindow(f.a);
        float f = (float)(v - f.a[0]);
        float f1 = (float)(v1 - f.a[1]);
        return new c(f, f1, ((float)view0.getWidth()) + f, ((float)view0.getHeight()) + f1);
    }

    public static final boolean e(u u0, boolean z) {
        switch(u0.o0().ordinal()) {
            case 0: {
                ((w0.k)((Q0.u)P0.f.w(u0)).getFocusOwner()).g(null);
                u0.m0(t.a, t.d);
                return true;
            }
            case 1: {
                u u1 = f.n(u0);
                if((u1 == null ? true : f.e(u1, z))) {
                    u0.m0(t.b, t.d);
                    return true;
                }
                return false;
            }
            case 2: {
                if(z) {
                    ((w0.k)((Q0.u)P0.f.w(u0)).getFocusOwner()).g(null);
                    u0.m0(t.c, t.d);
                }
                return z;
            }
            case 3: {
                return true;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static final void f(u u0, e e0) {
        e e2;
        p p1;
        if(!u0.getNode().isAttached()) {
            a.b("visitChildren called on an unattached node");
        }
        e e1 = new e(new p[16]);
        p p0 = u0.getNode().getChild$ui_release();
        if(p0 == null) {
            P0.f.b(e1, u0.getNode());
        }
        else {
            e1.b(p0);
        }
    alab1:
        while(true) {
        alab2:
            while(true) {
                int v = e1.c;
                if(v == 0) {
                    break alab1;
                }
                p1 = (p)e1.k(v - 1);
                if((p1.getAggregateChildKindSet$ui_release() & 0x400) == 0) {
                    P0.f.b(e1, p1);
                }
                else {
                    while(true) {
                        if(p1 == null) {
                            continue alab1;
                        }
                        if((p1.getKindSet$ui_release() & 0x400) == 0) {
                            p1 = p1.getChild$ui_release();
                            continue;
                        }
                        e2 = null;
                    label_19:
                        if(p1 == null) {
                            break;
                        }
                        break alab2;
                    }
                }
            }
            if(!(p1 instanceof u)) {
                if((p1.getKindSet$ui_release() & 0x400) != 0 && p1 instanceof n) {
                    p p2 = ((n)p1).b;
                    int v1 = 0;
                    while(p2 != null) {
                        if((p2.getKindSet$ui_release() & 0x400) != 0) {
                            ++v1;
                            if(v1 == 1) {
                                p1 = p2;
                            }
                            else {
                                if(e2 == null) {
                                    e2 = new e(new p[16]);
                                }
                                if(p1 != null) {
                                    e2.b(p1);
                                    p1 = null;
                                }
                                e2.b(p2);
                            }
                        }
                        p2 = p2.getChild$ui_release();
                    }
                    if(v1 != 1) {
                        p1 = P0.f.f(e2);
                    }
                    goto label_19;
                }
            }
            else if(((u)p1).isAttached() && !P0.f.v(((u)p1)).l0) {
                if(((u)p1).n0().a) {
                    e0.b(((u)p1));
                }
                else {
                    f.f(((u)p1), e0);
                }
            }
            p1 = P0.f.f(e2);
            goto label_19;
        }
    }

    public static final u g(u u0) {
        u u1 = ((w0.k)((Q0.u)P0.f.w(u0)).getFocusOwner()).l;
        return u1 == null || !u1.isAttached() ? null : u1;
    }

    public static final u h(e e0, c c0, int v) {
        c c1;
        switch(v) {
            case 3: {
                c1 = c0.g(c0.c - c0.a + 1.0f, 0.0f);
                break;
            }
            case 4: {
                c1 = c0.g(-(c0.c - c0.a + 1.0f), 0.0f);
                break;
            }
            case 5: {
                c1 = c0.g(0.0f, c0.d - c0.b + 1.0f);
                break;
            }
            case 6: {
                c1 = c0.g(0.0f, -(c0.d - c0.b + 1.0f));
                break;
            }
            default: {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
        }
        Object[] arr_object = e0.a;
        int v1 = e0.c;
        u u0 = null;
        for(int v2 = 0; v2 < v1; ++v2) {
            u u1 = (u)arr_object[v2];
            if(f.s(u1)) {
                c c2 = f.j(u1);
                if(f.p(c2, c1, c0, v)) {
                    u0 = u1;
                    c1 = c2;
                }
            }
        }
        return u0;
    }

    public static final boolean i(u u0, int v, k k0) {
        c c1;
        c c0;
        e e0 = new e(new u[16]);
        f.f(u0, e0);
        int v1 = e0.c;
        if(v1 <= 1) {
            Object object0 = v1 == 0 ? null : e0.a[0];
            return ((u)object0) == null ? false : ((Boolean)k0.invoke(((u)object0))).booleanValue();
        }
        switch(v) {
            case 3: 
            case 5: {
                c c2 = f.j(u0);
                c1 = new c(c2.c, c2.d, c2.c, c2.d);
                break;
            }
            case 4: 
            case 6: {
                c0 = f.j(u0);
                c1 = new c(c0.a, c0.b, c0.a, c0.b);
                break;
            }
            case 7: {
                v = 4;
                c0 = f.j(u0);
                c1 = new c(c0.a, c0.b, c0.a, c0.b);
                break;
            }
            default: {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
        }
        u u1 = f.h(e0, c1, v);
        return u1 == null ? false : ((Boolean)k0.invoke(u1)).booleanValue();
    }

    public static final c j(u u0) {
        j0 j00 = u0.getCoordinator$ui_release();
        return j00 == null ? c.e : g0.g(j00).f(j00, false);
    }

    public static final boolean k(u u0, g g0) {
        switch(u0.o0().ordinal()) {
            case 1: {
                u u1 = f.n(u0);
                if(u1 == null) {
                    throw new IllegalStateException("ActiveParent must have a focusedChild");
                }
                return f.k(u1, g0) || f.m(u0, u1, 1, g0);
            }
            case 0: 
            case 2: {
                return f.y(u0, g0);
            }
            case 3: {
                return u0.n0().a ? ((Boolean)g0.invoke(u0)).booleanValue() : f.y(u0, g0);
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static final boolean l(int v, g g0, u u0, c c0) {
        if(f.B(v, g0, u0, c0)) {
            return true;
        }
        v v1 = ((w0.k)((Q0.u)P0.f.w(u0)).getFocusOwner()).h;
        v1.getClass();
        Boolean boolean0 = (Boolean)f.A(u0, v, new x(v1, ((w0.k)((Q0.u)P0.f.w(u0)).getFocusOwner()).l, u0, c0, v, g0, 2));
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    public static final boolean m(u u0, u u1, int v, g g0) {
        if(f.C(u0, u1, v, g0)) {
            return true;
        }
        v v1 = ((w0.k)((Q0.u)P0.f.w(u0)).getFocusOwner()).h;
        v1.getClass();
        Boolean boolean0 = (Boolean)f.A(u0, v, new x(v1, ((w0.k)((Q0.u)P0.f.w(u0)).getFocusOwner()).l, u0, u1, v, g0, 1));
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    public static final u n(u u0) {
        e e1;
        p p1;
        if(u0.getNode().isAttached()) {
            if(!u0.getNode().isAttached()) {
                a.b("visitChildren called on an unattached node");
            }
            e e0 = new e(new p[16]);
            p p0 = u0.getNode().getChild$ui_release();
            if(p0 == null) {
                P0.f.b(e0, u0.getNode());
            }
            else {
                e0.b(p0);
            }
        alab1:
            while(true) {
            alab2:
                while(true) {
                    int v = e0.c;
                    if(v == 0) {
                        break alab1;
                    }
                    p1 = (p)e0.k(v - 1);
                    if((p1.getAggregateChildKindSet$ui_release() & 0x400) == 0) {
                        P0.f.b(e0, p1);
                    }
                    else {
                        while(true) {
                            if(p1 == null) {
                                continue alab1;
                            }
                            if((p1.getKindSet$ui_release() & 0x400) == 0) {
                                p1 = p1.getChild$ui_release();
                                continue;
                            }
                            e1 = null;
                        label_20:
                            if(p1 == null) {
                                break;
                            }
                            break alab2;
                        }
                    }
                }
                if(p1 instanceof u) {
                    if(((u)p1).getNode().isAttached()) {
                        int v1 = ((u)p1).o0().ordinal();
                        if(v1 == 0 || v1 == 1 || v1 == 2) {
                            return (u)p1;
                        }
                    }
                }
                else if((p1.getKindSet$ui_release() & 0x400) != 0 && p1 instanceof n) {
                    p p2 = ((n)p1).b;
                    int v2 = 0;
                    while(p2 != null) {
                        if((p2.getKindSet$ui_release() & 0x400) != 0) {
                            ++v2;
                            if(v2 == 1) {
                                p1 = p2;
                            }
                            else {
                                if(e1 == null) {
                                    e1 = new e(new p[16]);
                                }
                                if(p1 != null) {
                                    e1.b(p1);
                                    p1 = null;
                                }
                                e1.b(p2);
                            }
                        }
                        p2 = p2.getChild$ui_release();
                    }
                    if(v2 != 1) {
                        p1 = P0.f.f(e1);
                    }
                    goto label_20;
                }
                p1 = P0.f.f(e1);
                goto label_20;
            }
        }
        return null;
    }

    public static final void o(u u0) {
        boolean z = u0.getNode().getCoordinator$ui_release() == null;
    }

    // 去混淆评级： 低(40)
    public static final boolean p(c c0, c c1, c c2, int v) {
        return f.q(v, c0, c2) && (!f.q(v, c1, c2) || f.b(c2, c0, c1, v) || !f.b(c2, c1, c0, v) && f.r(v, c2, c0) < f.r(v, c2, c1));
    }

    public static final boolean q(int v, c c0, c c1) {
        float f = c0.b;
        float f1 = c0.d;
        float f2 = c0.a;
        float f3 = c0.c;
        if(v == 3) {
            return (c1.c > f3 || c1.a >= f3) && c1.a > f2;
        }
        switch(v) {
            case 4: {
                return (c1.a < f2 || c1.c <= f2) && c1.c < f3;
            }
            case 5: {
                return (c1.d > f1 || c1.b >= f1) && c1.b > f;
            }
            case 6: {
                return (c1.b < f || c1.d <= f) && c1.d < f1;
            }
            default: {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
        }
    }

    public static final long r(int v, c c0, c c1) {
        float f5;
        float f4;
        float f = c1.b;
        float f1 = c1.d;
        float f2 = c1.a;
        float f3 = c1.c;
        if(v == 3) {
            f4 = c0.a - f3;
        }
        else {
            if(v == 4) {
                f4 = f2 - c0.c;
                goto label_15;
            }
            if(v == 5) {
                f4 = c0.b - f1;
            }
            else if(v == 6) {
                f4 = f - c0.d;
            }
            else {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
        }
    label_15:
        if(f4 < 0.0f) {
            f4 = 0.0f;
        }
        switch(v) {
            case 3: 
            case 4: {
                f5 = (c0.d - c0.b) / 2.0f + c0.b - ((f1 - f) / 2.0f + f);
                return ((long)f5) * ((long)f5) + 13L * ((long)f4) * ((long)f4);
            }
            case 5: 
            case 6: {
                f5 = (c0.c - c0.a) / 2.0f + c0.a - ((f3 - f2) / 2.0f + f2);
                return ((long)f5) * ((long)f5) + 13L * ((long)f4) * ((long)f4);
            }
            default: {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
        }
    }

    public static final boolean s(u u0) {
        j0 j00 = u0.getCoordinator$ui_release();
        if(j00 != null && (j00.l != null && j00.l.I())) {
            j0 j01 = u0.getCoordinator$ui_release();
            return j01 != null && (j01.l != null && j01.l.H());
        }
        return false;
    }

    public static final b t(u u0, int v) {
        switch(u0.o0().ordinal()) {
            case 1: {
                u u1 = f.n(u0);
                if(u1 == null) {
                    throw new IllegalArgumentException("ActiveParent with no focused child");
                }
                b b0 = f.t(u1, v);
                b b1 = b.a;
                if(b0 == b1) {
                    b0 = null;
                }
                if(b0 == null) {
                    if(!u0.b) {
                        try {
                            u0.b = true;
                            w0.n n0 = u0.n0();
                            w0.a a0 = new w0.a(v);
                            f.o(u0);
                            j j0 = ((Q0.u)P0.f.w(u0)).getFocusOwner();
                            u u2 = ((w0.k)j0).l;
                            ((k)n0.k).invoke(a0);
                            u u3 = ((w0.k)j0).l;
                            if(a0.b) {
                                return b.b;
                            }
                            if(u2 != u3 && u3 != null) {
                                return w0.p.d == w0.p.c ? b.b : b.c;
                            }
                            return b1;
                        }
                        finally {
                            u0.b = false;
                        }
                    }
                    return b1;
                }
                return b0;
            }
            case 2: {
                return b.b;
            }
            case 0: 
            case 3: {
                return b.a;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static final b u(u u0, int v) {
        if(!u0.c) {
            try {
                u0.c = true;
                w0.n n0 = u0.n0();
                w0.a a0 = new w0.a(v);
                f.o(u0);
                j j0 = ((Q0.u)P0.f.w(u0)).getFocusOwner();
                u u1 = ((w0.k)j0).l;
                ((k)n0.j).invoke(a0);
                u u2 = ((w0.k)j0).l;
                if(a0.b) {
                    return b.b;
                }
                if(u1 != u2 && u2 != null) {
                    return w0.p.d == w0.p.c ? b.b : b.c;
                }
            }
            finally {
                u0.c = false;
            }
        }
        return b.a;
    }

    public static final b v(u u0, int v) {
        b b0;
        p p1;
        switch(u0.o0().ordinal()) {
            case 1: {
                u u1 = f.n(u0);
                if(u1 == null) {
                    throw new IllegalArgumentException("ActiveParent with no focused child");
                }
                return f.t(u1, v);
            }
            case 0: 
            case 2: {
                return b.a;
            }
            case 3: {
                if(!u0.getNode().isAttached()) {
                    a.b("visitAncestors called on an unattached node");
                }
                p p0 = u0.getNode().getParent$ui_release();
                I i0 = P0.f.v(u0);
            alab1:
                while(true) {
                    p1 = null;
                    b0 = null;
                    if(i0 == null) {
                        break;
                    }
                    if((((p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0x400) != 0) {
                        while(p0 != null) {
                            if((p0.getKindSet$ui_release() & 0x400) != 0) {
                                p1 = p0;
                                e e0 = null;
                                while(p1 != null) {
                                    if(p1 instanceof u) {
                                        break alab1;
                                    }
                                    if((p1.getKindSet$ui_release() & 0x400) != 0 && p1 instanceof n) {
                                        p p2 = ((n)p1).b;
                                        int v1 = 0;
                                        while(p2 != null) {
                                            if((p2.getKindSet$ui_release() & 0x400) != 0) {
                                                ++v1;
                                                if(v1 == 1) {
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
                                        if(v1 != 1) {
                                            p1 = P0.f.f(e0);
                                        }
                                    }
                                    else {
                                        p1 = P0.f.f(e0);
                                    }
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
                if(((u)p1) == null) {
                    return b.a;
                }
                switch(((u)p1).o0().ordinal()) {
                    case 0: {
                        return f.u(((u)p1), v);
                    }
                    case 1: {
                        return f.v(((u)p1), v);
                    }
                    case 2: {
                        return b.b;
                    }
                    case 3: {
                        b b1 = f.v(((u)p1), v);
                        if(b1 != b.a) {
                            b0 = b1;
                        }
                        return b0 == null ? f.u(((u)p1), v) : b0;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static final boolean w(u u0) {
        e e0;
        w0.k k0 = (w0.k)((Q0.u)P0.f.w(u0)).getFocusOwner();
        u u1 = k0.l;
        t t0 = u0.o0();
        if(u1 == u0) {
            u0.m0(t0, t0);
            return true;
        }
        if(u1 != null || ((Boolean)((w0.k)((Q0.u)P0.f.w(u0)).getFocusOwner()).a.invoke(null, null)).booleanValue()) {
            if(u1 == null) {
                e0 = null;
            }
            else {
                e0 = new e(new u[16]);
                if(!u1.getNode().isAttached()) {
                    a.b("visitAncestors called on an unattached node");
                }
                p p0 = u1.getNode().getParent$ui_release();
                I i0 = P0.f.v(u1);
                while(i0 != null) {
                    if((((p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0x400) != 0) {
                        while(p0 != null) {
                            if((p0.getKindSet$ui_release() & 0x400) != 0) {
                                e e1 = null;
                                p p1 = p0;
                                while(p1 != null) {
                                    if(p1 instanceof u) {
                                        e0.b(((u)p1));
                                    }
                                    else if((p1.getKindSet$ui_release() & 0x400) != 0 && p1 instanceof n) {
                                        p p2 = ((n)p1).b;
                                        int v = 0;
                                        while(p2 != null) {
                                            if((p2.getKindSet$ui_release() & 0x400) != 0) {
                                                ++v;
                                                if(v == 1) {
                                                    p1 = p2;
                                                }
                                                else {
                                                    if(e1 == null) {
                                                        e1 = new e(new p[16]);
                                                    }
                                                    if(p1 != null) {
                                                        e1.b(p1);
                                                        p1 = null;
                                                    }
                                                    e1.b(p2);
                                                }
                                            }
                                            p2 = p2.getChild$ui_release();
                                        }
                                        if(v != 1) {
                                            goto label_41;
                                        }
                                        continue;
                                    }
                                label_41:
                                    p1 = P0.f.f(e1);
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
            u[] arr_u = new u[16];
            if(!u0.getNode().isAttached()) {
                a.b("visitAncestors called on an unattached node");
            }
            p p3 = u0.getNode().getParent$ui_release();
            I i1 = P0.f.v(u0);
            boolean z = true;
            int v1 = 0;
            while(i1 != null) {
                if((((p)i1.b0.f).getAggregateChildKindSet$ui_release() & 0x400) != 0) {
                    while(p3 != null) {
                        if((p3.getKindSet$ui_release() & 0x400) != 0) {
                            p p4 = p3;
                            e e2 = null;
                            while(p4 != null) {
                                if(p4 instanceof u) {
                                    Boolean boolean0 = e0 == null ? null : Boolean.valueOf(e0.j(((u)p4)));
                                    if(boolean0 == null || !boolean0.booleanValue()) {
                                        if(arr_u.length < v1 + 1) {
                                            Object[] arr_object = new Object[Math.max(v1 + 1, arr_u.length * 2)];
                                            System.arraycopy(arr_u, 0, arr_object, 0, arr_u.length);
                                            arr_u = arr_object;
                                        }
                                        arr_u[v1] = (u)p4;
                                        ++v1;
                                    }
                                    if(((u)p4) == u1) {
                                        z = false;
                                    }
                                }
                                else if((p4.getKindSet$ui_release() & 0x400) != 0 && p4 instanceof n) {
                                    p p5 = ((n)p4).b;
                                    int v2 = 0;
                                    while(p5 != null) {
                                        if((p5.getKindSet$ui_release() & 0x400) != 0) {
                                            ++v2;
                                            if(v2 == 1) {
                                                p4 = p5;
                                            }
                                            else {
                                                if(e2 == null) {
                                                    e2 = new e(new p[16]);
                                                }
                                                if(p4 != null) {
                                                    e2.b(p4);
                                                    p4 = null;
                                                }
                                                e2.b(p5);
                                            }
                                        }
                                        p5 = p5.getChild$ui_release();
                                    }
                                    if(v2 != 1) {
                                        goto label_99;
                                    }
                                    continue;
                                }
                            label_99:
                                p4 = P0.f.f(e2);
                            }
                        }
                        p3 = p3.getParent$ui_release();
                    }
                }
                i1 = i1.u();
                if(i1 != null) {
                    d0 d01 = i1.b0;
                    if(d01 != null) {
                        p3 = (A0)d01.e;
                        continue;
                    }
                }
                p3 = null;
            }
            if(!z || u1 == null || f.e(u1, false)) {
                P0.f.r(u0, new X.k(u0, 29));
                switch(u0.o0().ordinal()) {
                    case 1: 
                    case 3: {
                        ((w0.k)((Q0.u)P0.f.w(u0)).getFocusOwner()).g(u0);
                    }
                }
                if(e0 != null) {
                    int v3 = e0.c - 1;
                    Object[] arr_object1 = e0.a;
                    if(v3 < arr_object1.length) {
                        while(v3 >= 0) {
                            u u2 = (u)arr_object1[v3];
                            if(k0.l != u0) {
                                return false;
                            }
                            u2.m0(t.b, t.d);
                            --v3;
                        }
                    }
                }
                int v4 = v1 - 1;
                if(v4 < arr_u.length) {
                    while(v4 >= 0) {
                        u u3 = arr_u[v4];
                        if(k0.l != u0) {
                            return false;
                        }
                        u3.m0((u3 == u1 ? t.a : t.d), t.b);
                        --v4;
                    }
                }
                if(k0.l == u0) {
                    u0.m0(t0, t.a);
                    return k0.l == u0;
                }
            }
        }
        return false;
    }

    public static final boolean x(u u0, g g0) {
        e e1;
        p p1;
        u[] arr_u = new u[16];
        if(!u0.getNode().isAttached()) {
            a.b("visitChildren called on an unattached node");
        }
        e e0 = new e(new p[16]);
        p p0 = u0.getNode().getChild$ui_release();
        if(p0 == null) {
            P0.f.b(e0, u0.getNode());
        }
        else {
            e0.b(p0);
        }
        int v = 0;
    alab1:
        while(true) {
        alab2:
            while(true) {
                int v1 = e0.c;
                if(v1 == 0) {
                    break alab1;
                }
                p1 = (p)e0.k(v1 - 1);
                if((p1.getAggregateChildKindSet$ui_release() & 0x400) == 0) {
                    P0.f.b(e0, p1);
                }
                else {
                    while(true) {
                        if(p1 == null) {
                            continue alab1;
                        }
                        if((p1.getKindSet$ui_release() & 0x400) == 0) {
                            p1 = p1.getChild$ui_release();
                            continue;
                        }
                        e1 = null;
                    label_21:
                        if(p1 == null) {
                            break;
                        }
                        break alab2;
                    }
                }
            }
            if(p1 instanceof u) {
                if(arr_u.length < v + 1) {
                    Object[] arr_object = new Object[Math.max(v + 1, arr_u.length * 2)];
                    System.arraycopy(arr_u, 0, arr_object, 0, arr_u.length);
                    arr_u = arr_object;
                }
                arr_u[v] = (u)p1;
                ++v;
            }
            else if((p1.getKindSet$ui_release() & 0x400) != 0 && p1 instanceof n) {
                p p2 = ((n)p1).b;
                int v2 = 0;
                while(p2 != null) {
                    if((p2.getKindSet$ui_release() & 0x400) != 0) {
                        ++v2;
                        if(v2 == 1) {
                            p1 = p2;
                        }
                        else {
                            if(e1 == null) {
                                e1 = new e(new p[16]);
                            }
                            if(p1 != null) {
                                e1.b(p1);
                                p1 = null;
                            }
                            e1.b(p2);
                        }
                    }
                    p2 = p2.getChild$ui_release();
                }
                if(v2 != 1) {
                    p1 = P0.f.f(e1);
                }
                goto label_21;
            }
            p1 = P0.f.f(e1);
            goto label_21;
        }
        Arrays.sort(arr_u, 0, v, w.a);
        int v3 = v - 1;
        if(v3 < arr_u.length) {
            while(v3 >= 0) {
                u u1 = arr_u[v3];
                if(f.s(u1) && f.a(u1, g0)) {
                    return true;
                }
                --v3;
            }
        }
        return false;
    }

    public static final boolean y(u u0, g g0) {
        e e1;
        p p1;
        u[] arr_u = new u[16];
        if(!u0.getNode().isAttached()) {
            a.b("visitChildren called on an unattached node");
        }
        e e0 = new e(new p[16]);
        p p0 = u0.getNode().getChild$ui_release();
        if(p0 == null) {
            P0.f.b(e0, u0.getNode());
        }
        else {
            e0.b(p0);
        }
        int v = 0;
    alab1:
        while(true) {
        alab2:
            while(true) {
                int v1 = e0.c;
                if(v1 == 0) {
                    break alab1;
                }
                p1 = (p)e0.k(v1 - 1);
                if((p1.getAggregateChildKindSet$ui_release() & 0x400) == 0) {
                    P0.f.b(e0, p1);
                }
                else {
                    while(true) {
                        if(p1 == null) {
                            continue alab1;
                        }
                        if((p1.getKindSet$ui_release() & 0x400) == 0) {
                            p1 = p1.getChild$ui_release();
                            continue;
                        }
                        e1 = null;
                    label_21:
                        if(p1 == null) {
                            break;
                        }
                        break alab2;
                    }
                }
            }
            if(p1 instanceof u) {
                if(arr_u.length < v + 1) {
                    Object[] arr_object = new Object[Math.max(v + 1, arr_u.length * 2)];
                    System.arraycopy(arr_u, 0, arr_object, 0, arr_u.length);
                    arr_u = arr_object;
                }
                arr_u[v] = (u)p1;
                ++v;
            }
            else if((p1.getKindSet$ui_release() & 0x400) != 0 && p1 instanceof n) {
                p p2 = ((n)p1).b;
                int v2 = 0;
                while(p2 != null) {
                    if((p2.getKindSet$ui_release() & 0x400) != 0) {
                        ++v2;
                        if(v2 == 1) {
                            p1 = p2;
                        }
                        else {
                            if(e1 == null) {
                                e1 = new e(new p[16]);
                            }
                            if(p1 != null) {
                                e1.b(p1);
                                p1 = null;
                            }
                            e1.b(p2);
                        }
                    }
                    p2 = p2.getChild$ui_release();
                }
                if(v2 != 1) {
                    p1 = P0.f.f(e1);
                }
                goto label_21;
            }
            p1 = P0.f.f(e1);
            goto label_21;
        }
        Arrays.sort(arr_u, 0, v, w.a);
        for(int v3 = 0; v3 < v; ++v3) {
            u u1 = arr_u[v3];
            if(f.s(u1) && f.k(u1, g0)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean z(View view0, Integer integer0, Rect rect0) {
        if(integer0 == null) {
            return view0.requestFocus();
        }
        if(!(view0 instanceof ViewGroup)) {
            return view0.requestFocus(((int)integer0), rect0);
        }
        if(((ViewGroup)view0).isFocused()) {
            return true;
        }
        if(((ViewGroup)view0).isFocusable() && !view0.hasFocus()) {
            return view0.requestFocus(((int)integer0), rect0);
        }
        if(view0 instanceof Q0.u) {
            return view0.requestFocus(((int)integer0), rect0);
        }
        if(rect0 != null) {
            View view1 = FocusFinder.getInstance().findNextFocusFromRect(((ViewGroup)view0), rect0, ((int)integer0));
            return view1 == null ? view0.requestFocus(((int)integer0), rect0) : view1.requestFocus(((int)integer0), rect0);
        }
        View view2 = view0.hasFocus() ? view0.findFocus() : null;
        View view3 = FocusFinder.getInstance().findNextFocus(((ViewGroup)view0), view2, ((int)integer0));
        return view3 == null ? view0.requestFocus(((int)integer0)) : view3.requestFocus(((int)integer0));
    }
}

