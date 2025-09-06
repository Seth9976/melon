package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzaa;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzs implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        List list0 = null;
        String s5 = null;
        String s6 = null;
        String s7 = null;
        byte[] arr_b = null;
        String s8 = null;
        zzaa zzaa0 = null;
        Integer integer0 = null;
        Boolean boolean0 = null;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        boolean z = false;
        int v4 = -1;
        while(parcel0.dataPosition() < v) {
            int v5 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v5)) {
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 3: {
                    s1 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 4: {
                    s2 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 5: {
                    s3 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 6: {
                    s4 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 7: {
                    v1 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 8: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v5, WebImage.CREATOR);
                    break;
                }
                case 9: {
                    v2 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 10: {
                    v4 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 11: {
                    s5 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 12: {
                    s6 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 13: {
                    v3 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 14: {
                    s7 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 15: {
                    arr_b = SafeParcelReader.createByteArray(parcel0, v5);
                    break;
                }
                case 16: {
                    s8 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 17: {
                    z = SafeParcelReader.readBoolean(parcel0, v5);
                    break;
                }
                case 18: {
                    zzaa0 = (zzaa)SafeParcelReader.createParcelable(parcel0, v5, zzaa.CREATOR);
                    break;
                }
                case 19: {
                    integer0 = SafeParcelReader.readIntegerObject(parcel0, v5);
                    break;
                }
                case 20: {
                    boolean0 = SafeParcelReader.readBooleanObject(parcel0, v5);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v5);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new CastDevice(s, s1, s2, s3, s4, v1, list0, v2, v4, s5, s6, v3, s7, arr_b, s8, z, zzaa0, integer0, boolean0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new CastDevice[v];
    }
}

