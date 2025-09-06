package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzat;

final class zzaq extends zzbg {
    final int zza;
    final int zzb;
    final int zzc;
    final RemoteMediaClient zzd;

    public zzaq(RemoteMediaClient remoteMediaClient0, boolean z, int v, int v1, int v2) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = v2;
        this.zzd = remoteMediaClient0;
        super(remoteMediaClient0, true);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzd.zzd.zzt(zzat0, this.zza, this.zzb, this.zzc);
    }
}

