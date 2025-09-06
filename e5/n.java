package e5;

import H7.c;
import U4.v;
import U4.w;
import U4.x;
import Vc.A;
import android.content.Context;
import d5.q;
import e.k;
import e1.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import w1.m;

public final class n extends i implements we.n {
    public final q B;
    public final p D;
    public final Context E;
    public int r;
    public final v w;

    public n(v v0, q q0, p p0, Context context0, Continuation continuation0) {
        this.w = v0;
        this.B = q0;
        this.D = p0;
        this.E = context0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        v v0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                m m0 = v0.a();
                this.r = 1;
                object0 = V4.H.a(m0, v0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        q q0 = this.B;
        if(((U4.m)object0) == null) {
            throw new IllegalStateException(x.m(new StringBuilder("Worker was marked important ("), q0.c, ") but did not provide ForegroundInfo"));
        }
        w.e().a("WM-WorkForegroundRunnab", "Updating notification for " + q0.c);
        A a1 = new A(this.D, v0.b.a, ((U4.m)object0), this.E, 3);
        kotlin.jvm.internal.q.g(this.D.a.a, "<this>");
        m m1 = k.q(new c(this.D.a.a, "setForegroundAsync", a1, 4));
        this.r = 2;
        Object object1 = b.o(m1, this);
        return object1 == a0 ? a0 : object1;
    }
}

