package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.List;

public final class zzi implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        DeviceOrientationRequest deviceOrientationRequest0 = zzh.zzb;
        List list0 = zzh.zza;
        String s = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    deviceOrientationRequest0 = (DeviceOrientationRequest)SafeParcelReader.createParcelable(parcel0, v1, DeviceOrientationRequest.CREATOR);
                    break;
                }
                case 2: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v1, ClientIdentity.CREATOR);
                    break;
                }
                case 3: {
                    s = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzh(deviceOrientationRequest0, list0, s);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzh[v];
    }
}

