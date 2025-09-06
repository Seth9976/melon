package com.melon.playlist;

import Ac.F2;
import Qb.z;
import Ub.q;
import android.content.Context;
import android.content.Intent;
import com.iloen.melon.LoginUser;
import com.iloen.melon.custom.L0;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventCurPlaylistViewFocus;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.LocalDownloadablePlaylist;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistLog;
import com.iloen.melon.task.ReportService.Reporter;
import com.iloen.melon.utils.ReentrantMutexContextElement;
import com.iloen.melon.utils.ReentrantMutexContextKey;
import com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.log.error.MelonDebugUtils;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.playlist.station.CastData;
import d5.n;
import i.n.i.b.a.s.e.M3;
import j9.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k8.a;
import kc.A0;
import kc.B0;
import kc.D0;
import kc.D;
import kc.E;
import kc.F;
import kc.G;
import kc.H1;
import kc.H;
import kc.I0;
import kc.I;
import kc.J;
import kc.K;
import kc.L1;
import kc.L;
import kc.M0;
import kc.M;
import kc.N0;
import kc.N;
import kc.O0;
import kc.O;
import kc.P;
import kc.Q0;
import kc.Q;
import kc.R0;
import kc.S0;
import kc.S;
import kc.T;
import kc.U0;
import kc.U;
import kc.V0;
import kc.V;
import kc.W0;
import kc.W1;
import kc.W;
import kc.X;
import kc.Y;
import kc.Z0;
import kc.Z;
import kc.a0;
import kc.b0;
import kc.b2;
import kc.c;
import kc.e3;
import kc.e;
import kc.f1;
import kc.g1;
import kc.g3;
import kc.h0;
import kc.h1;
import kc.h3;
import kc.i0;
import kc.i1;
import kc.i3;
import kc.i;
import kc.j0;
import kc.j1;
import kc.j;
import kc.k0;
import kc.k1;
import kc.l1;
import kc.m1;
import kc.n1;
import kc.s0;
import kc.t0;
import kc.t;
import kc.u0;
import kc.v0;
import kc.w0;
import kc.x0;
import kc.y0;
import kc.z0;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import mb.k;
import nc.C0;
import nc.E0;
import nc.F0;
import nc.G0;
import nc.H0;
import oc.A;
import oc.B;
import oc.d0;
import oc.f0;
import oc.f;
import oc.g0;
import oc.h;
import oc.l0;
import oc.l;
import oc.m0;
import oc.m;
import oc.n0;
import oc.o0;
import oc.o;
import oc.p;
import oc.r;
import oc.s;
import oc.u;
import oc.v;
import oc.w;
import oc.x;
import oc.y;
import sc.P0;
import va.e0;

public final class b implements i {
    public final Context a;
    public final W1 b;
    public final x9.b c;
    public final H1 d;
    public final SmartPlaylistUseSettingPreferencesRepository e;
    public final c f;
    public final k g;
    public final z h;
    public final q i;
    public final a j;
    public final d k;
    public final LogU l;
    public final CoroutineScope m;
    public final Mutex n;
    public final MutableStateFlow o;
    public final MutableStateFlow p;
    public final MutableStateFlow q;
    public final MutableStateFlow r;
    public final Mutex s;
    public e t;

    public b(Context context0, W1 w10, x9.b b0, H1 h10, SmartPlaylistUseSettingPreferencesRepository smartPlaylistUseSettingPreferencesRepository0, c c0, k k0, z z0, q q0, a a0, d d0) {
        kotlin.jvm.internal.q.g(context0, "context");
        kotlin.jvm.internal.q.g(w10, "melonPlaylistFactory");
        kotlin.jvm.internal.q.g(h10, "melonPlaylistContentRepository");
        kotlin.jvm.internal.q.g(smartPlaylistUseSettingPreferencesRepository0, "smartUserSettingRepository");
        kotlin.jvm.internal.q.g(k0, "loginUseCase");
        kotlin.jvm.internal.q.g(z0, "playerController");
        kotlin.jvm.internal.q.g(q0, "playbackManager");
        kotlin.jvm.internal.q.g(a0, "progressDialog");
        kotlin.jvm.internal.q.g(d0, "networkMonitor");
        super();
        this.a = context0;
        this.b = w10;
        this.c = b0;
        this.d = h10;
        this.e = smartPlaylistUseSettingPreferencesRepository0;
        this.f = c0;
        this.g = k0;
        this.h = z0;
        this.i = q0;
        this.j = a0;
        this.k = d0;
        this.l = new LogU("MelonInternalPlaylistManagerImpl");
        this.m = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.n = MutexKt.Mutex$default(false, 1, null);
        this.o = StateFlowKt.MutableStateFlow(e3.a);
        this.p = StateFlowKt.MutableStateFlow(null);
        this.q = StateFlowKt.MutableStateFlow(null);
        this.r = StateFlowKt.MutableStateFlow(null);
        this.s = MutexKt.Mutex$default(false, 1, null);
    }

