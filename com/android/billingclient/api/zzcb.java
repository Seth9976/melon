package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzfz;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzgd;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzgg;
import com.google.android.gms.internal.play_billing.zzgk;

public final class zzcb {
    public static final int zza;

    static {
    }

    public static zzga zza(int v, int v1, BillingResult billingResult0) {
        try {
            zzfz zzfz0 = zzga.zzy();
            zzgg zzgg0 = zzgk.zzy();
            zzgg0.zzn(billingResult0.getResponseCode());
            zzgg0.zzm(billingResult0.getDebugMessage());
            zzgg0.zzo(v);
            zzfz0.zzl(zzgg0);
            zzfz0.zzn(v1);
            return (zzga)zzfz0.zzd();
        }
        catch(Exception exception0) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", exception0);
            return null;
        }
    }

    public static zzga zzb(int v, int v1, BillingResult billingResult0, String s) {
        try {
            zzgg zzgg0 = zzgk.zzy();
            zzgg0.zzn(billingResult0.getResponseCode());
            zzgg0.zzm(billingResult0.getDebugMessage());
            zzgg0.zzo(v);
            if(s != null) {
                zzgg0.zzl(s);
            }
            zzfz zzfz0 = zzga.zzy();
            zzfz0.zzl(zzgg0);
            zzfz0.zzn(v1);
            return (zzga)zzfz0.zzd();
        }
        catch(Exception exception0) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", exception0);
            return null;
        }
    }

    public static zzge zzc(int v) {
        try {
            zzgd zzgd0 = zzge.zzy();
            zzgd0.zzm(v);
            return (zzge)zzgd0.zzd();
        }
        catch(Exception exception0) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", exception0);
            return null;
        }
    }
}

