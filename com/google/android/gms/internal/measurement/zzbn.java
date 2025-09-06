package com.google.android.gms.internal.measurement;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.utils.a;
import java.util.HashMap;

public final class zzbn {
    public static final int zza;
    private static final ClassLoader zzb;

    static {
        zzbn.zzb = zzbn.class.getClassLoader();
    }

    public static boolean zza(Parcel parcel0) {
        return parcel0.readInt() != 0;
    }

    public static Parcelable zzb(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
        return parcel0.readInt() == 0 ? null : ((Parcelable)parcelable$Creator0.createFromParcel(parcel0));
    }

    public static void zzc(Parcel parcel0, Parcelable parcelable0) {
        if(parcelable0 == null) {
            parcel0.writeInt(0);
            return;
        }
        parcel0.writeInt(1);
        parcelable0.writeToParcel(parcel0, 0);
    }

    public static void zzd(Parcel parcel0, IInterface iInterface0) {
        if(iInterface0 == null) {
            parcel0.writeStrongBinder(null);
            return;
        }
        parcel0.writeStrongBinder(iInterface0.asBinder());
    }

    public static HashMap zze(Parcel parcel0) {
        return parcel0.readHashMap(zzbn.zzb);
    }

    public static void zzf(Parcel parcel0) {
        int v = parcel0.dataAvail();
        if(v > 0) {
            throw new BadParcelableException(a.k(v, "Parcel data not fully consumed, unread size: ", new StringBuilder(String.valueOf(v).length() + 45)));
        }
    }
}

