package com.iloen.melon.fragments.melonchart;

import android.view.View.OnScrollChangeListener;
import android.view.View;

public final class o implements View.OnScrollChangeListener {
    public final MelonChartGenreFragment a;

    public o(MelonChartGenreFragment melonChartGenreFragment0) {
        this.a = melonChartGenreFragment0;
    }

    @Override  // android.view.View$OnScrollChangeListener
    public final void onScrollChange(View view0, int v, int v1, int v2, int v3) {
        MelonChartGenreFragment.onViewCreated$lambda$2(this.a, view0, v, v1, v2, v3);
    }
}

