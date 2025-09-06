package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzde implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        Bundle bundle0 = null;
        String s = null;
        boolean z = false;
        long v1 = 0L;
        long v2 = 0L;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v1 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                case 2: {
                    v2 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                case 3: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 7: {
                    bundle0 = SafeParcelReader.createBundle(parcel0, v3);
                    break;
                }
                case 8: {
                    s = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzdd(v1, v2, z, bundle0, s);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzdd[v];
    }
}

