package com.iloen.melon.player.video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.video.LivePreviewSubscribeManager", f = "LivePreviewSubscribeManager.kt", l = {108, 0x77}, m = "fetchSubscribe")
final class LivePreviewSubscribeManager.fetchSubscribe.1 extends c {
    public int B;
    public Object r;
    public final LivePreviewSubscribeManager w;

    public LivePreviewSubscribeManager.fetchSubscribe.1(LivePreviewSubscribeManager livePreviewSubscribeManager0, Continuation continuation0) {
        this.w = livePreviewSubscribeManager0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return LivePreviewSubscribeManager.access$fetchSubscribe(this.w, this);
    }
}

