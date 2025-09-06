package com.android.billingclient.api;

import androidx.activity.result.ActivityResult;
import e.a;

public final class zzcw implements a {
    public final ProxyBillingActivityV2 zza;

    public zzcw(ProxyBillingActivityV2 proxyBillingActivityV20) {
        this.zza = proxyBillingActivityV20;
    }

    @Override  // e.a
    public final void onActivityResult(Object object0) {
        this.zza.zza(((ActivityResult)object0));
    }
}

