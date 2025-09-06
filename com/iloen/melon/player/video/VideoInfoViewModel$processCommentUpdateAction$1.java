package com.iloen.melon.player.video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.video.VideoInfoViewModel", f = "VideoInfoViewModel.kt", l = {340, 341}, m = "processCommentUpdateAction")
final class VideoInfoViewModel.processCommentUpdateAction.1 extends c {
    public int B;
    public Object r;
    public final VideoInfoViewModel w;

    public VideoInfoViewModel.processCommentUpdateAction.1(Continuation continuation0, VideoInfoViewModel videoInfoViewModel0) {
        this.w = videoInfoViewModel0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return VideoInfoViewModel.access$processCommentUpdateAction(this.w, null, this);
    }
}

