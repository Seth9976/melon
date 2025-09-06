package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zza implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        String s6 = null;
        String s7 = null;
        String s8 = null;
        VastAdsRequest vastAdsRequest0 = null;
        long v1 = 0L;
        long v2 = 0L;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 3: {
                    s1 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 4: {
                    v1 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                case 5: {
                    s2 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 6: {
                    s3 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 7: {
                    s4 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 8: {
                    s5 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 9: {
                    s6 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 10: {
                    s7 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 11: {
                    v2 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                case 12: {
                    s8 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 13: {
                    vastAdsRequest0 = (VastAdsRequest)SafeParcelReader.createParcelable(parcel0, v3, VastAdsRequest.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new AdBreakClipInfo(s, s1, v1, s2, s3, s4, s5, s6, s7, v2, s8, vastAdsRequest0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new AdBreakClipInfo[v];
    }
}

