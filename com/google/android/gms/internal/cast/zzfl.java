package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzfl implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        boolean z = false;
        int v2 = 0;
        boolean z1 = false;
        List list0 = null;
        String s = null;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 2: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 3: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 4: {
                    list0 = SafeParcelReader.createStringList(parcel0, v3);
                    break;
                }
                case 5: {
                    v2 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 6: {
                    s = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 7: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzfk(v1, z, list0, v2, s, z1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzfk[v];
    }
}

