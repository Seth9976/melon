package com.iloen.melon.fragments.shortform;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;

public final class b implements View.OnClickListener {
    public final int a;
    public final TrendEmphasizeSongFragment b;
    public final SLOTLIST c;

    public b(TrendEmphasizeSongFragment trendEmphasizeSongFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, int v) {
        this.a = v;
        this.b = trendEmphasizeSongFragment0;
        this.c = trendShortFormRes$Response$SLOTLIST0;
        super();
    }

    public b(SLOTLIST trendShortFormRes$Response$SLOTLIST0, TrendEmphasizeSongFragment trendEmphasizeSongFragment0) {
        this.a = 2;
        super();
        this.c = trendShortFormRes$Response$SLOTLIST0;
        this.b = trendEmphasizeSongFragment0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                TrendEmphasizeSongFragment.onViewCreated$lambda$4(this.b, this.c, view0);
                return;
            }
            case 1: {
                TrendEmphasizeSongFragment.onViewCreated$lambda$6(this.b, this.c, view0);
                return;
            }
            default: {
                TrendEmphasizeSongFragment.m(this.b, this.c, view0);
            }
        }
    }
}

