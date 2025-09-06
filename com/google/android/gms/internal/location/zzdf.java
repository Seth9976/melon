package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.location.LocationSettingsResult;

final class zzdf extends zzaa {
    final ResultHolder zza;

    public zzdf(ResultHolder baseImplementation$ResultHolder0) {
        this.zza = baseImplementation$ResultHolder0;
        super();
    }

    @Override  // com.google.android.gms.internal.location.zzab
    public final void zzb(LocationSettingsResult locationSettingsResult0) {
        this.zza.setResult(locationSettingsResult0);
    }
}

