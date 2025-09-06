package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.framework.SessionTransferCallback;

public final class zzk extends SessionTransferCallback {
    final zzl zza;

    public zzk(zzl zzl0) {
        this.zza = zzl0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferFailed(int v, int v1) {
        zzl.zze().d("onTransferFailed with type = %d and reason = %d", new Object[]{v, v1});
        zzl.zzk(this.zza);
        zzqe zzqe0 = zzl.zzd(this.zza).zzf(zzl.zzc(this.zza), v, v1);
        zzl.zzb(this.zza).zzf(zzqe0, 0xE8);
        zzl.zzi(this.zza, false);
    }

    @Override  // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferred(int v, SessionState sessionState0) {
        zzl.zze().d("onTransferred with type = %d", new Object[]{v});
        zzl.zzk(this.zza);
        zzqe zzqe0 = zzl.zzd(this.zza).zzg(zzl.zzc(this.zza), v);
        zzl.zzb(this.zza).zzf(zzqe0, 0xE7);
        zzl.zzi(this.zza, false);
        zzl.zzg(this.zza, null);
    }

    @Override  // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferring(int v) {
        zzl.zze().d("onTransferring with type = %d", new Object[]{v});
        zzl.zzi(this.zza, true);
        zzl.zzk(this.zza);
        zzqe zzqe0 = zzl.zzd(this.zza).zzg(zzl.zzc(this.zza), v);
        zzl.zzb(this.zza).zzf(zzqe0, 230);
    }
}

