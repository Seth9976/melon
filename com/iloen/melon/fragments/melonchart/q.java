package com.iloen.melon.fragments.melonchart;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.common.ChartSongInfoBase;

public final class q implements View.OnClickListener {
    public final int a;
    public final MelonChartGenreFragment b;
    public final ChartSongInfoBase c;
    public final GenreAdapter d;
    public final int e;

    public q(MelonChartGenreFragment melonChartGenreFragment0, ChartSongInfoBase chartSongInfoBase0, GenreAdapter melonChartGenreFragment$GenreAdapter0, int v, int v1) {
        this.a = v1;
        this.b = melonChartGenreFragment0;
        this.c = chartSongInfoBase0;
        this.d = melonChartGenreFragment$GenreAdapter0;
        this.e = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            GenreAdapter.onBindViewImpl$lambda$4(this.b, this.c, this.d, this.e, view0);
            return;
        }
        GenreAdapter.onBindViewImpl$lambda$3(this.b, this.c, this.d, this.e, view0);
    }
}

