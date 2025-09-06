package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

final class zzaz implements Comparator {
    final zzai zza;
    final zzg zzb;

    public zzaz(zzai zzai0, zzg zzg0) {
        this.zza = zzai0;
        this.zzb = zzg0;
        super();
    }

    @Override
    public final int compare(Object object0, Object object1) {
        if(((zzao)object0) instanceof zzat) {
            return ((zzao)object1) instanceof zzat ? 0 : 1;
        }
        if(((zzao)object1) instanceof zzat) {
            return -1;
        }
        zzai zzai0 = this.zza;
        if(zzai0 == null) {
            return ((zzao)object0).zzc().compareTo(((zzao)object1).zzc());
        }
        List list0 = Arrays.asList(new zzao[]{((zzao)object0), ((zzao)object1)});
        return (int)zzh.zzi(((double)zzai0.zza(this.zzb, list0).zzd()));
    }
}

