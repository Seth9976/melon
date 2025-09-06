package mb;

import Cb.j;
import android.accounts.Account;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.v4x.response.TokenValidExpireRes;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import ne.a;
import oe.c;
import va.j1;
import va.q1;
import va.t1;
import va.u1;

public final class n {
    public final u1 a;
    public final l b;

    public n(u1 u10, l l0) {
        q.g(u10, "simpleLoginRepository");
        q.g(l0, "melonLoginRepository");
        super();
        this.a = u10;
        this.b = l0;
    }

    public final Object a(String s, c c0) {
        m m0;
        if(c0 instanceof m) {
            m0 = (m)c0;
            int v = m0.D;
            if((v & 0x80000000) == 0) {
                m0 = new m(this, c0);
            }
            else {
                m0.D = v ^ 0x80000000;
            }
        }
        else {
            m0 = new m(this, c0);
        }
        Object object0 = m0.w;
        a a0 = a.a;
        u1 u10 = this.a;
        switch(m0.D) {
            case 0: {
                d5.n.D(object0);
                m0.r = s;
                m0.D = 1;
                t1 t10 = u10.a;
                Account account0 = t10.b(s);
                if(account0 == null) {
                    object0 = null;
                }
                else {
                    q1 q10 = new q1(t10, account0, null);
                    object0 = BuildersKt.withContext(t10.a, q10, m0);
                }
                if(object0 == a0) {
                    return a0;
                }
                goto label_30;
            }
            case 1: {
                s = m0.r;
                d5.n.D(object0);
            label_30:
                if(((String)object0) != null) {
                    m0.r = s;
                    m0.D = 2;
                    object0 = ((j1)this.b).a.a.b(s, ((String)object0), m0);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_38;
                }
                break;
            }
            case 2: {
                s = m0.r;
                d5.n.D(object0);
            label_38:
                if(((ApiResult)object0) instanceof Success) {
                    Notification httpResponse$Notification0 = ((TokenValidExpireRes)((Success)(((ApiResult)object0))).getData()).notification;
                    if(httpResponse$Notification0 != null) {
                        j.b(httpResponse$Notification0, false, 3);
                    }
                }
                break;
            }
            case 3: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        m0.r = null;
        m0.D = 3;
        Object object1 = u10.a.d(s, m0);
        return object1 == a0 ? a0 : object1;
    }
}

