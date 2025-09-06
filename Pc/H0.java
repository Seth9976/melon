package pc;

import android.net.Uri;
import com.iloen.melon.LoginUser;
import com.iloen.melon.MixUpPreference;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.datastore.LoginUserPreferencesSerializer;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.ui.K4;
import d5.n;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.m;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oc.Q;
import pd.r;
import qb.F;
import qb.G;
import qb.h;
import qb.i;
import qb.k;
import qb.o;
import qb.p;
import td.E;
import td.I;
import ud.z0;
import va.m0;
import va.o0;
import va.p0;
import va.r0;
import w8.C0;
import w8.G0;
import w8.K0;
import w8.e0;
import w8.f0;
import w8.g0;
import w8.q0;
import wb.b;
import wb.c;
import wb.d;
import wb.e;
import wb.f;

public final class h0 implements FlowCollector {
    public final int a;
    public final FlowCollector b;

    public h0(FlowCollector flowCollector0, int v) {
        this.a = v;
        this.b = flowCollector0;
        super();
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        K0 k00;
        G0 g02;
        C0 c00;
        q0 q01;
        g0 g01;
        f0 f00;
        e0 e00;
        r0 r00;
        va.q0 q00;
        p0 p01;
        o0 o00;
        m0 m00;
        z0 z00;
        I i1;
        E e0;
        i i0;
        G g0;
        h h0;
        F f0;
        r r0;
        k0 k01;
        pc.g0 g00;
        switch(this.a) {
            case 0: {
                if(continuation0 instanceof pc.g0) {
                    g00 = (pc.g0)continuation0;
                    int v1 = g00.w;
                    if((v1 & 0x80000000) == 0) {
                        g00 = new pc.g0(this, continuation0);
                    }
                    else {
                        g00.w = v1 ^ 0x80000000;
                    }
                }
                else {
                    g00 = new pc.g0(this, continuation0);
                }
                Object object2 = g00.r;
                a a1 = a.a;
                switch(g00.w) {
                    case 0: {
                        n.D(object2);
                        Integer integer0 = new Integer(((MixUpPreference)object0).getFirstPositionOnWaitingList());
                        g00.w = 1;
                        return this.b.emit(integer0, g00) != a1 ? H.a : a1;
                    }
                    case 1: {
                        n.D(object2);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 1: {
                if(continuation0 instanceof k0) {
                    k01 = (k0)continuation0;
                    int v2 = k01.w;
                    if((v2 & 0x80000000) == 0) {
                        k01 = new k0(this, continuation0);
                    }
                    else {
                        k01.w = v2 ^ 0x80000000;
                    }
                }
                else {
                    k01 = new k0(this, continuation0);
                }
                Object object3 = k01.r;
                a a2 = a.a;
                switch(k01.w) {
                    case 0: {
                        n.D(object3);
                        q.f("", "getMainTitle(...)");
                        q.f("", "getSubTitle(...)");
                        q.f("", "getContsId(...)");
                        q.f("", "getMixType(...)");
                        pc.a a3 = new pc.a("", "", "", "");
                        k01.w = 1;
                        return this.b.emit(a3, k01) != a2 ? H.a : a2;
                    }
                    case 1: {
                        n.D(object3);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 2: {
                if(continuation0 instanceof r) {
                    r0 = (r)continuation0;
                    int v3 = r0.w;
                    if((v3 & 0x80000000) == 0) {
                        r0 = new r(this, continuation0);
                    }
                    else {
                        r0.w = v3 ^ 0x80000000;
                    }
                }
                else {
                    r0 = new r(this, continuation0);
                }
                Object object4 = r0.r;
                a a4 = a.a;
                switch(r0.w) {
                    case 0: {
                        n.D(object4);
                        long v4 = ((pd.a)object0).g;
                        m m0 = ((pd.a)object0).i ? new m(new Long(((pd.a)object0).h), new Long(v4)) : new m(new Long(((pd.a)object0).f), new Long(v4));
                        r0.w = 1;
                        return this.b.emit(m0, r0) != a4 ? H.a : a4;
                    }
                    case 1: {
                        n.D(object4);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 3: {
                if(continuation0 instanceof F) {
                    f0 = (F)continuation0;
                    int v5 = f0.w;
                    if((v5 & 0x80000000) == 0) {
                        f0 = new F(this, continuation0);
                    }
                    else {
                        f0.w = v5 ^ 0x80000000;
                    }
                }
                else {
                    f0 = new F(this, continuation0);
                }
                Object object5 = f0.r;
                a a5 = a.a;
                switch(f0.w) {
                    case 0: {
                        n.D(object5);
                        if(((f)object0) instanceof b) {
                            h0 = new h(((b)(((f)object0))).a);
                        }
                        else {
                            if(((f)object0) instanceof c) {
                                q.f("", "getAlbumid(...)");
                                h0 = new qb.n("");
                                f0.w = 1;
                                return this.b.emit(h0, f0) != a5 ? H.a : a5;
                            }
                            if(((f)object0) instanceof e) {
                                h0 = new p(((e)(((f)object0))).a);
                            }
                            else if(((f)object0) instanceof d) {
                                h0 = new k(new Exception("not use this function"));
                            }
                            else {
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                        }
                        f0.w = 1;
                        return this.b.emit(h0, f0) != a5 ? H.a : a5;
                    }
                    case 1: {
                        n.D(object5);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 4: {
                if(continuation0 instanceof G) {
                    g0 = (G)continuation0;
                    int v6 = g0.w;
                    if((v6 & 0x80000000) == 0) {
                        g0 = new G(this, continuation0);
                    }
                    else {
                        g0.w = v6 ^ 0x80000000;
                    }
                }
                else {
                    g0 = new G(this, continuation0);
                }
                Object object6 = g0.r;
                a a6 = a.a;
                switch(g0.w) {
                    case 0: {
                        n.D(object6);
                        if(((f)object0) instanceof b) {
                            i0 = new i(((b)(((f)object0))).a);
                        }
                        else {
                            if(((f)object0) instanceof c) {
                                Playable playable0 = ((c)(((f)object0))).a;
                                if(((c)(((f)object0))).a.getArtists().size() > 1) {
                                    Map map0 = playable0.getArtists();
                                    q.f(map0, "getArtists(...)");
                                    i0 = new qb.r(map0, playable0);
                                    g0.w = 1;
                                    return this.b.emit(i0, g0) != a6 ? H.a : a6;
                                }
                                String s = playable0.getArtistid();
                                if(s != null && s.length() != 0 && StringIds.a(s, StringIds.e)) {
                                    i0 = new o(s);
                                    g0.w = 1;
                                    return this.b.emit(i0, g0) != a6 ? H.a : a6;
                                }
                                i0 = new i(new Exception("showArtistInfoPage() invalid artistId"));
                                g0.w = 1;
                                return this.b.emit(i0, g0) != a6 ? H.a : a6;
                            }
                            if(((f)object0) instanceof d) {
                                i0 = new k(new Exception("not use this function"));
                            }
                            else if(((f)object0) instanceof e) {
                                i0 = new p(((e)(((f)object0))).a);
                            }
                            else {
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                        }
                        g0.w = 1;
                        return this.b.emit(i0, g0) != a6 ? H.a : a6;
                    }
                    case 1: {
                        n.D(object6);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 5: {
                if(continuation0 instanceof E) {
                    e0 = (E)continuation0;
                    int v7 = e0.w;
                    if((v7 & 0x80000000) == 0) {
                        e0 = new E(this, continuation0);
                    }
                    else {
                        e0.w = v7 ^ 0x80000000;
                    }
                }
                else {
                    e0 = new E(this, continuation0);
                }
                Object object7 = e0.r;
                a a7 = a.a;
                switch(e0.w) {
                    case 0: {
                        n.D(object7);
                        e0.w = 1;
                        return this.b.emit((((K4)object0) instanceof td.p0 ? ((td.p0)(((K4)object0))) : null), e0) != a7 ? H.a : a7;
                    }
                    case 1: {
                        n.D(object7);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 6: {
                if(continuation0 instanceof I) {
                    i1 = (I)continuation0;
                    int v8 = i1.w;
                    if((v8 & 0x80000000) == 0) {
                        i1 = new I(this, continuation0);
                    }
                    else {
                        i1.w = v8 ^ 0x80000000;
                    }
                }
                else {
                    i1 = new I(this, continuation0);
                }
                Object object8 = i1.r;
                a a8 = a.a;
                switch(i1.w) {
                    case 0: {
                        n.D(object8);
                        Uri uri0 = null;
                        td.p0 p00 = ((K4)object0) instanceof td.p0 ? ((td.p0)(((K4)object0))) : null;
                        if(p00 != null) {
                            uri0 = p00.e;
                        }
                        i1.w = 1;
                        return this.b.emit(uri0, i1) != a8 ? H.a : a8;
                    }
                    case 1: {
                        n.D(object8);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 7: {
                if(continuation0 instanceof z0) {
                    z00 = (z0)continuation0;
                    int v9 = z00.w;
                    if((v9 & 0x80000000) == 0) {
                        z00 = new z0(this, continuation0);
                    }
                    else {
                        z00.w = v9 ^ 0x80000000;
                    }
                }
                else {
                    z00 = new z0(this, continuation0);
                }
                Object object9 = z00.r;
                a a9 = a.a;
                switch(z00.w) {
                    case 0: {
                        n.D(object9);
                        String s1 = ((ud.h0)object0) == null ? null : ((ud.h0)object0).a;
                        if(s1 != null) {
                            z00.w = 1;
                            if(this.b.emit(s1, z00) == a9) {
                                return a9;
                            }
                        }
                        return H.a;
                    }
                    case 1: {
                        n.D(object9);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 8: {
                if(continuation0 instanceof m0) {
                    m00 = (m0)continuation0;
                    int v10 = m00.w;
                    if((v10 & 0x80000000) == 0) {
                        m00 = new m0(this, continuation0);
                    }
                    else {
                        m00.w = v10 ^ 0x80000000;
                    }
                }
                else {
                    m00 = new m0(this, continuation0);
                }
                Object object10 = m00.r;
                a a10 = a.a;
                switch(m00.w) {
                    case 0: {
                        n.D(object10);
                        int v11 = ((LoginUser)object0).getAutoLoginIntervalTimeForDeveloper();
                        if(v11 < 1) {
                            v11 = 360;
                        }
                        m00.w = 1;
                        return this.b.emit(new Integer(v11), m00) != a10 ? H.a : a10;
                    }
                    case 1: {
                        n.D(object10);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 9: {
                if(continuation0 instanceof o0) {
                    o00 = (o0)continuation0;
                    int v12 = o00.w;
                    if((v12 & 0x80000000) == 0) {
                        o00 = new o0(this, continuation0);
                    }
                    else {
                        o00.w = v12 ^ 0x80000000;
                    }
                }
                else {
                    o00 = new o0(this, continuation0);
                }
                Object object11 = o00.r;
                a a11 = a.a;
                switch(o00.w) {
                    case 0: {
                        n.D(object11);
                        Long long0 = new Long(((LoginUser)object0).getAutoLoginSuccessTime());
                        o00.w = 1;
                        return this.b.emit(long0, o00) != a11 ? H.a : a11;
                    }
                    case 1: {
                        n.D(object11);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 10: {
                if(continuation0 instanceof p0) {
                    p01 = (p0)continuation0;
                    int v13 = p01.w;
                    if((v13 & 0x80000000) == 0) {
                        p01 = new p0(this, continuation0);
                    }
                    else {
                        p01.w = v13 ^ 0x80000000;
                    }
                }
                else {
                    p01 = new p0(this, continuation0);
                }
                Object object12 = p01.r;
                a a12 = a.a;
                switch(p01.w) {
                    case 0: {
                        n.D(object12);
                        LoginUser loginUser0 = (LoginUser)object0;
                        q.f("", "getMemberKey(...)");
                        loginUser0 = LoginUserPreferencesSerializer.INSTANCE.createDefaultValue();
                        p01.w = 1;
                        return this.b.emit(loginUser0, p01) != a12 ? H.a : a12;
                    }
                    case 1: {
                        n.D(object12);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 11: {
                if(continuation0 instanceof va.q0) {
                    q00 = (va.q0)continuation0;
                    int v14 = q00.w;
                    if((v14 & 0x80000000) == 0) {
                        q00 = new va.q0(this, continuation0);
                    }
                    else {
                        q00.w = v14 ^ 0x80000000;
                    }
                }
                else {
                    q00 = new va.q0(this, continuation0);
                }
                Object object13 = q00.r;
                a a13 = a.a;
                switch(q00.w) {
                    case 0: {
                        n.D(object13);
                        q00.w = 1;
                        return this.b.emit("", q00) != a13 ? H.a : a13;
                    }
                    case 1: {
                        n.D(object13);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 12: {
                if(continuation0 instanceof r0) {
                    r00 = (r0)continuation0;
                    int v15 = r00.w;
                    if((v15 & 0x80000000) == 0) {
                        r00 = new r0(this, continuation0);
                    }
                    else {
                        r00.w = v15 ^ 0x80000000;
                    }
                }
                else {
                    r00 = new r0(this, continuation0);
                }
                Object object14 = r00.r;
                a a14 = a.a;
                switch(r00.w) {
                    case 0: {
                        n.D(object14);
                        r00.w = 1;
                        return this.b.emit("", r00) != a14 ? H.a : a14;
                    }
                    case 1: {
                        n.D(object14);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 13: {
                if(continuation0 instanceof e0) {
                    e00 = (e0)continuation0;
                    int v16 = e00.w;
                    if((v16 & 0x80000000) == 0) {
                        e00 = new e0(this, continuation0);
                    }
                    else {
                        e00.w = v16 ^ 0x80000000;
                    }
                }
                else {
                    e00 = new e0(this, continuation0);
                }
                Object object15 = e00.r;
                a a15 = a.a;
                switch(e00.w) {
                    case 0: {
                        n.D(object15);
                        e00.w = 1;
                        return this.b.emit(((fc.a)object0).c, e00) != a15 ? H.a : a15;
                    }
                    case 1: {
                        n.D(object15);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 14: {
                if(continuation0 instanceof f0) {
                    f00 = (f0)continuation0;
                    int v17 = f00.w;
                    if((v17 & 0x80000000) == 0) {
                        f00 = new f0(this, continuation0);
                    }
                    else {
                        f00.w = v17 ^ 0x80000000;
                    }
                }
                else {
                    f00 = new f0(this, continuation0);
                }
                Object object16 = f00.r;
                a a16 = a.a;
                switch(f00.w) {
                    case 0: {
                        n.D(object16);
                        f00.w = 1;
                        return this.b.emit(new Float(((float)(((fc.a)object0).d / 900L * 900L)) / ((float)((fc.a)object0).e)), f00) != a16 ? H.a : a16;
                    }
                    case 1: {
                        n.D(object16);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 15: {
                if(continuation0 instanceof g0) {
                    g01 = (g0)continuation0;
                    int v18 = g01.w;
                    if((v18 & 0x80000000) == 0) {
                        g01 = new g0(this, continuation0);
                    }
                    else {
                        g01.w = v18 ^ 0x80000000;
                    }
                }
                else {
                    g01 = new g0(this, continuation0);
                }
                Object object17 = g01.r;
                a a17 = a.a;
                switch(g01.w) {
                    case 0: {
                        n.D(object17);
                        g01.w = 1;
                        return this.b.emit(new Long(((fc.a)object0).d), g01) != a17 ? H.a : a17;
                    }
                    case 1: {
                        n.D(object17);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 16: {
                if(continuation0 instanceof q0) {
                    q01 = (q0)continuation0;
                    int v19 = q01.w;
                    if((v19 & 0x80000000) == 0) {
                        q01 = new q0(this, continuation0);
                    }
                    else {
                        q01.w = v19 ^ 0x80000000;
                    }
                }
                else {
                    q01 = new q0(this, continuation0);
                }
                Object object18 = q01.r;
                a a18 = a.a;
                switch(q01.w) {
                    case 0: {
                        n.D(object18);
                        PlayableData playableData1 = e1.b.z(((Q)object0));
                        q01.w = 1;
                        return this.b.emit((playableData1 == null ? null : playableData1.b), q01) != a18 ? H.a : a18;
                    }
                    case 1: {
                        n.D(object18);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 17: {
                if(continuation0 instanceof C0) {
                    c00 = (C0)continuation0;
                    int v20 = c00.w;
                    if((v20 & 0x80000000) == 0) {
                        c00 = new C0(this, continuation0);
                    }
                    else {
                        c00.w = v20 ^ 0x80000000;
                    }
                }
                else {
                    c00 = new C0(this, continuation0);
                }
                Object object19 = c00.r;
                a a19 = a.a;
                switch(c00.w) {
                    case 0: {
                        n.D(object19);
                        PlayableData playableData2 = e1.b.z(((Q)object0));
                        c00.w = 1;
                        return this.b.emit((playableData2 == null ? null : Boolean.valueOf(playableData2.k)), c00) != a19 ? H.a : a19;
                    }
                    case 1: {
                        n.D(object19);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 18: {
                if(continuation0 instanceof G0) {
                    g02 = (G0)continuation0;
                    int v21 = g02.w;
                    if((v21 & 0x80000000) == 0) {
                        g02 = new G0(this, continuation0);
                    }
                    else {
                        g02.w = v21 ^ 0x80000000;
                    }
                }
                else {
                    g02 = new G0(this, continuation0);
                }
                Object object20 = g02.r;
                a a20 = a.a;
                switch(g02.w) {
                    case 0: {
                        n.D(object20);
                        g02.w = 1;
                        return this.b.emit(Boolean.valueOf(((fc.a)object0).b), g02) != a20 ? H.a : a20;
                    }
                    case 1: {
                        n.D(object20);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            default: {
                if(continuation0 instanceof K0) {
                    k00 = (K0)continuation0;
                    int v = k00.w;
                    if((v & 0x80000000) == 0) {
                        k00 = new K0(this, continuation0);
                    }
                    else {
                        k00.w = v ^ 0x80000000;
                    }
                }
                else {
                    k00 = new K0(this, continuation0);
                }
                Object object1 = k00.r;
                a a0 = a.a;
                switch(k00.w) {
                    case 0: {
                        n.D(object1);
                        PlayableData playableData0 = e1.b.z(((Q)object0));
                        k00.w = 1;
                        return this.b.emit(playableData0, k00) != a0 ? H.a : a0;
                    }
                    case 1: {
                        n.D(object1);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }
    }
}

