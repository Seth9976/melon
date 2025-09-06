package o5;

import i5.b;
import i5.c;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.CoroutineScope;
import n5.m;
import ne.a;
import oe.i;
import t5.j;
import t5.o;
import we.n;

public final class d extends i implements n {
    public final H B;
    public final H D;
    public final j E;
    public final Object G;
    public final H I;
    public final c M;
    public int r;
    public final o5.i w;

    public d(o5.i i0, H h0, H h1, j j0, Object object0, H h2, c c0, Continuation continuation0) {
        this.w = i0;
        this.B = h0;
        this.D = h1;
        this.E = j0;
        this.G = object0;
        this.I = h2;
        this.M = c0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d(this.w, this.B, this.D, this.E, this.G, this.I, this.M, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                Object object1 = o5.i.b(this.w, ((m)this.B.a), ((b)this.D.a), this.E, this.G, ((o)this.I.a), this.M, this);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

