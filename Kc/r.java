package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import ne.a;
import oe.i;
import we.n;

public final class r extends i implements n {
    public int B;
    public int D;
    public int E;
    public final Mutex G;
    public final b I;
    public b M;
    public int N;
    public Mutex r;
    public Object w;

    public r(Mutex mutex0, Continuation continuation0, b b0) {
        this.G = mutex0;
        this.I = b0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r(this.G, continuation0, this.I);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object3;
        Mutex mutex3;
        Object object2;
        int v1;
        Object object1;
        Mutex mutex1;
        a a0 = a.a;
        int v = 0;
        switch(this.E) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex0 = this.G;
                this.r = mutex0;
                this.w = null;
                this.B = 0;
                this.E = 1;
                if(mutex0.lock(null, this) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                object1 = null;
                v1 = 0;
                goto label_21;
            }
            case 1: {
                int v2 = this.B;
                object1 = this.w;
                Mutex mutex2 = this.r;
                d5.n.D(object0);
                v1 = v2;
                mutex1 = mutex2;
                try {
                label_21:
                    b b0 = this.I;
                    this.r = mutex1;
                    this.w = object1;
                    this.M = b0;
                    this.B = v1;
                    this.D = 0;
                    this.N = 0;
                    this.E = 2;
                    Enum enum0 = b0.w(this);
                    if(enum0 == a0) {
                        return a0;
                    }
                    int v3 = v1;
                    object0 = enum0;
                    int v4 = 0;
                    goto label_52;
                    try {
                    label_35:
                        int v5 = this.N;
                        int v6 = this.D;
                        v3 = this.B;
                        b b1 = this.M;
                        object2 = this.w;
                        mutex3 = this.r;
                        d5.n.D(object0);
                        v = v6;
                        mutex1 = mutex3;
                        v4 = v5;
                        b0 = b1;
                        object1 = object2;
                    }
                    catch(Throwable throwable0) {
                        object3 = object2;
                        mutex1 = mutex3;
                        goto label_72;
                    }
                label_52:
                    this.r = mutex1;
                    this.w = object1;
                    this.M = null;
                    this.B = v3;
                    this.D = v;
                    this.N = v4;
                    this.E = 3;
                    object0 = b0.l(((PlaylistId)object0), this);
                    if(object0 == a0) {
                        return a0;
                    }
                    object3 = object1;
                    break;
                }
                catch(Throwable throwable0) {
                    object3 = object1;
                    goto label_72;
                }
            }
            case 2: {
                goto label_35;
            }
            case 3: {
                try {
                    object3 = this.w;
                    mutex1 = this.r;
                    d5.n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                }
            label_72:
                mutex1.unlock(object3);
                throw throwable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex1.unlock(object3);
        return object0;
    }
}

