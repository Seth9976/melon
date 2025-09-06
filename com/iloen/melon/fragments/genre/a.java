package com.iloen.melon.fragments.genre;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v5x.response.GenreDetailArtistRes.RESPONSE.ALBUMLIST;
import com.melon.net.res.common.AlbumInfoBase;

public final class a implements View.OnClickListener {
    public final int a;
    public final boolean b;
    public final int c;
    public final MetaContentBaseFragment d;
    public final AlbumInfoBase e;
    public final p f;

    public a(boolean z, MetaContentBaseFragment metaContentBaseFragment0, int v, AlbumInfoBase albumInfoBase0, p p0, int v1) {
        this.a = v1;
        this.b = z;
        this.d = metaContentBaseFragment0;
        this.c = v;
        this.e = albumInfoBase0;
        this.f = p0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                AlbumAdapter.onBindViewImpl$lambda$0(this.b, ((GenreArtistDetailBottomFragment)this.d), this.c, ((ALBUMLIST)this.e), ((AlbumAdapter)this.f), view0);
                return;
            }
            case 1: {
                GenreMasterpieceAdapter.onBindViewImpl$lambda$0(this.b, ((GenreDetailMoreMasterPieceFragment)this.d), this.c, ((com.iloen.melon.net.v5x.response.GenreMoreMasterpieceRes.RESPONSE.ALBUMLIST)this.e), ((GenreMasterpieceAdapter)this.f), view0);
                return;
            }
            default: {
                NewSongAdapter.onBindViewImpl$lambda$5(this.b, ((GenreDetailMoreNewSongFragment)this.d), this.c, this.e, ((NewSongAdapter)this.f), view0);
            }
        }
    }
}

