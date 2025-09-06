package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzs implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        long v1 = -1L;
        boolean z = false;
        int v2 = 0;
        int v3 = 0;
        String s = null;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 1: {
                    z = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 3: {
                    v2 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 4: {
                    v3 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 5: {
                    v1 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzr(z, s, v2, v3, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzr[v];
    }
}

