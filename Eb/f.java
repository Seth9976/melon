package eb;

import Ba.H;
import com.iloen.melon.net.v4x.response.PvLogDummyRes;
import com.melon.net.ApiResult.Failure;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import d5.n;
import i.n.i.b.a.s.e.M3;
import java.io.Serializable;
import java.util.Map;
import oe.c;
import wa.a;

public final class f {
    public final a a;

    public f(a a0) {
        this.a = a0;
    }

    public final Serializable a(String s, Map map0, c c0) {
        e e0;
        if(c0 instanceof e) {
            e0 = (e)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new e(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new e(this, c0);
        }
        Object object0 = e0.r;
        Serializable serializable0 = ne.a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                e0.B = 1;
                object0 = ((H)this.a.a).a(s, map0, e0);
                if(object0 == serializable0) {
                    return serializable0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((ApiResult)object0) instanceof Success) {
            return (PvLogDummyRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }
}

