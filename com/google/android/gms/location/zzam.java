package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzam implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        long v1 = -1L;
        long v2 = -1L;
        int v3 = 1;
        int v4 = 1;
        while(parcel0.dataPosition() < v) {
            int v5 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v5)) {
                case 1: {
                    v3 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 2: {
                    v4 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 3: {
                    v1 = SafeParcelReader.readLong(parcel0, v5);
                    break;
                }
                case 4: {
                    v2 = SafeParcelReader.readLong(parcel0, v5);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v5);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzal(v3, v4, v1, v2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzal[v];
    }
}

