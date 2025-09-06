package l2;

import android.content.SharedPreferences;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import o2.d;
import o2.f;
import oe.i;
import we.n;
import we.o;

public final class h extends i implements n {
    public Object B;
    public int D;
    public Object E;
    public final List G;
    public final ArrayList I;
    public Iterator r;
    public d w;

    public h(List list0, ArrayList arrayList0, Continuation continuation0) {
        this.G = list0;
        this.I = arrayList0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new h(this.G, this.I, continuation0);
        continuation1.E = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d d1;
        Iterator iterator1;
        Object object1;
        List list0;
        Iterator iterator0;
        a a0 = a.a;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                object0 = this.E;
                iterator0 = this.G.iterator();
                list0 = this.I;
                break;
            }
            case 1: {
                object1 = this.B;
                d d0 = this.w;
                iterator1 = this.r;
                List list1 = (List)this.E;
                d5.n.D(object0);
                d1 = d0;
                list0 = list1;
                goto label_32;
            }
            case 2: {
                iterator0 = this.r;
                list0 = (List)this.E;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(iterator0.hasNext()) {
            Object object2 = iterator0.next();
            this.E = list0;
            this.r = iterator0;
            this.w = (d)object2;
            this.B = object0;
            this.D = 1;
            Object object3 = ((d)object2).a(object0, this);
            if(object3 != a0) {
                object1 = object0;
                object0 = object3;
                d1 = (d)object2;
                iterator1 = iterator0;
            label_32:
                if(((Boolean)object0).booleanValue()) {
                    list0.add(new g(d1, null));
                    this.E = list0;
                    this.r = iterator1;
                    this.w = null;
                    this.B = null;
                    this.D = 2;
                    f f0 = new f(((SharedPreferences)d1.e.getValue()), d1.f);
                    object0 = ((o)d1.b).invoke(f0, object1, this);
                    if(object0 == a0) {
                        return a0;
                    }
                }
                else {
                    object0 = object1;
                }
                iterator0 = iterator1;
                continue;
            }
            return a0;
        }
        return object0;
    }
}

