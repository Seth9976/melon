package com.google.android.gms.internal.fido;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;

public final class zzc {
    public static final int zza;
    private static final ClassLoader zzb;

    static {
        zzc.zzb = zzc.class.getClassLoader();
    }

    public static Parcelable zza(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
        return parcel0.readInt() == 0 ? null : ((Parcelable)parcelable$Creator0.createFromParcel(parcel0));
    }

    public static ArrayList zzb(Parcel parcel0) {
        return parcel0.readArrayList(zzc.zzb);
    }

    public static void zzc(Parcel parcel0) {
        int v = parcel0.dataAvail();
        if(v > 0) {
            throw new BadParcelableException("Parcel data not fully consumed, unread size: " + v);
        }
    }

    public static void zzd(Parcel parcel0, Parcelable parcelable0) {
        if(parcelable0 == null) {
            parcel0.writeInt(0);
            return;
        }
        parcel0.writeInt(1);
        parcelable0.writeToParcel(parcel0, 0);
    }
}

