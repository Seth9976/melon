package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzap implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        long v4 = 0L;
        long v5 = 0L;
        while(parcel0.dataPosition() < v) {
            int v6 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v6)) {
                case 1: {
                    v4 = SafeParcelReader.readLong(parcel0, v6);
                    break;
                }
                case 2: {
                    v5 = SafeParcelReader.readLong(parcel0, v6);
                    break;
                }
                case 3: {
                    v1 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                case 4: {
                    v2 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                case 5: {
                    v3 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v6);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new SleepSegmentEvent(v4, v5, v1, v2, v3);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SleepSegmentEvent[v];
    }
}

