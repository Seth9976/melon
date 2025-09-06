package androidx.media3.session;

import A6.i;
import I6.V;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import androidx.media3.session.legacy.PlaybackStateCompat.CustomAction;
import androidx.media3.session.legacy.PlaybackStateCompat;
import b3.E;
import b3.G;
import b3.K;
import b3.L;
import b3.N;
import b3.P;
import b3.Q;
import b3.S;
import b3.d;
import b3.f;
import b3.k;
import b3.o;
import b3.p0;
import b3.u0;
import b3.w0;
import b3.z0;
import d3.c;
import e3.x;
import java.util.ArrayList;
import java.util.List;

public final class o1 extends f {
    public i c;
    public Bundle d;
    public V e;
    public V f;
    public t1 g;
    public N h;

    @Override  // b3.f
    public final z0 A() {
        this.s0();
        return super.A();
    }

    @Override  // b3.S
    public final k B() {
        this.s0();
        return ((S)this.b).B();
    }

    @Override  // b3.f
    public final void C(int v, int v1) {
        this.s0();
        super.C(v, v1);
    }

    @Override  // b3.S
    public final void D(List list0, int v, long v1) {
        this.s0();
        ((S)this.b).D(list0, v, v1);
    }

    @Override  // b3.S
    public final long E() {
        this.s0();
        return ((S)this.b).E();
    }

    @Override  // b3.S
    public final void F(int v, List list0) {
        this.s0();
        ((S)this.b).F(v, list0);
    }

    @Override  // b3.f
    public final void G(E e0) {
        this.s0();
        super.G(e0);
    }

    @Override  // b3.S
    public final void H(P p0) {
        this.s0();
        o o0 = new o(this, p0);
        ((S)this.b).H(o0);
    }

    @Override  // b3.S
    public final G I() {
        this.s0();
        return ((S)this.b).I();
    }

    @Override  // b3.f
    public final void J(u0 u00) {
        this.s0();
        super.J(u00);
    }

    @Override  // b3.f
    public final void K(G g0) {
        this.s0();
        super.K(g0);
    }

    @Override  // b3.S
    public final int L() {
        this.s0();
        return ((S)this.b).L();
    }

    @Override  // b3.f
    public final void M(int v, int v1) {
        this.s0();
        super.M(v, v1);
    }

    @Override  // b3.S
    public final void N(int v, int v1, int v2) {
        this.s0();
        ((S)this.b).N(v, v1, v2);
    }

    @Override  // b3.f
    public final void O(List list0) {
        this.s0();
        super.O(list0);
    }

    @Override  // b3.f
    public final boolean P() {
        this.s0();
        return super.P();
    }

    @Override  // b3.f
    public final void Q(int v) {
        this.s0();
        super.Q(v);
    }

    @Override  // b3.f
    public final void R() {
        this.s0();
        super.R();
    }

    @Override  // b3.f
    public final void S() {
        this.s0();
        super.S();
    }

    @Override  // b3.S
    public final G T() {
        this.s0();
        return ((S)this.b).T();
    }

    @Override  // b3.S
    public final void U(List list0) {
        this.s0();
        ((S)this.b).U(list0);
    }

    @Override  // b3.S
    public final long V() {
        this.s0();
        return ((S)this.b).V();
    }

    @Override  // b3.f
    public final E W() {
        this.s0();
        return ((S)this.b).W();
    }

    @Override  // b3.f
    public final boolean Y(int v) {
        this.s0();
        return ((S)this.b).Y(v);
    }

    @Override  // b3.f
    public final boolean Z() {
        this.s0();
        return ((S)this.b).Z();
    }

    @Override  // b3.S
    public final void a(L l0) {
        this.s0();
        ((S)this.b).a(l0);
    }

    @Override  // b3.f
    public final boolean a0() {
        this.s0();
        return ((S)this.b).a0();
    }

    @Override  // b3.f
    public final void b() {
        this.s0();
        super.b();
    }

    @Override  // b3.f
    public final void b0(P p0) {
        this.s0();
        super.b0(p0);
    }

    @Override  // b3.f
    public final void c() {
        this.s0();
        super.c();
    }

    @Override  // b3.f
    public final boolean c0() {
        this.s0();
        return ((S)this.b).c0();
    }

