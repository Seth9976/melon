package kc;

import Ac.F2;
import M6.B;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import com.melon.playlist.interfaces.PlayableData;
import d5.t;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import nc.C0;
import ne.a;
import oc.M;
import oc.Q;
import oc.w;
import oe.c;
import pc.d;
import we.n;

public final class d3 implements s2 {
    public final i a;
    public final CoroutineScope b;

    public d3(i i0) {
        q.g(i0, "melonInternalPlaylistManager");
        super();
        this.a = i0;
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public final B A(PlaylistId playlistId0, boolean z) {
        q.g(playlistId0, "playlistId");
        W2 w20 = new W2(this, playlistId0, z, null);
        return ListenableFutureKt.future$default(this.b, null, null, w20, 3, null);
    }

    public final Object B(PlaylistId playlistId0, Playable playable0, c c0) {
        Object object0 = ((b)this.a).h0(playlistId0, playable0, c0);
        return object0 == a.a ? object0 : H.a;
    }

    public final B C(PlaylistId playlistId0, String s, boolean z, boolean z1, n n0) {
        q.g(playlistId0, "playlistId");
        a3 a30 = new a3(this, playlistId0, s, z, z1, n0, null);
        return ListenableFutureKt.future$default(this.b, null, null, a30, 3, null);
    }

    public final B a(PlaylistId playlistId0) {
        q.g(playlistId0, "playlistId");
        u2 u20 = new u2(this, playlistId0, null);
        return ListenableFutureKt.future$default(this.b, null, null, u20, 3, null);
    }

    public final B b() {
        v2 v20 = new v2(this, null);
        return ListenableFutureKt.future$default(this.b, null, null, v20, 3, null);
    }

    public final F2 c() {
        return ((b)this.a).c.o();
    }

    public final F2 d() {
        return ((b)this.a).c.n();
    }

    public final B e() {
        y2 y20 = new y2(this, null);
        return ListenableFutureKt.future$default(this.b, null, null, y20, 3, null);
    }

    public final Playable f() {
        b b0 = (b)this.a;
        PlaylistId playlistId0 = b0.t();
        if(playlistId0 != null) {
            w w0 = b0.H(playlistId0);
            if(w0 != null) {
                Q q0 = w0.getState();
                if(q0 != null) {
                    PlayableData playableData0 = e1.b.z(q0);
                    return playableData0 == null ? null : playableData0.a;
                }
            }
        }
        throw new NullPointerException();
    }

    public final B g() {
        z2 z20 = new z2(this, null);
        return ListenableFutureKt.future$default(this.b, null, null, z20, 3, null);
    }

    public final B h() {
        A2 a20 = new A2(this, null);
        return ListenableFutureKt.future$default(this.b, null, null, a20, 3, null);
    }

    public final Flow i() {
        ((b)this.a).Y("getCurrentPlaylistIdFlow");
        return FlowKt.filterNotNull(((b)this.a).p);
    }

    public final PlaylistId j() {
        return ((b)this.a).t();
    }

    public final w k() {
        return ((b)this.a).u();
    }

    public final B l() {
        C2 c20 = new C2(this, null);
        return ListenableFutureKt.future$default(this.b, null, null, c20, 3, null);
    }

    public final Boolean m() {
        b b0 = (b)this.a;
        b0.Y("getIsUseSmartPlaylistOrNull");
        return b0.o.getValue() == e3.c ? ((Boolean)b0.r.getValue()) : null;
    }

    public final B n() {
        kc.F2 f20 = new kc.F2(this, null);
        return ListenableFutureKt.future$default(this.b, null, null, f20, 3, null);
    }

    public final B o() {
        H2 h20 = new H2(this, null);
        return ListenableFutureKt.future$default(this.b, null, null, h20, 3, null);
    }

    public final B p(PlaylistId playlistId0) {
        q.g(playlistId0, "playlistId");
        I2 i20 = new I2(this, playlistId0, null);
        return ListenableFutureKt.future$default(this.b, null, null, i20, 3, null);
    }

    public final w q(PlaylistId playlistId0) {
        q.g(playlistId0, "playlistId");
        ((b)this.a).getClass();
        return ((b)this.a).H(playlistId0);
    }

    public final B r() {
        J2 j20 = new J2(this, null);
        return ListenableFutureKt.future$default(this.b, null, null, j20, 3, null);
    }

    public final B s() {
        N2 n20 = new N2(this, null);
        return ListenableFutureKt.future$default(this.b, null, null, n20, 3, null);
    }

    public final Flow t() {
        ((b)this.a).getClass();
        return FlowKt.callbackFlow(new g0(((b)this.a), null));
    }

    public final Boolean u() {
        w w0 = ((b)this.a).u();
        if(w0 != null) {
            if(w0.getId() == PlaylistId.MIX_UP) {
                d d0 = w0 instanceof d ? ((d)w0) : null;
                return d0 == null ? null : Boolean.valueOf(t.k(d0));
            }
            return false;
        }
        return null;
    }

    public final void v(AddPosition addPosition0) {
        ((b)this.a).getClass();
        l0 l00 = new l0(((b)this.a), addPosition0, null);
        BuildersKt__Builders_commonKt.launch$default(((b)this.a).m, null, null, l00, 3, null);
    }

    public final B w(PlaylistId playlistId0, List list0) {
        q.g(playlistId0, "playlistId");
        q.g(list0, "indices");
        S2 s20 = new S2(this, playlistId0, list0, null);
        return ListenableFutureKt.future$default(this.b, null, null, s20, 3, null);
    }

    public final B x(C0 c00) {
        T2 t20 = new T2(this, c00, null);
        return ListenableFutureKt.future$default(this.b, null, null, t20, 3, null);
    }

    public final B y(M m0) {
        U2 u20 = new U2(this, m0, null);
        return ListenableFutureKt.future$default(this.b, null, null, u20, 3, null);
    }

    public final B z(boolean z) {
        V2 v20 = new V2(this, z, null);
        return ListenableFutureKt.future$default(this.b, null, null, v20, 3, null);
    }
}

