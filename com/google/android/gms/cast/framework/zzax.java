package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzax extends zza implements zzay {
    public zzax(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.framework.ISessionManager");
    }

    @Override  // com.google.android.gms.cast.framework.zzay
    public final int zze() {
        Parcel parcel0 = this.zzb(8, this.zza());
        int v = parcel0.readInt();
        parcel0.recycle();
        return v;
    }

    @Override  // com.google.android.gms.cast.framework.zzay
    public final IObjectWrapper zzf() {
        Parcel parcel0 = this.zzb(1, this.zza());
        IObjectWrapper iObjectWrapper0 = Stub.asInterface(parcel0.readStrongBinder());
        parcel0.recycle();
        return iObjectWrapper0;
    }

    @Override  // com.google.android.gms.cast.framework.zzay
    public final IObjectWrapper zzg() {
        Parcel parcel0 = this.zzb(7, this.zza());
        IObjectWrapper iObjectWrapper0 = Stub.asInterface(parcel0.readStrongBinder());
        parcel0.recycle();
        return iObjectWrapper0;
    }

    @Override  // com.google.android.gms.cast.framework.zzay
    public final void zzh(zzao zzao0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzao0);
        this.zzc(4, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzay
    public final void zzi(zzba zzba0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzba0);
        this.zzc(2, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzay
    public final void zzj(boolean z, boolean z1) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(1);
        parcel0.writeInt(((int)z1));
        this.zzc(6, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzay
    public final void zzk(zzao zzao0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzao0);
        this.zzc(5, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzay
    public final void zzl(zzba zzba0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzba0);
        this.zzc(3, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzay
    public final void zzm(Bundle bundle0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, bundle0);
        this.zzc(9, parcel0);
    }
}