    @Override  // b3.f
    public final void d(int v, boolean z) {
        this.s0();
        super.d(v, z);
    }

    @Override  // b3.f
    public final void e() {
        this.s0();
        super.e();
    }

    @Override  // b3.f
    public final void f(int v) {
        this.s0();
        super.f(v);
    }

    @Override  // b3.f
    public final void g(E e0, long v) {
        this.s0();
        super.g(e0, v);
    }

    @Override  // b3.S
    public final d getAudioAttributes() {
        this.s0();
        return ((S)this.b).getAudioAttributes();
    }

    @Override  // b3.f
    public final int getBufferedPercentage() {
        this.s0();
        return ((S)this.b).getBufferedPercentage();
    }

    @Override  // b3.f
    public final long getBufferedPosition() {
        this.s0();
        return ((S)this.b).getBufferedPosition();
    }

    @Override  // b3.f
    public final long getContentBufferedPosition() {
        this.s0();
        return ((S)this.b).getContentBufferedPosition();
    }

    @Override  // b3.f
    public final long getContentDuration() {
        this.s0();
        return ((S)this.b).getContentDuration();
    }

    @Override  // b3.f
    public final long getContentPosition() {
        this.s0();
        return ((S)this.b).getContentPosition();
    }

    @Override  // b3.S
    public final int getCurrentAdGroupIndex() {
        this.s0();
        return ((S)this.b).getCurrentAdGroupIndex();
    }

    @Override  // b3.S
    public final int getCurrentAdIndexInAdGroup() {
        this.s0();
        return ((S)this.b).getCurrentAdIndexInAdGroup();
    }

    @Override  // b3.f
    public final int getCurrentPeriodIndex() {
        this.s0();
        return ((S)this.b).getCurrentPeriodIndex();
    }

    @Override  // b3.S
    public final long getCurrentPosition() {
        this.s0();
        return ((S)this.b).getCurrentPosition();
    }

    @Override  // b3.S
    public final p0 getCurrentTimeline() {
        this.s0();
        return ((S)this.b).getCurrentTimeline();
    }

    @Override  // b3.f
    public final long getDuration() {
        this.s0();
        return ((S)this.b).getDuration();
    }

    @Override  // b3.S
    public final boolean getPlayWhenReady() {
        this.s0();
        return ((S)this.b).getPlayWhenReady();
    }

    @Override  // b3.S
    public final L getPlaybackParameters() {
        this.s0();
        return ((S)this.b).getPlaybackParameters();
    }

    @Override  // b3.S
    public final int getPlaybackState() {
        this.s0();
        return ((S)this.b).getPlaybackState();
    }

    @Override  // b3.S
    public final int getPlaybackSuppressionReason() {
        this.s0();
        return ((S)this.b).getPlaybackSuppressionReason();
    }

    @Override  // b3.S
    public final int getRepeatMode() {
        this.s0();
        return ((S)this.b).getRepeatMode();
    }

    @Override  // b3.S
    public final boolean getShuffleModeEnabled() {
        this.s0();
        return ((S)this.b).getShuffleModeEnabled();
    }

    @Override  // b3.S
    public final long getTotalBufferedDuration() {
        this.s0();
        return ((S)this.b).getTotalBufferedDuration();
    }

    @Override  // b3.f
    public final float getVolume() {
        this.s0();
        return super.getVolume();
    }

    @Override  // b3.S
    public final void h(int v, int v1, List list0) {
        this.s0();
        ((S)this.b).h(v, v1, list0);
    }

    @Override  // b3.f
    public final void i(int v) {
        this.s0();
        super.i(v);
    }

    @Override  // b3.S
    public final boolean isLoading() {
        this.s0();
        return ((S)this.b).isLoading();
    }

    @Override  // b3.f
    public final boolean isPlaying() {
        this.s0();
        return ((S)this.b).isPlaying();
    }

    @Override  // b3.S
    public final boolean isPlayingAd() {
        this.s0();
        return ((S)this.b).isPlayingAd();
    }

    @Override  // b3.S
    public final void j(int v, int v1) {
        this.s0();
        ((S)this.b).j(v, v1);
    }

    @Override  // b3.f
    public final void k() {
        this.s0();
        super.k();
    }

