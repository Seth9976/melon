package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzfj {
    @Deprecated
    public static final Api zza;
    private static final ClientKey zzb;
    private static final AbstractClientBuilder zzc;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        zzfj.zzb = api$ClientKey0;
        zzfh zzfh0 = new zzfh();
        zzfj.zzc = zzfh0;
        zzfj.zza = new Api("UsageReporting.API", zzfh0, api$ClientKey0);
    }
}

