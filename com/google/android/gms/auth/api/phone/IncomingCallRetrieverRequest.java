package com.google.android.gms.auth.api.phone;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Class(creator = "IncomingCallRetrieverRequestCreator")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B1\b\u0007\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0007\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001A\u0004\b\u0014\u0010\u0013R\u001A\u0010\u0005\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001A\u0004\b\u0015\u0010\u0013R\u001A\u0010\u0006\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001A\u0004\b\u0016\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/google/android/gms/auth/api/phone/IncomingCallRetrieverRequest;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "Lcom/google/android/gms/common/internal/ReflectedParcelable;", "", "countryCode", "prefix", "startRange", "endRange", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getCountryCode", "()Ljava/lang/String;", "getEndRange", "getPrefix", "getStartRange", "Companion", "java.com.google.android.gmscore.integ.client.auth-api-phone_auth-api-phone"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class IncomingCallRetrieverRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/google/android/gms/auth/api/phone/IncomingCallRetrieverRequest$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/google/android/gms/auth/api/phone/IncomingCallRetrieverRequest;", "java.com.google.android.gmscore.integ.client.auth-api-phone_auth-api-phone"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
            throw null;
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Parcelable.Creator CREATOR;
    @NotNull
    public static final Companion Companion;
    @Field(getter = "getCountryCode", id = 1)
    @NotNull
    private final String zza;
    @Field(getter = "getPrefix", id = 2)
    @NotNull
    private final String zzb;
    @Field(getter = "getStartRange", id = 3)
    @NotNull
    private final String zzc;
    @Field(getter = "getEndRange", id = 4)
    @NotNull
    private final String zzd;

    static {
        IncomingCallRetrieverRequest.Companion = new Companion(null);
        IncomingCallRetrieverRequest.CREATOR = new zza();
    }

    @Constructor
    public IncomingCallRetrieverRequest(@Param(id = 1) String s, @Param(id = 2) String s1, @Param(id = 3) String s2, @Param(id = 4) String s3) {
        q.g(s, "countryCode");
        q.g(s1, "prefix");
        q.g(s2, "startRange");
        q.g(s3, "endRange");
        super();
        this.zza = s;
        this.zzb = s1;
        this.zzc = s2;
        this.zzd = s3;
    }

    @NotNull
    public final String getCountryCode() {
        return this.zza;
    }

    @NotNull
    public final String getEndRange() {
        return this.zzd;
    }

    @NotNull
    public final String getPrefix() {
        return this.zzb;
    }

    @NotNull
    public final String getStartRange() {
        return this.zzc;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.getCountryCode(), false);
        SafeParcelWriter.writeString(parcel0, 2, this.getPrefix(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getStartRange(), false);
        SafeParcelWriter.writeString(parcel0, 4, this.getEndRange(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

