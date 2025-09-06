package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzcl implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        List list0 = null;
        int v1 = 0;
        int v2 = 0;
        long v3 = 0L;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 2: {
                    v3 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 3: {
                    v1 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 4: {
                    s1 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 5: {
                    s2 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 6: {
                    s3 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 7: {
                    s4 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 8: {
                    v2 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 9: {
                    list0 = SafeParcelReader.createStringList(parcel0, v4);
                    break;
                }
                case 10: {
                    s = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new MediaTrack(v3, v1, s1, s2, s3, s4, v2, list0, CastUtils.jsonStringToJsonObject(s));
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new MediaTrack[v];
    }
}

