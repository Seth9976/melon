package com.google.android.gms.cast;

import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.cast.zzeg;
import com.google.android.gms.internal.cast.zzel;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzz implements RemoteCall {
    public final CastRemoteDisplayClient zza;

    public zzz(CastRemoteDisplayClient castRemoteDisplayClient0) {
        this.zza = castRemoteDisplayClient0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzac zzac0 = new zzac(this.zza, ((TaskCompletionSource)object1));
        ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(((zzeg)object0).getContext()).build();
        ((zzel)((zzeg)object0).getService()).zzi(zzac0, ApiMetadata.fromComplianceOptions(complianceOptions0));
    }
}

