package com.iloen.melon.fragments.genre;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v5x.response.GenreDetailArtistRes.RESPONSE.ALBUMLIST;
import com.iloen.melon.net.v5x.response.GenreMoreNewMusicRes.RESPONSE.SONGLIST;
import com.melon.net.res.common.AlbumInfoBase;

public final class b implements View.OnLongClickListener {
    public final int a;
    public final MetaContentBaseFragment b;
    public final AlbumInfoBase c;
    public final Object d;

    public b(MetaContentBaseFragment metaContentBaseFragment0, AlbumInfoBase albumInfoBase0, Object object0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        this.c = albumInfoBase0;
        this.d = object0;
        super();
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        switch(this.a) {
            case 0: {
                return AlbumAdapter.onBindViewImpl$lambda$2(((GenreArtistDetailBottomFragment)this.b), ((ALBUMLIST)this.c), ((AlbumAdapter)this.d), view0);
            }
            case 1: {
                return GenreDetailLabelAlbumListAdapter.onBindViewImpl$lambda$4$lambda$3$lambda$2(((GenreDetailLabelAlbumListFragment)this.b), ((com.iloen.melon.net.v5x.response.GenreLabelAlbumlistRes.RESPONSE.ALBUMLIST)this.c), ((com.iloen.melon.net.v5x.response.GenreLabelAlbumlistRes.RESPONSE.ALBUMLIST)this.d), view0);
            }
            case 2: {
                return NewSongAdapter.onBindViewImpl$lambda$1(((GenreDetailMoreNewSongFragment)this.b), ((SONGLIST)this.c), ((NewSongAdapter)this.d), view0);
            }
            default: {
                return NewSongAdapter.onBindViewImpl$lambda$7(((GenreDetailMoreNewSongFragment)this.b), this.c, ((NewSongAdapter)this.d), view0);
            }
        }
    }
}

