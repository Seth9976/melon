package com.iloen.melon.fragments.genre;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.GenreDetailArtistRes.RESPONSE.ARTIST;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.ARTISTLIST;
import com.iloen.melon.net.v5x.response.GenreMoreMasterpieceRes.RESPONSE.ALBUMLIST;
import com.melon.net.res.common.AlbumInfoBase;

public final class h implements View.OnClickListener {
    public final int a;
    public final Object b;

    public h(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                GenreDetailLabelAdapter.onBindViewImpl$lambda$23$lambda$22$lambda$17(((ARTISTLIST)this.b), view0);
                return;
            }
            case 1: {
                GenreArtistDetailFragment.updateHeader$lambda$7(((ARTIST)this.b), view0);
                return;
            }
            case 2: {
                GenreDetailLabelFragment.updateHeaderView$lambda$2(((GenreDetailLabelFragment)this.b), view0);
                return;
            }
            case 3: {
                GenreArtistAdapter.onBindViewImpl$lambda$0(((AlbumInfoBase)this.b), view0);
                return;
            }
            default: {
                GenreMasterpieceAdapter.onBindViewImpl$lambda$6(((ALBUMLIST)this.b), view0);
            }
        }
    }
}

