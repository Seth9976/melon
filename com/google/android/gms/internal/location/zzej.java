package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzej implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        zzeg zzeg0 = null;
        IBinder iBinder0 = null;
        IBinder iBinder1 = null;
        PendingIntent pendingIntent0 = null;
        IBinder iBinder2 = null;
        String s = null;
        int v1 = 1;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 2: {
                    zzeg0 = (zzeg)SafeParcelReader.createParcelable(parcel0, v2, zzeg.CREATOR);
                    break;
                }
                case 3: {
                    iBinder0 = SafeParcelReader.readIBinder(parcel0, v2);
                    break;
                }
                case 4: {
                    pendingIntent0 = (PendingIntent)SafeParcelReader.createParcelable(parcel0, v2, PendingIntent.CREATOR);
                    break;
                }
                case 5: {
                    iBinder1 = SafeParcelReader.readIBinder(parcel0, v2);
                    break;
                }
                case 6: {
                    iBinder2 = SafeParcelReader.readIBinder(parcel0, v2);
                    break;
                }
                case 8: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzei(v1, zzeg0, iBinder0, iBinder1, pendingIntent0, iBinder2, s);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzei[v];
    }
}

