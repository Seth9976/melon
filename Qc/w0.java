package qc;

import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class w0 extends i implements n {
    public final ArrayList B;
    public final Collection D;
    public final List E;
    public int r;
    public final C0 w;

    public w0(C0 c00, ArrayList arrayList0, Collection collection0, List list0, Continuation continuation0) {
        this.w = c00;
        this.B = arrayList0;
        this.D = collection0;
        this.E = list0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new w0(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((w0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                return this.w.a.removeAndAdd(this.B, this.D, this.E, this) == a0 ? a0 : H.a;
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

