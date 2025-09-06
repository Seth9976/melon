package com.google.android.gms.internal.cast;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.ApiMetadata;

public final class zzel extends zza implements IInterface {
    public zzel(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
    }

    public final void zze(ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(3, parcel0);
    }

    public final void zzf(zzek zzek0, int v, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzek0);
        parcel0.writeInt(v);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(5, parcel0);
    }

    public final void zzg(zzek zzek0, zzen zzen0, String s, String s1, Bundle bundle0, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzek0);
        zzc.zze(parcel0, zzen0);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzc.zzc(parcel0, bundle0);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(7, parcel0);
    }

    public final void zzh(zzek zzek0, PendingIntent pendingIntent0, String s, String s1, Bundle bundle0, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzek0);
        zzc.zzc(parcel0, pendingIntent0);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzc.zzc(parcel0, bundle0);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(8, parcel0);
    }

    public final void zzi(zzek zzek0, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzek0);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(6, parcel0);
    }
}

