package gd;

import com.iloen.melon.net.v4x.response.DjApplyMainRes.RESPONSE;
import com.iloen.melon.net.v4x.response.DjApplyMainRes;
import dd.z;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class m5 extends i implements n {
    public final p5 r;

    public m5(p5 p50, Continuation continuation0) {
        this.r = p50;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m5(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((m5)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        p5 p50 = this.r;
        DjApplyMainRes djApplyMainRes0 = p50.c;
        H h0 = H.a;
        if(djApplyMainRes0 != null) {
            RESPONSE djApplyMainRes$RESPONSE0 = djApplyMainRes0.response;
            if(djApplyMainRes$RESPONSE0 != null) {
                p50.updateUiState(new z(djApplyMainRes$RESPONSE0, 21));
            }
        }
        return h0;
    }
}

