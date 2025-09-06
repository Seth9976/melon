package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.o;
import java.util.concurrent.atomic.AtomicReference;

public final class zzco extends zzct {
    private final AtomicReference zza;
    private boolean zzb;

    public zzco() {
        this.zza = new AtomicReference();
    }

    @Override  // com.google.android.gms.internal.measurement.zzcu
    public final void zzb(Bundle bundle0) {
        AtomicReference atomicReference0 = this.zza;
        synchronized(atomicReference0) {
            try {
                atomicReference0.set(bundle0);
                this.zzb = true;
            }
            catch(Throwable throwable0) {
                this.zza.notify();
                throw throwable0;
            }
        }
        this.zza.notify();
    }

    public final String zzc(long v) {
        return (String)zzco.zzf(this.zze(v), String.class);
    }

    public final Long zzd(long v) {
        return (Long)zzco.zzf(this.zze(v), Long.class);
    }

    public final Bundle zze(long v) {
        AtomicReference atomicReference0 = this.zza;
        synchronized(atomicReference0) {
            if(!this.zzb) {
                try {
                    atomicReference0.wait(v);
                }
                catch(InterruptedException unused_ex) {
                    return null;
                }
            }
        }
        return (Bundle)this.zza.get();
    }

    public static final Object zzf(Bundle bundle0, Class class0) {
        if(bundle0 != null) {
            Object object0 = bundle0.get("r");
            if(object0 != null) {
                try {
                    return class0.cast(object0);
                }
                catch(ClassCastException classCastException0) {
                    Log.w("AM", o.o("Unexpected object type. Expected, Received: ", class0.getCanonicalName(), ", ", object0.getClass().getCanonicalName()), classCastException0);
                    throw classCastException0;
                }
            }
        }
        return null;
    }
}

