package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzs implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        boolean z = false;
        int v1 = 0;
        boolean z1 = false;
        boolean z2 = false;
        int v2 = 0;
        int v3 = 0;
        long v4 = 0L;
        long v5 = 0L;
        long v6 = 0L;
        long v7 = 0L;
        long v8 = 0L;
        long v9 = 0L;
        long v10 = 0L;
        String s = "";
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = null;
        String s5 = null;
        String s6 = null;
        String s7 = null;
        String s8 = null;
        String s9 = null;
        Boolean boolean0 = null;
        List list0 = null;
        String s10 = null;
        String s11 = null;
        int v11 = 100;
        boolean z3 = true;
        boolean z4 = true;
        long v12 = 0xFFFFFFFF80000000L;
        while(parcel0.dataPosition() < v) {
            int v13 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v13)) {
                case 2: {
                    s4 = SafeParcelReader.createString(parcel0, v13);
                    break;
                }
                case 3: {
                    s5 = SafeParcelReader.createString(parcel0, v13);
                    break;
                }
                case 4: {
                    s6 = SafeParcelReader.createString(parcel0, v13);
                    break;
                }
                case 5: {
                    s7 = SafeParcelReader.createString(parcel0, v13);
                    break;
                }
                case 6: {
                    v4 = SafeParcelReader.readLong(parcel0, v13);
                    break;
                }
                case 7: {
                    v5 = SafeParcelReader.readLong(parcel0, v13);
                    break;
                }
                case 8: {
                    s8 = SafeParcelReader.createString(parcel0, v13);
                    break;
                }
                case 9: {
                    z3 = SafeParcelReader.readBoolean(parcel0, v13);
                    break;
                }
                case 10: {
                    z = SafeParcelReader.readBoolean(parcel0, v13);
                    break;
                }
                case 11: {
                    v12 = SafeParcelReader.readLong(parcel0, v13);
                    break;
                }
                case 12: {
                    s9 = SafeParcelReader.createString(parcel0, v13);
                    break;
                }
                case 14: {
                    v6 = SafeParcelReader.readLong(parcel0, v13);
                    break;
                }
                case 15: {
                    v1 = SafeParcelReader.readInt(parcel0, v13);
                    break;
                }
                case 16: {
                    z4 = SafeParcelReader.readBoolean(parcel0, v13);
                    break;
                }
                case 18: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v13);
                    break;
                }
                case 21: {
                    boolean0 = SafeParcelReader.readBooleanObject(parcel0, v13);
                    break;
                }
                case 22: {
                    v7 = SafeParcelReader.readLong(parcel0, v13);
                    break;
                }
                case 23: {
                    list0 = SafeParcelReader.createStringList(parcel0, v13);
                    break;
                }
                case 25: {
                    s = SafeParcelReader.createString(parcel0, v13);
                    break;
                }
                case 26: {
                    s1 = SafeParcelReader.createString(parcel0, v13);
                    break;
                }
                case 27: {
                    s10 = SafeParcelReader.createString(parcel0, v13);
                    break;
                }
                case 28: {
                    z2 = SafeParcelReader.readBoolean(parcel0, v13);
                    break;
                }
                case 29: {
                    v8 = SafeParcelReader.readLong(parcel0, v13);
                    break;
                }
                case 30: {
                    v11 = SafeParcelReader.readInt(parcel0, v13);
                    break;
                }
                case 0x1F: {
                    s2 = SafeParcelReader.createString(parcel0, v13);
                    break;
                }
                case 0x20: {
                    v2 = SafeParcelReader.readInt(parcel0, v13);
                    break;
                }
                case 34: {
                    v9 = SafeParcelReader.readLong(parcel0, v13);
                    break;
                }
                case 35: {
                    s11 = SafeParcelReader.createString(parcel0, v13);
                    break;
                }
                case 36: {
                    s3 = SafeParcelReader.createString(parcel0, v13);
                    break;
                }
                case 37: {
                    v10 = SafeParcelReader.readLong(parcel0, v13);
                    break;
                }
                case 38: {
                    v3 = SafeParcelReader.readInt(parcel0, v13);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v13);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzr(s4, s5, s6, s7, v4, v5, s8, z3, z, v12, s9, v6, v1, z4, z1, boolean0, v7, list0, s, s1, s10, z2, v8, v11, s2, v2, v9, s11, s3, v10, v3);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzr[v];
    }
}

