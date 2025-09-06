package a5;

import G.g;
import U4.w;
import b5.e;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import ne.a;
import oe.i;
import we.n;

public final class b extends i implements n {
    public final c B;
    public int r;
    public Object w;

    public b(c c0, Continuation continuation0) {
        this.B = c0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new b(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b)this.create(((ProducerScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                ProducerScope producerScope0 = (ProducerScope)this.w;
                c c0 = this.B;
                a5.a a1 = new a5.a(c0, producerScope0);
                e e0 = c0.a;
                e0.getClass();
                synchronized(e0.c) {
                    if(e0.d.add(a1)) {
                        if(e0.d.size() == 1) {
                            e0.e = e0.a();
                            w.e().a("WM-ConstraintTracker", e0.getClass().getSimpleName() + ": initial state = " + e0.e);
                            e0.c();
                        }
                        Z4.b b0 = c0.e(e0.e) ? new Z4.b(c0.d()) : Z4.a.a;
                        producerScope0.getChannel().trySend-JP2dKIU(b0);
                    }
                }
                g g0 = new g(22, this.B, a1);
                this.r = 1;
                return ProduceKt.awaitClose(producerScope0, g0, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

