package com.google.android.gms.cast;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.stats.ConnectionTracker;

final class zzah implements ServiceConnection {
    final String zza;
    final CastDevice zzb;
    final Options zzc;
    final NotificationSettings zzd;
    final Context zze;
    final Callbacks zzf;

    public zzah(String s, CastDevice castDevice0, Options castRemoteDisplayLocalService$Options0, NotificationSettings castRemoteDisplayLocalService$NotificationSettings0, Context context0, Callbacks castRemoteDisplayLocalService$Callbacks0) {
        this.zza = s;
        this.zzb = castDevice0;
        this.zzc = castRemoteDisplayLocalService$Options0;
        this.zzd = castRemoteDisplayLocalService$NotificationSettings0;
        this.zze = context0;
        this.zzf = castRemoteDisplayLocalService$Callbacks0;
        super();
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        Context context0 = this.zze;
        Callbacks castRemoteDisplayLocalService$Callbacks0 = this.zzf;
        if(!CastRemoteDisplayLocalService.zzt(((zzan)iBinder0).zza, this.zza, this.zzb, this.zzc, this.zzd, context0, this, castRemoteDisplayLocalService$Callbacks0)) {
            CastRemoteDisplayLocalService.zza.e("Connected but unable to get the service instance", new Object[0]);
            castRemoteDisplayLocalService$Callbacks0.onRemoteDisplaySessionError(new Status(2200));
            CastRemoteDisplayLocalService.zzd.set(false);
            try {
                ConnectionTracker.getInstance().unbindService(context0, this);
            }
            catch(IllegalArgumentException unused_ex) {
                CastRemoteDisplayLocalService.zza.d("No need to unbind service, already unbound", new Object[0]);
            }
        }
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        CastRemoteDisplayLocalService.zza.d("onServiceDisconnected", new Object[0]);
        Status status0 = new Status(2201, "Service Disconnected");
        this.zzf.onRemoteDisplaySessionError(status0);
        CastRemoteDisplayLocalService.zzd.set(false);
        try {
            ConnectionTracker.getInstance().unbindService(this.zze, this);
        }
        catch(IllegalArgumentException unused_ex) {
            CastRemoteDisplayLocalService.zza.d("No need to unbind service, already unbound", new Object[0]);
        }
    }
}

