package com.google.android.gms.cast.framework;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzar extends zza implements zzat {
    public zzar(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.framework.IReconnectionService");
    }

    @Override  // com.google.android.gms.cast.framework.zzat
    public final int zze(Intent intent0, int v, int v1) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, intent0);
        parcel0.writeInt(v);
        parcel0.writeInt(v1);
        Parcel parcel1 = this.zzb(2, parcel0);
        int v2 = parcel1.readInt();
        parcel1.recycle();
        return v2;
    }

    @Override  // com.google.android.gms.cast.framework.zzat
    public final IBinder zzf(Intent intent0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, intent0);
        Parcel parcel1 = this.zzb(3, parcel0);
        IBinder iBinder0 = parcel1.readStrongBinder();
        parcel1.recycle();
        return iBinder0;
    }

    @Override  // com.google.android.gms.cast.framework.zzat
    public final void zzg() {
        this.zzc(1, this.zza());
    }

    @Override  // com.google.android.gms.cast.framework.zzat
    public final void zzh() {
        this.zzc(4, this.zza());
    }
}

