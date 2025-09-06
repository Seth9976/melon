package vd;

import J0.L;
import J0.o;
import J0.v;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.h;
import r1.l;
import we.k;
import we.n;
import x0.b;

public final class p extends h implements n {
    public final k B;
    public final b0 D;
    public final b0 E;
    public final a0 G;
    public int r;
    public Object w;

    public p(k k0, b0 b00, b0 b01, a0 a00, Continuation continuation0) {
        this.B = k0;
        this.D = b00;
        this.E = b01;
        this.G = a00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new p(this.B, this.D, this.E, this.G, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((p)this.create(((L)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return a.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        L l0 = (L)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                goto label_16;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        do {
            v v0 = (v)je.p.m0(((List)((J0.n)object0).a));
            if(v0 != null) {
                b b0 = new b(v0.c);
                this.D.setValue(b0);
                float f = ((float)(((int)(((l)this.E.getValue()).a >> 0x20)))) / 10.0f;
                int v1 = P4.a.j(((int)(Float.intBitsToFloat(((int)(v0.c >> 0x20))) / f + 1.0f)), 1, 10);
                ((K0)this.G).n(v1);
                Integer integer0 = new Integer(((K0)this.G).m());
                this.B.invoke(integer0);
            }
        label_16:
            this.w = l0;
            this.r = 1;
            object0 = l0.a(o.b, this);
        }
        while(object0 != a0);
        return a0;
    }
}

