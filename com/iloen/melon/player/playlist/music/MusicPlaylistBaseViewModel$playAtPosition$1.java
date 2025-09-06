package com.iloen.melon.player.playlist.music;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel", f = "MusicPlaylistBaseViewModel.kt", l = {800}, m = "playAtPosition")
final class MusicPlaylistBaseViewModel.playAtPosition.1 extends c {
    public Object B;
    public final MusicPlaylistBaseViewModel D;
    public int E;
    public int r;
    public int w;

    public MusicPlaylistBaseViewModel.playAtPosition.1(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0, Continuation continuation0) {
        this.D = musicPlaylistBaseViewModel0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return MusicPlaylistBaseViewModel.access$playAtPosition(this.D, 0, this);
    }
}

