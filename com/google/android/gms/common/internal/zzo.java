package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode.VmPolicy;
import android.os.StrictMode;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.util.zzd;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

final class zzo implements ServiceConnection, zzr {
    final zzq zza;
    private final Map zzb;
    private int zzc;
    private boolean zzd;
    private IBinder zze;
    private final zzn zzf;
    private ComponentName zzg;

    public zzo(zzq zzq0, zzn zzn0) {
        Objects.requireNonNull(zzq0);
        this.zza = zzq0;
        super();
        this.zzf = zzn0;
        this.zzb = new HashMap();
        this.zzc = 2;
    }

    @Override  // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName0) {
        this.onServiceDisconnected(componentName0);
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        synchronized(this.zza.zzf()) {
            this.zza.zzh().removeMessages(1, this.zzf);
            this.zze = iBinder0;
            this.zzg = componentName0;
            for(Object object0: this.zzb.values()) {
                ((ServiceConnection)object0).onServiceConnected(componentName0, iBinder0);
            }
            this.zzc = 1;
        }
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        synchronized(this.zza.zzf()) {
            this.zza.zzh().removeMessages(1, this.zzf);
            this.zze = null;
            this.zzg = componentName0;
            for(Object object0: this.zzb.values()) {
                ((ServiceConnection)object0).onServiceDisconnected(componentName0);
            }
            this.zzc = 2;
        }
    }

    public final void zza(String s) {
        this.zza.zzh().removeMessages(1, this.zzf);
        this.zza.zzi().unbindService(this.zza.zzg(), this);
        this.zzd = false;
        this.zzc = 2;
    }

    public final void zzb(ServiceConnection serviceConnection0, ServiceConnection serviceConnection1, String s) {
        this.zzb.put(serviceConnection0, serviceConnection1);
    }

    public final void zzc(ServiceConnection serviceConnection0, String s) {
        this.zzb.remove(serviceConnection0);
    }

    public final boolean zzd() {
        return this.zzd;
    }

    public final int zze() {
        return this.zzc;
    }

    public final boolean zzf(ServiceConnection serviceConnection0) {
        return this.zzb.containsKey(serviceConnection0);
    }

    public final boolean zzg() {
        return this.zzb.isEmpty();
    }

    public final IBinder zzh() {
        return this.zze;
    }

    public final ComponentName zzi() {
        return this.zzg;
    }

    public final ConnectionResult zzj(String s, Executor executor0) {
        Intent intent0;
        try {
            intent0 = zzah.zza(this.zza.zzg(), this.zzf);
        }
        catch(zzaf zzaf0) {
            return zzaf0.zza;
        }
        this.zzc = 3;
        StrictMode.VmPolicy strictMode$VmPolicy0 = zzd.zza();
        try {
            zzq zzq0 = this.zza;
            zzn zzn0 = this.zzf;
            boolean z = zzq0.zzi().zza(zzq0.zzg(), s, intent0, this, 0x1081, executor0);
            this.zzd = z;
            if(z) {
                zzq0.zzh().sendMessageDelayed(zzq0.zzh().obtainMessage(1, zzn0), zzq0.zzj());
                return ConnectionResult.RESULT_SUCCESS;
            }
            try {
                this.zzc = 2;
                zzq0.zzi().unbindService(zzq0.zzg(), this);
            }
            catch(IllegalArgumentException unused_ex) {
            }
            return new ConnectionResult(16);
        }
        finally {
            StrictMode.setVmPolicy(strictMode$VmPolicy0);
        }
    }
}

