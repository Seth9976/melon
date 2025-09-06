package com.iloen.melon.player.playlist.mixup;

import com.iloen.melon.playback.Playable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel", f = "MixUpPlaylistComposeViewModel.kt", l = {590, 607}, m = "playInternal")
final class MixUpPlaylistComposeViewModel.playInternal.1 extends c {
    public int B;
    public boolean D;
    public Object E;
    public final MixUpPlaylistComposeViewModel G;
    public int I;
    public Integer r;
    public Playable w;

    public MixUpPlaylistComposeViewModel.playInternal.1(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, Continuation continuation0) {
        this.G = mixUpPlaylistComposeViewModel0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return MixUpPlaylistComposeViewModel.access$playInternal(this.G, null, null, this);
    }
}

