package com.google.android.gms.common.internal;

import android.os.IBinder;
import com.google.android.gms.internal.common.zza;

public final class zzu extends zza implements ICancelToken {
    public zzu(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.common.internal.ICancelToken");
    }

    @Override  // com.google.android.gms.common.internal.ICancelToken
    public final void cancel() {
        this.zzC(2, this.zza());
    }
}

