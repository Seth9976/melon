package com.google.android.gms.internal.cast;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class zzyy extends zzzd {
    public zzyy() {
        super(null);
    }

    @Override  // com.google.android.gms.internal.cast.zzzd
    public final void zza() {
        if(!this.zzj()) {
            for(int v = 0; v < this.zzc(); ++v) {
                Map.Entry map$Entry0 = this.zzg(v);
                if(((zzxa)((zzyz)map$Entry0).zza()).zze()) {
                    map$Entry0.setValue(Collections.unmodifiableList(((List)map$Entry0.getValue())));
                }
            }
            for(Object object0: this.zzd()) {
                Map.Entry map$Entry1 = (Map.Entry)object0;
                if(((zzxa)map$Entry1.getKey()).zze()) {
                    map$Entry1.setValue(Collections.unmodifiableList(((List)map$Entry1.getValue())));
                }
            }
        }
        super.zza();
    }
}

