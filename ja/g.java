package ja;

import Ba.m;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType2Res;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType3Res;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType5Res;
import com.iloen.melon.net.v5x.response.GenreDetailRes;
import com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes;
import com.melon.net.ApiResult.Failure;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import d5.n;
import i.n.i.b.a.s.e.Ga;
import i.n.i.b.a.s.e.M3;
import java.io.Serializable;
import oe.c;

public final class g {
    public final Ga a;

    public g(Ga ga0) {
        this.a = ga0;
    }

    public final Serializable a(String s, c c0) {
        a a0;
        if(c0 instanceof a) {
            a0 = (a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new a(this, c0);
        }
        Object object0 = a0.r;
        Serializable serializable0 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                a0.B = 1;
                object0 = ((m)this.a.b).b(s, a0);
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
            return (GenreDetailRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable b(int v, int v1, String s, String s1, c c0) {
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
                object0 = ((m)this.a.b).a(s, s1, v, v1, b0);
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
            return (GenreDetailGuiType2Res)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable c(int v, int v1, String s, c c0) {
        ja.c c1;
        if(c0 instanceof ja.c) {
            c1 = (ja.c)c0;
            int v2 = c1.B;
            if((v2 & 0x80000000) == 0) {
                c1 = new ja.c(this, c0);
            }
            else {
                c1.B = v2 ^ 0x80000000;
            }
        }
        else {
            c1 = new ja.c(this, c0);
        }
        Object object0 = c1.r;
        Serializable serializable0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                c1.B = 1;
                object0 = ((m)this.a.b).e(s, v, v1, c1);
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
            return (GenreDetailGuiType3Res)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable d(int v, int v1, String s, String s1, c c0) {
        d d0;
        if(c0 instanceof d) {
            d0 = (d)c0;
            int v2 = d0.B;
            if((v2 & 0x80000000) == 0) {
                d0 = new d(this, c0);
            }
            else {
                d0.B = v2 ^ 0x80000000;
            }
        }
        else {
            d0 = new d(this, c0);
        }
        Object object0 = d0.r;
        Serializable serializable0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                d0.B = 1;
                object0 = ((m)this.a.b).c(s, s1, v, v1, d0);
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
            return (GenreDetailGuiType4Res)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable e(String s, c c0) {
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
                object0 = ((m)this.a.b).d(s, e0);
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
            return (GenreDetailGuiType5Res)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable f(String s, String s1, c c0) {
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
        Serializable serializable0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                n.D(object0);
                f0.B = 1;
                object0 = ((m)this.a.b).f(s, s1, f0);
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
            return (GenreMenuDtlGnrsRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }
}

