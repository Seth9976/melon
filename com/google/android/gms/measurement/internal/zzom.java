package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzom implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        byte[] arr_b = null;
        String s = null;
        Bundle bundle0 = null;
        String s1 = null;
        long v1 = 0L;
        long v2 = 0L;
        int v3 = 0;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 1: {
                    v1 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 2: {
                    arr_b = SafeParcelReader.createByteArray(parcel0, v4);
                    break;
                }
                case 3: {
                    s = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 4: {
                    bundle0 = SafeParcelReader.createBundle(parcel0, v4);
                    break;
                }
                case 5: {
                    v3 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 6: {
                    v2 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 7: {
                    s1 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzol(v1, arr_b, s, bundle0, v3, v2, s1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzol[v];
    }
}

