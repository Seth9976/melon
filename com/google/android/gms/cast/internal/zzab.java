package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzab implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 2: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 3: {
                    z = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 4: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 5: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 6: {
                    s1 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 7: {
                    s2 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 8: {
                    s3 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 9: {
                    s4 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 10: {
                    z2 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzaa(v1, z, z1, s, s1, s2, s3, s4, z2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzaa[v];
    }
}

