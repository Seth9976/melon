package com.iloen.melon.fragments.genre;

import a9.d;
import com.iloen.melon.custom.FilterDropDownView;
import com.iloen.melon.custom.G;

public final class l implements d, G {
    public final GenreDetailMoreArtistFragment a;

    public l(GenreDetailMoreArtistFragment genreDetailMoreArtistFragment0) {
        this.a = genreDetailMoreArtistFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.G
    public void onClick(FilterDropDownView filterDropDownView0) {
        GenreDetailMoreArtistFragment.updateFileterLayout$lambda$4$lambda$3$lambda$2(this.a, filterDropDownView0);
    }

    @Override  // a9.d
    public void onSelected(int v) {
        GenreDetailMoreArtistFragment.showFilterPopup$lambda$7(this.a, v);
    }
}

