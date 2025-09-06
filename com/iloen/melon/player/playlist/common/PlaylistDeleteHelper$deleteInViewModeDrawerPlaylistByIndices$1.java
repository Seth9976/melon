package com.iloen.melon.player.playlist.common;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.common.PlaylistDeleteHelper", f = "NewPlaylistDeleteHelper.kt", l = {0x11F}, m = "deleteInViewModeDrawerPlaylistByIndices")
final class PlaylistDeleteHelper.deleteInViewModeDrawerPlaylistByIndices.1 extends c {
    public final PlaylistDeleteHelper B;
    public int D;
    public k r;
    public Object w;

    public PlaylistDeleteHelper.deleteInViewModeDrawerPlaylistByIndices.1(PlaylistDeleteHelper playlistDeleteHelper0, Continuation continuation0) {
        this.B = playlistDeleteHelper0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return PlaylistDeleteHelper.access$deleteInViewModeDrawerPlaylistByIndices(this.B, null, null, false, null, null, null, this);
    }
}

