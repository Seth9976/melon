package z4;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import me.e;
import me.f;
import me.g;
import me.j;
import oe.i;
import we.n;

public final class y extends i implements n {
    public Object r;
    public final i w;

    public y(n n0, Continuation continuation0) {
        this.w = (i)n0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new y(((n)this.w), continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        g g0 = ((CoroutineScope)this.r).getCoroutineContext().get(e.a);
        q.d(g0);
        f f0 = (f)g0;
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        w w0 = new w(completableDeferred0, ((n)this.w), null);
        BuildersKt.launch(() -> j.a, f0, CoroutineStart.UNDISPATCHED, w0);
    label_7:
        if(!completableDeferred0.isCompleted()) {
            try {
                return BuildersKt.runBlocking(f0, new x(completableDeferred0, null));
            }
            catch(InterruptedException unused_ex) {
                goto label_7;
            }
        }
        return completableDeferred0.getCompleted();
    }
}

