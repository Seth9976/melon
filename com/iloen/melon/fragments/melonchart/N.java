package com.iloen.melon.fragments.melonchart;

import android.view.View.OnClickListener;
import android.view.View;

public final class n implements View.OnClickListener {
    public final int a;
    public final MelonChartGenreFragment b;

    public n(MelonChartGenreFragment melonChartGenreFragment0, int v) {
        this.a = v;
        this.b = melonChartGenreFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                MelonChartGenreFragment.onViewCreated$lambda$1(this.b, view0);
                return;
            }
            case 1: {
                MelonChartGenreFragment.onViewCreated$lambda$3(this.b, view0);
                return;
            }
            case 2: {
                MelonChartGenreFragment.onViewCreated$lambda$4(this.b, view0);
                return;
            }
            default: {
                MelonChartGenreFragment.setFilterLayout$lambda$18(this.b, view0);
            }
        }
    }
}

