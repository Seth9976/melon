package oa;

import E9.w;
import Oc.m;
import a.a;
import com.iloen.melon.net.v4x.response.InformArtistRes;
import com.iloen.melon.net.v6x.response.FeedLogsNewsCountRes;
import com.iloen.melon.userstore.VolatileDatabase_Impl;
import com.melon.net.ApiResult.Failure;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import com.melon.net.res.InfoCommerceAndBtnVer6Res;
import com.melon.net.res.NavigationMenuBenefitRes;
import com.melon.net.res.NavigationMenuListRes;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import java.io.Serializable;
import java.util.List;
import k8.Y;
import kb.D;
import oe.c;
import va.e0;
import va.o;
import x9.b;

public final class k {
    public final D a;
    public final D b;

    public k(D d0, D d1) {
        this.a = d0;
        this.b = d1;
    }

    public final Integer a(String s, List list0) {
        b b0 = (b)this.a.b;
        if(b0 != null) {
            StringBuilder stringBuilder0 = Y.p("delete from tab_menu_shortcut where menu_seq in ( ");
            int v = list0.size();
            a.k(v, stringBuilder0);
            stringBuilder0.append(" ) AND member_key = ");
            stringBuilder0.append("?");
            return new Integer(((int)(((Integer)w.N(((VolatileDatabase_Impl)b0.a), false, true, new m(stringBuilder0.toString(), list0, v, s, 12))))));
        }
        return new Integer(-1);
    }

    public final Serializable b(c c0) {
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
                String s = u.w(((e0)o.a()).j());
                object0 = ((Ba.u)this.b.b).c(s, f0);
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
            return (FeedLogsNewsCountRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Object c(c c0) {
        g g0;
        if(c0 instanceof g) {
            g0 = (g)c0;
            int v = g0.B;
            if((v & 0x80000000) == 0) {
                g0 = new g(this, c0);
            }
            else {
                g0.B = v ^ 0x80000000;
            }
        }
        else {
            g0 = new g(this, c0);
        }
        Object object0 = g0.r;
        ne.a a0 = ne.a.a;
        switch(g0.B) {
            case 0: {
                n.D(object0);
                g0.B = 1;
                String s = u.v(((e0)o.a()).j());
                object0 = ((Ba.u)this.b.b).d(s, g0);
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
        if(((ApiResult)object0) instanceof Success) {
            return (InfoCommerceAndBtnVer6Res)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable d(String s, c c0) {
        h h0;
        if(c0 instanceof h) {
            h0 = (h)c0;
            int v = h0.B;
            if((v & 0x80000000) == 0) {
                h0 = new h(this, c0);
            }
            else {
                h0.B = v ^ 0x80000000;
            }
        }
        else {
            h0 = new h(this, c0);
        }
        Object object0 = h0.r;
        Serializable serializable0 = ne.a.a;
        switch(h0.B) {
            case 0: {
                n.D(object0);
                h0.B = 1;
                String s1 = u.w(((e0)o.a()).j());
                object0 = ((Ba.u)this.b.b).a(s1, s, h0);
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
            return (InformArtistRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable e(String s, c c0) {
        i i0;
        if(c0 instanceof i) {
            i0 = (i)c0;
            int v = i0.B;
            if((v & 0x80000000) == 0) {
                i0 = new i(this, c0);
            }
            else {
                i0.B = v ^ 0x80000000;
            }
        }
        else {
            i0 = new i(this, c0);
        }
        Object object0 = i0.r;
        Serializable serializable0 = ne.a.a;
        switch(i0.B) {
            case 0: {
                n.D(object0);
                i0.B = 1;
                String s1 = u.v(((e0)o.a()).j());
                object0 = ((Ba.u)this.b.b).e(s1, s, i0);
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
            return (NavigationMenuBenefitRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable f(String s, String s1, c c0) {
        j j0;
        if(c0 instanceof j) {
            j0 = (j)c0;
            int v = j0.B;
            if((v & 0x80000000) == 0) {
                j0 = new j(this, c0);
            }
            else {
                j0.B = v ^ 0x80000000;
            }
        }
        else {
            j0 = new j(this, c0);
        }
        Object object0 = j0.r;
        Serializable serializable0 = ne.a.a;
        switch(j0.B) {
            case 0: {
                n.D(object0);
                j0.B = 1;
                object0 = ((Ba.u)this.b.b).b(s, s1, j0);
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
            return (NavigationMenuListRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }
}

