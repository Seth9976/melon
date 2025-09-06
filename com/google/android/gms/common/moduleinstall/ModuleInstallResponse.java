package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "ModuleInstallResponseCreator")
public class ModuleInstallResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getSessionId", id = 1)
    private final int zaa;
    @Field(defaultValue = "false", getter = "getShouldUnregisterListener", id = 2)
    private final boolean zab;

    static {
        ModuleInstallResponse.CREATOR = new zad();
    }

    @KeepForSdk
    public ModuleInstallResponse(int v) {
        this(v, false);
    }

    @Constructor
    public ModuleInstallResponse(@Param(id = 1) int v, @Param(id = 2) boolean z) {
        this.zaa = v;
        this.zab = z;
    }

    public boolean areModulesAlreadyInstalled() {
        return this.zaa == 0;
    }

    public int getSessionId() {
        return this.zaa;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.getSessionId());
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zab);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final boolean zaa() {
        return this.zab;
    }
}

