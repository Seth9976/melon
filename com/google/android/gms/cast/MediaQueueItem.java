package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.JsonUtils;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "MediaQueueItemCreator")
@Reserved({1})
public class MediaQueueItem extends AbstractSafeParcelable {
    public static class Builder {
        private final MediaQueueItem zza;

        public Builder(MediaInfo mediaInfo0) {
            this.zza = new MediaQueueItem(mediaInfo0, null);
        }

        public Builder(MediaQueueItem mediaQueueItem0) {
            this.zza = new MediaQueueItem(mediaQueueItem0, null);
        }

        public Builder(JSONObject jSONObject0) {
            this.zza = new MediaQueueItem(jSONObject0);
        }

        public MediaQueueItem build() {
            this.zza.zzi();
            return this.zza;
        }

        public Builder clearItemId() {
            this.zza.getWriter().setItemId(0);
            return this;
        }

        public Builder setActiveTrackIds(long[] arr_v) {
            this.zza.getWriter().setActiveTrackIds(arr_v);
            return this;
        }

        public Builder setAutoplay(boolean z) {
            this.zza.getWriter().setAutoplay(z);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject0) {
            this.zza.getWriter().setCustomData(jSONObject0);
            return this;
        }

        public Builder setItemId(int v) {
            this.zza.getWriter().setItemId(v);
            return this;
        }

        public Builder setPlaybackDuration(double f) {
            this.zza.getWriter().setPlaybackDuration(f);
            return this;
        }

        public Builder setPreloadTime(double f) {
            this.zza.getWriter().setPreloadTime(f);
            return this;
        }

        public Builder setStartTime(double f) {
            this.zza.getWriter().setStartTime(f);
            return this;
        }
    }

    @KeepForSdk
    public class Writer {
        final MediaQueueItem zza;

        @KeepForSdk
        public void setActiveTrackIds(long[] arr_v) {
            MediaQueueItem.this.zzh = arr_v;
        }

        @KeepForSdk
        public void setAutoplay(boolean z) {
            MediaQueueItem.this.zzd = z;
        }

        @KeepForSdk
        public void setCustomData(JSONObject jSONObject0) {
            MediaQueueItem.this.zzi = jSONObject0;
        }

        @KeepForSdk
        public void setItemId(int v) {
            MediaQueueItem.this.zzc = v;
        }

        @KeepForSdk
        public void setMedia(MediaInfo mediaInfo0) {
            MediaQueueItem.this.zzb = mediaInfo0;
        }

        @KeepForSdk
        public void setPlaybackDuration(double f) {
            if(Double.isNaN(f)) {
                throw new IllegalArgumentException("playbackDuration cannot be NaN.");
            }
            MediaQueueItem.this.zzf = f;
        }

        @KeepForSdk
        public void setPreloadTime(double f) {
            if(Double.isNaN(f) || f < 0.0) {
                throw new IllegalArgumentException("preloadTime cannot be negative or NaN.");
            }
            MediaQueueItem.this.zzg = f;
        }

        @KeepForSdk
        public void setStartTime(double f) {
            if(!Double.isNaN(f) && f < 0.0) {
                throw new IllegalArgumentException("startTime cannot be negative.");
            }
            MediaQueueItem.this.zze = f;
        }
    }

    @KeepForSdk
    public static final Parcelable.Creator CREATOR = null;
    public static final double DEFAULT_PLAYBACK_DURATION = Infinity;
    public static final int INVALID_ITEM_ID;
    @Field(id = 9)
    String zza;
    @Field(getter = "getMedia", id = 2)
    private MediaInfo zzb;
    @Field(getter = "getItemId", id = 3)
    private int zzc;
    @Field(getter = "getAutoplay", id = 4)
    private boolean zzd;
    @Field(getter = "getStartTime", id = 5)
    private double zze;
    @Field(getter = "getPlaybackDuration", id = 6)
    private double zzf;
    @Field(getter = "getPreloadTime", id = 7)
    private double zzg;
    @Field(getter = "getActiveTrackIds", id = 8)
    private long[] zzh;
    private JSONObject zzi;
    private final Writer zzj;

