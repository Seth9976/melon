package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.cast.zzb;

public abstract class zzas extends zzb implements zzat {
    public static zzat zzb(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.framework.IReconnectionService");
        return iInterface0 instanceof zzat ? ((zzat)iInterface0) : new zzar(iBinder0);
    }
}

