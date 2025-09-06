package com.iloen.melon.player.playlist.mixup;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment", f = "MixUpPlaylistComposeFragment.kt", l = {503}, m = "getPvDummyAction")
final class MixUpPlaylistComposeFragment.getPvDummyAction.1 extends c {
    public int B;
    public Object r;
    public final MixUpPlaylistComposeFragment w;

    public MixUpPlaylistComposeFragment.getPvDummyAction.1(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, Continuation continuation0) {
        this.w = mixUpPlaylistComposeFragment0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return MixUpPlaylistComposeFragment.access$getPvDummyAction(this.w, this);
    }
}

