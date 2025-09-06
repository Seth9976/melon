package com.google.android.gms.flags;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;
import java.util.Collection;

public class FlagRegistry {
    private final Collection zza;
    private final Collection zzb;
    private final Collection zzc;

    public FlagRegistry() {
        this.zza = new ArrayList();
        this.zzb = new ArrayList();
        this.zzc = new ArrayList();
    }

    @KeepForSdk
    public static void initialize(Context context0) {
        Singletons.zza().zzb(context0);
    }

    public final void zza(Flag flag0) {
        this.zza.add(flag0);
    }
}

