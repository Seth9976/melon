package com.iloen.melon.fragments.local;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.playback.Playable;

public final class m implements View.OnClickListener {
    public final int a;
    public final LocalContentBaseUIFragment b;
    public final Playable c;

    public m(LocalContentBaseUIFragment localContentBaseUIFragment0, Playable playable0) {
        this.a = 1;
        super();
        this.b = localContentBaseUIFragment0;
        this.c = playable0;
    }

    public m(Playable playable0, LocalContentBaseUIFragment localContentBaseUIFragment0) {
        this.a = 0;
        super();
        this.c = playable0;
        this.b = localContentBaseUIFragment0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            LocalSongAdapter.onBindViewImpl$lambda$3(this.b, this.c, view0);
            return;
        }
        LocalSongAdapter.c(this.b, this.c, view0);
    }
}

