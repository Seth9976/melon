package com.iloen.melon.fragments.local;

import android.view.View.OnClickListener;
import android.view.View;

public final class x implements View.OnClickListener {
    public final int a;
    public final LocalPlaylistDetailFragment b;

    public x(LocalPlaylistDetailFragment localPlaylistDetailFragment0, int v) {
        this.a = v;
        this.b = localPlaylistDetailFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                LocalPlaylistDetailFragment.onViewCreated$lambda$1(this.b, view0);
                return;
            }
            case 1: {
                LocalPlaylistDetailFragment.onViewCreated$lambda$3(this.b, view0);
                return;
            }
            default: {
                LocalPlaylistDetailFragment.onViewCreated$lambda$5(this.b, view0);
            }
        }
    }
}

