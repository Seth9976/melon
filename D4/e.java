package D4;

import androidx.room.H;
import androidx.room.S;
import androidx.room.T;
import androidx.room.l;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class e extends i implements n {
    public Object B;
    public final H D;
    public final k E;
    public S r;
    public int w;

    public e(H h0, Continuation continuation0, k k0) {
        this.D = h0;
        this.E = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e(this.D, continuation0, this.E);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((T)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1;
        T t0;
        S s1;
        S s0;
        T t2;
        a a0 = a.a;
        int v = this.w;
        H h0 = this.D;
        switch(v) {
            case 0: {
                d5.n.D(object0);
                T t3 = (T)this.B;
                s0 = S.b;
                this.B = t3;
                this.r = s0;
                this.w = 1;
                Object object2 = t3.a(this);
                if(object2 != a0) {
                    t2 = t3;
                    object0 = object2;
                label_34:
                    if(((Boolean)object0).booleanValue()) {
                        s1 = s0;
                        t0 = t2;
                    label_45:
                        d d0 = new d(this.E, null);
                        this.B = t0;
                        this.r = null;
                        this.w = 3;
                        object0 = t0.b(s1, d0, this);
                        if(object0 != a0) {
                        label_51:
                            this.B = object0;
                            this.w = 4;
                            Object object3 = t0.a(this);
                            if(object3 != a0) {
                                object1 = object0;
                                object0 = object3;
                            label_57:
                                if(!((Boolean)object0).booleanValue()) {
                                    l l1 = h0.getInvalidationTracker();
                                    l1.c.e(l1.f, l1.g);
                                }
                                return object1;
                            }
                        }
                    }
                    else {
                        l l0 = h0.getInvalidationTracker();
                        this.B = t2;
                        this.r = s0;
                        this.w = 2;
                        if(l0.a(this) != a0) {
                            s1 = s0;
                            t0 = t2;
                            goto label_45;
                        }
                    }
                }
                break;
            }
            case 1: {
                s0 = this.r;
                t2 = (T)this.B;
                d5.n.D(object0);
                goto label_34;
            }
            case 2: {
                s0 = this.r;
                T t1 = (T)this.B;
                d5.n.D(object0);
                s1 = s0;
                t0 = t1;
                goto label_45;
            }
            case 3: {
                t0 = (T)this.B;
                d5.n.D(object0);
                goto label_51;
            }
            case 4: {
                object1 = this.B;
                d5.n.D(object0);
                goto label_57;
            }
            default: {
                if(v != 5) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                return object0;
            }
        }
        return a0;
    }
}

