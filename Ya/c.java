package ya;

import Ba.G;
import com.iloen.melon.net.v4x.response.GiftInformGiftBoxReceiveRes;
import com.iloen.melon.net.v4x.response.GiftInformGiftBoxSendRes;
import com.melon.net.ApiResult.Failure;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import java.io.Serializable;
import va.e0;
import va.o;
import wa.a;

public final class c {
    public final a a;

    public c(a a0) {
        this.a = a0;
    }

    public final Serializable a(String s, oe.c c0) {
        ya.a a0;
        if(c0 instanceof ya.a) {
            a0 = (ya.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new ya.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new ya.a(this, c0);
        }
        Object object0 = a0.r;
        Serializable serializable0 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                a0.B = 1;
                String s1 = u.v(((e0)o.a()).j());
                object0 = ((G)this.a.a).c(s, s1, a0);
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
            return (GiftInformGiftBoxReceiveRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable b(String s, oe.c c0) {
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
        Serializable serializable0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                b0.B = 1;
                String s1 = u.v(((e0)o.a()).j());
                object0 = ((G)this.a.a).b(s, s1, b0);
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
            return (GiftInformGiftBoxSendRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }
}

