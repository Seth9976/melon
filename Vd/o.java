package vd;

import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import r1.c;
import r1.f;
import r1.l;
import we.n;

public final class o extends i implements n {
    public final b0 B;
    public final b0 D;
    public final b0 E;
    public final b0 G;
    public final c r;
    public final float w;

    public o(c c0, float f, b0 b00, b0 b01, b0 b02, b0 b03, Continuation continuation0) {
        this.r = c0;
        this.w = f;
        this.B = b00;
        this.D = b01;
        this.E = b02;
        this.G = b03;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o(this.r, this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((o)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        int v = (int)(((l)this.B.getValue()).a & 0xFFFFFFFFL);
        f f0 = new f(this.r.R(v));
        this.D.setValue(f0);
        boolean z = Float.compare(((f)this.D.getValue()).a, this.w) > 0;
        this.E.setValue(Boolean.valueOf(z));
        f f1 = new f(((float)(((Boolean)this.E.getValue()).booleanValue() ? 14 : 15)));
        this.G.setValue(f1);
        return H.a;
    }
}

