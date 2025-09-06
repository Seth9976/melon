package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzcd {
    static final zzcd zza = null;
    private static volatile boolean zzb = false;
    private static volatile zzcd zzc;
    private final Map zzd;

    static {
        zzcd.zza = new zzcd(true);
    }

    public zzcd() {
        this.zzd = new HashMap();
    }

    public zzcd(boolean z) {
        this.zzd = Collections.EMPTY_MAP;
    }

    public static zzcd zza() {
        zzcd zzcd0 = zzcd.zzc;
        if(zzcd0 != null) {
            return zzcd0;
        }
        synchronized(zzcd.class) {
            zzcd zzcd1 = zzcd.zzc;
            if(zzcd1 != null) {
                return zzcd1;
            }
            zzcd zzcd2 = zzcl.zzb(zzcd.class);
            zzcd.zzc = zzcd2;
            return zzcd2;
        }
    }

    public final zzcq zzb(zzec zzec0, int v) {
        zzcc zzcc0 = new zzcc(zzec0, v);
        return (zzcq)this.zzd.get(zzcc0);
    }
}

