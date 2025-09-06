package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.TimeUnit;

public final class zzj implements Runnable {
    public final zzp zza;

    public zzj(zzp zzp0) {
        this.zza = zzp0;
    }

    @Override
    public final void run() {
        zzs zzs0;
        while(true) {
            zzp zzp0 = this.zza;
            synchronized(zzp0) {
                if(zzp0.zza != 2) {
                    return;
                }
                if(zzp0.zzd.isEmpty()) {
                    zzp0.zzf();
                    return;
                }
                zzs0 = (zzs)zzp0.zzd.poll();
                zzp0.zze.put(zzs0.zza, zzs0);
                zzn zzn0 = new zzn(zzp0, zzs0);
                zzv.zze(zzp0.zzf).schedule(zzn0, 30L, TimeUnit.SECONDS);
            }
            if(Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Sending " + zzs0);
            }
            Message message0 = Message.obtain();
            message0.what = zzs0.zzc;
            message0.arg1 = zzs0.zza;
            message0.replyTo = zzp0.zzb;
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("oneWay", zzs0.zzb());
            bundle0.putString("pkg", "com.iloen.melon");
            bundle0.putBundle("data", zzs0.zzd);
            message0.setData(bundle0);
            try {
                zzp0.zzc.zza(message0);
            }
            catch(RemoteException remoteException0) {
                zzp0.zza(2, remoteException0.getMessage());
            }
        }
    }
}

