package androidx.room;

import ie.H;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;

public final class n extends i implements we.n {
    public final String[] B;
    public final p D;
    public Set r;
    public int w;

    public n(String[] arr_s, p p0, Continuation continuation0) {
        this.B = arr_s;
        this.D = p0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n(this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Set set1;
        a a0 = a.a;
        p p0 = this.D;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                Object[] arr_object = Arrays.copyOf(this.B, this.B.length);
                q.g(arr_object, "elements");
                Set set0 = je.n.A0(arr_object);
                this.r = set0;
                this.w = 1;
                if(p0.h.emit(set0, this) == a0) {
                    return a0;
                }
                set1 = set0;
                break;
            }
            case 1: {
                set1 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        q.g(set1, "tables");
        p0.b.e.lock();
        try {
            List list0 = je.p.P0(p0.b.d.values());
        }
        finally {
            p0.b.e.unlock();
        }
        for(Object object1: list0) {
            ((v)object1).a.getClass();
        }
        return H.a;
    }
}

