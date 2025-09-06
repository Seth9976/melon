package Nb;

import M6.B;
import U4.F;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.melon.playback.PlaybackLibraryService;
import e1.b;
import ie.H;
import ie.m;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import we.n;

public final class l0 extends i implements n {
    public int r;
    public final PlaybackLibraryService w;

    public l0(PlaybackLibraryService playbackLibraryService0, Continuation continuation0) {
        this.w = playbackLibraryService0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        m m0;
        a a0 = a.a;
        PlaybackLibraryService playbackLibraryService0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)F.z(playbackLibraryService0)).g();
                this.r = 1;
                object0 = ListenableFutureKt.await(b0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(b.D(((oc.H)object0).getState())) {
            m0 = new m(Boolean.TRUE, "playlist is empty");
        }
        else {
            m0 = MelonSettingInfo.isBlockedAutoPlayByExternal(playbackLibraryService0) ? new m(Boolean.TRUE, "BlockedAutoPlayByExternal") : new m(Boolean.FALSE, "");
        }
        String s = (String)m0.b;
        if(((Boolean)m0.a).booleanValue()) {
            LogU.debug$default(playbackLibraryService0.m, "onStartCommand() showDefaultNotification() reason: " + s, null, false, 6, null);
            PlaybackLibraryService.k(playbackLibraryService0);
        }
        return H.a;
    }
}

