package com.google.android.gms.cast.framework.media;

import java.util.HashSet;
import java.util.Set;

final class zzbk {
    final RemoteMediaClient zza;
    private final Set zzb;
    private final long zzc;
    private final Runnable zzd;
    private boolean zze;

    public zzbk(RemoteMediaClient remoteMediaClient0, long v) {
        this.zza = remoteMediaClient0;
        super();
        this.zzb = new HashSet();
        this.zzc = v;
        this.zzd = new zzbj(this);
    }

    public static long zza(zzbk zzbk0) {
        return zzbk0.zzc;
    }

    public final long zzb() {
        return this.zzc;
    }

    public final void zzd(ProgressListener remoteMediaClient$ProgressListener0) {
        this.zzb.add(remoteMediaClient$ProgressListener0);
    }

    public final void zze(ProgressListener remoteMediaClient$ProgressListener0) {
        this.zzb.remove(remoteMediaClient$ProgressListener0);
    }

    public final void zzf() {
        this.zza.zzc.removeCallbacks(this.zzd);
        this.zze = true;
        this.zza.zzc.postDelayed(this.zzd, this.zzc);
    }

    public final void zzg() {
        this.zza.zzc.removeCallbacks(this.zzd);
        this.zze = false;
    }

    public final boolean zzh() {
        return !this.zzb.isEmpty();
    }

    public final boolean zzi() {
        return this.zze;
    }
}

