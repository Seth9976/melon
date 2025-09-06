package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzab;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzhl;
import com.google.android.gms.internal.play_billing.zzr;
import com.google.android.gms.internal.play_billing.zzs;
import k8.Y;
import va.e;

final class zzbc implements ServiceConnection {
    final BillingClientImpl zza;
    private final Object zzb;
    private boolean zzc;
    private BillingClientStateListener zzd;

    public zzbc(BillingClientImpl billingClientImpl0, BillingClientStateListener billingClientStateListener0, zzbb zzbb0) {
        this.zza = billingClientImpl0;
        super();
        this.zzb = new Object();
        this.zzc = false;
        this.zzd = billingClientStateListener0;
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        zzb.zzj("BillingClient", "Billing service connected.");
        zzs zzs0 = zzr.zzu(iBinder0);
        this.zza.zzg = zzs0;
        zzaz zzaz0 = new zzaz(this);
        zzba zzba0 = () -> {
            this.zza.zza = 0;
            this.zza.zzg = null;
            BillingClientImpl.zzah(this.zza, 24, 6, zzce.zzn);
            this.zzd(zzce.zzn);
        };
        Handler handler0 = this.zza.zzaj();
        if(BillingClientImpl.zzw(this.zza, zzaz0, 30000L, zzba0, handler0) == null) {
            BillingResult billingResult0 = this.zza.zzal();
            BillingClientImpl.zzah(this.zza, 25, 6, billingResult0);
            this.zzd(billingResult0);
        }
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        zzb.zzk("BillingClient", "Billing service disconnected.");
        this.zza.zzf.zze(zzhl.zzz());
        this.zza.zzg = null;
        this.zza.zza = 0;
        synchronized(this.zzb) {
            BillingClientStateListener billingClientStateListener0 = this.zzd;
            if(billingClientStateListener0 != null) {
                billingClientStateListener0.onBillingServiceDisconnected();
            }
        }
    }

    public final Object zza() {
        String s;
        int v2;
        synchronized(this.zzb) {
            if(this.zzc) {
                return null;
            }
        }
        Bundle bundle0 = TextUtils.isEmpty(null) ? null : Y.b("accountName", null);
        int v = 3;
        int v1 = 22;
        try {
            while(v1 >= 3) {
                v = bundle0 == null ? this.zza.zzg.zzy(v1, "com.iloen.melon", "subs") : this.zza.zzg.zzc(v1, "com.iloen.melon", "subs", bundle0);
                if(v != 0) {
                    --v1;
                    continue;
                }
                zzb.zzj("BillingClient", "highestLevelSupportedForSubs: " + v1);
                goto label_17;
            }
            v1 = 0;
        label_17:
            boolean z = true;
            this.zza.zzj = v1 >= 5;
            this.zza.zzi = v1 >= 3;
            if(v1 < 3) {
                zzb.zzj("BillingClient", "In-app billing API does not support subscription on this device.");
                v2 = 9;
            }
            else {
                v2 = 1;
            }
            int v3 = 22;
            while(v3 >= 3) {
                v = bundle0 == null ? this.zza.zzg.zzy(v3, "com.iloen.melon", "inapp") : this.zza.zzg.zzc(v3, "com.iloen.melon", "inapp", bundle0);
                if(v == 0) {
                    this.zza.zzk = v3;
                    zzb.zzj("BillingClient", "mHighestLevelSupportedForInApp: " + this.zza.zzk);
                    if(true) {
                        break;
                    }
                }
                else {
                    --v3;
                }
            }
            this.zza.zzy = this.zza.zzk >= 22;
            this.zza.zzx = this.zza.zzk >= 21;
            this.zza.zzw = this.zza.zzk >= 20;
            this.zza.zzv = this.zza.zzk >= 19;
            this.zza.zzu = this.zza.zzk >= 18;
            this.zza.zzt = this.zza.zzk >= 17;
            this.zza.zzs = this.zza.zzk >= 16;
            this.zza.zzr = this.zza.zzk >= 15;
            this.zza.zzq = this.zza.zzk >= 14;
            this.zza.zzp = this.zza.zzk >= 12;
            this.zza.zzo = this.zza.zzk >= 10;
            this.zza.zzn = this.zza.zzk >= 9;
            this.zza.zzm = this.zza.zzk >= 8;
            BillingClientImpl billingClientImpl0 = this.zza;
            if(billingClientImpl0.zzk < 6) {
                z = false;
            }
            billingClientImpl0.zzl = z;
            if(this.zza.zzk < 3) {
                zzb.zzk("BillingClient", "In-app billing API version 3 is not supported on this device.");
                v2 = 36;
            }
            if(v == 0) {
                this.zza.zza = 2;
                if(this.zza.zzd != null) {
                    this.zza.zzd.zzg(this.zza.zzx);
                }
            }
            else {
                this.zza.zza = 0;
                this.zza.zzg = null;
            }
            s = null;
        }
        catch(Exception exception0) {
            zzb.zzl("BillingClient", "Exception while checking if billing is supported; try to reconnect", exception0);
            if(exception0 instanceof DeadObjectException) {
                v2 = 101;
            }
            else if(exception0 instanceof RemoteException) {
                v2 = 100;
            }
            else {
                v2 = exception0 instanceof SecurityException ? 102 : 42;
            }
            if(v2 == 42) {
                s = e.c(exception0.getClass().getSimpleName(), ": ", zzab.zzb(exception0.getMessage()));
                if(s.length() > 70) {
                    s = s.substring(0, 70);
                }
            }
            else {
                s = null;
            }
            this.zza.zza = 0;
            this.zza.zzg = null;
        }
        if(v == 0) {
            BillingClientImpl.zzai(this.zza, 6);
            this.zzd(zzce.zzl);
            return null;
        }
        zzga zzga0 = zzcb.zzb(v2, 6, zzce.zza, s);
        this.zza.zzap(zzga0);
        this.zzd(zzce.zza);
        return null;
    }

    // 检测为 Lambda 实现
    public final void zzb() [...]

    public final void zzc() {
        synchronized(this.zzb) {
            this.zzd = null;
            this.zzc = true;
        }
    }

    private final void zzd(BillingResult billingResult0) {
        synchronized(this.zzb) {
            BillingClientStateListener billingClientStateListener0 = this.zzd;
            if(billingClientStateListener0 != null) {
                billingClientStateListener0.onBillingSetupFinished(billingResult0);
            }
        }
    }
}

