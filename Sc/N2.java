package sc;

import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class n2 extends i implements n {
    public final l1 B;
    public int r;
    public final S2 w;

    public n2(S2 s20, l1 l10, Continuation continuation0) {
        this.w = s20;
        this.B = l10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n2(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = this.w.f.b(this.B.b, this.B.a, this);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                d5.n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

