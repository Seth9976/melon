package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbp extends zzbm implements zzbq {
    public static zzbq zzb(IBinder iBinder0) {
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        return iInterface0 instanceof zzbq ? ((zzbq)iInterface0) : new zzbo(iBinder0);
    }
}

