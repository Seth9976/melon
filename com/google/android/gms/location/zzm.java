package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzm implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        float f = 0.0f;
        float f1 = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int v1 = 0;
        long v2 = 0L;
        float[] arr_f = null;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            int v4 = (char)v3;
            if(v4 == 1) {
                arr_f = SafeParcelReader.createFloatArray(parcel0, v3);
            }
            else {
                switch(v4) {
                    case 4: {
                        f = SafeParcelReader.readFloat(parcel0, v3);
                        break;
                    }
                    case 5: {
                        f1 = SafeParcelReader.readFloat(parcel0, v3);
                        break;
                    }
                    case 6: {
                        v2 = SafeParcelReader.readLong(parcel0, v3);
                        break;
                    }
                    case 7: {
                        v1 = SafeParcelReader.readByte(parcel0, v3);
                        break;
                    }
                    case 8: {
                        f2 = SafeParcelReader.readFloat(parcel0, v3);
                        break;
                    }
                    case 9: {
                        f3 = SafeParcelReader.readFloat(parcel0, v3);
                        break;
                    }
                    default: {
                        SafeParcelReader.skipUnknownField(parcel0, v3);
                    }
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new DeviceOrientation(arr_f, f, f1, v2, ((byte)v1), f2, f3);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new DeviceOrientation[v];
    }
}

