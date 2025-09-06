package com.iloen.melon.player.video;

import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.VideoViewModel$collectPlaylistId$2", f = "VideoViewModel.kt", l = {322}, m = "invokeSuspend")
final class VideoViewModel.collectPlaylistId.2 extends i implements n {
    public int r;
    public final VideoViewModel w;

    public VideoViewModel.collectPlaylistId.2(VideoViewModel videoViewModel0, Continuation continuation0) {
        this.w = videoViewModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoViewModel.collectPlaylistId.2(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoViewModel.collectPlaylistId.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = ((d3)this.w.getPlaylistManager()).i();
                com.iloen.melon.player.video.VideoViewModel.collectPlaylistId.2.1 videoViewModel$collectPlaylistId$2$10 = new n(null) {
                    public Object r;
                    public final VideoViewModel w;

                    {
                        this.w = videoViewModel0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.player.video.VideoViewModel.collectPlaylistId.2.1(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(PlaylistId playlistId0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoViewModel.collectPlaylistId.2.1)this.create(playlistId0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((PlaylistId)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        PlaylistId playlistId0 = (PlaylistId)this.r;
                        d5.n.D(object0);
                        this.w.e.setValue(playlistId0);
                        return H.a;
                    }
                };
                this.r = 1;
                return FlowKt.collectLatest(flow0, videoViewModel$collectPlaylistId$2$10, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

