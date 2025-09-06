package com.iloen.melon.viewholders;

import android.view.View.OnLongClickListener;
import android.view.View;

public final class a implements View.OnLongClickListener {
    public final int a;
    public final DjPlaylistNewHolderImpl b;

    public a(DjPlaylistNewHolderImpl djPlaylistNewHolderImpl0, int v) {
        this.b = djPlaylistNewHolderImpl0;
        this.a = v;
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        DjPlaylistNewHolderImpl djPlaylistNewHolderImpl0 = this.b;
        if(djPlaylistNewHolderImpl0.mOnLongClickListener != null) {
            djPlaylistNewHolderImpl0.mOnLongClickListener.a(view0, this.a);
        }
        return true;
    }
}

