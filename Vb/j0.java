package Vb;

import com.iloen.melon.utils.log.LogConstantsKt;
import com.melon.playlist.interfaces.PlayableData;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.q;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class j0 extends i implements n {
    public final List B;
    public final o0 D;
    public final long E;
    public int r;
    public Object w;

    public j0(List list0, o0 o00, long v, Continuation continuation0) {
        this.B = list0;
        this.D = o00;
        this.E = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new j0(this.B, this.D, this.E, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        List list0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                ArrayList arrayList0 = new ArrayList(q.Q(10, list0));
                for(Object object1: list0) {
                    arrayList0.add(BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new i0(((PlayableData)object1), null), 3, null));
                }
                this.w = null;
                this.r = 1;
                object0 = AwaitKt.awaitAll(arrayList0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        List list1 = (List)object0;
        LogConstantsKt.debug(this.D.e1(), "toMediaItems() listSize:" + list0.size(), this.E);
        return object0;
    }
}

