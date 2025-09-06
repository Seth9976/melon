package com.iloen.melon.player.playlist;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.PlaylistSharedViewModel", f = "PlaylistSharedViewModel.kt", l = {103}, m = "updateMusicTabContent")
final class PlaylistSharedViewModel.updateMusicTabContent.1 extends c {
    public final PlaylistSharedViewModel B;
    public int D;
    public MusicPlaylistTabContent r;
    public Object w;

    public PlaylistSharedViewModel.updateMusicTabContent.1(PlaylistSharedViewModel playlistSharedViewModel0, Continuation continuation0) {
        this.B = playlistSharedViewModel0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return PlaylistSharedViewModel.access$updateMusicTabContent(this.B, null, this);
    }
}

