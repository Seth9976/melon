package ra;

import Cb.g;
import com.melon.net.ApiResult.Failure;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import com.melon.net.res.MusicDnaMainMonthlyLogRes;
import com.melon.net.res.MusicDnaMainRes;
import com.melon.net.res.MusicDnaMonthlyLogRes;
import d5.l;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import java.io.Serializable;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import va.e0;
import va.o;

public final class h {
    public final c a;
    public final l b;

    public h(c c0, l l0) {
        this.a = c0;
        this.b = l0;
    }

    public final Object a(oe.c c0) {
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
        a a0 = a.a;
        boolean z = true;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                d0.B = 1;
                object0 = FlowKt.firstOrNull(((g)this.b.c), d0);
                if(object0 == a0) {
                    return a0;
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
        if(((Boolean)object0) != null) {
            z = ((Boolean)object0).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    public final Serializable b(oe.c c0) {
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
        Serializable serializable0 = a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                e0.B = 1;
                String s = u.w(((e0)o.a()).j());
                object0 = this.a.a.a(s, e0);
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
            return (MusicDnaMainRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable c(String s, oe.c c0) {
        f f0;
        if(c0 instanceof f) {
            f0 = (f)c0;
            int v = f0.B;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, c0);
            }
            else {
                f0.B = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, c0);
        }
        Object object0 = f0.r;
        Serializable serializable0 = a.a;
        switch(f0.B) {
            case 0: {
                n.D(object0);
                f0.B = 1;
                String s1 = u.w(((e0)o.a()).j());
                object0 = this.a.a.e(s, s1, f0);
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
            return (MusicDnaMainMonthlyLogRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable d(String s, oe.c c0) {
        ra.g g0;
        if(c0 instanceof ra.g) {
            g0 = (ra.g)c0;
            int v = g0.B;
            if((v & 0x80000000) == 0) {
                g0 = new ra.g(this, c0);
            }
            else {
                g0.B = v ^ 0x80000000;
            }
        }
        else {
            g0 = new ra.g(this, c0);
        }
        Object object0 = g0.r;
        Serializable serializable0 = a.a;
        switch(g0.B) {
            case 0: {
                n.D(object0);
                g0.B = 1;
                String s1 = u.w(((e0)o.a()).j());
                object0 = this.a.a.b(s, s1, g0);
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
            return (MusicDnaMonthlyLogRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }
}