    static {
        MediaQueueItem.CREATOR = new zzci();
    }

    @Constructor
    public MediaQueueItem(@Param(id = 2) MediaInfo mediaInfo0, @Param(id = 3) int v, @Param(id = 4) boolean z, @Param(id = 5) double f, @Param(id = 6) double f1, @Param(id = 7) double f2, @Param(id = 8) long[] arr_v, @Param(id = 9) String s) {
        this.zze = NaN;
        this.zzj = new Writer(this);
        this.zzb = mediaInfo0;
        this.zzc = v;
        this.zzd = z;
        this.zze = f;
        this.zzf = f1;
        this.zzg = f2;
        this.zzh = arr_v;
        this.zza = s;
        if(s != null) {
            try {
                this.zzi = new JSONObject(this.zza);
            }
            catch(JSONException unused_ex) {
                this.zzi = null;
                this.zza = null;
            }
            return;
        }
        this.zzi = null;
    }

    public MediaQueueItem(MediaInfo mediaInfo0, zzch zzch0) {
        this(mediaInfo0, 0, true, NaN, Infinity, 0.0, null, null);
        if(mediaInfo0 == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
    }

    public MediaQueueItem(MediaQueueItem mediaQueueItem0, zzch zzch0) {
        this(mediaQueueItem0.getMedia(), mediaQueueItem0.getItemId(), mediaQueueItem0.getAutoplay(), mediaQueueItem0.getStartTime(), mediaQueueItem0.getPlaybackDuration(), mediaQueueItem0.getPreloadTime(), mediaQueueItem0.getActiveTrackIds(), null);
        if(this.zzb == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.zzi = mediaQueueItem0.getCustomData();
    }

    @KeepForSdk
    public MediaQueueItem(JSONObject jSONObject0) {
        this(null, 0, true, NaN, Infinity, 0.0, null, null);
        this.fromJson(jSONObject0);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MediaQueueItem)) {
            return false;
        }
        JSONObject jSONObject0 = this.zzi;
        JSONObject jSONObject1 = ((MediaQueueItem)object0).zzi;
        if((jSONObject0 == null ? 1 : 0) != (jSONObject1 == null ? 1 : 0)) {
            return false;
        }
        return jSONObject0 == null || jSONObject1 == null || JsonUtils.areJsonValuesEquivalent(jSONObject0, jSONObject1) ? CastUtils.zze(this.zzb, ((MediaQueueItem)object0).zzb) && this.zzc == ((MediaQueueItem)object0).zzc && this.zzd == ((MediaQueueItem)object0).zzd && (Double.isNaN(this.zze) && Double.isNaN(((MediaQueueItem)object0).zze) || this.zze == ((MediaQueueItem)object0).zze) && this.zzf == ((MediaQueueItem)object0).zzf && this.zzg == ((MediaQueueItem)object0).zzg && Arrays.equals(this.zzh, ((MediaQueueItem)object0).zzh) : false;
    }

