package com.iloen.melon.fragments.genre;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.GenreMoreArtistRes.RESPONSE.ARTISTLIST;

public final class m implements View.OnClickListener {
    public final int a;
    public final GenreArtistAdapter b;
    public final ARTISTLIST c;

    public m(GenreArtistAdapter genreDetailMoreArtistFragment$GenreArtistAdapter0, ARTISTLIST genreMoreArtistRes$RESPONSE$ARTISTLIST0, int v) {
        this.a = v;
        this.b = genreDetailMoreArtistFragment$GenreArtistAdapter0;
        this.c = genreMoreArtistRes$RESPONSE$ARTISTLIST0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            GenreArtistAdapter.onBindViewImpl$lambda$2(this.b, this.c, view0);
            return;
        }
        GenreArtistAdapter.onBindViewImpl$lambda$1(this.b, this.c, view0);
    }
}

