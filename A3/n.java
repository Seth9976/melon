package a3;

import Ac.X3;
import I6.V;
import Vb.v0;
import Vd.w;
import android.net.Uri;
import android.os.Looper;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Surface;
import b3.E;
import b3.F;
import b3.G;
import b3.H;
import b3.K;
import b3.L;
import b3.N;
import b3.P;
import b3.Q;
import b3.d;
import b3.f;
import b3.k;
import b3.m0;
import b3.o0;
import b3.p0;
import b3.q0;
import b3.s;
import b3.u0;
import b3.w0;
import b3.z0;
import com.google.android.gms.cast.MediaInfo.Builder;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.images.WebImage;
import com.iloen.melon.constants.CType;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.LeonPlayerHelper;
import d5.e;
import e3.b;
import e3.r;
import e3.x;
import gc.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.q;

public final class n extends f {
    public G A;
    public final k B;
    public static final k C;
    public static final N D;
    public static final long[] E;
    public final CastContext c;
    public final a d;
    public final long e;
    public final long f;
    public final long g;
    public final e h;
    public final m0 i;
    public final m j;
    public final a3.k k;
    public final e3.m l;
    public final l m;
    public final l n;
    public final l o;
    public RemoteMediaClient p;
    public p q;
    public w0 r;
    public N s;
    public int t;
    public int u;
    public long v;
    public int w;
    public int x;
    public long y;
    public Q z;

    static {
        n.C = new w(1).e();
        F.a("media3.cast");
        SparseBooleanArray sparseBooleanArray0 = new SparseBooleanArray();
        for(int v = 0; v < 15; ++v) {
            int v1 = new int[]{1, 2, 3, 4, 10, 15, 13, 16, 17, 18, 19, 0x1F, 20, 30, 0x20}[v];
            b.j(((boolean)1));
            sparseBooleanArray0.append(v1, true);
        }
        b.j(((boolean)1));
        n.D = new N(new b3.m(sparseBooleanArray0));
        n.E = new long[0];
    }

    public n(CastContext castContext0, a a0) {
        this.c = castContext0;
        this.d = a0;
        this.e = 5000L;
        this.f = 15000L;
        this.g = 3000L;
        this.h = new e(a0);
        this.i = new m0();
        m m0 = new m(this);
        this.j = m0;
        this.k = new a3.k(this);
        Looper looper0 = Looper.getMainLooper();
        c c0 = new c(this, 6);
        this.l = new e3.m(looper0, r.a, c0);
        this.m = new l(Boolean.FALSE);
        this.n = new l(0);
        this.o = new l(L.d);
        this.t = 1;
        this.q = p.k;
        this.A = G.K;
        this.r = w0.b;
        SparseBooleanArray sparseBooleanArray0 = new SparseBooleanArray();
        b3.m m1 = n.D.a;
        for(int v = 0; v < m1.a.size(); ++v) {
            int v1 = m1.b(v);
            b.j(((boolean)1));
            sparseBooleanArray0.append(v1, true);
        }
        b.j(((boolean)1));
        this.s = new N(new b3.m(sparseBooleanArray0));
        this.x = -1;
        this.y = 0x8000000000000001L;
        SessionManager sessionManager0 = castContext0.getSessionManager();
        sessionManager0.addSessionManagerListener(m0, CastSession.class);
        CastSession castSession0 = sessionManager0.getCurrentCastSession();
        this.o0((castSession0 == null ? null : castSession0.getRemoteMediaClient()));
        this.s0();
        this.B = n.C;
    }

    @Override  // b3.f
    public final z0 A() {
        return z0.d;
    }

    @Override  // b3.S
    public final k B() {
        return this.B;
    }

    @Override  // b3.f
    public final void C(int v, int v1) {
    }

