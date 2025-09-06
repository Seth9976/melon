package mb;

import Cb.j;
import android.content.Context;
import b3.Z;
import com.iloen.melon.net.v4x.response.TokenValidInformRes;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.kakao.sdk.user.model.AccessTokenInfo;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import ie.H;
import ie.o;
import java.util.Date;
import kotlin.jvm.internal.q;
import ne.a;
import oe.c;
import va.j1;
import va.n;

public final class s {
    public final l a;
    public final n b;
    public final LogU c;

    public s(Context context0, l l0, n n0) {
        q.g(context0, "context");
        q.g(l0, "melonLoginRepository");
        q.g(n0, "kakaoLoginRepository");
        super();
        this.a = l0;
        this.b = n0;
        LogU logU0 = Z.g("TokenCheckUseCase", true);
        logU0.setCategory(Category.Login);
        this.c = logU0;
    }

    public static final Object a(s s0, c c0) {
        Object object1;
        p p0;
        n n0 = s0.b;
        if(c0 instanceof p) {
            p0 = (p)c0;
            int v = p0.B;
            if((v & 0x80000000) == 0) {
                p0 = new p(s0, c0);
            }
            else {
                p0.B = v ^ 0x80000000;
            }
        }
        else {
            p0 = new p(s0, c0);
        }
        Object object0 = p0.r;
        a a0 = a.a;
        H h0 = H.a;
        switch(p0.B) {
            case 0: {
                d5.n.D(object0);
                if(n0.c() != null) {
                    p0.B = 1;
                    object1 = n0.b(p0);
                    if(object1 == a0) {
                        return a0;
                    }
                    goto label_25;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                object1 = ((ie.p)object0).a;
            label_25:
                Long long0 = null;
                Object object2 = object1 instanceof o ? null : object1;
                LogU logU0 = s0.c;
                Date date0 = new Date(System.currentTimeMillis());
                Long long1 = ((AccessTokenInfo)object2) == null ? null : ((AccessTokenInfo)object2).getId();
                Integer integer0 = ((AccessTokenInfo)object2) == null ? null : new Integer(((AccessTokenInfo)object2).getAppId());
                if(((AccessTokenInfo)object2) != null) {
                    long0 = new Long(((AccessTokenInfo)object2).getExpiresIn());
                }
                LogU.debug$default(logU0, "checkTokenValidForKakao() - time: " + date0 + ", id: " + long1 + ", appId: " + integer0 + ", expiresIn: " + long0, null, false, 6, null);
                if(object1 instanceof o) {
                    Throwable throwable0 = ie.p.a(object1);
                    LogU.debug$default(s0.c, "checkTokenValidForKakao() fail: " + throwable0, null, false, 6, null);
                    p0.B = 2;
                    if(n0.g(p0) == a0) {
                        return a0;
                    }
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }

    public final Object b(String s, String s1, c c0) {
        r r0;
        if(c0 instanceof r) {
            r0 = (r)c0;
            int v = r0.B;
            if((v & 0x80000000) == 0) {
                r0 = new r(this, c0);
            }
            else {
                r0.B = v ^ 0x80000000;
            }
        }
        else {
            r0 = new r(this, c0);
        }
        Object object0 = r0.r;
        a a0 = a.a;
        switch(r0.B) {
            case 0: {
                d5.n.D(object0);
                LogU.debug$default(this.c, "checkTokenValidWithSpecific() userId: " + s, null, false, 6, null);
                r0.B = 1;
                object0 = ((j1)this.a).a.a.e(s, s1, r0);
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
        if(((ApiResult)object0) instanceof Success) {
            if(!j.d(((TokenValidInformRes)((Success)(((ApiResult)object0))).getData()))) {
                LogU.debug$default(this.c, "checkTokenValidWithSpecific api success but failed", null, false, 6, null);
                return false;
            }
            return true;
        }
        LogU.debug$default(this.c, "checkTokenValidWithSpecific failed", null, false, 6, null);
        return false;
    }
}

