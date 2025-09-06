package com.iloen.melon.viewholders;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;

public final class k implements View.OnClickListener {
    public final ArtistPlayListInfoBase a;
    public final PlaylistNewHolderImpl b;

    public k(PlaylistNewHolderImpl playlistNewHolderImpl0, ArtistPlayListInfoBase artistPlayListInfoBase0) {
        this.b = playlistNewHolderImpl0;
        this.a = artistPlayListInfoBase0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        PlaylistNewHolderImpl playlistNewHolderImpl0 = this.b;
        if(playlistNewHolderImpl0.mOnClickListener != null) {
            playlistNewHolderImpl0.mOnClickListener.clickItemView(this.a);
        }
    }
}

