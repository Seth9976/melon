package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzb implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        String s = null;
        String[] arr_s = null;
        long v1 = 0L;
        long v2 = 0L;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 2: {
                    v1 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                case 3: {
                    s = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 4: {
                    v2 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                case 5: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 6: {
                    arr_s = SafeParcelReader.createStringArray(parcel0, v3);
                    break;
                }
                case 7: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 8: {
                    z2 = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new AdBreakInfo(v1, s, v2, z, arr_s, z1, z2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new AdBreakInfo[v];
    }
}

