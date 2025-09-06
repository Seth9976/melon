package com.iloen.melon.fragments.local;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.playback.Playable;

public final class g implements View.OnClickListener {
    public final int a;
    public final MetaContentBaseFragment b;
    public final Object c;

    public g(MetaContentBaseFragment metaContentBaseFragment0, Object object0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        this.c = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                LocalContentAllSongAdapter.onBindViewImpl$lambda$1(((LocalContentAllSongFragment)this.b), ((Playable)this.c), view0);
                return;
            }
            case 1: {
                LocalContentAllSongAdapter.onBindViewImpl$lambda$2(((LocalContentAllSongFragment)this.b), ((Playable)this.c), view0);
                return;
            }
            default: {
                LocalPlaylistAdapter.a(((LocalPlaylistFragment)this.b), ((LocalPlaylistAdapter)this.c), view0);
            }
        }
    }
}

