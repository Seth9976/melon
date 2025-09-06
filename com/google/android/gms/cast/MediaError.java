package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "MediaErrorCreator")
@Reserved({1})
public class MediaError extends AbstractSafeParcelable implements ReflectedParcelable {
    public static class Builder {
        private Integer zza;
        private long zzb;
        private String zzc;
        private JSONObject zzd;
        private String zze;

        public Builder() {
            this.zze = "ERROR";
        }

        public MediaError build() {
            return new MediaError((this.zze == null ? "ERROR" : this.zze), this.zzb, this.zza, this.zzc, this.zzd);
        }

        public Builder setCustomData(JSONObject jSONObject0) {
            this.zzd = jSONObject0;
            return this;
        }

        public Builder setDetailedErrorCode(Integer integer0) {
            this.zza = integer0;
            return this;
        }

        public Builder setReason(String s) {
            this.zzc = s;
            return this;
        }

        @KeepForSdk
        public Builder setRequestId(long v) {
            this.zzb = v;
            return this;
        }

        public Builder setType(String s) {
            this.zze = s;
            return this;
        }
    }

    public @interface DetailedErrorCode {
        public static final int APP = 900;
        public static final int BREAK_CLIP_LOADING_ERROR = 901;
        public static final int BREAK_SEEK_INTERCEPTOR_ERROR = 902;
        public static final int DASH_INVALID_SEGMENT_INFO = 423;
        public static final int DASH_MANIFEST_NO_MIMETYPE = 422;
        public static final int DASH_MANIFEST_NO_PERIODS = 421;
        public static final int DASH_MANIFEST_UNKNOWN = 420;
        public static final int DASH_NETWORK = 321;
        public static final int DASH_NO_INIT = 322;
        public static final int GENERIC = 999;
        public static final int HLS_MANIFEST_MASTER = 411;
        public static final int HLS_MANIFEST_PLAYLIST = 412;
        public static final int HLS_NETWORK_INVALID_SEGMENT = 315;
        public static final int HLS_NETWORK_KEY_LOAD = 314;
        public static final int HLS_NETWORK_MASTER_PLAYLIST = 311;
        public static final int HLS_NETWORK_NO_KEY_RESPONSE = 313;
        public static final int HLS_NETWORK_PLAYLIST = 312;
        public static final int HLS_SEGMENT_PARSING = 316;
        public static final int IMAGE_ERROR = 903;
        public static final int LOAD_FAILED = 905;
        public static final int LOAD_INTERRUPTED = 904;
        public static final int MANIFEST_UNKNOWN = 400;
        public static final int MEDIAKEYS_NETWORK = 201;
        public static final int MEDIAKEYS_UNKNOWN = 200;
        public static final int MEDIAKEYS_UNSUPPORTED = 202;
        public static final int MEDIAKEYS_WEBCRYPTO = 203;
        public static final int MEDIA_ABORTED = 101;
        public static final int MEDIA_DECODE = 102;
        public static final int MEDIA_ERROR_MESSAGE = 906;
        public static final int MEDIA_NETWORK = 103;
        public static final int MEDIA_SRC_NOT_SUPPORTED = 104;
        public static final int MEDIA_UNKNOWN = 100;
        public static final int NETWORK_UNKNOWN = 300;
        public static final int SEGMENT_NETWORK = 301;
        public static final int SEGMENT_UNKNOWN = 500;
        public static final int SMOOTH_MANIFEST = 0x1AF;
        public static final int SMOOTH_NETWORK = 331;
        public static final int SMOOTH_NO_MEDIA_DATA = 332;
        public static final int SOURCE_BUFFER_FAILURE = 110;
        public static final int TEXT_UNKNOWN = 600;

    }