    @KeepForSdk
    public boolean fromJson(JSONObject jSONObject0) {
        long[] arr_v;
        boolean z1;
        boolean z = false;
        if(jSONObject0.has("media")) {
            this.zzb = new MediaInfo(jSONObject0.getJSONObject("media"));
            z1 = true;
        }
        else {
            z1 = false;
        }
        if(jSONObject0.has("itemId")) {
            int v = jSONObject0.getInt("itemId");
            if(this.zzc != v) {
                this.zzc = v;
                z1 = true;
            }
        }
        if(jSONObject0.has("autoplay")) {
            boolean z2 = jSONObject0.getBoolean("autoplay");
            if(this.zzd != z2) {
                this.zzd = z2;
                z1 = true;
            }
        }
        double f = jSONObject0.optDouble("startTime");
        if(Double.isNaN(f) != Double.isNaN(this.zze) || !Double.isNaN(f) && Math.abs(f - this.zze) > 1.000000E-07) {
            this.zze = f;
            z1 = true;
        }
        if(jSONObject0.has("playbackDuration")) {
            double f1 = jSONObject0.getDouble("playbackDuration");
            if(Math.abs(f1 - this.zzf) > 1.000000E-07) {
                this.zzf = f1;
                z1 = true;
            }
        }
        if(jSONObject0.has("preloadTime")) {
            double f2 = jSONObject0.getDouble("preloadTime");
            if(Math.abs(f2 - this.zzg) > 1.000000E-07) {
                this.zzg = f2;
                z1 = true;
            }
        }
        if(jSONObject0.has("activeTrackIds")) {
            JSONArray jSONArray0 = jSONObject0.getJSONArray("activeTrackIds");
            int v1 = jSONArray0.length();
            arr_v = new long[v1];
            for(int v2 = 0; v2 < v1; ++v2) {
                arr_v[v2] = jSONArray0.getLong(v2);
            }
            if(this.zzh != null && this.zzh.length == v1) {
                int v3 = 0;
                while(v3 < v1) {
                    if(this.zzh[v3] != arr_v[v3]) {
                        goto label_46;
                    }
                    ++v3;
                }
                goto label_49;
            }
        label_46:
            z = true;
        }
        else {
            arr_v = null;
        }
    label_49:
        if(z) {
            this.zzh = arr_v;
            z1 = true;
        }
        if(jSONObject0.has("customData")) {
            this.zzi = jSONObject0.getJSONObject("customData");
            return true;
        }
        return z1;
    }

    public long[] getActiveTrackIds() {
        return this.zzh;
    }

    public boolean getAutoplay() {
        return this.zzd;
    }

    public JSONObject getCustomData() {
        return this.zzi;
    }

    public int getItemId() {
        return this.zzc;
    }

    public MediaInfo getMedia() {
        return this.zzb;
    }

    public double getPlaybackDuration() {
        return this.zzf;
    }

    public double getPreloadTime() {
        return this.zzg;
    }

    public double getStartTime() {
        return this.zze;
    }

    @KeepForSdk
    public Writer getWriter() {
        return this.zzj;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, this.zzc, Boolean.valueOf(this.zzd), this.zze, this.zzf, this.zzg, Arrays.hashCode(this.zzh), String.valueOf(this.zzi)});
    }

    @KeepForSdk
    public JSONObject toJson() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            MediaInfo mediaInfo0 = this.zzb;
            if(mediaInfo0 != null) {
                jSONObject0.put("media", mediaInfo0.zza());
            }
            int v = this.zzc;
            if(v != 0) {
                jSONObject0.put("itemId", v);
            }
            jSONObject0.put("autoplay", this.zzd);
            if(!Double.isNaN(this.zze)) {
                jSONObject0.put("startTime", this.zze);
            }
            double f = this.zzf;
            if(f != Infinity) {
                jSONObject0.put("playbackDuration", f);
            }
            jSONObject0.put("preloadTime", this.zzg);
            if(this.zzh != null) {
                JSONArray jSONArray0 = new JSONArray();
                long[] arr_v = this.zzh;
                for(int v1 = 0; v1 < arr_v.length; ++v1) {
                    jSONArray0.put(arr_v[v1]);
                }
                jSONObject0.put("activeTrackIds", jSONArray0);
            }
            JSONObject jSONObject1 = this.zzi;
            if(jSONObject1 != null) {
                jSONObject0.put("customData", jSONObject1);
            }
        }
        catch(JSONException unused_ex) {
        }
        return jSONObject0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        this.zza = this.zzi == null ? null : this.zzi.toString();
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.getMedia(), v, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.getItemId());
        SafeParcelWriter.writeBoolean(parcel0, 4, this.getAutoplay());
        SafeParcelWriter.writeDouble(parcel0, 5, this.getStartTime());
        SafeParcelWriter.writeDouble(parcel0, 6, this.getPlaybackDuration());
        SafeParcelWriter.writeDouble(parcel0, 7, this.getPreloadTime());
        SafeParcelWriter.writeLongArray(parcel0, 8, this.getActiveTrackIds(), false);
        SafeParcelWriter.writeString(parcel0, 9, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final void zzi() {
        if(this.zzb == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        if(!Double.isNaN(this.zze) && this.zze < 0.0) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        if(Double.isNaN(this.zzf)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        if(Double.isNaN(this.zzg) || this.zzg < 0.0) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
    }
}

