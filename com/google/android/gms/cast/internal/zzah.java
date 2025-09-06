package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzbs;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzah extends zza implements IInterface {
    public zzah(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.internal.ICastDeviceController");
    }

    public final void zze(ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(17, parcel0);
    }

    public final void zzf(ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(1, parcel0);
    }

    public final void zzg(String s, String s1, zzbs zzbs0, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzc.zzc(parcel0, zzbs0);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(14, parcel0);
    }

    public final void zzh(String s, LaunchOptions launchOptions0, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzc.zzc(parcel0, launchOptions0);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(13, parcel0);
    }

    public final void zzi(ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(4, parcel0);
    }

    public final void zzj(zzaj zzaj0, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzaj0);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(18, parcel0);
    }

    public final void zzk(String s, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(11, parcel0);
    }

    public final void zzl(ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(6, parcel0);
    }

    public final void zzm(String s, String s1, long v, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeLong(v);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(9, parcel0);
    }

    public final void zzn(boolean z, double f, boolean z1, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(((int)z));
        parcel0.writeDouble(f);
        parcel0.writeInt(((int)z1));
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(8, parcel0);
    }

    public final void zzo(double f, double f1, boolean z, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        parcel0.writeDouble(f);
        parcel0.writeDouble(f1);
        parcel0.writeInt(((int)z));
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(7, parcel0);
    }

    public final void zzp(String s, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(5, parcel0);
    }

    public final void zzq(ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(19, parcel0);
    }

    public final void zzr(String s, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(12, parcel0);
    }
}

