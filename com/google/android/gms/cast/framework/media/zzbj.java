package com.google.android.gms.cast.framework.media;

import java.util.TimerTask;

final class zzbj extends TimerTask {
    final zzbk zza;

    public zzbj(zzbk zzbk0) {
        this.zza = zzbk0;
        super();
    }

    @Override
    public final void run() {
        this.zza.zza.zzx(this.zza.zzb);
        this.zza.zza.zzc.postDelayed(this, zzbk.zza(this.zza));
    }
}

