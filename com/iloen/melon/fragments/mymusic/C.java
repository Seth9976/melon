package com.iloen.melon.fragments.mymusic;

import E8.g;
import com.android.volley.Response.Listener;

public final class c implements g, Listener {
    public final int a;
    public final DjPlaylistFragment b;

    public c(DjPlaylistFragment djPlaylistFragment0, int v) {
        this.a = v;
        this.b = djPlaylistFragment0;
        super();
    }

    @Override  // E8.g
    public void b(int v) {
        PlaylistAdapter.onBindViewImpl$lambda$1$lambda$0(this.b, v);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        switch(this.a) {
            case 1: {
                DjPlaylistFragment.checkWithMakeSeriesFolder$lambda$16(this.b, object0);
                return;
            }
            case 2: {
                DjPlaylistFragment.checkWithMakeDjPlaylist$lambda$13(this.b, object0);
                return;
            }
            default: {
                DjPlaylistFragment.checkWithMakePlaylist$lambda$10(this.b, object0);
            }
        }
    }
}

