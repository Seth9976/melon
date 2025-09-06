package com.iloen.melon.player.playlist;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.VideoPlaylistFragment", f = "VideoPlaylistFragment.kt", l = {0x9F}, m = "handlePlaybackEvent")
final class VideoPlaylistFragment.handlePlaybackEvent.1 extends c {
    public int B;
    public Object r;
    public final VideoPlaylistFragment w;

    public VideoPlaylistFragment.handlePlaybackEvent.1(VideoPlaylistFragment videoPlaylistFragment0, Continuation continuation0) {
        this.w = videoPlaylistFragment0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return VideoPlaylistFragment.access$handlePlaybackEvent(this.w, false, this);
    }
}

