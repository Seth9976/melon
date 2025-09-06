package com.google.android.gms.cast.framework;

import android.content.Context;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.internal.cast.zzbf;
import java.util.concurrent.Callable;

public final class zzi implements Callable {
    public final Context zza;
    public final CastOptions zzb;
    public final OptionsProvider zzc;
    public final zzbf zzd;
    public final zzn zze;

    public zzi(Context context0, CastOptions castOptions0, OptionsProvider optionsProvider0, zzbf zzbf0, zzn zzn0) {
        this.zza = context0;
        this.zzb = castOptions0;
        this.zzc = optionsProvider0;
        this.zzd = zzbf0;
        this.zze = zzn0;
    }

    @Override
    public final Object call() {
        return CastContext.zzc(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}

