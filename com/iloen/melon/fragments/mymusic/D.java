package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;

public final class d implements View.OnClickListener {
    public final int a;
    public final DjPlaylistFragment b;

    public d(DjPlaylistFragment djPlaylistFragment0, int v) {
        this.a = v;
        this.b = djPlaylistFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            PlaylistAdapter.onBindViewImpl$lambda$5(this.b, view0);
            return;
        }
        PlaylistAdapter.onBindViewImpl$lambda$3(this.b, view0);
    }
}

