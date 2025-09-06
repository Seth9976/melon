package com.iloen.melon.fragments.genre;

import a9.d;
import android.view.View;
import com.iloen.melon.custom.J;
import com.iloen.melon.custom.K;
import com.iloen.melon.custom.S;

public final class p implements d, J, K {
    public final GenreDetailMoreNewSongFragment a;

    public p(GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0) {
        this.a = genreDetailMoreNewSongFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.J
    public void a(S s0, boolean z) {
        GenreDetailMoreNewSongFragment.showSortingBarButton$lambda$1(this.a, s0, z);
    }

    @Override  // com.iloen.melon.custom.K
    public void onClick(View view0) {
        GenreDetailMoreNewSongFragment.showSortingBarButton$lambda$2(this.a, view0);
    }

    @Override  // a9.d
    public void onSelected(int v) {
        GenreDetailMoreNewSongFragment.onViewCreated$lambda$0(this.a, v);
    }
}

