package tg;

import e1.u;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import ma.c;
import ne.a;
import okhttp3.Call.Factory;

public final class s extends t {
    public final f d;

    public s(P p0, Factory call$Factory0, m m0, f f0) {
        super(p0, call$Factory0, m0);
        this.d = f0;
    }

    @Override  // tg.t
    public final Object b(z z0, Object[] arr_object) {
        d d0 = (d)this.d.adapt(z0);
        Continuation continuation0 = (Continuation)arr_object[arr_object.length - 1];
        try {
            CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
            cancellableContinuationImpl0.initCancellability();
            cancellableContinuationImpl0.invokeOnCancellation(new v(d0, 2));
            d0.enqueue(new c(cancellableContinuationImpl0, 3));
            return cancellableContinuationImpl0.getResult();
        }
        catch(Exception exception0) {
            b0.q(continuation0, exception0);
            return a.a;
        }
    }
}

