package ed;

import com.iloen.melon.net.v6x.response.SearchHotKeywordAndMenuListRes.Contents;
import java.util.List;
import je.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.n;

public final class z extends i implements n {
    public final F B;
    public final int D;
    public final List E;
    public final H G;
    public int r;
    public Object w;

    public z(F f0, int v, List list0, H h0, Continuation continuation0) {
        this.B = f0;
        this.D = v;
        this.E = list0;
        this.G = h0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new z(this.B, this.D, this.E, this.G, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s1;
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                goto label_22;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            F f0 = this.B;
            int v = f0.a + 1 < this.D ? f0.a + 1 : 0;
            f0.a = v;
            List list0 = this.E;
            if(list0 == null) {
                s1 = "";
            }
            else {
                Contents searchHotKeywordAndMenuListRes$Contents0 = (Contents)p.n0(v, list0);
                if(searchHotKeywordAndMenuListRes$Contents0 != null) {
                    String s = searchHotKeywordAndMenuListRes$Contents0.keyword;
                    if(s != null) {
                        s1 = s;
                    }
                }
            }
            n n0 = (n)this.G.a;
            if(n0 != null) {
                n0.invoke(new Integer(f0.a), s1);
            }
        label_22:
            if(!CoroutineScopeKt.isActive(coroutineScope0)) {
                break;
            }
            this.w = coroutineScope0;
            this.r = 1;
            if(DelayKt.delay(4000L, this) != a0) {
                continue;
            }
            return a0;
        }
        return ie.H.a;
    }
}

