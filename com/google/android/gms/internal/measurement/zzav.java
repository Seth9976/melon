package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

public abstract class zzav {
    final List zza;

    public zzav() {
        this.zza = new ArrayList();
    }

    public abstract zzao zza(String arg1, zzg arg2, List arg3);

    public final zzao zzb(String s) {
        zzbk zzbk0 = zzh.zze(s);
        if(!this.zza.contains(zzbk0)) {
            throw new IllegalArgumentException("Command not supported");
        }
        throw new UnsupportedOperationException("Command not implemented: " + s);
    }
}

