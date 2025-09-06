package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "MediaQueueDataCreator")
@Reserved({1})
public class MediaQueueData extends AbstractSafeParcelable {
    public static class Builder {
        private final MediaQueueData zza;

        public Builder() {
            this.zza = new MediaQueueData(null);
        }

        @KeepForSdk
        public Builder(MediaQueueData mediaQueueData0) {
            this.zza = new MediaQueueData(mediaQueueData0, null);
        }

        public MediaQueueData build() {
            return new MediaQueueData(this.zza, null);
        }

        public Builder setContainerMetadata(MediaQueueContainerMetadata mediaQueueContainerMetadata0) {
            this.zza.zze = mediaQueueContainerMetadata0;
            return this;
        }

        public Builder setEntity(String s) {
            this.zza.zzb = s;
            return this;
        }

        public Builder setItems(List list0) {
            MediaQueueData.zze(this.zza, list0);
            return this;
        }

        public Builder setName(String s) {
            this.zza.zzd = s;
            return this;
        }

        public Builder setQueueId(String s) {
            this.zza.zza = s;
            return this;
        }

        public Builder setQueueType(int v) {
            this.zza.zzc = v;
            return this;
        }

        public Builder setRepeatMode(int v) {
            this.zza.setRepeatMode(v);
            return this;
        }

        public Builder setStartIndex(int v) {
            this.zza.zzh = v;
            return this;
        }

        public Builder setStartTime(long v) {
            this.zza.zzi = v;
            return this;
        }

        public final Builder zza(JSONObject jSONObject0) {
            MediaQueueData.zzb(this.zza, jSONObject0);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaQueueType {
    }

    public static final Parcelable.Creator CREATOR = null;
    public static final int MEDIA_QUEUE_TYPE_ALBUM = 1;
    public static final int MEDIA_QUEUE_TYPE_AUDIO_BOOK = 3;
    public static final int MEDIA_QUEUE_TYPE_GENERIC = 0;
    public static final int MEDIA_QUEUE_TYPE_LIVE_TV = 8;
    public static final int MEDIA_QUEUE_TYPE_MOVIE = 9;
    public static final int MEDIA_QUEUE_TYPE_PLAYLIST = 2;
    public static final int MEDIA_QUEUE_TYPE_PODCAST_SERIES = 5;
    public static final int MEDIA_QUEUE_TYPE_RADIO_STATION = 4;
    public static final int MEDIA_QUEUE_TYPE_TV_SERIES = 6;
    public static final int MEDIA_QUEUE_TYPE_VIDEO_PLAYLIST = 7;
    @Field(getter = "getQueueId", id = 2)
    private String zza;
    @Field(getter = "getEntity", id = 3)
    private String zzb;
    @Field(getter = "getQueueType", id = 4)
    private int zzc;
    @Field(getter = "getName", id = 5)
    private String zzd;
    @Field(getter = "getContainerMetadata", id = 6)
    private MediaQueueContainerMetadata zze;
    @Field(getter = "getRepeatMode", id = 7)
    private int zzf;
    @Field(getter = "getItems", id = 8)
    private List zzg;
    @Field(getter = "getStartIndex", id = 9)
    private int zzh;
    @Field(getter = "getStartTime", id = 10)
    private long zzi;
    @Field(getter = "getShuffle", id = 11)
    private boolean zzj;

    static {
        MediaQueueData.CREATOR = new zzcg();
    }

    private MediaQueueData() {
        throw null;
    }

    public MediaQueueData(MediaQueueData mediaQueueData0, zzcf zzcf0) {
        this.zza = mediaQueueData0.zza;
        this.zzb = mediaQueueData0.zzb;
        this.zzc = mediaQueueData0.zzc;
        this.zzd = mediaQueueData0.zzd;
        this.zze = mediaQueueData0.zze;
        this.zzf = mediaQueueData0.zzf;
        this.zzg = mediaQueueData0.zzg;
        this.zzh = mediaQueueData0.zzh;
        this.zzi = mediaQueueData0.zzi;
        this.zzj = mediaQueueData0.zzj;
    }

    public MediaQueueData(zzcf zzcf0) {
        this.zzl();
    }

    @Constructor
    public MediaQueueData(@Param(id = 2) String s, @Param(id = 3) String s1, @Param(id = 4) int v, @Param(id = 5) String s2, @Param(id = 6) MediaQueueContainerMetadata mediaQueueContainerMetadata0, @Param(id = 7) int v1, @Param(id = 8) List list0, @Param(id = 9) int v2, @Param(id = 10) long v3, @Param(id = 11) boolean z) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = v;
        this.zzd = s2;
        this.zze = mediaQueueContainerMetadata0;
        this.zzf = v1;
        this.zzg = list0;
        this.zzh = v2;
        this.zzi = v3;
        this.zzj = z;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof MediaQueueData ? TextUtils.equals(this.zza, ((MediaQueueData)object0).zza) && TextUtils.equals(this.zzb, ((MediaQueueData)object0).zzb) && this.zzc == ((MediaQueueData)object0).zzc && TextUtils.equals(this.zzd, ((MediaQueueData)object0).zzd) && Objects.equal(this.zze, ((MediaQueueData)object0).zze) && this.zzf == ((MediaQueueData)object0).zzf && Objects.equal(this.zzg, ((MediaQueueData)object0).zzg) && this.zzh == ((MediaQueueData)object0).zzh && this.zzi == ((MediaQueueData)object0).zzi && this.zzj == ((MediaQueueData)object0).zzj : false;
    }

