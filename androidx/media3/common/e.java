package androidx.media3.common;

import A3.l;
import Cb.i;
import H6.k;
import H8.p;
import M6.x;
import Nb.t0;
import Nb.x0;
import U4.F;
import Vb.V;
import Vb.h0;
import X5.g;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.appcompat.app.o;
import androidx.media3.exoplayer.u;
import androidx.media3.exoplayer.v;
import androidx.media3.session.a0;
import androidx.media3.session.w;
import b3.E;
import b3.G;
import b3.K;
import b3.L;
import b3.N;
import b3.P;
import b3.Q;
import b3.U;
import b3.W;
import b3.X;
import b3.Z;
import b3.b0;
import b3.d;
import b3.e0;
import b3.f0;
import b3.f;
import b3.i0;
import b3.m0;
import b3.o0;
import b3.p0;
import b3.u0;
import b3.w0;
import b3.z0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.EpPlayLogger;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import d3.c;
import e3.b;
import e3.m;
import e3.r;
import e3.t;
import gc.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.MutableStateFlow;

public abstract class e extends f {
    public final m c;
    public final Looper d;
    public final t e;
    public final HashSet f;
    public final m0 g;
    public i0 h;
    public boolean i;

    public e(Looper looper0) {
        this.d = looper0;
        this.e = r.a.a(looper0, null);
        this.f = new HashSet();
        this.g = new m0();
        a0 a00 = new a0(this, 9);
        this.c = new m(looper0, r.a, a00);
    }

    @Override  // b3.f
    public final z0 A() {
        this.C0();
        return this.h.n;
    }

    public final void A0(k k0, boolean z, boolean z1) {
        x x0 = x.b;
        HashSet hashSet0 = this.f;
        if(hashSet0.isEmpty()) {
            this.z0(this.s0(), z, z1);
            return;
        }
        hashSet0.add(x0);
        this.z0(((i0)k0.get()), z, z1);
        x0.addListener(new l(this), new w(this, 1));
    }

    @Override  // b3.S
    public final b3.k B() {
        this.C0();
        return this.h.p;
    }

    public final void B0() {
        Looper looper0 = this.d;
        if(Thread.currentThread() != looper0.getThread()) {
            throw new IllegalStateException(Y.k("Player is accessed on the wrong thread.\nCurrent thread: \'", "jeb-dexdec-sb-st-973", "\'\nExpected thread: \'", looper0.getThread().getName(), "\'\n"));
        }
    }

    @Override  // b3.f
    public final void C(int v, int v1) {
        this.C0();
        if(this.y0(33)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_SET_DEVICE_VOLUME or COMMAND_SET_DEVICE_VOLUME_WITH_FLAGS");
        }
    }

    public final void C0() {
        this.B0();
        if(this.h == null) {
            this.h = this.s0();
        }
    }

    @Override  // b3.S
    public final void D(List list0, int v, long v1) {
        this.C0();
        if(v == -1) {
            v = this.h.x;
            v1 = this.h.A.get();
        }
        this.x0(list0, v, v1);
    }

    @Override  // b3.S
    public final long E() {
        this.C0();
        return this.h.h;
    }

    @Override  // b3.S
    public final void F(int v, List list0) {
        this.C0();
        b.c(v >= 0);
        i0 i00 = this.h;
        int v1 = i00.t.o();
        if(this.y0(20) && !list0.isEmpty()) {
            this.A0(new X(this, i00, list0, Math.min(v, v1)), false, false);
        }
    }

    @Override  // b3.S
    public final void H(P p0) {
        p0.getClass();
        this.c.a(p0);
    }

    @Override  // b3.S
    public final G I() {
        this.C0();
        return this.h.w;
    }

    @Override  // b3.f
    public final void J(u0 u00) {
        this.C0();
        if(this.y0(29)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_SET_TRACK_SELECTION_PARAMETERS");
        }
    }

    @Override  // b3.f
    public final void K(G g0) {
        this.C0();
        if(this.y0(19)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_SET_PLAYLIST_METADATA");
        }
    }

    @Override  // b3.S
    public final int L() {
        this.C0();
        int v = this.h.x;
        return v == -1 ? 0 : v;
    }

    @Override  // b3.S
    public final void N(int v, int v1, int v2) {
        this.C0();
        b.c(v >= 0 && v1 >= v && v2 >= 0);
        i0 i00 = this.h;
        int v3 = i00.t.o();
        if(this.y0(20) && v3 != 0 && v < v3) {
            int v4 = Math.min(v1, v3);
            int v5 = Math.min(v2, v3 - (v4 - v));
            if(v != v4 && v5 != v) {
                x x0 = x.b;
                HashSet hashSet0 = this.f;
                if(hashSet0.isEmpty()) {
                    this.z0(this.s0(), false, false);
                    return;
                }
                hashSet0.add(x0);
                ArrayList arrayList0 = e.k0(i00, this.g, ((o0)this.b));
                e3.x.L(v, v4, v5, arrayList0);
                this.z0(e.t0(i00, arrayList0, this.g, ((o0)this.b)), false, false);
                x0.addListener(new l(this), new w(this, 1));
            }
        }
    }

