package tg;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import okhttp3.Call.Factory;

public final class r extends t {
    public final f d;
    public final boolean e;

    public r(P p0, Factory call$Factory0, m m0, f f0, boolean z) {
        super(p0, call$Factory0, m0);
        this.d = f0;
        this.e = z;
    }

    @Override  // tg.t
    public final Object b(z z0, Object[] arr_object) {
        d d0 = (d)this.d.adapt(z0);
        Continuation continuation0 = (Continuation)arr_object[arr_object.length - 1];
        try {
            if(this.e) {
                q.e(d0, "null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>");
                return b0.c(d0, continuation0);
            }
            return b0.b(d0, continuation0);
        }
        catch(VirtualMachineError | ThreadDeath | LinkageError virtualMachineError0) {
            throw virtualMachineError0;
        }
        catch(Throwable throwable0) {
            b0.q(continuation0, throwable0);
            return a.a;
        }
    }
}

