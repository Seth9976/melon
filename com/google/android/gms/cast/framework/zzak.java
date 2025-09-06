package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzak extends zza implements zzam {
    public zzak(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.framework.ICastSession");
    }

    @Override  // com.google.android.gms.cast.framework.zzam
    public final void zze(boolean z, int v) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(((int)z));
        parcel0.writeInt(0);
        this.zzc(6, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzam
    public final void zzf(ApplicationMetadata applicationMetadata0, String s, String s1, boolean z) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, applicationMetadata0);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeInt(((int)z));
        this.zzc(4, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzam
    public final void zzg(int v) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(v);
        this.zzc(5, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzam
    public final void zzh(Bundle bundle0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, null);
        this.zzc(1, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzam
    public final void zzi(ConnectionResult connectionResult0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, connectionResult0);
        this.zzc(3, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzam
    public final void zzj(int v) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(v);
        this.zzc(2, parcel0);
    }
}