    @Override  // b3.f
    public final boolean P() {
        this.C0();
        this.h.getClass();
        return false;
    }

    @Override  // b3.f
    public final void Q(int v) {
        this.C0();
        if(this.y0(25)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_SET_DEVICE_VOLUME or COMMAND_SET_DEVICE_VOLUME_WITH_FLAGS");
        }
    }

    @Override  // b3.S
    public final G T() {
        this.C0();
        return this.h.v;
    }

    @Override  // b3.S
    public final void U(List list0) {
        this.C0();
        this.x0(list0, -1, 0x8000000000000001L);
    }

    @Override  // b3.S
    public final long V() {
        this.C0();
        return this.h.g;
    }

    @Override  // b3.S
    public final void a(L l0) {
        this.C0();
        if(this.y0(13)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_SET_SPEED_AND_PITCH");
        }
    }

    @Override  // b3.f
    public final void b0(P p0) {
        this.C0();
        this.c.e(p0);
    }

    @Override  // b3.f
    public final void d(int v, boolean z) {
        this.C0();
        if(this.y0(34)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME or COMMAND_ADJUST_DEVICE_VOLUME_WITH_FLAGS");
        }
    }

    @Override  // b3.f
    public final void e() {
        this.C0();
        if(this.y0(26)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME or COMMAND_ADJUST_DEVICE_VOLUME_WITH_FLAGS");
        }
    }

    @Override  // b3.f
    public final void f(int v) {
        this.C0();
        if(this.y0(34)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME or COMMAND_ADJUST_DEVICE_VOLUME_WITH_FLAGS");
        }
    }

    @Override  // b3.f
    public final Looper getApplicationLooper() {
        return this.d;
    }

    @Override  // b3.S
    public final d getAudioAttributes() {
        this.C0();
        return this.h.l;
    }

    @Override  // b3.f
    public final long getBufferedPosition() {
        this.C0();
        return this.isPlayingAd() ? Math.max(this.h.D.get(), this.h.B.get()) : this.getContentBufferedPosition();
    }

    @Override  // b3.f
    public final long getContentBufferedPosition() {
        this.C0();
        long v = e.r0(this.h.C.a, this.h, ((o0)this.b));
        i0 i00 = this.h;
        return Math.max(v, e.r0(i00.A.get(), i00, ((o0)this.b)));
    }

    @Override  // b3.f
    public final long getContentPosition() {
        this.C0();
        i0 i00 = this.h;
        return e.r0(i00.A.get(), i00, ((o0)this.b));
    }

    @Override  // b3.S
    public final int getCurrentAdGroupIndex() {
        this.C0();
        return this.h.y;
    }

    @Override  // b3.S
    public final int getCurrentAdIndexInAdGroup() {
        this.C0();
        return this.h.z;
    }

    @Override  // b3.f
    public final int getCurrentPeriodIndex() {
        this.C0();
        return e.m0(this.h, this.g, ((o0)this.b));
    }

    @Override  // b3.S
    public final long getCurrentPosition() {
        this.C0();
        return this.isPlayingAd() ? this.h.B.get() : this.getContentPosition();
    }

    @Override  // b3.S
    public final p0 getCurrentTimeline() {
        this.C0();
        return this.h.t;
    }

    @Override  // b3.f
    public final long getDuration() {
        this.C0();
        if(this.isPlayingAd()) {
            this.h.t.f(this.getCurrentPeriodIndex(), this.g, false);
            return e3.x.Z(this.g.a(this.h.y, this.h.z));
        }
        return this.getContentDuration();
    }

    @Override  // b3.S
    public final boolean getPlayWhenReady() {
        this.C0();
        return this.h.b;
    }

    @Override  // b3.S
    public final L getPlaybackParameters() {
        this.C0();
        return this.h.j;
    }

    @Override  // b3.S
    public final int getPlaybackState() {
        this.C0();
        return this.h.d;
    }

    @Override  // b3.S
    public final int getPlaybackSuppressionReason() {
        this.C0();
        this.h.getClass();
        return 0;
    }

    @Override  // b3.S
    public final int getRepeatMode() {
        this.C0();
        return this.h.f;
    }

    @Override  // b3.S
    public final boolean getShuffleModeEnabled() {
        this.C0();
        this.h.getClass();
        return false;
    }

    @Override  // b3.S
    public final long getTotalBufferedDuration() {
        this.C0();
        return this.h.E.a;
    }

    @Override  // b3.f
    public final float getVolume() {
        this.C0();
        return this.h.m;
    }

    @Override  // b3.S
    public final void h(int v, int v1, List list0) {
        this.C0();
        b.c(v >= 0 && v <= v1);
        i0 i00 = this.h;
        int v2 = i00.t.o();
        if(this.y0(20) && v <= v2) {
            q.g(list0, "mediaItems");
            this.A0(new b3.Y(this, i00, list0, Math.min(v1, v2), v), false, false);
        }
    }

