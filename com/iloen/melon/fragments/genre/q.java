package com.iloen.melon.fragments.genre;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.net.v5x.response.GenreMoreNewMusicRes.RESPONSE.SONGLIST;
import com.iloen.melon.net.v5x.response.GenrePlayListInfoBase;
import java.io.Serializable;

public final class q implements View.OnClickListener {
    public final int a;
    public final DetailMetaContentBaseFragment b;
    public final Serializable c;
    public final p d;

    public q(DetailMetaContentBaseFragment detailMetaContentBaseFragment0, Serializable serializable0, p p0, int v) {
        this.a = v;
        this.b = detailMetaContentBaseFragment0;
        this.c = serializable0;
        this.d = p0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                NewSongAdapter.onBindViewImpl$lambda$2(((GenreDetailMoreNewSongFragment)this.b), ((SONGLIST)this.c), ((NewSongAdapter)this.d), view0);
                return;
            }
            case 1: {
                NewSongAdapter.onBindViewImpl$lambda$3(((GenreDetailMoreNewSongFragment)this.b), ((SONGLIST)this.c), ((NewSongAdapter)this.d), view0);
                return;
            }
            default: {
                PlaylistAdapter.onBindViewImpl$lambda$2$lambda$1(((GenreDetailMorePlaylistFragment)this.b), ((GenrePlayListInfoBase)this.c), ((PlaylistAdapter)this.d), view0);
            }
        }
    }
}