    @Override  // b3.S
    public final void D(List list0, int v, long v1) {
        int v4;
        int v2 = (int)(((Integer)this.n.a));
        if(this.p != null && !list0.isEmpty()) {
            if(v1 == 0x8000000000000001L) {
                v1 = 0L;
            }
            if(v == -1) {
                v = this.L();
                v1 = this.getCurrentPosition();
            }
            if(!this.q.p()) {
                this.z = this.k0();
            }
            MediaQueueItem[] arr_mediaQueueItem = this.q0(list0);
            ((HashMap)this.h.c).clear();
            this.h.o(list0, arr_mediaQueueItem);
            RemoteMediaClient remoteMediaClient0 = this.p;
            int v3 = Math.min(v, list0.size() - 1);
            if(v2 == 0) {
                v4 = 0;
            }
            else {
                switch(v2) {
                    case 1: {
                        v4 = 2;
                        break;
                    }
                    case 2: {
                        v4 = 1;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException();
                    }
                }
            }
            remoteMediaClient0.queueLoad(arr_mediaQueueItem, v3, v4, v1, null);
        }
    }

    @Override  // b3.S
    public final long E() {
        return this.f;
    }

    @Override  // b3.S
    public final void F(int v, List list0) {
        int v1 = 0;
        b.c(v >= 0);
        p p0 = this.q;
        if(v < p0.g.length) {
            p0.m(v, ((o0)this.b), 0L);
            v1 = (int)(((Integer)((o0)this.b).a));
        }
        if(this.p != null && this.l0() != null) {
            MediaQueueItem[] arr_mediaQueueItem = this.q0(list0);
            this.h.o(list0, arr_mediaQueueItem);
            this.p.queueInsertItems(arr_mediaQueueItem, v1, null);
        }
    }

    @Override  // b3.S
    public final void H(P p0) {
        this.l.a(p0);
    }

    @Override  // b3.S
    public final G I() {
        return G.K;
    }

    @Override  // b3.f
    public final void J(u0 u00) {
    }

    @Override  // b3.f
    public final void K(G g0) {
    }

    @Override  // b3.S
    public final int L() {
        return this.x == -1 ? this.u : this.x;
    }

    @Override  // b3.S
    public final void N(int v, int v1, int v2) {
        o0 o00 = (o0)this.b;
        int v3 = 0;
        b.c(v >= 0 && v <= v1 && v2 >= 0);
        int v4 = Math.min(v1, this.q.g.length);
        int v5 = v4 - v;
        int v6 = Math.min(v2, this.q.g.length - v5);
        if(v < this.q.g.length && v != v4 && v != v6) {
            int[] arr_v = new int[v5];
            for(int v7 = 0; v7 < v5; ++v7) {
                this.q.m(v7 + v, o00, 0L);
                arr_v[v7] = (int)(((Integer)o00.a));
            }
            if(this.p != null && this.l0() != null) {
                if(v < v6) {
                    v6 += v5;
                }
                p p0 = this.q;
                if(v6 < p0.g.length) {
                    p0.m(v6, o00, 0L);
                    v3 = (int)(((Integer)o00.a));
                }
                this.p.queueReorderItems(arr_v, v3, null);
            }
        }
    }

    @Override  // b3.f
    public final boolean P() {
        return false;
    }

    @Override  // b3.f
    public final void Q(int v) {
    }

    @Override  // b3.S
    public final G T() {
        return this.A;
    }

    @Override  // b3.S
    public final void U(List list0) {
        this.D(list0, 0, 0x8000000000000001L);
    }

    @Override  // b3.S
    public final long V() {
        return this.e;
    }

    @Override  // b3.S
    public final void a(L l0) {
        if(this.p == null) {
            return;
        }
        L l1 = new L(x.g(l0.a, 0.5f, 2.0f));
        this.m0(l1);
        this.l.b();
        PendingResult pendingResult0 = this.p.setPlaybackRate(((double)l1.a), null);
        i i0 = new i(this);
        this.o.b = i0;
        pendingResult0.setResultCallback(i0);
    }

    @Override  // b3.f
    public final void b0(P p0) {
        this.l.e(p0);
    }

    @Override  // b3.f
    public final void d(int v, boolean z) {
    }

    @Override  // b3.f
    public final void e() {
    }

