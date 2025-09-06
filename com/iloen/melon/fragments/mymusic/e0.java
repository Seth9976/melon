package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;

public final class e0 implements View.OnClickListener {
    public final int a;
    public final PlaylistFragment b;

    public e0(PlaylistFragment playlistFragment0, int v) {
        this.a = v;
        this.b = playlistFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                PlaylistAdapter.onBindViewImpl$lambda$0(this.b, view0);
                return;
            }
            case 1: {
                PlaylistAdapter.onBindViewImpl$lambda$2(this.b, view0);
                return;
            }
            default: {
                PlaylistFragment.makeTitleBar$lambda$3$lambda$2(this.b, view0);
            }
        }
    }
}

