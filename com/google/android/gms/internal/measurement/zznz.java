package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class zznz extends zzod {
    public zznz() {
        super(null);
    }

    @Override  // com.google.android.gms.internal.measurement.zzod
    public final void zza() {
        if(!this.zzb()) {
            for(int v = 0; v < this.zzc(); ++v) {
                Map.Entry map$Entry0 = this.zzd(v);
                if(((zzlu)((zzoa)map$Entry0).zza()).zzd()) {
                    map$Entry0.setValue(Collections.unmodifiableList(((List)map$Entry0.getValue())));
                }
            }
            for(Object object0: this.zze()) {
                Map.Entry map$Entry1 = (Map.Entry)object0;
                if(((zzlu)map$Entry1.getKey()).zzd()) {
                    map$Entry1.setValue(Collections.unmodifiableList(((List)map$Entry1.getValue())));
                }
            }
        }
        super.zza();
    }
}

