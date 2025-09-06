package com.google.android.gms.internal.cast;

import java.util.Comparator;

final class zzjr implements Comparator {
    @Override
    public final int compare(Object object0, Object object1) {
        zzjx zzjx0 = zzjx.zza(object0);
        zzjx zzjx1 = zzjx.zza(object1);
        if(zzjx0 == zzjx1) {
            switch(zzjx0.ordinal()) {
                case 0: {
                    return ((Boolean)object0).compareTo(((Boolean)object1));
                }
                case 1: {
                    return ((String)object0).compareTo(((String)object1));
                }
                case 2: {
                    return ((Long)object0).compareTo(((Long)object1));
                }
                case 3: {
                    return ((Double)object0).compareTo(((Double)object1));
                }
                default: {
                    throw null;
                }
            }
        }
        return zzjx0.compareTo(zzjx1);
    }
}

