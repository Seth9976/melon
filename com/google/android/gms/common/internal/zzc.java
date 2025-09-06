package com.google.android.gms.common.internal;

import android.util.Log;
import java.util.Objects;

public abstract class zzc {
    private Object zza;
    private boolean zzb;
    final BaseGmsClient zzd;

    public zzc(BaseGmsClient baseGmsClient0, Object object0) {
        Objects.requireNonNull(baseGmsClient0);
        this.zzd = baseGmsClient0;
        super();
        this.zza = object0;
        this.zzb = false;
    }

    public abstract void zzc(Object arg1);

    public final void zzd() {
        Object object0;
        synchronized(this) {
            object0 = this.zza;
            if(this.zzb) {
                Log.w("GmsClient", "Callback proxy " + this.toString() + " being reused. This is not safe.");
            }
        }
        if(object0 != null) {
            this.zzc(object0);
        }
        synchronized(this) {
            this.zzb = true;
        }
        this.zze();
    }

    public final void zze() {
        this.zzf();
        synchronized(this.zzd.zzj()) {
            this.zzd.zzj().remove(this);
        }
    }

    public final void zzf() {
        synchronized(this) {
            this.zza = null;
        }
    }
}

