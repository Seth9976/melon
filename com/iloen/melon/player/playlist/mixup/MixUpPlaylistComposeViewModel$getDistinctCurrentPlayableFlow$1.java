package com.iloen.melon.player.playlist.mixup;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel", f = "MixUpPlaylistComposeViewModel.kt", l = {291}, m = "getDistinctCurrentPlayableFlow")
final class MixUpPlaylistComposeViewModel.getDistinctCurrentPlayableFlow.1 extends c {
    public int B;
    public Object r;
    public final MixUpPlaylistComposeViewModel w;

    public MixUpPlaylistComposeViewModel.getDistinctCurrentPlayableFlow.1(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, Continuation continuation0) {
        this.w = mixUpPlaylistComposeViewModel0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return MixUpPlaylistComposeViewModel.access$getDistinctCurrentPlayableFlow(this.w, this);
    }
}

