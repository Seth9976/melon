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
import org.jetbrains.annotations.Nullable;

@Class(creator = "IncomingCallRetrieverResponseCreator")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B+\b\u0007\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001A\u00020\u0003\u0012\n\b\u0001\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\u000E\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0005\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001A\u0004\b\u0013\u0010\u0012R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001A\u0004\b\u0014\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/google/android/gms/auth/api/phone/IncomingCallRetrieverResponse;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "Lcom/google/android/gms/common/internal/ReflectedParcelable;", "", "phoneNumber", "incomingCallVerificationStatusCode", "errorDetails", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getErrorDetails", "()Ljava/lang/String;", "getIncomingCallVerificationStatusCode", "getPhoneNumber", "Companion", "java.com.google.android.gmscore.integ.client.auth-api-phone_auth-api-phone"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class IncomingCallRetrieverResponse extends AbstractSafeParcelable implements ReflectedParcelable {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/google/android/gms/auth/api/phone/IncomingCallRetrieverResponse$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/google/android/gms/auth/api/phone/IncomingCallRetrieverResponse;", "java.com.google.android.gmscore.integ.client.auth-api-phone_auth-api-phone"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
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
    @Field(getter = "getPhoneNumber", id = 1)
    @Nullable
    private final String zza;
    @Field(getter = "getIncomingCallVerificationStatusCode", id = 2)
    @NotNull
    private final String zzb;
    @Field(getter = "getErrorDetails", id = 3)
    @Nullable
    private final String zzc;

    static {
        IncomingCallRetrieverResponse.Companion = new Companion(null);
        IncomingCallRetrieverResponse.CREATOR = new zzb();
    }

    @Constructor
    public IncomingCallRetrieverResponse(@Param(id = 1) @Nullable String s, @Param(id = 2) String s1, @Param(id = 3) @Nullable String s2) {
        q.g(s1, "incomingCallVerificationStatusCode");
        super();
        this.zza = s;
        this.zzb = s1;
        this.zzc = s2;
        if(s != null && !q.b(s1, "SUCCESS")) {
            throw new IllegalArgumentException("incomingCallVerificationStatusCode should be SUCCESS when phone number is set.");
        }
        if(s == null && q.b(s1, "SUCCESS")) {
            throw new IllegalArgumentException("Phone number must not be null when verificationStatus is SUCCESS.");
        }
    }

    public final String getErrorDetails() {
        return this.zzc;
    }

    @NotNull
    public final String getIncomingCallVerificationStatusCode() {
        return this.zzb;
    }

    public final String getPhoneNumber() {
        return this.zza;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.getPhoneNumber(), false);
        SafeParcelWriter.writeString(parcel0, 2, this.getIncomingCallVerificationStatusCode(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getErrorDetails(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

