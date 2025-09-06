package com.google.android.exoplayer2.offline;

import java.util.Comparator;

public final class d implements Comparator {
    @Override
    public final int compare(Object object0, Object object1) {
        return InternalHandler.compareStartTimes(((Download)object0), ((Download)object1));
    }
}

