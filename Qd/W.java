package qd;

import Cc.n3;
import android.content.Context;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class w extends i implements n {
    public final String B;
    public final n3 r;
    public final Context w;

    public w(n3 n30, Context context0, String s, Continuation continuation0) {
        this.r = n30;
        this.w = context0;
        this.B = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new w(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((w)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        this.r.a(this.w, this.B);
        return H.a;
    }
}

