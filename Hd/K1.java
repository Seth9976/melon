package hd;

import androidx.lifecycle.f0;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE;
import com.melon.net.res.MusicDnaMainMonthlyLogRes;
import ie.H;
import java.util.ArrayList;
import je.q;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import ne.a;
import oe.i;
import we.n;

public final class k1 extends i implements n {
    public int r;
    public final m1 w;

    public k1(m1 m10, Continuation continuation0) {
        this.w = m10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k1(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        X0 x00 = null;
        m1 m10 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(f0.h(m10), null, null, new j1(m10, null), 3, null);
                this.r = 1;
                object0 = deferred0.await(this);
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
        if(((MusicDnaMainMonthlyLogRes)object0) != null) {
            RESPONSE musicDnaMainMonthlyLogRes$RESPONSE0 = ((MusicDnaMainMonthlyLogRes)object0).response;
            if(musicDnaMainMonthlyLogRes$RESPONSE0 != null) {
                Object object1 = m10.getUiState().getValue();
                if(object1 instanceof X0) {
                    x00 = (X0)object1;
                }
                if(x00 != null) {
                    ArrayList arrayList0 = new ArrayList(q.Q(10, x00.a));
                    for(Object object2: x00.a) {
                        U0 u00 = (U0)object2;
                        if(u00 instanceof R0) {
                            u00 = new R0(musicDnaMainMonthlyLogRes$RESPONSE0, m10.l, m10.e(((String)m10.i.getValue())));
                        }
                        arrayList0.add(u00);
                    }
                    m10.updateUiState(new hd.i(new X0(arrayList0), 3));
                }
            }
        }
        return H.a;
    }
}

