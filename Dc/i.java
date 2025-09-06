package Dc;

import Gd.j;
import Hd.y0;
import Ic.A0;
import Ic.c0;
import Kc.Y;
import Kc.w;
import L8.s;
import O.v;
import Qb.h;
import Qb.z;
import Sd.b;
import Tf.o;
import U4.x;
import U8.l;
import Ub.t;
import Vb.o0;
import Vc.h0;
import Vc.i0;
import Zc.t0;
import android.app.Activity;
import android.text.TextUtils;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import com.gaa.sdk.auth.e;
import com.gaa.sdk.iap.d;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastSession;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.fragments.detail.PlaylistDetailContentsAllSongFragment;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistInformRes.RESPONSE;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.trackzero.SinglePlayer;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.InfoCommerceAndBtnVer6Res.Response;
import com.melon.net.res.MainMenuTabBannerRes.Response.Banner;
import com.melon.playback.manager.CastHelper;
import com.melon.playback.manager.DlnaHelper;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.x4;
import i.n.i.b.a.s.e.M3;
import ic.c;
import ie.H;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import l4.O;
import l4.Q;
import l4.j0;
import l4.k0;
import oc.d0;
import oc.e0;
import oc.f0;
import oc.m;
import p8.f;
import p8.g;
import pc.T0;
import we.a;
import we.n;

public final class i implements a {
    public final int a;
    public final Object b;
    public final Object c;

