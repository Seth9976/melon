package com.iloen.melon.fragments.genre;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.FilterDropDownView;
import com.iloen.melon.custom.G;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v5x.response.GenreDetailArtistRes;
import com.iloen.melon.net.v5x.response.GenreLabelAlbumlistRes;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes;
import com.iloen.melon.net.v5x.response.GenreLabelIntroRes;
import com.iloen.melon.net.v5x.response.GenreMoreIntroRes;

public final class c implements ErrorListener, Listener, G {
    public final int a;
    public final MetaContentBaseFragment b;

    public c(MetaContentBaseFragment metaContentBaseFragment0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.G
    public void onClick(FilterDropDownView filterDropDownView0) {
        GenreDetailMoreMasterPieceFragment.initFilterLayout$lambda$11$lambda$10(((GenreDetailMoreMasterPieceFragment)this.b), filterDropDownView0);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        switch(this.a) {
            case 0: {
                GenreArtistDetailFragment.onFetchStart$lambda$1(((GenreArtistDetailFragment)this.b), ((GenreDetailArtistRes)object0));
                return;
            }
            case 1: {
                GenreDetailLabelAlbumListFragment.onFetchStart$lambda$1(((GenreDetailLabelAlbumListFragment)this.b), ((GenreLabelAlbumlistRes)object0));
                return;
            }
            case 3: {
                GenreDetailLabelFragment.onFetchStart$lambda$0(((GenreDetailLabelFragment)this.b), ((GenreLabelDetailRes)object0));
                return;
            }
            case 4: {
                GenreDetailLabelIntroFragment.onFetchStart$lambda$0(((GenreDetailLabelIntroFragment)this.b), ((GenreLabelIntroRes)object0));
                return;
            }
            default: {
                GenreDetailMoreIntroFragment.onFetchStart$lambda$0(((GenreDetailMoreIntroFragment)this.b), ((GenreMoreIntroRes)object0));
            }
        }
    }
}

