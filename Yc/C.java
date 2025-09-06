package yc;

import androidx.compose.runtime.l;
import com.iloen.melon.net.v4x.response.OneHourChartGraphRes.RESPONSE;
import com.melon.net.res.common.ResponseBase;
import ie.H;
import we.k;
import we.n;

public final class c implements n {
    public final int a;
    public final float b;
    public final k c;
    public final ResponseBase d;

    public c(ResponseBase responseBase0, float f, k k0, int v, int v1) {
        this.a = v1;
        this.d = responseBase0;
        this.b = f;
        this.c = k0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            i.e(((RESPONSE)this.d), this.b, this.c, ((l)object0), 1);
            return H.a;
        }
        ((Integer)object1).getClass();
        i.b(((com.iloen.melon.net.v4x.response.FiveMinuteChartGraphRes.RESPONSE)this.d), this.b, this.c, ((l)object0), 1);
        return H.a;
    }
}

