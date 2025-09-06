package com.google.android.gms.cast;

import com.google.android.gms.common.internal.Objects;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

public class MediaSeekOptions {
    public static class Builder {
        private long zza;
        private int zzb;
        private boolean zzc;
        private JSONObject zzd;

        public Builder() {
            this.zzb = 0;
        }

        public MediaSeekOptions build() {
            return new MediaSeekOptions(this.zza, this.zzb, this.zzc, this.zzd, null);
        }

        public Builder setCustomData(JSONObject jSONObject0) {
            this.zzd = jSONObject0;
            return this;
        }

        public Builder setIsSeekToInfinite(boolean z) {
            this.zzc = z;
            return this;
        }

        public Builder setPosition(long v) {
            this.zza = v;
            return this;
        }

        public Builder setResumeState(int v) {
            this.zzb = v;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResumeState {
    }

    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED;
    private final long zza;
    private final int zzb;
    private final boolean zzc;
    private final JSONObject zzd;

    public MediaSeekOptions(long v, int v1, boolean z, JSONObject jSONObject0, zzcj zzcj0) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = z;
        this.zzd = jSONObject0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof MediaSeekOptions ? this.zza == ((MediaSeekOptions)object0).zza && this.zzb == ((MediaSeekOptions)object0).zzb && this.zzc == ((MediaSeekOptions)object0).zzc && Objects.equal(this.zzd, ((MediaSeekOptions)object0).zzd) : false;
    }

    public JSONObject getCustomData() {
        return this.zzd;
    }

    public long getPosition() {
        return this.zza;
    }

    public int getResumeState() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, Boolean.valueOf(this.zzc), this.zzd});
    }

    public boolean isSeekToInfinite() {
        return this.zzc;
    }
}

