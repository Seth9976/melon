package com.iloen.melon.player.video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.i;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.video.VideoInfoViewModel", f = "VideoInfoViewModel.kt", l = {291, 302}, m = "requestComment")
final class VideoInfoViewModel.requestComment.1 extends c {
    public CoroutineScope B;
    public i D;
    public Object E;
    public final VideoInfoViewModel G;
    public int I;
    public int r;
    public v9.i w;

    public VideoInfoViewModel.requestComment.1(Continuation continuation0, VideoInfoViewModel videoInfoViewModel0) {
        this.G = videoInfoViewModel0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return VideoInfoViewModel.access$requestComment(this.G, 0, null, null, this);
    }
}

