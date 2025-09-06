package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;

final class zznz {
    protected long zza;
    protected long zzb;
    final zzob zzc;
    private final zzay zzd;

    public zznz(zzob zzob0) {
        Objects.requireNonNull(zzob0);
        this.zzc = zzob0;
        super();
        this.zzd = new zzny(this, zzob0.zzu);
        long v = zzob0.zzu.zzaZ().elapsedRealtime();
        this.zza = v;
        this.zzb = v;
    }

    public final void zza(long v) {
        this.zzc.zzg();
        this.zzd.zzd();
        this.zza = v;
        this.zzb = v;
    }

    public final void zzb(long v) {
        this.zzd.zzd();
    }

    public final void zzc() {
        this.zzd.zzd();
        long v = this.zzc.zzu.zzaZ().elapsedRealtime();
        this.zza = v;
        this.zzb = v;
    }

    public final boolean zzd(boolean z, boolean z1, long v) {
        zzob zzob0 = this.zzc;
        zzob0.zzg();
        zzob0.zzb();
        if(zzob0.zzu.zzB()) {
            zzhg zzhg0 = zzob0.zzu.zzd();
            long v1 = zzob0.zzu.zzaZ().currentTimeMillis();
            zzhg0.zzk.zzb(v1);
        }
        long v2 = v - this.zza;
        if(!z && v2 < 1000L) {
            zzob0.zzu.zzaV().zzk().zzb("Screen exposed for less than 1000 ms. Event not sent. time", v2);
            return false;
        }
        if(!z1) {
            v2 = v - this.zzb;
            this.zzb = v;
        }
        zzob0.zzu.zzaV().zzk().zzb("Recording user engagement, ms", v2);
        Bundle bundle0 = new Bundle();
        bundle0.putLong("_et", v2);
        boolean z2 = zzob0.zzu.zzc().zzv();
        zzib zzib0 = zzob0.zzu;
        zzpo.zzav(zzib0.zzs().zzh(!z2), bundle0, true);
        if(!z1) {
            zzib0.zzj().zzF("auto", "_e", bundle0);
        }
        this.zza = v;
        this.zzd.zzd();
        long v3 = (long)(((Long)zzfx.zzaq.zzb(null)));
        this.zzd.zzb(v3);
        return true;
    }
}

