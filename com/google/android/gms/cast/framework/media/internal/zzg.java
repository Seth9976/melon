package com.google.android.gms.cast.framework.media.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.cast.zzb;

public abstract class zzg extends zzb implements zzh {
    public static zzh zzb(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask");
        return iInterface0 instanceof zzh ? ((zzh)iInterface0) : new zzf(iBinder0);
    }
}

