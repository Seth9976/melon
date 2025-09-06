package com.iloen.melon.fragments.genre;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.GenreDetailArtistRes.RESPONSE.ALBUMLIST;
import com.iloen.melon.net.v5x.response.GenreDetailArtistRes.RESPONSE.ARTIST;
import com.iloen.melon.net.v5x.response.GenreMoreNewMusicRes.RESPONSE.SONGLIST;
import com.iloen.melon.net.v5x.response.GenrePlayListInfoBase;

public final class e implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;

    public e(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                GenreDetailLabelAdapter.onBindViewImpl$lambda$8$lambda$7$lambda$6(((GenreDetailLabelBottomFragment)this.b), ((ServerDataWrapper)this.c), view0);
                return;
            }
            case 1: {
                PlaylistAdapter.onBindViewImpl$lambda$2$lambda$0(((GenrePlayListInfoBase)this.b), ((GenrePlayListInfoBase)this.c), view0);
                return;
            }
            case 2: {
                AlbumAdapter.onBindViewImpl$lambda$1(((ALBUMLIST)this.b), ((GenreArtistDetailBottomFragment)this.c), view0);
                return;
            }
            case 3: {
                GenreArtistDetailFragment.updateHeader$lambda$4(((GenreArtistDetailFragment)this.b), ((ARTIST)this.c), view0);
                return;
            }
            case 4: {
                GenreDetailLabelAlbumListAdapter.onBindViewImpl$lambda$4$lambda$3$lambda$1(((com.iloen.melon.net.v5x.response.GenreLabelAlbumlistRes.RESPONSE.ALBUMLIST)this.b), ((GenreDetailLabelAlbumListFragment)this.c), view0);
                return;
            }
            case 5: {
                GenreMasterpieceAdapter.onBindViewImpl$lambda$1(((com.iloen.melon.net.v5x.response.GenreMoreMasterpieceRes.RESPONSE.ALBUMLIST)this.b), ((GenreDetailMoreMasterPieceFragment)this.c), view0);
                return;
            }
            case 6: {
                NewSongAdapter.onBindViewImpl$lambda$4(((GenreDetailMoreNewSongFragment)this.b), ((SONGLIST)this.c), view0);
                return;
            }
            default: {
                NewSongAdapter.onBindViewImpl$lambda$6(((String)this.b), ((GenreDetailMoreNewSongFragment)this.c), view0);
            }
        }
    }
}

