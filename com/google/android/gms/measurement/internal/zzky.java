package com.google.android.gms.measurement.internal;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

final class zzky implements zzlk {
    private final zzli zza;
    private final AtomicReference zzb;
    private final zzol zzc;

    public zzky(zzli zzli0, AtomicReference atomicReference0, zzol zzol0) {
        this.zza = zzli0;
        this.zzb = atomicReference0;
        this.zzc = zzol0;
    }

    @Override  // com.google.android.gms.measurement.internal.zzlk
    public final void zza(String s, int v, Throwable throwable0, byte[] arr_b, Map map0) {
        zzlq zzlq0;
        zzli zzli0 = this.zza;
        zzli0.zzg();
        zzol zzol0 = this.zzc;
        switch(v) {
            case 200: 
            case 204: {
            label_8:
                if(throwable0 == null) {
                    zzli0.zzu.zzaV().zzk().zzb("[sgtm] Upload succeeded for row_id", zzol0.zza);
                    zzlq0 = zzlq.zzb;
                }
                else {
                    zzli0.zzu.zzaV().zze().zzd("[sgtm] Upload failed for row_id. response, exception", zzol0.zza, v, throwable0);
                    zzlq0 = Arrays.asList(new String[]{"404", "429", "503", "504"}).contains(String.valueOf(v)) ? zzlq.zzd : zzlq.zzc;
                }
                break;
            }
            case 304: {
                v = 304;
                goto label_8;
            }
            default: {
                zzli0.zzu.zzaV().zze().zzd("[sgtm] Upload failed for row_id. response, exception", zzol0.zza, v, throwable0);
                zzlq0 = Arrays.asList(new String[]{"404", "429", "503", "504"}).contains(String.valueOf(v)) ? zzlq.zzd : zzlq.zzc;
            }
        }
        zzli0.zzu.zzt().zzy(new zzaf(zzol0.zza, zzlq0.zza(), zzol0.zzf));
        zzli0.zzu.zzaV().zzk().zzc("[sgtm] Updated status for row_id", zzol0.zza, zzlq0);
        synchronized(this.zzb) {
            this.zzb.set(zzlq0);
            this.zzb.notifyAll();
        }
    }
}

