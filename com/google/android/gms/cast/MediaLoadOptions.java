package com.google.android.gms.cast;

import org.json.JSONObject;

public class MediaLoadOptions {
    public static class Builder {
        private boolean zza;
        private long zzb;
        private double zzc;
        private long[] zzd;
        private JSONObject zze;
        private String zzf;
        private String zzg;

        public Builder() {
            this.zza = true;
            this.zzb = -1L;
            this.zzc = 1.0;
        }

        public MediaLoadOptions build() {
            return new MediaLoadOptions(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, null);
        }

        public Builder setActiveTrackIds(long[] arr_v) {
            this.zzd = arr_v;
            return this;
        }

        public Builder setAutoplay(boolean z) {
            this.zza = z;
            return this;
        }

        public Builder setCredentials(String s) {
            this.zzf = s;
            return this;
        }

        public Builder setCredentialsType(String s) {
            this.zzg = s;
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject0) {
            this.zze = jSONObject0;
            return this;
        }

        public Builder setPlayPosition(long v) {
            this.zzb = v;
            return this;
        }

        public Builder setPlaybackRate(double f) {
            if(Double.compare(f, 2.0) > 0 || Double.compare(f, 0.5) < 0) {
                throw new IllegalArgumentException("playbackRate must be between PLAYBACK_RATE_MIN and PLAYBACK_RATE_MAX");
            }
            this.zzc = f;
            return this;
        }
    }

    public static final double PLAYBACK_RATE_MAX = 2.0;
    public static final double PLAYBACK_RATE_MIN = 0.5;
    private final boolean zza;
    private final long zzb;
    private final double zzc;
    private final long[] zzd;
    private final JSONObject zze;
    private final String zzf;
    private final String zzg;

    public MediaLoadOptions(boolean z, long v, double f, long[] arr_v, JSONObject jSONObject0, String s, String s1, zzby zzby0) {
        this.zza = z;
        this.zzb = v;
        this.zzc = f;
        this.zzd = arr_v;
        this.zze = jSONObject0;
        this.zzf = s;
        this.zzg = s1;
    }

    public long[] getActiveTrackIds() {
        return this.zzd;
    }

    public boolean getAutoplay() {
        return this.zza;
    }

    public String getCredentials() {
        return this.zzf;
    }

    public String getCredentialsType() {
        return this.zzg;
    }

    public JSONObject getCustomData() {
        return this.zze;
    }

    public long getPlayPosition() {
        return this.zzb;
    }

    public double getPlaybackRate() {
        return this.zzc;
    }
}

