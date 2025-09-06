package com.iloen.melon.fragments.shortform;

import androidx.compose.runtime.l;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import we.n;

public final class e implements n {
    public final SLOTLIST a;

    public e(SLOTLIST trendShortFormRes$Response$SLOTLIST0) {
        this.a = trendShortFormRes$Response$SLOTLIST0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return TrendMusicWaveExclusiveFragment.onViewCreated$lambda$4(this.a, ((l)object0), ((int)(((Integer)object1))));
    }
}

