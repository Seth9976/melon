package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.common.zzb;

public abstract class zzac extends zzb implements zzad {
    public static zzad zzb(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return iInterface0 instanceof zzad ? ((zzad)iInterface0) : new zzab(iBinder0);
    }
}

