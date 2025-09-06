package com.google.android.gms.internal.location;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.utils.a;

public final class zzc {
    public static final int zza;
    private static final ClassLoader zzb;

    static {
        zzc.zzb = zzc.class.getClassLoader();
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

    public static void zzd(Parcel parcel0) {
        int v = parcel0.dataAvail();
        if(v > 0) {
            throw new BadParcelableException(a.k(v, "Parcel data not fully consumed, unread size: ", new StringBuilder(String.valueOf(v).length() + 45)));
        }
    }
}

