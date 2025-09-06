package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.cast.zzb;

public abstract class zzai extends zzb implements zzaj {
    public static zzaj zzb(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.framework.ICastContext");
        return iInterface0 instanceof zzaj ? ((zzaj)iInterface0) : new zzah(iBinder0);
    }
}