    @Override  // b3.f
    public final void h0(int v, int v1, long v2, boolean z) {
        this.C0();
        int v3 = -1;
        b.c(v == -1 || v >= 0);
        i0 i00 = this.h;
        if(!this.y0(v1)) {
            return;
        }
        int v4 = v == -1 || this.isPlayingAd() || !i00.t.p() && v >= i00.t.o() ? 1 : 0;
        LogConstantsKt.buildDebug$default(((Vb.o0)this).e1(), false, new p(v, v1, 1, v2), 1, null);
        if(!Td.b.c(((Vb.o0)this).j)) {
            ToastManager.show(Z.m(MelonAppBase.Companion, 0x7F1307ED, "getString(...)"));  // string:permission_alert_widget_popup_body_contact_and_storage "멜론 앱 사용을 위해서\n앱정보>권한 
                                                                                           // 승인 후 이용해주세요."
            y.K0(((Vb.o0)this), false, 0, null, null, 15);
        }
        else if(((Vb.o0)this).D0().e() && !((Vb.o0)this).D0().f()) {
            if(v1 == 7) {
                v3 = 7;
            }
            else if(v1 == 9 || v1 == 11 || v1 == 12) {
                v3 = 9;
            }
            LogConstantsKt.debugOnlyDebugMode(((Vb.o0)this).e1(), "handleSeek() latestSeekCommand: " + F.Z(v3));
            ((Vb.o0)this).N.set(v3);
            h0 h00 = ((Vb.o0)this).W;
            CoroutineDispatcher coroutineDispatcher0 = ((Vb.o0)this).v;
            switch(v1) {
                case 4: {
                    StringBuilder stringBuilder0 = Y.p("handleSeek()");
                    i.a(stringBuilder0, "mediaItemIndex: " + v);
                    i.a(stringBuilder0, "positionMs: " + v2);
                    i.a(stringBuilder0, "seekCommand: COMMAND_SEEK_TO_DEFAULT_POSITION");
                    i.a(stringBuilder0, "nextItemIndex: " + ((Vb.o0)this).d0());
                    LogConstantsKt.infoOnlyDebugMode(((Vb.o0)this).l, stringBuilder0.toString());
                    ((Vb.o0)this).p1(v, (((Vb.o0)this).getPlaybackState() == 4 ? ((Vb.o0)this).getContentPosition() : v2));
                    break;
                }
                case 5: {
                    ((Vb.o0)this).l1(v, 5, v2);
                    break;
                }
                case 6: {
                    ((Vb.o0)this).m1(v, 6, v2);
                    break;
                }
                case 7: {
                    if(v != ((Vb.o0)this).L()) {
                        ((Vb.o0)this).m1(v, 7, v2);
                    }
                    else if(((Vb.o0)this).getContentPosition() < ((Vb.o0)this).z()) {
                        ((Vb.o0)this).m1(v, 7, v2);
                    }
                    else {
                        ((Vb.o0)this).p1(v, v2);
                    }
                    break;
                }
                case 8: 
                case 9: {
                    LogConstantsKt.buildDebug$default(((Vb.o0)this).e1(), false, new p(v, v1, 3, v2), 1, null);
                    me.i i0 = coroutineDispatcher0.plus(h00);
                    Vb.Y y0 = new Vb.Y(((Vb.o0)this), null);
                    BuildersKt__Builders_commonKt.launch$default(((Vb.o0)this).u, i0, null, y0, 2, null);
                    break;
                }
                case 10: {
                    LogConstantsKt.buildDebug$default(((Vb.o0)this).e1(), false, new p(v, 10, 2, v2), 1, null);
                    me.i i1 = coroutineDispatcher0.plus(h00);
                    Vb.X x0 = new Vb.X(((Vb.o0)this), v, v2, null);
                    BuildersKt__Builders_commonKt.launch$default(((Vb.o0)this).u, i1, null, x0, 2, null);
                    break;
                }
                case 11: {
                    ((Vb.o0)this).l1(v, 11, v2);
                    break;
                }
                case 12: {
                    ((Vb.o0)this).l1(v, 12, v2);
                    break;
                }
                default: {
                    LogU.warn$default(((Vb.o0)this).e1(), "handleSeek() Unknown command: " + v1, null, false, 6, null);
                }
            }
        }
        else {
            ToastManager.show(Z.m(MelonAppBase.Companion, 0x7F130796, "getString(...)"));  // string:not_play_on_busy "통화중에는 재생할 수 없습니다."
        }
        x x1 = x.b;
        HashSet hashSet0 = this.f;
        if(hashSet0.isEmpty()) {
            this.z0(this.s0(), ((boolean)(v4 ^ 1)), z);
            return;
        }
        hashSet0.add(x1);
        this.z0((v4 == 0 ? e.u0(i00, null, v, v2, ((o0)this.b)) : i00), ((boolean)(v4 ^ 1)), z);
        x1.addListener(new l(this), new w(this, 1));
    }

