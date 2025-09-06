package mb;

import A8.l;
import A8.r;
import A8.u;
import Na.d;
import Na.e;
import b3.Z;
import com.iloen.melon.net.v4x.response.CheckConnectKakaoByAccessTokenRes;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kb.D;
import kotlin.jvm.internal.q;
import ne.a;
import oe.c;
import va.e0;
import va.g0;
import va.h0;
import va.i0;

public final class j {
    public final k a;
    public final f b;
    public final D c;
    public final LogU d;

    public j(k k0, f f0, D d0) {
        q.g(k0, "loginUseCase");
        super();
        this.a = k0;
        this.b = f0;
        this.c = d0;
        LogU logU0 = Z.g("LoginByKakaoFromSchemeUseCase", true);
        logU0.setCategory(Category.Login);
        this.d = logU0;
    }

    public final Object a(l l0, String s, String s1, String s2, c c0) {
        String s3;
        l l1;
        String s5;
        String s4;
        i i0;
        if(c0 instanceof i) {
            i0 = (i)c0;
            int v = i0.I;
            if((v & 0x80000000) == 0) {
                i0 = new i(this, c0);
            }
            else {
                i0.I = v ^ 0x80000000;
            }
        }
        else {
            i0 = new i(this, c0);
        }
        Object object0 = i0.E;
        a a0 = a.a;
        H h0 = H.a;
        switch(i0.I) {
            case 0: {
                n.D(object0);
                i0.r = l0;
                i0.w = s;
                i0.B = s1;
                i0.D = s2;
                i0.I = 1;
                object0 = this.c.e(l0.c, i0);
                if(object0 != a0) {
                label_39:
                    if(!(((Na.f)object0) instanceof e)) {
                        goto label_70;
                    }
                    CheckConnectKakaoByAccessTokenRes checkConnectKakaoByAccessTokenRes0 = (CheckConnectKakaoByAccessTokenRes)((e)(((Na.f)object0))).a;
                    if(!Cb.j.d(checkConnectKakaoByAccessTokenRes0)) {
                        Cb.j.b(checkConnectKakaoByAccessTokenRes0.notification, false, 3);
                        i0.r = null;
                        i0.w = null;
                        i0.B = null;
                        i0.D = null;
                        i0.I = 2;
                        return this.b.d(i0) != a0 ? h0 : a0;
                    }
                    i0.r = l0;
                    i0.w = s;
                    i0.B = s1;
                    i0.D = s2;
                    i0.I = 3;
                    if(((e0)this.a).z("token expired (from kakao scheme)", false, i0) != a0) {
                        l1 = l0;
                        s3 = s2;
                        s5 = s;
                        s4 = s1;
                    label_60:
                        i0.r = null;
                        i0.w = null;
                        i0.B = null;
                        i0.D = s3;
                        i0.I = 4;
                        object0 = this.b(l1, s5, s4, i0);
                        if(object0 != a0) {
                        label_67:
                            if(((i0)object0) instanceof h0 && s3 != null && s3.length() != 0) {
                                MelonLinkExecutor.open(s3);
                            }
                            return h0;
                        label_70:
                            if(!(((Na.f)object0) instanceof d)) {
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                            LogU.error$default(this.d, va.e.b("checkMelonConnectAndMelonLogin failed. ", ((d)(((Na.f)object0))).a.getMessage()), null, false, 6, null);
                            return h0;
                        }
                    }
                }
                break;
            }
            case 1: {
                s2 = i0.D;
                s1 = i0.B;
                s = i0.w;
                l0 = i0.r;
                n.D(object0);
                goto label_39;
            }
            case 2: {
                n.D(object0);
                return h0;
            }
            case 3: {
                s3 = i0.D;
                s4 = i0.B;
                s5 = i0.w;
                l1 = i0.r;
                n.D(object0);
                goto label_60;
            }
            case 4: {
                s3 = i0.D;
                n.D(object0);
                goto label_67;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final Object b(l l0, String s, String s1, c c0) {
        r.b.getClass();
        r r0 = z6.f.e(s);
        u.b.getClass();
        u u0 = z6.f.f(s1);
        k k0 = this.a;
        switch(r0.ordinal()) {
            case 5: {
                return ((e0)k0).s(l0, u0, c0);
            }
            case 6: {
                return ((e0)k0).u(l0, u0, c0);
            }
            case 7: {
                return ((e0)k0).t(l0, u0, c0);
            }
            default: {
                LogU.error$default(this.d, "loginBySchemeWithLoginTypeAndOption(), invalid loginType " + r0, null, false, 6, null);
                return new g0(null);
            }
        }
    }
}

