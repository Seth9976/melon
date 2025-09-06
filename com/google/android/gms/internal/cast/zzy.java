package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.common.internal.Preconditions;

public final class zzy implements zzgr {
    @Override  // com.google.android.gms.internal.cast.zzgr
    public final Object zza() {
        return ((CastContext)Preconditions.checkNotNull(CastContext.getSharedInstance())).getCastOptions().getReceiverApplicationId();
    }
}

