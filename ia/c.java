package Ia;

import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import d5.n;
import e1.u;
import java.util.ArrayList;
import va.e0;
import va.o;

public final class c {
    public final a a;

    public c(a a0) {
        this.a = a0;
    }

    public final Object a(ArrayList arrayList0, oe.c c0) {
        b b0;
        if(c0 instanceof b) {
            b0 = (b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new b(this, c0);
        }
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                b0.B = 1;
                String s = u.w(((e0)o.a()).j());
                object0 = this.a.a.a(arrayList0, s, b0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

