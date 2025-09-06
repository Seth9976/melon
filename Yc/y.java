package yc;

import com.iloen.melon.net.v4x.response.OneHourChartGraphRes.RESPONSE;
import com.melon.net.res.common.ResponseBase;
import com.melon.ui.b1;
import com.melon.ui.c1;
import com.melon.ui.c3;
import com.melon.ui.d1;
import ie.H;
import kotlin.jvm.internal.q;
import p8.s;
import q8.b;
import we.k;

public final class y implements k {
    public final int a;
    public final E b;

    public y(E e0, int v) {
        this.a = v;
        this.b = e0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        String s = "";
        E e0 = this.b;
        String s1 = null;
        switch(this.a) {
            case 0: {
                q.g(((b)object0), "$this$common");
                ((b)object0).a = "";
                s s2 = e0.getTiaraProperty();
                if(s2 != null) {
                    s1 = s2.b;
                }
                if(s1 != null) {
                    s = s1;
                }
                ((b)object0).b = s;
                return h0;
            }
            case 1: {
                q.g(((b)object0), "$this$common");
                ((b)object0).a = "";
                s s3 = e0.getTiaraProperty();
                if(s3 != null) {
                    s1 = s3.b;
                }
                if(s1 != null) {
                    s = s1;
                }
                ((b)object0).b = s;
                return h0;
            }
            case 2: {
                if(((d1)object0) instanceof c1) {
                    ResponseBase responseBase1 = ((c1)(((d1)object0))).a;
                    e0.setTiaraProperty(new s(responseBase1.section, "", responseBase1.menuId, null));
                    if(responseBase1 instanceof RESPONSE) {
                        e0.g = ((RESPONSE)responseBase1).getChartInfo();
                        return new m(((RESPONSE)responseBase1));
                    }
                    return new j(new c3(null, 0, false, null, 15));
                }
                return ((d1)object0) instanceof b1 ? new l(((b1)(((d1)object0))).a) : null;
            }
            default: {
                if(((d1)object0) instanceof c1) {
                    ResponseBase responseBase0 = ((c1)(((d1)object0))).a;
                    e0.setTiaraProperty(new s(responseBase0.section, "", responseBase0.menuId, null));
                    return responseBase0 instanceof com.iloen.melon.net.v4x.response.FiveMinuteChartGraphRes.RESPONSE ? new yc.k(((com.iloen.melon.net.v4x.response.FiveMinuteChartGraphRes.RESPONSE)responseBase0)) : new j(new c3(null, 0, false, null, 15));
                }
                return ((d1)object0) instanceof b1 ? new l(((b1)(((d1)object0))).a) : null;
            }
        }
    }
}

