package com.google.android.gms.flags;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class Singletons {
    private static Singletons zza;
    private final FlagRegistry zzb;
    private final zzb zzc;

    static {
        Singletons singletons0 = new Singletons();
        synchronized(Singletons.class) {
            Singletons.zza = singletons0;
        }
    }

    private Singletons() {
        this.zzb = new FlagRegistry();
        this.zzc = new zzb();
    }

    @KeepForSdk
    public static FlagRegistry flagRegistry() {
        return Singletons.zzb().zzb;
    }

    public static zzb zza() {
        return Singletons.zzb().zzc;
    }

    private static Singletons zzb() {
        synchronized(Singletons.class) {
        }
        return Singletons.zza;
    }
}

