package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.CastUtils;
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

@Class(creator = "MediaLiveSeekableRangeCreator")
@Reserved({1})
public class MediaLiveSeekableRange extends AbstractSafeParcelable {
    public static class Builder {
        private long zza;
        private long zzb;
        private boolean zzc;
        private boolean zzd;

        public MediaLiveSeekableRange build() {
            return new MediaLiveSeekableRange(this.zza, this.zzb, this.zzc, this.zzd);
        }

        public Builder setEndTime(long v) {
            this.zzb = v;
            return this;
        }

        public Builder setIsLiveDone(boolean z) {
            this.zzd = z;
            return this;
        }

        public Builder setIsMovingWindow(boolean z) {
            this.zzc = z;
            return this;
        }

        public Builder setStartTime(long v) {
            this.zza = v;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    private static final Logger zza;
    @Field(getter = "getStartTime", id = 2)
    private final long zzb;
    @Field(getter = "getEndTime", id = 3)
    private final long zzc;
    @Field(getter = "isMovingWindow", id = 4)
    private final boolean zzd;
    @Field(getter = "isLiveDone", id = 5)
    private final boolean zze;

    static {
        MediaLiveSeekableRange.zza = new Logger("MediaLiveSeekableRange");
        MediaLiveSeekableRange.CREATOR = new zzbx();
    }

    @Constructor
    public MediaLiveSeekableRange(@Param(id = 2) long v, @Param(id = 3) long v1, @Param(id = 4) boolean z, @Param(id = 5) boolean z1) {
        this.zzb = Math.max(v, 0L);
        this.zzc = Math.max(v1, 0L);
        this.zzd = z;
        this.zze = z1;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof MediaLiveSeekableRange ? this.zzb == ((MediaLiveSeekableRange)object0).zzb && this.zzc == ((MediaLiveSeekableRange)object0).zzc && this.zzd == ((MediaLiveSeekableRange)object0).zzd && this.zze == ((MediaLiveSeekableRange)object0).zze : false;
    }

    public long getEndTime() {
        return this.zzc;
    }

    public long getStartTime() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, this.zzc, Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze)});
    }

    public boolean isLiveDone() {
        return this.zze;
    }

    public boolean isMovingWindow() {
        return this.zzd;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 2, this.getStartTime());
        SafeParcelWriter.writeLong(parcel0, 3, this.getEndTime());
        SafeParcelWriter.writeBoolean(parcel0, 4, this.isMovingWindow());
        SafeParcelWriter.writeBoolean(parcel0, 5, this.isLiveDone());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static MediaLiveSeekableRange zza(JSONObject jSONObject0) {
        if(jSONObject0 == null) {
            return null;
        }
        if(jSONObject0.has("start") && jSONObject0.has("end")) {
            try {
                return new MediaLiveSeekableRange(CastUtils.secToMillisec(jSONObject0.getDouble("start")), CastUtils.secToMillisec(jSONObject0.getDouble("end")), jSONObject0.optBoolean("isMovingWindow"), jSONObject0.optBoolean("isLiveDone"));
            }
            catch(JSONException unused_ex) {
                MediaLiveSeekableRange.zza.e("Ignoring Malformed MediaLiveSeekableRange: " + jSONObject0.toString(), new Object[0]);
            }
        }
        return null;
    }

    public final JSONObject zzb() {
        try {
            JSONObject jSONObject0 = new JSONObject();
            jSONObject0.put("start", ((double)this.zzb) / 1000.0);
            jSONObject0.put("end", ((double)this.zzc) / 1000.0);
            jSONObject0.put("isMovingWindow", this.zzd);
            jSONObject0.put("isLiveDone", this.zze);
            return jSONObject0;
        }
        catch(JSONException unused_ex) {
            MediaLiveSeekableRange.zza.e("Error transforming MediaLiveSeekableRange into JSONObject", new Object[0]);
            return new JSONObject();
        }
    }
}