    @Override  // b3.f
    public final void f(int v) {
    }

    @Override  // b3.f
    public final Looper getApplicationLooper() {
        return Looper.getMainLooper();
    }

    @Override  // b3.S
    public final d getAudioAttributes() {
        return d.g;
    }

    @Override  // b3.S
    public final int getCurrentAdGroupIndex() {
        return -1;
    }

    @Override  // b3.S
    public final int getCurrentAdIndexInAdGroup() {
        return -1;
    }

    @Override  // b3.S
    public final long getCurrentPosition() {
        long v = this.y;
        if(v != 0x8000000000000001L) {
            return v;
        }
        return this.p == null ? this.v : this.p.getApproximateStreamPosition();
    }

    @Override  // b3.S
    public final p0 getCurrentTimeline() {
        return this.q;
    }

    @Override  // b3.S
    public final boolean getPlayWhenReady() {
        return ((Boolean)this.m.a).booleanValue();
    }

    @Override  // b3.S
    public final L getPlaybackParameters() {
        return (L)this.o.a;
    }

    @Override  // b3.S
    public final int getPlaybackState() {
        return this.t;
    }

    @Override  // b3.S
    public final int getPlaybackSuppressionReason() {
        return 0;
    }

    @Override  // b3.S
    public final int getRepeatMode() {
        return (int)(((Integer)this.n.a));
    }

    @Override  // b3.S
    public final boolean getShuffleModeEnabled() {
        return false;
    }

    @Override  // b3.S
    public final long getTotalBufferedDuration() {
        long v = this.getCurrentPosition();
        long v1 = this.getCurrentPosition();
        return v == 0x8000000000000001L || v1 == 0x8000000000000001L ? 0L : v - v1;
    }

    @Override  // b3.f
    public final float getVolume() {
        return 1.0f;
    }

    @Override  // b3.S
    public final void h(int v, int v1, List list0) {
        b.c(v >= 0 && v <= v1);
        int v2 = this.q.g.length;
        if(v > v2) {
            return;
        }
        int v3 = Math.min(v1, v2);
        this.F(v3, list0);
        this.j(v, v3);
    }

    @Override  // b3.f
    public final void h0(int v, int v1, long v2, boolean z) {
        if(v != -1) {
            b.c(v >= 0);
            if(this.q.p() || v < this.q.g.length) {
                MediaStatus mediaStatus0 = this.l0();
                if(Long.compare(v2, 0x8000000000000001L) == 0) {
                    v2 = 0L;
                }
                e3.m m0 = this.l;
                if(mediaStatus0 != null) {
                    a3.k k0 = this.k;
                    if(this.L() == v) {
                        this.p.seek(v2).setResultCallback(k0);
                    }
                    else {
                        RemoteMediaClient remoteMediaClient0 = this.p;
                        this.q.f(v, this.i, false);
                        remoteMediaClient0.queueJumpToItem(((int)(((Integer)this.i.b))), v2, null).setResultCallback(k0);
                    }
                    Q q0 = this.k0();
                    ++this.w;
                    this.x = v;
                    this.y = v2;
                    Q q1 = this.k0();
                    m0.c(11, new a3.b(q0, q1, 2));
                    if(q0.b != q1.b) {
                        this.q.m(v, ((o0)this.b), 0L);
                        m0.c(1, new a3.e(0, ((o0)this.b).c));
                        G g0 = this.A;
                        E e0 = this.W();
                        G g1 = e0 == null ? G.K : e0.d;
                        this.A = g1;
                        if(!g0.equals(g1)) {
                            m0.c(14, new c(this, 5));
                        }
                    }
                    this.r0();
                }
                m0.b();
            }
        }
    }

    @Override  // b3.S
    public final boolean isLoading() {
        return false;
    }

    @Override  // b3.S
    public final boolean isPlayingAd() {
        return false;
    }

