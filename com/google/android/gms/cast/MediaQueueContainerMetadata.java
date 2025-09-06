package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.media.zza;
import com.google.android.gms.common.internal.Objects;
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

@Class(creator = "MediaQueueContainerMetadataCreator")
@Reserved({1})
public class MediaQueueContainerMetadata extends AbstractSafeParcelable {
    public static class Builder {
        private final MediaQueueContainerMetadata zza;

        public Builder() {
            this.zza = new MediaQueueContainerMetadata(null);
        }

        public MediaQueueContainerMetadata build() {
            return new MediaQueueContainerMetadata(this.zza, null);
        }

        public Builder setContainerDuration(double f) {
            this.zza.zze = f;
            return this;
        }

        public Builder setContainerImages(List list0) {
            MediaQueueContainerMetadata.zzd(this.zza, list0);
            return this;
        }

        public Builder setContainerType(int v) {
            this.zza.zza = v;
            return this;
        }

        public Builder setSections(List list0) {
            this.zza.zzg(list0);
            return this;
        }

        public Builder setTitle(String s) {
            this.zza.zzb = s;
            return this;
        }

        public final Builder zza(JSONObject jSONObject0) {
            MediaQueueContainerMetadata.zzb(this.zza, jSONObject0);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaQueueContainerType {
    }

    public static final Parcelable.Creator CREATOR = null;
    public static final int MEDIA_QUEUE_CONTAINER_TYPE_AUDIO_BOOK = 1;
    public static final int MEDIA_QUEUE_CONTAINER_TYPE_GENERIC;
    @Field(getter = "getContainerType", id = 2)
    private int zza;
    @Field(getter = "getTitle", id = 3)
    private String zzb;
    @Field(getter = "getSections", id = 4)
    private List zzc;
    @Field(getter = "getContainerImages", id = 5)
    private List zzd;
    @Field(getter = "getContainerDuration", id = 6)
    private double zze;

    static {
        MediaQueueContainerMetadata.CREATOR = new zzce();
    }

    private MediaQueueContainerMetadata() {
        throw null;
    }

    @Constructor
    public MediaQueueContainerMetadata(@Param(id = 2) int v, @Param(id = 3) String s, @Param(id = 4) List list0, @Param(id = 5) List list1, @Param(id = 6) double f) {
        this.zza = v;
        this.zzb = s;
        this.zzc = list0;
        this.zzd = list1;
        this.zze = f;
    }

    public MediaQueueContainerMetadata(MediaQueueContainerMetadata mediaQueueContainerMetadata0, zzcd zzcd0) {
        this.zza = mediaQueueContainerMetadata0.zza;
        this.zzb = mediaQueueContainerMetadata0.zzb;
        this.zzc = mediaQueueContainerMetadata0.zzc;
        this.zzd = mediaQueueContainerMetadata0.zzd;
        this.zze = mediaQueueContainerMetadata0.zze;
    }

    public MediaQueueContainerMetadata(zzcd zzcd0) {
        this.zzh();
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof MediaQueueContainerMetadata ? this.zza == ((MediaQueueContainerMetadata)object0).zza && TextUtils.equals(this.zzb, ((MediaQueueContainerMetadata)object0).zzb) && Objects.equal(this.zzc, ((MediaQueueContainerMetadata)object0).zzc) && Objects.equal(this.zzd, ((MediaQueueContainerMetadata)object0).zzd) && this.zze == ((MediaQueueContainerMetadata)object0).zze : false;
    }

    public double getContainerDuration() {
        return this.zze;
    }

    public List getContainerImages() {
        return this.zzd == null ? null : Collections.unmodifiableList(this.zzd);
    }

    public int getContainerType() {
        return this.zza;
    }

    public List getSections() {
        return this.zzc == null ? null : Collections.unmodifiableList(this.zzc);
    }

    public String getTitle() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.getContainerType());
        SafeParcelWriter.writeString(parcel0, 3, this.getTitle(), false);
        SafeParcelWriter.writeTypedList(parcel0, 4, this.getSections(), false);
        SafeParcelWriter.writeTypedList(parcel0, 5, this.getContainerImages(), false);
        SafeParcelWriter.writeDouble(parcel0, 6, this.getContainerDuration());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final JSONObject zza() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            switch(this.zza) {
                case 0: {
                    jSONObject0.put("containerType", "GENERIC_CONTAINER");
                    break;
                }
                case 1: {
                    jSONObject0.put("containerType", "AUDIOBOOK_CONTAINER");
                }
            }
            if(!TextUtils.isEmpty(this.zzb)) {
                jSONObject0.put("title", this.zzb);
            }
            if(this.zzc != null && !this.zzc.isEmpty()) {
                JSONArray jSONArray0 = new JSONArray();
                for(Object object0: this.zzc) {
                    jSONArray0.put(((MediaMetadata)object0).zza());
                }
                jSONObject0.put("sections", jSONArray0);
            }
            if(this.zzd != null && !this.zzd.isEmpty()) {
                jSONObject0.put("containerImages", zza.zzc(this.zzd));
            }
            jSONObject0.put("containerDuration", this.zze);
        }
        catch(JSONException unused_ex) {
        }
        return jSONObject0;
    }

    public static void zzb(MediaQueueContainerMetadata mediaQueueContainerMetadata0, JSONObject jSONObject0) {
        mediaQueueContainerMetadata0.zzh();
        switch(jSONObject0.optString("containerType", "")) {
            case "AUDIOBOOK_CONTAINER": {
                mediaQueueContainerMetadata0.zza = 1;
                break;
            }
            case "GENERIC_CONTAINER": {
                mediaQueueContainerMetadata0.zza = 0;
            }
        }
        mediaQueueContainerMetadata0.zzb = CastUtils.optStringOrNull(jSONObject0, "title");
        JSONArray jSONArray0 = jSONObject0.optJSONArray("sections");
        if(jSONArray0 != null) {
            ArrayList arrayList0 = new ArrayList();
            mediaQueueContainerMetadata0.zzc = arrayList0;
            for(int v = 0; v < jSONArray0.length(); ++v) {
                JSONObject jSONObject1 = jSONArray0.optJSONObject(v);
                if(jSONObject1 != null) {
                    MediaMetadata mediaMetadata0 = new MediaMetadata();
                    mediaMetadata0.zzc(jSONObject1);
                    arrayList0.add(mediaMetadata0);
                }
            }
        }
        JSONArray jSONArray1 = jSONObject0.optJSONArray("containerImages");
        if(jSONArray1 != null) {
            ArrayList arrayList1 = new ArrayList();
            mediaQueueContainerMetadata0.zzd = arrayList1;
            zza.zzd(arrayList1, jSONArray1);
        }
        mediaQueueContainerMetadata0.zze = jSONObject0.optDouble("containerDuration", mediaQueueContainerMetadata0.zze);
    }

    public static void zzd(MediaQueueContainerMetadata mediaQueueContainerMetadata0, List list0) {
        mediaQueueContainerMetadata0.zzd = list0 == null ? null : new ArrayList(list0);
    }

    public final void zzg(List list0) {
        this.zzc = list0 == null ? null : new ArrayList(list0);
    }

    private final void zzh() {
        this.zza = 0;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = 0.0;
    }
}

