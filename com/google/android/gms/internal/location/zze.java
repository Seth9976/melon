package com.google.android.gms.internal.location;

import Tf.v;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import ie.d;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.checkerframework.dataflow.qual.Pure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Class(creator = "ClientIdentityCreator")
@Reserved({2, 5})
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001dBS\b\u0017\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001A\u00020\u0004\u0012\n\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0003\u0010\u0007\u001A\u0004\u0018\u00010\u0004\u0012\u0010\b\u0003\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0003\u0010\u000B\u001A\u0004\u0018\u00010\u0000\u00A2\u0006\u0004\b\f\u0010\rBc\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u000E\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u0002\u0012\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0000\u00A2\u0006\u0004\b\f\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001A\u0010\u0018\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0096\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001F\u0010 \u001A\u00020\u001F2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b \u0010!J\u0015\u0010%\u001A\u00020$2\u0006\u0010#\u001A\u00020\"\u00A2\u0006\u0004\b%\u0010&J+\u0010)\u001A\u00020\u00172\u0006\u0010#\u001A\u00020\"2\u0012\u0010(\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00040\'\"\u00020\u0004H\u0007\u00A2\u0006\u0004\b)\u0010*J+\u0010+\u001A\u00020\u00172\u0006\u0010#\u001A\u00020\"2\u0012\u0010(\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00040\'\"\u00020\u0004H\u0007\u00A2\u0006\u0004\b+\u0010*JC\u0010,\u001A\u00020\u00002\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00042\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010$H\u0007\u00A2\u0006\u0004\b,\u0010-J+\u0010.\u001A\u00020\u001F2\u0006\u0010#\u001A\u00020\"2\u0012\u0010(\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00040\'\"\u00020\u0004H\u0007\u00A2\u0006\u0004\b.\u0010/J\u0017\u00100\u001A\u00020\u001F2\u0006\u0010#\u001A\u00020\"H\u0007\u00A2\u0006\u0004\b0\u00101J\u0017\u00102\u001A\u00020\u001F2\u0006\u0010#\u001A\u00020\"H\u0007\u00A2\u0006\u0004\b2\u00101J+\u00103\u001A\u00020\u001F2\u0006\u0010#\u001A\u00020\"2\u0012\u0010(\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00040\'\"\u00020\u0004H\u0007\u00A2\u0006\u0004\b3\u0010/J\u0017\u00104\u001A\u00020\u001F2\u0006\u0010#\u001A\u00020\"H\u0007\u00A2\u0006\u0004\b4\u00101J\u000F\u00105\u001A\u00020\u0000H\u0007\u00A2\u0006\u0004\b5\u00106J\u0011\u00107\u001A\u0004\u0018\u00010\u0000H\u0007\u00A2\u0006\u0004\b7\u00106J-\u0010:\u001A\u00020\u00002\u0006\u0010#\u001A\u00020\"2\b\u00108\u001A\u0004\u0018\u00010\u00002\n\b\u0002\u00109\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b:\u0010;J\u0017\u0010=\u001A\u00020\u00172\u0006\u0010<\u001A\u00020\tH\u0007\u00A2\u0006\u0004\b=\u0010>J\u001F\u0010=\u001A\u00020\u00172\u0006\u0010?\u001A\u00020\u00042\u0006\u0010A\u001A\u00020@H\u0007\u00A2\u0006\u0004\b=\u0010BR\u0018\u0010C\u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010E\u001A\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u00048GX\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0006\u0010G\u001A\u0004\bH\u0010\u0014R \u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b8GX\u0087\u0004\u00A2\u0006\f\n\u0004\b\n\u0010I\u001A\u0004\bJ\u0010KR\u001D\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00020L8G\u00A2\u0006\u0006\u001A\u0004\bM\u0010NR\u001D\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00100L8G\u00A2\u0006\u0006\u001A\u0004\bO\u0010NR\u0016\u0010\u000B\u001A\u0004\u0018\u00010\u00008\u0002X\u0083\u0004\u00A2\u0006\u0006\n\u0004\b\u000B\u0010PR\u001E\u0010Q\u001A\u000E\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00170L8\u00C7\u0002\u00A2\u0006\u0006\u001A\u0004\bQ\u0010NR\u0011\u0010R\u001A\u00020\u00178G\u00A2\u0006\u0006\u001A\u0004\bR\u0010SR\u0011\u0010T\u001A\u00020\u00178G\u00A2\u0006\u0006\u001A\u0004\bT\u0010SR\u0011\u0010U\u001A\u00020\u00178G\u00A2\u0006\u0006\u001A\u0004\bU\u0010SR\u0011\u0010V\u001A\u00020\u00178G\u00A2\u0006\u0006\u001A\u0004\bV\u0010SR\u0011\u0010W\u001A\u00020\u00178G\u00A2\u0006\u0006\u001A\u0004\bW\u0010SR\u001E\u0010X\u001A\u000E\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00170L8\u00C7\u0002\u00A2\u0006\u0006\u001A\u0004\bX\u0010NR\u001C\u0010\u0007\u001A\u0004\u0018\u00010\u00048GX\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0007\u0010G\u001A\u0004\bY\u0010\u0014R\u001A\u0010\u0005\u001A\u00020\u00048GX\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0005\u0010G\u001A\u0004\bZ\u0010\u0014R\u0017\u0010\u000E\u001A\u00020\u00028G\u00A2\u0006\f\n\u0004\b\u000E\u0010[\u001A\u0004\b\\\u0010\u001BR\u0011\u0010^\u001A\u00020\u00008G\u00A2\u0006\u0006\u001A\u0004\b]\u00106R\u001A\u0010\u0003\u001A\u00020\u00028GX\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0003\u0010[\u001A\u0004\b_\u0010\u001BR\u0011\u0010c\u001A\u00020`8G\u00A2\u0006\u0006\u001A\u0004\ba\u0010b\u00A8\u0006e"}, d2 = {"Lcom/google/android/gms/libs/identity/ClientIdentity;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "", "uid", "", "packageName", "attributionTag", "listenerId", "", "Lcom/google/android/gms/common/Feature;", "clientFeatures", "impersonator", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/google/android/gms/libs/identity/ClientIdentity;)V", "pid", "clientSdkVersion", "Lcom/google/android/gms/libs/identity/ClientType;", "clientType", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/google/android/gms/libs/identity/ClientType;Lcom/google/android/gms/libs/identity/ClientIdentity;)V", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Landroid/os/Parcel;", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/content/Context;", "context", "Lcom/google/android/gms/libs/identity/Impersonator;", "asImpersonator", "(Landroid/content/Context;)Lcom/google/android/gms/libs/identity/Impersonator;", "", "permissions", "checkAnyPermissions", "(Landroid/content/Context;[Ljava/lang/String;)Z", "checkPermissions", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/google/android/gms/libs/identity/Impersonator;)Lcom/google/android/gms/libs/identity/ClientIdentity;", "enforceAnyPermissions", "(Landroid/content/Context;[Ljava/lang/String;)V", "enforceFirstParty", "(Landroid/content/Context;)V", "enforcePackageName", "enforcePermissions", "enforceZeroParty", "forAggregation", "()Lcom/google/android/gms/libs/identity/ClientIdentity;", "getImpersonator", "impersonatee", "impersonateeListenerId", "impersonate", "(Landroid/content/Context;Lcom/google/android/gms/libs/identity/ClientIdentity;Ljava/lang/String;)Lcom/google/android/gms/libs/identity/ClientIdentity;", "feature", "supportsFeature", "(Lcom/google/android/gms/common/Feature;)Z", "name", "", "version", "(Ljava/lang/String;J)Z", "_clientSdkVersion", "Ljava/lang/Integer;", "_clientType", "Lcom/google/android/gms/libs/identity/ClientType;", "Ljava/lang/String;", "getAttributionTag", "Ljava/util/List;", "getClientFeatures", "()Ljava/util/List;", "Lkotlin/Function1;", "getClientSdkVersion", "()Lwe/k;", "getClientType", "Lcom/google/android/gms/libs/identity/ClientIdentity;", "isFirstParty", "isImpersonatedIdentity", "()Z", "isMyProcess", "isMyUid", "isMyUser", "isSystemServer", "isZeroParty", "getListenerId", "getPackageName", "I", "getPid", "getRealIdentity", "realIdentity", "getUid", "Landroid/os/UserHandle;", "getUserHandle", "()Landroid/os/UserHandle;", "userHandle", "Companion", "java.com.google.android.gms.libs.identity_identity"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class zze extends AbstractSafeParcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    @NotNull
    public static final zzd zza;
    @Field(getter = "getUid", id = 1)
    private final int zzb;
    @Field(getter = "getPackageName", id = 3)
    @NotNull
    private final String zzc;
    @Field(getter = "getAttributionTag", id = 4)
    @Nullable
    private final String zzd;
    @Field(getter = "getListenerId", id = 6)
    @Nullable
    private final String zze;
    @Field(getter = "getClientFeatures", id = 8)
    @NotNull
    private final List zzf;
    @Field(getter = "getImpersonator", id = 7)
    @Nullable
    private final zze zzg;

    static {
        zze.zza = new zzd(null);
        zze.CREATOR = new zzf();
        Process.myUid();
        Process.myPid();
    }

    @Constructor
    @d
    public zze(@Param(id = 1) int v, @Param(id = 3) @NotNull String s, @Param(id = 4) @Nullable String s1, @Param(id = 6) @Nullable String s2, @Param(id = 8) @Nullable List list0, @Param(id = 7) @Nullable zze zze0) {
        q.g(s, "packageName");
        super();
        if(zze0 != null && zze0.zza()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.zzb = v;
        this.zzc = s;
        this.zzd = s1;
        List list1 = null;
        if(s2 == null) {
            s2 = zze0 == null ? null : zze0.zze;
        }
        this.zze = s2;
        if(list0 == null) {
            if(zze0 != null) {
                list1 = zze0.zzf;
            }
            list0 = list1;
            if(list0 == null) {
                list0 = zzex.zzi();
                q.f(list0, "of(...)");
            }
        }
        zzex zzex0 = zzex.zzj(list0);
        q.f(zzex0, "copyOf(...)");
        this.zzf = zzex0;
        this.zzg = zze0;
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(@Nullable Object object0) {
        return object0 instanceof zze && this.zzb == ((zze)object0).zzb && q.b(this.zzc, ((zze)object0).zzc) && q.b(this.zzd, ((zze)object0).zzd) && q.b(this.zze, ((zze)object0).zze) && q.b(this.zzg, ((zze)object0).zzg) && q.b(this.zzf, ((zze)object0).zzf);
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzc, this.zzd, this.zze, this.zzg});
    }

    @Override
    @NotNull
    public final String toString() {
        int v = 0;
        StringBuilder stringBuilder0 = new StringBuilder(this.zzc.length() + 18 + (this.zzd == null ? 0 : this.zzd.length()));
        stringBuilder0.append(this.zzb);
        stringBuilder0.append("/");
        stringBuilder0.append(this.zzc);
        String s = this.zzd;
        if(s != null) {
            stringBuilder0.append("[");
            if(v.r0(s, this.zzc, false)) {
                stringBuilder0.append(s, this.zzc.length(), s.length());
            }
            else {
                stringBuilder0.append(s);
            }
            stringBuilder0.append("]");
        }
        if(this.zze != null) {
            stringBuilder0.append("/");
            String s1 = this.zze;
            if(s1 != null) {
                v = s1.hashCode();
            }
            stringBuilder0.append(Integer.toHexString(v));
        }
        String s2 = stringBuilder0.toString();
        q.f(s2, "toString(...)");
        return s2;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zzb);
        SafeParcelWriter.writeString(parcel0, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel0, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel0, 6, this.zze, false);
        SafeParcelWriter.writeParcelable(parcel0, 7, this.zzg, v, false);
        SafeParcelWriter.writeTypedList(parcel0, 8, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Pure
    public final boolean zza() {
        return this.zzg != null;
    }
}

