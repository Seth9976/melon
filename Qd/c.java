package qd;

import O.F;
import androidx.compose.runtime.b0;
import ie.H;
import java.util.Collection;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class c extends i implements n {
    public final b0 B;
    public final F D;
    public int r;
    public final b0 w;

    public c(F f0, b0 b00, b0 b01, Continuation continuation0) {
        this.w = b00;
        this.B = b01;
        this.D = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c(this.D, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Collection collection0 = (List)this.w.getValue();
                if(collection0 != null && !collection0.isEmpty()) {
                    Integer integer0 = (Integer)this.B.getValue();
                    if(integer0 != null) {
                        int v = integer0.intValue();
                        if(v < 0) {
                            v = 0;
                        }
                        this.r = 1;
                        if(this.D.j(v, 0, this) == a0) {
                            return a0;
                        }
                    }
                }
                return h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

