package com.iloen.melon.fragments.local;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.iloen.melon.playback.Playable;

public final class h implements View.OnLongClickListener {
    public final int a;
    public final Playable b;
    public final LocalContentNewDbBaseFragment c;

    public h(LocalContentNewDbBaseFragment localContentNewDbBaseFragment0, Playable playable0, int v) {
        this.a = v;
        this.c = localContentNewDbBaseFragment0;
        this.b = playable0;
        super();
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        return this.a == 0 ? LocalContentAllSongAdapter.onBindViewImpl$lambda$3(((LocalContentAllSongFragment)this.c), this.b, view0) : LocalSongAdapter.onBindViewImpl$lambda$1(((LocalContentBaseUIFragment)this.c), this.b, view0);
    }
}

