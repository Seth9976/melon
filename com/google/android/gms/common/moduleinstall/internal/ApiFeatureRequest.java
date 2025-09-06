package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.moduleinstall.ModuleInstallRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

@KeepForSdk
@Class(creator = "ApiFeatureRequestCreator")
public class ApiFeatureRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private static final Comparator zaa;
    @Field(getter = "getApiFeatures", id = 1)
    private final List zab;
    @Field(getter = "getIsUrgent", id = 2)
    private final boolean zac;
    @Field(getter = "getFeatureRequestSessionId", id = 3)
    private final String zad;
    @Field(getter = "getCallingPackage", id = 4)
    private final String zae;

    static {
        ApiFeatureRequest.CREATOR = new zac();
        ApiFeatureRequest.zaa = zab.zaa;
    }

    @Constructor
    public ApiFeatureRequest(@Param(id = 1) List list0, @Param(id = 2) boolean z, @Param(id = 3) String s, @Param(id = 4) String s1) {
        Preconditions.checkNotNull(list0);
        this.zab = list0;
        this.zac = z;
        this.zad = s;
        this.zae = s1;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof ApiFeatureRequest ? this.zac == ((ApiFeatureRequest)object0).zac && Objects.equal(this.zab, ((ApiFeatureRequest)object0).zab) && Objects.equal(this.zad, ((ApiFeatureRequest)object0).zad) && Objects.equal(this.zae, ((ApiFeatureRequest)object0).zae) : false;
    }

    @KeepForSdk
    public static ApiFeatureRequest fromModuleInstallRequest(ModuleInstallRequest moduleInstallRequest0) {
        return ApiFeatureRequest.zaa(moduleInstallRequest0.getApis(), true);
    }

    @KeepForSdk
    public List getApiFeatures() {
        return this.zab;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.zac), this.zab, this.zad, this.zae});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, this.getApiFeatures(), false);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zac);
        SafeParcelWriter.writeString(parcel0, 3, this.zad, false);
        SafeParcelWriter.writeString(parcel0, 4, this.zae, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static ApiFeatureRequest zaa(List list0, boolean z) {
        TreeSet treeSet0 = new TreeSet(ApiFeatureRequest.zaa);
        for(Object object0: list0) {
            Collections.addAll(treeSet0, ((OptionalModuleApi)object0).getOptionalFeatures());
        }
        return new ApiFeatureRequest(new ArrayList(treeSet0), z, null, null);
    }
}

