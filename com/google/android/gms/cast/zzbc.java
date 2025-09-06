package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzah;
import com.google.android.gms.cast.internal.zzy;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbc implements RemoteCall {
    public final zzbr zza;

    public zzbc(zzbr zzbr0) {
        this.zza = zzbr0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(((zzy)object0).getContext()).build();
        zzah zzah0 = (zzah)((zzy)object0).getService();
        ApiMetadata apiMetadata0 = ApiMetadata.fromComplianceOptions(complianceOptions0);
        zzah0.zzj(this.zza.zza, apiMetadata0);
        ((zzah)((zzy)object0).getService()).zze(ApiMetadata.fromComplianceOptions(complianceOptions0));
        ((TaskCompletionSource)object1).setResult(null);
    }
}

