package com.google.android.gms.internal.cast;

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
import java.util.ArrayList;
import java.util.List;

@ShowFirstParty
@Class(creator = "UsageReportingOptInOptionsCreator")
@Reserved({1})
public final class zzfk extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getOptInUsageReporting", id = 2)
    private final int zza;
    @Field(getter = "isNewCheckboxOptIn", id = 3)
    private final boolean zzb;
    @Field(getter = "getAccountsToUpload", id = 4)
    private final List zzc;
    @Field(getter = "getOptInPlayPass", id = 5)
    private final int zzd;
    @Field(getter = "getPlayPassAccount", id = 6)
    private final String zze;
    @Field(getter = "getCbFromSetupWizard", id = 7)
    private final boolean zzf;

    static {
        zzfk.CREATOR = new zzfl();
    }

    @ShowFirstParty
    @Constructor
    public zzfk(@Param(id = 2) int v, @Param(id = 3) boolean z, @Param(id = 4) List list0, @Param(id = 5) int v1, @Param(id = 6) String s, @Param(id = 7) boolean z1) {
        ArrayList arrayList0 = new ArrayList();
        this.zzc = arrayList0;
        this.zza = v;
        this.zzb = z;
        if(list0 != null) {
            arrayList0.addAll(list0);
        }
        this.zzd = v1;
        this.zze = s;
        this.zzf = z1;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.zza);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzb);
        SafeParcelWriter.writeStringList(parcel0, 4, this.zzc, false);
        SafeParcelWriter.writeInt(parcel0, 5, this.zzd);
        SafeParcelWriter.writeString(parcel0, 6, this.zze, false);
        SafeParcelWriter.writeBoolean(parcel0, 7, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final int zza() {
        return this.zza;
    }
}

