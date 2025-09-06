package gc;

import A9.f;
import Bf.a;
import Nb.x0;
import Nb.z0;
import android.app.Service;
import android.net.Uri;
import b3.E;
import com.iloen.melon.custom.S0;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.LeonPlayerHelper;
import com.iloen.melon.utils.player.LeonPlayerHelperKt;
import com.kakaoent.leonplayer.core.LeonPlayer;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener;
import hc.s;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.q;

public final class l extends a implements G {
    public final LogU b;
    public final x0 c;
    public final AtomicBoolean d;
    public final LeonPlayerEventListener[] e;
    public final LeonPlayer f;
    public final AtomicReference g;

    public l(S0 s00, Service service0) {
        super(s00);
        this.b = Companion.create$default(LogU.Companion, "LeonVideoPlayer", false, Category.Playback, 2, null);
        this.c = x0.b;
        this.d = new AtomicBoolean(false);
        LeonPlayerEventListener[] arr_leonPlayerEventListener = {new h(this, s00, service0), new i(s00, this), new j(this), new k(s00, this)};
        this.e = arr_leonPlayerEventListener;
        LeonPlayer leonPlayer0 = LeonPlayer.Companion.create(service0);
        leonPlayer0.addPlayerEventListeners(((LeonPlayerEventListener[])Arrays.copyOf(arr_leonPlayerEventListener, 4)));
        this.f = leonPlayer0;
        this.g = new AtomicReference(E.g);
    }

    @Override  // Bf.a
    public final E X0() {
        Object object0 = this.g.get();
        q.f(object0, "get(...)");
        return (E)object0;
    }

    @Override  // Bf.a
    public final long Y0() {
        return (long)this.f.getCurrentTime().getDuration();
    }

    @Override  // Bf.a
    public final z0 a1() {
        return this.c;
    }

    @Override  // Bf.a
    public final long b1() {
        return (long)this.f.getCurrentTime().getPosition();
    }

    @Override  // Bf.a
    public final void j1() {
        this.f.pause();
    }

    @Override  // Bf.a
    public final void k1() {
        this.f.play();
    }

    @Override  // Bf.a
    public final void l1() {
        LeonPlayerEventListener[] arr_leonPlayerEventListener = (LeonPlayerEventListener[])Arrays.copyOf(this.e, this.e.length);
        this.f.removePlayerEventListeners(arr_leonPlayerEventListener);
        this.f.releasePlayer();
        f.a("release() Released Player");
    }

    @Override  // Bf.a
    public final void m1(long v) {
        this.f.seek(((int)v));
    }

    @Override  // Bf.a
    public final void n1(Uri uri0, E e0, s s0) {
        q.g(uri0, "uri");
        q.g(e0, "mediaItem");
        LogConstantsKt.infoOnlyDebugMode(this.b, "setDataSource() uri: " + uri0);
        this.g.set(e0);
        this.d.set(true);
        String s1 = uri0.toString();
        q.f(s1, "toString(...)");
        boolean z = LeonPlayerHelper.isAvailableLiveItem(s1);
        LeonPlayer leonPlayer0 = this.f;
        if(z) {
            String s2 = uri0.toString();
            q.f(s2, "toString(...)");
            leonPlayer0.configure(s2);
        }
        else {
            leonPlayer0.configure(LeonPlayerHelperKt.toConfiguration(uri0));
        }
        leonPlayer0.prepare();
    }

    @Override  // Bf.a
    public final void o1(float f) {
        this.f.setVolume(f);
    }

    @Override  // Bf.a
    public final void p1() {
        this.f.reset();
    }
}

