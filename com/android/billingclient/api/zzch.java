package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzgt;
import com.google.android.gms.internal.play_billing.zzgu;
import com.google.android.gms.internal.play_billing.zzhd;
import com.google.android.gms.internal.play_billing.zzhe;
import com.google.android.gms.internal.play_billing.zzhl;

final class zzch implements zzcc {
    private zzgu zzb;
    private final zzcj zzc;

    public zzch(Context context0, zzgu zzgu0) {
        zzcj zzcj0 = new zzcj(context0);
        super();
        this.zzc = zzcj0;
        this.zzb = zzgu0;
    }

    @Override  // com.android.billingclient.api.zzcc
    public final void zza(zzga zzga0) {
        if(zzga0 == null) {
            return;
        }
        try {
            zzhd zzhd0 = zzhe.zzy();
            zzhd0.zzn(this.zzb);
            zzhd0.zzl(zzga0);
            zzhe zzhe0 = (zzhe)zzhd0.zzd();
            this.zzc.zza(zzhe0);
        }
        catch(Throwable throwable0) {
            zzb.zzl("BillingLogger", "Unable to log.", throwable0);
        }
    }

    @Override  // com.android.billingclient.api.zzcc
    public final void zzb(zzga zzga0, int v) {
        try {
            zzgt zzgt0 = (zzgt)this.zzb.zzi();
            zzgt0.zzl(v);
            this.zzb = (zzgu)zzgt0.zzd();
            this.zza(zzga0);
        }
        catch(Throwable throwable0) {
            zzb.zzl("BillingLogger", "Unable to log.", throwable0);
        }
    }

    @Override  // com.android.billingclient.api.zzcc
    public final void zzc(zzge zzge0) {
        if(zzge0 == null) {
            return;
        }
        try {
            zzhd zzhd0 = zzhe.zzy();
            zzhd0.zzn(this.zzb);
            zzhd0.zzm(zzge0);
            zzhe zzhe0 = (zzhe)zzhd0.zzd();
            this.zzc.zza(zzhe0);
        }
        catch(Throwable throwable0) {
            zzb.zzl("BillingLogger", "Unable to log.", throwable0);
        }
    }

    @Override  // com.android.billingclient.api.zzcc
    public final void zzd(zzge zzge0, int v) {
        try {
            zzgt zzgt0 = (zzgt)this.zzb.zzi();
            zzgt0.zzl(v);
            this.zzb = (zzgu)zzgt0.zzd();
            this.zzc(zzge0);
        }
        catch(Throwable throwable0) {
            zzb.zzl("BillingLogger", "Unable to log.", throwable0);
        }
    }

    @Override  // com.android.billingclient.api.zzcc
    public final void zze(zzhl zzhl0) {
        if(zzhl0 == null) {
            return;
        }
        try {
            zzhd zzhd0 = zzhe.zzy();
            zzhd0.zzn(this.zzb);
            zzhd0.zzo(zzhl0);
            zzhe zzhe0 = (zzhe)zzhd0.zzd();
            this.zzc.zza(zzhe0);
        }
        catch(Throwable throwable0) {
            zzb.zzl("BillingLogger", "Unable to log.", throwable0);
        }
    }
}

