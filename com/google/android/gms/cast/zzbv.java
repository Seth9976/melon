package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbv implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        long v1 = 0L;
        String s1 = null;
        Integer integer0 = null;
        String s2 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 2: {
                    s1 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 3: {
                    v1 = SafeParcelReader.readLong(parcel0, v2);
                    break;
                }
                case 4: {
                    integer0 = SafeParcelReader.readIntegerObject(parcel0, v2);
                    break;
                }
                case 5: {
                    s2 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 6: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new MediaError(s1, v1, integer0, s2, CastUtils.jsonStringToJsonObject(s));
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new MediaError[v];
    }
}

