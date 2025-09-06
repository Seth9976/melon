package com.iloen.melon.fragments.shortform;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;

public final class n implements View.OnClickListener {
    public final int a;
    public final TrendShortLyricsFragment b;
    public final SLOTLIST c;

    public n(TrendShortLyricsFragment trendShortLyricsFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, int v) {
        this.a = v;
        this.b = trendShortLyricsFragment0;
        this.c = trendShortFormRes$Response$SLOTLIST0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            TrendShortLyricsFragment.updateUI$lambda$7(this.b, this.c, view0);
            return;
        }
        TrendShortLyricsFragment.updateUI$lambda$2(this.b, this.c, view0);
    }
}

