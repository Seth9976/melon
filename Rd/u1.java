package rd;

import E9.h;
import Na.f;
import com.iloen.melon.net.v4x.response.AuthLocationRes.Response;
import com.iloen.melon.net.v4x.response.AuthLocationRes;
import com.melon.ui.N0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class u1 extends i implements n {
    public int r;
    public final K1 w;

    public u1(K1 k10, Continuation continuation0) {
        this.w = k10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new u1(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z;
        a a0 = a.a;
        K1 k10 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = k10.g.c(this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        AuthLocationRes authLocationRes0 = (AuthLocationRes)h.H(((f)object0));
        if(authLocationRes0 == null) {
            z = false;
        }
        else {
            Response authLocationRes$Response0 = authLocationRes0.response;
            z = authLocationRes$Response0 == null ? false : authLocationRes$Response0.isAgree;
        }
        k10.sendUiEvent(new N0(z, true, k10.getMenuId(), new j3.n(k10, 7)));
        return H.a;
    }
}

