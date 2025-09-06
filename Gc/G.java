package gc;

import B3.o;
import Bf.a;
import Nb.w0;
import Nb.z0;
import Nf.p;
import U4.F;
import Yb.t;
import android.app.Service;
import android.net.Uri;
import androidx.media3.datasource.DefaultDataSource.Factory;
import androidx.media3.exoplayer.B;
import androidx.media3.exoplayer.ExoPlayer.Builder;
import androidx.media3.exoplayer.hls.HlsMediaSource.Factory;
import androidx.media3.exoplayer.m;
import b3.E;
import b3.K;
import b3.P;
import b3.d;
import com.iloen.melon.custom.S0;
import com.iloen.melon.mcache.MelonStreamCacheManager;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.melon.playback.cache.CacheDataSource.Factory;
import e3.b;
import e3.x;
import hc.s;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.q;

public final class g extends a implements P {
    public final Service b;
    public final LogU c;
    public final w0 d;
    public final B e;
    public final AtomicBoolean f;
    public final AtomicBoolean g;
    public final AtomicReference h;

    public g(S0 s00, Service service0) {
        super(s00);
        this.b = service0;
        this.c = Companion.create$default(LogU.Companion, "ExoMusicPlayer", false, Category.Playback, 2, null);
        this.d = w0.b;
        ExoPlayer.Builder exoPlayer$Builder0 = new ExoPlayer.Builder(service0, new m(new f(service0), 0), new m(service0, 1));  // 初始化器: Landroidx/media3/exoplayer/DefaultRenderersFactory;-><init>(Landroid/content/Context;)V
        d d0 = new d(2, 0, 1, 1, 0);
        b.j(!exoPlayer$Builder0.w);
        exoPlayer$Builder0.k = d0;
        b.j(!exoPlayer$Builder0.w);
        exoPlayer$Builder0.l = true;
        b.j(!exoPlayer$Builder0.w);
        exoPlayer$Builder0.w = true;
        B b0 = new B(exoPlayer$Builder0);
        b0.m.a(this);
        this.e = b0;
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.h = new AtomicReference(E.g);
    }

    @Override  // Bf.a
    public final E X0() {
        Object object0 = this.h.get();
        q.f(object0, "get(...)");
        return (E)object0;
    }

    @Override  // Bf.a
    public final long Y0() {
        return this.e.getDuration();
    }

    @Override  // Bf.a
    public final z0 a1() {
        return this.d;
    }

    @Override  // Bf.a
    public final long b1() {
        return this.e.getContentPosition();
    }

    @Override  // Bf.a
    public final void j1() {
        this.e.setPlayWhenReady(false);
    }

    @Override  // b3.P
    public final void k0(K k0) {
        q.g(k0, "error");
        String s = k0.b();
        LogU.error$default(this.c, "onPlayerError() error: " + k0 + ", errorCode: " + s, null, false, 6, null);
        S0 s00 = (S0)this.a;
        String s1 = this.b.getString((k0.a == 2000 ? 0x7F1303EB : 0x7F1303E9));  // string:error_player_exoplayer_source "플레이어에서 재생 시도 중 문제가 발생했습니다.\n잠시 후 다시 시도해 주세요."
        q.f(s1, "getString(...)");
        s00.e0(this, new t(s1, k0), "ExoMusicPlayer Error");
    }

    @Override  // Bf.a
    public final void k1() {
        this.e.setPlayWhenReady(true);
    }

    @Override  // Bf.a
    public final void l1() {
        this.e.release();
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("AudioEffectController", "release");
        if(y8.a.b != null && y8.a.b.l.compareAndSet(true, false)) {
            logU$Companion0.d("[GaudioSolMusicOne] ", "destroyCore");
        }
    }

    @Override  // Bf.a
    public final void m1(long v) {
        if(this.g.compareAndSet(false, true)) {
            this.e.i0(5, v);
        }
    }

