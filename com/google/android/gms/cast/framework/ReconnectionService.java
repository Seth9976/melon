package com.google.android.gms.cast.framework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.internal.cast.zzag;

public class ReconnectionService extends Service {
    private static final Logger zza;
    private zzat zzb;

    static {
        ReconnectionService.zza = new Logger("ReconnectionService");
    }

    @Override  // android.app.Service
    public IBinder onBind(Intent intent0) {
        zzat zzat0 = this.zzb;
        if(zzat0 != null) {
            try {
                return zzat0.zzf(intent0);
            }
            catch(RemoteException remoteException0) {
                ReconnectionService.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onBind", "zzat"});
            }
        }
        return null;
    }

    @Override  // android.app.Service
    public void onCreate() {
        CastContext castContext0 = CastContext.getSharedInstance(this);
        zzat zzat0 = zzag.zzc(this, castContext0.getSessionManager().zzb(), castContext0.zzd().zza());
        this.zzb = zzat0;
        if(zzat0 != null) {
            try {
                zzat0.zzg();
            }
            catch(RemoteException remoteException0) {
                ReconnectionService.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onCreate", "zzat"});
            }
            super.onCreate();
        }
    }

    @Override  // android.app.Service
    public void onDestroy() {
        zzat zzat0 = this.zzb;
        if(zzat0 != null) {
            try {
                zzat0.zzh();
            }
            catch(RemoteException remoteException0) {
                ReconnectionService.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onDestroy", "zzat"});
            }
            super.onDestroy();
        }
    }

    @Override  // android.app.Service
    public int onStartCommand(Intent intent0, int v, int v1) {
        zzat zzat0 = this.zzb;
        if(zzat0 != null) {
            try {
                return zzat0.zze(intent0, v, v1);
            }
            catch(RemoteException remoteException0) {
                ReconnectionService.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onStartCommand", "zzat"});
            }
        }
        return 2;
    }
}

