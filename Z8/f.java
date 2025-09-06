package Z8;

import com.gaa.sdk.iap.d;
import com.gaa.sdk.iap.k;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class f extends i implements n {
    public int r;
    public final g w;

    public f(g g0, Continuation continuation0) {
        this.w = g0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        g g0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                CompletableDeferred completableDeferred0 = g.a(g0);
                this.r = 1;
                object0 = completableDeferred0.await(this);
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
        List list0 = (List)((m)object0).b;
        LogU.Companion.d("OneStoreIapClientLifecycle", "updateOwnedPurchaseList() " + ((d)((m)object0).a).a + ", " + list0);
        if(((d)((m)object0).a).a()) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object1: list0) {
                if(((k)object1).a()) {
                    arrayList0.add(object1);
                }
            }
            for(Object object2: arrayList0) {
                g0.b(new Dc.i(26, g0, ((k)object2)));
            }
            g0.d.postValue(list0);
        }
        return H.a;
    }
}