    public final PlaybackStateCompat k0() {
        int v15;
        long v10;
        long v7;
        long v6;
        int v2;
        i i0 = this.c;
        if(i0 != null && i0.b) {
            new Bundle(((Bundle)i0.e)).putAll(this.d);
            ArrayList arrayList0 = new ArrayList();
            long v = SystemClock.elapsedRealtime();
            int v1 = i0.c;
            ((String)i0.d).getClass();
            return new PlaybackStateCompat(7, -1L, 0L, 0.0f, 0L, v1, ((String)i0.d), v, arrayList0, -1L, ((Bundle)i0.e));
        }
        K k0 = this.l();
        if(this.l() == null) {
            int v3 = this.getPlaybackState();
            boolean z = x.V(this, true);
            switch(v3) {
                case 1: {
                    v2 = 0;
                    break;
                }
                case 2: {
                    v2 = z ? 2 : 6;
                    break;
                }
                case 3: {
                    v2 = z ? 2 : 3;
                    break;
                }
                default: {
                    if(v3 != 4) {
                        throw new IllegalArgumentException("Unrecognized State: " + v3);
                    }
                    v2 = 1;
                    break;
                }
            }
        }
        else {
            v2 = 7;
        }
        N n0 = h1.d(this.h, this.y());
        long v4 = 0x80L;
        for(int v5 = 0; true; ++v5) {
            v6 = -1L;
            v7 = 0L;
            if(v5 >= n0.a.a.size()) {
                break;
            }
            int v8 = n0.a.b(v5);
            switch(v8) {
                case 1: {
                    v7 = 0x206L;
                    break;
                }
                case 2: {
                    v7 = 0x4000L;
                    break;
                }
                case 3: {
                    v7 = 1L;
                    break;
                }
                default: {
                    if(v8 == 0x1F) {
                        v7 = 0x3AC00L;
                    }
                    else {
                        switch(v8) {
                            case 5: {
                                v7 = 0x100L;
                                break;
                            }
                            case 6: 
                            case 7: {
                                v7 = 16L;
                                break;
                            }
                            case 8: 
                            case 9: {
                                v7 = 0x20L;
                                break;
                            }
                            case 10: {
                                v7 = 0x1000L;
                                break;
                            }
                            case 11: {
                                v7 = 8L;
                                break;
                            }
                            case 12: {
                                v7 = 0x40L;
                                break;
                            }
                            case 13: {
                                v7 = 0x400000L;
                                break;
                            }
                            case 14: {
                                v7 = 0x280000L;
                                break;
                            }
                            case 15: {
                                v7 = 0x40000L;
                            }
                        }
                    }
                }
            }
            v4 |= v7;
        }
        if(this.Y(17)) {
            int v9 = this.L();
            v10 = v9 == -1 ? -1L : ((long)v9);
        }
        else {
            v10 = -1L;
        }
        float f = this.getPlaybackParameters().a;
        float f1 = this.isPlaying() ? f : 0.0f;
        Bundle bundle0 = i0 == null ? new Bundle() : new Bundle(((Bundle)i0.e));
        bundle0.putAll(this.d);
        bundle0.putFloat("EXO_SPEED", f);
        E e0 = this.o0();
        if(e0 != null) {
            String s = e0.a;
            if(!"".equals(s)) {
                bundle0.putString("androidx.media.PlaybackStateCompat.Extras.KEY_MEDIA_ID", s);
            }
        }
        boolean z1 = this.Y(16);
        if(z1) {
            v6 = this.getCurrentPosition();
        }
        if(z1) {
            v7 = this.getBufferedPosition();
        }
        ArrayList arrayList1 = new ArrayList();
        long v11 = SystemClock.elapsedRealtime();
        V v12 = this.f.isEmpty() ? this.e : this.f;
        int v13 = 0;
        while(v13 < v12.size()) {
            b b0 = (b)v12.get(v13);
            s1 s10 = b0.a;
            int v14 = b0.c;
            if(s10 == null) {
                v15 = v2;
            }
            else {
                Bundle bundle1 = s10.c;
                if(!b0.i || s10.a != 0) {
                    v15 = v2;
                }
                else {
                    v15 = v2;
                    N n1 = this.h;
                    if(s10 != null && this.g.a.contains(s10) || b0.b != -1 && n1.a(b0.b)) {
                        if(v14 != 0) {
                            Bundle bundle2 = new Bundle(bundle1);
                            bundle2.putInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", v14);
                            bundle1 = bundle2;
                        }
                        String s1 = s10.b;
                        CharSequence charSequence0 = b0.f;
                        int v16 = b0.d;
                        if(TextUtils.isEmpty(s1)) {
                            throw new IllegalArgumentException("You must specify an action to build a CustomAction");
                        }
                        if(TextUtils.isEmpty(charSequence0)) {
                            throw new IllegalArgumentException("You must specify a name to build a CustomAction");
                        }
                        if(v16 == 0) {
                            throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction");
                        }
                        arrayList1.add(new CustomAction(s1, charSequence0, v16, bundle1));
                    }
                }
            }
            ++v13;
            v2 = v15;
        }
        if(k0 != null) {
            return new PlaybackStateCompat(v2, v6, v7, f1, v4, q.h(k0.a), k0.getMessage(), v11, arrayList1, v10, bundle0);
        }
        return i0 == null ? new PlaybackStateCompat(v2, v6, v7, f1, v4, 0, null, v11, arrayList1, v10, bundle0) : new PlaybackStateCompat(v2, v6, v7, f1, v4, i0.c, ((String)i0.d), v11, arrayList1, v10, bundle0);
    }

