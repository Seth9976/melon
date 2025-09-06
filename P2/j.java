package p2;

import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import je.q;
import kotlin.coroutines.Continuation;
import oe.i;
import q2.f;
import q2.h;
import we.n;

public final class j extends i implements n {
    public Object r;
    public final Set w;

    public j(Set set0, Continuation continuation0) {
        this.w = set0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new j(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j)this.create(((h)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Iterable iterable0 = ((h)this.r).a().keySet();
        ArrayList arrayList0 = new ArrayList(q.Q(10, iterable0));
        for(Object object1: iterable0) {
            arrayList0.add(((f)object1).a);
        }
        Set set0 = this.w;
        if(set0 != k.a) {
            if(!(set0 instanceof Collection) || !set0.isEmpty()) {
                for(Object object2: set0) {
                    if(arrayList0.contains(((String)object2))) {
                        continue;
                    }
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}

