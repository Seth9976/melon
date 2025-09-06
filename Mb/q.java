package mb;

import Cb.j;
import com.iloen.melon.LoginUser;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.response.TokenValidInformRes;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import ie.H;
import java.util.Date;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import va.j1;
import we.n;

public final class q extends i implements n {
    public final s B;
    public ApiResult r;
    public int w;

    public q(s s0, Continuation continuation0) {
        this.B = s0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q(this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ApiResult apiResult0;
        s s0 = this.B;
        l l0 = s0.a;
        a a0 = a.a;
        boolean z = false;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                if(!((j1)l0).n()) {
                    LogU.debug$default(s0.c, "checkTokenValidForMelon() fail: Not login", null, false, 6, null);
                    return false;
                }
                LoginUser loginUser0 = ((j1)l0).f;
                LogU.debug$default(s0.c, "checkTokenValidForMelon() fail: Invalid value userId = , Token isNullOrEmpty = " + true, null, false, 6, null);
                return false;
            }
            case 1: {
                d5.n.D(object0);
                apiResult0 = (ApiResult)object0;
                TokenValidInformRes tokenValidInformRes0 = (TokenValidInformRes)ApiResultKt.getOrNull(apiResult0);
                if(tokenValidInformRes0 != null) {
                    Date date0 = new Date(System.currentTimeMillis());
                    boolean z1 = j.d(tokenValidInformRes0);
                    LogU.debug$default(s0.c, "checkTokenValidForMelon() time: " + date0 + ", isSuccess: " + z1, null, false, 6, null);
                    j.b(tokenValidInformRes0.notification, false, 3);
                }
                if(s0.b.c() != null) {
                    this.r = apiResult0;
                    this.w = 2;
                    if(s.a(s0, this) == a0) {
                        return a0;
                    }
                }
                break;
            }
            case 2: {
                ApiResult apiResult1 = this.r;
                d5.n.D(object0);
                apiResult0 = apiResult1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(apiResult0 instanceof Success) {
            z = j.d(((HttpResponse)((Success)apiResult0).getData()));
        }
        return Boolean.valueOf(z);
    }
}

