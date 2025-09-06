package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import b3.Z;
import com.google.android.gms.internal.measurement.zzbp;
import com.google.android.gms.internal.measurement.zzbq;
import java.util.Objects;

public final class zzhi implements ServiceConnection {
    final zzhj zza;
    private final String zzb;

    public zzhi(zzhj zzhj0, String s) {
        Objects.requireNonNull(zzhj0);
        this.zza = zzhj0;
        super();
        this.zzb = s;
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        if(iBinder0 != null) {
            try {
                zzbq zzbq0 = zzbp.zzb(iBinder0);
                if(zzbq0 == null) {
                    this.zza.zza.zzaV().zze().zza("Install Referrer Service implementation was not found");
                    return;
                }
                this.zza.zza.zzaV().zzk().zza("Install Referrer Service connected");
                this.zza.zza.zzaW().zzj(new zzhh(this, zzbq0, this));
                return;
            }
            catch(RuntimeException runtimeException0) {
            }
            this.zza.zza.zzaV().zze().zzb("Exception occurred while calling Install Referrer API", runtimeException0);
            return;
        }
        Z.A(this.zza.zza, "Install Referrer connection returned with null binder");
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        this.zza.zza.zzaV().zzk().zza("Install Referrer Service disconnected");
    }

    public final String zza() {
        return this.zzb;
    }
}

