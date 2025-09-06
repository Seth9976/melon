package com.iloen.melon.player.playlist.common;

import com.iloen.melon.playback.playlist.PlaylistId;
import java.util.Iterator;
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
@e(c = "com.iloen.melon.player.playlist.common.PlaylistDeleteHelper", f = "NewPlaylistDeleteHelper.kt", l = {0xF1, 0xF4, 0xFB, 0x109}, m = "deleteInDrawerPlaylistByIndices")
final class PlaylistDeleteHelper.deleteInDrawerPlaylistByIndices.1 extends c {
    public k B;
    public a D;
    public a E;
    public PlaylistId G;
    public PlaylistId I;
    public Iterator M;
    public boolean N;
    public boolean S;
    public int T;
    public int V;
    public Object W;
    public final PlaylistDeleteHelper X;
    public int Y;
    public List r;
    public a w;

    public PlaylistDeleteHelper.deleteInDrawerPlaylistByIndices.1(PlaylistDeleteHelper playlistDeleteHelper0, Continuation continuation0) {
        this.X = playlistDeleteHelper0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.W = object0;
        this.Y |= 0x80000000;
        return PlaylistDeleteHelper.access$deleteInDrawerPlaylistByIndices(this.X, null, false, false, null, null, null, null, this);
    }
}