    @Override  // b3.S
    public final boolean isLoading() {
        this.C0();
        this.h.getClass();
        return false;
    }

    @Override  // b3.S
    public final boolean isPlayingAd() {
        this.C0();
        return this.h.y != -1;
    }

    @Override  // b3.S
    public final void j(int v, int v1) {
        this.C0();
        b.c(v >= 0 && v1 >= v);
        i0 i00 = this.h;
        int v2 = i00.t.o();
        if(this.y0(20) && v2 != 0 && v < v2) {
            int v3 = Math.min(v1, v2);
            if(v != v3) {
                x x0 = x.b;
                HashSet hashSet0 = this.f;
                if(hashSet0.isEmpty()) {
                    this.z0(this.s0(), false, false);
                    return;
                }
                hashSet0.add(x0);
                ArrayList arrayList0 = e.k0(i00, this.g, ((o0)this.b));
                e3.x.Q(arrayList0, v, v3);
                this.z0(e.t0(i00, arrayList0, this.g, ((o0)this.b)), false, false);
                x0.addListener(new l(this), new w(this, 1));
            }
        }
    }

    public static ArrayList k0(i0 i00, m0 m00, o0 o00) {
        p0 p00 = i00.t;
        if(p00 instanceof f0) {
            return new ArrayList(((f0)p00).e);
        }
        ArrayList arrayList0 = new ArrayList(p00.o());
        for(int v = 0; v < p00.o(); ++v) {
            arrayList0.add(b0.a(i00, v, m00, o00));
        }
        return arrayList0;
    }

    @Override  // b3.S
    public final K l() {
        this.C0();
        return this.h.e;
    }

    public static i0 l0(androidx.media3.common.d d0, i0 i00, long v, p0 p00, int v1, long v2, boolean z, o0 o00) {
        long v4;
        long v3 = e.r0(v, i00, o00);
        if(p00.p() || v1 != -1 && v1 < p00.o()) {
            v4 = v2;
        }
        else {
            v4 = 0x8000000000000001L;
            v1 = 0;
        }
        if(!p00.p() && v4 == 0x8000000000000001L) {
            v4 = e3.x.Z(p00.m(v1, o00, 0L).l);
        }
        g g0 = i00.C;
        boolean z1 = i00.t.p() || p00.p();
        boolean z2 = !z1 && !i00.t.m((i00.x == -1 ? 0 : i00.x), o00, 0L).a.equals(p00.m(v1, o00, 0L).a);
        if(p00.p()) {
            d0.t = null;
            d0.u = p00;
            d0.v = w0.b;
            d0.w = null;
        }
        else if(p00 instanceof f0) {
            b0 b00 = (b0)((f0)p00).e.get(v1);
            d0.t = null;
            d0.u = p00;
            d0.v = b00.b;
            d0.w = b00.d;
        }
        else {
            boolean z3 = !z1 && !z2;
            d0.t = null;
            d0.u = p00;
            d0.v = z3 ? i00.u : w0.b;
            d0.w = z3 ? i00.v : null;
        }
        if(!z1 && !z2) {
            int v5 = Long.compare(v4, v3);
            if(v5 >= 0) {
                if(v5 == 0) {
                    d0.y = v1;
                    if(i00.y != -1 && z) {
                        d0.G = new g(i00.D.get() - i00.B.get());
                        return new i0(d0);
                    }
                    d0.a();
                    d0.G = new g(e.r0(g0.a, i00, o00) - v3);
                    return new i0(d0);
                }
                long v6 = Math.max(e.r0(g0.a, i00, o00), v4);
                d0.y = v1;
                d0.a();
                d0.B = v4;
                d0.E = new g(v6);
                d0.G = new g(Math.max(0L, i00.E.a - (v4 - v3)));
                return new i0(d0);
            }
        }
        d0.y = v1;
        d0.a();
        d0.B = v4;
        d0.E = new g(v4);
        d0.G = b3.h0.F;
        return new i0(d0);
    }

    public static int m0(i0 i00, m0 m00, o0 o00) {
        int v = i00.x == -1 ? 0 : i00.x;
        if(i00.t.p()) {
            return v;
        }
        long v1 = e3.x.M(e.r0(i00.A.get(), i00, o00));
        Pair pair0 = i00.t.i(o00, m00, v, v1);
        return i00.t.b(pair0.first);
    }

    @Override  // b3.f
    public final void n(int v) {
        this.C0();
        if(this.y0(34)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME or COMMAND_ADJUST_DEVICE_VOLUME_WITH_FLAGS");
        }
    }

    public static long n0(i0 i00, Object object0, m0 m00, o0 o00) {
        return i00.y == -1 ? e.r0(i00.A.get(), i00, o00) - e3.x.Z(i00.t.g(object0, m00).e) : i00.B.get();
    }

    @Override  // b3.S
    public final w0 o() {
        this.C0();
        return this.h.u;
    }

