package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzab implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        boolean z = false;
        zzal[] arr_zzal = null;
        long v1 = 0L;
        int v2 = 1;
        int v3 = 1;
        int v4 = 1000;
        while(parcel0.dataPosition() < v) {
            int v5 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v5)) {
                case 1: {
                    v2 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 2: {
                    v3 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 3: {
                    v1 = SafeParcelReader.readLong(parcel0, v5);
                    break;
                }
                case 4: {
                    v4 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 5: {
                    arr_zzal = (zzal[])SafeParcelReader.createTypedArray(parcel0, v5, zzal.CREATOR);
                    break;
                }
                case 6: {
                    z = SafeParcelReader.readBoolean(parcel0, v5);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v5);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new LocationAvailability(v4, v2, v3, v1, arr_zzal, z);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new LocationAvailability[v];
    }
}

