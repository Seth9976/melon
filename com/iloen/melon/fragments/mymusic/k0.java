package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;

public final class k0 implements View.OnClickListener {
    public final int a;
    public final SeriesPlaylistMakeFragment b;

    public k0(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, int v) {
        this.a = v;
        this.b = seriesPlaylistMakeFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                CoverViewHolder.bindItem$lambda$0(this.b, view0);
                return;
            }
            case 1: {
                SeriesEditMenuViewHolder.bindItem$lambda$1(this.b, view0);
                return;
            }
            default: {
                SeriesPlaylistMakeFragment.initTitleBar$lambda$4(this.b, view0);
            }
        }
    }
}

