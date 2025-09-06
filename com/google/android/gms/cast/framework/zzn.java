package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzn implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int v1 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        String s = null;
        List list0 = null;
        LaunchOptions launchOptions0 = null;
        CastMediaOptions castMediaOptions0 = null;
        List list1 = null;
        zzj zzj0 = null;
        zzl zzl0 = null;
        double f = 0.0;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 3: {
                    list0 = SafeParcelReader.createStringList(parcel0, v2);
                    break;
                }
                case 4: {
                    z = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 5: {
                    launchOptions0 = (LaunchOptions)SafeParcelReader.createParcelable(parcel0, v2, LaunchOptions.CREATOR);
                    break;
                }
                case 6: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 7: {
                    castMediaOptions0 = (CastMediaOptions)SafeParcelReader.createParcelable(parcel0, v2, CastMediaOptions.CREATOR);
                    break;
                }
                case 8: {
                    z2 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 9: {
                    f = SafeParcelReader.readDouble(parcel0, v2);
                    break;
                }
                case 10: {
                    z3 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 11: {
                    z4 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 12: {
                    z5 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 13: {
                    list1 = SafeParcelReader.createStringList(parcel0, v2);
                    break;
                }
                case 14: {
                    z6 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 15: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 16: {
                    z7 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 17: {
                    zzj0 = (zzj)SafeParcelReader.createParcelable(parcel0, v2, zzj.CREATOR);
                    break;
                }
                case 18: {
                    zzl0 = (zzl)SafeParcelReader.createParcelable(parcel0, v2, zzl.CREATOR);
                    break;
                }
                case 19: {
                    z8 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 20: {
                    z9 = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new CastOptions(s, list0, z, launchOptions0, z1, castMediaOptions0, z2, f, z3, z4, z5, list1, z6, v1, z7, zzj0, zzl0, z8, z9);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new CastOptions[v];
    }
}

