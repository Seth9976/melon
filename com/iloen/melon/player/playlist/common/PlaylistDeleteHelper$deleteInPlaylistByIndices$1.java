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
@e(c = "com.iloen.melon.player.playlist.common.PlaylistDeleteHelper", f = "NewPlaylistDeleteHelper.kt", l = {0xA3, 0xA4, 0xAE, 0xB9}, m = "deleteInPlaylistByIndices")
final class PlaylistDeleteHelper.deleteInPlaylistByIndices.1 extends c {
    public a B;
    public k D;
    public a E;
    public a G;
    public PlaylistId I;
    public boolean M;
    public boolean N;
    public int S;
    public int T;
    public Object V;
    public final PlaylistDeleteHelper W;
    public int X;
    public PlaylistId r;
    public List w;

    public PlaylistDeleteHelper.deleteInPlaylistByIndices.1(PlaylistDeleteHelper playlistDeleteHelper0, Continuation continuation0) {
        this.W = playlistDeleteHelper0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.V = object0;
        this.X |= 0x80000000;
        return PlaylistDeleteHelper.access$deleteInPlaylistByIndices(this.W, null, null, false, false, null, null, null, null, this);
    }
}

