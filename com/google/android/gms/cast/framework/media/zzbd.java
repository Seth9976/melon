package com.google.android.gms.cast.framework.media;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class zzbd extends BasePendingResult {
    public zzbd() {
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status0) {
        return new zzbc(this, status0);
    }
}

