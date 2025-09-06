package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.Objects;

final class zzq {
    private final Messenger zza;
    private final zzd zzb;

    public zzq(IBinder iBinder0) {
        String s = iBinder0.getInterfaceDescriptor();
        if(Objects.equals(s, "android.os.IMessenger")) {
            this.zza = new Messenger(iBinder0);
            this.zzb = null;
            return;
        }
        if(Objects.equals(s, "com.google.android.gms.iid.IMessengerCompat")) {
            this.zzb = new zzd(iBinder0);
            this.zza = null;
            return;
        }
        Log.w("MessengerIpcClient", "Invalid interface descriptor: " + s);
        throw new RemoteException();
    }

    public final void zza(Message message0) {
        Messenger messenger0 = this.zza;
        if(messenger0 != null) {
            messenger0.send(message0);
            return;
        }
        zzd zzd0 = this.zzb;
        if(zzd0 == null) {
            throw new IllegalStateException("Both messengers are null");
        }
        zzd0.zzb(message0);
    }
}

