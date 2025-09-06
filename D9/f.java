package d9;

import Ma.m;
import android.content.Context;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.ClassUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import com.melon.playlist.b;
import e.k;
import ie.H;
import jeb.synthetic.FIN;
import k8.o;
import kc.d3;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oc.w;
import oe.i;
import va.e;
import we.n;

public final class f extends i implements n {
    public final h B;
    public int r;
    public Object w;

    public f(h h0, Continuation continuation0) {
        this.B = h0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new f(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z;
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                h h0 = this.B;
                __monitor_enter(h0);
                int v = FIN.finallyOpen$NT();
                LogU.debug$default(h0.b, "isLyricViewAvailable()", null, false, 6, null);
                Playable playable0 = h0.m;
                if(playable0 == null) {
                    FIN.finallyExec$NT(v);
                    z = false;
                }
                else if(h0.l.isEmpty() || playable0.isOriginLocal()) {
                    FIN.finallyExec$NT(v);
                    z = false;
                }
                else if(playable0.getIsMusicWaveSong()) {
                    FIN.finallyCodeBegin$NT(v);
                    __monitor_exit(h0);
                    FIN.finallyCodeEnd$NT(v);
                    z = true;
                }
                else {
                    Context context0 = h0.getApplication().getApplicationContext();
                    q.d(context0);
                    z = MusicUtils.checkStreamingLyricsExist(".slf", u9.f.g.b(context0, "streamlyric").f);
                    FIN.finallyExec$NT(v);
                }
                if(!z) {
                    LogU.debug$default(this.B.b, "run(), cancel", null, false, 6, null);
                    CoroutineScopeKt.cancel$default(coroutineScope0, null, 1, null);
                }
                this.B.c();
                break;
            }
            case 1: {
                d5.n.D(object0);
                goto label_64;
            }
            case 2: 
            case 3: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(CoroutineScopeKt.isActive(coroutineScope0)) {
            Context context1 = this.B.a.getApplicationContext();
            q.f(context1, "getApplicationContext(...)");
            Context context2 = context1.getApplicationContext();
            q.d(context2);
            b b0 = (b)((d3)(((s2)((o)(((m)com.google.firebase.b.B(context2, m.class)))).w.get()))).a;
            b0.Y("getRecentAudioPlaylistIdOrNull");
            PlaylistId playlistId0 = (PlaylistId)b0.q.getValue();
            w w0 = playlistId0 == null ? null : b0.H(playlistId0);
            Playable playable1 = w0 == null ? null : k.p(w0);
            if(!ClassUtils.equals(this.B.m, playable1)) {
                LogU.warn$default(this.B.b, "run() mismatched playable information", null, false, 6, null);
            }
            else if(this.B.l.isEmpty()) {
                LogU.debug$default(this.B.b, "run(), lyricsInfoList is Empty", null, false, 6, null);
            }
            else {
                long v1 = ((fc.a)FlowKt.asStateFlow(this.B.e.b).getValue()).d;
                LogU.debug$default(this.B.b, e.a(v1, "run() curPlayTime : "), null, false, 6, null);
                if(Math.abs(v1 - this.B.r) > 1000L) {
                    this.B.c();
                }
                this.B.r = v1;
                this.w = coroutineScope0;
                this.r = 1;
                d9.e e0 = new d9.e(this.B, v1, null);
                H h1 = BuildersKt.withContext(this.B.c, e0, this);
                if(h1 != a.a) {
                    h1 = H.a;
                }
                if(h1 == a0) {
                    return a0;
                }
            }
        label_64:
            Playable playable2 = this.B.m;
            if(playable2 != null && playable2.getIsMusicWaveSong()) {
                this.w = coroutineScope0;
                this.r = 2;
                if(DelayKt.delay(100L, this) != a0) {
                    continue;
                }
                return a0;
            }
            this.w = coroutineScope0;
            this.r = 3;
            if(DelayKt.delay(500L, this) != a0) {
                continue;
            }
            return a0;
        }
        return H.a;
    }
}

