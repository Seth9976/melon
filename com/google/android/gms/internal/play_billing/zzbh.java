package com.google.android.gms.internal.play_billing;

import java.util.Comparator;

final class zzbh implements Comparator {
    @Override
    public final int compare(Object object0, Object object1) {
        zzbg zzbg0 = new zzbg(((zzbq)object0));
        zzbg zzbg1 = new zzbg(((zzbq)object1));
        while(zzbg0.hasNext() && zzbg1.hasNext()) {
            int v = ((int)(zzbg0.zza() & 0xFF)).compareTo(((int)(zzbg1.zza() & 0xFF)));
            if(v != 0) {
                return v;
            }
            if(false) {
                break;
            }
        }
        return ((zzbq)object0).zzd().compareTo(((zzbq)object1).zzd());
    }
}

