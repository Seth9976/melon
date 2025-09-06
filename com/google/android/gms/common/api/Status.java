package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.activity.result.IntentSenderRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import e.b;
import kotlin.jvm.internal.q;

@Class(creator = "StatusCreator")
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    @KeepForSdk
    @ShowFirstParty
    public static final Status RESULT_API_NOT_CONNECTED;
    @KeepForSdk
    @ShowFirstParty
    public static final Status RESULT_CANCELED;
    @KeepForSdk
    public static final Status RESULT_DEAD_CLIENT;
    @KeepForSdk
    @ShowFirstParty
    public static final Status RESULT_INTERNAL_ERROR;
    @KeepForSdk
    @ShowFirstParty
    public static final Status RESULT_INTERRUPTED;
    @KeepForSdk
    @ShowFirstParty
    public static final Status RESULT_SUCCESS;
    @KeepForSdk
    @ShowFirstParty
    public static final Status RESULT_SUCCESS_CACHE;
    @KeepForSdk
    @ShowFirstParty
    public static final Status RESULT_TIMEOUT;
    @Field(getter = "getStatusCode", id = 1)
    private final int zza;
    @Field(getter = "getStatusMessage", id = 2)
    private final String zzb;
    @Field(getter = "getPendingIntent", id = 3)
    private final PendingIntent zzc;
    @Field(getter = "getConnectionResult", id = 4)
    private final ConnectionResult zzd;

    static {
        Status.RESULT_SUCCESS_CACHE = new Status(-1);
        Status.RESULT_SUCCESS = new Status(0);
        Status.RESULT_INTERRUPTED = new Status(14);
        Status.RESULT_INTERNAL_ERROR = new Status(8);
        Status.RESULT_TIMEOUT = new Status(15);
        Status.RESULT_CANCELED = new Status(16);
        Status.RESULT_API_NOT_CONNECTED = new Status(17);
        Status.RESULT_DEAD_CLIENT = new Status(18);
        Status.CREATOR = new zze();
    }

    public Status(int v) {
        this(v, null);
    }

    public Status(int v, String s) {
        this(v, s, null);
    }

    public Status(int v, String s, PendingIntent pendingIntent0) {
        this(v, s, pendingIntent0, null);
    }

    @Constructor
    public Status(@Param(id = 1) int v, @Param(id = 2) String s, @Param(id = 3) PendingIntent pendingIntent0, @Param(id = 4) ConnectionResult connectionResult0) {
        this.zza = v;
        this.zzb = s;
        this.zzc = pendingIntent0;
        this.zzd = connectionResult0;
    }

    public Status(ConnectionResult connectionResult0, String s) {
        this(connectionResult0, s, 17);
    }

    @KeepForSdk
    @Deprecated
    public Status(ConnectionResult connectionResult0, String s, int v) {
        this(v, s, connectionResult0.getResolution(), connectionResult0);
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof Status ? this.zza == ((Status)object0).zza && Objects.equal(this.zzb, ((Status)object0).zzb) && Objects.equal(this.zzc, ((Status)object0).zzc) && Objects.equal(this.zzd, ((Status)object0).zzd) : false;
    }

    public ConnectionResult getConnectionResult() {
        return this.zzd;
    }

    public PendingIntent getResolution() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.zza;
    }

    public String getStatusMessage() {
        return this.zzb;
    }

    public boolean hasResolution() {
        return this.zzc != null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd});
    }

    public boolean isCanceled() {
        return this.zza == 16;
    }

    public boolean isInterrupted() {
        return this.zza == 14;
    }

    public boolean isSuccess() {
        return this.zza <= 0;
    }

    public void startResolutionForResult(Activity activity0, int v) {
        if(!this.hasResolution()) {
            return;
        }
        Preconditions.checkNotNull(this.zzc);
        activity0.startIntentSenderForResult(this.zzc.getIntentSender(), v, null, 0, 0, 0, null);
    }

    public void startResolutionForResult(b b0) {
        if(!this.hasResolution()) {
            return;
        }
        Preconditions.checkNotNull(this.zzc);
        IntentSender intentSender0 = this.zzc.getIntentSender();
        q.g(intentSender0, "intentSender");
        b0.b(new IntentSenderRequest(intentSender0, null, 0, 0));
    }

    @Override
    public String toString() {
        ToStringHelper objects$ToStringHelper0 = Objects.toStringHelper(this);
        objects$ToStringHelper0.add("statusCode", this.zza());
        objects$ToStringHelper0.add("resolution", this.zzc);
        return objects$ToStringHelper0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.getStatusCode());
        SafeParcelWriter.writeString(parcel0, 2, this.getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzc, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.getConnectionResult(), v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final String zza() {
        return this.zzb == null ? CommonStatusCodes.getStatusCodeString(this.zza) : this.zzb;
    }
}

