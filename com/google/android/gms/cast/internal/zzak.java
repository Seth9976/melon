package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;
import java.util.List;

public final class zzak extends zza implements IInterface {
    public zzak(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.internal.ICastService");
    }

    public final void zze(IStatusCallback iStatusCallback0, String[] arr_s, String s, List list0, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, iStatusCallback0);
        parcel0.writeStringArray(arr_s);
        parcel0.writeString(s);
        parcel0.writeTypedList(null);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(2, parcel0);
    }

    public final void zzf(zzag zzag0, String[] arr_s, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzag0);
        parcel0.writeStringArray(arr_s);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(5, parcel0);
    }

    public final void zzg(zzag zzag0, String[] arr_s, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzag0);
        parcel0.writeStringArray(arr_s);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(7, parcel0);
    }

    public final void zzh(zzag zzag0, String[] arr_s, ApiMetadata apiMetadata0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzag0);
        parcel0.writeStringArray(arr_s);
        zzc.zzc(parcel0, apiMetadata0);
        this.zzd(6, parcel0);
    }
}

