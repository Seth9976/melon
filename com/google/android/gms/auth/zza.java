package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zza implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String s1 = null;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        long v4 = 0L;
        while(parcel0.dataPosition() < v) {
            int v5 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v5)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 2: {
                    v4 = SafeParcelReader.readLong(parcel0, v5);
                    break;
                }
                case 3: {
                    s = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 4: {
                    v2 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 5: {
                    v3 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 6: {
                    s1 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v5);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new AccountChangeEvent(v1, v4, s, v2, v3, s1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new AccountChangeEvent[v];
    }
}

