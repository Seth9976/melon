package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.CastDevice;
import java.util.function.Function;

public final class zzdl implements Function {
    public final CastDevice zza;
    public final String zzb;

    public zzdl(CastDevice castDevice0, String s) {
        this.zza = castDevice0;
        this.zzb = s;
    }

    @Override
    public final Object apply(Object object0) {
        String s = (String)object0;
        return new zzdk(this.zza, this.zzb, null);
    }
}

