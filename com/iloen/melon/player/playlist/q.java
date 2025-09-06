package com.iloen.melon.player.playlist;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.playback.Playable;
import oc.H;

public final class q implements View.OnClickListener {
    public final VideoPlaylistFragment a;
    public final int b;
    public final Playable c;

    public q(VideoPlaylistFragment videoPlaylistFragment0, int v, Playable playable0) {
        this.a = videoPlaylistFragment0;
        this.b = v;
        this.c = playable0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        VideoPlaylistFragment videoPlaylistFragment0 = this.a;
        H h0 = VideoPlaylistFragment.access$getVodPlaylist(videoPlaylistFragment0);
        if(h0 != null) {
            int v = h0.getState().b();
            int v1 = this.b;
            if(v1 != v) {
                kotlin.jvm.internal.q.f("", "getMvid(...)");
                kotlin.jvm.internal.q.f("", "getMvname(...)");
                VideoPlaylistFragment.access$sendTiaraLog(videoPlaylistFragment0, v1, "", "");
                VideoPlaylistFragment.access$getPlayerUseCase(videoPlaylistFragment0).v(v1);
                videoPlaylistFragment0.mAdapter.notifyDataSetChanged();
            }
            else if(!VideoPlaylistFragment.access$isPlaying(videoPlaylistFragment0)) {
                VideoPlaylistFragment.access$getPlayerController(videoPlaylistFragment0).s();
            }
        }
    }
}

