package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzis;
import java.util.Collections;
import java.util.Map;

public final class zzos {
    private final String zza;
    private final Map zzb;
    private final zzlr zzc;
    private final zzis zzd;

    public zzos(String s, Map map0, zzlr zzlr0, zzis zzis0) {
        this.zza = s;
        this.zzb = map0;
        this.zzc = zzlr0;
        this.zzd = zzis0;
    }

    public final String zza() {
        return this.zza;
    }

    public final Map zzb() {
        return this.zzb == null ? Collections.EMPTY_MAP : this.zzb;
    }

    public final zzlr zzc() {
        return this.zzc;
    }

    public final zzis zzd() {
        return this.zzd;
    }
}

