package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zze;

public final class zzaf implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        WorkSource workSource0 = new WorkSource();
        zze zze0 = null;
        boolean z = false;
        int v1 = 0;
        int v2 = 0;
        boolean z1 = false;
        long v3 = -1L;
        float f = 0.0f;
        int v4 = 0x7FFFFFFF;
        long v5 = 0x7FFFFFFFFFFFFFFFL;
        long v6 = 0x7FFFFFFFFFFFFFFFL;
        long v7 = 0L;
        long v8 = 600000L;
        long v9 = 3600000L;
        int v10 = 102;
        while(parcel0.dataPosition() < v) {
            int v11 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v11)) {
                case 1: {
                    v10 = SafeParcelReader.readInt(parcel0, v11);
                    break;
                }
                case 2: {
                    v9 = SafeParcelReader.readLong(parcel0, v11);
                    break;
                }
                case 3: {
                    v8 = SafeParcelReader.readLong(parcel0, v11);
                    break;
                }
                case 5: {
                    v5 = SafeParcelReader.readLong(parcel0, v11);
                    break;
                }
                case 6: {
                    v4 = SafeParcelReader.readInt(parcel0, v11);
                    break;
                }
                case 7: {
                    f = SafeParcelReader.readFloat(parcel0, v11);
                    break;
                }
                case 8: {
                    v7 = SafeParcelReader.readLong(parcel0, v11);
                    break;
                }
                case 9: {
                    z = SafeParcelReader.readBoolean(parcel0, v11);
                    break;
                }
                case 10: {
                    v6 = SafeParcelReader.readLong(parcel0, v11);
                    break;
                }
                case 11: {
                    v3 = SafeParcelReader.readLong(parcel0, v11);
                    break;
                }
                case 12: {
                    v1 = SafeParcelReader.readInt(parcel0, v11);
                    break;
                }
                case 13: {
                    v2 = SafeParcelReader.readInt(parcel0, v11);
                    break;
                }
                case 15: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v11);
                    break;
                }
                case 16: {
                    workSource0 = (WorkSource)SafeParcelReader.createParcelable(parcel0, v11, WorkSource.CREATOR);
                    break;
                }
                case 17: {
                    zze0 = (zze)SafeParcelReader.createParcelable(parcel0, v11, zze.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v11);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new LocationRequest(v10, v9, v8, v7, v5, v6, v4, f, z, v3, v1, v2, z1, workSource0, zze0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new LocationRequest[v];
    }
}