    @Override  // b3.S
    public final K l() {
        this.s0();
        return ((S)this.b).l();
    }

    public final k1 l0() {
        K k0 = this.l();
        v1 v10 = this.n0();
        Q q0 = this.m0();
        Q q1 = this.m0();
        L l0 = this.getPlaybackParameters();
        int v = this.getRepeatMode();
        boolean z = this.getShuffleModeEnabled();
        z0 z00 = this.A();
        p0 p00 = this.p0();
        G g0 = this.Y(18) ? this.I() : G.K;
        float f = this.Y(22) ? this.getVolume() : 0.0f;
        d d0 = this.Y(21) ? this.getAudioAttributes() : d.g;
        c c0 = this.Y(28) ? this.p() : c.c;
        k k1 = this.B();
        int v1 = this.Y(23) ? this.v() : 0;
        boolean z1 = this.r0();
        boolean z2 = this.getPlayWhenReady();
        int v2 = this.getPlaybackSuppressionReason();
        int v3 = this.getPlaybackState();
        boolean z3 = this.isPlaying();
        boolean z4 = this.isLoading();
        G g1 = this.q0();
        long v4 = this.V();
        long v5 = this.E();
        long v6 = this.z();
        return this.Y(30) ? new k1(k0, 0, v10, q0, q1, 0, l0, v, z, z00, p00, 0, g0, f, d0, c0, k1, v1, z1, z2, 1, v2, v3, z3, z4, g1, v4, v5, v6, this.o(), this.s()) : new k1(k0, 0, v10, q0, q1, 0, l0, v, z, z00, p00, 0, g0, f, d0, c0, k1, v1, z1, z2, 1, v2, v3, z3, z4, g1, v4, v5, v6, w0.b, this.s());
    }

    @Override  // b3.f
    public final void m() {
        this.s0();
        super.m();
    }

    public final Q m0() {
        boolean z = this.Y(16);
        boolean z1 = this.Y(17);
        int v = 0;
        int v1 = z1 ? this.L() : 0;
        E e0 = z ? this.W() : null;
        if(z1) {
            v = this.getCurrentPeriodIndex();
        }
        long v2 = 0L;
        long v3 = z ? this.getCurrentPosition() : 0L;
        if(z) {
            v2 = this.getContentPosition();
        }
        int v4 = -1;
        int v5 = z ? this.getCurrentAdGroupIndex() : -1;
        if(z) {
            v4 = this.getCurrentAdIndexInAdGroup();
        }
        return new Q(null, v1, e0, null, v, v3, v2, v5, v4);
    }

    @Override  // b3.f
    public final void n(int v) {
        this.s0();
        super.n(v);
    }

