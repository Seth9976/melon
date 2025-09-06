package com.melon.ui;

import Ub.s;
import Ub.u;
import b3.Z;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddAction.VideoPlayAndOpen;
import com.iloen.melon.playback.playlist.add.AddFailType.Normal;
import com.iloen.melon.playback.playlist.add.AddResult.Failure;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.interfaces.StringProviderImpl;
import d5.n;
import db.g;
import i.n.i.b.a.s.e.M3;
import k8.a;
import kc.s2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.NonCancellable;
import mb.k;
import ob.z;
import oe.c;
import w7.d;

public final class Q {
    public final a a;
    public final k b;
    public final z c;
    public final s d;
    public final StringProviderImpl e;
    public final LogU f;

    public Q(a a0, d d0, k k0, z z0, s2 s20, u u0, s s0, g g0, StringProviderImpl stringProviderImpl0) {
        q.g(a0, "blockingProgressDialogManage");
        q.g(k0, "loginUseCase");
        q.g(s20, "playlistManager");
        q.g(u0, "vodRepeatManager");
        q.g(s0, "remotePlayerManager");
        super();
        this.a = a0;
        this.b = k0;
        this.c = z0;
        this.d = s0;
        this.e = stringProviderImpl0;
        this.f = Z.g("AddPlayUserEventHelper", true);
    }

    public static final Object a(Q q0, Playable playable0, boolean z, c c0) {
        K k0;
        if(c0 instanceof K) {
            k0 = (K)c0;
            int v = k0.B;
            if((v & 0x80000000) == 0) {
                k0 = new K(q0, c0);
            }
            else {
                k0.B = v ^ 0x80000000;
            }
        }
        else {
            k0 = new K(q0, c0);
        }
        Object object0 = k0.r;
        ne.a a0 = ne.a.a;
        switch(k0.B) {
            case 0: {
                n.D(object0);
                L l0 = new L(z, playable0, null);
                k0.B = 1;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, l0, k0);
                return object0 == a0 ? a0 : ((AddResult)object0);
            }
            case 1: {
                n.D(object0);
                return (AddResult)object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static final Object b(Q q0, String s, String s1, boolean z, boolean z1, StatsElementsBase statsElementsBase0, com.melon.ui.q q1, c c0) {
        M m0;
        if(c0 instanceof M) {
            m0 = (M)c0;
            int v = m0.D;
            if((v & 0x80000000) == 0) {
                m0 = new M(q0, c0);
            }
            else {
                m0.D = v ^ 0x80000000;
            }
        }
        else {
            m0 = new M(q0, c0);
        }
        Object object0 = m0.w;
        ne.a a0 = ne.a.a;
        switch(m0.D) {
            case 0: {
                n.D(object0);
                if(s.length() == 0 || s1.length() == 0) {
                    LogU.warn$default(q0.f, "playVideo() invalid parameter", null, false, 6, null);
                    return new b(new Failure(Normal.INSTANCE), q1);
                }
                VideoPlayAndOpen addAction$VideoPlayAndOpen0 = z1 ? new VideoPlayAndOpen(z) : new AddPlay(false);
                N n0 = new N(s, s1, statsElementsBase0, q0, addAction$VideoPlayAndOpen0, null);
                m0.r = q1;
                m0.D = 1;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, n0, m0);
                return object0 == a0 ? a0 : new b(((AddResult)object0), q1);
            }
            case 1: {
                com.melon.ui.q q2 = m0.r;
                n.D(object0);
                return new b(((AddResult)object0), q2);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static final Object c(Q q0, String s, String s1, boolean z, StatsElementsBase statsElementsBase0, com.melon.ui.q q1, c c0) {
        O o0;
        if(c0 instanceof O) {
            o0 = (O)c0;
            int v = o0.D;
            if((v & 0x80000000) == 0) {
                o0 = new O(q0, c0);
            }
            else {
                o0.D = v ^ 0x80000000;
            }
        }
        else {
            o0 = new O(q0, c0);
        }
        Object object0 = o0.w;
        ne.a a0 = ne.a.a;
        switch(o0.D) {
            case 0: {
                n.D(object0);
                if(s.length() == 0 || s1.length() == 0) {
                    LogU.warn$default(q0.f, "playVideoBySongId() invalid parameter", null, false, 6, null);
                    return new b(new Failure(Normal.INSTANCE), q1);
                }
                VideoPlayAndOpen addAction$VideoPlayAndOpen0 = z ? new VideoPlayAndOpen(false) : new AddPlay(false);
                P p0 = new P(s, s1, statsElementsBase0, q0, addAction$VideoPlayAndOpen0, null);
                o0.r = q1;
                o0.D = 1;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, p0, o0);
                return object0 == a0 ? a0 : new b(((AddResult)object0), q1);
            }
            case 1: {
                com.melon.ui.q q2 = o0.r;
                n.D(object0);
                return new b(((AddResult)object0), q2);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final void d(com.melon.ui.q q0, T2.a a0, we.k k0) {
        q.g(q0, "event");
        if(q0 instanceof com.melon.ui.n) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getMain(), null, new com.melon.ui.z(q0, this, null, k0), 2, null);
            return;
        }
        if(q0 instanceof com.melon.ui.g) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getMain(), null, new B(q0, this, null, k0), 2, null);
            return;
        }
        if(q0 instanceof h) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getMain(), null, new D(q0, this, null, k0), 2, null);
            return;
        }
        if(q0 instanceof p) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getMain(), null, new E(q0, this, null, k0), 2, null);
            return;
        }
        if(q0 instanceof o) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getMain(), null, new F(q0, this, null, k0), 2, null);
            return;
        }
        if(q0 instanceof l) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getMain(), null, new H(q0, this, null, k0), 2, null);
            return;
        }
        if(q0 instanceof com.melon.ui.k) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getMain(), null, new J(q0, this, null, k0), 2, null);
            return;
        }
        if(q0 instanceof m) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getMain(), null, new t(q0, this, null, k0), 2, null);
            return;
        }
        if(q0 instanceof i) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getMain(), null, new v(q0, this, null, k0), 2, null);
            return;
        }
        if(q0 instanceof j) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getMain(), null, new x(q0, this, null, k0), 2, null);
            return;
        }
        if(!(q0 instanceof K0)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getMain(), null, new y(this, q0, a0, k0, null), 2, null);
    }
}

