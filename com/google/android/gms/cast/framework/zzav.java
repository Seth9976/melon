package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.cast.zzb;

public abstract class zzav extends zzb implements zzaw {
    public static zzaw zzb(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.framework.ISession");
        return iInterface0 instanceof zzaw ? ((zzaw)iInterface0) : new zzau(iBinder0);
    }
}

