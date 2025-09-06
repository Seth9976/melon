package com.iloen.melon.player.video;

import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.net.v4x.response.SongPlayerInfoPostContentRes.RESPONSE;
import com.iloen.melon.net.v4x.response.SongPlayerInfoPostContentRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.SharableBase;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.VideoMoreBottomSheetFragment$VideoMoreFragment$renderUi$1$1$1$1$1", f = "VideoMoreBottomSheetFragment.kt", l = {276}, m = "invokeSuspend")
final class VideoMoreBottomSheetFragment.VideoMoreFragment.renderUi.1.1.1.1.1 extends i implements n {
    public final String B;
    public final String D;
    public final Playable E;
    public final SharableBase G;
    public int r;
    public final VideoMoreFragment w;

    public VideoMoreBottomSheetFragment.VideoMoreFragment.renderUi.1.1.1.1.1(VideoMoreFragment videoMoreBottomSheetFragment$VideoMoreFragment0, String s, String s1, Playable playable0, SharableBase sharableBase0, Continuation continuation0) {
        this.w = videoMoreBottomSheetFragment$VideoMoreFragment0;
        this.B = s;
        this.D = s1;
        this.E = playable0;
        this.G = sharableBase0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoMoreBottomSheetFragment.VideoMoreFragment.renderUi.1.1.1.1.1(this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoMoreBottomSheetFragment.VideoMoreFragment.renderUi.1.1.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        VideoMoreFragment videoMoreBottomSheetFragment$VideoMoreFragment0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                q.d(this.D);
                Deferred deferred0 = VideoMoreFragment.access$requestSongPlayerInfoPostContentAsync(videoMoreBottomSheetFragment$VideoMoreFragment0, this.B, this.D);
                this.r = 1;
                object0 = deferred0.await(this);
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
        if(((SongPlayerInfoPostContentRes)object0) != null && ((SongPlayerInfoPostContentRes)object0).isSuccessful()) {
            RESPONSE songPlayerInfoPostContentRes$RESPONSE0 = ((SongPlayerInfoPostContentRes)object0).response;
            if(songPlayerInfoPostContentRes$RESPONSE0 != null) {
                Playable playable0 = this.E;
                if(playable0 != null) {
                    playable0.setPostImg(songPlayerInfoPostContentRes$RESPONSE0.postImg);
                }
                if(playable0 != null) {
                    playable0.setPostEditImg(((SongPlayerInfoPostContentRes)object0).response.postEditImg);
                }
            }
        }
        MelonBaseFragment melonBaseFragment0 = VideoMoreFragment.access$getRootFragment(videoMoreBottomSheetFragment$VideoMoreFragment0);
        if(melonBaseFragment0 != null) {
            melonBaseFragment0.showSNSListPopup(this.G);
        }
        VideoMoreFragment.access$closeBottomSheet(videoMoreBottomSheetFragment$VideoMoreFragment0);
        return H.a;
    }
}

