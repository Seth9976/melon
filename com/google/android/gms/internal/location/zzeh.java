package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public final class zzeh implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        LocationRequest locationRequest0 = null;
        List list0 = null;
        String s = null;
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        boolean z3 = false;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 1: {
                    locationRequest0 = (LocationRequest)SafeParcelReader.createParcelable(parcel0, v2, LocationRequest.CREATOR);
                    break;
                }
                case 5: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v2, ClientIdentity.CREATOR);
                    break;
                }
                case 8: {
                    z = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 9: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 11: {
                    z2 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 12: {
                    z3 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 13: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 14: {
                    v1 = SafeParcelReader.readLong(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzeg(locationRequest0, list0, z, z1, z2, z3, s, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzeg[v];
    }
}

