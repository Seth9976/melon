package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzah;
import com.google.android.gms.cast.internal.zzy;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzay implements RemoteCall {
    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(((zzy)object0).getContext()).build();
        ((zzah)((zzy)object0).getService()).zzf(ApiMetadata.fromComplianceOptions(complianceOptions0));
        ((TaskCompletionSource)object1).setResult(null);
    }
}

