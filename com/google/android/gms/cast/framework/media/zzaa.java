package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.internal.zzat;

final class zzaa extends zzbg {
    final TextTrackStyle zza;
    final RemoteMediaClient zzb;

    public zzaa(RemoteMediaClient remoteMediaClient0, TextTrackStyle textTrackStyle0) {
        this.zza = textTrackStyle0;
        this.zzb = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzb.zzd.zzH(zzat0, this.zza);
    }
}

