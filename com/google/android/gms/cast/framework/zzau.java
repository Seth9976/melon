package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzau extends zza implements zzaw {
    public zzau(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.framework.ISession");
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final int zze() {
        Parcel parcel0 = this.zzb(17, this.zza());
        int v = parcel0.readInt();
        parcel0.recycle();
        return v;
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final int zzf() {
        Parcel parcel0 = this.zzb(18, this.zza());
        int v = parcel0.readInt();
        parcel0.recycle();
        return v;
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final IObjectWrapper zzg() {
        Parcel parcel0 = this.zzb(1, this.zza());
        IObjectWrapper iObjectWrapper0 = Stub.asInterface(parcel0.readStrongBinder());
        parcel0.recycle();
        return iObjectWrapper0;
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final String zzh() {
        Parcel parcel0 = this.zzb(2, this.zza());
        String s = parcel0.readString();
        parcel0.recycle();
        return s;
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final String zzi() {
        Parcel parcel0 = this.zzb(3, this.zza());
        String s = parcel0.readString();
        parcel0.recycle();
        return s;
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final void zzj(int v) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(v);
        this.zzc(15, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final void zzk(int v) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(v);
        this.zzc(12, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final void zzl(int v) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(v);
        this.zzc(13, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final void zzm(boolean z) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(((int)z));
        this.zzc(14, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final void zzn(String s) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        this.zzc(11, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final void zzo(int v) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(v);
        this.zzc(16, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final boolean zzp() {
        Parcel parcel0 = this.zzb(5, this.zza());
        boolean z = zzc.zzf(parcel0);
        parcel0.recycle();
        return z;
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final boolean zzq() {
        Parcel parcel0 = this.zzb(6, this.zza());
        boolean z = zzc.zzf(parcel0);
        parcel0.recycle();
        return z;
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final boolean zzr() {
        Parcel parcel0 = this.zzb(8, this.zza());
        boolean z = zzc.zzf(parcel0);
        parcel0.recycle();
        return z;
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final boolean zzs() {
        Parcel parcel0 = this.zzb(7, this.zza());
        boolean z = zzc.zzf(parcel0);
        parcel0.recycle();
        return z;
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final boolean zzt() {
        Parcel parcel0 = this.zzb(9, this.zza());
        boolean z = zzc.zzf(parcel0);
        parcel0.recycle();
        return z;
    }

    @Override  // com.google.android.gms.cast.framework.zzaw
    public final boolean zzu() {
        Parcel parcel0 = this.zzb(10, this.zza());
        boolean z = zzc.zzf(parcel0);
        parcel0.recycle();
        return z;
    }
}