    @Override  // b3.S
    public final void j(int v, int v1) {
        b.c(v >= 0 && v1 >= v);
        int v3 = Math.min(v1, this.q.g.length);
        if(v < this.q.g.length && v != v3) {
            int v4 = v3 - v;
            int[] arr_v = new int[v4];
            for(int v5 = 0; v5 < v4; ++v5) {
                this.q.m(v5 + v, ((o0)this.b), 0L);
                arr_v[v5] = (int)(((Integer)((o0)this.b).a));
            }
            if(this.p != null && this.l0() != null) {
                p p0 = this.q;
                if(!p0.p()) {
                    p0.f(this.L(), this.i, true);
                    Object object0 = this.i.b;
                    for(int v2 = 0; v2 < v4; ++v2) {
                        if(object0.equals(((int)arr_v[v2]))) {
                            this.z = this.k0();
                            break;
                        }
                    }
                }
                this.p.queueRemoveItems(arr_v, null);
            }
        }
    }

    public final Q k0() {
        o0 o00 = (o0)this.b;
        p p0 = this.q;
        if(!p0.p()) {
            p0.f(this.L(), this.i, true);
            Object object0 = this.i.b;
            p0.m(this.i.c, o00, 0L);
            return new Q(o00.a, this.L(), o00.c, object0, this.L(), this.getCurrentPosition(), this.getCurrentPosition(), -1, -1);
        }
        return new Q(null, this.L(), null, null, this.L(), this.getCurrentPosition(), this.getCurrentPosition(), -1, -1);
    }

    @Override  // b3.S
    public final K l() {
        return null;
    }

    public final MediaStatus l0() {
        return this.p == null ? null : this.p.getMediaStatus();
    }

    public final void m0(L l0) {
        l l1 = this.o;
        if(((L)l1.a).equals(l0)) {
            return;
        }
        l1.a = l0;
        a3.d d0 = new a3.d(l0, 0);
        this.l.c(12, d0);
        this.r0();
    }

    @Override  // b3.f
    public final void n(int v) {
    }

    public final void n0(int v, int v1, boolean z) {
        l l0 = this.m;
        boolean z1 = false;
        boolean z2 = this.t == 3 && ((Boolean)l0.a).booleanValue();
        boolean z3 = ((Boolean)l0.a).booleanValue() != z;
        boolean z4 = this.t != v1;
        if(z3 || z4) {
            this.t = v1;
            l0.a = Boolean.valueOf(z);
            g g0 = new g(z, v1, 0);
            e3.m m0 = this.l;
            m0.c(-1, g0);
            if(z4) {
                m0.c(4, new a3.f(v1, 1));
            }
            if(z3) {
                m0.c(5, new g(z, v, 1));
            }
            if(v1 == 3 && z) {
                z1 = true;
            }
            if(z2 != z1) {
                m0.c(7, new a3.a(z1, 0));
            }
        }
    }

    @Override  // b3.S
    public final w0 o() {
        return this.r;
    }