    public i(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public i(z z0, n n0) {
        this.a = 10;
        super();
        this.b = z0;
        this.c = (oe.i)n0;
    }

    public i(a a0, b0 b00) {
        this.a = 24;
        super();
        this.c = a0;
        this.b = b00;
    }

    @Override  // we.a
    public final Object invoke() {
        d d0;
        int v4;
        String s = "";
        String s1 = null;
        H h0 = H.a;
        Object object0 = this.c;
        Object object1 = this.b;
        switch(this.a) {
            case 0: {
                u u0 = ((k)object1).a;
                n n0 = u0.e;
                b0 b00 = u0.g;
                v v0 = u0.a();
                if((v0 == null ? null : v0.a) == null) {
                    int v1 = u0.q;
                    if(v1 != -1 && (u0.r != -1 && v1 != u0.r)) {
                        n0.invoke(v1, u0.r);
                    }
                }
                else {
                    Object object2 = ((O0)b00).getValue();
                    ((O0)u0.o).setValue(object2);
                    r r0 = new r(u0, u0.b(), null);
                    BuildersKt__Builders_commonKt.launch$default(u0.b, null, null, r0, 3, null);
                    n0.invoke(u0.q, u0.r);
                }
                ((O0)u0.h).setValue(0.0f);
                ((O0)b00).setValue(null);
                ((O0)u0.i).setValue(0);
                B b0 = u0.n;
                Job job0 = b0.f;
                if(job0 != null) {
                    DefaultImpls.cancel$default(job0, null, 1, null);
                }
                b0.e = null;
                u0.j = null;
                u0.k = null;
                u0.q = -1;
                u0.r = -1;
                ((a)object0).invoke();
                return h0;
            }
            case 1: {
                return Boolean.valueOf(q.b(object1, ((O0)((u)object0).g).getValue()));
            }
            case 2: {
                BuildersKt__Builders_commonKt.launch$default(((CoroutineScope)object1), null, null, new j(((Gd.n)object0), null), 3, null);
                return h0;
            }
            case 3: {
                ((A0)object1).onUserEvent(new c0(((Playable)object0)));
                return h0;
            }
            case 4: {
                ((C)object1).a = !((C)object1).a;
                y0 y00 = new y0(((Id.a)object0));
                ((Id.a)object0).i.invoke(y00);
                return h0;
            }
            case 5: {
                ((b0)object1).setValue(Boolean.valueOf(!((Boolean)((b0)object1).getValue()).booleanValue()));
                ((b0)object0).setValue(new l1.u(3));
                return h0;
            }
            case 6: {
                f f0 = ((Y)((Kc.f)object1).getViewModel()).h();
                if(f0 != null) {
                    f0.a = "페이지이동";
                    f0.y = "소개";
                    f0.F = "플레이리스트 설명더보기";
                    f0.a().track();
                }
                return h0;
            }
            case 7: {
                ((Y)object1).onUserEvent(new w(((Playable)object0)));
                return h0;
            }
            case 8: {
                String s3 = ((Y)object1).q();
                Navigator.open(PlaylistDetailContentsAllSongFragment.Companion.newInstance(s3, ((RESPONSE)object0).plylsttitle, ((RESPONSE)object0).playTime, ((RESPONSE)object0).songcnt));
                return h0;
            }
            case 9: {
                if(!q.b(((Oc.k)object1).d, "GN2300")) {
                    String s4 = ((com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes.RESPONSE)object0).menuId;
                    if(s4 == null) {
                        s4 = "";
                    }
                    String s5 = ((Oc.k)object1).d;
                    String s6 = ((com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes.RESPONSE)object0).gnr.gnrName;
                    q.f(s6, "gnrName");
                    ((Oc.k)object1).sendUiEvent(new x4(s4, new T0(s5, s6, ((com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes.RESPONSE)object0).statsElements), false));
                    String s7 = ((com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes.RESPONSE)object0).gnr.gnrName;
                    String s8 = ((com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes.RESPONSE)object0).section;
                    String s9 = ((com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes.RESPONSE)object0).page;
                    g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                    StringProviderImpl stringProviderImpl0 = ((Oc.k)object1).c;
                    g0.a = stringProviderImpl0.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                    g0.d = ActionKind.PlayMusic;
                    if(s8 == null) {
                        s8 = "";
                    }
                    g0.b = s8;
                    if(s9 == null) {
                        s9 = "";
                    }
                    g0.c = s9;
                    g0.y = stringProviderImpl0.a(0x7F130EB8);  // string:tiara_gnb_layer1_gnb "GNB"
                    g0.e = ((Oc.k)object1).d;
                    g0.f = k8.Y.i(ContsTypeCode.GENRE_MIXUP, "code(...)");
                    if(s7 != null) {
                        s = s7;
                    }
                    g0.g = s;
                    g0.I = ((Oc.k)object1).getMenuId();
                    g0.J = "1000003099";
                    g0.a().track();
                }
                return h0;
            }
            case 10: {
                BuildersKt__Builders_commonKt.launch$default(((CoroutineScope)((z)object1).d), null, null, new Qb.d(((z)object1), ((n)(((oe.i)object0))), null), 3, null);
                return h0;
            }
            case 11: {
                return k8.Y.h(((n)object1).hashCode(), ((ArrayList)((h)object0).f).size(), "executePendingActions() Pending Actions: ", ", Remain: ");
            }
            case 12: {
                ((we.k)object1).invoke(((z)object0));
                ((z)object0).l();
                return h0;
            }
            case 13: {
                ((Sd.d)object1).c = null;
                ((MusicBrowserActivity)object0).unregisterScreenCaptureCallback(b.e(((Sd.d)object1).d.getValue()));
                return h0;
            }
            case 14: {
                ((U8.w)((l)object1).getViewModel()).f();
                ((U8.w)((l)object1).getViewModel()).g(false);
                ((U8.w)((l)object1).getViewModel()).getClass();
                y8.l.a.d();
                ((a)object0).invoke();
                return h0;
            }
            case 15: {
                ((U8.w)((l)object1).getViewModel()).getClass();
                q.g(((float[])object0), "values");
                y8.l.d.set(true);
                return h0;
            }
            case 16: {
                ArrayList arrayList0 = new ArrayList();
                ((Q)object1).getClass();
                for(Object object3: Q.f()) {
                    l4.u u1 = ((O)object3).u;
                    String s10 = ((O)object3).c;
                    if((u1 == null || !u1.a.getBoolean("isDynamicGroupRoute", false)) && (((O)object0) == null || ((O)object0).n != 1000 || !q.b(((O)object0).c, s10))) {
                        arrayList0.add(new j0(new e(s10)));
                    }
                }
                df.B b1 = new df.B();
                b1.b = Collections.unmodifiableList(new ArrayList(arrayList0));
                Q.k(new k0(b1));
                return h0;
            }
            case 17: {
                O o0 = ((ic.b)object1).a;
                if(1000 == o0.n) {
                    WeakReference weakReference0 = ((CastHelper)object0).o;
                    if(weakReference0 != null) {
                        CastSession castSession0 = (CastSession)weakReference0.get();
                        if(castSession0 != null) {
                            CastDevice castDevice0 = castSession0.getCastDevice();
                            if(castDevice0 != null) {
                                s1 = castDevice0.getFriendlyName();
                            }
                        }
                    }
                    return Boolean.valueOf(q.b(s1, o0.d));
                }
                WeakReference weakReference1 = ((CastHelper)object0).o;
                if(weakReference1 != null) {
                    CastSession castSession1 = (CastSession)weakReference1.get();
                    if(castSession1 != null) {
                        CastDevice castDevice1 = castSession1.getCastDevice();
                        if(castDevice1 != null) {
                            s1 = castDevice1.getDeviceId();
                        }
                    }
                }
                q.f(o0.c, "getId(...)");
                return Boolean.valueOf(q.b(s1, o.Z0(o0.c, ":", o0.c)));
            }
            case 18: {
                DlnaHelper dlnaHelper0 = ((t)object1).c;
                dlnaHelper0.getClass();
                M8.a a0 = ((c)object0).a;
                LogU.info$default(dlnaHelper0.b, "connect() - device : " + a0.a.l, null, false, 6, null);
                if(q.b(dlnaHelper0.i(), a0)) {
                    LogU.info$default(dlnaHelper0.b, "connect() - Device already connected.", null, false, 6, null);
                    return h0;
                }
                t t0 = dlnaHelper0.f;
                if(t0 != null) {
                    hc.u u2 = hc.u.a;
                    t0.i(new hc.i(u2, hc.f.a, hc.a.a));
                    if(dlnaHelper0.i != null) {
                        LogU.debug$default(dlnaHelper0.b, "connect() - Destroy the old controller", null, false, 6, null);
                        dlnaHelper0.f();
                    }
                    L8.a a1 = dlnaHelper0.h();
                    a1.d.getClass();
                    M8.b b2 = (M8.b)a1.d.c.get(a0.a.j);
                    je.w w0 = b2 == null ? je.w.a : b2.b;
                    LogU.info$default(dlnaHelper0.b, "createController()", null, false, 6, null);
                    dlnaHelper0.i = new s(a0, w0, dlnaHelper0.n);
                    t t1 = dlnaHelper0.f;
                    if(t1 != null) {
                        t1.i(new hc.i(u2, hc.e.a, hc.b.a));
                        if(dlnaHelper0.j == null) {
                            LogU.info$default(dlnaHelper0.b, "startLocalServer()", null, false, 6, null);
                            dlnaHelper0.j = new K8.b(((Number)dlnaHelper0.l.getValue()).intValue());
                        }
                        return h0;
                    }
                    q.m("connectionListener");
                    throw null;
                }
                q.m("connectionListener");
                throw null;
            }
            case 19: {
                if(((f0)object1) instanceof e0) {
                    ((o0)object0).p1(((e0)(((f0)object1))).a.b(), ((e0)(((f0)object1))).b);
                    ((o0)object0).v0();
                    return h0;
                }
                if(!(((f0)object1) instanceof d0)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                LogU.error$default(((o0)object0).e1(), "handleSeekToMediaItem() handleSeekTo failure", null, false, 6, null);
                return h0;
            }
            case 20: {
                if(((oc.h)object1) instanceof oc.g) {
                    int v2 = ((oc.g)(((oc.h)object1))).a;
                    if(v2 != -1) {
                        ((o0)object0).p1(v2, 0L);
                        ((o0)object0).v0();
                        return h0;
                    }
                    LogU.error$default(((o0)object0).e1(), x.e(((oc.g)(((oc.h)object1))).a, "handleSeekToNextMediaItem() Invalid index: "), null, false, 6, null);
                    return h0;
                }
                if(!(((oc.h)object1) instanceof oc.f)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                LogU.error$default(((o0)object0).e1(), "handleSeekToNextMediaItem() handleNext failure", null, false, 6, null);
                return h0;
            }
            case 21: {
                if(((oc.o)object1) instanceof oc.n) {
                    int v3 = ((oc.n)(((oc.o)object1))).a;
                    if(v3 != -1) {
                        ((o0)object0).p1(v3, 0L);
                        ((o0)object0).v0();
                        return h0;
                    }
                    LogU.error$default(((o0)object0).e1(), x.e(((oc.n)(((oc.o)object1))).a, "handleSeekToPreviousMediaItem() Invalid index: "), null, false, 6, null);
                    return h0;
                }
                if(!(((oc.o)object1) instanceof m)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                LogU.error$default(((o0)object0).e1(), "handleSeekToPreviousMediaItem() handlePrevious failure", null, false, 6, null);
                return h0;
            }
            case 22: {
                ((SinglePlayer)object1).start();
                if(((a)object0) != null) {
                    ((a)object0).invoke();
                }
                return h0;
            }
            case 23: {
                ((SinglePlayer)object1).pause();
                ((SinglePlayer)object1).seekTo(0L);
                if(((we.k)object0) != null) {
                    ((we.k)object0).invoke(Boolean.FALSE);
                }
                return h0;
            }
            case 24: {
                ((b0)object1).setValue(Boolean.TRUE);
                if(((a)object0) != null) {
                    ((a)object0).invoke();
                }
                return h0;
            }
            case 25: {
                if(((we.k)object1) != null) {
                    ((we.k)object1).invoke(new i0(((h0)object0)));
                }
                return h0;
            }
            case 26: {
                com.gaa.sdk.iap.j j0 = ((Z8.g)object1).d();
                androidx.lifecycle.b b3 = new androidx.lifecycle.b(15);
                b3.b = (com.gaa.sdk.iap.k)object0;
                T7.b b4 = new T7.b(22);
                if(!j0.c()) {
                    v4 = 1007;
                    d0 = B.a.Z(v4);
                    T7.b.b(d0);
                    return h0;
                }
                com.gaa.sdk.iap.k k0 = (com.gaa.sdk.iap.k)b3.b;
                if(TextUtils.isEmpty(k0.b.optString("purchaseToken")) && TextUtils.isEmpty(k0.b.optString("purchaseId"))) {
                    y5.a.Y("PurchaseClientImpl", "Please fix the input params. purchaseData with purchaseToken can\'t be null.");
                    v4 = 1003;
                    d0 = B.a.Z(v4);
                    T7.b.b(d0);
                    return h0;
                }
                com.gaa.sdk.iap.g g1 = new com.gaa.sdk.iap.g(j0, b3, b4);
                M6.z z0 = new M6.z(j0, b4);
                if(j0.j.f(g1, 30000L, z0) == null) {
                    d0 = j0.b();
                    T7.b.b(d0);
                    return h0;
                }
                return h0;
            }
            case 27: {
                ((Z8.g)object1).d().d(((Activity)object0), new Z8.b(((Z8.g)object1), 0));
                return h0;
            }
            case 28: {
                String s11 = ((Banner)object0).getBannerSeq();
                if(s11 != null) {
                    s = s11;
                }
                ((n)object1).invoke(s, ((Banner)object0));
                return h0;
            }
            default: {
                String s2 = ((Response)object0).getUserGrade();
                if(s2 != null) {
                    s = s2;
                }
                ((t0)object1).onUserEvent(new Zc.l(s));
                return h0;
            }
        }
    }
}

