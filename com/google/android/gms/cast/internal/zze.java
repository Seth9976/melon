package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zze implements RemoteCall {
    public final zzn zza;
    public final String[] zzb;

    public zze(zzn zzn0, String[] arr_s) {
        this.zza = zzn0;
        this.zzb = arr_s;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzl zzl0 = new zzl(this.zza, ((TaskCompletionSource)object1));
        ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(((zzo)object0).getContext()).build();
        zzak zzak0 = (zzak)((zzo)object0).getService();
        ApiMetadata apiMetadata0 = ApiMetadata.fromComplianceOptions(complianceOptions0);
        zzak0.zzh(zzl0, this.zzb, apiMetadata0);
    }
}

