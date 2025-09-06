package ed;

import Na.e;
import Na.f;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import com.iloen.melon.net.v6x.request.SearchNextTagListReq.Params;
import com.iloen.melon.net.v6x.response.SearchNextTagListRes.Response;
import com.iloen.melon.net.v6x.response.SearchNextTagListRes;
import com.iloen.melon.net.v6x.response.SearchTagBase;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.a;
import we.k;
import we.n;

public final class y0 extends i implements n {
    public final Params B;
    public final b0 D;
    public final SearchTagBase E;
    public final a G;
    public final k I;
    public int r;
    public final F0 w;

    public y0(F0 f00, Params searchNextTagListReq$Params0, b0 b00, SearchTagBase searchTagBase0, a a0, k k0, Continuation continuation0) {
        this.w = f00;
        this.B = searchNextTagListReq$Params0;
        this.D = b00;
        this.E = searchTagBase0;
        this.G = a0;
        this.I = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new y0(this.w, this.B, this.D, this.E, this.G, this.I, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Response searchNextTagListRes$Response0;
        ne.a a0 = ne.a.a;
        F0 f00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = f00.g.c(this.B, this);
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
        if(((f)object0) instanceof e) {
            searchNextTagListRes$Response0 = ((SearchNextTagListRes)((e)(((f)object0))).a).response;
            if(searchNextTagListRes$Response0 == null) {
                searchNextTagListRes$Response0 = null;
            }
        }
        else {
            searchNextTagListRes$Response0 = null;
        }
        ((O0)this.D).setValue(Boolean.TRUE);
        K0 k00 = new K0(new ed.O0(this.E.disPlayKeyword, this.E.landingUrl, q.b(this.E.promotionYn, "Y")), searchNextTagListRes$Response0, this.G, this.I);
        f00.k.add(k00);
        return H.a;
    }
}