    public static int o0(p0 p00, f0 f00, int v, m0 m00, o0 o00) {
        if(p00.p()) {
            return v >= f00.e.size() ? -1 : v;
        }
        Object object0 = p00.f(p00.m(v, o00, 0L).n, m00, true).b;
        object0.getClass();
        if(f00.b(object0) == -1) {
            return -1;
        }
        f00.g(object0, m00);
        return m00.c;
    }

    @Override  // b3.f
    public final c p() {
        this.C0();
        return this.h.o;
    }

    public static b0 p0(E e0) {
        b3.a0 a00 = new b3.a0(new e0());  // 初始化器: Ljava/lang/Object;-><init>()V
        a00.c = e0;
        a00.k = true;
        a00.o = true;
        return new b0(a00);
    }

    @Override  // b3.f
    public final void prepare() {
        this.C0();
        i0 i00 = this.h;
        if(!this.y0(2)) {
            return;
        }
        LogConstantsKt.debugOnlyDebugMode(((Vb.o0)this).e1(), "handlePrepare()");
        if(Td.b.c(((Vb.o0)this).j)) {
            MelonAppBase.Companion.getClass();
            if(!k8.t.a().isCarConnected() || (((com.melon.playlist.b)((Vb.o0)this).B.a).t() == null || true)) {
                LogU.info$default(((Vb.o0)this).l, "handlePrepare()", null, false, 6, null);
                E e0 = ((Vb.o0)this).W();
                if(e0 == null) {
                    LogConstantsKt.debugOnlyDebugMode(((Vb.o0)this).l, "handlePrepare() currentItem is null.");
                    ToastManager.show((q.b(((Vb.o0)this).n.e.a1(), x0.b) ? 0x7F13082C : 0x7F13082B));  // string:playlist_empty_mv "재생할 비디오가 없습니다."
                    y.K0(((Vb.o0)this), false, 0, null, "handlePrepare() currentItem is null.", 7);
                }
                else {
                    ((Vb.o0)this).G0(e0, ((Vb.o0)this).getContentPosition());
                }
            }
            else {
                ToastManager.show(0x7F131069);  // string:toast_message_androidauto_not_support_video_play_in_auto "Android Auto 실행 
                                                // 중에는 영상 재생을 할 수 없습니다."
                y.K0(((Vb.o0)this), false, 0, null, "handlePrepare() Not support video play in auto", 7);
            }
        }
        else {
            ToastManager.show(Z.m(MelonAppBase.Companion, 0x7F1307ED, "getString(...)"));  // string:permission_alert_widget_popup_body_contact_and_storage "멜론 앱 사용을 위해서\n앱정보>권한 
                                                                                           // 승인 후 이용해주세요."
            y.K0(((Vb.o0)this), false, 0, null, null, 15);
        }
        this.A0(new androidx.media3.exoplayer.m(i00, 3), false, false);
    }

    @Override  // b3.f
    public final void q(boolean z) {
        this.C0();
        if(this.y0(26)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME or COMMAND_ADJUST_DEVICE_VOLUME_WITH_FLAGS");
        }
    }

    public static Q q0(i0 i00, m0 m00, o0 o00) {
        E e0;
        int v3;
        Object object1;
        Object object0;
        int v = i00.x == -1 ? 0 : i00.x;
        b3.h0 h00 = i00.A;
        int v1 = i00.y;
        p0 p00 = i00.t;
        if(p00.p()) {
            object0 = null;
            v3 = -1;
            object1 = null;
            e0 = null;
        }
        else {
            int v2 = e.m0(i00, m00, o00);
            object0 = p00.f(v2, m00, true).b;
            object1 = p00.m(v, o00, 0L).a;
            v3 = v2;
            e0 = o00.c;
        }
        long v4 = e.r0(h00.get(), i00, o00);
        return v1 == -1 ? new Q(object1, v, e0, object0, v3, v4, v4, i00.y, i00.z) : new Q(object1, v, e0, object0, v3, i00.B.get(), v4, i00.y, i00.z);
    }

    @Override  // b3.f
    public final void r() {
        this.C0();
        if(this.y0(26)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME or COMMAND_ADJUST_DEVICE_VOLUME_WITH_FLAGS");
        }
    }

    public static long r0(long v, i0 i00, o0 o00) {
        if(v != 0x8000000000000001L) {
            return v;
        }
        return i00.t.p() ? 0L : e3.x.Z(i00.t.m((i00.x == -1 ? 0 : i00.x), o00, 0L).l);
    }

