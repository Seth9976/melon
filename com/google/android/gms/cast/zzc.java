package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzc implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        long v1 = 0L;
        long v2 = 0L;
        long v3 = 0L;
        String s = null;
        String s1 = null;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 2: {
                    v1 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 3: {
                    v2 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 4: {
                    s = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 5: {
                    s1 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 6: {
                    v3 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new AdBreakStatus(v1, v2, s, s1, v3);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new AdBreakStatus[v];
    }
}

