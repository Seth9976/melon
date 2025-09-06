package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;

public final class b0 implements View.OnClickListener {
    public final int a;
    public final OtherMusicLikedSongFragment b;

    public b0(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, int v) {
        this.a = v;
        this.b = otherMusicLikedSongFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            OtherMusicLikedSongFragment.initHeaderView$lambda$1(this.b, view0);
            return;
        }
        OtherMusicLikedSongFragment.initHeaderView$lambda$0(this.b, view0);
    }
}