    @Override  // b3.S
    public final void release() {
        this.C0();
        i0 i00 = this.h;
        if(!this.y0(0x20)) {
            return;
        }
        ((Vb.o0)this).j.unregisterReceiver(((Vb.o0)this).P);
        ((Vb.o0)this).j.unregisterReceiver(((Vb.o0)this).T);
        ((Vb.o0)this).j.unregisterReceiver(((Vb.o0)this).Q);
        ((Vb.o0)this).j.unregisterReceiver(((Vb.o0)this).U);
        ((Vb.o0)this).j.unregisterReceiver(((Vb.o0)this).R);
        ((Vb.o0)this).j.unregisterReceiver(((Vb.o0)this).S);
        ((Vb.o0)this).j.unregisterReceiver(((Vb.o0)this).V);
        ((Vb.o0)this).B.getClass();
        q.g(((Vb.o0)this).a0, "listener");
        com.melon.playlist.b b0 = (com.melon.playlist.b)((Vb.o0)this).B.a;
        b0.getClass();
        b0.t = null;
        LogU.info$default(((Vb.o0)this).l, "handleRelease()", null, false, 6, null);
        ((Vb.o0)this).B0();
        LogU.info$default(((Vb.o0)this).n.d, "release()", null, false, 6, null);
        ((Vb.o0)this).n.e.l1();
        MutableStateFlow mutableStateFlow0 = (MutableStateFlow)((Vb.o0)this).m.getValue();
        do {
            Object object0 = mutableStateFlow0.getValue();
            androidx.media3.common.d d0 = ((i0)object0).a();
            d0.d = 1;
        }
        while(!o.B(d0, mutableStateFlow0, object0));
        LogU.info$default(((Vb.o0)this).e1(), "onDestroyPlayer()", null, false, 6, null);
        ((Vb.o0)this).Y0();
        ((Vb.o0)this).b0(((t0)((Vb.o0)this).I.getValue()));
        EpPlayLogger.INSTANCE.setAnalytics(null, 0x8000000000000001L);
        d9.k.a.getViewModelStore().a();
        x x0 = x.b;
        HashSet hashSet0 = this.f;
        if(hashSet0.isEmpty()) {
            this.z0(this.s0(), false, false);
        }
        else {
            hashSet0.add(x0);
            this.z0(i00, false, false);
            x0.addListener(new l(this), new w(this, 1));
        }
        this.i = true;
        this.c.d();
        androidx.media3.common.d d1 = this.h.a();
        d1.d = 1;
        d1.G = b3.h0.F;
        d1.E = new g(e.r0(i00.A.get(), i00, ((o0)this.b)));
        d1.F = i00.B;
        this.h = new i0(d1);
    }

    @Override  // b3.f
    public final u0 s() {
        this.C0();
        return this.h.k;
    }

    public abstract i0 s0();

    @Override  // b3.S
    public final void setPlayWhenReady(boolean z) {
        this.C0();
        i0 i00 = this.h;
        if(!this.y0(1)) {
            return;
        }
        long v = ((Vb.o0)this).getCurrentPosition();
        EpPlayLogger.INSTANCE.updateCurrentPosition(v);
        LogU.info$default(((Vb.o0)this).l, "handleSetPlayWhenReady() playWhenReady: " + z, null, false, 6, null);
        ((Vb.o0)this).B0();
        if(((Vb.o0)this).getPlaybackState() != 3 || ((Vb.o0)this).getPlayWhenReady() || !z) {
            ((Vb.o0)this).M0(z);
        }
        else {
            me.i i0 = ((Vb.o0)this).v.plus(((Vb.o0)this).W);
            V v1 = new V(((Vb.o0)this), null);
            BuildersKt__Builders_commonKt.launch$default(((Vb.o0)this).u, i0, null, v1, 2, null);
        }
        x x0 = x.b;
        HashSet hashSet0 = this.f;
        if(hashSet0.isEmpty()) {
            this.z0(this.s0(), false, false);
            return;
        }
        hashSet0.add(x0);
        androidx.media3.common.d d0 = i00.a();
        d0.b = z;
        d0.c = 1;
        this.z0(new i0(d0), false, false);
        x0.addListener(new l(this), new w(this, 1));
    }

    @Override  // b3.f
    public final void setRepeatMode(int v) {
        this.C0();
        if(this.y0(15)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_SET_REPEAT_MODE");
        }
    }

    @Override  // b3.f
    public final void setShuffleModeEnabled(boolean z) {
        this.C0();
        if(this.y0(14)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_SET_SHUFFLE_MODE");
        }
    }

    @Override  // b3.f
    public final void setVideoSurface(Surface surface0) {
        this.C0();
        if(this.y0(27)) {
            if(surface0 != null) {
                throw new IllegalStateException("Missing implementation to handle COMMAND_SET_VIDEO_SURFACE");
            }
            this.C0();
            if(this.y0(27)) {
                throw new IllegalStateException("Missing implementation to handle COMMAND_SET_VIDEO_SURFACE");
            }
        }
    }

    @Override  // b3.f
    public final void setVolume(float f) {
        this.C0();
        i0 i00 = this.h;
        if(!this.y0(24)) {
            return;
        }
        LogConstantsKt.infoOnlyDebugMode(((y)this).l, "handleSetVolume() volume: " + f);
        LogU.info$default(((y)this).n.d, "setVolume() volume: " + f, null, false, 6, null);
        ((y)this).n.e.o1(f);
        MutableStateFlow mutableStateFlow0 = (MutableStateFlow)((y)this).m.getValue();
        do {
            Object object0 = mutableStateFlow0.getValue();
            androidx.media3.common.d d0 = ((i0)object0).a();
            d0.c(f);
        }
        while(!mutableStateFlow0.compareAndSet(object0, new i0(d0)));
        x x0 = x.b;
        HashSet hashSet0 = this.f;
        if(hashSet0.isEmpty()) {
            this.z0(this.s0(), false, false);
            return;
        }
        hashSet0.add(x0);
        androidx.media3.common.d d1 = i00.a();
        d1.c(f);
        this.z0(new i0(d1), false, false);
        x0.addListener(new l(this), new w(this, 1));
    }

