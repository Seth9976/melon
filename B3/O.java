package b3;

import androidx.media3.common.Metadata;
import d3.c;
import java.util.List;

public final class o implements P {
    public final f a;
    public final P b;

    public o(f f0, P p0) {
        this.a = f0;
        this.b = p0;
    }

    @Override  // b3.P
    public final void A0(d d0) {
        this.b.A0(d0);
    }

    @Override  // b3.P
    public final void B0(Metadata metadata0) {
        this.b.B0(metadata0);
    }

    @Override  // b3.P
    public final void D(u0 u00) {
        this.b.D(u00);
    }

    @Override  // b3.P
    public final void G0(long v) {
        this.b.G0(v);
    }

    @Override  // b3.P
    public final void H(int v, boolean z) {
        this.b.H(v, z);
    }

    @Override  // b3.P
    public final void I(long v) {
        this.b.I(v);
    }

    @Override  // b3.P
    public final void J(c c0) {
        this.b.J(c0);
    }

    @Override  // b3.P
    public final void J0(G g0) {
        this.b.J0(g0);
    }

    @Override  // b3.P
    public final void M(S s0, O o0) {
        this.b.M(this.a, o0);
    }

    @Override  // b3.P
    public final void S(boolean z) {
        this.b.S(z);
    }

    @Override  // b3.P
    public final void Y(w0 w00) {
        this.b.Y(w00);
    }

    @Override  // b3.P
    public final void c0(z0 z00) {
        this.b.c0(z00);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof o)) {
            return false;
        }
        return this.a.equals(((o)object0).a) ? this.b.equals(((o)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override  // b3.P
    public final void j0(boolean z) {
        this.b.j0(z);
    }

    @Override  // b3.P
    public final void k0(K k0) {
        this.b.k0(k0);
    }

    @Override  // b3.P
    public final void n(L l0) {
        this.b.n(l0);
    }

    @Override  // b3.P
    public final void n0(N n0) {
        this.b.n0(n0);
    }

    @Override  // b3.P
    public final void o(k k0) {
        this.b.o(k0);
    }

    @Override  // b3.P
    public final void onCues(List list0) {
        this.b.onCues(list0);
    }

    @Override  // b3.P
    public final void onIsPlayingChanged(boolean z) {
        this.b.onIsPlayingChanged(z);
    }

    @Override  // b3.P
    public final void onLoadingChanged(boolean z) {
        this.b.j0(z);
    }

    @Override  // b3.P
    public final void onPlaybackSuppressionReasonChanged(int v) {
        this.b.onPlaybackSuppressionReasonChanged(v);
    }

    @Override  // b3.P
    public final void onPlayerStateChanged(boolean z, int v) {
        this.b.onPlayerStateChanged(z, v);
    }

    @Override  // b3.P
    public final void onPositionDiscontinuity(int v) {
        this.b.onPositionDiscontinuity(v);
    }

    @Override  // b3.P
    public final void onRenderedFirstFrame() {
        this.b.onRenderedFirstFrame();
    }

    @Override  // b3.P
    public final void onRepeatModeChanged(int v) {
        this.b.onRepeatModeChanged(v);
    }

    @Override  // b3.P
    public final void onShuffleModeEnabledChanged(boolean z) {
        this.b.onShuffleModeEnabledChanged(z);
    }

    @Override  // b3.P
    public final void onSurfaceSizeChanged(int v, int v1) {
        this.b.onSurfaceSizeChanged(v, v1);
    }

    @Override  // b3.P
    public final void onVolumeChanged(float f) {
        this.b.onVolumeChanged(f);
    }

    @Override  // b3.P
    public final void p(K k0) {
        this.b.p(k0);
    }

    @Override  // b3.P
    public final void p0(int v, boolean z) {
        this.b.p0(v, z);
    }

    @Override  // b3.P
    public final void r(Q q0, Q q1, int v) {
        this.b.r(q0, q1, v);
    }

    @Override  // b3.P
    public final void s0(p0 p00, int v) {
        this.b.s0(p00, v);
    }

    @Override  // b3.P
    public final void t(int v, E e0) {
        this.b.t(v, e0);
    }

    @Override  // b3.P
    public final void u0(G g0) {
        this.b.u0(g0);
    }

    @Override  // b3.P
    public final void w(int v) {
        this.b.w(v);
    }

    @Override  // b3.P
    public final void z0(long v) {
        this.b.z0(v);
    }
}

