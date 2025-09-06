package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "VideoInfoCreator")
@Reserved({1})
public final class VideoInfo extends AbstractSafeParcelable {
    public static class Builder {
        private int zza;
        private int zzb;
        private int zzc;

        public VideoInfo build() {
            return new VideoInfo(this.zza, this.zzb, this.zzc);
        }

        public Builder setHdrType(int v) {
            this.zzc = v;
            return this;
        }

        public Builder setHeight(int v) {
            this.zzb = v;
            return this;
        }

        public Builder setWidth(int v) {
            this.zza = v;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR = null;
    public static final int HDR_TYPE_DV = 3;
    public static final int HDR_TYPE_HDR = 4;
    public static final int HDR_TYPE_HDR10 = 2;
    public static final int HDR_TYPE_SDR = 1;
    public static final int HDR_TYPE_UNKNOWN;
    private static final Logger zza;
    @Field(getter = "getWidth", id = 2)
    private final int zzb;
    @Field(getter = "getHeight", id = 3)
    private final int zzc;
    @Field(getter = "getHdrType", id = 4)
    private final int zzd;

    static {
        VideoInfo.zza = new Logger("VideoInfo");
        VideoInfo.CREATOR = new zzds();
    }

    @Constructor
    public VideoInfo(@Param(id = 2) int v, @Param(id = 3) int v1, @Param(id = 4) int v2) {
        this.zzb = v;
        this.zzc = v1;
        this.zzd = v2;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof VideoInfo ? this.zzc == ((VideoInfo)object0).getHeight() && this.zzb == ((VideoInfo)object0).getWidth() && this.zzd == ((VideoInfo)object0).getHdrType() : false;
    }

    public int getHdrType() {
        return this.zzd;
    }

    public int getHeight() {
        return this.zzc;
    }

    public int getWidth() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzc, this.zzb, this.zzd});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.getWidth());
        SafeParcelWriter.writeInt(parcel0, 3, this.getHeight());
        SafeParcelWriter.writeInt(parcel0, 4, this.getHdrType());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static VideoInfo zza(JSONObject jSONObject0) {
        if(jSONObject0 == null) {
            return null;
        }
        try {
            int v = 2;
            String s = jSONObject0.getString("hdrType");
            switch(s) {
                case "dv": {
                    v = 3;
                    break;
                }
                case "hdr": {
                    v = 4;
                    break;
                }
                case "hdr10": {
                    break;
                }
                case "sdr": {
                    v = 1;
                    break;
                }
                default: {
                    VideoInfo.zza.d("Unknown HDR type: %s", new Object[]{s});
                    v = 0;
                }
            }
            return new VideoInfo(jSONObject0.getInt("width"), jSONObject0.getInt("height"), v);
        }
        catch(JSONException jSONException0) {
        }
        VideoInfo.zza.d(jSONException0, "Error while creating a VideoInfo instance from JSON", new Object[0]);
        return null;
    }

    public final JSONObject zzb() {
        String s;
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("width", this.zzb);
            jSONObject0.put("height", this.zzc);
            switch(this.zzd) {
                case 1: {
                    s = "sdr";
                    break;
                }
                case 2: {
                    s = "hdr10";
                    break;
                }
                case 3: {
                    s = "dv";
                    break;
                }
                case 4: {
                    s = "hdr";
                    break;
                }
                default: {
                    s = null;
                }
            }
            jSONObject0.put("hdrType", s);
            return jSONObject0;
        }
        catch(JSONException unused_ex) {
            VideoInfo.zza.e("Failed to transform VideoInfo into Json", new Object[0]);
            return new JSONObject();
        }
    }
}

