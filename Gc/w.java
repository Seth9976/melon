package gc;

import Bf.a;
import L8.s;
import Nb.v0;
import Nb.z0;
import Ub.t;
import Vb.u0;
import Yc.D;
import ac.l;
import ac.o;
import android.net.Uri;
import b3.E;
import com.iloen.melon.custom.l1;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.b;
import com.melon.playlist.interfaces.PlayableData;
import hc.p;
import hc.r;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import oe.i;
import we.n;

public final class w extends i implements n {
    public final E B;
    public final y r;
    public final Uri w;

    public w(y y0, Uri uri0, E e0, Continuation continuation0) {
        this.r = y0;
        this.w = uri0;
        this.B = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new w(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((w)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        PlayableData playableData0;
        d5.n.D(object0);
        gc.E e0 = this.r.n;
        D d0 = new D(1, this.r, y.class, "handleOnPrepared", "handleOnPrepared(Lcom/melon/playback/player/PlayerImpl;)V", 0, 18);
        e0.getClass();
        Uri uri0 = this.w;
        q.g(uri0, "uri");
        E e1 = this.B;
        q.g(e1, "mediaItem");
        String s = e0.e.a1().a();
        LogU.info$default(e0.d, "prepare() uri: " + uri0 + ", mediaItem: " + s, null, false, 6, null);
        MutableStateFlow mutableStateFlow0 = e0.f;
        do {
            Object object1 = mutableStateFlow0.getValue();
            q.g(((F)object1), "state");
            playableData0 = null;
        }
        while(!mutableStateFlow0.compareAndSet(object1, new F(e1, B.a, d0, null)));
        a a0 = e0.e;
        u0 u00 = e0.c;
        z0 z00 = a0.a1();
        q.g(z00, "playerType");
        String s1 = e1.a;
        q.f(s1, "mediaId");
        String s2 = U4.F.Y(s1).a;
        kc.i i0 = u00.b;
        if(i0 != null) {
            PlaylistId playlistId0 = ((b)i0).t();
            if(playlistId0 != null) {
                oc.w w0 = ((b)i0).H(playlistId0);
                if(w0 != null) {
                    for(Object object2: w0.getState().c()) {
                        if(q.b(((PlayableData)object2).b, s2)) {
                            playableData0 = object2;
                            break;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
            }
            r r0 = r.a;
            if(playableData0 == null) {
                LogConstantsKt.debugOnlyDebugMode(u00.d, "provideRemoteResource() Not found mediaItem: " + s1);
            }
            else {
                Playable playable0 = playableData0.a;
                if(z00 instanceof v0) {
                    s s3 = ((t)u00.d()).c.i;
                    if(s3 == null) {
                        LogU.error$default(u00.d, "provideRemoteResource() Not found controller", null, false, 6, null);
                    }
                    else {
                        q.f("", "getSongidString(...)");
                        q.f("", "getSongName(...)");
                        String s4 = l1.n("", "getArtistNames(...)", playable0, "getArtistNames(...)");
                        q.f("", "getAlbum(...)");
                        long v = playable0.getDuration();
                        boolean z = playable0.isOriginLocal();
                        String s5 = ((t)u00.d()).c.k;
                        q.f("", "getMetatype(...)");
                        r0 = new hc.q(s3, new o("", "", s4, "", z, s5, "", ((Number)((t)u00.d()).c.l.getValue()).intValue(), "", playableData0.n, v));
                    }
                }
                else if(z00 instanceof Nb.u0) {
                    long v1 = playable0.getDuration();
                    r0 = new p(new l(((int)playable0.isOnAir()), ((int)playable0.isAdult()), v1));
                }
            }
            a0.n1(uri0, e1, r0);
            return H.a;
        }
        q.m("melonInternalPlaylistManager");
        throw null;
    }
}

