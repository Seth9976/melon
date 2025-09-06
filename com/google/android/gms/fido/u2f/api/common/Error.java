package com.google.android.gms.fido.u2f.api.common;

import androidx.appcompat.app.o;
import com.google.android.gms.common.util.VisibleForTesting;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class Error {
    @VisibleForTesting
    public static final String JSON_ERROR_CODE = "errorCode";
    @VisibleForTesting
    public static final String JSON_ERROR_MESSAGE = "errorMessage";
    private final ErrorCode zza;
    private final String zzb;

    public Error(ErrorCode errorCode0) {
        this.zza = errorCode0;
        this.zzb = null;
    }

    public Error(ErrorCode errorCode0, String s) {
        this.zza = errorCode0;
        this.zzb = s;
    }

    public ErrorCode getErrorCode() {
        return this.zza;
    }

    public String getErrorMessage() {
        return this.zzb;
    }

    public JSONObject toJsonObject() {
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
        return this.zzb == null ? o.j(this.zza.getCode(), "{errorCode: ", "}") : "{errorCode: " + this.zza.getCode() + ", errorMessage: " + this.zzb + "}";
    }
}

