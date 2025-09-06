package com.iloen.melon.player.playlist.mixup;

import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel", f = "MixUpPlaylistComposeViewModel.kt", l = {0x2F5}, m = "playPopularPlaylistInternal")
final class MixUpPlaylistComposeViewModel.playPopularPlaylistInternal.1 extends c {
    public final MixUpPlaylistComposeViewModel B;
    public int D;
    public AddPlay r;
    public Object w;

    public MixUpPlaylistComposeViewModel.playPopularPlaylistInternal.1(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, Continuation continuation0) {
        this.B = mixUpPlaylistComposeViewModel0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return MixUpPlaylistComposeViewModel.access$playPopularPlaylistInternal(this.B, this);
    }
}

