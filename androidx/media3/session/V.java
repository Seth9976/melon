package androidx.media3.session;

import M6.B;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import b3.E;
import b3.G;
import b3.K;
import b3.L;
import b3.N;
import b3.P;
import b3.S;
import b3.k;
import b3.o0;
import b3.o;
import b3.p0;
import b3.u0;
import b3.w0;
import b3.z0;
import d3.c;
import e3.b;
import ea.d;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public final class v implements S {
    public final o0 a;
    public boolean b;
    public final u c;
    public final t d;
    public final Handler e;
    public final long f;
    public boolean g;
    public final x h;

    public v(Context context0, y1 y10, Bundle bundle0, t t0, Looper looper0, x x0, d d0) {
        b.h(context0, "context must not be null");
        Y y0;
        b.h(y10, "token must not be null");
        b.u("MediaController", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.5.1] [" + e3.x.e + "]");
        this.a = new o0();
        this.f = 0x8000000000000001L;
        this.d = t0;
        this.e = new Handler(looper0);
        this.h = x0;
        if(y10.a.e()) {
            d0.getClass();
            y0 = new Y(context0, this, y10, bundle0, looper0, d0);
        }
        else {
            y0 = new Q(context0, this, y10, bundle0, looper0);
        }
        this.c = y0;
        y0.connect();
    }

    @Override  // b3.S
    public final z0 A() {
        this.h0();
        return this.c.isConnected() ? this.c.A() : z0.d;
    }

    @Override  // b3.S
    public final k B() {
        this.h0();
        return this.c.isConnected() ? this.c.B() : k.e;
    }

    @Override  // b3.S
    public final void C(int v, int v1) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setDeviceVolume().");
            return;
        }
        u0.C(v, v1);
    }

    @Override  // b3.S
    public final void D(List list0, int v, long v1) {
        this.h0();
        b.h(list0, "mediaItems must not be null");
        for(int v2 = 0; v2 < list0.size(); ++v2) {
            b.d(list0.get(v2) != null, "items must not contain null, index=" + v2);
        }
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setMediaItems().");
            return;
        }
        u0.D(list0, v, v1);
    }

    @Override  // b3.S
    public final long E() {
        this.h0();
        return this.c.isConnected() ? this.c.E() : 0L;
    }

    @Override  // b3.S
    public final void F(int v, List list0) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring addMediaItems().");
            return;
        }
        u0.F(v, list0);
    }

    @Override  // b3.S
    public final void G(E e0) {
        this.h0();
        b.h(e0, "mediaItems must not be null");
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setMediaItems().");
            return;
        }
        u0.G(e0);
    }

    @Override  // b3.S
    public final void H(P p0) {
        this.c.H(p0);
    }

    @Override  // b3.S
    public final G I() {
        this.h0();
        return this.c.isConnected() ? this.c.I() : G.K;
    }

    @Override  // b3.S
    public final void J(u0 u00) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setTrackSelectionParameters().");
        }
        u0.J(u00);
    }

    @Override  // b3.S
    public final void K(G g0) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setPlaylistMetadata().");
            return;
        }
        u0.K(g0);
    }

    @Override  // b3.S
    public final int L() {
        this.h0();
        return this.c.isConnected() ? this.c.L() : -1;
    }

    @Override  // b3.S
    public final void M(int v, int v1) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring moveMediaItem().");
            return;
        }
        u0.M(v, v1);
    }

    @Override  // b3.S
    public final void N(int v, int v1, int v2) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring moveMediaItems().");
            return;
        }
        u0.N(v, v1, v2);
    }

    @Override  // b3.S
    public final void O(List list0) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring addMediaItems().");
            return;
        }
        u0.O(list0);
    }

    @Override  // b3.S
    public final boolean P() {
        this.h0();
        return this.c.isConnected() ? this.c.P() : false;
    }

    @Override  // b3.S
    public final void Q(int v) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setDeviceVolume().");
            return;
        }
        u0.Q(v);
    }

    @Override  // b3.S
    public final void R() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring seekForward().");
            return;
        }
        u0.R();
    }

    @Override  // b3.S
    public final void S() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring seekBack().");
            return;
        }
        u0.S();
    }

    @Override  // b3.S
    public final G T() {
        this.h0();
        return this.c.isConnected() ? this.c.T() : G.K;
    }

    @Override  // b3.S
    public final void U(List list0) {
        this.h0();
        b.h(list0, "mediaItems must not be null");
        for(int v = 0; v < list0.size(); ++v) {
            b.d(list0.get(v) != null, "items must not contain null, index=" + v);
        }
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setMediaItems().");
            return;
        }
        u0.U(list0);
    }

    @Override  // b3.S
    public final long V() {
        this.h0();
        return this.c.isConnected() ? this.c.V() : 0L;
    }

    @Override  // b3.S
    public final E W() {
        p0 p00 = this.getCurrentTimeline();
        return p00.p() ? null : p00.m(this.L(), this.a, 0L).c;
    }

    @Override  // b3.S
    public final boolean X() {
        return false;
    }

    @Override  // b3.S
    public final boolean Y(int v) {
        return this.y().a(v);
    }

    @Override  // b3.S
    public final boolean Z() {
        this.h0();
        p0 p00 = this.getCurrentTimeline();
        return !p00.p() && p00.m(this.L(), this.a, 0L).i;
    }

    @Override  // b3.S
    public final void a(L l0) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setPlaybackParameters().");
            return;
        }
        u0.a(l0);
    }

    @Override  // b3.S
    public final boolean a0() {
        this.h0();
        p0 p00 = this.getCurrentTimeline();
        return !p00.p() && p00.m(this.L(), this.a, 0L).h;
    }

    @Override  // b3.S
    public final void b() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring clearMediaItems().");
            return;
        }
        u0.b();
    }

    @Override  // b3.S
    public final void b0(P p0) {
        this.h0();
        this.c.Y(((o)p0));
    }

    @Override  // b3.S
    public final void c() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring seekToPreviousMediaItem().");
            return;
        }
        u0.c();
    }

    @Override  // b3.S
    public final boolean c0() {
        this.h0();
        p0 p00 = this.getCurrentTimeline();
        return !p00.p() && p00.m(this.L(), this.a, 0L).a();
    }

    @Override  // b3.S
    public final void d(int v, boolean z) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setDeviceMuted().");
            return;
        }
        u0.d(v, z);
    }

    public final void d0() {
        b.j(Looper.myLooper() == this.e.getLooper());
        b.j(!this.g);
        this.g = true;
        x x0 = this.h;
        x0.j = true;
        v v0 = x0.i;
        if(v0 != null) {
            x0.k(v0);
        }
    }

    @Override  // b3.S
    public final void e() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring decreaseDeviceVolume().");
            return;
        }
        u0.e();
    }

    public static void e0(B b0) {
        v v0;
        if(b0.cancel(false)) {
            return;
        }
        try {
            v0 = (v)com.google.firebase.b.D(b0);
        }
        catch(CancellationException | ExecutionException exception0) {
            b.E("MediaController", "MediaController future failed (so we couldn\'t release it)", exception0);
            return;
        }
        v0.release();
    }

    @Override  // b3.S
    public final void f(int v) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring increaseDeviceVolume().");
            return;
        }
        u0.f(v);
    }

    public final void f0(Runnable runnable0) {
        e3.x.P(this.e, runnable0);
    }

    @Override  // b3.S
    public final void g(E e0, long v) {
        this.h0();
        b.h(e0, "mediaItems must not be null");
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setMediaItem().");
            return;
        }
        u0.g(e0, v);
    }

    public final B g0(s1 s10, Bundle bundle0) {
        this.h0();
        b.h(s10, "command must not be null");
        b.d(s10.a == 0, "command must be a custom command");
        u u0 = this.c;
        return u0.isConnected() ? u0.X(s10, bundle0) : com.google.firebase.b.I(new w1(-100));
    }

    @Override  // b3.S
    public final Looper getApplicationLooper() {
        return this.e.getLooper();
    }

    @Override  // b3.S
    public final b3.d getAudioAttributes() {
        this.h0();
        return this.c.isConnected() ? this.c.getAudioAttributes() : b3.d.g;
    }

    @Override  // b3.S
    public final int getBufferedPercentage() {
        this.h0();
        return this.c.isConnected() ? this.c.getBufferedPercentage() : 0;
    }

    @Override  // b3.S
    public final long getBufferedPosition() {
        this.h0();
        return this.c.isConnected() ? this.c.getBufferedPosition() : 0L;
    }

    @Override  // b3.S
    public final long getContentBufferedPosition() {
        this.h0();
        return this.c.isConnected() ? this.c.getContentBufferedPosition() : 0L;
    }

    @Override  // b3.S
    public final long getContentDuration() {
        this.h0();
        return this.c.isConnected() ? this.c.getContentDuration() : 0x8000000000000001L;
    }

    @Override  // b3.S
    public final long getContentPosition() {
        this.h0();
        return this.c.isConnected() ? this.c.getContentPosition() : 0L;
    }

    @Override  // b3.S
    public final int getCurrentAdGroupIndex() {
        this.h0();
        return this.c.isConnected() ? this.c.getCurrentAdGroupIndex() : -1;
    }

    @Override  // b3.S
    public final int getCurrentAdIndexInAdGroup() {
        this.h0();
        return this.c.isConnected() ? this.c.getCurrentAdIndexInAdGroup() : -1;
    }

    @Override  // b3.S
    public final int getCurrentPeriodIndex() {
        this.h0();
        return this.c.isConnected() ? this.c.getCurrentPeriodIndex() : -1;
    }

    @Override  // b3.S
    public final long getCurrentPosition() {
        this.h0();
        return this.c.isConnected() ? this.c.getCurrentPosition() : 0L;
    }

    @Override  // b3.S
    public final p0 getCurrentTimeline() {
        this.h0();
        u u0 = this.c;
        return u0.isConnected() ? u0.getCurrentTimeline() : p0.a;
    }

    @Override  // b3.S
    public final long getDuration() {
        this.h0();
        return this.c.isConnected() ? this.c.getDuration() : 0x8000000000000001L;
    }

    @Override  // b3.S
    public final boolean getPlayWhenReady() {
        this.h0();
        return this.c.isConnected() && this.c.getPlayWhenReady();
    }

    @Override  // b3.S
    public final L getPlaybackParameters() {
        this.h0();
        return this.c.isConnected() ? this.c.getPlaybackParameters() : L.d;
    }

    @Override  // b3.S
    public final int getPlaybackState() {
        this.h0();
        return this.c.isConnected() ? this.c.getPlaybackState() : 1;
    }

    @Override  // b3.S
    public final int getPlaybackSuppressionReason() {
        this.h0();
        return this.c.isConnected() ? this.c.getPlaybackSuppressionReason() : 0;
    }

    @Override  // b3.S
    public final int getRepeatMode() {
        this.h0();
        return this.c.isConnected() ? this.c.getRepeatMode() : 0;
    }

    @Override  // b3.S
    public final boolean getShuffleModeEnabled() {
        this.h0();
        return this.c.isConnected() && this.c.getShuffleModeEnabled();
    }

    @Override  // b3.S
    public final long getTotalBufferedDuration() {
        this.h0();
        return this.c.isConnected() ? this.c.getTotalBufferedDuration() : 0L;
    }

    @Override  // b3.S
    public final float getVolume() {
        this.h0();
        return this.c.isConnected() ? this.c.getVolume() : 1.0f;
    }

    @Override  // b3.S
    public final void h(int v, int v1, List list0) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring replaceMediaItems().");
            return;
        }
        u0.h(v, v1, list0);
    }

    public final void h0() {
        b.i("MediaController method is called from a wrong thread. See javadoc of MediaController for details.", Looper.myLooper() == this.e.getLooper());
    }

    @Override  // b3.S
    public final void i(int v) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring removeMediaItem().");
            return;
        }
        u0.i(v);
    }

    @Override  // b3.S
    public final boolean isLoading() {
        this.h0();
        return this.c.isConnected() && this.c.isLoading();
    }

    @Override  // b3.S
    public final boolean isPlaying() {
        this.h0();
        return this.c.isConnected() && this.c.isPlaying();
    }

    @Override  // b3.S
    public final boolean isPlayingAd() {
        this.h0();
        return this.c.isConnected() && this.c.isPlayingAd();
    }

    @Override  // b3.S
    public final void j(int v, int v1) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring removeMediaItems().");
            return;
        }
        u0.j(v, v1);
    }

    @Override  // b3.S
    public final void k() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring seekToPrevious().");
            return;
        }
        u0.k();
    }

    @Override  // b3.S
    public final K l() {
        this.h0();
        return this.c.isConnected() ? this.c.l() : null;
    }

    @Override  // b3.S
    public final void m() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring seekToNextMediaItem().");
            return;
        }
        u0.m();
    }

    @Override  // b3.S
    public final void n(int v) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring decreaseDeviceVolume().");
            return;
        }
        u0.n(v);
    }

    @Override  // b3.S
    public final w0 o() {
        this.h0();
        return this.c.isConnected() ? this.c.o() : w0.b;
    }

    @Override  // b3.S
    public final c p() {
        this.h0();
        return this.c.isConnected() ? this.c.p() : c.c;
    }

    @Override  // b3.S
    public final void pause() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring pause().");
            return;
        }
        u0.pause();
    }

    @Override  // b3.S
    public final void play() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring play().");
            return;
        }
        u0.play();
    }

    @Override  // b3.S
    public final void prepare() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring prepare().");
            return;
        }
        u0.prepare();
    }

    @Override  // b3.S
    public final void q(boolean z) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setDeviceMuted().");
            return;
        }
        u0.q(z);
    }

    @Override  // b3.S
    public final void r() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring increaseDeviceVolume().");
            return;
        }
        u0.r();
    }

    @Override  // b3.S
    public final void release() {
        Handler handler0 = this.e;
        this.h0();
        if(!this.b) {
            b.u("MediaController", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.5.1] [" + e3.x.e + "] [" + "media3.common" + "]");
            boolean z = true;
            this.b = true;
            handler0.removeCallbacksAndMessages(null);
            try {
                this.c.release();
            }
            catch(Exception exception0) {
                b.n(exception0, "MediaController", "Exception while releasing impl");
            }
            if(this.g) {
                if(Looper.myLooper() != handler0.getLooper()) {
                    z = false;
                }
                b.j(z);
                this.d.d();
                return;
            }
            this.g = true;
            this.h.getClass();
            SecurityException securityException0 = new SecurityException("Session rejected the connection request.");
            this.h.l(securityException0);
        }
    }

    @Override  // b3.S
    public final u0 s() {
        this.h0();
        return this.c.isConnected() ? this.c.s() : u0.C;
    }

    @Override  // b3.S
    public final void seekTo(int v, long v1) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring seekTo().");
            return;
        }
        u0.seekTo(v, v1);
    }

    @Override  // b3.S
    public final void seekTo(long v) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring seekTo().");
            return;
        }
        u0.seekTo(v);
    }

    @Override  // b3.S
    public final void seekToDefaultPosition() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring seekTo().");
            return;
        }
        u0.seekToDefaultPosition();
    }

    @Override  // b3.S
    public final void seekToDefaultPosition(int v) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring seekTo().");
            return;
        }
        u0.seekToDefaultPosition(v);
    }

    @Override  // b3.S
    public final void setPlayWhenReady(boolean z) {
        this.h0();
        u u0 = this.c;
        if(u0.isConnected()) {
            u0.setPlayWhenReady(z);
        }
    }

    @Override  // b3.S
    public final void setPlaybackSpeed(float f) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setPlaybackSpeed().");
            return;
        }
        u0.setPlaybackSpeed(f);
    }

    @Override  // b3.S
    public final void setRepeatMode(int v) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setRepeatMode().");
            return;
        }
        u0.setRepeatMode(v);
    }

    @Override  // b3.S
    public final void setShuffleModeEnabled(boolean z) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setShuffleMode().");
            return;
        }
        u0.setShuffleModeEnabled(z);
    }

    @Override  // b3.S
    public final void setVideoSurface(Surface surface0) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setVideoSurface().");
            return;
        }
        u0.setVideoSurface(surface0);
    }

    @Override  // b3.S
    public final void setVolume(float f) {
        this.h0();
        b.d(f >= 0.0f && f <= 1.0f, "volume must be between 0 and 1");
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setVolume().");
            return;
        }
        u0.setVolume(f);
    }

    @Override  // b3.S
    public final void stop() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring stop().");
            return;
        }
        u0.stop();
    }

    @Override  // b3.S
    public final void t() {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring seekToNext().");
            return;
        }
        u0.t();
    }

    @Override  // b3.S
    public final void u(b3.d d0, boolean z) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring setAudioAttributes().");
            return;
        }
        u0.u(d0, z);
    }

    @Override  // b3.S
    public final int v() {
        this.h0();
        return this.c.isConnected() ? this.c.v() : 0;
    }

    @Override  // b3.S
    public final long w() {
        this.h0();
        return this.c.isConnected() ? this.c.w() : 0x8000000000000001L;
    }

    @Override  // b3.S
    public final void x(int v, E e0) {
        this.h0();
        u u0 = this.c;
        if(!u0.isConnected()) {
            b.D("MediaController", "The controller is not connected. Ignoring replaceMediaItem().");
            return;
        }
        u0.x(v, e0);
    }

    @Override  // b3.S
    public final N y() {
        this.h0();
        return this.c.isConnected() ? this.c.y() : N.b;
    }

    @Override  // b3.S
    public final long z() {
        this.h0();
        return this.c.isConnected() ? this.c.z() : 0L;
    }
}

