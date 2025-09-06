package com.iloen.melon.fragments.shortform;

import java.util.List;
import v8.i;

public final class k implements we.k {
    public final int a;
    public final TrendShortFormFragment b;

    public k(TrendShortFormFragment trendShortFormFragment0, int v) {
        this.a = v;
        this.b = trendShortFormFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return TrendShortFormFragment.initPager$lambda$9(this.b, ((int)(((Integer)object0))));
            }
            case 1: {
                return TrendShortFormFragment.onViewCreated$lambda$5(this.b, ((i)object0));
            }
            default: {
                return TrendShortFormFragment.onViewCreated$lambda$6(this.b, ((List)object0));
            }
        }
    }
}

