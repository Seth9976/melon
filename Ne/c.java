package ne;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import me.i;
import we.n;

public final class c extends oe.c {
    public final Object B;
    public int r;
    public final n w;

    public c(Continuation continuation0, i i0, n n0, Object object0) {
        this.w = n0;
        this.B = object0;
        q.e(continuation0, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        super(continuation0, i0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        switch(this.r) {
            case 0: {
                this.r = 1;
                d5.n.D(object0);
                q.e(this.w, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                N.e(2, this.w);
                return this.w.invoke(this.B, this);
            }
            case 1: {
                this.r = 2;
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("This coroutine had already completed");
            }
        }
    }
}