    @Override  // b3.S
    public final void stop() {
        this.C0();
        i0 i00 = this.h;
        if(!this.y0(3)) {
            return;
        }
        LogConstantsKt.infoOnlyDebugMode(((y)this).l, "handleStop()");
        y.K0(((y)this), false, 0, null, "handleStop()", 6);
        this.A0(new b3.V(0, this, i00), false, false);
    }

    public static i0 t0(i0 i00, ArrayList arrayList0, m0 m00, o0 o00) {
        androidx.media3.common.d d0 = i00.a();
        f0 f00 = new f0(arrayList0);
        p0 p00 = i00.t;
        long v = i00.A.get();
        int v1 = i00.x == -1 ? 0 : i00.x;
        int v2 = e.o0(p00, f00, v1, m00, o00);
        long v3 = v2 == -1 ? 0x8000000000000001L : v;
        for(int v4 = v1 + 1; v2 == -1 && v4 < p00.o(); ++v4) {
            v2 = e.o0(p00, f00, v4, m00, o00);
        }
        if(i00.d != 1 && v2 == -1) {
            d0.d = 4;
        }
        return e.l0(d0, i00, v, f00, v2, v3, true, o00);
    }

    @Override  // b3.f
    public final void u(d d0, boolean z) {
        this.C0();
        if(this.y0(35)) {
            throw new IllegalStateException("Missing implementation to handle COMMAND_SET_AUDIO_ATTRIBUTES");
        }
    }

    public static i0 u0(i0 i00, ArrayList arrayList0, int v, long v1, o0 o00) {
        androidx.media3.common.d d0 = i00.a();
        p0 p00 = arrayList0 == null ? i00.t : new f0(arrayList0);
        if(i00.d != 1) {
            if(!p00.p() && (v == -1 || v < p00.o())) {
                d0.d = 2;
                return e.l0(d0, i00, i00.A.get(), p00, v, v1, false, o00);
            }
            d0.d = 4;
        }
        return e.l0(d0, i00, i00.A.get(), p00, v, v1, false, o00);
    }

    @Override  // b3.S
    public final int v() {
        this.C0();
        return this.h.q;
    }

    public final void v0() {
        this.C0();
        if(this.f.isEmpty() && !this.i) {
            this.z0(this.s0(), false, false);
        }
    }

    public static boolean w0(i0 i00) {
        return i00.b && i00.d == 3;
    }

    public final void x0(List list0, int v, long v1) {
        b.c(v == -1 || v >= 0);
        i0 i00 = this.h;
        if(!this.y0(20) && (list0.size() != 1 || !this.y0(0x1F))) {
            return;
        }
        q.g(list0, "mediaItems");
        this.A0(new W(this, list0, i00, v, v1), false, false);
    }

    @Override  // b3.S
    public final N y() {
        this.C0();
        return this.h.a;
    }

    // 去混淆评级： 低(20)
    public final boolean y0(int v) {
        return !this.i && this.h.a.a(v);
    }

    @Override  // b3.S
    public final long z() {
        this.C0();
        return this.h.i;
    }

