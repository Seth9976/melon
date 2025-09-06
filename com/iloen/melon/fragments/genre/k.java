package com.iloen.melon.fragments.genre;

import android.view.View;
import com.android.volley.Response.Listener;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v5x.response.GenreDetailArtistRes;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.PLYLSTINFO.PLYLSTLIST;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes;
import com.iloen.melon.net.v5x.response.GenreMoreArtistRes;
import com.iloen.melon.net.v5x.response.GenreMoreMasterpieceRes;
import com.iloen.melon.net.v5x.response.GenreMoreNewMusicRes;
import com.iloen.melon.net.v5x.response.GenreMorePlaylistRes;
import com.iloen.melon.viewholders.DjPlaylistNewHolderImpl.OnLongClickListener;
import v9.i;

public final class k implements Listener, OnLongClickListener {
    public final int a;
    public final MetaContentBaseFragment b;
    public final Object c;

    public k(MetaContentBaseFragment metaContentBaseFragment0, Object object0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        this.c = object0;
        super();
    }

    @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnLongClickListener
    public void a(View view0, int v) {
        GenreDetailLabelAdapter.onBindViewImpl$lambda$26$lambda$25$lambda$24(((GenreDetailLabelBottomFragment)this.b), ((PLYLSTLIST)this.c), view0, v);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        switch(this.a) {
            case 1: {
                GenreArtistDetailBottomFragment.onFetchStart$lambda$0(((GenreArtistDetailBottomFragment)this.b), ((i)this.c), ((GenreDetailArtistRes)object0));
                return;
            }
            case 2: {
                GenreDetailLabelBottomFragment.onFetchStart$lambda$0(((GenreDetailLabelBottomFragment)this.b), ((i)this.c), ((GenreLabelDetailRes)object0));
                return;
            }
            case 3: {
                GenreDetailMoreArtistFragment.onFetchStart$lambda$1(((GenreDetailMoreArtistFragment)this.b), ((i)this.c), ((GenreMoreArtistRes)object0));
                return;
            }
            case 4: {
                GenreDetailMoreMasterPieceFragment.onFetchStart$lambda$0(((GenreDetailMoreMasterPieceFragment)this.b), ((i)this.c), ((GenreMoreMasterpieceRes)object0));
                return;
            }
            case 5: {
                GenreDetailMoreNewSongFragment.onFetchStart$lambda$3(((GenreDetailMoreNewSongFragment)this.b), ((i)this.c), ((GenreMoreNewMusicRes)object0));
                return;
            }
            default: {
                GenreDetailMorePlaylistFragment.onFetchStart$lambda$0(((GenreDetailMorePlaylistFragment)this.b), ((i)this.c), ((GenreMorePlaylistRes)object0));
            }
        }
    }
}

