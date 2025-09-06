package com.iloen.melon.fragments.local;

import android.view.View.OnClickListener;
import android.view.View;

public final class v implements View.OnClickListener {
    public final int a;
    public final LocalPlaylistDetailEditFragment b;

    public v(LocalPlaylistDetailEditFragment localPlaylistDetailEditFragment0, int v) {
        this.a = v;
        this.b = localPlaylistDetailEditFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                LocalPlaylistDetailEditFragment.onViewCreated$lambda$0(this.b, view0);
                return;
            }
            case 1: {
                LocalPlaylistDetailEditFragment.onViewCreated$lambda$2(this.b, view0);
                return;
            }
            default: {
                LocalPlaylistDetailEditFragment.onViewCreated$lambda$3(this.b, view0);
            }
        }
    }
}

