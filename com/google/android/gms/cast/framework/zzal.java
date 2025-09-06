package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.cast.zzb;

public abstract class zzal extends zzb implements zzam {
    public static zzam zzb(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.framework.ICastSession");
        return iInterface0 instanceof zzam ? ((zzam)iInterface0) : new zzak(iBinder0);
    }
}

