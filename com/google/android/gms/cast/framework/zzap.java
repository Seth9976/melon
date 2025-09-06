package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zza;

public final class zzap extends zza implements zzaq {
    public zzap(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.framework.IDiscoveryManager");
    }

    @Override  // com.google.android.gms.cast.framework.zzaq
    public final IObjectWrapper zze() {
        Parcel parcel0 = this.zzb(5, this.zza());
        IObjectWrapper iObjectWrapper0 = Stub.asInterface(parcel0.readStrongBinder());
        parcel0.recycle();
        return iObjectWrapper0;
    }
}

