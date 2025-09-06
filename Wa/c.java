package wa;

import Ba.D;
import com.iloen.melon.net.v4x.response.NewSongListRes;
import com.melon.net.ApiResult.Failure;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import d5.n;
import i.n.i.b.a.s.e.M3;
import java.io.Serializable;

public final class c {
    public final a a;

    public c(a a0) {
        this.a = a0;
    }

    public final Serializable a(int v, int v1, String s, oe.c c0) {
        b b0;
        if(c0 instanceof b) {
            b0 = (b)c0;
            int v2 = b0.B;
            if((v2 & 0x80000000) == 0) {
                b0 = new b(this, c0);
            }
            else {
                b0.B = v2 ^ 0x80000000;
            }
        }
        else {
            b0 = new b(this, c0);
        }
        Object object0 = b0.r;
        Serializable serializable0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                b0.B = 1;
                object0 = ((D)this.a.a).a(v, v1, s, b0);
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
            return (NewSongListRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }
}

