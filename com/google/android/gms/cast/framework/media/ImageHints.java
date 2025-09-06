package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "ImageHintsCreator")
@Reserved({1})
public class ImageHints extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getType", id = 2)
    private final int zza;
    @Field(getter = "getWidthInPixels", id = 3)
    private final int zzb;
    @Field(getter = "getHeightInPixels", id = 4)
    private final int zzc;

    static {
        ImageHints.CREATOR = new zzh();
    }

    @ShowFirstParty
    @Constructor
    public ImageHints(@Param(id = 2) int v, @Param(id = 3) int v1, @Param(id = 4) int v2) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = v2;
    }

    public int getHeightInPixels() {
        return this.zzc;
    }

    public int getType() {
        return this.zza;
    }

    public int getWidthInPixels() {
        return this.zzb;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.getType());
        SafeParcelWriter.writeInt(parcel0, 3, this.getWidthInPixels());
        SafeParcelWriter.writeInt(parcel0, 4, this.getHeightInPixels());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

