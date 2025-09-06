package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzbq extends zzbi {
    final ProxyRequest zza;

    public zzbq(zzbt zzbt0, GoogleApiClient googleApiClient0, ProxyRequest proxyRequest0) {
        this.zza = proxyRequest0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.internal.auth.zzbi
    public final void zza(Context context0, zzbh zzbh0) {
        zzbh0.zze(new zzbp(this), this.zza);
    }
}

