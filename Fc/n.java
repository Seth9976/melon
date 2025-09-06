package Fc;

import Ac.A2;
import com.melon.playlist.interfaces.PlayableData;
import e1.b;
import ie.H;
import kotlin.coroutines.Continuation;
import oc.Q;
import oe.i;

public final class n extends i implements we.n {
    public Object r;
    public final p w;

    public n(p p0, Continuation continuation0) {
        this.w = p0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new n(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((n)this.create(((Q)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Q q0 = (Q)this.r;
        d5.n.D(object0);
        PlayableData playableData0 = b.z(q0);
        A2 a20 = new A2((playableData0 == null ? null : playableData0.m), 17);
        this.w.updateUiState(a20);
        return H.a;
    }
}

