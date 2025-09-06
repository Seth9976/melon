package com.android.billingclient.api;

import B3.n;
import H8.i;
import N5.c;
import N5.d;
import N5.f;
import O5.a;
import Q5.u;
import android.content.Context;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzhe;

final class zzcj {
    private boolean zza;
    private f zzb;

    public zzcj(Context context0) {
        try {
            u.b(context0);
            this.zzb = u.a().c(a.e).a("PLAY_BILLING_LIBRARY", new c("proto"), new zzci());
        }
        catch(Throwable unused_ex) {
            this.zza = true;
        }
    }

    public final void zza(zzhe zzhe0) {
        if(this.zza) {
            zzb.zzk("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            ((i)this.zzb).x(new N5.a(null, zzhe0, d.a, null), new n(26));
        }
        catch(Throwable unused_ex) {
            zzb.zzk("BillingLogger", "logging failed.");
        }
    }
}

