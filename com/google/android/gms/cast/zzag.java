package com.google.android.gms.cast;

final class zzag implements Runnable {
    final CastRemoteDisplayLocalService zza;

    public zzag(CastRemoteDisplayLocalService castRemoteDisplayLocalService0) {
        this.zza = castRemoteDisplayLocalService0;
        super();
    }

    @Override
    public final void run() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService0 = this.zza;
        castRemoteDisplayLocalService0.zzv("onCreate after delay. The local service been started: " + castRemoteDisplayLocalService0.zzs);
        if(!castRemoteDisplayLocalService0.zzs) {
            CastRemoteDisplayLocalService.zzn(castRemoteDisplayLocalService0, "The local service has not been been started, stopping it");
            castRemoteDisplayLocalService0.stopSelf();
        }
    }
}

