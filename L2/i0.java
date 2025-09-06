package l2;

import d5.n;
import java.util.concurrent.atomic.AtomicInteger;
import kb.D;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import ne.a;
import oe.c;
import we.k;

public final class i0 {
    public final Mutex a;
    public final D b;
    public final Flow c;

    public i0(String s) {
        q.g(s, "filePath");
        super();
        this.a = MutexKt.Mutex$default(false, 1, null);
        this.b = new D(2);
        this.c = FlowKt.flow(new h0(2, null));  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    public final Integer a() {
        return new Integer(((AtomicInteger)this.b.b).get());
    }

    public final Object b(k k0, c c0) {
        Mutex mutex2;
        Throwable throwable1;
        Object object1;
        Mutex mutex0;
        f0 f00;
        if(c0 instanceof f0) {
            f00 = (f0)c0;
            int v = f00.E;
            if((v & 0x80000000) == 0) {
                f00 = new f0(this, c0);
            }
            else {
                f00.E = v ^ 0x80000000;
            }
        }
        else {
            f00 = new f0(this, c0);
        }
        Object object0 = f00.B;
        a a0 = a.a;
        switch(f00.E) {
            case 0: {
                n.D(object0);
                f00.r = k0;
                mutex0 = this.a;
                f00.w = mutex0;
                f00.E = 1;
                if(mutex0.lock(null, f00) == a0) {
                    return a0;
                }
                goto label_25;
            }
            case 1: {
                Mutex mutex1 = f00.w;
                k k1 = (k)f00.r;
                n.D(object0);
                mutex0 = mutex1;
                k0 = k1;
                try {
                label_25:
                    f00.r = mutex0;
                    f00.w = null;
                    f00.E = 2;
                    object1 = k0.invoke(f00);
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    mutex2 = mutex0;
                    mutex2.unlock(null);
                    throw throwable1;
                }
                if(object1 == a0) {
                    return a0;
                }
                object0 = object1;
                mutex2 = mutex0;
                break;
            }
            case 2: {
                mutex2 = (Mutex)f00.r;
                try {
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
                mutex2.unlock(null);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return object0;
    }

    public final Object c(we.n n0, c c0) {
        boolean z1;
        Throwable throwable1;
        Mutex mutex1;
        Object object1;
        g0 g00;
        if(c0 instanceof g0) {
            g00 = (g0)c0;
            int v = g00.E;
            if((v & 0x80000000) == 0) {
                g00 = new g0(this, c0);
            }
            else {
                g00.E = v ^ 0x80000000;
            }
        }
        else {
            g00 = new g0(this, c0);
        }
        Object object0 = g00.B;
        a a0 = a.a;
        switch(g00.E) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.a;
                boolean z = mutex0.tryLock(null);
                try {
                    g00.r = mutex0;
                    g00.w = z;
                    g00.E = 1;
                    object1 = n0.invoke(Boolean.valueOf(z), g00);
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex0;
                    throwable1 = throwable0;
                    z1 = z;
                    goto label_37;
                }
                if(object1 == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                object0 = object1;
                z1 = z;
                break;
            }
            case 1: {
                try {
                    z1 = g00.w;
                    mutex1 = g00.r;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
            label_37:
                if(z1) {
                    mutex1.unlock(null);
                }
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(z1) {
            mutex1.unlock(null);
        }
        return object0;
    }
}

