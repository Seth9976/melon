package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;

@Class(creator = "ConverterWrapperCreator")
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @VersionField(id = 1)
    final int zaa;
    @Field(getter = "getStringToIntConverter", id = 2)
    private final StringToIntConverter zab;

    static {
        zaa.CREATOR = new zab();
    }

    @Constructor
    public zaa(@Param(id = 1) int v, @Param(id = 2) StringToIntConverter stringToIntConverter0) {
        this.zaa = v;
        this.zab = stringToIntConverter0;
    }

    private zaa(StringToIntConverter stringToIntConverter0) {
        this.zaa = 1;
        this.zab = stringToIntConverter0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zaa);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zab, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static zaa zaa(FieldConverter fastJsonResponse$FieldConverter0) {
        if(!(fastJsonResponse$FieldConverter0 instanceof StringToIntConverter)) {
            throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
        }
        return new zaa(((StringToIntConverter)fastJsonResponse$FieldConverter0));
    }

    public final FieldConverter zab() {
        FieldConverter fastJsonResponse$FieldConverter0 = this.zab;
        if(fastJsonResponse$FieldConverter0 == null) {
            throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        }
        return fastJsonResponse$FieldConverter0;
    }
}

