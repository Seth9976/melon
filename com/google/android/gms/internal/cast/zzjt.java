package com.google.android.gms.internal.cast;

import java.util.Comparator;
import java.util.Map.Entry;

final class zzjt implements Comparator {
    @Override
    public final int compare(Object object0, Object object1) {
        return ((String)((Map.Entry)object0).getKey()).compareTo(((String)((Map.Entry)object1).getKey()));
    }
}