    public final Object A(oe.c c0) {
        H h0;
        if(c0 instanceof H) {
            h0 = (H)c0;
            int v = h0.B;
            if((v & 0x80000000) == 0) {
                h0 = new H(this, c0);
            }
            else {
                h0.B = v ^ 0x80000000;
            }
        }
        else {
            h0 = new H(this, c0);
        }
        Object object0 = h0.r;
        ne.a a0 = ne.a.a;
        switch(h0.B) {
            case 0: {
                n.D(object0);
                h0.B = 1;
                if(this.X("getMixupPlaylist", h0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        h0.B = 2;
        Object object1 = this.b.d(false, h0);
        return object1 == a0 ? a0 : object1;
    }

    public final Object B(oe.c c0) {
        I i0;
        if(c0 instanceof I) {
            i0 = (I)c0;
            int v = i0.B;
            if((v & 0x80000000) == 0) {
                i0 = new I(this, c0);
            }
            else {
                i0.B = v ^ 0x80000000;
            }
        }
        else {
            i0 = new I(this, c0);
        }
        Object object0 = i0.r;
        ne.a a0 = ne.a.a;
        switch(i0.B) {
            case 0: {
                n.D(object0);
                i0.B = 1;
                if(this.X("getMusicPlaylist", i0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        i0.B = 2;
        Object object1 = this.b.e(false, i0);
        return object1 == a0 ? a0 : object1;
    }

    public final Object C(oe.c c0) {
        J j0;
        if(c0 instanceof J) {
            j0 = (J)c0;
            int v = j0.B;
            if((v & 0x80000000) == 0) {
                j0 = new J(this, c0);
            }
            else {
                j0.B = v ^ 0x80000000;
            }
        }
        else {
            j0 = new J(this, c0);
        }
        Object object0 = j0.r;
        ne.a a0 = ne.a.a;
        switch(j0.B) {
            case 0: {
                n.D(object0);
                j0.B = 1;
                if(this.X("getMusicWavePlaylist", j0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        j0.B = 2;
        Object object1 = this.b.f(false, j0);
        return object1 == a0 ? a0 : object1;
    }

    public final Object D(oe.c c0) {
        b b0;
        K k0;
        if(c0 instanceof K) {
            k0 = (K)c0;
            int v = k0.D;
            if((v & 0x80000000) == 0) {
                k0 = new K(this, c0);
            }
            else {
                k0.D = v ^ 0x80000000;
            }
        }
        else {
            k0 = new K(this, c0);
        }
        Enum enum0 = k0.w;
        ne.a a0 = ne.a.a;
        switch(k0.D) {
            case 0: {
                n.D(enum0);
                k0.r = this;
                k0.D = 1;
                enum0 = this.E(k0);
                if(enum0 == a0) {
                    return a0;
                }
                b0 = this;
                break;
            }
            case 1: {
                b0 = k0.r;
                n.D(enum0);
                break;
            }
            case 2: {
                n.D(enum0);
                return enum0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        k0.r = null;
        k0.D = 2;
        Object object0 = b0.G(((PlaylistId)enum0), k0);
        return object0 == a0 ? a0 : object0;
    }

    public final Enum E(oe.c c0) {
        L l0;
        if(c0 instanceof L) {
            l0 = (L)c0;
            int v = l0.B;
            if((v & 0x80000000) == 0) {
                l0 = new L(this, c0);
            }
            else {
                l0.B = v ^ 0x80000000;
            }
        }
        else {
            l0 = new L(this, c0);
        }
        Object object0 = l0.r;
        Enum enum0 = ne.a.a;
        switch(l0.B) {
            case 0: {
                n.D(object0);
                l0.B = 1;
                if(this.X("getRecentAudioPlaylistId", l0) == enum0) {
                    return enum0;
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
        Enum enum1 = (PlaylistId)this.q.getValue();
        if(enum1 == null) {
            MelonDebugUtils.INSTANCE.errorLogOrException(this.l, "getRecentAudioPlaylistId() null");
            return PlaylistId.EMPTY;
        }
        return enum1;
    }

    public final Object F(oe.c c0) {
        M m0;
        if(c0 instanceof M) {
            m0 = (M)c0;
            int v = m0.B;
            if((v & 0x80000000) == 0) {
                m0 = new M(this, c0);
            }
            else {
                m0.B = v ^ 0x80000000;
            }
        }
        else {
            m0 = new M(this, c0);
        }
        Enum enum0 = m0.r;
        ne.a a0 = ne.a.a;
        switch(m0.B) {
            case 0: {
                n.D(enum0);
                m0.B = 1;
                enum0 = this.s(m0);
                if(enum0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(enum0);
                break;
            }
            case 2: {
                n.D(enum0);
                return enum0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        m0.B = 2;
        Object object0 = this.b.g(((PlaylistId)enum0), false, m0);
        return object0 == a0 ? a0 : object0;
    }

    public final Object G(PlaylistId playlistId0, oe.c c0) {
        N n0;
        if(c0 instanceof N) {
            n0 = (N)c0;
            int v = n0.D;
            if((v & 0x80000000) == 0) {
                n0 = new N(this, c0);
            }
            else {
                n0.D = v ^ 0x80000000;
            }
        }
        else {
            n0 = new N(this, c0);
        }
        Object object0 = n0.w;
        ne.a a0 = ne.a.a;
        switch(n0.D) {
            case 0: {
                n.D(object0);
                n0.r = playlistId0;
                n0.D = 1;
                if(this.X("getRestoredMutablePlaylist", n0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                playlistId0 = n0.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        n0.r = null;
        n0.D = 2;
        Object object1 = this.b.g(playlistId0, false, n0);
        return object1 == a0 ? a0 : object1;
    }

    public final w H(PlaylistId playlistId0) {
        this.Y("getRestoredMutablePlaylistOrNull");
        this.b.getClass();
        kotlin.jvm.internal.q.g(playlistId0, "playlistId");
        return (w)this.b.e.get(playlistId0.getSeq());
    }

    public final Object I(oe.c c0) {
        O o0;
        if(c0 instanceof O) {
            o0 = (O)c0;
            int v = o0.B;
            if((v & 0x80000000) == 0) {
                o0 = new O(this, c0);
            }
            else {
                o0.B = v ^ 0x80000000;
            }
        }
        else {
            o0 = new O(this, c0);
        }
        Object object0 = o0.r;
        ne.a a0 = ne.a.a;
        switch(o0.B) {
            case 0: {
                n.D(object0);
                o0.B = 1;
                if(this.X("getSmartPlaylist", o0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        o0.B = 2;
        Object object1 = this.b.h(false, o0);
        return object1 == a0 ? a0 : object1;
    }

    public final Object J(oe.c c0) {
        P p0;
        if(c0 instanceof P) {
            p0 = (P)c0;
            int v = p0.B;
            if((v & 0x80000000) == 0) {
                p0 = new P(this, c0);
            }
            else {
                p0.B = v ^ 0x80000000;
            }
        }
        else {
            p0 = new P(this, c0);
        }
        Object object0 = p0.r;
        ne.a a0 = ne.a.a;
        switch(p0.B) {
            case 0: {
                n.D(object0);
                p0.B = 1;
                if(this.X("getStationPlaylist", p0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        p0.B = 2;
        Object object1 = this.b.i(false, p0);
        return object1 == a0 ? a0 : object1;
    }

    public final Object K(oe.c c0) {
        Q q0;
        if(c0 instanceof Q) {
            q0 = (Q)c0;
            int v = q0.B;
            if((v & 0x80000000) == 0) {
                q0 = new Q(this, c0);
            }
            else {
                q0.B = v ^ 0x80000000;
            }
        }
        else {
            q0 = new Q(this, c0);
        }
        Object object0 = q0.r;
        ne.a a0 = ne.a.a;
        switch(q0.B) {
            case 0: {
                n.D(object0);
                q0.B = 1;
                if(this.X("getVodPlaylist", q0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        q0.B = 2;
        Object object1 = this.b.j(false, q0);
        return object1 == a0 ? a0 : object1;
    }

    public final Object L(oe.c c0) {
        PlaylistId playlistId0;
        S s0;
        if(c0 instanceof S) {
            s0 = (S)c0;
            int v = s0.D;
            if((v & 0x80000000) == 0) {
                s0 = new S(this, c0);
            }
            else {
                s0.D = v ^ 0x80000000;
            }
        }
        else {
            s0 = new S(this, c0);
        }
        Object object0 = s0.w;
        ne.a a0 = ne.a.a;
        switch(s0.D) {
            case 0: {
                n.D(object0);
                playlistId0 = this.t();
                LogU logU0 = this.l;
                if(playlistId0 == null) {
                    MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "handleNext() - playlistId is null");
                    return new f("playlistId is null");
                }
                w w0 = this.H(playlistId0);
                if(w0 == null) {
                    MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "handleNext() - playlist is null");
                    return new f("playlist is null");
                }
                s0.r = playlistId0;
                s0.D = 1;
                object0 = w0.g(s0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_30;
            }
            case 1: {
                playlistId0 = s0.r;
                n.D(object0);
            label_30:
                T t0 = new T(((h)object0), null);
                s0.r = null;
                s0.D = 2;
                object0 = this.p(playlistId0, t0, s0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return ((h)object0) == null ? new f("playlist is changed") : ((h)object0);
    }

    public final Object M(oe.c c0) {
        PlaylistId playlistId0;
        U u0;
        if(c0 instanceof U) {
            u0 = (U)c0;
            int v = u0.D;
            if((v & 0x80000000) == 0) {
                u0 = new U(this, c0);
            }
            else {
                u0.D = v ^ 0x80000000;
            }
        }
        else {
            u0 = new U(this, c0);
        }
        Object object0 = u0.w;
        ne.a a0 = ne.a.a;
        switch(u0.D) {
            case 0: {
                n.D(object0);
                playlistId0 = this.t();
                LogU logU0 = this.l;
                if(playlistId0 == null) {
                    MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "handleNextWhenPlayCompleted() - playlistId is null");
                    return new oc.i("playlistId is null");
                }
                w w0 = this.H(playlistId0);
                if(w0 == null) {
                    MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "handleNextWhenPlayCompleted() - playlist is null");
                    return new oc.i("playlist is null");
                }
                u0.r = playlistId0;
                u0.D = 1;
                object0 = w0.B(u0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_30;
            }
            case 1: {
                playlistId0 = u0.r;
                n.D(object0);
            label_30:
                V v1 = new V(((l)object0), null);
                u0.r = null;
                u0.D = 2;
                object0 = this.p(playlistId0, v1, u0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return ((l)object0) == null ? new oc.i("playlist is changed") : ((l)object0);
    }

    public final Object N(oe.c c0) {
        PlaylistId playlistId0;
        W w0;
        if(c0 instanceof W) {
            w0 = (W)c0;
            int v = w0.D;
            if((v & 0x80000000) == 0) {
                w0 = new W(this, c0);
            }
            else {
                w0.D = v ^ 0x80000000;
            }
        }
        else {
            w0 = new W(this, c0);
        }
        Object object0 = w0.w;
        ne.a a0 = ne.a.a;
        switch(w0.D) {
            case 0: {
                n.D(object0);
                playlistId0 = this.t();
                LogU logU0 = this.l;
                if(playlistId0 == null) {
                    MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "handlePrevious() - playlistId is null");
                    return new m("playlistId is null");
                }
                w w1 = this.H(playlistId0);
                if(w1 == null) {
                    MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "handlePrevious() - playlist is null");
                    return new m("playlist is null");
                }
                w0.r = playlistId0;
                w0.D = 1;
                object0 = w1.z(w0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_30;
            }
            case 1: {
                playlistId0 = w0.r;
                n.D(object0);
            label_30:
                X x0 = new X(((o)object0), null);
                w0.r = null;
                w0.D = 2;
                object0 = this.p(playlistId0, x0, w0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return ((o)object0) == null ? new m("playlist is changed") : ((o)object0);
    }

    public final Object O(oe.c c0) {
        PlaylistId playlistId0;
        Y y0;
        if(c0 instanceof Y) {
            y0 = (Y)c0;
            int v = y0.D;
            if((v & 0x80000000) == 0) {
                y0 = new Y(this, c0);
            }
            else {
                y0.D = v ^ 0x80000000;
            }
        }
        else {
            y0 = new Y(this, c0);
        }
        Object object0 = y0.w;
        ne.a a0 = ne.a.a;
        switch(y0.D) {
            case 0: {
                n.D(object0);
                playlistId0 = this.t();
                LogU logU0 = this.l;
                if(playlistId0 == null) {
                    MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "handleResume() - playlistId is null");
                    return new p("playlistId is null");
                }
                w w0 = this.H(playlistId0);
                if(w0 == null) {
                    MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "handleResume() - playlist is null");
                    return new p("playlist is null");
                }
                if(!(w0 instanceof oc.K)) {
                    return r.a;
                }
                y0.r = playlistId0;
                y0.D = 1;
                object0 = ((rc.m)(((oc.K)w0))).e(y0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_32;
            }
            case 1: {
                playlistId0 = y0.r;
                n.D(object0);
            label_32:
                Z z0 = new Z(((s)object0), null);
                y0.r = null;
                y0.D = 2;
                object0 = this.p(playlistId0, z0, y0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return ((s)object0) == null ? new p("playlist is changed") : ((s)object0);
    }

    public final Object P(int v, long v1, boolean z, oe.c c0) {
        PlaylistId playlistId0;
        boolean z1;
        long v5;
        int v4;
        PlaylistId playlistId1;
        Mutex mutex0;
        a0 a00;
        if(c0 instanceof a0) {
            a00 = (a0)c0;
            int v2 = a00.I;
            if((v2 & 0x80000000) == 0) {
                a00 = new a0(this, c0);
            }
            else {
                a00.I = v2 ^ 0x80000000;
            }
        }
        else {
            a00 = new a0(this, c0);
        }
        Object object0 = a00.E;
        ne.a a0 = ne.a.a;
        switch(a00.I) {
            case 0: {
                n.D(object0);
                mutex0 = this.s;
                a00.D = mutex0;
                a00.r = v;
                a00.w = v1;
                a00.B = z;
                a00.I = 1;
                if(mutex0.lock(null, a00) == a0) {
                    return a0;
                }
                goto label_27;
            }
            case 1: {
                z = a00.B;
                v1 = a00.w;
                v = a00.r;
                mutex0 = (Mutex)a00.D;
                n.D(object0);
            label_27:
                try {
                    playlistId0 = (PlaylistId)this.p.getValue();
                }
                finally {
                    mutex0.unlock(null);
                }
                LogU logU0 = this.l;
                if(playlistId0 == null) {
                    MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "handleSeekTo() - currentPlaylistId is null");
                    return new d0();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                w w0 = this.H(playlistId0);
                if(w0 == null) {
                    MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "handleSeekTo() - playlist is null");
                    return new d0();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                a00.D = playlistId0;
                a00.r = v;
                a00.w = v1;
                a00.B = z;
                a00.I = 2;
                object0 = w0.v(v, v1, z, "handleSeekTo", a00);
                if(object0 == a0) {
                    return a0;
                }
                playlistId1 = playlistId0;
                v4 = v;
                v5 = v1;
                z1 = z;
                goto label_57;
            }
            case 2: {
                z1 = a00.B;
                v5 = a00.w;
                v4 = a00.r;
                playlistId1 = (PlaylistId)a00.D;
                n.D(object0);
            label_57:
                b0 b00 = new b0(((f0)object0), null);
                a00.D = null;
                a00.r = v4;
                a00.w = v5;
                a00.B = z1;
                a00.I = 3;
                object0 = this.p(playlistId1, b00, a00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 3: {
                PlaylistId playlistId2 = (PlaylistId)a00.D;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return ((f0)object0) == null ? new d0() : ((f0)object0);  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final Object Q(PlaylistId playlistId0, int v, int v1, oe.c c0) {
        int v3;
        PlaylistId playlistId1;
        h0 h00;
        if(c0 instanceof h0) {
            h00 = (h0)c0;
            int v2 = h00.I;
            if((v2 & 0x80000000) == 0) {
                h00 = new h0(this, c0);
            }
            else {
                h00.I = v2 ^ 0x80000000;
            }
        }
        else {
            h00 = new h0(this, c0);
        }
        Object object0 = h00.E;
        ne.a a0 = ne.a.a;
        switch(h00.I) {
            case 0: {
                n.D(object0);
                h00.r = playlistId0;
                h00.B = v;
                h00.D = v1;
                h00.I = 1;
                object0 = this.G(playlistId0, h00);
                if(object0 == a0) {
                    return a0;
                }
                goto label_28;
            }
            case 1: {
                v1 = h00.D;
                v = h00.B;
                playlistId0 = h00.r;
                n.D(object0);
            label_28:
                h00.r = playlistId0;
                h00.B = v;
                h00.D = v1;
                h00.I = 2;
                object0 = ((w)object0).q(v, v1, h00);
                if(object0 == a0) {
                    return a0;
                }
                playlistId1 = playlistId0;
                v3 = v1;
                break;
            }
            case 2: {
                v3 = h00.D;
                v = h00.B;
                playlistId1 = h00.r;
                n.D(object0);
                break;
            }
            case 3: {
                Object object1 = h00.w;
                n.D(object0);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((v)object0) instanceof u) {
            i0 i00 = new i0(this, ((v)object0), null);
            h00.r = null;
            h00.w = object0;
            h00.B = v;
            h00.D = v3;
            h00.I = 3;
            if(this.p(playlistId1, i00, h00) == a0) {
                return a0;
            }
        }
        return object0;
    }

    public final Object R(int v, int v1, oe.c c0) {
        int v4;
        int v3;
        j0 j00;
        if(c0 instanceof j0) {
            j00 = (j0)c0;
            int v2 = j00.G;
            if((v2 & 0x80000000) == 0) {
                j00 = new j0(this, c0);
            }
            else {
                j00.G = v2 ^ 0x80000000;
            }
        }
        else {
            j00 = new j0(this, c0);
        }
        Object object0 = j00.D;
        ne.a a0 = ne.a.a;
        switch(j00.G) {
            case 0: {
                n.D(object0);
                j00.r = v;
                j00.w = v1;
                j00.G = 1;
                if(this.X("moveInMixUp", j00) != a0) {
                label_33:
                    j00.r = v;
                    j00.w = v1;
                    j00.G = 2;
                    object0 = this.b.d(false, j00);
                    if(object0 != a0) {
                        v4 = v;
                        v3 = v1;
                    label_40:
                        j00.r = v4;
                        j00.w = v3;
                        j00.G = 3;
                        object0 = ((pc.Z)object0).o(v4, v3, j00);
                        if(object0 != a0) {
                        label_45:
                            if(!(((v)object0) instanceof u)) {
                                return object0;
                            }
                            k0 k00 = new k0(this, ((v)object0), null);
                            j00.B = object0;
                            j00.r = v4;
                            j00.w = v3;
                            j00.G = 4;
                            if(this.p(PlaylistId.MIX_UP, k00, j00) != a0) {
                                return object0;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                v1 = j00.w;
                v = j00.r;
                n.D(object0);
                goto label_33;
            }
            case 2: {
                v3 = j00.w;
                v4 = j00.r;
                n.D(object0);
                goto label_40;
            }
            case 3: {
                v3 = j00.w;
                v4 = j00.r;
                n.D(object0);
                goto label_45;
            }
            case 4: {
                Object object1 = j00.B;
                n.D(object0);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final Object S(PlaylistId playlistId0, String s, oe.c c0) {
        u0 u00;
        if(c0 instanceof u0) {
            u00 = (u0)c0;
            int v = u00.D;
            if((v & 0x80000000) == 0) {
                u00 = new u0(this, c0);
            }
            else {
                u00.D = v ^ 0x80000000;
            }
        }
        else {
            u00 = new u0(this, c0);
        }
        Object object0 = u00.w;
        ne.a a0 = ne.a.a;
        switch(u00.D) {
            case 0: {
                n.D(object0);
                u00.r = s;
                u00.D = 1;
                object0 = this.G(playlistId0, u00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                s = u00.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return ie.H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        u00.r = null;
        u00.D = 2;
        return ((w)object0).a(s, u00) == a0 ? a0 : ie.H.a;
    }

    public final Object T(oe.c c0) {
        v0 v00;
        if(c0 instanceof v0) {
            v00 = (v0)c0;
            int v = v00.D;
            if((v & 0x80000000) == 0) {
                v00 = new v0(this, c0);
            }
            else {
                v00.D = v ^ 0x80000000;
            }
        }
        else {
            v00 = new v0(this, c0);
        }
        Object object0 = v00.w;
        ne.a a0 = ne.a.a;
        switch(v00.D) {
            case 0: {
                n.D(object0);
                v00.D = 1;
                if(this.X("refreshDrawerPlaylist", v00) != a0) {
                label_25:
                    v00.D = 2;
                    object0 = this.b.b(false, v00);
                    if(object0 != a0) {
                    label_28:
                        v00.D = 3;
                        object0 = ((nc.u0)object0).K(v00);
                        if(object0 != a0) {
                        label_31:
                            if(((H0)object0) instanceof G0) {
                                w0 w00 = new w0(this, ((H0)object0), null);
                                v00.r = object0;
                                v00.D = 4;
                                return this.p(PlaylistId.DRAWER, w00, v00) != a0 ? object0 : a0;
                            }
                            if(!(((H0)object0) instanceof E0)) {
                                goto label_42;
                            }
                            v00.r = object0;
                            v00.D = 5;
                            if(this.m(v00) != a0) {
                                return object0;
                            label_42:
                                if(!(((H0)object0) instanceof F0)) {
                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                }
                                LogU.debug$default(this.l, "refreshDrawerPlaylist error: " + ((F0)(((H0)object0))).a, null, false, 6, null);
                                return object0;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                n.D(object0);
                goto label_25;
            }
            case 2: {
                n.D(object0);
                goto label_28;
            }
            case 3: {
                n.D(object0);
                goto label_31;
            }
            case 4: 
            case 5: {
                Object object1 = v00.r;
                n.D(object0);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final Object U(e e0, oe.c c0) {
        x0 x00;
        if(c0 instanceof x0) {
            x00 = (x0)c0;
            int v = x00.D;
            if((v & 0x80000000) == 0) {
                x00 = new x0(this, c0);
            }
            else {
                x00.D = v ^ 0x80000000;
            }
        }
        else {
            x00 = new x0(this, c0);
        }
        Object object0 = x00.w;
        ne.a a0 = ne.a.a;
        switch(x00.D) {
            case 0: {
                n.D(object0);
                x00.r = e0;
                x00.D = 1;
                if(this.X("registerPlaylistChangeListener", x00) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                e0 = x00.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.t = e0;
        return ie.H.a;
    }

    public final Object V(PlaylistId playlistId0, List list0, oe.c c0) {
        y0 y00;
        if(c0 instanceof y0) {
            y00 = (y0)c0;
            int v = y00.G;
            if((v & 0x80000000) == 0) {
                y00 = new y0(this, c0);
            }
            else {
                y00.G = v ^ 0x80000000;
            }
        }
        else {
            y00 = new y0(this, c0);
        }
        Object object0 = y00.D;
        ne.a a0 = ne.a.a;
        switch(y00.G) {
            case 0: {
                n.D(object0);
                y00.r = playlistId0;
                y00.w = list0;
                y00.G = 1;
                object0 = this.G(playlistId0, y00);
                if(object0 == a0) {
                    return a0;
                }
                goto label_26;
            }
            case 1: {
                list0 = y00.w;
                playlistId0 = y00.r;
                n.D(object0);
            label_26:
                y00.r = playlistId0;
                y00.w = null;
                y00.G = 2;
                object0 = ((w)object0).i(list0, y00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                playlistId0 = y00.r;
                n.D(object0);
                break;
            }
            case 3: {
                Object object1 = y00.B;
                n.D(object0);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((oc.U)object0) instanceof oc.T) {
            z0 z00 = new z0(this, ((oc.U)object0), null);
            y00.r = null;
            y00.w = null;
            y00.B = object0;
            y00.G = 3;
            if(this.p(playlistId0, z00, y00) == a0) {
                return a0;
            }
        }
        return object0;
    }

    public final Object W(C0 c00, oe.c c0) {
        A0 a00;
        if(c0 instanceof A0) {
            a00 = (A0)c0;
            int v = a00.E;
            if((v & 0x80000000) == 0) {
                a00 = new A0(this, c0);
            }
            else {
                a00.E = v ^ 0x80000000;
            }
        }
        else {
            a00 = new A0(this, c0);
        }
        Object object0 = a00.B;
        ne.a a0 = ne.a.a;
        switch(a00.E) {
            case 0: {
                n.D(object0);
                a00.r = c00;
                a00.E = 1;
                if(this.X("replaceDrawerPlaylist", a00) != a0) {
                label_28:
                    a00.r = c00;
                    a00.E = 2;
                    object0 = this.b.b(false, a00);
                    if(object0 != a0) {
                    label_32:
                        a00.r = null;
                        a00.E = 3;
                        object0 = ((nc.u0)object0).M(c00, a00);
                        if(object0 != a0) {
                        label_36:
                            B0 b00 = new B0(this, ((C0)object0), null);
                            a00.r = null;
                            a00.w = object0;
                            a00.E = 4;
                            if(this.p(PlaylistId.DRAWER, b00, a00) != a0) {
                                return object0;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                c00 = a00.r;
                n.D(object0);
                goto label_28;
            }
            case 2: {
                c00 = a00.r;
                n.D(object0);
                goto label_32;
            }
            case 3: {
                n.D(object0);
                goto label_36;
            }
            case 4: {
                Object object1 = a00.w;
                n.D(object0);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final Object X(String s, oe.c c0) {
        if(this.o.getValue() != e3.c) {
            Mutex mutex0 = this.n;
            ReentrantMutexContextKey reentrantMutexContextKey0 = new ReentrantMutexContextKey(mutex0);
            if(c0.getContext().get(reentrantMutexContextKey0) == null) {
                Object object1 = BuildersKt.withContext(new ReentrantMutexContextElement(reentrantMutexContextKey0), new kc.C0(mutex0, null, this, s), c0);
                if(object1 == ne.a.a) {
                    return object1;
                }
            }
            else {
                D0 d00 = new D0(this, s, null);
                Object object0 = BuildersKt.withContext(NonCancellable.INSTANCE, d00, c0);
                if(object0 == ne.a.a) {
                    return object0;
                }
            }
        }
        return ie.H.a;
    }

    public final void Y(String s) {
        kc.E0 e00 = new kc.E0(this, s, null);
        BuildersKt__Builders_commonKt.launch$default(this.m, null, null, e00, 3, null);
    }

    public final Object Z(oe.c c0) {
        String s61;
        String s60;
        int v109;
        w w14;
        int v108;
        L0 l013;
        PlaylistId playlistId55;
        e e2;
        Object object23;
        PlaylistId playlistId54;
        e e1;
        LoginUser loginUser42;
        PlaylistId playlistId53;
        String s59;
        int v107;
        L0 l012;
        int v106;
        A a2;
        kotlin.jvm.internal.H h28;
        w w13;
        LoginUser loginUser40;
        PlaylistId playlistId50;
        LoginUser loginUser39;
        PlaylistId playlistId49;
        String s58;
        int v103;
        L0 l011;
        int v102;
        y y1;
        kotlin.jvm.internal.H h27;
        w w12;
        LoginUser loginUser37;
        PlaylistId playlistId46;
        L0 l010;
        String s57;
        MutableStateFlow mutableStateFlow15;
        LoginUser loginUser34;
        kotlin.jvm.internal.H h26;
        int v83;
        int v82;
        L0 l09;
        String s56;
        boolean z2;
        LoginUser loginUser32;
        String s55;
        nc.u0 u02;
        Object object20;
        nc.u0 u01;
        String s53;
        L0 l07;
        LoginUser loginUser29;
        String s48;
        kotlin.jvm.internal.H h22;
        PlaylistId playlistId33;
        kotlin.jvm.internal.H h21;
        String s47;
        LoginUser loginUser28;
        i3 i35;
        int v72;
        int v71;
        int v70;
        String s50;
        i3 i34;
        int v69;
        int v68;
        String s46;
        LoginUser loginUser27;
        int v67;
        int v66;
        int v65;
        String s43;
        LoginUser loginUser26;
        int v64;
        w w9;
        PlaylistId playlistId32;
        Object object18;
        String s40;
        PlaylistId playlistId30;
        LoginUser loginUser24;
        Object object17;
        P0 p07;
        Object object16;
        P0 p06;
        String s39;
        PlaylistId playlistId28;
        Object object15;
        kotlin.jvm.internal.H h18;
        int v57;
        String s37;
        PlaylistId playlistId27;
        String s36;
        LoginUser loginUser22;
        Object object14;
        MutableStateFlow mutableStateFlow14;
        MutableStateFlow mutableStateFlow13;
        PlaylistId playlistId26;
        LoginUser loginUser20;
        String s33;
        int v53;
        Object object13;
        kotlin.jvm.internal.H h16;
        L0 l05;
        String s32;
        int v52;
        L0 l04;
        String s30;
        Boolean boolean1;
        L0 l03;
        int v49;
        String s29;
        MutableStateFlow mutableStateFlow11;
        String s28;
        MutableStateFlow mutableStateFlow10;
        LoginUser loginUser18;
        Object object12;
        MutableStateFlow mutableStateFlow9;
        C c6;
        String s27;
        String s26;
        C c5;
        LoginUser loginUser17;
        L0 l02;
        String s25;
        String s24;
        LoginUser loginUser16;
        String s23;
        PlaylistId playlistId23;
        e e0;
        LoginUser loginUser15;
        String s22;
        w w7;
        int v45;
        int v44;
        int v43;
        A a1;
        kotlin.jvm.internal.H h13;
        w w6;
        PlaylistId playlistId21;
        LoginUser loginUser14;
        String s21;
        int v42;
        int v41;
        int v40;
        y y0;
        kotlin.jvm.internal.H h12;
        w w5;
        PlaylistId playlistId19;
        ie.o o0;
        boolean z;
        int v37;
        LoginUser loginUser12;
        String s19;
        kotlin.jvm.internal.H h11;
        int v36;
        int v35;
        nc.u0 u00;
        Object object9;
        PlaylistId playlistId7;
        LoginUser loginUser10;
        String s16;
        w w2;
        int v30;
        int v29;
        PlaylistId playlistId6;
        kotlin.jvm.internal.H h9;
        String s15;
        int v28;
        i3 i31;
        LoginUser loginUser9;
        int v27;
        int v26;
        LoginUser loginUser8;
        String s14;
        kotlin.jvm.internal.H h8;
        w w1;
        i3 i30;
        LoginUser loginUser7;
        w w0;
        PlaylistId playlistId5;
        kotlin.jvm.internal.H h7;
        Object object7;
        String s9;
        Object object6;
        P0 p00;
        int v18;
        int v17;
        String s7;
        PlaylistId playlistId2;
        int v16;
        Object object4;
        LoginUser loginUser4;
        kotlin.jvm.internal.H h4;
        int v20;
        int v19;
        PlaylistId playlistId1;
        String s6;
        kotlin.jvm.internal.H h3;
        int v15;
        MutableStateFlow mutableStateFlow8;
        int v12;
        LoginUser loginUser2;
        int v11;
        int v10;
        kotlin.jvm.internal.H h1;
        MutableStateFlow mutableStateFlow6;
        Boolean boolean0;
        int v8;
        String s3;
        C c3;
        MutableStateFlow mutableStateFlow5;
        LoginUser loginUser0;
        int v7;
        int v6;
        C c2;
        String s2;
        int v4;
        int v3;
        L0 l01;
        String s1;
        MutableStateFlow mutableStateFlow4;
        MutableStateFlow mutableStateFlow3;
        int v2;
        int v1;
        L0 l00;
        String s;
        kc.F0 f00;
        if(c0 instanceof kc.F0) {
            f00 = (kc.F0)c0;
            int v = f00.Z;
            if((v & 0x80000000) == 0) {
                f00 = new kc.F0(this, c0);
            }
            else {
                f00.Z = v ^ 0x80000000;
            }
        }
        else {
            f00 = new kc.F0(this, c0);
        }
        Object object0 = f00.X;
        ne.a a0 = ne.a.a;
        SmartPlaylistUseSettingPreferencesRepository smartPlaylistUseSettingPreferencesRepository0 = this.e;
        ie.H h0 = ie.H.a;
        c c1 = this.f;
        x9.b b0 = this.c;
        MutableStateFlow mutableStateFlow0 = this.r;
        W1 w10 = this.b;
        MutableStateFlow mutableStateFlow1 = this.q;
        MutableStateFlow mutableStateFlow2 = this.p;
        switch(f00.Z) {
            case 0: {
                n.D(object0);
                k k0 = this.g;
                kc.H0 h00 = new kc.H0(FlowKt.drop(((e0)k0).n(), 1), this, null);
                BuildersKt__Builders_commonKt.launch$default(this.m, null, null, h00, 3, null);
                s = "MelonInternalPlaylistManagerImpl - restore()";
                l00 = this.j;
                if(l00 == null) {
                    f00.r = null;
                    f00.w = null;
                    f00.T = 0;
                    f00.V = 0;
                    f00.Z = 1;
                    object0 = ((e0)k0).l(f00);
                    if(object0 == a0) {
                        return a0;
                    }
                    v1 = 0;
                    v2 = 0;
                    goto label_60;
                }
                else {
                    mutableStateFlow3 = mutableStateFlow0;
                    mutableStateFlow4 = mutableStateFlow2;
                    ((k8.b)l00).a("MelonInternalPlaylistManagerImpl - restore() true", true);
                    try {
                        f00.r = l00;
                        f00.w = "MelonInternalPlaylistManagerImpl - restore()";
                        f00.T = 0;
                        f00.V = 0;
                        f00.Z = 25;
                        object0 = ((e0)k0).l(f00);
                    }
                    catch(Throwable throwable0) {
                        s1 = "MelonInternalPlaylistManagerImpl - restore()";
                        l01 = l00;
                        k8.Y.v(s1, " false", l01, false);
                        throw throwable0;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    v3 = 0;
                    v4 = 0;
                    goto label_1022;
                }
                break;
            }
            case 1: {
                int v5 = f00.V;
                v2 = f00.T;
                n.D(object0);
                v1 = v5;
            label_60:
                s2 = "";
                c2 = new C();
                if(e1.u.o("")) {
                    I0 i00 = new I0(c2, this, null);
                    f00.r = null;
                    f00.w = null;
                    f00.B = (LoginUser)object0;
                    f00.D = c2;
                    f00.E = "";
                    f00.G = mutableStateFlow0;
                    f00.T = v2;
                    f00.V = v1;
                    f00.Z = 2;
                    Object object1 = smartPlaylistUseSettingPreferencesRepository0.getUseSmartPlaylistOrSet("", i00, f00);
                    if(object1 == a0) {
                        return a0;
                    }
                    v6 = v1;
                    v7 = v2;
                    loginUser0 = (LoginUser)object0;
                    mutableStateFlow5 = mutableStateFlow0;
                    object0 = object1;
                    goto label_100;
                }
                else {
                    v7 = v2;
                    c3 = c2;
                    s3 = "";
                    v8 = v1;
                    loginUser0 = (LoginUser)object0;
                    boolean0 = oe.f.a(false);
                    mutableStateFlow6 = mutableStateFlow0;
                }
                goto label_105;
            }
            case 2: {
                v7 = f00.T;
                v6 = f00.V;
                MutableStateFlow mutableStateFlow7 = (MutableStateFlow)f00.G;
                String s4 = f00.E;
                C c4 = f00.D;
                LoginUser loginUser1 = f00.B;
                n.D(object0);
                c2 = c4;
                s2 = s4;
                loginUser0 = loginUser1;
                mutableStateFlow5 = mutableStateFlow7;
            label_100:
                boolean0 = (Boolean)object0;
                mutableStateFlow6 = mutableStateFlow5;
                c3 = c2;
                s3 = s2;
                v8 = v6;
            label_105:
                mutableStateFlow6.setValue(boolean0);
                int v9 = !c3.a;
                h1 = new kotlin.jvm.internal.H();
                f00.r = null;
                f00.w = null;
                f00.B = loginUser0;
                f00.D = null;
                f00.E = s3;
                f00.G = h1;
                f00.T = v7;
                f00.V = v8;
                f00.W = v9;
                f00.Z = 3;
                Object object2 = BuildersKt.withContext(Dispatchers.getIO(), new b2(2, null), f00);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                if(object2 == a0) {
                    return a0;
                }
                v10 = v9;
                object0 = object2;
                v11 = v7;
                loginUser2 = loginUser0;
                v12 = v8;
                goto label_138;
            }
            case 3: {
                v12 = f00.V;
                int v13 = f00.W;
                int v14 = f00.T;
                kotlin.jvm.internal.H h2 = (kotlin.jvm.internal.H)f00.G;
                String s5 = f00.E;
                LoginUser loginUser3 = f00.B;
                n.D(object0);
                v11 = v14;
                s3 = s5;
                loginUser2 = loginUser3;
                v10 = v13;
                h1 = h2;
            label_138:
                PlaylistId playlistId0 = (PlaylistId)object0;
                mutableStateFlow8 = mutableStateFlow0;
                if(kotlin.jvm.internal.q.b(mutableStateFlow0.getValue(), oe.f.a(true))) {
                    f00.r = null;
                    f00.w = null;
                    f00.B = loginUser2;
                    f00.D = null;
                    f00.E = s3;
                    f00.G = h1;
                    f00.I = playlistId0;
                    f00.T = v11;
                    f00.V = v12;
                    f00.W = v10;
                    f00.Z = 4;
                    Object object3 = w10.h(true, f00);
                    if(object3 == a0) {
                        return a0;
                    }
                    v15 = v11;
                    h3 = h1;
                    s6 = s3;
                    playlistId1 = playlistId0;
                    object0 = object3;
                    goto label_219;
                }
                else {
                    mutableStateFlow0 = mutableStateFlow8;
                    if(e.k.A(new PlaylistId[]{PlaylistId.SMART, PlaylistId.TEMP}).contains(playlistId0) || playlistId0.isDeprecated()) {
                        f00.r = null;
                        f00.w = null;
                        f00.B = loginUser2;
                        f00.D = null;
                        f00.E = s3;
                        f00.G = h1;
                        f00.I = null;
                        f00.T = v11;
                        f00.V = v12;
                        f00.W = v10;
                        f00.Z = 16;
                        object0 = w10.g(PlaylistId.MUSIC, true, f00);
                        if(object0 == a0) {
                            return a0;
                        }
                        v19 = v10;
                        v20 = v11;
                        h4 = h1;
                        loginUser4 = loginUser2;
                        v16 = v12;
                        goto label_784;
                    }
                    else {
                        try {
                            f00.r = null;
                            f00.w = null;
                            f00.B = loginUser2;
                            f00.D = null;
                            f00.E = s3;
                            f00.G = h1;
                            f00.I = playlistId0;
                            f00.T = v11;
                            f00.V = v12;
                            f00.W = v10;
                            f00.Z = 17;
                            object4 = w10.g(playlistId0, true, f00);
                        }
                        catch(Exception exception0) {
                            v16 = v12;
                            goto label_751;
                        }
                        if(object4 == a0) {
                            return a0;
                        }
                        playlistId2 = playlistId0;
                        object0 = object4;
                        s7 = s3;
                        v17 = v10;
                        v18 = v12;
                        goto label_742;
                    }
                }
                goto label_793;
            }
            case 4: {
                v12 = f00.V;
                int v21 = f00.W;
                int v22 = f00.T;
                PlaylistId playlistId3 = (PlaylistId)f00.I;
                kotlin.jvm.internal.H h5 = (kotlin.jvm.internal.H)f00.G;
                String s8 = f00.E;
                LoginUser loginUser5 = f00.B;
                n.D(object0);
                mutableStateFlow8 = mutableStateFlow0;
                v15 = v22;
                playlistId1 = playlistId3;
                loginUser2 = loginUser5;
                s6 = s8;
                h3 = h5;
                v10 = v21;
            label_219:
                f00.r = null;
                f00.w = null;
                f00.B = loginUser2;
                f00.D = null;
                f00.E = s6;
                f00.G = h3;
                f00.I = playlistId1;
                f00.M = (P0)object0;
                f00.T = v15;
                f00.V = v12;
                f00.W = v10;
                f00.Z = 5;
                Object object5 = ((P0)object0).U(s6, v10 != 0, f00);
                if(object5 == a0) {
                    return a0;
                }
                p00 = (P0)object0;
                object6 = object5;
                s9 = s6;
                h1 = h3;
                v11 = v15;
                goto label_257;
            }
            case 5: {
                v12 = f00.V;
                int v23 = f00.W;
                int v24 = f00.T;
                P0 p01 = (P0)f00.M;
                PlaylistId playlistId4 = (PlaylistId)f00.I;
                kotlin.jvm.internal.H h6 = (kotlin.jvm.internal.H)f00.G;
                String s10 = f00.E;
                LoginUser loginUser6 = f00.B;
                n.D(object0);
                object6 = ((ie.p)object0).d();
                p00 = p01;
                mutableStateFlow8 = mutableStateFlow0;
                playlistId1 = playlistId4;
                s9 = s10;
                v10 = v23;
                loginUser2 = loginUser6;
                h1 = h6;
                v11 = v24;
            label_257:
                if(ie.p.c(object6)) {
                    try {
                        if(!c.b(playlistId1)) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                        f00.r = null;
                        f00.w = null;
                        f00.B = loginUser2;
                        f00.D = null;
                        f00.E = s9;
                        f00.G = h1;
                        f00.I = playlistId1;
                        f00.M = p00;
                        f00.N = null;
                        f00.T = v11;
                        f00.V = v12;
                        f00.W = v10;
                        f00.Z = 6;
                        object7 = c1.a(s9, f00);
                    }
                    catch(Throwable throwable1) {
                        v17 = v10;
                        s7 = s9;
                        v18 = v12;
                        h7 = h1;
                        playlistId5 = playlistId1;
                        w0 = p00;
                        goto label_332;
                    }
                    if(object7 == a0) {
                        return a0;
                    }
                    v17 = v10;
                    s7 = s9;
                    v18 = v12;
                    h7 = h1;
                    playlistId5 = playlistId1;
                    w0 = p00;
                    goto label_328;
                }
                else {
                    Throwable throwable2 = ie.p.a(object6);
                    LogU.error$default(this.l, "Fail to restore smartPlaylist. - " + (throwable2 == null ? null : throwable2.getMessage()), null, false, 6, null);
                    String s11 = throwable2 == null ? null : throwable2.getMessage();
                    kotlin.jvm.internal.q.g(("restoreSmartPlaylistFailed from:PlaylistManager-restore(), exception:" + s11), "message");
                    String s12 = "memberKey:" + s9 + "\n" + ("restoreSmartPlaylistFailed from:PlaylistManager-restore(), exception:" + s11);
                    kotlin.jvm.internal.q.f(s12, "toString(...)");
                    Reporter.createReporter(Type.PLAYLIST, LogLevel.INFO).setMessage(s12).report();
                    if(e1.u.o(s9)) {
                        f00.r = null;
                        f00.w = null;
                        f00.B = loginUser2;
                        f00.D = null;
                        f00.E = s9;
                        f00.G = h1;
                        f00.I = playlistId1;
                        f00.M = null;
                        f00.N = null;
                        f00.S = null;
                        f00.T = v11;
                        f00.V = v12;
                        f00.W = v10;
                        f00.Z = 12;
                        if(SmartPlaylistUseSettingPreferencesRepository.INSTANCE.updateUseSmartPlaylist(s9, false, f00) != a0) {
                            loginUser7 = loginUser2;
                            goto label_601;
                        }
                        return a0;
                    }
                    loginUser7 = loginUser2;
                    goto label_601;
                }
                goto label_793;
            }
            case 6: {
                v17 = f00.W;
                v18 = f00.V;
                v11 = f00.T;
                w0 = (P0)f00.M;
                playlistId5 = (PlaylistId)f00.I;
                h7 = (kotlin.jvm.internal.H)f00.G;
                s7 = f00.E;
                loginUser2 = f00.B;
                try {
                    n.D(object0);
                    mutableStateFlow8 = mutableStateFlow0;
                    object7 = ((ie.p)object0).d();
                    mutableStateFlow8 = mutableStateFlow0;
                label_328:
                    n.D(object7);
                    i30 = (i3)object7;
                    goto label_333;
                }
                catch(Throwable throwable1) {
                }
            label_332:
                i30 = n.t(throwable1);
            label_333:
                if(ie.p.b(i30)) {
                    i30 = null;
                }
                if(i30 instanceof h3) {
                    String s13 = ((h3)i30).c();
                    long v25 = ((h3)i30).b();
                    f00.r = null;
                    f00.w = null;
                    f00.B = loginUser2;
                    f00.D = null;
                    f00.E = s7;
                    f00.G = h7;
                    f00.I = null;
                    f00.M = w0;
                    f00.N = null;
                    f00.S = null;
                    f00.T = v11;
                    f00.V = v18;
                    f00.W = v17;
                    f00.Z = 7;
                    if(((P0)w0).V(s13, v25, f00) == a0) {
                        return a0;
                    }
                    v19 = v17;
                    v16 = v18;
                    v20 = v11;
                    w1 = w0;
                    h8 = h7;
                    s14 = s7;
                    loginUser8 = loginUser2;
                    goto label_437;
                }
                else if(i30 instanceof g3) {
                    f00.r = null;
                    f00.w = null;
                    f00.B = loginUser2;
                    f00.D = null;
                    f00.E = s7;
                    f00.G = h7;
                    f00.I = null;
                    f00.M = w0;
                    f00.N = null;
                    f00.S = i30;
                    f00.T = v11;
                    f00.V = v18;
                    f00.W = v17;
                    f00.Z = 8;
                    Object object8 = w10.b(false, f00);
                    if(object8 == a0) {
                        return a0;
                    }
                    v26 = v18;
                    v27 = v11;
                    loginUser9 = loginUser2;
                    i31 = i30;
                    object0 = object8;
                    v28 = v17;
                    s15 = s7;
                    h9 = h7;
                    goto label_463;
                }
                else {
                    playlistId6 = PlaylistId.SMART;
                    if(playlistId5 == playlistId6 || e.k.A(new PlaylistId[]{PlaylistId.MUSIC, PlaylistId.TEMP}).contains(playlistId5) || playlistId5.isDeprecated()) {
                        h7.a = playlistId6;
                        mutableStateFlow0 = mutableStateFlow8;
                    }
                    else {
                        try {
                            f00.r = null;
                            f00.w = null;
                            f00.B = loginUser2;
                            f00.D = null;
                            f00.E = s7;
                            f00.G = h7;
                            f00.I = playlistId5;
                            f00.M = w0;
                            f00.N = null;
                            f00.S = null;
                            f00.T = v11;
                            f00.V = v18;
                            f00.W = v17;
                            f00.Z = 11;
                            object0 = w10.g(playlistId5, true, f00);
                        }
                        catch(Exception unused_ex) {
                            v19 = v17;
                            v29 = v18;
                            v30 = v11;
                            w2 = w0;
                            h1 = h7;
                            s16 = s7;
                            loginUser10 = loginUser2;
                            goto label_578;
                        }
                        if(object0 == a0) {
                            return a0;
                        }
                        v19 = v17;
                        v29 = v18;
                        v30 = v11;
                        w2 = w0;
                        playlistId7 = playlistId5;
                        h1 = h7;
                        s16 = s7;
                        loginUser10 = loginUser2;
                        goto label_567;
                    }
                }
                goto label_793;
            }
            case 7: {
                v19 = f00.W;
                v16 = f00.V;
                v20 = f00.T;
                i3 i32 = (i3)f00.S;
                w1 = (P0)f00.M;
                PlaylistId playlistId8 = (PlaylistId)f00.I;
                h8 = (kotlin.jvm.internal.H)f00.G;
                s14 = f00.E;
                loginUser8 = f00.B;
                n.D(object0);
                mutableStateFlow8 = mutableStateFlow0;
            label_437:
                playlistId6 = PlaylistId.SMART;
                h8.a = playlistId6;
                EventBusHelper.post(EventCurPlaylistViewFocus.INSTANCE);
                s7 = s14;
                loginUser2 = loginUser8;
                mutableStateFlow0 = mutableStateFlow8;
                h7 = h8;
                w0 = w1;
                goto label_790;
            }
            case 8: {
                int v31 = f00.W;
                int v32 = f00.V;
                int v33 = f00.T;
                i31 = (i3)f00.S;
                w0 = (P0)f00.M;
                PlaylistId playlistId9 = (PlaylistId)f00.I;
                kotlin.jvm.internal.H h10 = (kotlin.jvm.internal.H)f00.G;
                String s17 = f00.E;
                LoginUser loginUser11 = f00.B;
                n.D(object0);
                v28 = v31;
                mutableStateFlow8 = mutableStateFlow0;
                s15 = s17;
                loginUser9 = loginUser11;
                v26 = v32;
                h9 = h10;
                v27 = v33;
            label_463:
                DrawerPlaylistInfo drawerPlaylistInfo0 = ((g3)i31).c();
                String s18 = ((g3)i31).b();
                long v34 = ((g3)i31).d();
                f00.r = null;
                f00.w = null;
                f00.B = loginUser9;
                f00.D = null;
                f00.E = s15;
                f00.G = h9;
                f00.I = null;
                f00.M = w0;
                f00.N = null;
                f00.S = (nc.u0)object0;
                f00.T = v27;
                f00.V = v26;
                f00.W = v28;
                f00.Z = 9;
                object9 = ((nc.u0)object0).N(drawerPlaylistInfo0, s18, v34, f00);
                if(object9 == a0) {
                    return a0;
                }
                u00 = (nc.u0)object0;
                v35 = v26;
                v36 = v27;
                h11 = h9;
                s19 = s15;
                loginUser12 = loginUser9;
                v37 = v28;
                goto label_502;
            }
            case 9: {
                v37 = f00.W;
                v35 = f00.V;
                v36 = f00.T;
                u00 = (nc.u0)f00.S;
                w0 = (P0)f00.M;
                PlaylistId playlistId10 = (PlaylistId)f00.I;
                h11 = (kotlin.jvm.internal.H)f00.G;
                s19 = f00.E;
                loginUser12 = f00.B;
                n.D(object0);
                object9 = ((ie.p)object0).d();
                mutableStateFlow8 = mutableStateFlow0;
            label_502:
                z = ie.p.c(object9);
                if(!z) {
                    try {
                        f00.r = null;
                        f00.w = null;
                        f00.B = loginUser12;
                        f00.D = null;
                        f00.E = s19;
                        f00.G = h11;
                        f00.I = null;
                        f00.M = w0;
                        f00.N = null;
                        f00.S = u00;
                        f00.T = v36;
                        f00.V = v35;
                        f00.W = v37;
                        f00.Z = 10;
                        if(u00.O(f00) != a0) {
                            goto label_536;
                        }
                        return a0;
                    }
                    catch(Throwable throwable3) {
                        o0 = n.t(throwable3);
                        goto label_537;
                    }
                    goto label_536;
                }
                goto label_538;
            }
            case 10: {
                v37 = f00.W;
                v35 = f00.V;
                v36 = f00.T;
                u00 = (nc.u0)f00.S;
                w0 = (P0)f00.M;
                PlaylistId playlistId11 = (PlaylistId)f00.I;
                h11 = (kotlin.jvm.internal.H)f00.G;
                s19 = f00.E;
                loginUser12 = f00.B;
                try {
                    mutableStateFlow8 = mutableStateFlow0;
                    n.D(object0);
                    mutableStateFlow8 = mutableStateFlow0;
                }
                catch(Throwable throwable3) {
                    o0 = n.t(throwable3);
                    goto label_537;
                }
            label_536:
                o0 = h0;
            label_537:
                z = ie.p.c(o0);
            label_538:
                loginUser2 = loginUser12;
                v11 = v36;
                s7 = s19;
                v18 = v35;
                h7 = h11;
                v17 = v37;
                if(z) {
                    playlistId6 = PlaylistId.DRAWER;
                    h7.a = playlistId6;
                    EventBusHelper.post(EventCurPlaylistViewFocus.INSTANCE);
                    w0 = u00;
                }
                else {
                    playlistId6 = PlaylistId.SMART;
                    h7.a = playlistId6;
                }
                mutableStateFlow0 = mutableStateFlow8;
                goto label_793;
            }
            case 11: {
                v19 = f00.W;
                v29 = f00.V;
                v30 = f00.T;
                i3 i33 = (i3)f00.S;
                w2 = (P0)f00.M;
                playlistId7 = (PlaylistId)f00.I;
                h1 = (kotlin.jvm.internal.H)f00.G;
                s16 = f00.E;
                loginUser10 = f00.B;
                try {
                    mutableStateFlow8 = mutableStateFlow0;
                    n.D(object0);
                    mutableStateFlow8 = mutableStateFlow0;
                label_567:
                    h1.a = playlistId7;
                    PlaylistId playlistId12 = playlistId7.isAudioType() ? playlistId7 : PlaylistId.SMART;
                    w0 = (w)object0;
                    playlistId6 = playlistId12;
                    v11 = v30;
                    loginUser2 = loginUser10;
                    mutableStateFlow0 = mutableStateFlow8;
                    v18 = v29;
                    s7 = s16;
                    v17 = v19;
                    h7 = h1;
                    goto label_793;
                }
                catch(Exception unused_ex) {
                label_578:
                    playlistId6 = PlaylistId.SMART;
                    h1.a = playlistId6;
                    w0 = w2;
                    loginUser2 = loginUser10;
                    mutableStateFlow0 = mutableStateFlow8;
                    v11 = v30;
                    s7 = s16;
                    v18 = v29;
                    h7 = h1;
                    goto label_792;
                }
            }
            case 12: {
                int v38 = f00.W;
                int v39 = f00.V;
                v11 = f00.T;
                Throwable throwable4 = (Throwable)f00.S;
                P0 p02 = (P0)f00.M;
                playlistId1 = (PlaylistId)f00.I;
                h1 = (kotlin.jvm.internal.H)f00.G;
                s9 = f00.E;
                loginUser7 = f00.B;
                n.D(object0);
                v12 = v39;
                mutableStateFlow8 = mutableStateFlow0;
                v10 = v38;
            label_601:
                mutableStateFlow0 = mutableStateFlow8;
                mutableStateFlow0.setValue(oe.f.a(false));
                if(e.k.A(new PlaylistId[]{PlaylistId.SMART, PlaylistId.TEMP}).contains(playlistId1) || playlistId1.isDeprecated()) {
                    f00.r = null;
                    f00.w = null;
                    f00.B = loginUser7;
                    f00.D = null;
                    f00.E = s9;
                    f00.G = h1;
                    f00.I = null;
                    f00.M = null;
                    f00.N = null;
                    f00.S = null;
                    f00.T = v11;
                    f00.V = v12;
                    f00.W = v10;
                    f00.Z = 13;
                    object0 = w10.g(PlaylistId.MUSIC, true, f00);
                    if(object0 == a0) {
                        return a0;
                    }
                    v19 = v10;
                    v20 = v11;
                    h4 = h1;
                    s3 = s9;
                    loginUser4 = loginUser7;
                    v16 = v12;
                    goto label_784;
                }
                else {
                    try {
                        f00.r = null;
                        f00.w = null;
                        f00.B = loginUser7;
                        f00.D = null;
                        f00.E = s9;
                        f00.G = h1;
                        f00.I = playlistId1;
                        f00.M = null;
                        f00.N = null;
                        f00.S = null;
                        f00.T = v11;
                        f00.V = v12;
                        f00.W = v10;
                        f00.Z = 14;
                        object0 = w10.g(playlistId1, true, f00);
                    }
                    catch(Exception exception1) {
                        s3 = s9;
                        v16 = v12;
                        goto label_683;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    v17 = v10;
                    v18 = v12;
                    goto label_672;
                }
                goto label_793;
            }
            case 13: {
                v19 = f00.W;
                v16 = f00.V;
                v20 = f00.T;
                Throwable throwable5 = (Throwable)f00.S;
                P0 p03 = (P0)f00.M;
                PlaylistId playlistId13 = (PlaylistId)f00.I;
                h4 = (kotlin.jvm.internal.H)f00.G;
                s3 = f00.E;
                loginUser4 = f00.B;
                n.D(object0);
                goto label_784;
            }
            case 14: {
                v17 = f00.W;
                v18 = f00.V;
                v11 = f00.T;
                Throwable throwable6 = (Throwable)f00.S;
                P0 p04 = (P0)f00.M;
                playlistId1 = (PlaylistId)f00.I;
                h1 = (kotlin.jvm.internal.H)f00.G;
                s9 = f00.E;
                loginUser7 = f00.B;
                try {
                    n.D(object0);
                label_672:
                    h1.a = playlistId1;
                    PlaylistId playlistId14 = playlistId1.isAudioType() ? playlistId1 : PlaylistId.MUSIC;
                    w0 = (w)object0;
                    playlistId6 = playlistId14;
                    loginUser2 = loginUser7;
                    s7 = s9;
                    h7 = h1;
                    goto label_793;
                }
                catch(Exception exception1) {
                    v10 = v17;
                    v16 = v18;
                    s3 = s9;
                }
            label_683:
                LogU.error$default(this.l, "Fail to restore playlist. - " + exception1.getMessage(), null, false, 6, null);
                f00.r = null;
                f00.w = null;
                f00.B = loginUser7;
                f00.D = null;
                f00.E = s3;
                f00.G = null;
                f00.I = h1;
                f00.M = null;
                f00.N = null;
                f00.S = null;
                f00.T = v11;
                f00.V = v16;
                f00.W = v10;
                f00.Z = 15;
                object0 = w10.g(PlaylistId.MUSIC, true, f00);
                if(object0 == a0) {
                    return a0;
                }
                v19 = v10;
                v20 = v11;
                h4 = h1;
                loginUser4 = loginUser7;
                goto label_784;
            }
            case 15: {
                v19 = f00.W;
                v16 = f00.V;
                v20 = f00.T;
                P0 p05 = (P0)f00.N;
                PlaylistId playlistId15 = (PlaylistId)f00.M;
                h4 = (kotlin.jvm.internal.H)f00.I;
                w w3 = (w)f00.G;
                s3 = f00.E;
                loginUser4 = f00.B;
                n.D(object0);
                goto label_784;
            }
            case 16: {
                v19 = f00.W;
                v16 = f00.V;
                v20 = f00.T;
                PlaylistId playlistId16 = (PlaylistId)f00.I;
                h4 = (kotlin.jvm.internal.H)f00.G;
                s3 = f00.E;
                loginUser4 = f00.B;
                n.D(object0);
                goto label_784;
            }
            case 17: {
                v17 = f00.W;
                v18 = f00.V;
                v11 = f00.T;
                playlistId2 = (PlaylistId)f00.I;
                h1 = (kotlin.jvm.internal.H)f00.G;
                String s20 = f00.E;
                LoginUser loginUser13 = f00.B;
                try {
                    n.D(object0);
                    loginUser2 = loginUser13;
                    s7 = s20;
                }
                catch(Exception exception0) {
                    v10 = v17;
                    v16 = v18;
                    s3 = s20;
                    loginUser2 = loginUser13;
                    goto label_751;
                }
                try {
                label_742:
                    h1.a = playlistId2;
                    PlaylistId playlistId17 = playlistId2.isAudioType() ? playlistId2 : PlaylistId.MUSIC;
                    w0 = (w)object0;
                    playlistId6 = playlistId17;
                    h7 = h1;
                    goto label_793;
                }
                catch(Exception exception0) {
                    v10 = v17;
                    v16 = v18;
                    s3 = s7;
                }
            label_751:
                LogU.error$default(this.l, "Fail to restore playlist. - " + exception0.getMessage(), null, false, 6, null);
                f00.r = null;
                f00.w = null;
                f00.B = loginUser2;
                f00.D = null;
                f00.E = s3;
                f00.G = null;
                f00.I = h1;
                f00.M = null;
                f00.N = null;
                f00.T = v11;
                f00.V = v16;
                f00.W = v10;
                f00.Z = 18;
                object0 = w10.g(PlaylistId.MUSIC, true, f00);
                if(object0 == a0) {
                    return a0;
                }
                v19 = v10;
                v20 = v11;
                h4 = h1;
                loginUser4 = loginUser2;
                goto label_784;
            }
            case 18: {
                v19 = f00.W;
                v16 = f00.V;
                v20 = f00.T;
                Exception exception2 = (Exception)f00.N;
                PlaylistId playlistId18 = (PlaylistId)f00.M;
                h4 = (kotlin.jvm.internal.H)f00.I;
                w w4 = (w)f00.G;
                s3 = f00.E;
                loginUser4 = f00.B;
                n.D(object0);
            label_784:
                h4.a = PlaylistId.MUSIC;
                s7 = s3;
                loginUser2 = loginUser4;
                w0 = (w)object0;
                playlistId6 = PlaylistId.MUSIC;
                h7 = h4;
            label_790:
                v11 = v20;
                v18 = v16;
            label_792:
                v17 = v19;
            label_793:
                if(w0 instanceof y) {
                    F2 f20 = b0.n();
                    f00.r = null;
                    f00.w = null;
                    f00.B = loginUser2;
                    f00.D = null;
                    f00.E = s7;
                    f00.G = (y)w0;
                    f00.I = w0;
                    f00.M = h7;
                    f00.N = playlistId6;
                    f00.S = null;
                    f00.T = v11;
                    f00.V = v18;
                    f00.W = v17;
                    f00.Z = 19;
                    Object object10 = FlowKt.first(f20, f00);
                    if(object10 == a0) {
                        return a0;
                    }
                    playlistId19 = playlistId6;
                    object0 = object10;
                    w5 = w0;
                    h12 = h7;
                    y0 = (y)w0;
                    v40 = v17;
                    v41 = v18;
                    v42 = v11;
                    goto label_831;
                }
                goto label_866;
            }
            case 19: {
                v40 = f00.W;
                v41 = f00.V;
                v42 = f00.T;
                PlaylistId playlistId20 = (PlaylistId)f00.S;
                playlistId19 = f00.N;
                h12 = (kotlin.jvm.internal.H)f00.M;
                w5 = (w)f00.I;
                y0 = (y)f00.G;
                s7 = f00.E;
                loginUser2 = f00.B;
                n.D(object0);
            label_831:
                f00.r = null;
                f00.w = null;
                f00.B = loginUser2;
                f00.D = null;
                f00.E = s7;
                f00.G = w5;
                f00.I = h12;
                f00.M = playlistId19;
                f00.N = null;
                f00.S = null;
                f00.T = v42;
                f00.V = v41;
                f00.W = v40;
                f00.Z = 20;
                if(y0.o(((oc.M)object0), f00) == a0) {
                    return a0;
                }
                s21 = s7;
                loginUser14 = loginUser2;
                goto label_858;
            }
            case 20: {
                v40 = f00.W;
                v41 = f00.V;
                v42 = f00.T;
                playlistId19 = (PlaylistId)f00.M;
                h12 = (kotlin.jvm.internal.H)f00.I;
                w5 = (w)f00.G;
                s21 = f00.E;
                loginUser14 = f00.B;
                n.D(object0);
            label_858:
                playlistId6 = playlistId19;
                loginUser2 = loginUser14;
                v11 = v42;
                s7 = s21;
                v18 = v41;
                h7 = h12;
                w0 = w5;
                v17 = v40;
            label_866:
                if(w0 instanceof A) {
                    F2 f21 = b0.o();
                    f00.r = null;
                    f00.w = null;
                    f00.B = loginUser2;
                    f00.D = null;
                    f00.E = s7;
                    f00.G = (A)w0;
                    f00.I = w0;
                    f00.M = h7;
                    f00.N = playlistId6;
                    f00.S = null;
                    f00.T = v11;
                    f00.V = v18;
                    f00.W = v17;
                    f00.Z = 21;
                    Object object11 = FlowKt.first(f21, f00);
                    if(object11 == a0) {
                        return a0;
                    }
                    playlistId21 = playlistId6;
                    object0 = object11;
                    w6 = w0;
                    h13 = h7;
                    a1 = (A)w0;
                    v43 = v17;
                    v44 = v18;
                    v45 = v11;
                    goto label_909;
                }
                else {
                    v43 = v17;
                    v44 = v18;
                    v45 = v11;
                    w7 = w0;
                }
                goto label_941;
            }
            case 21: {
                v43 = f00.W;
                v44 = f00.V;
                v45 = f00.T;
                PlaylistId playlistId22 = (PlaylistId)f00.S;
                playlistId21 = f00.N;
                h13 = (kotlin.jvm.internal.H)f00.M;
                w6 = (w)f00.I;
                a1 = (A)f00.G;
                s7 = f00.E;
                loginUser2 = f00.B;
                n.D(object0);
            label_909:
                f00.r = null;
                f00.w = null;
                f00.B = loginUser2;
                f00.D = null;
                f00.E = s7;
                f00.G = w6;
                f00.I = h13;
                f00.M = playlistId21;
                f00.N = null;
                f00.S = null;
                f00.T = v45;
                f00.V = v44;
                f00.W = v43;
                f00.Z = 22;
                if(a1.m(((Boolean)object0).booleanValue(), f00) == a0) {
                    return a0;
                }
                s22 = s7;
                loginUser15 = loginUser2;
                goto label_936;
            }
            case 22: {
                v43 = f00.W;
                v44 = f00.V;
                v45 = f00.T;
                playlistId21 = (PlaylistId)f00.M;
                h13 = (kotlin.jvm.internal.H)f00.I;
                w6 = (w)f00.G;
                s22 = f00.E;
                loginUser15 = f00.B;
                n.D(object0);
            label_936:
                playlistId6 = playlistId21;
                w7 = w6;
                loginUser2 = loginUser15;
                s7 = s22;
                h7 = h13;
            label_941:
                if(w7 instanceof oc.J) {
                    ((oc.J)w7).j(new ea.d(this, h7));
                }
                mutableStateFlow2.setValue(h7.a);
                mutableStateFlow1.setValue(playlistId6);
                e0 = this.t;
                if(e0 != null) {
                    playlistId23 = (PlaylistId)h7.a;
                    f00.r = null;
                    f00.w = null;
                    f00.B = loginUser2;
                    f00.D = null;
                    f00.E = s7;
                    f00.G = e0;
                    f00.I = playlistId23;
                    f00.M = w7;
                    f00.N = null;
                    f00.S = null;
                    f00.T = v45;
                    f00.V = v44;
                    f00.W = v43;
                    f00.Z = 23;
                    object0 = w7.b(f00);
                    if(object0 == a0) {
                        return a0;
                    }
                    s23 = s7;
                    loginUser16 = loginUser2;
                    goto label_978;
                }
                goto label_1002;
            }
            case 23: {
                v43 = f00.W;
                v44 = f00.V;
                v45 = f00.T;
                PlaylistId playlistId24 = (PlaylistId)f00.S;
                kotlin.jvm.internal.H h14 = (kotlin.jvm.internal.H)f00.N;
                w7 = (w)f00.M;
                playlistId23 = (PlaylistId)f00.I;
                e0 = (e)f00.G;
                s23 = f00.E;
                loginUser16 = f00.B;
                n.D(object0);
            label_978:
                long v46 = w7.k();
                f00.r = null;
                f00.w = null;
                f00.B = loginUser16;
                f00.D = null;
                f00.E = s23;
                f00.G = null;
                f00.I = null;
                f00.M = null;
                f00.N = null;
                f00.S = null;
                f00.T = v45;
                f00.V = v44;
                f00.W = v43;
                f00.Z = 24;
                if(((Vb.d0)e0).c(playlistId23, ((oc.Q)object0), v46, f00) == a0) {
                    return a0;
                }
                s24 = s23;
                goto label_1001;
            }
            case 24: {
                PlaylistId playlistId25 = (PlaylistId)f00.M;
                kotlin.jvm.internal.H h15 = (kotlin.jvm.internal.H)f00.I;
                w w8 = (w)f00.G;
                s24 = f00.E;
                n.D(object0);
            label_1001:
                s7 = s24;
            label_1002:
                if(e1.u.o("")) {
                    boolean z1 = kotlin.jvm.internal.q.b(mutableStateFlow0.getValue(), oe.f.a(true));
                    SmartPlaylistLog.INSTANCE.sendSpStatisticsAsync("restore", s7, z1);
                }
                break;
            }
            case 25: {
                try {
                    int v47 = f00.V;
                    int v48 = f00.T;
                    s25 = f00.w;
                    l02 = f00.r;
                    n.D(object0);
                    mutableStateFlow3 = mutableStateFlow0;
                    l00 = l02;
                    mutableStateFlow4 = mutableStateFlow2;
                    v4 = v47;
                    v3 = v48;
                    s = s25;
                }
                catch(Throwable throwable0) {
                    l01 = l02;
                    s1 = s25;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_1022:
                    loginUser17 = (LoginUser)object0;
                    mutableStateFlow2 = mutableStateFlow4;
                    c5 = new C();
                    if(e1.u.o("")) {
                        goto label_1031;
                    }
                    else {
                        goto label_1059;
                    }
                    goto label_1095;
                }
                catch(Throwable throwable0) {
                    s26 = s;
                    l01 = l00;
                    s1 = s26;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_1031:
                    s26 = s;
                    I0 i01 = new I0(c5, this, null);
                    f00.r = l00;
                    f00.w = s;
                    f00.B = loginUser17;
                    f00.D = c5;
                    s27 = "";
                    f00.E = "";
                    c6 = c5;
                    mutableStateFlow9 = mutableStateFlow3;
                    f00.G = mutableStateFlow9;
                    f00.T = v3;
                    f00.V = v4;
                    s26 = s;
                    f00.Z = 26;
                    object12 = smartPlaylistUseSettingPreferencesRepository0.getUseSmartPlaylistOrSet("", i01, f00);
                }
                catch(Throwable throwable0) {
                    l01 = l00;
                    s1 = s26;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                if(object12 == a0) {
                    return a0;
                }
                loginUser18 = loginUser17;
                object0 = object12;
                l01 = l00;
                mutableStateFlow10 = mutableStateFlow9;
                s28 = s26;
                goto label_1086;
            label_1059:
                c6 = c5;
                mutableStateFlow10 = mutableStateFlow3;
                mutableStateFlow11 = mutableStateFlow10;
                s29 = "";
                v49 = v3;
                l03 = l00;
                loginUser18 = loginUser17;
                boolean1 = oe.f.a(false);
                s30 = s;
                goto label_1095;
            }
            case 26: {
                int v50 = f00.V;
                int v51 = f00.T;
                MutableStateFlow mutableStateFlow12 = (MutableStateFlow)f00.G;
                String s31 = f00.E;
                C c7 = f00.D;
                LoginUser loginUser19 = f00.B;
                s28 = f00.w;
                l04 = f00.r;
                try {
                    n.D(object0);
                    l01 = l04;
                    v4 = v50;
                    v3 = v51;
                    mutableStateFlow10 = mutableStateFlow12;
                    c6 = c7;
                    loginUser18 = loginUser19;
                    mutableStateFlow9 = mutableStateFlow0;
                    s27 = s31;
                }
                catch(Throwable throwable0) {
                    l01 = l04;
                    s1 = s28;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_1086:
                    boolean1 = (Boolean)object0;
                    l03 = l01;
                    s30 = s28;
                    mutableStateFlow11 = mutableStateFlow9;
                    s29 = s27;
                    v49 = v3;
                }
                catch(Throwable throwable0) {
                    s1 = s28;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_1095:
                    mutableStateFlow10.setValue(boolean1);
                    v52 = !c6.a;
                    s32 = s30;
                    l05 = l03;
                    h16 = new kotlin.jvm.internal.H();
                    f00.r = l03;
                    f00.w = s30;
                    f00.B = loginUser18;
                    f00.D = null;
                    f00.E = s29;
                    f00.G = h16;
                    f00.T = v49;
                    f00.V = v4;
                    f00.W = v52;
                    f00.Z = 27;
                    s32 = s30;
                    l05 = l03;
                    object13 = BuildersKt.withContext(Dispatchers.getIO(), new b2(2, null), f00);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                }
                catch(Throwable throwable0) {
                    s1 = s32;
                    l01 = l05;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                if(object13 == a0) {
                    return a0;
                }
                v53 = v52;
                object0 = object13;
                s33 = s32;
                loginUser20 = loginUser18;
                l04 = l05;
                goto label_1147;
            }
            case 27: {
                int v54 = f00.W;
                int v55 = f00.V;
                int v56 = f00.T;
                kotlin.jvm.internal.H h17 = (kotlin.jvm.internal.H)f00.G;
                String s34 = f00.E;
                LoginUser loginUser21 = f00.B;
                String s35 = f00.w;
                l04 = f00.r;
                try {
                    n.D(object0);
                    mutableStateFlow11 = mutableStateFlow0;
                    v53 = v54;
                    v4 = v55;
                    v49 = v56;
                    loginUser20 = loginUser21;
                    s33 = s35;
                    s29 = s34;
                    h16 = h17;
                }
                catch(Throwable throwable0) {
                    l01 = l04;
                    s1 = s35;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_1147:
                    playlistId26 = (PlaylistId)object0;
                    if(kotlin.jvm.internal.q.b(mutableStateFlow11.getValue(), oe.f.a(true))) {
                        goto label_1203;
                    }
                    else {
                        mutableStateFlow13 = mutableStateFlow1;
                        mutableStateFlow14 = mutableStateFlow11;
                        if(e.k.A(new PlaylistId[]{PlaylistId.SMART, PlaylistId.TEMP}).contains(playlistId26)) {
                            goto label_1178;
                        }
                        else {
                            goto label_1152;
                        }
                    }
                    goto label_2004;
                }
                catch(Throwable throwable0) {
                    s1 = s33;
                    l01 = l04;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_1152:
                    if(playlistId26.isDeprecated()) {
                        goto label_1178;
                    }
                    else {
                        try {
                            f00.r = l04;
                            f00.w = s33;
                            f00.B = loginUser20;
                            f00.D = null;
                            f00.E = s29;
                            f00.G = h16;
                            f00.I = playlistId26;
                            f00.T = v49;
                            f00.V = v4;
                            f00.W = v53;
                            f00.Z = 41;
                            object14 = w10.g(playlistId26, true, f00);
                            goto label_1171;
                        }
                        catch(Exception exception3) {
                        }
                        loginUser22 = loginUser20;
                        s36 = s29;
                        s1 = s33;
                        l01 = l04;
                        goto label_1956;
                    }
                    goto label_2004;
                }
                catch(Throwable throwable0) {
                    s1 = s33;
                    l01 = l04;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                loginUser22 = loginUser20;
                s36 = s29;
                s1 = s33;
                l01 = l04;
                goto label_1956;
            label_1171:
                if(object14 == a0) {
                    return a0;
                }
                playlistId27 = playlistId26;
                object0 = object14;
                s37 = s29;
                loginUser22 = loginUser20;
                s1 = s33;
                goto label_1946;
                try {
                label_1178:
                    f00.r = l04;
                    f00.w = s33;
                    f00.B = loginUser20;
                    f00.D = null;
                    f00.E = s29;
                    f00.G = h16;
                    f00.I = null;
                    f00.T = v49;
                    f00.V = v4;
                    f00.W = v53;
                    f00.Z = 40;
                    object0 = w10.g(PlaylistId.MUSIC, true, f00);
                }
                catch(Throwable throwable0) {
                    s1 = s33;
                    l01 = l04;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                if(object0 == a0) {
                    return a0;
                }
                loginUser22 = loginUser20;
                s36 = s29;
                s1 = s33;
                v57 = v53;
                h18 = h16;
                l01 = l04;
                goto label_1998;
                try {
                label_1203:
                    f00.r = l04;
                    f00.w = s33;
                    f00.B = loginUser20;
                    f00.D = null;
                    f00.E = s29;
                    f00.G = h16;
                    f00.I = playlistId26;
                    f00.T = v49;
                    f00.V = v4;
                    f00.W = v53;
                    f00.Z = 28;
                    object15 = w10.h(true, f00);
                }
                catch(Throwable throwable0) {
                    s1 = s33;
                    l01 = l04;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                if(object15 == a0) {
                    return a0;
                }
                playlistId28 = playlistId26;
                object0 = object15;
                goto label_1247;
            }
            case 28: {
                int v58 = f00.W;
                int v59 = f00.V;
                int v60 = f00.T;
                PlaylistId playlistId29 = (PlaylistId)f00.I;
                kotlin.jvm.internal.H h19 = (kotlin.jvm.internal.H)f00.G;
                String s38 = f00.E;
                LoginUser loginUser23 = f00.B;
                s28 = f00.w;
                l04 = f00.r;
                try {
                    n.D(object0);
                    playlistId28 = playlistId29;
                    v53 = v58;
                    v4 = v59;
                    loginUser20 = loginUser23;
                    s33 = s28;
                    mutableStateFlow11 = mutableStateFlow0;
                    v49 = v60;
                    h16 = h19;
                    s29 = s38;
                    goto label_1247;
                }
                catch(Throwable throwable0) {
                    l01 = l04;
                }
                s1 = s28;
                k8.Y.v(s1, " false", l01, false);
                throw throwable0;
                try {
                label_1247:
                    s39 = s33;
                    p06 = (P0)object0;
                    f00.r = l04;
                    f00.w = s33;
                    f00.B = loginUser20;
                    s39 = s33;
                    f00.D = null;
                    f00.E = s29;
                    f00.G = h16;
                    f00.I = playlistId28;
                    f00.M = p06;
                    f00.T = v49;
                    f00.V = v4;
                    f00.W = v53;
                    f00.Z = 29;
                    object16 = p06.U(s29, v53 != 0, f00);
                }
                catch(Throwable throwable0) {
                    l01 = l04;
                    s1 = s39;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                if(object16 == a0) {
                    return a0;
                }
                s37 = s29;
                p07 = p06;
                object17 = object16;
                l01 = l04;
                loginUser24 = loginUser20;
                playlistId30 = playlistId28;
                s40 = s39;
                goto label_1305;
            }
            case 29: {
                int v61 = f00.W;
                int v62 = f00.V;
                int v63 = f00.T;
                P0 p08 = (P0)f00.M;
                PlaylistId playlistId31 = (PlaylistId)f00.I;
                kotlin.jvm.internal.H h20 = (kotlin.jvm.internal.H)f00.G;
                String s41 = f00.E;
                LoginUser loginUser25 = f00.B;
                String s42 = f00.w;
                L0 l06 = f00.r;
                try {
                    n.D(object0);
                    l01 = l06;
                    object17 = ((ie.p)object0).d();
                    l01 = l06;
                    v53 = v61;
                    v4 = v62;
                    playlistId30 = playlistId31;
                    loginUser24 = loginUser25;
                    s40 = s42;
                    mutableStateFlow11 = mutableStateFlow0;
                    p07 = p08;
                    v49 = v63;
                    s37 = s41;
                    h16 = h20;
                }
                catch(Throwable throwable0) {
                    s1 = s42;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            label_1305:
                if(ie.p.c(object17)) {
                    try {
                        if(!c.b(playlistId30)) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                        f00.r = l01;
                        f00.w = s40;
                        f00.B = loginUser24;
                        f00.D = null;
                        f00.E = s37;
                        f00.G = h16;
                        f00.I = playlistId30;
                        f00.M = p07;
                        f00.N = null;
                        f00.T = v49;
                        f00.V = v4;
                        f00.W = v53;
                        f00.Z = 30;
                        object18 = c1.a(s37, f00);
                    }
                    catch(Throwable throwable7) {
                        playlistId32 = playlistId30;
                        w9 = p07;
                        s1 = s40;
                        goto label_1404;
                    }
                    if(object18 == a0) {
                        return a0;
                    }
                    l04 = l01;
                    v64 = v4;
                    loginUser26 = loginUser24;
                    playlistId32 = playlistId30;
                    w9 = p07;
                    s43 = s40;
                    v65 = v53;
                    v66 = v49;
                    goto label_1394;
                }
                else {
                    try {
                        mutableStateFlow13 = mutableStateFlow1;
                        Throwable throwable8 = ie.p.a(object17);
                        LogU.error$default(this.l, "Fail to restore smartPlaylist. - " + (throwable8 == null ? null : throwable8.getMessage()), null, false, 6, null);
                        String s44 = throwable8 == null ? null : throwable8.getMessage();
                        kotlin.jvm.internal.q.g(("restoreSmartPlaylistFailed from:PlaylistManager-restore(), exception:" + s44), "message");
                        String s45 = "memberKey:" + s37 + "\n" + ("restoreSmartPlaylistFailed from:PlaylistManager-restore(), exception:" + s44);
                        kotlin.jvm.internal.q.f(s45, "toString(...)");
                        Reporter.createReporter(Type.PLAYLIST, LogLevel.INFO).setMessage(s45).report();
                        if(e1.u.o(s37)) {
                            f00.r = l01;
                            f00.w = s40;
                            f00.B = loginUser24;
                            f00.D = null;
                            f00.E = s37;
                            f00.G = h16;
                            f00.I = playlistId30;
                            f00.M = null;
                            f00.N = null;
                            f00.S = null;
                            f00.T = v49;
                            f00.V = v4;
                            f00.W = v53;
                            f00.Z = 36;
                            if(SmartPlaylistUseSettingPreferencesRepository.INSTANCE.updateUseSmartPlaylist(s37, false, f00) == a0) {
                                return a0;
                            }
                            l04 = l01;
                            v67 = v4;
                            loginUser27 = loginUser24;
                            s46 = s40;
                            v68 = v53;
                            v69 = v49;
                            goto label_1749;
                        }
                        else {
                            s1 = s40;
                            goto label_1755;
                        }
                    }
                    catch(Throwable throwable0) {
                        s1 = s40;
                        k8.Y.v(s1, " false", l01, false);
                        throw throwable0;
                    }
                }
                goto label_2004;
            }
            case 30: {
                v65 = f00.W;
                v64 = f00.V;
                v66 = f00.T;
                w9 = (P0)f00.M;
                playlistId32 = (PlaylistId)f00.I;
                h16 = (kotlin.jvm.internal.H)f00.G;
                s37 = f00.E;
                loginUser26 = f00.B;
                s43 = f00.w;
                l04 = f00.r;
                try {
                    n.D(object0);
                    object18 = ((ie.p)object0).d();
                    mutableStateFlow11 = mutableStateFlow0;
                }
                catch(Throwable throwable7) {
                    v4 = v64;
                    l01 = l04;
                    loginUser24 = loginUser26;
                    mutableStateFlow11 = mutableStateFlow0;
                    goto label_1401;
                }
                try {
                label_1394:
                    n.D(object18);
                    i34 = (i3)object18;
                    goto label_1411;
                }
                catch(Throwable throwable7) {
                    v4 = v64;
                    l01 = l04;
                    loginUser24 = loginUser26;
                }
            label_1401:
                v49 = v66;
                v53 = v65;
                s1 = s43;
                try {
                label_1404:
                    i34 = n.t(throwable7);
                    l04 = l01;
                    v64 = v4;
                    loginUser26 = loginUser24;
                    s43 = s1;
                    v65 = v53;
                    v66 = v49;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_1411:
                    if(ie.p.b(i34)) {
                        i34 = null;
                    }
                    if(i34 instanceof h3) {
                        String s49 = ((h3)i34).c();
                        long v73 = ((h3)i34).b();
                        f00.r = l04;
                        f00.w = s43;
                        f00.B = loginUser26;
                        f00.D = null;
                        f00.E = s37;
                        f00.G = h16;
                        f00.I = null;
                        f00.M = w9;
                        f00.N = null;
                        f00.S = null;
                        f00.T = v66;
                        f00.V = v64;
                        f00.W = v65;
                        f00.Z = 0x1F;
                        if(((P0)w9).V(s49, v73, f00) == a0) {
                            return a0;
                        }
                        v57 = v65;
                        s50 = s37;
                        s1 = s43;
                        goto label_1522;
                    }
                    else if(i34 instanceof g3) {
                        f00.r = l04;
                        f00.w = s43;
                        f00.B = loginUser26;
                        f00.D = null;
                        f00.E = s37;
                        f00.G = h16;
                        f00.I = null;
                        f00.M = w9;
                        f00.N = null;
                        f00.S = i34;
                        f00.T = v66;
                        f00.V = v64;
                        f00.W = v65;
                        f00.Z = 0x20;
                        Object object19 = w10.b(false, f00);
                        if(object19 == a0) {
                            return a0;
                        }
                        v70 = v65;
                        v71 = v64;
                        v72 = v66;
                        i35 = i34;
                        object0 = object19;
                        loginUser28 = loginUser26;
                        s47 = s37;
                        h21 = h16;
                        goto label_1553;
                    }
                    else {
                        mutableStateFlow13 = mutableStateFlow1;
                        playlistId33 = PlaylistId.SMART;
                        if(playlistId32 == playlistId33 || e.k.A(new PlaylistId[]{PlaylistId.MUSIC, PlaylistId.TEMP}).contains(playlistId32) || playlistId32.isDeprecated()) {
                            h16.a = playlistId33;
                            v57 = v65;
                            loginUser22 = loginUser26;
                            s1 = s43;
                            mutableStateFlow14 = mutableStateFlow11;
                            v4 = v64;
                            l01 = l04;
                        }
                        else {
                            try {
                                f00.r = l04;
                                f00.w = s43;
                                f00.B = loginUser26;
                                f00.D = null;
                                f00.E = s37;
                                f00.G = h16;
                                f00.I = playlistId32;
                                f00.M = w9;
                                f00.N = null;
                                f00.S = null;
                                f00.T = v66;
                                f00.V = v64;
                                f00.W = v65;
                                f00.Z = 35;
                                object0 = w10.g(playlistId32, true, f00);
                            }
                            catch(Exception unused_ex) {
                                v57 = v65;
                                h22 = h16;
                                s48 = s37;
                                loginUser29 = loginUser26;
                                s1 = s43;
                                goto label_1723;
                            }
                            if(object0 == a0) {
                                return a0;
                            }
                            v57 = v65;
                            s1 = s43;
                            l07 = l04;
                            goto label_1709;
                        }
                    }
                    goto label_2004;
                }
                catch(Throwable throwable0) {
                    s1 = s43;
                    l01 = l04;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            }
            case 0x1F: {
                v57 = f00.W;
                int v74 = f00.V;
                int v75 = f00.T;
                i3 i36 = (i3)f00.S;
                P0 p09 = (P0)f00.M;
                PlaylistId playlistId34 = (PlaylistId)f00.I;
                kotlin.jvm.internal.H h23 = (kotlin.jvm.internal.H)f00.G;
                s50 = f00.E;
                LoginUser loginUser30 = f00.B;
                String s51 = f00.w;
                L0 l08 = f00.r;
                try {
                    s1 = s51;
                    n.D(object0);
                    mutableStateFlow11 = mutableStateFlow0;
                    l04 = l08;
                    loginUser26 = loginUser30;
                    h16 = h23;
                    w9 = p09;
                    v66 = v75;
                    v64 = v74;
                    s1 = s51;
                }
                catch(Throwable throwable0) {
                    l01 = l08;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_1522:
                    playlistId33 = PlaylistId.SMART;
                    h16.a = playlistId33;
                    EventBusHelper.post(EventCurPlaylistViewFocus.INSTANCE);
                    s37 = s50;
                    loginUser22 = loginUser26;
                    mutableStateFlow13 = mutableStateFlow1;
                    mutableStateFlow14 = mutableStateFlow11;
                }
                catch(Throwable throwable0) {
                    l01 = l04;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                v4 = v64;
                l01 = l04;
                goto label_2004;
            }
            case 0x20: {
                int v76 = f00.W;
                int v77 = f00.V;
                int v78 = f00.T;
                i35 = (i3)f00.S;
                w9 = (P0)f00.M;
                PlaylistId playlistId35 = (PlaylistId)f00.I;
                kotlin.jvm.internal.H h24 = (kotlin.jvm.internal.H)f00.G;
                String s52 = f00.E;
                LoginUser loginUser31 = f00.B;
                s53 = f00.w;
                l07 = f00.r;
                try {
                    n.D(object0);
                    v70 = v76;
                    mutableStateFlow11 = mutableStateFlow0;
                    loginUser28 = loginUser31;
                    l04 = l07;
                    v71 = v77;
                    h21 = h24;
                    s43 = s53;
                    v72 = v78;
                    s47 = s52;
                }
                catch(Throwable throwable0) {
                    s1 = s53;
                    l01 = l07;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_1553:
                    DrawerPlaylistInfo drawerPlaylistInfo1 = ((g3)i35).c();
                    String s54 = ((g3)i35).b();
                    long v79 = ((g3)i35).d();
                    f00.r = l04;
                    f00.w = s43;
                    f00.B = loginUser28;
                    f00.D = null;
                    f00.E = s47;
                    f00.G = h21;
                    f00.I = null;
                    f00.M = w9;
                    f00.N = null;
                    f00.S = (nc.u0)object0;
                    f00.T = v72;
                    f00.V = v71;
                    f00.W = v70;
                    f00.Z = 33;
                    u01 = (nc.u0)object0;
                    mutableStateFlow13 = mutableStateFlow1;
                    object20 = u01.N(drawerPlaylistInfo1, s54, v79, f00);
                    if(object20 != a0) {
                        goto label_1574;
                    }
                    return a0;
                }
                catch(Throwable throwable0) {
                    s1 = s43;
                    l01 = l04;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            label_1574:
                u02 = u01;
                s55 = s47;
                s1 = s43;
                l01 = l04;
                v57 = v70;
                loginUser32 = loginUser28;
                goto label_1602;
            }
            case 33: {
                v57 = f00.W;
                int v80 = f00.V;
                int v81 = f00.T;
                u02 = (nc.u0)f00.S;
                w9 = (P0)f00.M;
                PlaylistId playlistId36 = (PlaylistId)f00.I;
                kotlin.jvm.internal.H h25 = (kotlin.jvm.internal.H)f00.G;
                s55 = f00.E;
                LoginUser loginUser33 = f00.B;
                s53 = f00.w;
                l07 = f00.r;
                try {
                    n.D(object0);
                    object20 = ((ie.p)object0).d();
                    mutableStateFlow11 = mutableStateFlow0;
                    loginUser32 = loginUser33;
                    mutableStateFlow13 = mutableStateFlow1;
                    v71 = v80;
                    h21 = h25;
                    s1 = s53;
                    v72 = v81;
                    l01 = l07;
                }
                catch(Throwable throwable0) {
                    s1 = s53;
                    l01 = l07;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_1602:
                    z2 = ie.p.c(object20);
                    if(!z2) {
                        goto label_1604;
                    }
                    goto label_1663;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_1604:
                    f00.r = l01;
                    f00.w = s1;
                    f00.B = loginUser32;
                    f00.D = null;
                    f00.E = s55;
                    f00.G = h21;
                    f00.I = null;
                    f00.M = w9;
                    f00.N = null;
                    f00.S = u02;
                    f00.T = v72;
                    f00.V = v71;
                    f00.W = v57;
                    f00.Z = 34;
                    if(u02.O(f00) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable9) {
                    goto label_1653;
                }
                s56 = s1;
                l09 = l01;
                v82 = v71;
                v83 = v72;
                h26 = h21;
                loginUser34 = loginUser32;
                goto label_1655;
            }
            case 34: {
                v57 = f00.W;
                v82 = f00.V;
                v83 = f00.T;
                u02 = (nc.u0)f00.S;
                w9 = (P0)f00.M;
                PlaylistId playlistId37 = (PlaylistId)f00.I;
                h26 = (kotlin.jvm.internal.H)f00.G;
                s55 = f00.E;
                loginUser34 = f00.B;
                s56 = f00.w;
                l09 = f00.r;
                try {
                    mutableStateFlow11 = mutableStateFlow0;
                    n.D(object0);
                    mutableStateFlow11 = mutableStateFlow0;
                    mutableStateFlow13 = mutableStateFlow1;
                    goto label_1655;
                }
                catch(Throwable throwable9) {
                    loginUser32 = loginUser34;
                    mutableStateFlow13 = mutableStateFlow1;
                    v71 = v82;
                    h21 = h26;
                    s1 = s56;
                    v72 = v83;
                    l01 = l09;
                }
                try {
                label_1653:
                    ie.o o1 = n.t(throwable9);
                    goto label_1662;
                label_1655:
                    v71 = v82;
                    loginUser32 = loginUser34;
                    s1 = s56;
                    o1 = h0;
                    h21 = h26;
                    v72 = v83;
                    l01 = l09;
                label_1662:
                    z2 = ie.p.c(o1);
                label_1663:
                    s37 = s55;
                    h16 = h21;
                    v66 = v72;
                    if(z2) {
                        playlistId33 = PlaylistId.DRAWER;
                        h16.a = playlistId33;
                        EventBusHelper.post(EventCurPlaylistViewFocus.INSTANCE);
                        w9 = u02;
                    }
                    else {
                        playlistId33 = PlaylistId.SMART;
                        h16.a = playlistId33;
                    }
                    loginUser22 = loginUser32;
                    mutableStateFlow14 = mutableStateFlow11;
                    v4 = v71;
                    goto label_2004;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            }
            case 35: {
                v57 = f00.W;
                int v84 = f00.V;
                int v85 = f00.T;
                i3 i37 = (i3)f00.S;
                P0 p010 = (P0)f00.M;
                PlaylistId playlistId38 = (PlaylistId)f00.I;
                h22 = (kotlin.jvm.internal.H)f00.G;
                s48 = f00.E;
                loginUser29 = f00.B;
                s53 = f00.w;
                l07 = f00.r;
                try {
                    w9 = p010;
                    mutableStateFlow11 = mutableStateFlow0;
                    n.D(object0);
                    v64 = v84;
                    s1 = s53;
                    loginUser26 = loginUser29;
                    s37 = s48;
                    h16 = h22;
                    playlistId32 = playlistId38;
                    w9 = p010;
                    v66 = v85;
                    mutableStateFlow11 = mutableStateFlow0;
                    mutableStateFlow13 = mutableStateFlow1;
                    goto label_1709;
                }
                catch(Exception unused_ex) {
                }
                catch(Throwable throwable0) {
                    s1 = s53;
                    l01 = l07;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                l04 = l07;
                mutableStateFlow13 = mutableStateFlow1;
                v66 = v85;
                v64 = v84;
                s1 = s53;
                goto label_1723;
                try {
                label_1709:
                    h16.a = playlistId32;
                    l01 = l07;
                    PlaylistId playlistId39 = playlistId32.isAudioType() ? playlistId32 : PlaylistId.SMART;
                    w9 = (w)object0;
                    playlistId33 = playlistId39;
                    loginUser22 = loginUser26;
                    mutableStateFlow14 = mutableStateFlow11;
                    v4 = v64;
                    l01 = l07;
                    goto label_2004;
                }
                catch(Exception unused_ex) {
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                h22 = h16;
                s48 = s37;
                loginUser29 = loginUser26;
                l04 = l07;
                try {
                label_1723:
                    playlistId33 = PlaylistId.SMART;
                    h22.a = playlistId33;
                    h16 = h22;
                    loginUser22 = loginUser29;
                    s37 = s48;
                    v4 = v64;
                    l01 = l04;
                    mutableStateFlow14 = mutableStateFlow11;
                    goto label_2004;
                }
                catch(Throwable throwable0) {
                }
                l01 = l04;
                k8.Y.v(s1, " false", l01, false);
                throw throwable0;
            }
            case 36: {
                v68 = f00.W;
                v67 = f00.V;
                v69 = f00.T;
                Throwable throwable10 = (Throwable)f00.S;
                P0 p011 = (P0)f00.M;
                playlistId30 = (PlaylistId)f00.I;
                h16 = (kotlin.jvm.internal.H)f00.G;
                s37 = f00.E;
                loginUser27 = f00.B;
                s46 = f00.w;
                l04 = f00.r;
                try {
                    n.D(object0);
                    mutableStateFlow11 = mutableStateFlow0;
                    mutableStateFlow13 = mutableStateFlow1;
                }
                catch(Throwable throwable0) {
                    s1 = s46;
                    l01 = l04;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            label_1749:
                v4 = v67;
                l01 = l04;
                loginUser24 = loginUser27;
                v49 = v69;
                v53 = v68;
                s1 = s46;
                try {
                label_1755:
                    mutableStateFlow15 = mutableStateFlow11;
                    mutableStateFlow15.setValue(oe.f.a(false));
                    if(!e.k.A(new PlaylistId[]{PlaylistId.SMART, PlaylistId.TEMP}).contains(playlistId30) && !playlistId30.isDeprecated()) {
                        try {
                            f00.r = l01;
                            f00.w = s1;
                            f00.B = loginUser24;
                            f00.D = null;
                            f00.E = s37;
                            f00.G = h16;
                            f00.I = playlistId30;
                            f00.M = null;
                            f00.N = null;
                            f00.S = null;
                            f00.T = v49;
                            f00.V = v4;
                            f00.W = v53;
                            f00.Z = 38;
                            object0 = w10.g(playlistId30, true, f00);
                            if(object0 != a0) {
                                goto label_1848;
                            }
                            return a0;
                        }
                        catch(Exception exception4) {
                            goto label_1858;
                        }
                    }
                    else {
                        mutableStateFlow14 = mutableStateFlow15;
                        f00.r = l01;
                        f00.w = s1;
                        f00.B = loginUser24;
                        f00.D = null;
                        f00.E = s37;
                        f00.G = h16;
                        f00.I = null;
                        f00.M = null;
                        f00.N = null;
                        f00.S = null;
                        f00.T = v49;
                        f00.V = v4;
                        f00.W = v53;
                        f00.Z = 37;
                        object0 = w10.g(PlaylistId.MUSIC, true, f00);
                        if(object0 == a0) {
                            return a0;
                        }
                        v57 = v53;
                        h18 = h16;
                        s36 = s37;
                        loginUser22 = loginUser24;
                        goto label_1998;
                    }
                    goto label_2004;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                goto label_1848;
            }
            case 37: {
                v57 = f00.W;
                int v86 = f00.V;
                int v87 = f00.T;
                Throwable throwable11 = (Throwable)f00.S;
                P0 p012 = (P0)f00.M;
                PlaylistId playlistId40 = (PlaylistId)f00.I;
                h18 = (kotlin.jvm.internal.H)f00.G;
                s36 = f00.E;
                loginUser22 = f00.B;
                s57 = f00.w;
                l010 = f00.r;
                try {
                    n.D(object0);
                    v4 = v86;
                    mutableStateFlow14 = mutableStateFlow0;
                    s1 = s57;
                    mutableStateFlow13 = mutableStateFlow1;
                    v49 = v87;
                    l01 = l010;
                    goto label_1998;
                }
                catch(Throwable throwable0) {
                    s1 = s57;
                    l01 = l010;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            }
            case 38: {
                int v88 = f00.W;
                int v89 = f00.V;
                int v90 = f00.T;
                Throwable throwable12 = (Throwable)f00.S;
                P0 p013 = (P0)f00.M;
                playlistId30 = (PlaylistId)f00.I;
                h16 = (kotlin.jvm.internal.H)f00.G;
                s37 = f00.E;
                LoginUser loginUser35 = f00.B;
                s46 = f00.w;
                l04 = f00.r;
                try {
                    mutableStateFlow15 = mutableStateFlow0;
                    v49 = v90;
                    v53 = v88;
                    s1 = s46;
                    n.D(object0);
                    v4 = v89;
                    l01 = l04;
                    loginUser24 = loginUser35;
                    mutableStateFlow15 = mutableStateFlow0;
                    mutableStateFlow13 = mutableStateFlow1;
                    v49 = v90;
                    v53 = v88;
                    s1 = s46;
                    goto label_1848;
                }
                catch(Exception exception4) {
                }
                catch(Throwable throwable0) {
                    s1 = s46;
                    l01 = l04;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                s36 = s37;
                loginUser22 = loginUser35;
                mutableStateFlow13 = mutableStateFlow1;
                v4 = v89;
                l01 = l04;
                goto label_1860;
                try {
                label_1848:
                    h16.a = playlistId30;
                    PlaylistId playlistId41 = playlistId30.isAudioType() ? playlistId30 : PlaylistId.MUSIC;
                    w9 = (w)object0;
                    mutableStateFlow14 = mutableStateFlow15;
                    playlistId33 = playlistId41;
                    v57 = v53;
                    v66 = v49;
                    loginUser22 = loginUser24;
                    goto label_2004;
                }
                catch(Exception exception4) {
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            label_1858:
                s36 = s37;
                loginUser22 = loginUser24;
                try {
                label_1860:
                    mutableStateFlow14 = mutableStateFlow15;
                    LogU.error$default(this.l, "Fail to restore playlist. - " + exception4.getMessage(), null, false, 6, null);
                    f00.r = l01;
                    f00.w = s1;
                    f00.B = loginUser22;
                    f00.D = null;
                    f00.E = s36;
                    f00.G = null;
                    f00.I = h16;
                    f00.M = null;
                    f00.N = null;
                    f00.S = null;
                    f00.T = v49;
                    f00.V = v4;
                    f00.W = v53;
                    f00.Z = 39;
                    object0 = w10.g(PlaylistId.MUSIC, true, f00);
                    if(object0 == a0) {
                        return a0;
                    }
                    v57 = v53;
                    h18 = h16;
                    goto label_1998;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            }
            case 39: {
                v57 = f00.W;
                int v91 = f00.V;
                int v92 = f00.T;
                P0 p014 = (P0)f00.N;
                PlaylistId playlistId42 = (PlaylistId)f00.M;
                h18 = (kotlin.jvm.internal.H)f00.I;
                w w10_1 = (w)f00.G;
                s36 = f00.E;
                loginUser22 = f00.B;
                s57 = f00.w;
                l010 = f00.r;
                try {
                    n.D(object0);
                    v4 = v91;
                    mutableStateFlow14 = mutableStateFlow0;
                    s1 = s57;
                    mutableStateFlow13 = mutableStateFlow1;
                    v49 = v92;
                    l01 = l010;
                    goto label_1998;
                }
                catch(Throwable throwable0) {
                    s1 = s57;
                    l01 = l010;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            }
            case 40: {
                v57 = f00.W;
                int v93 = f00.V;
                int v94 = f00.T;
                PlaylistId playlistId43 = (PlaylistId)f00.I;
                h18 = (kotlin.jvm.internal.H)f00.G;
                s36 = f00.E;
                loginUser22 = f00.B;
                s57 = f00.w;
                l010 = f00.r;
                try {
                    n.D(object0);
                    v4 = v93;
                    mutableStateFlow14 = mutableStateFlow0;
                    s1 = s57;
                    mutableStateFlow13 = mutableStateFlow1;
                    v49 = v94;
                    l01 = l010;
                    goto label_1998;
                }
                catch(Throwable throwable0) {
                    s1 = s57;
                    l01 = l010;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            }
            case 41: {
                int v95 = f00.W;
                int v96 = f00.V;
                int v97 = f00.T;
                playlistId27 = (PlaylistId)f00.I;
                h16 = (kotlin.jvm.internal.H)f00.G;
                s37 = f00.E;
                LoginUser loginUser36 = f00.B;
                s46 = f00.w;
                l04 = f00.r;
                try {
                    mutableStateFlow14 = mutableStateFlow0;
                    n.D(object0);
                    mutableStateFlow14 = mutableStateFlow0;
                    mutableStateFlow13 = mutableStateFlow1;
                    v49 = v97;
                    v53 = v95;
                    s1 = s46;
                    loginUser22 = loginUser36;
                    v4 = v96;
                    goto label_1946;
                }
                catch(Exception exception3) {
                }
                catch(Throwable throwable0) {
                    s1 = s46;
                    l01 = l04;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                s36 = s37;
                mutableStateFlow13 = mutableStateFlow1;
                v49 = v97;
                v53 = v95;
                s1 = s46;
                loginUser22 = loginUser36;
                v4 = v96;
                l01 = l04;
                goto label_1956;
                try {
                label_1946:
                    l01 = l04;
                    h16.a = playlistId27;
                    PlaylistId playlistId44 = playlistId27.isAudioType() ? playlistId27 : PlaylistId.MUSIC;
                    w9 = (w)object0;
                    playlistId33 = playlistId44;
                    v57 = v53;
                    v66 = v49;
                    goto label_2004;
                }
                catch(Exception exception3) {
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                s36 = s37;
                try {
                label_1956:
                    LogU.error$default(this.l, "Fail to restore playlist. - " + exception3.getMessage(), null, false, 6, null);
                    f00.r = l01;
                    f00.w = s1;
                    f00.B = loginUser22;
                    f00.D = null;
                    f00.E = s36;
                    f00.G = null;
                    f00.I = h16;
                    f00.M = null;
                    f00.N = null;
                    f00.T = v49;
                    f00.V = v4;
                    f00.W = v53;
                    f00.Z = 42;
                    object0 = w10.g(PlaylistId.MUSIC, true, f00);
                    if(object0 == a0) {
                        return a0;
                    }
                    v57 = v53;
                    h18 = h16;
                    goto label_1998;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            }
            case 42: {
                v57 = f00.W;
                int v98 = f00.V;
                int v99 = f00.T;
                Exception exception5 = (Exception)f00.N;
                PlaylistId playlistId45 = (PlaylistId)f00.M;
                h18 = (kotlin.jvm.internal.H)f00.I;
                w w11 = (w)f00.G;
                s36 = f00.E;
                loginUser22 = f00.B;
                s57 = f00.w;
                l010 = f00.r;
                try {
                    n.D(object0);
                    v4 = v98;
                    mutableStateFlow14 = mutableStateFlow0;
                    s1 = s57;
                    mutableStateFlow13 = mutableStateFlow1;
                    v49 = v99;
                    l01 = l010;
                }
                catch(Throwable throwable0) {
                    s1 = s57;
                    l01 = l010;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_1998:
                    h18.a = PlaylistId.MUSIC;
                    h16 = h18;
                    s37 = s36;
                    v66 = v49;
                    w9 = (w)object0;
                    playlistId33 = PlaylistId.MUSIC;
                label_2004:
                    if(w9 instanceof y) {
                        F2 f22 = b0.n();
                        f00.r = l01;
                        f00.w = s1;
                        f00.B = loginUser22;
                        f00.D = null;
                        f00.E = s37;
                        f00.G = (y)w9;
                        f00.I = w9;
                        f00.M = h16;
                        f00.N = playlistId33;
                        f00.S = null;
                        f00.T = v66;
                        f00.V = v4;
                        f00.W = v57;
                        f00.Z = 43;
                        Object object21 = FlowKt.first(f22, f00);
                        if(object21 == a0) {
                            return a0;
                        }
                        playlistId46 = playlistId33;
                        object0 = object21;
                        loginUser37 = loginUser22;
                        w12 = w9;
                        h27 = h16;
                        y1 = (y)w9;
                        goto label_2050;
                    }
                    goto label_2096;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            }
            case 43: {
                v57 = f00.W;
                int v100 = f00.V;
                int v101 = f00.T;
                PlaylistId playlistId47 = (PlaylistId)f00.S;
                PlaylistId playlistId48 = f00.N;
                h27 = (kotlin.jvm.internal.H)f00.M;
                w12 = (w)f00.I;
                y1 = (y)f00.G;
                s37 = f00.E;
                LoginUser loginUser38 = f00.B;
                s46 = f00.w;
                l04 = f00.r;
                try {
                    n.D(object0);
                    mutableStateFlow14 = mutableStateFlow0;
                    loginUser37 = loginUser38;
                    mutableStateFlow13 = mutableStateFlow1;
                    v4 = v100;
                    s1 = s46;
                    playlistId46 = playlistId48;
                    v66 = v101;
                    l01 = l04;
                }
                catch(Throwable throwable0) {
                    s1 = s46;
                    l01 = l04;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_2050:
                    f00.r = l01;
                    f00.w = s1;
                    f00.B = loginUser37;
                    f00.D = null;
                    f00.E = s37;
                    f00.G = w12;
                    f00.I = h27;
                    f00.M = playlistId46;
                    f00.N = null;
                    f00.S = null;
                    f00.T = v66;
                    f00.V = v4;
                    f00.W = v57;
                    f00.Z = 44;
                    if(y1.o(((oc.M)object0), f00) == a0) {
                        return a0;
                    }
                    s53 = s1;
                    v102 = v4;
                    l011 = l01;
                    v103 = v66;
                    s58 = s37;
                    playlistId49 = playlistId46;
                    loginUser39 = loginUser37;
                    goto label_2087;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            }
            case 44: {
                v57 = f00.W;
                v102 = f00.V;
                v103 = f00.T;
                playlistId49 = (PlaylistId)f00.M;
                h27 = (kotlin.jvm.internal.H)f00.I;
                w12 = (w)f00.G;
                s58 = f00.E;
                loginUser39 = f00.B;
                s53 = f00.w;
                l07 = f00.r;
                try {
                    n.D(object0);
                    mutableStateFlow14 = mutableStateFlow0;
                    l011 = l07;
                    mutableStateFlow13 = mutableStateFlow1;
                }
                catch(Throwable throwable0) {
                    s1 = s53;
                    l01 = l07;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_2087:
                    l01 = l011;
                    playlistId33 = playlistId49;
                    v66 = v103;
                    v4 = v102;
                    s1 = s53;
                    h16 = h27;
                    w9 = w12;
                    loginUser22 = loginUser39;
                    s37 = s58;
                label_2096:
                    if(w9 instanceof A) {
                        F2 f23 = b0.o();
                        f00.r = l01;
                        f00.w = s1;
                        f00.B = loginUser22;
                        f00.D = null;
                        f00.E = s37;
                        f00.G = (A)w9;
                        f00.I = w9;
                        f00.M = h16;
                        f00.N = playlistId33;
                        f00.S = null;
                        f00.T = v66;
                        f00.V = v4;
                        f00.W = v57;
                        f00.Z = 45;
                        Object object22 = FlowKt.first(f23, f00);
                        if(object22 == a0) {
                            return a0;
                        }
                        playlistId50 = playlistId33;
                        object0 = object22;
                        loginUser40 = loginUser22;
                        w13 = w9;
                        h28 = h16;
                        a2 = (A)w9;
                        goto label_2147;
                    }
                    goto label_2193;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            }
            case 45: {
                v57 = f00.W;
                int v104 = f00.V;
                int v105 = f00.T;
                PlaylistId playlistId51 = (PlaylistId)f00.S;
                PlaylistId playlistId52 = f00.N;
                h28 = (kotlin.jvm.internal.H)f00.M;
                w13 = (w)f00.I;
                a2 = (A)f00.G;
                s37 = f00.E;
                LoginUser loginUser41 = f00.B;
                s46 = f00.w;
                l04 = f00.r;
                try {
                    n.D(object0);
                    mutableStateFlow14 = mutableStateFlow0;
                    loginUser40 = loginUser41;
                    mutableStateFlow13 = mutableStateFlow1;
                    v4 = v104;
                    s1 = s46;
                    playlistId50 = playlistId52;
                    v66 = v105;
                    l01 = l04;
                }
                catch(Throwable throwable0) {
                    s1 = s46;
                    l01 = l04;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_2147:
                    f00.r = l01;
                    f00.w = s1;
                    f00.B = loginUser40;
                    f00.D = null;
                    f00.E = s37;
                    f00.G = w13;
                    f00.I = h28;
                    f00.M = playlistId50;
                    f00.N = null;
                    f00.S = null;
                    f00.T = v66;
                    f00.V = v4;
                    f00.W = v57;
                    f00.Z = 46;
                    if(a2.m(((Boolean)object0).booleanValue(), f00) == a0) {
                        return a0;
                    }
                    s53 = s1;
                    v106 = v4;
                    l012 = l01;
                    v107 = v66;
                    s59 = s37;
                    playlistId53 = playlistId50;
                    loginUser42 = loginUser40;
                    goto label_2184;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            }
            case 46: {
                v57 = f00.W;
                v106 = f00.V;
                v107 = f00.T;
                playlistId53 = (PlaylistId)f00.M;
                h28 = (kotlin.jvm.internal.H)f00.I;
                w13 = (w)f00.G;
                s59 = f00.E;
                loginUser42 = f00.B;
                s53 = f00.w;
                l07 = f00.r;
                try {
                    n.D(object0);
                    mutableStateFlow14 = mutableStateFlow0;
                    l012 = l07;
                    mutableStateFlow13 = mutableStateFlow1;
                }
                catch(Throwable throwable0) {
                    s1 = s53;
                    l01 = l07;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_2184:
                    l01 = l012;
                    playlistId33 = playlistId53;
                    v66 = v107;
                    v4 = v106;
                    s1 = s53;
                    h16 = h28;
                    w9 = w13;
                    loginUser22 = loginUser42;
                    s37 = s59;
                label_2193:
                    if(w9 instanceof oc.J) {
                        ((oc.J)w9).j(new ea.d(this, h16));
                    }
                    mutableStateFlow2.setValue(h16.a);
                    mutableStateFlow13.setValue(playlistId33);
                    e1 = this.t;
                    if(e1 != null) {
                        playlistId54 = (PlaylistId)h16.a;
                        f00.r = l01;
                        f00.w = s1;
                        f00.B = loginUser22;
                        f00.D = null;
                        f00.E = s37;
                        f00.G = e1;
                        f00.I = playlistId54;
                        f00.M = w9;
                        f00.N = null;
                        f00.S = null;
                        f00.T = v66;
                        f00.V = v4;
                        f00.W = v57;
                        f00.Z = 0x2F;
                        object23 = w9.b(f00);
                        if(object23 != a0) {
                            goto label_2216;
                        }
                        return a0;
                    }
                    goto label_2288;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            label_2216:
                e2 = e1;
                object0 = object23;
                playlistId55 = playlistId54;
                l013 = l01;
                v108 = v66;
                w14 = w9;
                s53 = s1;
                v109 = v4;
                s60 = s37;
                goto label_2253;
            }
            case 0x2F: {
                v57 = f00.W;
                v109 = f00.V;
                v108 = f00.T;
                PlaylistId playlistId56 = (PlaylistId)f00.S;
                kotlin.jvm.internal.H h29 = (kotlin.jvm.internal.H)f00.N;
                w14 = (w)f00.M;
                playlistId55 = (PlaylistId)f00.I;
                e e3 = (e)f00.G;
                s60 = f00.E;
                LoginUser loginUser43 = f00.B;
                s53 = f00.w;
                l07 = f00.r;
                try {
                    n.D(object0);
                    l013 = l07;
                    mutableStateFlow14 = mutableStateFlow0;
                    e2 = e3;
                    loginUser22 = loginUser43;
                }
                catch(Throwable throwable0) {
                    s1 = s53;
                    l01 = l07;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_2253:
                    long v110 = w14.k();
                    f00.r = l013;
                    f00.w = s53;
                    f00.B = loginUser22;
                    f00.D = null;
                    f00.E = s60;
                    f00.G = null;
                    f00.I = null;
                    f00.M = null;
                    f00.N = null;
                    f00.S = null;
                    f00.T = v108;
                    f00.V = v109;
                    f00.W = v57;
                    f00.Z = 0x30;
                    if(((Vb.d0)e2).c(playlistId55, ((oc.Q)object0), v110, f00) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    l01 = l013;
                    s1 = s53;
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                l01 = l013;
                s61 = s60;
                s1 = s53;
                goto label_2287;
            }
            case 0x30: {
                PlaylistId playlistId57 = (PlaylistId)f00.M;
                kotlin.jvm.internal.H h30 = (kotlin.jvm.internal.H)f00.I;
                w w15 = (w)f00.G;
                s61 = f00.E;
                s1 = f00.w;
                l01 = f00.r;
                try {
                    n.D(object0);
                    mutableStateFlow14 = mutableStateFlow0;
                label_2287:
                    s37 = s61;
                label_2288:
                    if(e1.u.o("")) {
                        boolean z3 = kotlin.jvm.internal.q.b(mutableStateFlow14.getValue(), oe.f.a(true));
                        SmartPlaylistLog.INSTANCE.sendSpStatisticsAsync("restore", s37, z3);
                    }
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                k8.Y.v(s1, " false", l01, false);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.f0();
        this.e0();
        return h0;
    }

    public final Object a0(PlaylistId playlistId0, boolean z, oe.c c0) {
        oc.i0 i00;
        boolean z1;
        PlaylistId playlistId1;
        O0 o00;
        if(c0 instanceof O0) {
            o00 = (O0)c0;
            int v = o00.G;
            if((v & 0x80000000) == 0) {
                o00 = new O0(this, c0);
            }
            else {
                o00.G = v ^ 0x80000000;
            }
        }
        else {
            o00 = new O0(this, c0);
        }
        Object object0 = o00.D;
        ne.a a0 = ne.a.a;
        switch(o00.G) {
            case 0: {
                n.D(object0);
                o00.r = playlistId0;
                o00.B = z;
                o00.G = 1;
                object0 = this.G(playlistId0, o00);
                if(object0 == a0) {
                    return a0;
                }
                goto label_26;
            }
            case 1: {
                z = o00.B;
                playlistId0 = o00.r;
                n.D(object0);
            label_26:
                if(((w)object0) instanceof x) {
                    o00.r = playlistId0;
                    o00.B = z;
                    o00.G = 2;
                    object0 = ((x)(((w)object0))).w(z, o00);
                    if(object0 == a0) {
                        return a0;
                    }
                    playlistId1 = playlistId0;
                    z1 = z;
                    i00 = (oc.i0)object0;
                    z = z1;
                    playlistId0 = playlistId1;
                    break;
                }
                else {
                    LogU.error$default(this.l, "setOfflineMode failed. - not offline playlist " + playlistId0, null, false, 6, null);
                    i00 = new g0("not offline playlist " + playlistId0);
                }
                break;
            }
            case 2: {
                z1 = o00.B;
                playlistId1 = o00.r;
                n.D(object0);
                i00 = (oc.i0)object0;
                z = z1;
                playlistId0 = playlistId1;
                break;
            }
            case 3: {
                oc.h0 h00 = o00.w;
                n.D(object0);
                return h00;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(i00 instanceof oc.h0) {
            kc.P0 p00 = new kc.P0(this, i00, null);
            o00.r = null;
            o00.w = (oc.h0)i00;
            o00.B = z;
            o00.G = 3;
            if(this.p(playlistId0, p00, o00) == a0) {
                return a0;
            }
        }
        return i00;
    }

    public static final Object b(b b0, PlaylistId playlistId0, oe.c c0) {
        PlaylistId playlistId2;
        PlaylistId playlistId1;
        kc.n n0;
        b0.getClass();
        if(c0 instanceof kc.n) {
            n0 = (kc.n)c0;
            int v = n0.E;
            if((v & 0x80000000) == 0) {
                n0 = new kc.n(b0, c0);
            }
            else {
                n0.E = v ^ 0x80000000;
            }
        }
        else {
            n0 = new kc.n(b0, c0);
        }
        Enum enum0 = n0.B;
        ne.a a0 = ne.a.a;
        switch(n0.E) {
            case 0: {
                n.D(enum0);
                n0.r = playlistId0;
                n0.E = 1;
                enum0 = b0.s(n0);
                if(enum0 == a0) {
                    return a0;
                }
                goto label_24;
            }
            case 1: {
                playlistId0 = n0.r;
                n.D(enum0);
            label_24:
                n0.r = playlistId0;
                n0.w = (PlaylistId)enum0;
                n0.E = 2;
                Object object0 = b0.F(n0);
                if(object0 == a0) {
                    return a0;
                }
                playlistId1 = playlistId0;
                playlistId2 = (PlaylistId)enum0;
                enum0 = object0;
                break;
            }
            case 2: {
                PlaylistId playlistId3 = n0.w;
                PlaylistId playlistId4 = n0.r;
                n.D(enum0);
                playlistId2 = playlistId3;
                playlistId1 = playlistId4;
                break;
            }
            case 3: {
                n.D(enum0);
                return enum0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        kc.q q0 = new kc.q(playlistId1, playlistId2, ((w)enum0), b0, null);
        n0.r = null;
        n0.w = null;
        n0.E = 3;
        Object object1 = BuildersKt.withContext(NonCancellable.INSTANCE, q0, n0);
        return object1 == a0 ? a0 : object1;
    }

    public final Object b0(List list0, oe.c c0) {
        PlaylistId playlistId1;
        PlaylistId playlistId3;
        l0 l00;
        PlaylistId playlistId2;
        List list2;
        w w1;
        Mutex mutex1;
        List list1;
        Q0 q00;
        if(c0 instanceof Q0) {
            q00 = (Q0)c0;
            int v = q00.I;
            if((v & 0x80000000) == 0) {
                q00 = new Q0(this, c0);
            }
            else {
                q00.I = v ^ 0x80000000;
            }
        }
        else {
            q00 = new Q0(this, c0);
        }
        Object object0 = q00.E;
        ne.a a0 = ne.a.a;
        switch(q00.I) {
            case 0: {
                n.D(object0);
                q00.r = list0;
                q00.I = 1;
                if(this.X("setSelectRepeat", q00) == a0) {
                    return a0;
                }
                goto label_24;
            }
            case 1: {
                list0 = q00.r;
                n.D(object0);
            label_24:
                q00.r = list0;
                Mutex mutex0 = this.s;
                q00.w = mutex0;
                q00.I = 2;
                if(mutex0.lock(null, q00) == a0) {
                    return a0;
                }
                list1 = list0;
                mutex1 = mutex0;
                goto label_35;
            }
            case 2: {
                mutex1 = (Mutex)q00.w;
                list1 = q00.r;
                n.D(object0);
            label_35:
                try {
                    playlistId1 = (PlaylistId)this.p.getValue();
                }
                finally {
                    mutex1.unlock(null);
                }
                LogU logU0 = this.l;
                if(playlistId1 == null) {
                    MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "setSelectRepeat() - currentPlaylistId is null");
                    return new oc.j0();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                w w0 = this.H(playlistId1);
                if(w0 == null) {
                    MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "setSelectRepeat() - playlist is null");
                    return new oc.j0();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                if(w0 instanceof oc.z) {
                    q00.r = list1;
                    q00.w = playlistId1;
                    q00.B = w0;
                    q00.I = 3;
                    M0 m00 = new M0(this, oc.M.a, null);
                    if(BuildersKt.withContext(NonCancellable.INSTANCE, m00, q00) == a0) {
                        return a0;
                    }
                    w1 = w0;
                    list2 = list1;
                    playlistId2 = playlistId1;
                    goto label_67;
                }
                else {
                    kotlin.jvm.internal.q.g(("not select repeat playlist " + playlistId1), "reason");
                    l00 = new oc.j0();  // 初始化器: Ljava/lang/Object;-><init>()V
                    playlistId3 = playlistId1;
                }
                goto label_89;
            }
            case 3: {
                w1 = q00.B;
                playlistId2 = (PlaylistId)q00.w;
                list2 = q00.r;
                n.D(object0);
            label_67:
                q00.r = list2;
                q00.w = playlistId2;
                q00.B = w1;
                q00.I = 4;
                N0 n00 = new N0(this, false, null);
                if(BuildersKt.withContext(NonCancellable.INSTANCE, n00, q00) == a0) {
                    return a0;
                }
                goto label_78;
            }
            case 4: {
                w1 = q00.B;
                playlistId2 = (PlaylistId)q00.w;
                list2 = q00.r;
                n.D(object0);
            label_78:
                q00.r = null;
                q00.w = playlistId2;
                q00.B = null;
                q00.I = 5;
                object0 = ((oc.z)w1).c(list2, q00);
                if(object0 == a0) {
                    return a0;
                }
                playlistId3 = playlistId2;
                goto label_88;
            }
            case 5: {
                break;
            }
            case 6: {
                oc.k0 k00 = q00.D;
                PlaylistId playlistId0 = (PlaylistId)q00.w;
                n.D(object0);
                return k00;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        playlistId3 = (PlaylistId)q00.w;
        n.D(object0);
    label_88:
        l00 = (l0)object0;
    label_89:
        if(l00 instanceof oc.k0) {
            R0 r00 = new R0(this, l00, null);
            q00.r = null;
            q00.w = null;
            q00.B = null;
            q00.D = (oc.k0)l00;
            q00.I = 6;
            if(this.p(playlistId3, r00, q00) == a0) {
                return a0;
            }
        }
        return l00;
    }

    public final Object c0(boolean z, boolean z1, oe.c c0) {
        String s2;
        boolean z7;
        boolean z6;
        boolean z3;
        boolean z2;
        S0 s00;
        if(c0 instanceof S0) {
            s00 = (S0)c0;
            int v = s00.I;
            if((v & 0x80000000) == 0) {
                s00 = new S0(this, c0);
            }
            else {
                s00.I = v ^ 0x80000000;
            }
        }
        else {
            s00 = new S0(this, c0);
        }
        Object object0 = s00.E;
        ne.a a0 = ne.a.a;
        switch(s00.I) {
            case 0: {
                n.D(object0);
                s00.r = z;
                s00.w = z1;
                s00.I = 1;
                if(this.X("setSmartPlaylistUseByUserAction", s00) == a0) {
                    return a0;
                }
                z2 = z1;
                z3 = z;
                goto label_29;
            }
            case 1: {
                boolean z4 = s00.w;
                boolean z5 = s00.r;
                n.D(object0);
                z2 = z4;
                z3 = z5;
            label_29:
                String s = e1.u.v(((e0)this.g).j());
                if(!e1.u.o(s)) {
                    LogU.error$default(this.l, "setSmartPlaylistUseByUserAction() - invalid memberKey", null, false, 6, null);
                    return new Failure("invalid memberKey");
                }
                kotlin.jvm.internal.q.g(("setSmartPlaylistUseByUserAction isUse:" + z3), "message");
                String s1 = "memberKey:" + s + "\n" + ("setSmartPlaylistUseByUserAction isUse:" + z3);
                kotlin.jvm.internal.q.f(s1, "toString(...)");
                Reporter.createReporter(Type.PLAYLIST, LogLevel.INFO).setMessage(s1).report();
                com.melon.playlist.a a1 = new com.melon.playlist.a(this, z3, s, z2, new C(), null);  // 初始化器: Ljava/lang/Object;-><init>()V
                s00.B = s;
                s00.r = z3;
                s00.w = z2;
                s00.I = 2;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, a1, s00);
                if(object0 == a0) {
                    return a0;
                }
                z6 = z3;
                z7 = z2;
                s2 = s;
                break;
            }
            case 2: {
                z7 = s00.w;
                z6 = s00.r;
                s2 = s00.B;
                n.D(object0);
                break;
            }
            case 3: {
                Object object1 = s00.D;
                n.D(object0);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        SetSmartPlaylistUseResult setSmartPlaylistUseResult0 = (SetSmartPlaylistUseResult)object0;
        boolean z8 = kotlin.jvm.internal.q.b(this.r.getValue(), Boolean.TRUE);
        SmartPlaylistLog.INSTANCE.sendSpStatisticsAsync("setSpOnByUserAction", s2, z8);
        s00.B = null;
        s00.D = object0;
        s00.r = z6;
        s00.w = z7;
        s00.I = 3;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new kc.v(this, null), 3, null);
        return ie.H.a == a0 ? a0 : object0;
    }

    public final Object d0(PlaylistId playlistId0, oc.y0 y00, oe.c c0) {
        o0 o00;
        U0 u00;
        if(c0 instanceof U0) {
            u00 = (U0)c0;
            int v = u00.G;
            if((v & 0x80000000) == 0) {
                u00 = new U0(this, c0);
            }
            else {
                u00.G = v ^ 0x80000000;
            }
        }
        else {
            u00 = new U0(this, c0);
        }
        Object object0 = u00.D;
        ne.a a0 = ne.a.a;
        switch(u00.G) {
            case 0: {
                n.D(object0);
                u00.r = playlistId0;
                u00.w = y00;
                u00.G = 1;
                object0 = this.G(playlistId0, u00);
                if(object0 == a0) {
                    return a0;
                }
                goto label_26;
            }
            case 1: {
                y00 = u00.w;
                playlistId0 = u00.r;
                n.D(object0);
            label_26:
                if(((w)object0) instanceof B) {
                    u00.r = playlistId0;
                    u00.w = null;
                    u00.G = 2;
                    object0 = ((B)(((w)object0))).s(y00, u00);
                    if(object0 == a0) {
                        return a0;
                    }
                    o00 = (o0)object0;
                }
                else {
                    kotlin.jvm.internal.q.g(("not sortable playlist " + playlistId0), "reason");
                    o00 = new m0();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                break;
            }
            case 2: {
                playlistId0 = u00.r;
                n.D(object0);
                o00 = (o0)object0;
                break;
            }
            case 3: {
                n0 n00 = u00.B;
                n.D(object0);
                return n00;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(o00 instanceof n0) {
            V0 v00 = new V0(this, o00, null);
            u00.r = null;
            u00.w = null;
            u00.B = (n0)o00;
            u00.G = 3;
            if(this.p(playlistId0, v00, u00) == a0) {
                return a0;
            }
        }
        return o00;
    }

    public final void e0() {
        LogU.debug$default(this.l, "startContentInfoUpdater()", null, false, 6, null);
        W0 w00 = new W0(this, null);
        BuildersKt__Builders_commonKt.launch$default(this.m, null, null, w00, 3, null);
    }

    public final void f0() {
        LogU.debug$default(this.l, "startObserveNetworkConnection()", null, false, 6, null);
        Z0 z00 = new Z0(this, null);
        BuildersKt__Builders_commonKt.launch$default(this.m, null, null, z00, 3, null);
    }

    public final Object g0(PlaylistId playlistId0, Playable playable0, int v, boolean z, oe.c c0) {
        g1 g10;
        if(c0 instanceof g1) {
            g10 = (g1)c0;
            int v1 = g10.G;
            if((v1 & 0x80000000) == 0) {
                g10 = new g1(this, c0);
            }
            else {
                g10.G = v1 ^ 0x80000000;
            }
        }
        else {
            g10 = new g1(this, c0);
        }
        Object object0 = g10.D;
        ne.a a0 = ne.a.a;
        switch(g10.G) {
            case 0: {
                n.D(object0);
                if(playable0.getLikeCount() != v || playable0.isLiked() != z) {
                    h1 h10 = new h1(v, playable0, null, z);
                    g10.r = playable0;
                    g10.w = v;
                    g10.B = z;
                    g10.G = 1;
                    if(this.i0(playlistId0, "updateLikeInfo", false, false, h10, g10) == a0) {
                        return a0;
                    }
                    goto label_26;
                }
                break;
            }
            case 1: {
                z = g10.B;
                v = g10.w;
                playable0 = g10.r;
                n.D(object0);
            label_26:
                Intent intent0 = new Intent();
                Q1.c.Y(intent0, "android.appwidget.action.APPWIDGET_UPDATE", false);
                intent0.putExtra("com.iloen.melon.intent.action", "com.iloen.melon.response_like_content");
                this.a.sendBroadcast(intent0);
                StringBuilder stringBuilder0 = androidx.appcompat.app.o.u(v, "updateLikeInfo and sendBroadCast trackId=", playable0.getTrackId(), ", likeCount=", ", isLiked=");
                stringBuilder0.append(z);
                LogU.debug$default(this.l, stringBuilder0.toString(), null, false, 6, null);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return ie.H.a;
    }

    public final Object h0(PlaylistId playlistId0, Playable playable0, oe.c c0) {
        Playable playable1;
        kc.d d0;
        Object object1;
        f1 f10;
        if(c0 instanceof f1) {
            f10 = (f1)c0;
            int v = f10.G;
            if((v & 0x80000000) == 0) {
                f10 = new f1(this, c0);
            }
            else {
                f10.G = v ^ 0x80000000;
            }
        }
        else {
            f10 = new f1(this, c0);
        }
        Object object0 = f10.D;
        ne.a a0 = ne.a.a;
        switch(f10.G) {
            case 0: {
                n.D(object0);
                f10.r = playlistId0;
                f10.w = playable0;
                f10.G = 1;
                object1 = ((L1)this.d).b(playable0, f10);
                if(object1 == a0) {
                    return a0;
                }
                goto label_24;
            }
            case 1: {
                playable0 = f10.w;
                playlistId0 = f10.r;
                n.D(object0);
                object1 = ((ie.p)object0).a;
            label_24:
                if(object1 instanceof ie.o) {
                    object1 = null;
                }
                if(((kc.d)object1) != null) {
                    f10.r = null;
                    f10.w = playable0;
                    f10.B = (kc.d)object1;
                    f10.G = 2;
                    if(this.g0(playlistId0, playable0, ((kc.d)object1).a, ((kc.d)object1).b, f10) == a0) {
                        return a0;
                    }
                    d0 = (kc.d)object1;
                    playable1 = playable0;
                    LogU.debug$default(this.l, "updateLikeInfo fetchFromServer trackId=" + playable1.getTrackId() + ", " + d0, null, false, 6, null);
                    return ie.H.a;
                }
                return ie.H.a;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d0 = f10.B;
        playable1 = f10.w;
        n.D(object0);
        LogU.debug$default(this.l, "updateLikeInfo fetchFromServer trackId=" + playable1.getTrackId() + ", " + d0, null, false, 6, null);
        return ie.H.a;
    }

    public final Object i0(PlaylistId playlistId0, String s, boolean z, boolean z1, we.n n0, oe.c c0) {
        boolean z3;
        PlaylistId playlistId1;
        boolean z2;
        i1 i10;
        if(c0 instanceof i1) {
            i10 = (i1)c0;
            int v = i10.N;
            if((v & 0x80000000) == 0) {
                i10 = new i1(this, c0);
            }
            else {
                i10.N = v ^ 0x80000000;
            }
        }
        else {
            i10 = new i1(this, c0);
        }
        Object object0 = i10.I;
        ne.a a0 = ne.a.a;
        switch(i10.N) {
            case 0: {
                n.D(object0);
                i10.r = playlistId0;
                i10.w = s;
                i10.B = (oe.i)n0;
                i10.E = z;
                i10.G = z1;
                i10.N = 1;
                object0 = this.G(playlistId0, i10);
                if(object0 == a0) {
                    return a0;
                }
                goto label_32;
            }
            case 1: {
                z1 = i10.G;
                z = i10.E;
                n0 = (we.n)i10.B;
                s = i10.w;
                playlistId0 = i10.r;
                n.D(object0);
            label_32:
                i10.r = playlistId0;
                i10.w = null;
                i10.B = null;
                i10.E = z;
                i10.G = z1;
                i10.N = 2;
                object0 = ((w)object0).h(s, z, n0, i10);
                if(object0 == a0) {
                    return a0;
                }
                z2 = z;
                playlistId1 = playlistId0;
                z3 = z1;
                break;
            }
            case 2: {
                z3 = i10.G;
                z2 = i10.E;
                playlistId1 = i10.r;
                n.D(object0);
                break;
            }
            case 3: {
                Object object1 = i10.D;
                n.D(object0);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((oc.B0)object0) instanceof oc.A0) {
            j1 j10 = new j1(this, ((oc.B0)object0), z3, null);
            i10.r = null;
            i10.w = null;
            i10.B = null;
            i10.D = object0;
            i10.E = z2;
            i10.G = z3;
            i10.N = 3;
            if(this.p(playlistId1, j10, i10) == a0) {
                return a0;
            }
        }
        return object0;
    }

    public static final Object j(b b0, boolean z, boolean z1, oe.c c0) {
        w w0;
        Playable playable0;
        boolean z3;
        boolean z2;
        boolean z7;
        boolean z6;
        Playable playable1;
        kc.o0 o00;
        b0.getClass();
        if(c0 instanceof kc.o0) {
            o00 = (kc.o0)c0;
            int v = o00.I;
            if((v & 0x80000000) == 0) {
                o00 = new kc.o0(b0, c0);
            }
            else {
                o00.I = v ^ 0x80000000;
            }
        }
        else {
            o00 = new kc.o0(b0, c0);
        }
        Object object0 = o00.E;
        ne.a a0 = ne.a.a;
        ie.H h0 = ie.H.a;
        switch(o00.I) {
            case 0: {
                n.D(object0);
                LogU.debug$default(b0.l, "onLoginStateChanged() - newIsLogin:" + z + ", isPlayingNow:" + z1, null, false, 6, null);
                o00.r = z;
                o00.w = z1;
                o00.I = 1;
                if(b0.X("onLoginStateChanged", o00) != a0) {
                label_41:
                    s0 s00 = new s0(z, b0, z1, null);
                    o00.r = z;
                    o00.w = z1;
                    o00.I = 2;
                    if(BuildersKt.withContext(NonCancellable.INSTANCE, s00, o00) != a0) {
                        z7 = z;
                        z6 = z1;
                    label_48:
                        w w1 = b0.u();
                        if(w1 == null) {
                            playable1 = null;
                        }
                        else {
                            oc.Q q0 = w1.getState();
                            playable1 = q0 == null ? null : e1.b.y(q0);
                        }
                        if(playable1 == null) {
                            return h0;
                        }
                        if(z7 || !playable1.isAdult() || kotlin.jvm.internal.q.b(playable1.getLyricType(), "0")) {
                        label_75:
                            PlaylistId playlistId1 = w1.getId();
                            o00.B = null;
                            o00.D = null;
                            o00.r = z7;
                            o00.w = z6;
                            o00.I = 4;
                            if(b0.h0(playlistId1, playable1, o00) != a0) {
                                return h0;
                            }
                        }
                        else {
                            PlaylistId playlistId0 = w1.getId();
                            t0 t00 = new t0(playable1, null);
                            o00.B = w1;
                            o00.D = playable1;
                            o00.r = false;
                            o00.w = z6;
                            o00.I = 3;
                            if(b0.i0(playlistId0, "onLoginStateChanged_current19", false, false, t00, o00) != a0) {
                                z2 = z6;
                                z3 = false;
                                w0 = w1;
                                playable0 = playable1;
                            label_71:
                                z6 = z2;
                                z7 = z3;
                                playable1 = playable0;
                                w1 = w0;
                                goto label_75;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                boolean z8 = o00.w;
                boolean z9 = o00.r;
                n.D(object0);
                z1 = z8;
                z = z9;
                goto label_41;
            }
            case 2: {
                boolean z4 = o00.w;
                boolean z5 = o00.r;
                n.D(object0);
                z6 = z4;
                z7 = z5;
                goto label_48;
            }
            case 3: {
                z2 = o00.w;
                z3 = o00.r;
                playable0 = o00.D;
                w0 = o00.B;
                n.D(object0);
                goto label_71;
            }
            case 4: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final Object j0(oe.c c0) {
        Iterator iterator1;
        int v1;
        Iterator iterator0;
        ArrayList arrayList0;
        k1 k10;
        if(c0 instanceof k1) {
            k10 = (k1)c0;
            int v = k10.E;
            if((v & 0x80000000) == 0) {
                k10 = new k1(this, c0);
            }
            else {
                k10.E = v ^ 0x80000000;
            }
        }
        else {
            k10 = new k1(this, c0);
        }
        Object object0 = k10.B;
        ne.a a0 = ne.a.a;
    alab1:
        switch(k10.E) {
            case 0: {
                n.D(object0);
                k10.E = 1;
                object0 = this.b.a(k10);
                if(object0 != a0) {
                    arrayList0 = new ArrayList();
                    iterator0 = ((Iterable)object0).iterator();
                    goto label_23;
                }
                break;
            }
            case 1: {
                n.D(object0);
                arrayList0 = new ArrayList();
                iterator0 = ((Iterable)object0).iterator();
            label_23:
                while(iterator0.hasNext()) {
                    Object object1 = iterator0.next();
                    if(object1 instanceof LocalDownloadablePlaylist) {
                        arrayList0.add(object1);
                    }
                }
                v1 = 0;
                iterator1 = arrayList0.iterator();
                goto label_34;
            }
            case 2: {
                v1 = k10.w;
                iterator1 = k10.r;
                n.D(object0);
                while(true) {
                label_34:
                    if(!iterator1.hasNext()) {
                        return ie.H.a;
                    }
                    Object object2 = iterator1.next();
                    k10.r = iterator1;
                    k10.w = v1;
                    k10.E = 2;
                    if(((LocalDownloadablePlaylist)object2).updateSolMetaDataBase(k10) == a0) {
                        break alab1;
                    }
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final Object k(PlaylistId playlistId0, oc.V v0, oe.c c0) {
        j j0;
        if(c0 instanceof j) {
            j0 = (j)c0;
            int v1 = j0.G;
            if((v1 & 0x80000000) == 0) {
                j0 = new j(this, c0);
            }
            else {
                j0.G = v1 ^ 0x80000000;
            }
        }
        else {
            j0 = new j(this, c0);
        }
        Object object0 = j0.D;
        ne.a a0 = ne.a.a;
        switch(j0.G) {
            case 0: {
                n.D(object0);
                j0.r = playlistId0;
                j0.w = v0;
                j0.G = 1;
                object0 = this.G(playlistId0, j0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_26;
            }
            case 1: {
                v0 = j0.w;
                playlistId0 = j0.r;
                n.D(object0);
            label_26:
                j0.r = playlistId0;
                j0.w = null;
                j0.G = 2;
                object0 = ((w)object0).u(v0, j0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                playlistId0 = j0.r;
                n.D(object0);
                break;
            }
            case 3: {
                Object object1 = j0.B;
                n.D(object0);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((oc.b0)object0) instanceof oc.a0) {
            kc.k k0 = new kc.k(this, ((oc.b0)object0), null);
            j0.r = null;
            j0.w = null;
            j0.B = object0;
            j0.G = 3;
            if(this.p(playlistId0, k0, j0) == a0) {
                return a0;
            }
        }
        return object0;
    }

    public final Object k0(PlaylistId playlistId0, ArrayList arrayList0, oe.c c0) {
        List list0;
        Serializable serializable0;
        l1 l10;
        if(c0 instanceof l1) {
            l10 = (l1)c0;
            int v = l10.G;
            if((v & 0x80000000) == 0) {
                l10 = new l1(this, c0);
            }
            else {
                l10.G = v ^ 0x80000000;
            }
        }
        else {
            l10 = new l1(this, c0);
        }
        Object object0 = l10.D;
        ne.a a0 = ne.a.a;
        switch(l10.G) {
            case 0: {
                n.D(object0);
                l10.r = playlistId0;
                l10.w = arrayList0;
                l10.G = 1;
                serializable0 = ((L1)this.d).c(arrayList0, l10);
                if(serializable0 == a0) {
                    return a0;
                }
                goto label_24;
            }
            case 1: {
                arrayList0 = l10.w;
                playlistId0 = l10.r;
                n.D(object0);
                serializable0 = ((ie.p)object0).a;
            label_24:
                if(serializable0 instanceof ie.o) {
                    serializable0 = null;
                }
                if(((List)serializable0) != null) {
                    m1 m10 = new m1(arrayList0, ((List)serializable0), null);
                    l10.r = null;
                    l10.w = arrayList0;
                    l10.B = (List)serializable0;
                    l10.G = 2;
                    if(this.i0(playlistId0, "updateSpecialContentsInfo", false, false, m10, l10) == a0) {
                        return a0;
                    }
                    list0 = (List)serializable0;
                    goto label_39;
                }
                return ie.H.a;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        list0 = l10.B;
        arrayList0 = l10.w;
        n.D(object0);
    label_39:
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object1: arrayList0) {
            arrayList1.add(((Playable)object1).getTrackId());
        }
        LogU.debug$default(this.l, "updateSpecialContentsInfo trackId=" + arrayList1 + ", " + list0, null, false, 6, null);
        return ie.H.a;
    }

    public final Object l(PlaylistId playlistId0, oe.c c0) {
        kc.m m0;
        if(c0 instanceof kc.m) {
            m0 = (kc.m)c0;
            int v = m0.D;
            if((v & 0x80000000) == 0) {
                m0 = new kc.m(this, c0);
            }
            else {
                m0.D = v ^ 0x80000000;
            }
        }
        else {
            m0 = new kc.m(this, c0);
        }
        Object object0 = m0.w;
        ne.a a0 = ne.a.a;
        switch(m0.D) {
            case 0: {
                n.D(object0);
                m0.r = playlistId0;
                m0.D = 1;
                if(this.X("changePlaylist", m0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                playlistId0 = m0.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            case 3: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Mutex mutex0 = this.s;
        ReentrantMutexContextKey reentrantMutexContextKey0 = new ReentrantMutexContextKey(mutex0);
        if(m0.getContext().get(reentrantMutexContextKey0) != null) {
            if(playlistId0.isDeprecated()) {
                LogU.error$default(this.l, "changePlaylist failed. - cannot change to deprecated playlist " + playlistId0, null, false, 6, null);
                return false;
            }
            Boolean boolean0 = (Boolean)this.r.getValue();
            if(boolean0 == null) {
                MelonDebugUtils.INSTANCE.errorLogOrException(this.l, "changePlaylist failed. - isUseSmartPlaylist is null");
                return false;
            }
            if(boolean0.booleanValue() && playlistId0 == PlaylistId.MUSIC) {
                LogU.error$default(this.l, "changePlaylist failed. - cannot change to music playlist when smart on", null, false, 6, null);
                return false;
            }
            if(!boolean0.booleanValue() && playlistId0 == PlaylistId.SMART) {
                LogU.error$default(this.l, "changePlaylist failed. - cannot change to smart playlist when smart off", null, false, 6, null);
                return false;
            }
            m0.r = null;
            m0.D = 2;
            Object object1 = b.b(this, playlistId0, m0);
            return object1 == a0 ? a0 : object1;
        }
        ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
        kc.l l0 = new kc.l(mutex0, null, playlistId0, this);
        m0.r = null;
        m0.D = 3;
        Object object2 = BuildersKt.withContext(reentrantMutexContextElement0, l0, m0);
        return object2 == a0 ? a0 : object2;
    }

    public final Object l0(CastData castData0, oe.c c0) {
        n1 n10;
        if(c0 instanceof n1) {
            n10 = (n1)c0;
            int v = n10.D;
            if((v & 0x80000000) == 0) {
                n10 = new n1(this, c0);
            }
            else {
                n10.D = v ^ 0x80000000;
            }
        }
        else {
            n10 = new n1(this, c0);
        }
        Object object0 = n10.w;
        ne.a a0 = ne.a.a;
        switch(n10.D) {
            case 0: {
                n.D(object0);
                n10.r = castData0;
                n10.D = 1;
                if(this.X("updateStationPlaylistCastData", n10) == a0) {
                    return a0;
                }
                goto label_22;
            }
            case 1: {
                castData0 = n10.r;
                n.D(object0);
            label_22:
                n10.r = castData0;
                n10.D = 2;
                object0 = this.b.i(false, n10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                castData0 = n10.r;
                n.D(object0);
                break;
            }
            case 3: {
                n.D(object0);
                return ie.H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        n10.r = null;
        n10.D = 3;
        return ((tc.x)object0).j(castData0, n10) == a0 ? a0 : ie.H.a;
    }

    public final Object m(oe.c c0) {
        b b0;
        int v2;
        int v1;
        kc.s s0;
        if(c0 instanceof kc.s) {
            s0 = (kc.s)c0;
            int v = s0.G;
            if((v & 0x80000000) == 0) {
                s0 = new kc.s(this, c0);
            }
            else {
                s0.G = v ^ 0x80000000;
            }
        }
        else {
            s0 = new kc.s(this, c0);
        }
        Enum enum0 = s0.D;
        ne.a a0 = ne.a.a;
        switch(s0.G) {
            case 0: {
                n.D(enum0);
                s0.G = 1;
                if(this.X("changeToDefaultPlaylist", s0) != a0) {
                label_27:
                    Mutex mutex0 = this.s;
                    ReentrantMutexContextKey reentrantMutexContextKey0 = new ReentrantMutexContextKey(mutex0);
                    if(s0.getContext().get(reentrantMutexContextKey0) == null) {
                        ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                        kc.r r0 = new kc.r(mutex0, null, this);
                        s0.w = 0;
                        s0.G = 4;
                        Object object1 = BuildersKt.withContext(reentrantMutexContextElement0, r0, s0);
                        if(object1 != a0) {
                            return object1;
                        }
                    }
                    else {
                        s0.r = this;
                        s0.w = 0;
                        s0.B = 0;
                        s0.G = 2;
                        enum0 = this.w(s0);
                        if(enum0 != a0) {
                            b0 = this;
                            v1 = 0;
                            v2 = 0;
                        label_39:
                            s0.r = null;
                            s0.w = v2;
                            s0.B = v1;
                            s0.G = 3;
                            Object object0 = b0.l(((PlaylistId)enum0), s0);
                            if(object0 != a0) {
                                return object0;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                n.D(enum0);
                goto label_27;
            }
            case 2: {
                v1 = s0.B;
                v2 = s0.w;
                b0 = s0.r;
                n.D(enum0);
                goto label_39;
            }
            case 3: {
                n.D(enum0);
                return enum0;
            }
            case 4: {
                n.D(enum0);
                return enum0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final Object n(oe.c c0) {
        t t0;
        if(c0 instanceof t) {
            t0 = (t)c0;
            int v = t0.D;
            if((v & 0x80000000) == 0) {
                t0 = new t(this, c0);
            }
            else {
                t0.D = v ^ 0x80000000;
            }
        }
        else {
            t0 = new t(this, c0);
        }
        Object object0 = t0.w;
        ne.a a0 = ne.a.a;
        switch(t0.D) {
            case 0: {
                n.D(object0);
                t0.D = 1;
                if(this.X("clearDrawerPlaylist", t0) != a0) {
                label_25:
                    t0.D = 2;
                    object0 = this.b.b(false, t0);
                    if(object0 != a0) {
                    label_28:
                        t0.D = 3;
                        object0 = ((nc.u0)object0).E(PlaylistId.DRAWER, t0);
                        if(object0 != a0) {
                        label_31:
                            if(!(((oc.b)object0) instanceof oc.b)) {
                                return object0;
                            }
                            kc.u u0 = new kc.u(this, ((oc.b)object0), null);
                            t0.r = object0;
                            t0.D = 4;
                            if(this.p(PlaylistId.DRAWER, u0, t0) != a0) {
                                return object0;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                n.D(object0);
                goto label_25;
            }
            case 2: {
                n.D(object0);
                goto label_28;
            }
            case 3: {
                n.D(object0);
                goto label_31;
            }
            case 4: {
                Object object1 = t0.r;
                n.D(object0);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final Object o(oe.c c0) {
        PlaylistId playlistId2;
        oc.e e0;
        PlaylistId playlistId1;
        Mutex mutex0;
        kc.w w0;
        if(c0 instanceof kc.w) {
            w0 = (kc.w)c0;
            int v = w0.E;
            if((v & 0x80000000) == 0) {
                w0 = new kc.w(this, c0);
            }
            else {
                w0.E = v ^ 0x80000000;
            }
        }
        else {
            w0 = new kc.w(this, c0);
        }
        Object object0 = w0.B;
        ne.a a0 = ne.a.a;
        switch(w0.E) {
            case 0: {
                n.D(object0);
                w0.E = 1;
                if(this.X("clearSelectRepeat", w0) != a0) {
                label_29:
                    mutex0 = this.s;
                    w0.r = mutex0;
                    w0.E = 2;
                    if(mutex0.lock(null, w0) != a0) {
                    label_33:
                        try {
                            playlistId2 = (PlaylistId)this.p.getValue();
                        }
                        finally {
                            mutex0.unlock(null);
                        }
                        LogU logU0 = this.l;
                        if(playlistId2 == null) {
                            MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "clearSelectRepeat() - currentPlaylistId is null");
                            return new oc.c();  // 初始化器: Ljava/lang/Object;-><init>()V
                        }
                        w w1 = this.H(playlistId2);
                        if(w1 == null) {
                            MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "clearSelectRepeat() - playlist is null");
                            return new oc.c();  // 初始化器: Ljava/lang/Object;-><init>()V
                        }
                        if(w1 instanceof oc.z) {
                            w0.r = playlistId2;
                            w0.E = 3;
                            Object object1 = ((oc.z)w1).t(w0);
                            if(object1 != a0) {
                                playlistId1 = playlistId2;
                                e0 = (oc.e)object1;
                                goto label_57;
                            }
                        }
                        else {
                            kotlin.jvm.internal.q.g(("not select repeat playlist " + playlistId2), "reason");
                            playlistId1 = playlistId2;
                            e0 = new oc.c();  // 初始化器: Ljava/lang/Object;-><init>()V
                        label_57:
                            if(!(e0 instanceof oc.d)) {
                                return e0;
                            }
                            kc.x x0 = new kc.x(this, e0, null);
                            w0.r = null;
                            w0.w = (oc.d)e0;
                            w0.E = 4;
                            if(this.p(playlistId1, x0, w0) != a0) {
                                return e0;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                n.D(object0);
                goto label_29;
            }
            case 2: {
                mutex0 = (Mutex)w0.r;
                n.D(object0);
                goto label_33;
            }
            case 3: {
                playlistId1 = (PlaylistId)w0.r;
                n.D(object0);
                e0 = (oc.e)object0;
                goto label_57;
            }
            case 4: {
                oc.d d0 = w0.w;
                PlaylistId playlistId0 = (PlaylistId)w0.r;
                n.D(object0);
                return d0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final Object p(PlaylistId playlistId0, we.k k0, oe.c c0) {
        Throwable throwable1;
        Mutex mutex2;
        int v2;
        Mutex mutex1;
        we.k k1;
        kc.y y0;
        if(c0 instanceof kc.y) {
            y0 = (kc.y)c0;
            int v = y0.M;
            if((v & 0x80000000) == 0) {
                y0 = new kc.y(this, c0);
            }
            else {
                y0.M = v ^ 0x80000000;
            }
        }
        else {
            y0 = new kc.y(this, c0);
        }
        Object object0 = y0.G;
        ne.a a0 = ne.a.a;
        int v1 = 0;
        switch(y0.M) {
            case 0: {
                n.D(object0);
                y0.r = playlistId0;
                y0.w = k0;
                Mutex mutex0 = this.s;
                y0.B = mutex0;
                y0.D = 0;
                y0.M = 1;
                if(mutex0.lock(null, y0) == a0) {
                    return a0;
                }
                k1 = k0;
                mutex1 = mutex0;
                v2 = 0;
                goto label_33;
            }
            case 1: {
                int v3 = y0.D;
                mutex1 = y0.B;
                k1 = y0.w;
                PlaylistId playlistId1 = y0.r;
                n.D(object0);
                v2 = v3;
                playlistId0 = playlistId1;
                try {
                label_33:
                    y0.r = playlistId0;
                    y0.w = k1;
                    y0.B = mutex1;
                    y0.D = v2;
                    y0.E = 0;
                    y0.M = 2;
                    Enum enum0 = this.s(y0);
                    if(enum0 == a0) {
                        return a0;
                    }
                    PlaylistId playlistId2 = playlistId0;
                    mutex2 = mutex1;
                    goto label_59;
                label_44:
                    v1 = y0.E;
                    int v4 = y0.D;
                    mutex1 = y0.B;
                    k1 = y0.w;
                    PlaylistId playlistId3 = y0.r;
                    n.D(object0);
                    v2 = v4;
                    mutex2 = mutex1;
                    playlistId2 = playlistId3;
                    enum0 = object0;
                    goto label_59;
                }
                catch(Throwable throwable0) {
                }
                throwable1 = throwable0;
                mutex2 = mutex1;
                mutex2.unlock(null);
                throw throwable1;
            }
            case 2: {
                goto label_44;
            label_59:
                if(enum0 == playlistId2) {
                    try {
                        y0.r = null;
                        y0.w = null;
                        y0.B = mutex2;
                        y0.D = v2;
                        y0.E = v1;
                        y0.M = 3;
                        object0 = k1.invoke(y0);
                        if(object0 == a0) {
                            return a0;
                        label_71:
                            mutex2 = y0.B;
                            n.D(object0);
                        }
                    }
                    catch(Throwable throwable1) {
                        mutex2.unlock(null);
                        throw throwable1;
                    }
                }
                else {
                    object0 = null;
                    break;
                }
                break;
            }
            case 3: {
                goto label_71;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return object0;
    }

    public final Serializable q(oe.c c0) {
        kc.z z0;
        if(c0 instanceof kc.z) {
            z0 = (kc.z)c0;
            int v = z0.B;
            if((v & 0x80000000) == 0) {
                z0 = new kc.z(this, c0);
            }
            else {
                z0.B = v ^ 0x80000000;
            }
        }
        else {
            z0 = new kc.z(this, c0);
        }
        Object object0 = z0.r;
        Serializable serializable0 = ne.a.a;
        switch(z0.B) {
            case 0: {
                n.D(object0);
                z0.B = 1;
                object0 = this.r(z0);
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
        return ((PlayableData)object0) != null ? ((PlayableData)object0).a : null;
    }

    public final Object r(oe.c c0) {
        kc.A a0;
        if(c0 instanceof kc.A) {
            a0 = (kc.A)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new kc.A(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new kc.A(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                a0.B = 1;
                object0 = this.F(a0);
                return object0 == a1 ? a1 : e1.b.z(((w)object0).getState());
            }
            case 1: {
                n.D(object0);
                return e1.b.z(((w)object0).getState());
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Enum s(oe.c c0) {
        kc.B b0;
        if(c0 instanceof kc.B) {
            b0 = (kc.B)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new kc.B(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new kc.B(this, c0);
        }
        Object object0 = b0.r;
        Enum enum0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                b0.B = 1;
                if(this.X("getCurrentPlaylistId", b0) == enum0) {
                    return enum0;
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
        Enum enum1 = (PlaylistId)this.p.getValue();
        if(enum1 == null) {
            MelonDebugUtils.INSTANCE.errorLogOrException(this.l, "getCurrentPlaylistId() null");
            return PlaylistId.EMPTY;
        }
        return enum1;
    }

    public final PlaylistId t() {
        this.Y("getCurrentPlaylistIdOrNull");
        return (PlaylistId)this.p.getValue();
    }

    public final w u() {
        PlaylistId playlistId0 = this.t();
        return playlistId0 == null ? null : this.H(playlistId0);
    }

    public final Object v(oe.c c0) {
        b b0;
        kc.C c1;
        if(c0 instanceof kc.C) {
            c1 = (kc.C)c0;
            int v = c1.D;
            if((v & 0x80000000) == 0) {
                c1 = new kc.C(this, c0);
            }
            else {
                c1.D = v ^ 0x80000000;
            }
        }
        else {
            c1 = new kc.C(this, c0);
        }
        Enum enum0 = c1.w;
        ne.a a0 = ne.a.a;
        switch(c1.D) {
            case 0: {
                n.D(enum0);
                c1.r = this;
                c1.D = 1;
                enum0 = this.w(c1);
                if(enum0 == a0) {
                    return a0;
                }
                b0 = this;
                break;
            }
            case 1: {
                b0 = c1.r;
                n.D(enum0);
                break;
            }
            case 2: {
                n.D(enum0);
                return enum0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        c1.r = null;
        c1.D = 2;
        Object object0 = b0.G(((PlaylistId)enum0), c1);
        return object0 == a0 ? a0 : object0;
    }

    public final Enum w(Continuation continuation0) {
        D d0;
        if(continuation0 instanceof D) {
            d0 = (D)continuation0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new D(this, continuation0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new D(this, continuation0);
        }
        Object object0 = d0.r;
        Enum enum0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                d0.B = 1;
                object0 = this.y(d0);
                if(object0 == enum0) {
                    return enum0;
                }
                return ((Boolean)object0).booleanValue() ? PlaylistId.SMART : PlaylistId.MUSIC;
            }
            case 1: {
                n.D(object0);
                return ((Boolean)object0).booleanValue() ? PlaylistId.SMART : PlaylistId.MUSIC;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object x(oe.c c0) {
        E e0;
        if(c0 instanceof E) {
            e0 = (E)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new E(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new E(this, c0);
        }
        Object object0 = e0.r;
        ne.a a0 = ne.a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                e0.B = 1;
                if(this.X("getDrawerPlaylist", e0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        e0.B = 2;
        Object object1 = this.b.b(false, e0);
        return object1 == a0 ? a0 : object1;
    }

    public final Object y(oe.c c0) {
        F f0;
        if(c0 instanceof F) {
            f0 = (F)c0;
            int v = f0.B;
            if((v & 0x80000000) == 0) {
                f0 = new F(this, c0);
            }
            else {
                f0.B = v ^ 0x80000000;
            }
        }
        else {
            f0 = new F(this, c0);
        }
        Object object0 = f0.r;
        ne.a a0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                n.D(object0);
                f0.B = 1;
                if(this.X("getIsUseSmartPlaylist", f0) == a0) {
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
        Boolean boolean0 = (Boolean)this.r.getValue();
        if(boolean0 != null) {
            return Boolean.valueOf(boolean0.booleanValue());
        }
        MelonDebugUtils.INSTANCE.errorLogOrException(this.l, "getIsUseSmartPlaylist() null");
        return false;
    }

    public final Object z(oe.c c0) {
        G g0;
        if(c0 instanceof G) {
            g0 = (G)c0;
            int v = g0.B;
            if((v & 0x80000000) == 0) {
                g0 = new G(this, c0);
            }
            else {
                g0.B = v ^ 0x80000000;
            }
        }
        else {
            g0 = new G(this, c0);
        }
        Object object0 = g0.r;
        ne.a a0 = ne.a.a;
        switch(g0.B) {
            case 0: {
                n.D(object0);
                g0.B = 1;
                if(this.X("getLivePlaylist", g0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        g0.B = 2;
        Object object1 = this.b.c(false, g0);
        return object1 == a0 ? a0 : object1;
    }
}

