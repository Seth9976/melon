package com.iloen.melon.fragments.newmusic;

import com.android.volley.Response.Listener;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v4x.response.NewAlbumListRes;
import com.iloen.melon.net.v4x.response.NewMovieListRes;
import v9.i;

public final class b implements Listener {
    public final int a;
    public final i b;
    public final MetaContentBaseFragment c;

    public b(MetaContentBaseFragment metaContentBaseFragment0, i i0, int v) {
        this.a = v;
        this.c = metaContentBaseFragment0;
        this.b = i0;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        if(this.a != 0) {
            NewMvFragment.onFetchStart$lambda$0(((NewMvFragment)this.c), this.b, ((NewMovieListRes)object0));
            return;
        }
        NewAlbumFragment.request$lambda$7$lambda$6(((NewAlbumFragment)this.c), this.b, ((NewAlbumListRes)object0));
    }
}

