package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzlq {
    static final zzlq zza = null;
    public static final int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzlq zzd;
    private final Map zze;

    static {
        zzlq.zza = new zzlq(true);
    }

    public zzlq() {
        this.zze = new HashMap();
    }

    public zzlq(boolean z) {
        this.zze = Collections.EMPTY_MAP;
    }

    public static zzlq zza() {
        zzlq zzlq0 = zzlq.zzd;
        if(zzlq0 != null) {
            return zzlq0;
        }
        synchronized(zzlq.class) {
            zzlq zzlq1 = zzlq.zzd;
            if(zzlq1 != null) {
                return zzlq1;
            }
            zzlq zzlq2 = zzly.zzb(zzlq.class);
            zzlq.zzd = zzlq2;
            return zzlq2;
        }
    }

    public final zzmd zzb(zznl zznl0, int v) {
        zzlp zzlp0 = new zzlp(zznl0, v);
        return (zzmd)this.zze.get(zzlp0);
    }
}

