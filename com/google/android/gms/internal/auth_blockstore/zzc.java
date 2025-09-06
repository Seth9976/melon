package com.google.android.gms.internal.auth_blockstore;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public final class zzc {
    public static final int zza;

    static {
    }

    public static Parcelable zza(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
        return parcel0.readInt() == 0 ? null : ((Parcelable)parcelable$Creator0.createFromParcel(parcel0));
    }

    public static void zzb(Parcel parcel0, Parcelable parcelable0) {
        if(parcelable0 == null) {
            parcel0.writeInt(0);
            return;
        }
        parcel0.writeInt(1);
        parcelable0.writeToParcel(parcel0, 0);
    }

    public static void zzc(Parcel parcel0, IInterface iInterface0) {
        parcel0.writeStrongBinder(iInterface0.asBinder());
    }

    public static boolean zzd(Parcel parcel0) {
        return parcel0.readInt() != 0;
    }
}

