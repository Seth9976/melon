package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzg;
import java.util.HashMap;
import java.util.concurrent.Executor;

final class zzq extends GmsClientSupervisor {
    private final HashMap zzb;
    private final Context zzc;
    private volatile Handler zzd;
    private final zzp zze;
    private final ConnectionTracker zzf;
    private final long zzg;
    private final long zzh;
    private volatile Executor zzi;

    public zzq(Context context0, Looper looper0, Executor executor0) {
        this.zzb = new HashMap();
        zzp zzp0 = new zzp(this, null);
        this.zze = zzp0;
        this.zzc = context0.getApplicationContext();
        this.zzd = new zzg(looper0, zzp0);
        this.zzf = ConnectionTracker.getInstance();
        this.zzg = 5000L;
        this.zzh = 300000L;
        this.zzi = executor0;
    }

    @Override  // com.google.android.gms.common.internal.GmsClientSupervisor
    public final ConnectionResult zza(zzn zzn0, ServiceConnection serviceConnection0, String s, Executor executor0) {
        ConnectionResult connectionResult0;
        Preconditions.checkNotNull(serviceConnection0, "ServiceConnection must not be null");
        HashMap hashMap0 = this.zzb;
        synchronized(hashMap0) {
            zzo zzo0 = (zzo)hashMap0.get(zzn0);
            if(executor0 == null) {
                executor0 = this.zzi;
            }
            if(zzo0 == null) {
                zzo0 = new zzo(this, zzn0);
                zzo0.zzb(serviceConnection0, serviceConnection0, s);
                connectionResult0 = zzo0.zzj(s, executor0);
                hashMap0.put(zzn0, zzo0);
                goto label_23;
            }
            this.zzd.removeMessages(0, zzn0);
            if(!zzo0.zzf(serviceConnection0)) {
                zzo0.zzb(serviceConnection0, serviceConnection0, s);
                switch(zzo0.zze()) {
                    case 1: {
                        serviceConnection0.onServiceConnected(zzo0.zzi(), zzo0.zzh());
                        connectionResult0 = null;
                        break;
                    }
                    case 2: {
                        connectionResult0 = zzo0.zzj(s, executor0);
                        break;
                    }
                    default: {
                        connectionResult0 = null;
                    }
                }
            label_23:
                if(zzo0.zzd()) {
                    return ConnectionResult.RESULT_SUCCESS;
                }
                if(connectionResult0 == null) {
                    connectionResult0 = new ConnectionResult(-1);
                }
                return connectionResult0;
            }
        }
        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zzn0.toString());
    }

    @Override  // com.google.android.gms.common.internal.GmsClientSupervisor
    public final void zzc(zzn zzn0, ServiceConnection serviceConnection0, String s) {
        Preconditions.checkNotNull(serviceConnection0, "ServiceConnection must not be null");
        HashMap hashMap0 = this.zzb;
        synchronized(hashMap0) {
            zzo zzo0 = (zzo)hashMap0.get(zzn0);
            if(zzo0 != null) {
                if(!zzo0.zzf(serviceConnection0)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zzn0.toString());
                }
                zzo0.zzc(serviceConnection0, s);
                if(zzo0.zzg()) {
                    Message message0 = this.zzd.obtainMessage(0, zzn0);
                    this.zzd.sendMessageDelayed(message0, this.zzg);
                }
                return;
            }
        }
        throw new IllegalStateException("Nonexistent connection status for service config: " + zzn0.toString());
    }

    public final void zzd(Looper looper0) {
        synchronized(this.zzb) {
            this.zzd = new zzg(looper0, this.zze);
        }
    }

    public final void zze(Executor executor0) {
        synchronized(this.zzb) {
            this.zzi = executor0;
        }
    }

    public final HashMap zzf() {
        return this.zzb;
    }

    public final Context zzg() {
        return this.zzc;
    }

    public final Handler zzh() {
        return this.zzd;
    }

    public final ConnectionTracker zzi() {
        return this.zzf;
    }

    public final long zzj() {
        return this.zzh;
    }
}

