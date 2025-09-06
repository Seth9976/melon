package com.google.android.gms.internal.cast;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class zzan extends zza implements zzao {
    public zzan(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.framework.internal.IMediaRouterCallback");
    }

    @Override  // com.google.android.gms.internal.cast.zzao
    public final int zze() {
        Parcel parcel0 = this.zzb(7, this.zza());
        int v = parcel0.readInt();
        parcel0.recycle();
        return v;
    }

    @Override  // com.google.android.gms.internal.cast.zzao
    public final void zzf(String s, Bundle bundle0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzc.zzc(parcel0, bundle0);
        this.zzc(1, parcel0);
    }

    @Override  // com.google.android.gms.internal.cast.zzao
    public final void zzg(String s, Bundle bundle0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzc.zzc(parcel0, bundle0);
        this.zzc(2, parcel0);
    }

    @Override  // com.google.android.gms.internal.cast.zzao
    public final void zzh(String s, String s1, Bundle bundle0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzc.zzc(parcel0, bundle0);
        this.zzc(9, parcel0);
    }

    @Override  // com.google.android.gms.internal.cast.zzao
    public final void zzi(String s, String s1, Bundle bundle0, int v) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzc.zzc(parcel0, bundle0);
        parcel0.writeInt(v);
        this.zzc(10, parcel0);
    }

    @Override  // com.google.android.gms.internal.cast.zzao
    public final void zzj(String s, Bundle bundle0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzc.zzc(parcel0, bundle0);
        this.zzc(3, parcel0);
    }

    @Override  // com.google.android.gms.internal.cast.zzao
    public final void zzk(String s, Bundle bundle0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzc.zzc(parcel0, bundle0);
        this.zzc(4, parcel0);
    }

    @Override  // com.google.android.gms.internal.cast.zzao
    public final void zzl(String s, String s1, Bundle bundle0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzc.zzc(parcel0, bundle0);
        this.zzc(8, parcel0);
    }

    @Override  // com.google.android.gms.internal.cast.zzao
    public final void zzm(String s, Bundle bundle0, int v) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzc.zzc(parcel0, bundle0);
        parcel0.writeInt(v);
        this.zzc(6, parcel0);
    }
}

