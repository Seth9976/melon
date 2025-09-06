package Wa;

import Bb.b;
import com.iloen.melon.playback.Playable;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import we.n;

public final class f extends i implements n {
    public final ArrayList B;
    public final String D;
    public int r;
    public Object w;

    public f(ArrayList arrayList0, String s, Continuation continuation0) {
        this.B = arrayList0;
        this.D = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new f(this.B, this.D, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        FlowCollector flowCollector0 = (FlowCollector)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                ArrayList arrayList0 = new ArrayList();
                ArrayList arrayList1 = this.B;
                for(Object object1: arrayList1) {
                    if(((Playable)object1).isOriginMelon()) {
                        arrayList0.add(object1);
                    }
                }
                if(arrayList0.isEmpty()) {
                    this.w = null;
                    this.r = 1;
                    if(flowCollector0.emit(o.a, this) == a0) {
                        return a0;
                    }
                }
                else {
                    m m0 = new m(b.b(b.a, this.D, arrayList1));
                    this.w = null;
                    this.r = 2;
                    if(flowCollector0.emit(m0, this) == a0) {
                        return a0;
                    }
                }
                return H.a;
            }
            case 1: 
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

