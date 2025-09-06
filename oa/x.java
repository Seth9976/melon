package oa;

import com.iloen.melon.net.v4x.response.AgeSongChartListRes;
import com.iloen.melon.net.v5x.response.ChartTopDailySongChartListRes;
import com.iloen.melon.net.v5x.response.ChartTopMonthlySongChartListRes;
import com.iloen.melon.net.v5x.response.ChartTopWeeklySongChartListRes;
import com.iloen.melon.net.v5x.response.DailySongChartListRes;
import com.iloen.melon.net.v5x.response.FlexibleRes;
import com.iloen.melon.net.v5x.response.MainMusicRes;
import com.iloen.melon.net.v6x.response.ChartHot100ListRes;
import com.iloen.melon.net.v6x.response.ChartTop100ListRes;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes;
import com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes;
import com.iloen.melon.utils.player.MediaCodecInfoCompat;
import com.melon.net.ApiResult.Failure;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import java.io.Serializable;
import ne.a;
import oe.c;
import va.e0;

public final class x {
    public final l a;

    public x(l l0) {
        this.a = l0;
    }

    public final Serializable a(String s, String s1, String s2, c c0) {
        m m0;
        if(c0 instanceof m) {
            m0 = (m)c0;
            int v = m0.B;
            if((v & 0x80000000) == 0) {
                m0 = new m(this, c0);
            }
            else {
                m0.B = v ^ 0x80000000;
            }
        }
        else {
            m0 = new m(this, c0);
        }
        Object object0 = m0.r;
        Serializable serializable0 = a.a;
        switch(m0.B) {
            case 0: {
                n.D(object0);
                m0.B = 1;
                object0 = this.a.a.l(1, 100, "N", s, s2, s1, m0);
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
            return (AgeSongChartListRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable b(String s, c c0) {
        oa.n n0;
        if(c0 instanceof oa.n) {
            n0 = (oa.n)c0;
            int v = n0.B;
            if((v & 0x80000000) == 0) {
                n0 = new oa.n(this, c0);
            }
            else {
                n0.B = v ^ 0x80000000;
            }
        }
        else {
            n0 = new oa.n(this, c0);
        }
        Object object0 = n0.r;
        Serializable serializable0 = a.a;
        switch(n0.B) {
            case 0: {
                n.D(object0);
                n0.B = 1;
                object0 = this.a.a.m(1, 100, s, n0);
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
            return (DailySongChartListRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable c(String s, c c0) {
        o o0;
        if(c0 instanceof o) {
            o0 = (o)c0;
            int v = o0.B;
            if((v & 0x80000000) == 0) {
                o0 = new o(this, c0);
            }
            else {
                o0.B = v ^ 0x80000000;
            }
        }
        else {
            o0 = new o(this, c0);
        }
        Object object0 = o0.r;
        Serializable serializable0 = a.a;
        switch(o0.B) {
            case 0: {
                n.D(object0);
                o0.B = 1;
                object0 = this.a.a.h(s, o0);
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
            return (ChartHot100ListRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable d(c c0) {
        p p0;
        if(c0 instanceof p) {
            p0 = (p)c0;
            int v = p0.B;
            if((v & 0x80000000) == 0) {
                p0 = new p(this, c0);
            }
            else {
                p0.B = v ^ 0x80000000;
            }
        }
        else {
            p0 = new p(this, c0);
        }
        Object object0 = p0.r;
        Serializable serializable0 = a.a;
        switch(p0.B) {
            case 0: {
                n.D(object0);
                p0.B = 1;
                object0 = this.a.a.j(p0);
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
            return (ChartTop100ListRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable e(c c0) {
        q q0;
        if(c0 instanceof q) {
            q0 = (q)c0;
            int v = q0.B;
            if((v & 0x80000000) == 0) {
                q0 = new q(this, c0);
            }
            else {
                q0.B = v ^ 0x80000000;
            }
        }
        else {
            q0 = new q(this, c0);
        }
        Object object0 = q0.r;
        Serializable serializable0 = a.a;
        switch(q0.B) {
            case 0: {
                n.D(object0);
                q0.B = 1;
                object0 = this.a.a.e(1, 100, "DP0000", q0);
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
            return (ChartTopDailySongChartListRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable f(c c0) {
        r r0;
        if(c0 instanceof r) {
            r0 = (r)c0;
            int v = r0.B;
            if((v & 0x80000000) == 0) {
                r0 = new r(this, c0);
            }
            else {
                r0.B = v ^ 0x80000000;
            }
        }
        else {
            r0 = new r(this, c0);
        }
        Object object0 = r0.r;
        Serializable serializable0 = a.a;
        switch(r0.B) {
            case 0: {
                n.D(object0);
                r0.B = 1;
                object0 = this.a.a.f(1, 100, "Y", "DP0000", r0);
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
            return (ChartTopMonthlySongChartListRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable g(c c0) {
        s s0;
        if(c0 instanceof s) {
            s0 = (s)c0;
            int v = s0.B;
            if((v & 0x80000000) == 0) {
                s0 = new s(this, c0);
            }
            else {
                s0.B = v ^ 0x80000000;
            }
        }
        else {
            s0 = new s(this, c0);
        }
        Object object0 = s0.r;
        Serializable serializable0 = a.a;
        switch(s0.B) {
            case 0: {
                n.D(object0);
                s0.B = 1;
                object0 = this.a.a.k(1, 100, "DP0000", s0);
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
            return (ChartTopWeeklySongChartListRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable h(c c0) {
        t t0;
        if(c0 instanceof t) {
            t0 = (t)c0;
            int v = t0.B;
            if((v & 0x80000000) == 0) {
                t0 = new t(this, c0);
            }
            else {
                t0.B = v ^ 0x80000000;
            }
        }
        else {
            t0 = new t(this, c0);
        }
        Object object0 = t0.r;
        Serializable serializable0 = a.a;
        switch(t0.B) {
            case 0: {
                n.D(object0);
                t0.B = 1;
                String s = u.v(((e0)va.o.a()).j());
                String s1 = MediaCodecInfoCompat.isAc4Supported() ? "FDBSY" : "";
                object0 = this.a.a.c(s, s1, t0);
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
            return (FlexibleRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable i(c c0) {
        oa.u u0;
        if(c0 instanceof oa.u) {
            u0 = (oa.u)c0;
            int v = u0.B;
            if((v & 0x80000000) == 0) {
                u0 = new oa.u(this, c0);
            }
            else {
                u0.B = v ^ 0x80000000;
            }
        }
        else {
            u0 = new oa.u(this, c0);
        }
        Object object0 = u0.r;
        Serializable serializable0 = a.a;
        switch(u0.B) {
            case 0: {
                n.D(object0);
                u0.B = 1;
                String s = u.v(((e0)va.o.a()).j());
                String s1 = MediaCodecInfoCompat.isAc4Supported() ? "FDBSY" : "";
                object0 = this.a.a.a(s, s1, u0);
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
            return (MainMusicRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable j(String s, c c0) {
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
                String s1 = u.v(((e0)va.o.a()).j());
                object0 = this.a.a.g(s1, s, v0);
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
            return (MusicTabTitleBarBannerRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable k(String s, String s1, c c0) {
        w w0;
        if(c0 instanceof w) {
            w0 = (w)c0;
            int v = w0.B;
            if((v & 0x80000000) == 0) {
                w0 = new w(this, c0);
            }
            else {
                w0.B = v ^ 0x80000000;
            }
        }
        else {
            w0 = new w(this, c0);
        }
        Object object0 = w0.r;
        Serializable serializable0 = a.a;
        switch(w0.B) {
            case 0: {
                n.D(object0);
                w0.B = 1;
                String s2 = u.v(((e0)va.o.a()).j());
                object0 = this.a.a.b(s2, s, s1, w0);
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
            return (MainTopNotificationRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }
}

