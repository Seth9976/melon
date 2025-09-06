package com.iloen.melon.fragments.shortform;

import android.view.View.OnClickListener;
import android.view.View;

public final class l implements View.OnClickListener {
    public final int a;
    public final TrendShortFormFragment b;

    public l(TrendShortFormFragment trendShortFormFragment0, int v) {
        this.a = v;
        this.b = trendShortFormFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            TrendShortFormFragment.onViewCreated$lambda$4(this.b, view0);
            return;
        }
        TrendShortFormFragment.onViewCreated$lambda$3(this.b, view0);
    }
}

