package com.iloen.melon.fragments.shortform;

import androidx.compose.runtime.l;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import we.n;

public final class d implements n {
    public final int a;
    public final SLOTLIST b;
    public final TrendMusicWaveExclusiveFragment c;

    public d(SLOTLIST trendShortFormRes$Response$SLOTLIST0, TrendMusicWaveExclusiveFragment trendMusicWaveExclusiveFragment0, int v) {
        this.a = v;
        this.b = trendShortFormRes$Response$SLOTLIST0;
        this.c = trendMusicWaveExclusiveFragment0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        return this.a == 0 ? TrendMusicWaveExclusiveFragment.onViewCreated$lambda$1(this.b, this.c, ((l)object0), v) : TrendMusicWaveExclusiveFragment.onViewCreated$lambda$3(this.b, this.c, ((l)object0), v);
    }
}

