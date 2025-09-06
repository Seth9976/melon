package pc;

import Ba.y;
import Ma.l;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.mcp.response.MixUpPlayBase;
import com.iloen.melon.net.mcp.response.MixupPlayResponseBase;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import e1.u;
import ie.H;
import k8.Y;
import k8.o;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import va.e0;
import we.n;

public final class i1 extends i implements n {
    public int r;
    public final String w;

    public i1(String s, Continuation continuation0) {
        this.w = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i1(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                y y0 = ((o)(((l)Y.f(MelonAppBase.Companion, l.class)))).g();
                this.r = 1;
                q.f("", "getToken(...)");
                object0 = y0.c("", u.w(((e0)va.o.a()).j()), this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        MixupPlayResponseBase mixupPlayResponseBase0 = (MixupPlayResponseBase)ApiResultKt.getOrNull(((ApiResult)object0));
        if(mixupPlayResponseBase0 == null) {
            return null;
        }
        MixUpPlayBase mixUpPlayBase0 = mixupPlayResponseBase0.result;
        q.f(mixUpPlayBase0, "result");
        this.r = 2;
        Object object1 = w1.i(j1.c, this.w, mixUpPlayBase0, mixupPlayResponseBase0.result.playlist.statsElements, mixupPlayResponseBase0.result.waitingList.statsElements, this, 4);
        return object1 == a0 ? a0 : object1;
    }
}

