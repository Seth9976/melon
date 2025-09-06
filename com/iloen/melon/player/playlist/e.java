package com.iloen.melon.player.playlist;

import B.a;
import Cc.x2;
import Zc.N;
import android.net.Uri;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import kotlin.jvm.internal.q;
import ob.A;
import we.n;

public final class e implements n {
    public final int a;
    public final PlaylistMainFragment b;

    public e(PlaylistMainFragment playlistMainFragment0, int v) {
        this.a = v;
        this.b = playlistMainFragment0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        H h0 = H.a;
        PlaylistMainFragment playlistMainFragment0 = this.b;
        switch(this.a) {
            case 0: {
                int v1 = (int)(((Integer)object1));
                p p0 = (p)(((l)object0));
                if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
                    b0 b00 = a.r(((PlaylistMainViewModel)playlistMainFragment0.getViewModel()).isPlayingStateFlow(), p0, 0);
                    b0 b01 = a.r(((PlaylistMainViewModel)playlistMainFragment0.getViewModel()).getPositionStateFlow(), p0, 0);
                    b0 b02 = a.r(((PlaylistMainViewModel)playlistMainFragment0.getViewModel()).getThumbnailUriStateFlow(), p0, 0);
                    long v2 = ((A)b01.getValue()).a;
                    long v3 = ((A)b01.getValue()).b;
                    boolean z = p0.i(playlistMainFragment0);
                    k k0 = p0.N();
                    V v4 = androidx.compose.runtime.k.a;
                    if(z || k0 == v4) {
                        k0 = new k(playlistMainFragment0, 8);
                        p0.l0(k0);
                    }
                    boolean z1 = p0.i(playlistMainFragment0);
                    k k1 = p0.N();
                    if(z1 || k1 == v4) {
                        k1 = new k(playlistMainFragment0, 9);
                        p0.l0(k1);
                    }
                    boolean z2 = p0.i(playlistMainFragment0);
                    e e0 = p0.N();
                    if(z2 || e0 == v4) {
                        e0 = new e(playlistMainFragment0, 1);
                        p0.l0(e0);
                    }
                    boolean z3 = ((Boolean)b00.getValue()).booleanValue();
                    boolean z4 = p0.g(b00);
                    boolean z5 = p0.i(playlistMainFragment0);
                    N n0 = p0.N();
                    if(z4 || z5 || n0 == v4) {
                        n0 = new N(19, b00, playlistMainFragment0);
                        p0.l0(n0);
                    }
                    boolean z6 = p0.i(playlistMainFragment0);
                    k k2 = p0.N();
                    if(z6 || k2 == v4) {
                        k2 = new k(playlistMainFragment0, 10);
                        p0.l0(k2);
                    }
                    boolean z7 = p0.i(playlistMainFragment0);
                    e e1 = p0.N();
                    if(z7 || e1 == v4) {
                        e1 = new e(playlistMainFragment0, 2);
                        p0.l0(e1);
                    }
                    String s = ((Uri)b02.getValue()).toString();
                    q.f(s, "toString(...)");
                    boolean z8 = p0.i(playlistMainFragment0);
                    k k3 = p0.N();
                    if(z8 || k3 == v4) {
                        k3 = new k(playlistMainFragment0, 11);
                        p0.l0(k3);
                    }
                    PlaylistMainComposablesKt.PlaylistBottomController(v2, v3, k0, k1, e0, z3, n0, k2, e1, s, k3, p0, 0, 0, 0);
                    return h0;
                }
                p0.T();
                return h0;
            }
            case 1: {
                int v5 = (int)(((Integer)object0));
                long v6 = (long)(((Long)object1));
                if(v5 == 0) {
                    playlistMainFragment0.q().logLongClickPrev();
                }
                playlistMainFragment0.sendUserEvent(new LongClickPrevButton(v5, v6));
                return h0;
            }
            case 2: {
                int v7 = (int)(((Integer)object0));
                long v8 = (long)(((Long)object1));
                if(v7 == 0) {
                    playlistMainFragment0.q().logLongClickNext();
                }
                playlistMainFragment0.sendUserEvent(new LongClickNextButton(v7, v8));
                return h0;
            }
            default: {
                int v = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(1 & v, (v & 3) != 2)) {
                    Object object2 = a.r(((PlaylistMainViewModel)playlistMainFragment0.getViewModel()).getBgDataStateFlow(), ((p)(((l)object0))), 0).getValue();
                    x2 x20 = playlistMainFragment0.getPlayBgColorExtractor();
                    PlaylistMainComposablesKt.PlaylistBg(d.c, ((PlaylistMainBgData)object2), x20, ((p)(((l)object0))), 6, 0);
                    return h0;
                }
                ((p)(((l)object0))).T();
                return h0;
            }
        }
    }
}

