package com.iloen.melon.fragments.melonchart;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.common.ChartAlbumInfoBase;

public final class r implements View.OnClickListener {
    public final boolean a;
    public final MelonChartGenreFragment b;
    public final int c;
    public final ChartAlbumInfoBase d;
    public final GenreAdapter e;

    public r(boolean z, MelonChartGenreFragment melonChartGenreFragment0, int v, ChartAlbumInfoBase chartAlbumInfoBase0, GenreAdapter melonChartGenreFragment$GenreAdapter0) {
        this.a = z;
        this.b = melonChartGenreFragment0;
        this.c = v;
        this.d = chartAlbumInfoBase0;
        this.e = melonChartGenreFragment$GenreAdapter0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        GenreAdapter.onBindViewImpl$lambda$6(this.a, this.b, this.c, this.d, this.e, view0);
    }
}

