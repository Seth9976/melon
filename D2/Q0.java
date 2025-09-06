package D2;

import F2.d;
import F2.e;
import F2.f;
import F2.g;
import androidx.glance.appwidget.protobuf.v;
import ie.H;
import java.util.Map.Entry;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class q0 extends i implements n {
    public Object r;
    public final r0 w;

    public q0(r0 r00, Continuation continuation0) {
        this.w = r00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new q0(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q0)this.create(((e)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        e e0 = (e)this.r;
        v v0 = (v)e0.b(5);
        if(!v0.a.equals(e0)) {
            v0.c();
            v.d(v0.b, e0);
        }
        int v1 = ((e)((d)v0).b).p();
        ((d)v0).c();
        e.m(((e)((d)v0).b), v1);
        ((d)v0).c();
        e.l(((e)((d)v0).b));
        r0 r00 = this.w;
        for(Object object1: r00.b.entrySet()) {
            F2.i i0 = (F2.i)((Map.Entry)object1).getKey();
            int v2 = ((Number)((Map.Entry)object1).getValue()).intValue();
            if(r00.e.contains(new Integer(v2))) {
                f f0 = g.o();
                f0.c();
                g.k(((g)f0.b), i0);
                f0.c();
                g.l(((g)f0.b), v2);
                ((d)v0).c();
                e.k(((e)((d)v0).b), ((g)f0.a()));
            }
        }
        return ((d)v0).a();
    }
}

