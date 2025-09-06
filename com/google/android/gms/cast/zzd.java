package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzd implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        String s = null;
        String s1 = null;
        List list0 = null;
        List list1 = null;
        String s2 = null;
        Uri uri0 = null;
        String s3 = null;
        String s4 = null;
        Boolean boolean0 = null;
        Boolean boolean1 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 3: {
                    s1 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 4: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v2, WebImage.CREATOR);
                    break;
                }
                case 5: {
                    list1 = SafeParcelReader.createStringList(parcel0, v2);
                    break;
                }
                case 6: {
                    s2 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 7: {
                    uri0 = (Uri)SafeParcelReader.createParcelable(parcel0, v2, Uri.CREATOR);
                    break;
                }
                case 8: {
                    s3 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 9: {
                    s4 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 10: {
                    boolean0 = SafeParcelReader.readBooleanObject(parcel0, v2);
                    break;
                }
                case 11: {
                    boolean1 = SafeParcelReader.readBooleanObject(parcel0, v2);
                    break;
                }
                case 12: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new ApplicationMetadata(s, s1, list0, list1, s2, uri0, s3, s4, boolean0, boolean1, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new ApplicationMetadata[v];
    }
}

