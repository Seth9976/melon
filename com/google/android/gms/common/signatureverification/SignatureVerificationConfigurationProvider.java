package com.google.android.gms.common.signatureverification;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
@ShowFirstParty
public class SignatureVerificationConfigurationProvider {
    private static final SignatureVerificationConfiguration zza;

    static {
        SignatureVerificationConfigurationProvider.zza = zzd.zzb();
    }

    public static SignatureVerificationConfiguration zza() {
        return SignatureVerificationConfigurationProvider.zza;
    }
}

