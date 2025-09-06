package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import org.jetbrains.annotations.NotNull;

public final class zzr {
    @NotNull
    private static final ClientKey zza;
    @NotNull
    private static final zzq zzb;
    @NotNull
    private static final Api zzc;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        zzr.zza = api$ClientKey0;
        zzq zzq0 = new zzq();
        zzr.zzb = zzq0;
        zzr.zzc = new Api("MissedCallRetriever.API", zzq0, api$ClientKey0);
    }

    public static final Api zza() {
        return zzr.zzc;
    }
}

