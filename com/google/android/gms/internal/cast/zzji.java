package com.google.android.gms.internal.cast;

import java.util.Set;
import java.util.logging.Level;

public final class zzji implements zzjb {
    private final String zza;
    private final Level zzb;
    private final Set zzc;
    private final zzis zzd;
    private final int zze;

    private zzji() {
        this("", true, 2, Level.ALL, false, zzjl.zzd(), zzjl.zzb());
    }

    public zzji(zzjk zzjk0) {
        this("", true, 2, Level.ALL, false, zzjl.zzd(), zzjl.zzb());
    }

    private zzji(String s, boolean z, int v, Level level0, boolean z1, Set set0, zzis zzis0) {
        this.zza = "";
        this.zze = 2;
        this.zzb = level0;
        this.zzc = set0;
        this.zzd = zzis0;
    }

    @Override  // com.google.android.gms.internal.cast.zzjb
    public final zzii zza(String s) {
        return new zzjl(this.zza, s, true, 2, this.zzb, this.zzc, this.zzd, null);
    }

    public final zzji zzb(boolean z) {
        return new zzji(this.zza, true, 2, Level.OFF, false, this.zzc, this.zzd);
    }
}