    public final v1 n0() {
        boolean z = this.Y(16);
        Q q0 = this.m0();
        int v = 0;
        boolean z1 = z && this.isPlayingAd();
        long v1 = SystemClock.elapsedRealtime();
        long v2 = 0x8000000000000001L;
        long v3 = z ? this.getDuration() : 0x8000000000000001L;
        long v4 = 0L;
        long v5 = z ? this.getBufferedPosition() : 0L;
        if(z) {
            v = this.getBufferedPercentage();
        }
        long v6 = z ? this.getTotalBufferedDuration() : 0L;
        long v7 = z ? this.w() : 0x8000000000000001L;
        if(z) {
            v2 = this.getContentDuration();
        }
        if(z) {
            v4 = this.getContentBufferedPosition();
        }
        return new v1(q0, z1, v1, v3, v5, v, v6, v7, v2, v4);
    }

    @Override  // b3.S
    public final w0 o() {
        this.s0();
        return ((S)this.b).o();
    }

    // 去混淆评级： 低(20)
    public final E o0() {
        return this.Y(16) ? this.W() : null;
    }

    @Override  // b3.f
    public final c p() {
        this.s0();
        return super.p();
    }

    public final p0 p0() {
        if(this.Y(17)) {
            return this.getCurrentTimeline();
        }
        return this.Y(16) ? new n1(this) : p0.a;
    }

    @Override  // b3.f
    public final void pause() {
        this.s0();
        super.pause();
    }

    @Override  // b3.f
    public final void play() {
        this.s0();
        super.play();
    }

    @Override  // b3.f
    public final void prepare() {
        this.s0();
        super.prepare();
    }

    @Override  // b3.f
    public final void q(boolean z) {
        this.s0();
        super.q(z);
    }

    // 去混淆评级： 低(20)
    public final G q0() {
        return this.Y(18) ? this.T() : G.K;
    }

    @Override  // b3.f
    public final void r() {
        this.s0();
        super.r();
    }

    // 去混淆评级： 低(20)
    public final boolean r0() {
        return this.Y(23) && this.P();
    }

    @Override  // b3.S
    public final void release() {
        this.s0();
        ((S)this.b).release();
    }

    @Override  // b3.f
    public final u0 s() {
        this.s0();
        return super.s();
    }

    public final void s0() {
        e3.b.j(Looper.myLooper() == ((S)this.b).getApplicationLooper());
    }

    @Override  // b3.f
    public final void seekTo(int v, long v1) {
        this.s0();
        super.seekTo(v, v1);
    }

    @Override  // b3.f
    public final void seekTo(long v) {
        this.s0();
        super.seekTo(v);
    }

    @Override  // b3.f
    public final void seekToDefaultPosition() {
        this.s0();
        super.seekToDefaultPosition();
    }

    @Override  // b3.f
    public final void seekToDefaultPosition(int v) {
        this.s0();
        super.seekToDefaultPosition(v);
    }

    @Override  // b3.S
    public final void setPlayWhenReady(boolean z) {
        this.s0();
        ((S)this.b).setPlayWhenReady(z);
    }

    @Override  // b3.f
    public final void setPlaybackSpeed(float f) {
        this.s0();
        super.setPlaybackSpeed(f);
    }

    @Override  // b3.f
    public final void setRepeatMode(int v) {
        this.s0();
        super.setRepeatMode(v);
    }

    @Override  // b3.f
    public final void setShuffleModeEnabled(boolean z) {
        this.s0();
        super.setShuffleModeEnabled(z);
    }

    @Override  // b3.f
    public final void setVideoSurface(Surface surface0) {
        this.s0();
        super.setVideoSurface(surface0);
    }

    @Override  // b3.f
    public final void setVolume(float f) {
        this.s0();
        super.setVolume(f);
    }

    @Override  // b3.S
    public final void stop() {
        this.s0();
        ((S)this.b).stop();
    }

    @Override  // b3.f
    public final void t() {
        this.s0();
        super.t();
    }

    @Override  // b3.S
    public final int v() {
        this.s0();
        return ((S)this.b).v();
    }

    @Override  // b3.f
    public final long w() {
        this.s0();
        return ((S)this.b).w();
    }

    @Override  // b3.f
    public final void x(int v, E e0) {
        this.s0();
        super.x(v, e0);
    }

    @Override  // b3.S
    public final N y() {
        this.s0();
        return ((S)this.b).y();
    }

    @Override  // b3.S
    public final long z() {
        this.s0();
        return ((S)this.b).z();
    }
}