    public final void o0(RemoteMediaClient remoteMediaClient0) {
        RemoteMediaClient remoteMediaClient1 = this.p;
        if(remoteMediaClient1 == remoteMediaClient0) {
            return;
        }
        m m0 = this.j;
        if(remoteMediaClient1 != null) {
            remoteMediaClient1.unregisterCallback(m0);
            this.p.removeProgressListener(m0);
        }
        this.p = remoteMediaClient0;
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.registerCallback(m0);
            remoteMediaClient0.addProgressListener(m0, 1000L);
            this.s0();
        }
    }

    @Override  // b3.f
    public final d3.c p() {
        return d3.c.c;
    }

    public final void p0(int v) {
        l l0 = this.n;
        if(((int)(((Integer)l0.a))) != v) {
            l0.a = v;
            a3.f f0 = new a3.f(v, 0);
            this.l.c(8, f0);
            this.r0();
        }
    }

    @Override  // b3.f
    public final void prepare() {
    }

    @Override  // b3.f
    public final void q(boolean z) {
    }

    public final MediaQueueItem[] q0(List list0) {
        String s5;
        MediaQueueItem[] arr_mediaQueueItem = new MediaQueueItem[list0.size()];
        for(int v = 0; v < list0.size(); ++v) {
            E e0 = (E)list0.get(v);
            this.d.getClass();
            q.g(e0, "mediaItem");
            String s = e0.a;
            gc.b b0 = this.d.a;
            LogU logU0 = b0.j;
            boolean z = U4.F.M(e0);
            G g0 = e0.d;
            q.f(s, "mediaId");
            boolean z1 = U4.F.Y(s).b.equals(CType.LIVE);
            q.f(s, "mediaId");
            String s1 = U4.F.Y(s).c;
            String s2 = (z ? CType.MV : CType.SONG).getValue();
            MediaMetadata mediaMetadata0 = new MediaMetadata((z ? 1 : 3));
            CharSequence charSequence0 = g0.a;
            Uri uri0 = g0.m;
            if(charSequence0 != null) {
                mediaMetadata0.putString("com.google.android.gms.cast.metadata.TITLE", String.valueOf(charSequence0));
            }
            CharSequence charSequence1 = g0.b;
            if(charSequence1 != null) {
                mediaMetadata0.putString("com.google.android.gms.cast.metadata.ARTIST", String.valueOf(charSequence1));
            }
            if(uri0 != null) {
                mediaMetadata0.addImage(new WebImage(uri0));
            }
            androidx.media3.common.c c0 = g0.a();
            c0.d(b0.i);
            c0.getClass();
            new G(c0);
            if(!z1) {
                mediaMetadata0.putString("CID", s1);
            }
            mediaMetadata0.putString("CTYPE", s2);
            mediaMetadata0.putInt("IS_ADULT", b0.h);
            if(z) {
                mediaMetadata0.putInt("IS_ON_AIR", b0.g);
            }
            q.f(s, "mediaId");
            v0 v00 = U4.F.Y(s);
            int v1 = b0.h;
            int v2 = b0.g;
            long v3 = b0.i;
            StringBuilder stringBuilder0 = A7.d.o("updateMediaMetadata cid: ", v00.c, ", cType: ", s2, ", isAdult: ");
            U4.x.x(stringBuilder0, v1, ", onAirFlag: ", v2, ", duration: ");
            stringBuilder0.append(v3);
            LogConstantsKt.debugOnlyDebugMode(logU0, stringBuilder0.toString());
            androidx.media3.common.c c1 = g0.a();
            c1.d(b0.i);
            G g1 = new G(c1);
            s s3 = e0.a();
            s3.k = g1;
            E e1 = s3.a();
            if(b0.g == 1) {
                String s4 = U4.F.E(e1).toString();
                q.f(s4, "toString(...)");
                s5 = LeonPlayerHelper.findChromecastPath(s4);
            }
            else {
                s5 = U4.F.E(e1).toString();
                q.f(s5, "toString(...)");
            }
            Builder mediaInfo$Builder0 = new Builder(s5);
            mediaInfo$Builder0.setStreamType(1);
            String s6 = e1.b == null ? null : e1.b.b;
            if(s6 == null) {
                s6 = "";
            }
            mediaInfo$Builder0.setContentType(s6);
            mediaInfo$Builder0.setMetadata(mediaMetadata0);
            Long long0 = e1.d.h;
            mediaInfo$Builder0.setStreamDuration((long0 == null ? 0L : ((long)long0)));
            MediaInfo mediaInfo0 = mediaInfo$Builder0.build();
            q.f(mediaInfo0, "build(...)");
            LogConstantsKt.debugOnlyDebugMode(logU0, "getMediaInfo: " + mediaInfo0.zza());
            MediaQueueItem mediaQueueItem0 = new com.google.android.gms.cast.MediaQueueItem.Builder(mediaInfo0).build();
            q.f(mediaQueueItem0, "build(...)");
            arr_mediaQueueItem[v] = mediaQueueItem0;
        }
        return arr_mediaQueueItem;
    }

    @Override  // b3.f
    public final void r() {
    }

    public final void r0() {
        N n0 = this.s;
        N n1 = x.q(this, n.D);
        this.s = n1;
        if(!n1.equals(n0)) {
            c c0 = new c(this, 1);
            this.l.c(13, c0);
        }
    }

    @Override  // b3.S
    public final void release() {
        SessionManager sessionManager0 = this.c.getSessionManager();
        sessionManager0.removeSessionManagerListener(this.j, CastSession.class);
        sessionManager0.endCurrentSession(false);
    }

    @Override  // b3.f
    public final u0 s() {
        return u0.C;
    }

    public final void s0() {
        boolean z2;
        Object object1;
        int v2;
        Object object0;
        o0 o00 = (o0)this.b;
        if(this.p == null) {
            return;
        }
        int v = this.u;
        G g0 = this.A;
        boolean z = this.q.p();
        m0 m00 = this.i;
        List list0 = null;
        int v1 = 1;
        if(z) {
            object0 = null;
        }
        else {
            this.q.f(v, m00, true);
            object0 = m00.b;
        }
        this.u0(null);
        this.v0(null);
        this.t0(null);
        boolean z1 = this.w0();
        p p0 = this.q;
        RemoteMediaClient remoteMediaClient0 = this.p;
        if(remoteMediaClient0 == null) {
            v2 = 0;
        }
        else {
            MediaQueueItem mediaQueueItem0 = remoteMediaClient0.getCurrentItem();
            v2 = mediaQueueItem0 == null ? -1 : p0.b(mediaQueueItem0.getItemId());
            if(v2 == -1) {
                v2 = 0;
            }
        }
        this.u = v2;
        E e0 = this.W();
        this.A = e0 == null ? G.K : e0.d;
        if(p0.p()) {
            object1 = null;
        }
        else {
            p0.f(this.u, m00, true);
            object1 = m00.b;
        }
        e3.m m0 = this.l;
        if(!z1 && !Objects.equals(object0, object1) && this.w == 0) {
            p0.f(v, m00, true);
            p0.n(v, o00);
            long v3 = x.Z(o00.m);
            Q q0 = new Q(o00.a, m00.c, o00.c, m00.b, m00.c, v3, v3, -1, -1);
            p0.f(this.u, m00, true);
            p0.n(this.u, o00);
            m0.c(11, new a3.b(q0, new Q(o00.a, m00.c, o00.c, m00.b, m00.c, x.Z(o00.l), x.Z(o00.l), -1, -1), 1));
            m0.c(1, new c(this, 2));
        }
        if(this.p == null) {
            v1 = 0;
        }
        else {
            MediaStatus mediaStatus0 = this.l0();
            MediaInfo mediaInfo0 = mediaStatus0 == null ? null : mediaStatus0.getMediaInfo();
            if(mediaInfo0 != null) {
                list0 = mediaInfo0.getMediaTracks();
            }
            if(list0 == null || list0.isEmpty()) {
                v1 = true ^ w0.b.equals(this.r);
                this.r = w0.b;
            }
            else {
                long[] arr_v = mediaStatus0.getActiveTrackIds();
                if(arr_v == null) {
                    arr_v = n.E;
                }
                b3.v0[] arr_v0 = new b3.v0[list0.size()];
                int v4 = 0;
                while(v4 < list0.size()) {
                    MediaTrack mediaTrack0 = (MediaTrack)list0.get(v4);
                    b3.n n0 = new b3.n();
                    n0.a = mediaTrack0.getContentId();
                    n0.l = H.l(mediaTrack0.getContentType());
                    n0.d = mediaTrack0.getLanguage();
                    q0 q00 = new q0(Integer.toString(v4), new androidx.media3.common.b[]{new androidx.media3.common.b(n0)});
                    long v5 = mediaTrack0.getId();
                    int v6 = 0;
                    while(true) {
                        z2 = false;
                        if(v6 < arr_v.length) {
                            if(arr_v[v6] == v5) {
                                z2 = true;
                            }
                            else {
                                ++v6;
                                continue;
                            }
                        }
                        break;
                    }
                    arr_v0[v4] = new b3.v0(q00, false, new int[]{4}, new boolean[]{z2});
                    ++v4;
                }
                w0 w00 = new w0(V.q(arr_v0));
                if(w00.equals(this.r)) {
                    v1 = 0;
                }
                else {
                    this.r = w00;
                }
            }
        }
        if(v1 != 0) {
            m0.c(2, new c(this, 3));
        }
        if(!g0.equals(this.A)) {
            m0.c(14, new c(this, 4));
        }
        this.r0();
        m0.b();
    }

    @Override  // b3.S
    public final void setPlayWhenReady(boolean z) {
        if(this.p == null) {
            return;
        }
        this.n0(1, this.t, z);
        this.l.b();
        PendingResult pendingResult0 = z ? this.p.play() : this.p.pause();
        h h0 = new h(this);
        this.m.b = h0;
        pendingResult0.setResultCallback(h0);
    }

    @Override  // b3.f
    public final void setRepeatMode(int v) {
        if(this.p == null) {
            return;
        }
        int v1 = 2;
        this.p0(v);
        this.l.b();
        RemoteMediaClient remoteMediaClient0 = this.p;
        switch(v) {
            case 0: {
                v1 = 0;
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                v1 = 1;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        PendingResult pendingResult0 = remoteMediaClient0.queueSetRepeatMode(v1, null);
        j j0 = new j(this);
        this.n.b = j0;
        pendingResult0.setResultCallback(j0);
    }

    @Override  // b3.f
    public final void setShuffleModeEnabled(boolean z) {
    }

    @Override  // b3.f
    public final void setVideoSurface(Surface surface0) {
    }

    @Override  // b3.f
    public final void setVolume(float f) {
    }

    @Override  // b3.S
    public final void stop() {
        this.t = 1;
        RemoteMediaClient remoteMediaClient0 = this.p;
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.stop();
        }
    }

    public final void t0(i i0) {
        l l0 = this.o;
        if(l0.b == i0) {
            MediaStatus mediaStatus0 = this.p.getMediaStatus();
            float f = mediaStatus0 == null ? L.d.a : ((float)mediaStatus0.getPlaybackRate());
            if(f > 0.0f) {
                this.m0(new L(f));
            }
            l0.b = null;
        }
    }

    @Override  // b3.f
    public final void u(d d0, boolean z) {
    }

    public final void u0(h h0) {
        l l0 = this.m;
        boolean z = ((Boolean)l0.a).booleanValue();
        int v = 1;
        if(l0.b == h0) {
            z = !this.p.isPaused();
            l0.b = null;
        }
        int v1 = z == ((Boolean)l0.a).booleanValue() ? 1 : 4;
        int v2 = this.p.getPlayerState();
        switch(v2) {
            case 2: 
            case 3: {
                v = 3;
                break;
            }
            case 4: {
                v = 2;
                break;
            }
            default: {
                if(v2 == 5) {
                    v = 2;
                }
            }
        }
        this.n0(v1, v, z);
    }

    @Override  // b3.S
    public final int v() {
        return 0;
    }

    public final void v0(j j0) {
        l l0 = this.n;
        if(l0.b == j0) {
            MediaStatus mediaStatus0 = this.p.getMediaStatus();
            int v = 0;
            if(mediaStatus0 != null) {
                int v1 = mediaStatus0.getQueueRepeatMode();
                if(v1 != 0) {
                    v = 2;
                    switch(v1) {
                        case 2: {
                            v = 1;
                            break;
                        }
                        case 1: 
                        case 3: {
                            break;
                        }
                        default: {
                            throw new IllegalStateException();
                        }
                    }
                }
            }
            this.p0(v);
            l0.b = null;
        }
    }

    public final boolean w0() {
        int v6;
        int v5;
        p p1;
        o0 o00 = (o0)this.b;
        p p0 = this.q;
        int v = this.u;
        if(this.l0() == null) {
            p1 = p.k;
        }
        else {
            RemoteMediaClient remoteMediaClient0 = this.p;
            e e0 = this.h;
            SparseArray sparseArray0 = (SparseArray)e0.b;
            HashMap hashMap0 = (HashMap)e0.c;
            int[] arr_v = remoteMediaClient0.getMediaQueue().getItemIds();
            if(arr_v.length > 0) {
                HashSet hashSet0 = new HashSet(arr_v.length * 2);
                for(int v1 = 0; v1 < arr_v.length; ++v1) {
                    hashSet0.add(((int)arr_v[v1]));
                }
                int v2 = 0;
                while(v2 < sparseArray0.size()) {
                    if(hashSet0.contains(sparseArray0.keyAt(v2))) {
                        ++v2;
                    }
                    else {
                        hashMap0.remove(((o)sparseArray0.valueAt(v2)).e);
                        sparseArray0.removeAt(v2);
                    }
                }
            }
            MediaStatus mediaStatus0 = remoteMediaClient0.getMediaStatus();
            if(mediaStatus0 == null || mediaStatus0.getMediaInfo() == null) {
                p1 = p.k;
            }
            else {
                int v3 = mediaStatus0.getCurrentItemId();
                MediaInfo mediaInfo0 = mediaStatus0.getMediaInfo();
                mediaInfo0.getClass();
                String s = mediaInfo0.getContentId();
                E e1 = (E)hashMap0.get(s);
                if(e1 == null) {
                    e1 = E.g;
                }
                e0.q(v3, e1, mediaStatus0.getMediaInfo(), s, 0x8000000000000001L);
                for(Object object0: mediaStatus0.getQueueItems()) {
                    double f = ((MediaQueueItem)object0).getStartTime();
                    MediaInfo mediaInfo1 = ((MediaQueueItem)object0).getMedia();
                    String s1 = mediaInfo1 == null ? "UNKNOWN_CONTENT_ID" : mediaInfo1.getContentId();
                    E e2 = (E)hashMap0.get(s1);
                    int v4 = ((MediaQueueItem)object0).getItemId();
                    if(e2 == null) {
                        e2 = E.g;
                        q.f(e2, "EMPTY");
                    }
                    e0.q(v4, e2, mediaInfo1, s1, ((long)(f * 1000000.0)));
                }
                p1 = new p(arr_v, sparseArray0);
            }
        }
        this.q = p1;
        boolean z = p0.equals(p1);
        if(!z) {
            RemoteMediaClient remoteMediaClient1 = this.p;
            p p2 = this.q;
            if(remoteMediaClient1 == null) {
                v5 = 0;
            }
            else {
                MediaQueueItem mediaQueueItem0 = remoteMediaClient1.getCurrentItem();
                v5 = mediaQueueItem0 == null ? -1 : p2.b(mediaQueueItem0.getItemId());
                if(v5 == -1) {
                    v5 = 0;
                }
            }
            this.u = v5;
        }
        if(!z) {
            X3 x30 = new X3(this.q, 23);
            e3.m m0 = this.l;
            m0.c(0, x30);
            p p3 = this.q;
            boolean z1 = p0.p();
            m0 m00 = this.i;
            if(z1) {
                v6 = 0;
            }
            else {
                p0.f(v, m00, true);
                v6 = p3.b(m00.b) == -1 ? 1 : 0;
            }
            if(v6 != 0) {
                Q q0 = this.z;
                if(q0 == null) {
                    p0.f(v, m00, true);
                    p0.n(m00.c, o00);
                    q0 = new Q(o00.a, m00.c, o00.c, m00.b, m00.c, this.getCurrentPosition(), this.getCurrentPosition(), -1, -1);
                }
                else {
                    this.z = null;
                }
                m0.c(11, new a3.b(q0, this.k0(), 0));
            }
            boolean z2 = p3.p() != p0.p() || v6 != 0;
            if(z2) {
                m0.c(1, new c(this, 0));
            }
            this.r0();
            return z2;
        }
        return false;
    }

    @Override  // b3.S
    public final N y() {
        return this.s;
    }

    @Override  // b3.S
    public final long z() {
        return this.g;
    }
}

