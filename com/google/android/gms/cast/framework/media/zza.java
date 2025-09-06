package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zza implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        boolean z = false;
        boolean z1 = false;
        String s = null;
        String s1 = null;
        IBinder iBinder0 = null;
        NotificationOptions notificationOptions0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 3: {
                    s1 = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 4: {
                    iBinder0 = SafeParcelReader.readIBinder(parcel0, v1);
                    break;
                }
                case 5: {
                    notificationOptions0 = (NotificationOptions)SafeParcelReader.createParcelable(parcel0, v1, NotificationOptions.CREATOR);
                    break;
                }
                case 6: {
                    z = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                case 7: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new CastMediaOptions(s, s1, iBinder0, notificationOptions0, z, z1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new CastMediaOptions[v];
    }
}

