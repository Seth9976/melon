package Ff;

import A1.g;
import Df.B;
import Df.i;
import Gf.m;
import Hf.b0;
import Me.O;
import Me.k;
import Ne.h;
import Pe.c;
import Pe.z;
import e1.G;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;
import lf.T;
import lf.X;
import lf.Y;
import nf.f;
import qf.e;
import xf.d;

public final class w extends c {
    public final g k;
    public final Y l;
    public final a m;

    public w(g g0, Y y0, int v) {
        b0 b00;
        m m0 = ((i)g0.a).a;
        k k0 = (k)g0.c;
        e e0 = Q1.c.B(((f)g0.b), y0.e);
        X x0 = y0.g;
        q.f(x0, "getVariance(...)");
        switch(x0.ordinal()) {
            case 0: {
                b00 = b0.d;
                break;
            }
            case 1: {
                b00 = b0.e;
                break;
            }
            case 2: {
                b00 = b0.c;
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        super(m0, k0, Ne.g.a, e0, b00, y0.f, v, O.c);
        this.k = g0;
        this.l = y0;
        this.m = new a(m0, new Af.g(this, 6));
    }

    @Override  // Bf.a, Ne.a
    public final h getAnnotations() {
        return this.m;
    }

    @Override  // Pe.h
    public final List u1() {
        g g0 = this.k;
        List list0 = G.M(this.l, ((z)g0.d));
        if(list0.isEmpty()) {
            return e.k.z(d.e(this).n());
        }
        B b0 = (B)g0.h;
        List list1 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            ((ArrayList)list1).add(b0.g(((T)object0)));
        }
        return list1;
    }
}

