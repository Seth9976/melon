package com.iloen.melon.player.playlist.mixup;

import A8.b;
import Cc.N1;
import La.c;
import M.j;
import M.n0;
import M.p0;
import M.w;
import M.y;
import O.v;
import P0.h;
import P0.i;
import P0.k;
import P0.r;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import java.util.ListIterator;
import r0.a;
import r0.q;
import we.n;
import y0.s;

public final class e implements n {
    public final int a;
    public final MixUpPlaylistComposeFragment b;

    public e(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, int v) {
        this.a = v;
        this.b = mixUpPlaylistComposeFragment0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v6;
        V v5;
        H h0 = H.a;
        MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.b;
        switch(this.a) {
            case 0: {
                int v = (int)(((Integer)object1));
                p p0 = (p)(((l)object0));
                if(p0.Q(v & 1, (v & 3) != 2)) {
                    p0.p p1 = ((MixUpPlaylistComposeViewModel)mixUpPlaylistComposeFragment0.getViewModel()).getUiList();
                    r0.n n0 = r0.n.a;
                    q q0 = d.f(d.c(n0, 1.0f), 1.0f);
                    y y0 = w.a(j.c, r0.d.m, p0, 0);
                    int v1 = p0.P;
                    i0 i00 = p0.m();
                    q q1 = a.d(p0, q0);
                    k.y.getClass();
                    i i0 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    h h1 = P0.j.f;
                    androidx.compose.runtime.w.x(p0, y0, h1);
                    h h2 = P0.j.e;
                    androidx.compose.runtime.w.x(p0, i00, h2);
                    h h3 = P0.j.g;
                    if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v1)) {
                        A7.d.q(v1, p0, v1, h3);
                    }
                    h h4 = P0.j.d;
                    androidx.compose.runtime.w.x(p0, q1, h4);
                    E e0 = p0.N();
                    V v2 = androidx.compose.runtime.k.a;
                    if(e0 == v2) {
                        e0 = androidx.compose.runtime.w.i(new com.iloen.melon.player.playlist.mixup.h(p1, 1));
                        p0.l0(e0);
                    }
                    if(((Boolean)e0.getValue()).booleanValue()) {
                        p0.a0(-204134371);
                        mixUpPlaylistComposeFragment0.MixUpTabEmptyViewLayout(p0, 0);
                    }
                    else {
                        p0.a0(-204061862);
                        mixUpPlaylistComposeFragment0.SourceTitle(p0, 0);
                        mixUpPlaylistComposeFragment0.SelectableFilter(p0, 0);
                        mixUpPlaylistComposeFragment0.MixUpPlaylistList(p0, 0);
                    }
                    p0.p(false);
                    p0.p(true);
                    if(b.d()) {
                        v5 = v2;
                        p0.a0(0x34BBBA8);
                    }
                    else {
                        p0.a0(65820504);
                        p0 p00 = n0.a(j.a, r0.d.j, p0, 0);
                        int v3 = p0.P;
                        i0 i01 = p0.m();
                        q q2 = a.d(p0, n0);
                        p0.e0();
                        if(p0.O) {
                            p0.l(i0);
                        }
                        else {
                            p0.o0();
                        }
                        androidx.compose.runtime.w.x(p0, p00, h1);
                        androidx.compose.runtime.w.x(p0, i01, h2);
                        if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                            A7.d.q(v3, p0, v3, h3);
                        }
                        androidx.compose.runtime.w.x(p0, q2, h4);
                        if(((Boolean)B.a.r(c.b, p0, 0).getValue()).booleanValue()) {
                            p0.a0(0xEA7F477A);
                            int v4 = p1.size() - 1;
                            if(v4 < 0) {
                                v4 = 0;
                            }
                            v5 = v2;
                            N1.b(("전체 곡 수 : " + v4), null, s.d, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x180, 0, 0x1FFFA);
                        }
                        else {
                            v5 = v2;
                            p0.a0(0xE9DC47E7);
                        }
                        p0.p(false);
                        M.c.d(p0, d.q(n0, 10.0f));
                        if(((Boolean)B.a.r(c.c, p0, 0).getValue()).booleanValue()) {
                            p0.a0(-360207721);
                            boolean z = p0.i(mixUpPlaylistComposeFragment0);
                            g g0 = p0.N();
                            if(z || g0 == v5) {
                                g0 = new g(mixUpPlaylistComposeFragment0, 3);
                                p0.l0(g0);
                            }
                            b0.y.a(g0, null, false, null, null, null, null, ComposableSingletons.MixUpPlaylistComposeFragmentKt.INSTANCE.getLambda$1369553497$app_playstoreProdRelease(), p0, 0x30000000);
                        }
                        else {
                            p0.a0(0xE9DC47E7);
                        }
                        p0.p(false);
                        p0.p(true);
                    }
                    p0.p(false);
                    if(p1 == null || !p1.isEmpty()) {
                        ListIterator listIterator0 = p1.listIterator();
                        v6 = 0;
                        while(((r)listIterator0).hasNext()) {
                            MixUpUIItemData mixUpUIItemData0 = (MixUpUIItemData)((r)listIterator0).next();
                            if(mixUpUIItemData0 instanceof Ud.h && ((Ud.h)mixUpUIItemData0).isSelected()) {
                                ++v6;
                                if(v6 < 0) {
                                    e.k.N();
                                    throw null;
                                }
                                if(false) {
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        v6 = 0;
                    }
                    Integer integer0 = v6;
                    boolean z1 = p0.i(mixUpPlaylistComposeFragment0);
                    boolean z2 = p0.e(v6);
                    com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onViewCreated.1.3.1 mixUpPlaylistComposeFragment$onViewCreated$1$3$10 = p0.N();
                    if(z1 || z2 || mixUpPlaylistComposeFragment$onViewCreated$1$3$10 == v5) {
                        mixUpPlaylistComposeFragment$onViewCreated$1$3$10 = new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onViewCreated.1.3.1(mixUpPlaylistComposeFragment0, v6, null);
                        p0.l0(mixUpPlaylistComposeFragment$onViewCreated$1$3$10);
                    }
                    J.d(p0, integer0, mixUpPlaylistComposeFragment$onViewCreated$1$3$10);
                    return h0;
                }
                p0.T();
                return h0;
            }
            case 1: {
                kotlin.jvm.internal.q.g(((v)object0), "from");
                kotlin.jvm.internal.q.g(((v)object1), "to");
                ((MixUpPlaylistComposeViewModel)mixUpPlaylistComposeFragment0.getViewModel()).moveFromDragging(((v)object0).a, ((v)object1).a);
                return h0;
            }
            default: {
                ((MixUpPlaylistComposeViewModel)mixUpPlaylistComposeFragment0.getViewModel()).moveFromDragEnd(((int)(((Integer)object0))), ((int)(((Integer)object1))));
                return h0;
            }
        }
    }
}

