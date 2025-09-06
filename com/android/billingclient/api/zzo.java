package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

final class zzo {
    private final Context zza;
    private final PurchasesUpdatedListener zzb;
    private final zzc zzc;
    private final UserChoiceBillingListener zzd;
    private final zzcc zze;
    private final zzn zzf;
    private final zzn zzg;
    private boolean zzh;

    public zzo(Context context0, PurchasesUpdatedListener purchasesUpdatedListener0, zzck zzck0, zzc zzc0, UserChoiceBillingListener userChoiceBillingListener0, zzcc zzcc0) {
        this.zza = context0;
        this.zzb = purchasesUpdatedListener0;
        this.zzc = zzc0;
        this.zzd = userChoiceBillingListener0;
        this.zze = zzcc0;
        this.zzf = new zzn(this, true);
        this.zzg = new zzn(this, false);
    }

    public final PurchasesUpdatedListener zzd() {
        return this.zzb;
    }

    public final void zzf() {
        this.zzf.zzc(this.zza);
        this.zzg.zzc(this.zza);
    }

    public final void zzg(boolean z) {
        IntentFilter intentFilter0 = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter1 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter1.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.zzh = z;
        this.zzg.zza(this.zza, intentFilter1);
        if(this.zzh) {
            this.zzf.zzb(this.zza, intentFilter0, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
            return;
        }
        this.zzf.zza(this.zza, intentFilter0);
    }
}