    public MediaQueueContainerMetadata getContainerMetadata() {
        return this.zze;
    }

    public String getEntity() {
        return this.zzb;
    }

    public List getItems() {
        return this.zzg == null ? null : Collections.unmodifiableList(this.zzg);
    }

    public String getName() {
        return this.zzd;
    }

    public String getQueueId() {
        return this.zza;
    }

    public int getQueueType() {
        return this.zzc;
    }

    public int getRepeatMode() {
        return this.zzf;
    }

    public int getStartIndex() {
        return this.zzh;
    }

    public long getStartTime() {
        return this.zzi;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, Boolean.valueOf(this.zzj)});
    }

    @KeepForSdk
    public void setRepeatMode(int v) {
        this.zzf = v;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.getQueueId(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getEntity(), false);
        SafeParcelWriter.writeInt(parcel0, 4, this.getQueueType());
        SafeParcelWriter.writeString(parcel0, 5, this.getName(), false);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.getContainerMetadata(), v, false);
        SafeParcelWriter.writeInt(parcel0, 7, this.getRepeatMode());
        SafeParcelWriter.writeTypedList(parcel0, 8, this.getItems(), false);
        SafeParcelWriter.writeInt(parcel0, 9, this.getStartIndex());
        SafeParcelWriter.writeLong(parcel0, 10, this.getStartTime());
        SafeParcelWriter.writeBoolean(parcel0, 11, this.zzj);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final JSONObject zza() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            if(!TextUtils.isEmpty(this.zza)) {
                jSONObject0.put("id", this.zza);
            }
            if(!TextUtils.isEmpty(this.zzb)) {
                jSONObject0.put("entity", this.zzb);
            }
            switch(this.zzc) {
                case 1: {
                    jSONObject0.put("queueType", "ALBUM");
                    break;
                }
                case 2: {
                    jSONObject0.put("queueType", "PLAYLIST");
                    break;
                }
                case 3: {
                    jSONObject0.put("queueType", "AUDIOBOOK");
                    break;
                }
                case 4: {
                    jSONObject0.put("queueType", "RADIO_STATION");
                    break;
                }
                case 5: {
                    jSONObject0.put("queueType", "PODCAST_SERIES");
                    break;
                }
                case 6: {
                    jSONObject0.put("queueType", "TV_SERIES");
                    break;
                }
                case 7: {
                    jSONObject0.put("queueType", "VIDEO_PLAYLIST");
                    break;
                }
                case 8: {
                    jSONObject0.put("queueType", "LIVE_TV");
                    break;
                }
                case 9: {
                    jSONObject0.put("queueType", "MOVIE");
                }
            }
            if(!TextUtils.isEmpty(this.zzd)) {
                jSONObject0.put("name", this.zzd);
            }
            MediaQueueContainerMetadata mediaQueueContainerMetadata0 = this.zze;
            if(mediaQueueContainerMetadata0 != null) {
                jSONObject0.put("containerMetadata", mediaQueueContainerMetadata0.zza());
            }
            String s = MediaCommon.zza(this.zzf);
            if(s != null) {
                jSONObject0.put("repeatMode", s);
            }
            if(this.zzg != null && !this.zzg.isEmpty()) {
                JSONArray jSONArray0 = new JSONArray();
                for(Object object0: this.zzg) {
                    jSONArray0.put(((MediaQueueItem)object0).toJson());
                }
                jSONObject0.put("items", jSONArray0);
            }
            jSONObject0.put("startIndex", this.zzh);
            long v = this.zzi;
            if(v != -1L) {
                jSONObject0.put("startTime", ((double)v) / 1000.0);
            }
            jSONObject0.put("shuffle", this.zzj);
        }
        catch(JSONException unused_ex) {
        }
        return jSONObject0;
    }

    public static void zzb(MediaQueueData mediaQueueData0, JSONObject jSONObject0) {
        mediaQueueData0.zzl();
        if(jSONObject0 == null) {
            return;
        }
        mediaQueueData0.zza = CastUtils.optStringOrNull(jSONObject0, "id");
        mediaQueueData0.zzb = CastUtils.optStringOrNull(jSONObject0, "entity");
        switch(jSONObject0.optString("queueType")) {
            case "ALBUM": {
                mediaQueueData0.zzc = 1;
                break;
            }
            case "AUDIOBOOK": {
                mediaQueueData0.zzc = 3;
                break;
            }
            case "LIVE_TV": {
                mediaQueueData0.zzc = 8;
                break;
            }
            case "MOVIE": {
                mediaQueueData0.zzc = 9;
                break;
            }
            case "PLAYLIST": {
                mediaQueueData0.zzc = 2;
                break;
            }
            case "PODCAST_SERIES": {
                mediaQueueData0.zzc = 5;
                break;
            }
            case "RADIO_STATION": {
                mediaQueueData0.zzc = 4;
                break;
            }
            case "TV_SERIES": {
                mediaQueueData0.zzc = 6;
                break;
            }
            case "VIDEO_PLAYLIST": {
                mediaQueueData0.zzc = 7;
            }
        }
        mediaQueueData0.zzd = CastUtils.optStringOrNull(jSONObject0, "name");
        JSONObject jSONObject1 = jSONObject0.has("containerMetadata") ? jSONObject0.optJSONObject("containerMetadata") : null;
        if(jSONObject1 != null) {
            com.google.android.gms.cast.MediaQueueContainerMetadata.Builder mediaQueueContainerMetadata$Builder0 = new com.google.android.gms.cast.MediaQueueContainerMetadata.Builder();
            mediaQueueContainerMetadata$Builder0.zza(jSONObject1);
            mediaQueueData0.zze = mediaQueueContainerMetadata$Builder0.build();
        }
        Integer integer0 = MediaCommon.mediaRepeatModeFromString(jSONObject0.optString("repeatMode"));
        if(integer0 != null) {
            mediaQueueData0.zzf = (int)integer0;
        }
        JSONArray jSONArray0 = jSONObject0.optJSONArray("items");
        if(jSONArray0 != null) {
            ArrayList arrayList0 = new ArrayList();
            mediaQueueData0.zzg = arrayList0;
            for(int v = 0; v < jSONArray0.length(); ++v) {
                JSONObject jSONObject2 = jSONArray0.optJSONObject(v);
                if(jSONObject2 != null) {
                    try {
                        arrayList0.add(new MediaQueueItem(jSONObject2));
                    }
                    catch(JSONException unused_ex) {
                    }
                }
            }
        }
        mediaQueueData0.zzh = jSONObject0.optInt("startIndex", mediaQueueData0.zzh);
        if(jSONObject0.has("startTime")) {
            mediaQueueData0.zzi = CastUtils.secToMillisec(jSONObject0.optDouble("startTime", ((double)mediaQueueData0.zzi)));
        }
        mediaQueueData0.zzj = jSONObject0.optBoolean("shuffle");
    }

    public static void zze(MediaQueueData mediaQueueData0, List list0) {
        mediaQueueData0.zzg = list0 == null ? null : new ArrayList(list0);
    }

    @ShowFirstParty
    public final boolean zzk() {
        return this.zzj;
    }

    private final void zzl() {
        this.zza = null;
        this.zzb = null;
        this.zzc = 0;
        this.zzd = null;
        this.zzf = 0;
        this.zzg = null;
        this.zzh = 0;
        this.zzi = -1L;
        this.zzj = false;
    }
}

