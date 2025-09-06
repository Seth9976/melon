package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.RemoteException;

public final class zzi implements Runnable {
    public final zzp zza;
    public final IBinder zzb;

    public zzi(zzp zzp0, IBinder iBinder0) {
        this.zza = zzp0;
        this.zzb = iBinder0;
    }

    @Override
    public final void run() {
        zzp zzp0 = this.zza;
        IBinder iBinder0 = this.zzb;
        synchronized(zzp0) {
            if(iBinder0 == null) {
                zzp0.zza(0, "Null service connection");
                return;
            }
            try {
                zzp0.zzc = new zzq(iBinder0);
            }
            catch(RemoteException remoteException0) {
                zzp0.zza(0, remoteException0.getMessage());
                return;
            }
            zzp0.zza = 2;
            zzp0.zzc();
        }
    }
}

