package androidx.room;

import A3.c;
import ie.H;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class g0 extends i implements n {
    public final h0 B;
    public int r;
    public Object w;

    public g0(h0 h00, Continuation continuation0) {
        this.B = h00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new g0(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g0)this.create(((T)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        s[] arr_s;
        s s0;
        Object object1;
        T t0;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                t0 = (T)this.w;
                this.w = t0;
                this.r = 1;
                object1 = t0.a(this);
                if(object1 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                t0 = (T)this.w;
                d5.n.D(object0);
                object1 = object0;
                break;
            }
            case 2: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((Boolean)object1).booleanValue()) {
            h0 h00 = this.B;
            c c0 = h00.h;
            long[] arr_v = (long[])c0.c;
            ReentrantLock reentrantLock0 = (ReentrantLock)c0.b;
            reentrantLock0.lock();
            if(c0.a) {
                try {
                    c0.a = false;
                    arr_s = new s[arr_v.length];
                    int v1 = 0;
                    boolean z1 = false;
                    for(boolean z = true; v1 < arr_v.length; z = true) {
                        if(arr_v[v1] <= 0L) {
                            z = false;
                        }
                        boolean[] arr_z = (boolean[])c0.d;
                        if(z == arr_z[v1]) {
                            s0 = s.a;
                        }
                        else {
                            arr_z[v1] = z;
                            s0 = z ? s.b : s.c;
                            z1 = true;
                        }
                        arr_s[v1] = s0;
                        ++v1;
                    }
                    if(!z1) {
                        arr_s = null;
                    }
                }
                finally {
                    reentrantLock0.unlock();
                }
            }
            else {
                reentrantLock0.unlock();
                arr_s = null;
            }
            if(arr_s != null) {
                f0 f00 = new f0(arr_s, h00, t0, null);
                this.w = null;
                this.r = 2;
                if(t0.b(S.b, f00, this) == a0) {
                    return a0;
                }
            }
        }
        return h0;
    }
}

