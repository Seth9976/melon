package com.google.android.gms.cast;

final class zzai implements Runnable {
    final boolean zza;
    final CastRemoteDisplayLocalService zzb;

    public zzai(CastRemoteDisplayLocalService castRemoteDisplayLocalService0, boolean z) {
        this.zza = z;
        this.zzb = castRemoteDisplayLocalService0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzx(this.zza);
    }
}

