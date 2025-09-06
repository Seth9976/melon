package oa;

import Ba.t;
import com.iloen.melon.net.v6x.response.MyMusicInformStorageRes;
import com.melon.net.ApiResult.Failure;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import java.io.Serializable;
import kb.D;
import ne.a;
import oe.c;
import va.e0;
import va.o;

public final class e {
    public final D a;

    public e(D d0) {
        this.a = d0;
    }

    public final Serializable a(c c0) {
        d d0;
        if(c0 instanceof d) {
            d0 = (d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new d(this, c0);
        }
        Object object0 = d0.r;
        Serializable serializable0 = a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                d0.B = 1;
                String s = u.v(((e0)o.a()).j());
                object0 = ((t)this.a.b).a(s, d0);
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
            return (MyMusicInformStorageRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }
}

