package l2;

import d5.n;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.sync.Mutex;
import ne.a;
import oe.c;

public final class l {
    public final Mutex a;
    public final C b;
    public final H c;
    public final M d;

    public l(Mutex mutex0, C c0, H h0, M m0) {
        this.a = mutex0;
        this.b = c0;
        this.c = h0;
        this.d = m0;
    }

    public final Object a(h h0, c c0) {
        Object object3;
        M m2;
        Mutex mutex3;
        Mutex mutex2;
        Object object1;
        H h2;
        C c2;
        M m0;
        Mutex mutex0;
        k k0;
        if(c0 instanceof k) {
            k0 = (k)c0;
            int v = k0.M;
            if((v & 0x80000000) == 0) {
                k0 = new k(this, c0);
            }
            else {
                k0.M = v ^ 0x80000000;
            }
        }
        else {
            k0 = new k(this, c0);
        }
        Object object0 = k0.G;
        a a0 = a.a;
        switch(k0.M) {
            case 0: {
                n.D(object0);
                k0.r = h0;
                mutex0 = this.a;
                k0.w = mutex0;
                C c1 = this.b;
                k0.B = c1;
                H h1 = this.c;
                k0.D = h1;
                m0 = this.d;
                k0.E = m0;
                k0.M = 1;
                if(mutex0.lock(null, k0) != a0) {
                    c2 = c1;
                    h2 = h1;
                    goto label_37;
                }
                return a0;
            }
            case 1: {
                M m1 = k0.E;
                h2 = k0.D;
                c2 = (C)k0.B;
                Mutex mutex1 = (Mutex)k0.w;
                we.n n0 = (we.n)k0.r;
                n.D(object0);
                m0 = m1;
                h0 = n0;
                mutex0 = mutex1;
                try {
                label_37:
                    if(c2.a) {
                        throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
                    }
                    k0.r = mutex0;
                    k0.w = h2;
                    k0.B = m0;
                    k0.D = null;
                    k0.E = null;
                    k0.M = 2;
                    object1 = h0.invoke(h2.a, k0);
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    break;
                }
                if(object1 != a0) {
                    mutex3 = mutex0;
                    object0 = object1;
                    m2 = m0;
                    goto label_60;
                }
                return a0;
            }
            case 2: {
                m2 = (M)k0.B;
                h2 = (H)k0.w;
                mutex3 = (Mutex)k0.r;
                try {
                    n.D(object0);
                label_60:
                    if(q.b(object0, h2.a)) {
                        mutex2 = mutex3;
                    }
                    else {
                        k0.r = mutex3;
                        k0.w = h2;
                        k0.B = object0;
                        k0.M = 3;
                        if(m2.j(object0, false, k0) == a0) {
                            return a0;
                        }
                        mutex2 = mutex3;
                        h2.a = object0;
                    }
                    object3 = h2.a;
                    goto label_87;
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex3;
                    break;
                }
                return a0;
            }
            case 3: {
                Object object2 = k0.B;
                H h3 = (H)k0.w;
                mutex2 = (Mutex)k0.r;
                try {
                    n.D(object0);
                    h3.a = object2;
                    h2 = h3;
                    object3 = h2.a;
                    goto label_87;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_87:
        mutex2.unlock(null);
        return object3;
    }
}

