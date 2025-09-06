package zd;

import M6.B;
import com.iloen.melon.playback.Playable;
import com.melon.ui.popup.context.more.MelonBottomSheetComposeDialogFragment;
import ie.H;
import kc.d3;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import we.n;

public final class s extends i implements n {
    public final Playable B;
    public int r;
    public final MelonBottomSheetComposeDialogFragment w;

    public s(MelonBottomSheetComposeDialogFragment melonBottomSheetComposeDialogFragment0, Playable playable0, Continuation continuation0) {
        this.w = melonBottomSheetComposeDialogFragment0;
        this.B = playable0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new s(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        MelonBottomSheetComposeDialogFragment melonBottomSheetComposeDialogFragment0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                s2 s20 = melonBottomSheetComposeDialogFragment0.o;
                if(s20 == null) {
                    q.m("playlistManager");
                    throw null;
                }
                B b0 = ((d3)s20).e();
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
        Playable playable0 = this.B;
        int v = playable0.getSongid();
        Integer integer0 = ((Playable)object0) == null ? "" : new Integer(((Playable)object0).getSongid());
        int v1 = 0;
        if(integer0 instanceof Integer && v == integer0.intValue()) {
            playable0.setLiked((((Playable)object0) == null ? false : ((Playable)object0).isLiked()));
            if(((Playable)object0) != null) {
                v1 = ((Playable)object0).getLikeCount();
            }
            playable0.setLikeCount(v1);
            melonBottomSheetComposeDialogFragment0.sendUserEvent(new K(playable0.isLiked()));
        }
        return H.a;
    }
}

