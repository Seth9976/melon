package com.iloen.melon.fragments.mymusic;

import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.melon.ui.k2;
import we.k;

public final class a implements k {
    public final int a;
    public final MetaContentBaseFragment b;

    public a(MetaContentBaseFragment metaContentBaseFragment0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.a == 0 ? DjPlaylistFragment.makePlaylist$lambda$8(((DjPlaylistFragment)this.b), ((k2)object0)) : PlaylistFragment.makePlaylist$lambda$7(((PlaylistFragment)this.b), ((k2)object0));
    }
}