    @KeepForSdk
    public static final Parcelable.Creator CREATOR = null;
    public static final String ERROR_REASON_APP_ERROR = "APP_ERROR";
    public static final String ERROR_REASON_AUTHENTICATION_EXPIRED = "AUTHENTICATION_EXPIRED";
    public static final String ERROR_REASON_CONCURRENT_STREAM_LIMIT = "CONCURRENT_STREAM_LIMIT";
    public static final String ERROR_REASON_CONTENT_ALREADY_PLAYING = "CONTENT_ALREADY_PLAYING";
    public static final String ERROR_REASON_CONTENT_FILTERED = "CONTENT_FILTERED";
    public static final String ERROR_REASON_DUPLICATE_REQUEST_ID = "DUPLICATE_REQUEST_ID";
    public static final String ERROR_REASON_END_OF_QUEUE = "END_OF_QUEUE";
    public static final String ERROR_REASON_GENERIC_LOAD_ERROR = "GENERIC_LOAD_ERROR";
    public static final String ERROR_REASON_INVALID_COMMAND = "INVALID_COMMAND";
    public static final String ERROR_REASON_INVALID_MEDIA_SESSION_ID = "INVALID_MEDIA_SESSION_ID";
    public static final String ERROR_REASON_INVALID_PARAMS = "INVALID_PARAMS";
    public static final String ERROR_REASON_INVALID_REQUEST = "INVALID_REQUEST";
    public static final String ERROR_REASON_LANGUAGE_NOT_SUPPORTED = "LANGUAGE_NOT_SUPPORTED";
    public static final String ERROR_REASON_NOT_AVAILABLE_IN_REGION = "NOT_AVAILABLE_IN_REGION";
    public static final String ERROR_REASON_NOT_SUPPORTED = "NOT_SUPPORTED";
    public static final String ERROR_REASON_PARENTAL_CONTROL_RESTRICTED = "PARENTAL_CONTROL_RESTRICTED";
    public static final String ERROR_REASON_PREMIUM_ACCOUNT_REQUIRED = "PREMIUM_ACCOUNT_REQUIRED";
    public static final String ERROR_REASON_SKIP_LIMIT_REACHED = "SKIP_LIMIT_REACHED";
    public static final String ERROR_REASON_VIDEO_DEVICE_REQUIRED = "VIDEO_DEVICE_REQUIRED";
    public static final String ERROR_TYPE_ERROR = "ERROR";
    public static final String ERROR_TYPE_INVALID_PLAYER_STATE = "INVALID_PLAYER_STATE";
    public static final String ERROR_TYPE_INVALID_REQUEST = "INVALID_REQUEST";
    public static final String ERROR_TYPE_LOAD_CANCELLED = "LOAD_CANCELLED";
    public static final String ERROR_TYPE_LOAD_FAILED = "LOAD_FAILED";
    @Field(id = 6)
    String zza;
    @Field(getter = "getType", id = 2)
    private String zzb;
    @Field(getter = "getRequestId", id = 3)
    private long zzc;
    @DetailedErrorCode
    @Field(getter = "getDetailedErrorCode", id = 4)
    private final Integer zzd;
    @Field(getter = "getReason", id = 5)
    private final String zze;
    private final JSONObject zzf;

    static {
        MediaError.CREATOR = new zzbv();
    }

    @KeepForSdk
    public MediaError(String s, long v, Integer integer0, String s1, JSONObject jSONObject0) {
        this.zzb = s;
        this.zzc = v;
        this.zzd = integer0;
        this.zze = s1;
        this.zzf = jSONObject0;
    }

    public JSONObject getCustomData() {
        return this.zzf;
    }

    public Integer getDetailedErrorCode() {
        return this.zzd;
    }

    public String getReason() {
        return this.zze;
    }

    @KeepForSdk
    public long getRequestId() {
        return this.zzc;
    }

    public String getType() {
        return this.zzb;
    }

    @KeepForSdk
    public void setRequestId(long v) {
        this.zzc = v;
    }

    @KeepForSdk
    public void setType(String s) {
        this.zzb = s;
    }

    @KeepForSdk
    public JSONObject toJson() {
        try {
            JSONObject jSONObject0 = new JSONObject();
            jSONObject0.put("requestId", this.zzc);
            jSONObject0.putOpt("detailedErrorCode", this.zzd);
            jSONObject0.putOpt("reason", this.zze);
            jSONObject0.put("customData", this.zzf);
            jSONObject0.putOpt("type", (this.zzb == null ? "ERROR" : this.zzb));
            return jSONObject0;
        }
        catch(JSONException unused_ex) {
            return new JSONObject();
        }
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        this.zza = this.zzf == null ? null : this.zzf.toString();
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.getType(), false);
        SafeParcelWriter.writeLong(parcel0, 3, this.getRequestId());
        SafeParcelWriter.writeIntegerObject(parcel0, 4, this.getDetailedErrorCode(), false);
        SafeParcelWriter.writeString(parcel0, 5, this.getReason(), false);
        SafeParcelWriter.writeString(parcel0, 6, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static MediaError zza(JSONObject jSONObject0) {
        String s = jSONObject0.optString("type", "ERROR");
        long v = jSONObject0.optLong("requestId");
        JSONObject jSONObject1 = null;
        Integer integer0 = jSONObject0.has("detailedErrorCode") ? jSONObject0.optInt("detailedErrorCode") : null;
        String s1 = CastUtils.optStringOrNull(jSONObject0, "reason");
        if(jSONObject0.has("customData")) {
            jSONObject1 = jSONObject0.optJSONObject("customData");
        }
        return new MediaError(s, v, integer0, s1, jSONObject1);
    }
}

