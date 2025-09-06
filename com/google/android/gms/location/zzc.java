package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzc implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        WorkSource workSource0 = null;
        String s = null;
        int[] arr_v = null;
        String s1 = null;
        String s2 = null;
        long v1 = 0L;
        long v2 = 0L;
        boolean z = false;
        boolean z1 = false;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v1 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                case 2: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 3: {
                    workSource0 = (WorkSource)SafeParcelReader.createParcelable(parcel0, v3, WorkSource.CREATOR);
                    break;
                }
                case 4: {
                    s = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 5: {
                    arr_v = SafeParcelReader.createIntArray(parcel0, v3);
                    break;
                }
                case 6: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 7: {
                    s1 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 8: {
                    v2 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                case 9: {
                    s2 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzb(v1, z, workSource0, s, arr_v, z1, s1, v2, s2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzb[v];
    }
}

