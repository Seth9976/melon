package D2;

import android.util.Log;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import ne.a;
import oe.i;
import we.n;

public final class j0 extends i implements n {
    public int r;
    public final m0 w;

    public j0(m0 m00, Continuation continuation0) {
        this.w = m00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                f f0 = new f(this.w.b);
                try {
                    this.r = 1;
                    return m0.a(this.w, f0, this) == a0 ? a0 : H.a;
                label_9:
                    d5.n.D(object0);
                    return H.a;
                }
                catch(ClosedSendChannelException closedSendChannelException0) {
                    return new Integer(Log.e("GlanceRemoteViewService", "Error when trying to start session for list items", closedSendChannelException0));
                }
            }
            case 1: {
                goto label_9;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

