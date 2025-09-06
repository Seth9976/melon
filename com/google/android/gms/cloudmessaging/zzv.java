package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class zzv {
    private static zzv zza;
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private zzp zzd;
    private int zze;

    public zzv(Context context0, ScheduledExecutorService scheduledExecutorService0) {
        this.zzd = new zzp(this, null);
        this.zze = 1;
        this.zzc = scheduledExecutorService0;
        this.zzb = context0.getApplicationContext();
    }

    public static Context zza(zzv zzv0) {
        return zzv0.zzb;
    }

    public static zzv zzb(Context context0) {
        synchronized(zzv.class) {
            if(zzv.zza == null) {
                zzv.zza = new zzv(context0, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
            }
            return zzv.zza;
        }
    }

    public final Task zzc(int v, Bundle bundle0) {
        return this.zzg(new zzr(this.zzf(), v, bundle0));
    }

    public final Task zzd(int v, Bundle bundle0) {
        return this.zzg(new zzu(this.zzf(), v, bundle0));
    }

    public static ScheduledExecutorService zze(zzv zzv0) {
        return zzv0.zzc;
    }

    private final int zzf() {
        int v;
        synchronized(this) {
            v = this.zze;
            this.zze = v + 1;
        }
        return v;
    }

    private final Task zzg(zzs zzs0) {
        synchronized(this) {
            if(Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing " + zzs0.toString());
            }
            if(!this.zzd.zzg(zzs0)) {
                zzp zzp0 = new zzp(this, null);
                this.zzd = zzp0;
                zzp0.zzg(zzs0);
            }
        }
        return zzs0.zzb.getTask();
    }
}

