package com.google.android.exoplayer2.util;

import java.util.Comparator;

public final class b implements Comparator {
    public final int a;

    public b(int v) {
        this.a = v;
        super();
    }

    @Override
    public final int compare(Object object0, Object object1) {
        return this.a == 0 ? SlidingPercentile.lambda$static$0(((Sample)object0), ((Sample)object1)) : SlidingPercentile.lambda$static$1(((Sample)object0), ((Sample)object1));
    }
}

