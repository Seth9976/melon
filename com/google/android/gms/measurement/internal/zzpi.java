package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzib;
import java.util.Map.Entry;
import java.util.Map;

public final class zzpi {
    private final long zza;
    private final zzib zzb;
    private final String zzc;
    private final Map zzd;
    private final zzlr zze;
    private final long zzf;
    private final long zzg;
    private final long zzh;
    private final int zzi;

    public zzpi(long v, zzib zzib0, String s, Map map0, zzlr zzlr0, long v1, long v2, long v3, int v4, byte[] arr_b) {
        this.zza = v;
        this.zzb = zzib0;
        this.zzc = s;
        this.zzd = map0;
        this.zze = zzlr0;
        this.zzf = v1;
        this.zzg = v2;
        this.zzh = v3;
        this.zzi = v4;
    }

    public final zzos zza() {
        return new zzos(this.zzc, this.zzd, this.zze, null);
    }

    public final zzol zzb() {
        Bundle bundle0 = new Bundle();
        for(Object object0: this.zzd.entrySet()) {
            bundle0.putString(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
        }
        byte[] arr_b = this.zzb.zzcc();
        return new zzol(this.zza, arr_b, this.zzc, bundle0, this.zze.zza(), this.zzg, "");
    }

    public final long zzc() {
        return this.zza;
    }

    public final zzib zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zzc;
    }

    public final zzlr zzf() {
        return this.zze;
    }

    public final long zzg() {
        return this.zzf;
    }

    public final long zzh() {
        return this.zzh;
    }

    public final int zzi() {
        return this.zzi;
    }
}

