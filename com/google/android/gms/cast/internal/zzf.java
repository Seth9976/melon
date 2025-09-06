package com.google.android.gms.cast.internal;

import android.os.IInterface;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

public final class zzf implements RemoteCall {
    public final zzn zza;
    public final String[] zzb;
    public final String zzc;

    public zzf(zzn zzn0, String[] arr_s, String s, List list0) {
        this.zza = zzn0;
        this.zzb = arr_s;
        this.zzc = s;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzj zzj0 = new zzj(this.zza, ((TaskCompletionSource)object1));
        ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(((zzo)object0).getContext()).build();
        IInterface iInterface0 = ((zzo)object0).getService();
        ApiMetadata apiMetadata0 = ApiMetadata.fromComplianceOptions(complianceOptions0);
        ((zzak)iInterface0).zze(zzj0, this.zzb, this.zzc, null, apiMetadata0);
    }
}

