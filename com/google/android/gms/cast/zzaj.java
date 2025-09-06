package com.google.android.gms.cast;

final class zzaj implements Runnable {
    final NotificationSettings zza;
    final CastRemoteDisplayLocalService zzb;

    public zzaj(CastRemoteDisplayLocalService castRemoteDisplayLocalService0, NotificationSettings castRemoteDisplayLocalService$NotificationSettings0) {
        this.zza = castRemoteDisplayLocalService$NotificationSettings0;
        this.zzb = castRemoteDisplayLocalService0;
        super();
    }

    @Override
    public final void run() {
        CastRemoteDisplayLocalService.zzq(this.zzb, this.zza);
    }
}

