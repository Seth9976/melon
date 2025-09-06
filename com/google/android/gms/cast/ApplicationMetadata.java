package com.google.android.gms.cast;

import A7.d;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Class(creator = "ApplicationMetadataCreator")
@Reserved({1})
public class ApplicationMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getApplicationId", id = 2)
    String zza;
    @Field(getter = "getName", id = 3)
    String zzb;
    @Field(getter = "getSupportedNamespaces", id = 5)
    final List zzc;
    @Field(getter = "getSenderAppIdentifier", id = 6)
    String zzd;
    @Field(getter = "getSenderAppLaunchUrl", id = 7)
    Uri zze;
    @Field(getter = "getIconUrl", id = 8)
    String zzf;
    @Field(getter = "getApplicationType", id = 9)
    private String zzg;
    @Field(getter = "getSenderConnected", id = 10)
    private Boolean zzh;
    @Field(getter = "getLaunchedFromCloud", id = 11)
    private Boolean zzi;
    @Field(getter = "getReceiverVersion", id = 12)
    private final int zzj;

    static {
        ApplicationMetadata.CREATOR = new zzd();
    }

    private ApplicationMetadata() {
        this.zzc = new ArrayList();
        this.zzj = 1;
    }

    @Constructor
    public ApplicationMetadata(@Param(id = 2) String s, @Param(id = 3) String s1, @Param(id = 4) List list0, @Param(id = 5) List list1, @Param(id = 6) String s2, @Param(id = 7) Uri uri0, @Param(id = 8) String s3, @Param(id = 9) String s4, @Param(id = 10) Boolean boolean0, @Param(id = 11) Boolean boolean1, @Param(id = 12) int v) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = list1;
        this.zzd = s2;
        this.zze = uri0;
        this.zzf = s3;
        this.zzg = s4;
        this.zzh = boolean0;
        this.zzi = boolean1;
        this.zzj = v;
    }

    public boolean areNamespacesSupported(List list0) {
        return this.zzc != null && this.zzc.containsAll(list0);
    }

    // 去混淆评级： 低(26)
    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof ApplicationMetadata ? CastUtils.zze(this.zza, ((ApplicationMetadata)object0).zza) && CastUtils.zze(this.zzb, ((ApplicationMetadata)object0).zzb) && CastUtils.zze(this.zzc, ((ApplicationMetadata)object0).zzc) && CastUtils.zze(this.zzd, ((ApplicationMetadata)object0).zzd) && CastUtils.zze(this.zze, ((ApplicationMetadata)object0).zze) && CastUtils.zze(this.zzf, ((ApplicationMetadata)object0).zzf) && CastUtils.zze(this.zzg, ((ApplicationMetadata)object0).zzg) && this.zzj == ((ApplicationMetadata)object0).zzj : false;
    }

    public String getApplicationId() {
        return this.zza;
    }

    public String getIconUrl() {
        return this.zzf;
    }

    @Deprecated
    public List getImages() [...] // Inlined contents

    public String getName() {
        return this.zzb;
    }

    public String getSenderAppIdentifier() {
        return this.zzd;
    }

    public List getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzj});
    }

    public boolean isNamespaceSupported(String s) {
        return this.zzc != null && this.zzc.contains(s);
    }

    public void setIconUrl(String s) {
        this.zzf = s;
    }

    @Override
    public String toString() {
        String s = this.zzd;
        String s1 = String.valueOf(this.zze);
        String s2 = this.zzf;
        String s3 = this.zzg;
        StringBuilder stringBuilder0 = d.o("applicationId: ", this.zza, ", name: ", this.zzb, ", namespaces.count: ");
        stringBuilder0.append((this.zzc == null ? 0 : this.zzc.size()));
        stringBuilder0.append(", senderAppIdentifier: ");
        stringBuilder0.append(s);
        stringBuilder0.append(", senderAppLaunchUrl: ");
        d.u(stringBuilder0, s1, ", iconUrl: ", s2, ", type: ");
        stringBuilder0.append(s3);
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.getApplicationId(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getName(), false);
        SafeParcelWriter.writeTypedList(parcel0, 4, null, false);
        SafeParcelWriter.writeStringList(parcel0, 5, this.getSupportedNamespaces(), false);
        SafeParcelWriter.writeString(parcel0, 6, this.getSenderAppIdentifier(), false);
        SafeParcelWriter.writeParcelable(parcel0, 7, this.zze, v, false);
        SafeParcelWriter.writeString(parcel0, 8, this.getIconUrl(), false);
        SafeParcelWriter.writeString(parcel0, 9, this.zzg, false);
        SafeParcelWriter.writeBooleanObject(parcel0, 10, this.zzh, false);
        SafeParcelWriter.writeBooleanObject(parcel0, 11, this.zzi, false);
        SafeParcelWriter.writeInt(parcel0, 12, this.zzj);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

