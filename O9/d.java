package O9;

import e.k;
import ie.H;
import java.util.List;
import jd.x2;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.n;

public final class d extends i implements n {
    public int r;
    public final e w;

    public d(e e0, Continuation continuation0) {
        this.w = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        e e0;
        a a0 = a.a;
        if(this.r != 0 && this.r != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        d5.n.D(object0);
        while(true) {
            e0 = this.w;
            if(e0.e.isEmpty()) {
                break;
            }
            x2 x20 = (x2)e0.e.poll();
            if(x20 != null) {
                List list0 = k.z(x20);
                e0.a.invoke(list0);
            }
            this.r = 1;
            if(DelayKt.delay(e0.f, this) == a0) {
                return a0;
            }
        }
        e0.g = false;
        return H.a;
    }
}

