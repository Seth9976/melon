package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import va.e;

public final class zzm implements Handler.Callback {
    public final zzp zza;

    public zzm(zzp zzp0) {
        this.zza = zzp0;
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        zzs zzs0;
        int v = message0.arg1;
        if(Log.isLoggable("MessengerIpcClient", 3)) {
            e.f(v, "Received response to request: ", "MessengerIpcClient");
        }
        zzp zzp0 = this.zza;
        synchronized(zzp0) {
            zzs0 = (zzs)zzp0.zze.get(v);
            if(zzs0 == null) {
                Log.w("MessengerIpcClient", "Received response for unknown request: " + v);
                return true;
            }
            zzp0.zze.remove(v);
            zzp0.zzf();
        }
        Bundle bundle0 = message0.getData();
        if(bundle0.getBoolean("unsupported", false)) {
            zzs0.zzc(new zzt(4, "Not supported by GmsCore", null));
            return true;
        }
        zzs0.zza(bundle0);
        return true;
    }
}

