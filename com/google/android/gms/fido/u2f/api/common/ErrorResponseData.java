package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.fido.zzaj;
import com.google.android.gms.internal.fido.zzak;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "ErrorResponseDataCreator")
@Reserved({1})
@Deprecated
public class ErrorResponseData extends ResponseData {
    public static final Parcelable.Creator CREATOR = null;
    @VisibleForTesting
    public static final String JSON_ERROR_CODE = "errorCode";
    @VisibleForTesting
    public static final String JSON_ERROR_MESSAGE = "errorMessage";
    @Field(getter = "getErrorCodeAsInt", id = 2, type = "int")
    private final ErrorCode zza;
    @Field(getter = "getErrorMessage", id = 3)
    private final String zzb;

    static {
        ErrorResponseData.CREATOR = new zzd();
    }

    @Constructor
    public ErrorResponseData(@Param(id = 2) int v, @Param(id = 3) String s) {
        this.zza = ErrorCode.toErrorCode(v);
        this.zzb = s;
    }

    public ErrorResponseData(ErrorCode errorCode0) {
        this.zza = (ErrorCode)Preconditions.checkNotNull(errorCode0);
        this.zzb = null;
    }

    public ErrorResponseData(ErrorCode errorCode0, String s) {
        this.zza = (ErrorCode)Preconditions.checkNotNull(errorCode0);
        this.zzb = s;
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof ErrorResponseData ? Objects.equal(this.zza, ((ErrorResponseData)object0).zza) && Objects.equal(this.zzb, ((ErrorResponseData)object0).zzb) : false;
    }

    public ErrorCode getErrorCode() {
        return this.zza;
    }

    public int getErrorCodeAsInt() {
        return this.zza.getCode();
    }

    public String getErrorMessage() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb});
    }

    @Override  // com.google.android.gms.fido.u2f.api.common.ResponseData
    public final JSONObject toJsonObject() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("errorCode", this.zza.getCode());
            String s = this.zzb;
            if(s != null) {
                jSONObject0.put("errorMessage", s);
                return jSONObject0;
            }
            return jSONObject0;
        }
        catch(JSONException jSONException0) {
            throw new RuntimeException(jSONException0);
        }
    }

    @Override
    public String toString() {
        zzaj zzaj0 = zzak.zza(this);
        zzaj0.zza("errorCode", this.zza.getCode());
        String s = this.zzb;
        if(s != null) {
            zzaj0.zzb("errorMessage", s);
        }
        return zzaj0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.getErrorCodeAsInt());
        SafeParcelWriter.writeString(parcel0, 3, this.getErrorMessage(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

