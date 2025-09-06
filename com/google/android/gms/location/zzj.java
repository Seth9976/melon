package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zze;

public final class zzj implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        WorkSource workSource0 = new WorkSource();
        zze zze0 = null;
        int v1 = 0;
        boolean z = false;
        int v2 = 0;
        long v3 = 0x7FFFFFFFFFFFFFFFL;
        long v4 = 0x7FFFFFFFFFFFFFFFL;
        int v5 = 102;
        while(parcel0.dataPosition() < v) {
            int v6 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v6)) {
                case 1: {
                    v3 = SafeParcelReader.readLong(parcel0, v6);
                    break;
                }
                case 2: {
                    v1 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                case 3: {
                    v5 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                case 4: {
                    v4 = SafeParcelReader.readLong(parcel0, v6);
                    break;
                }
                case 5: {
                    z = SafeParcelReader.readBoolean(parcel0, v6);
                    break;
                }
                case 6: {
                    workSource0 = (WorkSource)SafeParcelReader.createParcelable(parcel0, v6, WorkSource.CREATOR);
                    break;
                }
                case 7: {
                    v2 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                case 9: {
                    zze0 = (zze)SafeParcelReader.createParcelable(parcel0, v6, zze.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v6);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new CurrentLocationRequest(v3, v1, v5, v4, z, v2, workSource0, zze0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new CurrentLocationRequest[v];
    }
}

