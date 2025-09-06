package eb;

import Ba.O;
import com.iloen.melon.net.v4x.response.PvLogDummyRes;
import com.melon.net.ApiResult.Failure;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import d5.n;
import i.n.i.b.a.s.e.M3;
import java.io.Serializable;
import java.util.Map;
import kb.D;
import ne.a;
import oe.c;

public final class w {
    public final D a;

    public w(D d0) {
        this.a = d0;
    }

    public final Serializable a(String s, Map map0, c c0) {
        v v0;
        if(c0 instanceof v) {
            v0 = (v)c0;
            int v1 = v0.B;
            if((v1 & 0x80000000) == 0) {
                v0 = new v(this, c0);
            }
            else {
                v0.B = v1 ^ 0x80000000;
            }
        }
        else {
            v0 = new v(this, c0);
        }
        Object object0 = v0.r;
        Serializable serializable0 = a.a;
        switch(v0.B) {
            case 0: {
                n.D(object0);
                v0.B = 1;
                object0 = ((O)this.a.b).a(s, map0, v0);
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

