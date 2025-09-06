package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class zza implements Parcelable.Creator {
    private final Parcelable.Creator zza;
    private static final zza zzb;

    static {
        zza.zzb = new zza(new zzb());
    }

    private zza(Parcelable.Creator parcelable$Creator0) {
        this.zza = parcelable$Creator0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = parcel0.dataPosition();
        if(parcel0.readInt() == -204102970) {
            return zzb.zza(parcel0);
        }
        parcel0.setDataPosition(v - 4);
        return ApiMetadata.getEmptyInstance();
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new ApiMetadata[v];
    }

    public static zza zza() {
        return zza.zzb;
    }
}

