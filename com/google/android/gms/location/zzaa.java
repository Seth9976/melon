package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zze;

public final class zzaa implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        zze zze0 = null;
        int v1 = 0;
        boolean z = false;
        long v2 = 0x7FFFFFFFFFFFFFFFL;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v2 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                case 2: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 3: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 5: {
                    zze0 = (zze)SafeParcelReader.createParcelable(parcel0, v3, zze.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new LastLocationRequest(v2, v1, z, zze0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new LastLocationRequest[v];
    }
}