    public final void z0(i0 i00, boolean z, boolean z1) {
        E e0;
        int v11;
        int v10;
        int v5;
        o0 o00 = (o0)this.b;
        i0 i01 = this.h;
        this.h = i00;
        i00.getClass();
        Metadata metadata0 = i00.s;
        K k0 = i00.e;
        int v = i00.x;
        p0 p00 = i00.t;
        int v1 = i01.z;
        int v2 = i01.y;
        p0 p01 = i01.t;
        int v3 = i01.b == i00.b ? 0 : 1;
        int v4 = i01.d == i00.d ? 0 : 1;
        m0 m00 = this.g;
        if(z) {
            v5 = 1;
        }
        else if(p01.p()) {
            v5 = -1;
        }
        else if(!p00.p()) {
            Object object0 = p01.l(e.m0(i01, m00, o00));
            Object object1 = p00.l(e.m0(i00, m00, o00));
            if(object0 instanceof e0 && !(object1 instanceof e0)) {
                v5 = -1;
            }
            else if(object1.equals(object0) && v2 == i00.y && v1 == i00.z) {
                long v6 = e.n0(i01, object0, m00, o00);
                if(Math.abs(v6 - e.n0(i00, object1, m00, o00)) >= 1000L) {
                    p01.g(object0, m00);
                    long v7 = e3.x.Z((v2 == -1 ? m00.d : m00.a(v2, v1)));
                    v5 = v7 != 0x8000000000000001L && v6 >= v7 ? 0 : 5;
                }
                else {
                    v5 = -1;
                }
            }
            else if(p00.b(object0) == -1) {
                v5 = 4;
            }
            else {
                long v8 = e.n0(i01, object0, m00, o00);
                p01.g(object0, m00);
                long v9 = e3.x.Z((v2 == -1 ? m00.d : m00.a(v2, v1)));
                v5 = v9 != 0x8000000000000001L && v8 >= v9 ? 0 : 3;
            }
        }
        else {
            v5 = 4;
        }
        boolean z2 = p01.equals(p00);
        if(p00.p() && p01.p()) {
            v10 = -1;
        }
        else if(p00.p() == p01.p()) {
            Object object2 = p01.m((i01.x == -1 ? 0 : i01.x), o00, 0L).a;
            Object object3 = p00.m((v == -1 ? 0 : v), o00, 0L).a;
            if(object2 instanceof e0 && !(object3 instanceof e0)) {
                v10 = -1;
            }
            else if(object2.equals(object3)) {
                if(v5 == 0 && e.r0(i01.A.get(), i01, o00) > e.r0(i00.A.get(), i00, o00)) {
                    v10 = 0;
                }
                else if(v5 != 1 || !z1) {
                    v10 = -1;
                }
                else {
                    v10 = 2;
                }
            }
            else if(v5 == 0) {
                v10 = 1;
            }
            else if(v5 == 1) {
                v10 = 2;
            }
            else {
                v10 = 3;
            }
        }
        else {
            v10 = 3;
        }
        m m0 = this.c;
        if(!z2) {
            if(p01.o() == p00.o()) {
                v11 = 1;
                int v12 = 0;
                while(v12 < p01.o()) {
                    Object object4 = p01.m(v12, o00, 0L).a;
                    Object object5 = p00.m(v12, o00, 0L).a;
                    if(!object4.equals(object5) && (!(object4 instanceof e0) || object5 instanceof e0)) {
                        goto label_88;
                    }
                    ++v12;
                }
            }
            else {
            label_88:
                v11 = 0;
            }
            m0.c(0, new A6.e(i00, v11, 4));
        }
        if(v5 != -1) {
            m0.c(11, new u(v5, e.q0(i01, m00, o00), e.q0(i00, m00, o00), 1));
        }
        if(v10 != -1) {
            if(p00.p()) {
                e0 = null;
            }
            else {
                if(v == -1) {
                    v = 0;
                }
                e0 = p00.m(v, o00, 0L).c;
            }
            m0.c(1, new v(e0, v10, 1));
        }
        if(!Objects.equals(i01.e, k0)) {
            m0.c(10, new U(i00, 14));
            if(k0 != null) {
                m0.c(10, new U(i00, 15));
            }
        }
        if(!i01.k.equals(i00.k)) {
            m0.c(19, new U(i00, 16));
        }
        if(!i01.u.equals(i00.u)) {
            m0.c(2, new U(i00, 17));
        }
        if(!i01.v.equals(i00.v)) {
            m0.c(14, new U(i00, 18));
        }
        if(v3 != 0 || v4 != 0) {
            m0.c(-1, new U(i00, 19));
        }
        if(v4 != 0) {
            m0.c(4, new U(i00, 20));
        }
        if(v3 != 0 || i01.c != i00.c) {
            m0.c(5, new U(i00, 21));
        }
        if(e.w0(i01) != e.w0(i00)) {
            m0.c(7, new U(i00, 22));
        }
        if(!i01.j.equals(i00.j)) {
            m0.c(12, new U(i00, 23));
        }
        if(i01.f != i00.f) {
            m0.c(8, new U(i00, 0));
        }
        if(i01.g != i00.g) {
            m0.c(16, new U(i00, 1));
        }
        if(i01.h != i00.h) {
            m0.c(17, new U(i00, 2));
        }
        if(i01.i != i00.i) {
            m0.c(18, new U(i00, 3));
        }
        if(!i01.l.equals(i00.l)) {
            m0.c(20, new U(i00, 4));
        }
        if(!i01.n.equals(i00.n)) {
            m0.c(25, new U(i00, 5));
        }
        if(!i01.p.equals(i00.p)) {
            m0.c(29, new U(i00, 6));
        }
        if(!i01.w.equals(i00.w)) {
            m0.c(15, new U(i00, 7));
        }
        if(!i01.r.equals(i00.r)) {
            m0.c(24, new U(i00, 8));
        }
        if(i01.m != i00.m) {
            m0.c(22, new U(i00, 9));
        }
        if(i01.q != i00.q) {
            m0.c(30, new U(i00, 10));
        }
        if(!i01.o.equals(i00.o)) {
            m0.c(27, new U(i00, 11));
        }
        if(!i01.s.equals(metadata0) && metadata0.b != 0x8000000000000001L) {
            m0.c(28, new U(i00, 12));
        }
        if(!i01.a.equals(i00.a)) {
            m0.c(13, new U(i00, 13));
        }
        m0.b();
    }
}