    @Override  // Bf.a
    public final void n1(Uri uri0, E e0, s s0) {
        DefaultDataSource.Factory defaultDataSource$Factory0;
        HlsMediaSource.Factory hlsMediaSource$Factory0;
        q.g(uri0, "uri");
        q.g(e0, "mediaItem");
        LogU logU0 = this.c;
        LogConstantsKt.infoOnlyDebugMode(logU0, "setDataSource() uri: " + uri0);
        this.h.set(e0);
        this.f.set(true);
        this.g.set(false);
        int v = x.F(uri0);
        Service service0 = this.b;
        switch(v) {
            case 2: {
                LogConstantsKt.debugOnlyDebugMode(logU0, "buildMediaSource() Use HlsMediaSource");
                A3.g g0 = new A3.g(7, 0);
                g0.e = F.y(service0);
                hlsMediaSource$Factory0 = new HlsMediaSource.Factory(new DefaultDataSource.Factory(service0, g0));
                break;
            }
            case 4: {
                MelonStreamCacheManager melonStreamCacheManager0 = MelonStreamCacheManager.getInstance();
                q.f(melonStreamCacheManager0, "getInstance(...)");
                if(!melonStreamCacheManager0.isMelonStreamCacheUri(uri0) || !MelonSettingInfo.getMcacheNewLogicEnable()) {
                    LogConstantsKt.debugOnlyDebugMode(logU0, "buildMediaSource() Use DefaultDataSource");
                    A3.g g1 = new A3.g(7, 0);
                    g1.e = F.y(service0);
                    defaultDataSource$Factory0 = new DefaultDataSource.Factory(service0, g1);
                }
                else {
                    LogConstantsKt.debugOnlyDebugMode(logU0, "buildMediaSource() Use CacheDataSource");
                    defaultDataSource$Factory0 = new Factory(service0);
                }
                hlsMediaSource$Factory0 = new s3.P(defaultDataSource$Factory0, new o());
                hlsMediaSource$Factory0.d = new p(0);
                break;
            }
            default: {
                q.f("플레이어에서 재생 시도 중 문제가 발생했습니다.\n잠시 후 다시 시도해 주세요.", "getString(...)");
                throw new Sb.b("플레이어에서 재생 시도 중 문제가 발생했습니다.\n잠시 후 다시 시도해 주세요.", new IllegalStateException("buildMediaSource() Unsupported content type: " + v));
            }
        }
        s3.a a0 = hlsMediaSource$Factory0.c(E.c(uri0));
        q.f(a0, "createMediaSource(...)");
        this.e.H0();
        List list0 = Collections.singletonList(a0);
        this.e.H0();
        this.e.H0();
        this.e.A0(list0, -1, 0x8000000000000001L, true);
        this.e.prepare();
    }

    @Override  // Bf.a
    public final void o1(float f) {
        this.e.setVolume(f);
    }

    @Override  // Bf.a
    public final void p1() {
        this.h.set(E.g);
        this.g.set(false);
        this.e.stop();
    }

    @Override  // b3.P
    public final void w(int v) {
        S0 s00 = (S0)this.a;
        LogConstantsKt.debugOnlyDebugMode(this.c, "onPlaybackStateChanged() " + F.a0(v));
        AtomicReference atomicReference0 = this.h;
        if(v != 1) {
            AtomicBoolean atomicBoolean0 = this.f;
            switch(v) {
                case 2: {
                    if(!atomicBoolean0.get()) {
                        s00.c0(this, true);
                        return;
                    }
                    break;
                }
                case 3: {
                    if(!q.b(atomicReference0.get(), E.g)) {
                        if(atomicBoolean0.compareAndSet(true, false)) {
                            s00.f0(this);
                            return;
                        }
                        if(this.g.compareAndSet(true, false)) {
                            s00.g0(this);
                            return;
                        }
                        s00.c0(this, false);
                        return;
                    }
                    break;
                }
                case 4: {
                    s00.d0(this);
                    return;
                }
                default: {
                    return;
                }
            }
            return;
        }
        atomicReference0.set(E.g);
    }
}

