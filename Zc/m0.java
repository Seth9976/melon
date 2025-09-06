package Zc;

import com.iloen.melon.net.v6x.response.FeedLogsNewsCountRes.Response;
import com.iloen.melon.net.v6x.response.FeedLogsNewsCountRes;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class m0 extends i implements n {
    public int r;
    public final t0 w;

    public m0(t0 t00, Continuation continuation0) {
        this.w = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v;
        a a0 = a.a;
        boolean z = false;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                try {
                    this.r = 1;
                    object0 = this.w.h.s(this);
                    if(object0 == a0) {
                        return a0;
                    label_9:
                        d5.n.D(object0);
                    }
                    if(((FeedLogsNewsCountRes)object0) == null) {
                        v = 0;
                    }
                    else {
                        Response feedLogsNewsCountRes$Response0 = ((FeedLogsNewsCountRes)object0).response;
                        v = feedLogsNewsCountRes$Response0 == null ? 0 : feedLogsNewsCountRes$Response0.newsCount;
                    }
                    if(v > 0) {
                        z = true;
                    }
                }
                catch(Exception unused_ex) {
                }
                break;
            }
            case 1: {
                goto label_9;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return Boolean.valueOf(z);
    }
}

