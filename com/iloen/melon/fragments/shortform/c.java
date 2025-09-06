package com.iloen.melon.fragments.shortform;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;

public final class c implements View.OnClickListener {
    public final int a;
    public final TrendMagazineFragment b;
    public final SLOTLIST c;

    public c(TrendMagazineFragment trendMagazineFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, int v) {
        this.a = v;
        this.b = trendMagazineFragment0;
        this.c = trendShortFormRes$Response$SLOTLIST0;
        super();
    }

    public c(SLOTLIST trendShortFormRes$Response$SLOTLIST0, TrendMagazineFragment trendMagazineFragment0) {
        this.a = 2;
        super();
        this.c = trendShortFormRes$Response$SLOTLIST0;
        this.b = trendMagazineFragment0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                TrendMagazineFragment.onViewCreated$lambda$2(this.b, this.c, view0);
                return;
            }
            case 1: {
                TrendMagazineFragment.onViewCreated$lambda$4(this.b, this.c, view0);
                return;
            }
            default: {
                TrendMagazineFragment.n(this.b, this.c, view0);
            }
        }
    }
}

