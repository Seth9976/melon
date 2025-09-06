package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@KeepForSdk
@Class(creator = "GetServiceRequestCreator")
@Reserved({9, 16})
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    static final Scope[] zza;
    static final Feature[] zzb;
    @VersionField(id = 1)
    final int zzc;
    @Field(id = 2)
    final int zzd;
    @Field(id = 3)
    final int zze;
    @Field(id = 4)
    String zzf;
    @Field(id = 5)
    IBinder zzg;
    @Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_SCOPES", id = 6)
    Scope[] zzh;
    @Field(defaultValueUnchecked = "new android.os.Bundle()", id = 7)
    Bundle zzi;
    @Field(id = 8)
    Account zzj;
    @Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_FEATURES", id = 10)
    Feature[] zzk;
    @Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_FEATURES", id = 11)
    Feature[] zzl;
    @Field(id = 12)
    final boolean zzm;
    @Field(defaultValue = "0", id = 13)
    final int zzn;
    @Field(getter = "isRequestingTelemetryConfiguration", id = 14)
    boolean zzo;
    @Field(getter = "getAttributionTag", id = 15)
    private final String zzp;

    static {
        GetServiceRequest.CREATOR = new zzm();
        GetServiceRequest.zza = new Scope[0];
        GetServiceRequest.zzb = new Feature[0];
    }

    @Constructor
    public GetServiceRequest(@Param(id = 1) int v, @Param(id = 2) int v1, @Param(id = 3) int v2, @Param(id = 4) String s, @Param(id = 5) IBinder iBinder0, @Param(id = 6) Scope[] arr_scope, @Param(id = 7) Bundle bundle0, @Param(id = 8) Account account0, @Param(id = 10) Feature[] arr_feature, @Param(id = 11) Feature[] arr_feature1, @Param(id = 12) boolean z, @Param(id = 13) int v3, @Param(id = 14) boolean z1, @Param(id = 15) String s1) {
        if(arr_scope == null) {
            arr_scope = GetServiceRequest.zza;
        }
        if(bundle0 == null) {
            bundle0 = new Bundle();
        }
        if(arr_feature == null) {
            arr_feature = GetServiceRequest.zzb;
        }
        if(arr_feature1 == null) {
            arr_feature1 = GetServiceRequest.zzb;
        }
        this.zzc = v;
        this.zzd = v1;
        this.zze = v2;
        this.zzf = "com.google.android.gms".equals(s) ? "com.google.android.gms" : s;
        if(v < 2) {
            this.zzj = iBinder0 == null ? null : AccountAccessor.getAccountBinderSafe(Stub.asInterface(iBinder0));
        }
        else {
            this.zzg = iBinder0;
            this.zzj = account0;
        }
        this.zzh = arr_scope;
        this.zzi = bundle0;
        this.zzk = arr_feature;
        this.zzl = arr_feature1;
        this.zzm = z;
        this.zzn = v3;
        this.zzo = z1;
        this.zzp = s1;
    }

    @KeepForSdk
    public String getAttributionTag() {
        return this.zzp;
    }

    @KeepForSdk
    public String getCallingPackage() {
        return this.zzf;
    }

    @KeepForSdk
    public Feature[] getClientApiFeatures() {
        return this.zzl;
    }

    @KeepForSdk
    public int getClientLibraryVersion() {
        return this.zze;
    }

    @KeepForSdk
    public Bundle getExtraArgs() {
        return this.zzi;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        zzm.zza(this, parcel0, v);
    }
}

