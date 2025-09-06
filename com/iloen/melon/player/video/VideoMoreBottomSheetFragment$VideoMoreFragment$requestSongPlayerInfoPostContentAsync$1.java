package com.iloen.melon.player.video;

import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.SongPlayerInfoPostContentReq;
import com.iloen.melon.net.v4x.response.SongPlayerInfoPostContentRes;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/iloen/melon/net/v4x/response/SongPlayerInfoPostContentRes;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.video.VideoMoreBottomSheetFragment$VideoMoreFragment$requestSongPlayerInfoPostContentAsync$1", f = "VideoMoreBottomSheetFragment.kt", l = {}, m = "invokeSuspend")
final class VideoMoreBottomSheetFragment.VideoMoreFragment.requestSongPlayerInfoPostContentAsync.1 extends i implements n {
    public final String B;
    public final VideoMoreFragment r;
    public final String w;

    public VideoMoreBottomSheetFragment.VideoMoreFragment.requestSongPlayerInfoPostContentAsync.1(VideoMoreFragment videoMoreBottomSheetFragment$VideoMoreFragment0, String s, String s1, Continuation continuation0) {
        this.r = videoMoreBottomSheetFragment$VideoMoreFragment0;
        this.w = s;
        this.B = s1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoMoreBottomSheetFragment.VideoMoreFragment.requestSongPlayerInfoPostContentAsync.1(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoMoreBottomSheetFragment.VideoMoreFragment.requestSongPlayerInfoPostContentAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        HttpResponse httpResponse0 = RequestBuilder.newInstance(new SongPlayerInfoPostContentReq(this.r.getContext(), this.w, this.B)).tag("VideoMoreFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.SongPlayerInfoPostContentRes");
        return (SongPlayerInfoPostContentRes)httpResponse0;
    }
}

