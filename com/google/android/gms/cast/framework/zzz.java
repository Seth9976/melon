package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.cast.zzq;
import com.google.android.gms.common.ConnectionResult;

final class zzz extends zzq {
    final CastSession zza;

    public zzz(CastSession castSession0, zzaa zzaa0) {
        this.zza = castSession0;
        super();
    }

    @Override  // com.google.android.gms.cast.zzq
    public final void zza() {
        CastSession castSession0 = this.zza;
        if(castSession0.zze != null) {
            try {
                if(castSession0.zzj != null) {
                    castSession0.zzj.zzq();
                }
                castSession0.zze.zzh(null);
            }
            catch(RemoteException remoteException0) {
                CastSession.zzb.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onConnected", "zzam"});
            }
            CastSession castSession1 = this.zza;
            if(castSession1.zzm != null) {
                castSession1.zzm.zza();
            }
        }
    }

    @Override  // com.google.android.gms.cast.zzq
    public final void zzb(int v) {
        CastSession castSession0 = this.zza;
        if(castSession0.zze == null) {
            return;
        }
        try {
            castSession0.zze.zzi(new ConnectionResult(v));
        }
        catch(RemoteException remoteException0) {
            CastSession.zzb.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onConnectionFailed", "zzam"});
        }
    }

    @Override  // com.google.android.gms.cast.zzq
    public final void zzc(int v) {
        CastSession castSession0 = this.zza;
        if(castSession0.zze == null) {
            return;
        }
        try {
            castSession0.zze.zzj(v);
        }
        catch(RemoteException remoteException0) {
            CastSession.zzb.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onConnectionSuspended", "zzam"});
        }
    }

    @Override  // com.google.android.gms.cast.zzq
    public final void zzd(int v) {
        CastSession castSession0 = this.zza;
        if(castSession0.zze == null) {
            return;
        }
        try {
            castSession0.zze.zzi(new ConnectionResult(v));
        }
        catch(RemoteException remoteException0) {
            CastSession.zzb.d(remoteException0, "Unable to call %s on %s.", new Object[]{"onDisconnected", "zzam"});
        }
    }
}

