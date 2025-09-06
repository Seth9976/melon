package m8;

import A8.j;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.utils.NameValuePairList;
import com.iloen.melon.utils.network.NetUtils;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import l8.d;
import mb.f;
import ne.a;
import oe.i;
import we.n;

public final class l extends i implements n {
    public final BaseActivity B;
    public final j D;
    public final m E;
    public int r;
    public final f w;

    public l(f f0, BaseActivity baseActivity0, j j0, m m0, Continuation continuation0) {
        this.w = f0;
        this.B = baseActivity0;
        this.D = j0;
        this.E = m0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = this.E.c1().getQueryParameter("url");
                NameValuePairList nameValuePairList0 = NetUtils.getQueryParamList(this.E.c1());
                d d0 = new d(this.B, 1);
                this.r = 1;
                return this.w.c(this.B, this.D, s, nameValuePairList0, d0, this) == a0 ? a0 : H.a;
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

