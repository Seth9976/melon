package androidx.compose.foundation;

import ie.H;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import me.g;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class z0 extends i implements n {
    public B0 B;
    public int D;
    public Object E;
    public final B0 G;
    public final i I;
    public Mutex r;
    public Object w;

    public z0(B0 b00, k k0, Continuation continuation0) {
        this.G = b00;
        this.I = (i)k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new z0(this.G, ((k)this.I), continuation0);
        continuation1.E = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        y0 y02;
        Throwable throwable1;
        B0 b02;
        Object object1;
        Mutex mutex1;
        y0 y01;
        k k0;
        Mutex mutex0;
        B0 b00;
        a a0 = a.a;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                g g0 = ((CoroutineScope)this.E).getCoroutineContext().get(Job.Key);
                q.d(g0);
                y0 y00 = new y0(x0.a, ((Job)g0));
                b00 = this.G;
                B0.a(b00, y00);
                mutex0 = b00.b;
                this.E = y00;
                this.r = mutex0;
                i i0 = this.I;
                this.w = i0;
                this.B = b00;
                this.D = 1;
                if(mutex0.lock(null, this) == a0) {
                    return a0;
                }
                k0 = i0;
                y01 = y00;
                mutex1 = mutex0;
                goto label_28;
            }
            case 1: {
                B0 b01 = this.B;
                k0 = (k)this.w;
                mutex0 = this.r;
                y01 = (y0)this.E;
                d5.n.D(object0);
                b00 = b01;
                mutex1 = mutex0;
                try {
                label_28:
                    this.E = y01;
                    this.r = mutex1;
                    this.w = b00;
                    this.B = null;
                    this.D = 2;
                    object1 = k0.invoke(this);
                }
                catch(Throwable throwable0) {
                    b02 = b00;
                    throwable1 = throwable0;
                    y02 = y01;
                    goto label_52;
                }
                if(object1 == a0) {
                    return a0;
                }
                b02 = b00;
                object0 = object1;
                y02 = y01;
                goto label_56;
            }
            case 2: {
                b02 = (B0)this.w;
                mutex1 = this.r;
                y02 = (y0)this.E;
                try {
                    d5.n.D(object0);
                    goto label_56;
                }
                catch(Throwable throwable1) {
                }
                try {
                label_52:
                    AtomicReference atomicReference0 = b02.a;
                    while(true) {
                        if(atomicReference0.compareAndSet(y02, null) || atomicReference0.get() != y02) {
                            throw throwable1;
                        }
                    }
                label_56:
                    AtomicReference atomicReference1 = b02.a;
                    while(true) {
                        if(atomicReference1.compareAndSet(y02, null) || atomicReference1.get() != y02) {
                            goto label_62;
                        }
                    }
                }
                catch(Throwable throwable2) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex1.unlock(null);
        throw throwable2;
    label_62:
        mutex1.unlock(null);
        return object0;
    }
}

