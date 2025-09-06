package com.iloen.melon.fragments.local;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.playback.Playable;

public final class z implements View.OnClickListener {
    public final LocalPlaylistDetailFragment a;
    public final int b;
    public final LocalPlaylistDetailSongAdapter c;
    public final int d;
    public final Playable e;

    public z(LocalPlaylistDetailFragment localPlaylistDetailFragment0, int v, LocalPlaylistDetailSongAdapter localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0, int v1, Playable playable0) {
        this.a = localPlaylistDetailFragment0;
        this.b = v;
        this.c = localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0;
        this.d = v1;
        this.e = playable0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        LocalPlaylistDetailSongAdapter.onBindViewImpl$lambda$1(this.a, this.b, this.c, this.d, this.e, view0);
    }
}

