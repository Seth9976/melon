package com.iloen.melon.player.video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.video.VideoPlayerFragmentBase", f = "VideoPlayerFragmentBase.kt", l = {868}, m = "getEndingViewCase")
final class VideoPlayerFragmentBase.getEndingViewCase.1 extends c {
    public final VideoPlayerFragmentBase B;
    public int D;
    public boolean r;
    public Object w;

    public VideoPlayerFragmentBase.getEndingViewCase.1(VideoPlayerFragmentBase videoPlayerFragmentBase0, Continuation continuation0) {
        this.B = videoPlayerFragmentBase0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return VideoPlayerFragmentBase.access$getEndingViewCase(this.B, this);
    }
}

