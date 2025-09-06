package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.zzu;

final class zzt implements zzu {
    final zzx zza;

    public zzt(zzx zzx0, zzw zzw0) {
        this.zza = zzx0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.zzu
    public final void zza() {
        zzcb zzcb0 = new zzcb(new zzca(3));
        zzx.zzf(this.zza, zzcb0);
    }

    @Override  // com.google.android.gms.cast.framework.zzu
    public final void zzb() {
        zzx.zzc(this.zza).zze();
    }

    @Override  // com.google.android.gms.cast.framework.zzu
    public final void zzc(String s, long v, int v1, long v2, long v3) {
        zzz zzz0 = zzx.zzc(this.zza);
        zzby zzby0 = new zzby(s);
        zzby0.zzf(v);
        zzby0.zzh(v1);
        zzby0.zzg(v2);
        zzby0.zze(v3);
        zzz0.zzb(new zzbz(zzby0));
    }

    @Override  // com.google.android.gms.cast.framework.zzu
    public final void zzd(MediaStatus mediaStatus0) {
        if(mediaStatus0 == null) {
            return;
        }
        zzx.zzc(this.zza).zzi(new zzr(new zzq(mediaStatus0)));
    }
}

