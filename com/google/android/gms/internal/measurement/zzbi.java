package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzbi extends zzav {
    @Override  // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String s, zzg zzg0, List list0) {
        if(s == null || s.isEmpty() || !zzg0.zzd(s)) {
            throw new IllegalArgumentException("Command not found: " + s);
        }
        zzao zzao0 = zzg0.zzh(s);
        if(!(zzao0 instanceof zzai)) {
            throw new IllegalArgumentException("Function " + s + " is not defined");
        }
        return ((zzai)zzao0).zza(zzg0, list0);
    }
}

