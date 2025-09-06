package Cc;

import androidx.compose.runtime.b0;
import androidx.lifecycle.s;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.a;
import we.n;

public final class k3 extends i implements n {
    public final a B;
    public final b0 D;
    public final b0 E;
    public final s r;
    public final int w;

    public k3(s s0, int v, a a0, b0 b00, b0 b01, Continuation continuation0) {
        this.r = s0;
        this.w = v;
        this.B = a0;
        this.D = b00;
        this.E = b01;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k3(this.r, this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((k3)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        int v = this.w;
        H h0 = H.a;
        b0 b00 = this.E;
        if(this.r.compareTo(s.e) >= 0) {
            b0 b01 = this.D;
            if(!q.b(((Boolean)b01.getValue()), Boolean.FALSE)) {
                if(q.b(((Boolean)b01.getValue()), Boolean.TRUE) && !((Boolean)b00.getValue()).booleanValue()) {
                    b00.setValue(Boolean.TRUE);
                    m3.a.put(v, true);
                    this.B.invoke();
                }
                return h0;
            }
        }
        b00.setValue(Boolean.FALSE);
        m3.a.delete(v);
        return h0;
    }
}

