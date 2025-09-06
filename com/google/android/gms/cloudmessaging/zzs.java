package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.o;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzs {
    final int zza;
    final TaskCompletionSource zzb;
    final int zzc;
    final Bundle zzd;

    public zzs(int v, int v1, Bundle bundle0) {
        this.zzb = new TaskCompletionSource();
        this.zza = v;
        this.zzc = v1;
        this.zzd = bundle0;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Request { what=");
        stringBuilder0.append(this.zzc);
        stringBuilder0.append(" id=");
        stringBuilder0.append(this.zza);
        stringBuilder0.append(" oneWay=");
        return o.s(stringBuilder0, this.zzb(), "}");
    }

    public abstract void zza(Bundle arg1);

    public abstract boolean zzb();

    public final void zzc(zzt zzt0) {
        if(Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + this.toString() + " with " + zzt0.toString());
        }
        this.zzb.setException(zzt0);
    }

    public final void zzd(Object object0) {
        if(Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + this.toString() + " with " + object0);
        }
        this.zzb.setResult(object0);
    }
}

