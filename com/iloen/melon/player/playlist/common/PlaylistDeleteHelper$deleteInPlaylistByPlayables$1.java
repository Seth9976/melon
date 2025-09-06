package com.iloen.melon.player.playlist.common;

import com.iloen.melon.playback.playlist.PlaylistId;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.k;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.common.PlaylistDeleteHelper", f = "NewPlaylistDeleteHelper.kt", l = {0xD6, 0xDB}, m = "deleteInPlaylistByPlayables")
final class PlaylistDeleteHelper.deleteInPlaylistByPlayables.1 extends c {
    public a B;
    public k D;
    public a E;
    public a G;
    public boolean I;
    public boolean M;
    public Object N;
    public final PlaylistDeleteHelper S;
    public int T;
    public PlaylistId r;
    public List w;

    public PlaylistDeleteHelper.deleteInPlaylistByPlayables.1(PlaylistDeleteHelper playlistDeleteHelper0, Continuation continuation0) {
        this.S = playlistDeleteHelper0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.N = object0;
        this.T |= 0x80000000;
        return PlaylistDeleteHelper.access$deleteInPlaylistByPlayables(this.S, null, null, false, false, null, null, null, null, this);
    }
}

