package com.iloen.melon.fragments.musicmessage;

import android.view.View.OnClickListener;
import android.view.View;

public final class j implements View.OnClickListener {
    public final int a;
    public final MusicMessageListFragment b;

    public j(MusicMessageListFragment musicMessageListFragment0, int v) {
        this.a = v;
        this.b = musicMessageListFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            MusicMessageListFragment.onViewCreated$lambda$3$lambda$2(this.b, view0);
            return;
        }
        MusicMessageListFragment.createRecyclerViewAdapter$lambda$5$lambda$4(this.b, view0);
    }
}

