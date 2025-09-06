package com.android.billingclient.api;

import androidx.activity.result.ActivityResult;
import e.a;

public final class zzcx implements a {
    public final ProxyBillingActivityV2 zza;

    public zzcx(ProxyBillingActivityV2 proxyBillingActivityV20) {
        this.zza = proxyBillingActivityV20;
    }

    @Override  // e.a
    public final void onActivityResult(Object object0) {
        this.zza.zzb(((ActivityResult)object0));
    }
}

