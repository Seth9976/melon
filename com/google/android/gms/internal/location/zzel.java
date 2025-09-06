package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzel implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = -1;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        long v5 = 0L;
        float f = 0.0f;
        double f1 = 0.0;
        double f2 = 0.0;
        String s = null;
        while(parcel0.dataPosition() < v) {
            int v6 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v6)) {
                case 1: {
                    s = SafeParcelReader.createString(parcel0, v6);
                    break;
                }
                case 2: {
                    v5 = SafeParcelReader.readLong(parcel0, v6);
                    break;
                }
                case 3: {
                    v3 = SafeParcelReader.readShort(parcel0, v6);
                    break;
                }
                case 4: {
                    f1 = SafeParcelReader.readDouble(parcel0, v6);
                    break;
                }
                case 5: {
                    f2 = SafeParcelReader.readDouble(parcel0, v6);
                    break;
                }
                case 6: {
                    f = SafeParcelReader.readFloat(parcel0, v6);
                    break;
                }
                case 7: {
                    v2 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                case 8: {
                    v4 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                case 9: {
                    v1 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v6);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzek(s, v2, ((short)v3), f1, f2, f, v5, v4, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzek[v];
    }
}

