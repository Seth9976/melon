package Nb;

import Ac.F2;
import androidx.media3.session.y0;
import com.melon.playlist.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class c0 extends i implements n {
    public final y0 B;
    public int r;
    public final h0 w;

    public c0(h0 h00, y0 y00, Continuation continuation0) {
        this.w = h00;
        this.B = y00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                F2 f20 = ((b)this.w.c).c.n();
                b0 b00 = new b0(this.w, this.B, null);
                this.r = 1;
                return FlowKt.collectLatest(f20, b00, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

