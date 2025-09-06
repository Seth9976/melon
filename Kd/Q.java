package kd;

import O.F;
import ie.H;
import jd.m3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.k;
import we.n;

public final class q extends i implements n {
    public final CoroutineScope B;
    public final k D;
    public final F E;
    public boolean r;
    public final m3 w;

    public q(F f0, m3 m30, Continuation continuation0, CoroutineScope coroutineScope0, k k0) {
        this.w = m30;
        this.B = coroutineScope0;
        this.D = k0;
        this.E = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new q(this.E, this.w, continuation0, this.B, this.D);
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((q)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.r;
        d5.n.D(object0);
        if(z || this.w == m3.a) {
            p p0 = new p(this.E, null);
            BuildersKt__Builders_commonKt.launch$default(this.B, null, null, p0, 3, null);
        }
        this.D.invoke(Boolean.valueOf(z));
        return H.a;
    }
}

