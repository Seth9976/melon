package D4;

import androidx.room.H;
import androidx.room.S;
import androidx.room.T;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.i;
import we.k;
import we.n;
import z4.v;

public final class m extends i implements n {
    public Object B;
    public final boolean D;
    public final boolean E;
    public final H G;
    public final k I;
    public S r;
    public int w;

    public m(H h0, Continuation continuation0, k k0, boolean z, boolean z1) {
        this.D = z;
        this.E = z1;
        this.G = h0;
        this.I = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new m(this.G, continuation0, this.I, this.D, this.E);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m)this.create(((T)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1;
        T t0;
        S s1;
        S s0;
        T t2;
        a a0 = a.a;
        k k0 = this.I;
        H h0 = this.G;
        boolean z = this.E;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                T t3 = (T)this.B;
                if(this.D) {
                    s0 = z ? S.a : S.b;
                    if(z) {
                        t0 = t3;
                        s1 = s0;
                    label_48:
                        l l1 = new l(k0, null);
                        this.B = t0;
                        this.r = null;
                        this.w = 3;
                        object0 = t0.b(s1, l1, this);
                        if(object0 != a0) {
                        label_54:
                            if(z) {
                                return object0;
                            }
                            this.B = object0;
                            this.w = 4;
                            Object object3 = t0.a(this);
                            if(object3 != a0) {
                                object1 = object0;
                                object0 = object3;
                            label_61:
                                if(!((Boolean)object0).booleanValue()) {
                                    androidx.room.l l2 = h0.getInvalidationTracker();
                                    l2.c.e(l2.f, l2.g);
                                }
                                return object1;
                            }
                        }
                    }
                    else {
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
                                goto label_48;
                            }
                            else {
                                androidx.room.l l0 = h0.getInvalidationTracker();
                                this.B = t2;
                                this.r = s0;
                                this.w = 2;
                                if(l0.a(this) != a0) {
                                    s1 = s0;
                                    t0 = t2;
                                    goto label_48;
                                }
                            }
                        }
                    }
                    return a0;
                }
                q.e(t3, "null cannot be cast to non-null type androidx.room.coroutines.RawConnectionAccessor");
                return k0.invoke(((v)t3).c());
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
                goto label_48;
            }
            case 3: {
                t0 = (T)this.B;
                d5.n.D(object0);
                goto label_54;
            }
            case 4: {
                object1 = this.B;
                d5.n.D(object0);
                goto label_61;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

