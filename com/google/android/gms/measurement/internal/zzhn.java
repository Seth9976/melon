package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;
import java.util.Objects;

final class zzhn implements zzo {
    final String zza;
    final zzhs zzb;

    public zzhn(zzhs zzhs0, String s) {
        this.zza = s;
        Objects.requireNonNull(zzhs0);
        this.zzb = zzhs0;
        super();
    }

    @Override  // com.google.android.gms.internal.measurement.zzo
    public final String zza(String s) {
        Map map0 = (Map)this.zzb.zzD().get(this.zza);
        return map0 == null || !map0.containsKey(s) ? null : ((String)map0.get(s));
    }
}

