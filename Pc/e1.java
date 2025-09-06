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
import je.p;
import k8.Y;
import k8.o;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import va.e0;
import we.n;

public final class e1 extends i implements n {
    public final String B;
    public int r;
    public final f1 w;

    public e1(f1 f10, String s, Continuation continuation0) {
        this.w = f10;
        this.B = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        f1 f10 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                y y0 = ((o)(((l)Y.f(MelonAppBase.Companion, l.class)))).g();
                String s = p.q0(f10.c, ",", null, null, null, 62);
                this.r = 1;
                q.f("", "getToken(...)");
                object0 = y0.b("", u.w(((e0)va.o.a()).j()), s, this);
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
        Object object1 = w1.i(f10, this.B, mixUpPlayBase0, null, mixupPlayResponseBase0.result.waitingList.statsElements, this, 12);
        return object1 == a0 ? a0 : object1;
    }
}

