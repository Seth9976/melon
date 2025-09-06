package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzal;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzgo;
import com.google.android.gms.internal.play_billing.zzhl;

interface zzcc {
    public static final zzal zza;

    static {
        zzcc.zza = zzal.zzc("com.android.vending.billing.PURCHASES_UPDATED", zzgo.zzb, "com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", zzgo.zzc, "com.android.vending.billing.ALTERNATIVE_BILLING", zzgo.zzd);
    }

    void zza(zzga arg1);

    void zzb(zzga arg1, int arg2);

    void zzc(zzge arg1);

    void zzd(zzge arg1, int arg2);

    void zze(zzhl arg1);
}

