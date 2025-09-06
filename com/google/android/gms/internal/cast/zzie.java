package com.google.android.gms.internal.cast;

import A7.d;
import U4.x;

public class zzie {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;

    public zzie(String s, Class class0, boolean z) {
        this(s, class0, z, true);
    }

    private zzie(String s, Class class0, boolean z, boolean z1) {
        zzka.zzb(s);
        this.zza = s;
        this.zzb = class0;
        this.zzc = z;
    }

    @Override
    public final String toString() {
        return d.n(x.p(this.getClass().getName(), "/"), this.zza, "[", this.zzb.getName(), "]");
    }

    public static zzie zza(String s, Class class0) {
        return new zzie(s, class0, false, false);
    }

    public final boolean zzb() {
        return this.zzc;
    }
}

