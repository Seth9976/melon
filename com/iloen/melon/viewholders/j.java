package com.iloen.melon.viewholders;

import android.view.View.OnLongClickListener;
import android.view.View;

public final class j implements View.OnLongClickListener {
    public final int a;
    public final PlaylistNewHolderImpl b;

    public j(PlaylistNewHolderImpl playlistNewHolderImpl0, int v) {
        this.b = playlistNewHolderImpl0;
        this.a = v;
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        PlaylistNewHolderImpl playlistNewHolderImpl0 = this.b;
        if(playlistNewHolderImpl0.mOnLongClickListener != null) {
            playlistNewHolderImpl0.mOnLongClickListener.a(view0, this.a);
        }
        return true;
    }
}

