package com.iloen.melon.fragments.searchandadd;

import android.view.View.OnClickListener;
import android.view.View;

public final class d implements View.OnClickListener {
    public final int a;
    public final SearchAndAddBaseFragment b;

    public d(SearchAndAddBaseFragment searchAndAddBaseFragment0, int v) {
        this.a = v;
        this.b = searchAndAddBaseFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            SongListAdapter.onBindViewHolder$lambda$1(((PlaylistSearchAndAddPlaylistFragment)this.b), view0);
            return;
        }
        ToggleFilterHolder._init_$lambda$0(((PlaylistSearchAndAddLikeFragment)this.b), view0);
    }
}

