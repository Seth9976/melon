package com.iloen.melon.fragments.mymusic;

import com.android.volley.Response.Listener;

public final class d0 implements Listener {
    public final int a;
    public final PlaylistFragment b;

    public d0(PlaylistFragment playlistFragment0, int v) {
        this.a = v;
        this.b = playlistFragment0;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        switch(this.a) {
            case 0: {
                PlaylistFragment.checkWithMakePlaylist$lambda$9(this.b, object0);
                return;
            }
            case 1: {
                PlaylistFragment.checkWithMakeSeriesFolder$lambda$15(this.b, object0);
                return;
            }
            default: {
                PlaylistFragment.checkWithMakeDjPlaylist$lambda$12(this.b, object0);
            }
        }
    }
}

