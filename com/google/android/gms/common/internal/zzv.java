package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

public final class zzv extends zza implements zzx {
    public zzv(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.common.internal.ICertData");
    }

    @Override  // com.google.android.gms.common.internal.zzx
    public final IObjectWrapper zzd() {
        Parcel parcel0 = this.zzB(1, this.zza());
        IObjectWrapper iObjectWrapper0 = Stub.asInterface(parcel0.readStrongBinder());
        parcel0.recycle();
        return iObjectWrapper0;
    }

    @Override  // com.google.android.gms.common.internal.zzx
    public final int zze() {
        Parcel parcel0 = this.zzB(2, this.zza());
        int v = parcel0.readInt();
        parcel0.recycle();
        return v;
    }
}

