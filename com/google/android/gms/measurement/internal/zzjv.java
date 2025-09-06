package com.google.android.gms.measurement.internal;

import M6.t;
import android.os.Bundle;
import android.util.SparseArray;
import java.util.Objects;

final class zzjv implements t {
    final zzog zza;
    final zzli zzb;

    public zzjv(zzli zzli0, zzog zzog0) {
        this.zza = zzog0;
        Objects.requireNonNull(zzli0);
        this.zzb = zzli0;
        super();
    }

    @Override  // M6.t
    public final void onFailure(Throwable throwable0) {
        zzli zzli0 = this.zzb;
        zzli0.zzg();
        zzli0.zzal(false);
        zzib zzib0 = zzli0.zzu;
        switch((zzib0.zzc().zzp(null, zzfx.zzaT) ? zzli0.zzap(throwable0) : 2) - 1) {
            case 0: {
                zzib0.zzaV().zze().zzc("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", zzgt.zzl(zzli0.zzu.zzv().zzj()), zzgt.zzl(throwable0.toString()));
                zzli0.zzan(1);
                zzli0.zzy().add(this.zza);
                return;
            }
            case 1: {
                zzli0.zzy().add(this.zza);
                if(zzli0.zzam() > ((int)(((Integer)zzfx.zzaw.zzb(null))))) {
                    zzli0.zzan(1);
                    zzib0.zzaV().zze().zzc("registerTriggerAsync failed. May try later. App ID, throwable", zzgt.zzl(zzli0.zzu.zzv().zzj()), zzgt.zzl(throwable0.toString()));
                    return;
                }
                zzib0.zzaV().zze().zzd("registerTriggerAsync failed. App ID, delay in seconds, throwable", zzgt.zzl(zzli0.zzu.zzv().zzj()), zzgt.zzl(String.valueOf(zzli0.zzam())), zzgt.zzl(throwable0.toString()));
                zzli0.zzah(zzli0.zzam());
                int v = zzli0.zzam();
                zzli0.zzan(v + v);
                return;
            }
            default: {
                zzib0.zzaV().zzb().zzc("registerTriggerAsync failed. Dropping URI. App ID, Throwable", zzgt.zzl(zzli0.zzu.zzv().zzj()), throwable0);
                this.zza();
                zzli0.zzan(1);
                zzli0.zzz();
            }
        }
    }

    @Override  // M6.t
    public final void onSuccess(Object object0) {
        this.zzb.zzg();
        this.zza();
        this.zzb.zzal(false);
        this.zzb.zzan(1);
        this.zzb.zzu.zzaV().zzj().zzb("Successfully registered trigger URI", this.zza.zza);
        this.zzb.zzz();
    }

    private final void zza() {
        SparseArray sparseArray0 = this.zzb.zzu.zzd().zzf();
        sparseArray0.put(this.zza.zzc, this.zza.zzb);
        zzhg zzhg0 = this.zzb.zzu.zzd();
        int[] arr_v = new int[sparseArray0.size()];
        long[] arr_v1 = new long[sparseArray0.size()];
        for(int v = 0; v < sparseArray0.size(); ++v) {
            arr_v[v] = sparseArray0.keyAt(v);
            arr_v1[v] = (long)(((Long)sparseArray0.valueAt(v)));
        }
        Bundle bundle0 = new Bundle();
        bundle0.putIntArray("uriSources", arr_v);
        bundle0.putLongArray("uriTimestamps", arr_v1);
        zzhg0.zzi.zzb(bundle0);
    }
}

