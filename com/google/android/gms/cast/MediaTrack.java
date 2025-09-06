package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.internal.cast.zzhg;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "MediaTrackCreator")
@Reserved({1})
public final class MediaTrack extends AbstractSafeParcelable implements ReflectedParcelable {
    public static class Builder {
        private final long zza;
        private final int zzb;
        private String zzc;
        private String zzd;
        private String zze;
        private String zzf;
        private int zzg;
        private List zzh;
        private JSONObject zzi;

        public Builder(long v, int v1) {
            this.zzg = 0;
            this.zza = v;
            this.zzb = v1;
        }

        public MediaTrack build() {
            return new MediaTrack(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
        }

        public Builder setContentId(String s) {
            this.zzc = s;
            return this;
        }

        public Builder setContentType(String s) {
            this.zzd = s;
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject0) {
            this.zzi = jSONObject0;
            return this;
        }

        public Builder setLanguage(String s) {
            this.zzf = s;
            return this;
        }

        public Builder setLanguage(Locale locale0) {
            this.zzf = CastUtils.zzb(locale0);
            return this;
        }

        public Builder setName(String s) {
            this.zze = s;
            return this;
        }

        public Builder setRoles(List list0) {
            if(list0 != null) {
                list0 = zzhg.zzj(list0);
            }
            this.zzh = list0;
            return this;
        }

        public Builder setSubtype(int v) {
            if(v < -1 || v > 5) {
                throw new IllegalArgumentException("invalid subtype " + v);
            }
            if(v != 0 && this.zzb != 1) {
                throw new IllegalArgumentException("subtypes are only valid for text tracks");
            }
            this.zzg = v;
            return this;
        }
    }

    @KeepForSdk
    public static final Parcelable.Creator CREATOR = null;
    public static final String ROLE_ALTERNATE = "alternate";
    public static final String ROLE_CAPTION = "caption";
    public static final String ROLE_COMMENTARY = "commentary";
    public static final String ROLE_DESCRIPTION = "description";
    public static final String ROLE_DUB = "dub";
    public static final String ROLE_EMERGENCY = "emergency";
    public static final String ROLE_FORCED_SUBTITLE = "forced_subtitle";
    public static final String ROLE_MAIN = "main";
    public static final String ROLE_SIGN = "sign";
    public static final String ROLE_SUBTITLE = "subtitle";
    public static final String ROLE_SUPPLEMENTARY = "supplementary";
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    @Field(id = 10)
    String zza;
    @Field(getter = "getId", id = 2)
    private final long zzb;
    @Field(getter = "getType", id = 3)
    private final int zzc;
    @Field(getter = "getContentId", id = 4)
    private String zzd;
    @Field(getter = "getContentType", id = 5)
    private String zze;
    @Field(getter = "getName", id = 6)
    private final String zzf;
    @Field(getter = "getLanguage", id = 7)
    private final String zzg;
    @Field(getter = "getSubtype", id = 8)
    private final int zzh;
    @Field(getter = "getRoles", id = 9)
    private final List zzi;
    private final JSONObject zzj;

    static {
        MediaTrack.CREATOR = new zzcl();
    }

    public MediaTrack(long v, int v1, String s, String s1, String s2, String s3, int v2, List list0, JSONObject jSONObject0) {
        this.zzb = v;
        this.zzc = v1;
        this.zzd = s;
        this.zze = s1;
        this.zzf = s2;
        this.zzg = s3;
        this.zzh = v2;
        this.zzi = list0;
        this.zzj = jSONObject0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MediaTrack)) {
            return false;
        }
        JSONObject jSONObject0 = this.zzj;
        JSONObject jSONObject1 = ((MediaTrack)object0).zzj;
        if((jSONObject0 == null ? 1 : 0) != (jSONObject1 == null ? 1 : 0)) {
            return false;
        }
        return jSONObject0 == null || jSONObject1 == null || JsonUtils.areJsonValuesEquivalent(jSONObject0, jSONObject1) ? this.zzb == ((MediaTrack)object0).zzb && this.zzc == ((MediaTrack)object0).zzc && CastUtils.zze(this.zzd, ((MediaTrack)object0).zzd) && CastUtils.zze(this.zze, ((MediaTrack)object0).zze) && CastUtils.zze(this.zzf, ((MediaTrack)object0).zzf) && CastUtils.zze(this.zzg, ((MediaTrack)object0).zzg) && this.zzh == ((MediaTrack)object0).zzh && CastUtils.zze(this.zzi, ((MediaTrack)object0).zzi) : false;
    }

    public String getContentId() {
        return this.zzd;
    }

    public String getContentType() {
        return this.zze;
    }

    public JSONObject getCustomData() {
        return this.zzj;
    }

    public long getId() {
        return this.zzb;
    }

    public String getLanguage() {
        return this.zzg;
    }

    // 去混淆评级： 低(20)
    @TargetApi(21)
    public Locale getLanguageLocale() {
        return TextUtils.isEmpty(this.zzg) ? null : Locale.forLanguageTag(this.zzg);
    }

    public String getName() {
        return this.zzf;
    }

    public List getRoles() {
        return this.zzi;
    }

    public int getSubtype() {
        return this.zzh;
    }

    public int getType() {
        return this.zzc;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, String.valueOf(this.zzj)});
    }

    public void setContentId(String s) {
        this.zzd = s;
    }

    public void setContentType(String s) {
        this.zze = s;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        this.zza = this.zzj == null ? null : this.zzj.toString();
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 2, this.getId());
        SafeParcelWriter.writeInt(parcel0, 3, this.getType());
        SafeParcelWriter.writeString(parcel0, 4, this.getContentId(), false);
        SafeParcelWriter.writeString(parcel0, 5, this.getContentType(), false);
        SafeParcelWriter.writeString(parcel0, 6, this.getName(), false);
        SafeParcelWriter.writeString(parcel0, 7, this.getLanguage(), false);
        SafeParcelWriter.writeInt(parcel0, 8, this.getSubtype());
        SafeParcelWriter.writeStringList(parcel0, 9, this.getRoles(), false);
        SafeParcelWriter.writeString(parcel0, 10, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final JSONObject zza() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("trackId", this.zzb);
            switch(this.zzc) {
                case 1: {
                    jSONObject0.put("type", "TEXT");
                    break;
                }
                case 2: {
                    jSONObject0.put("type", "AUDIO");
                    break;
                }
                case 3: {
                    jSONObject0.put("type", "VIDEO");
                }
            }
            String s = this.zzd;
            if(s != null) {
                jSONObject0.put("trackContentId", s);
            }
            String s1 = this.zze;
            if(s1 != null) {
                jSONObject0.put("trackContentType", s1);
            }
            String s2 = this.zzf;
            if(s2 != null) {
                jSONObject0.put("name", s2);
            }
            String s3 = this.zzg;
            if(!TextUtils.isEmpty(s3)) {
                jSONObject0.put("language", s3);
            }
            switch(this.zzh) {
                case 1: {
                    jSONObject0.put("subtype", "SUBTITLES");
                    break;
                }
                case 2: {
                    jSONObject0.put("subtype", "CAPTIONS");
                    break;
                }
                case 3: {
                    jSONObject0.put("subtype", "DESCRIPTIONS");
                    break;
                }
                case 4: {
                    jSONObject0.put("subtype", "CHAPTERS");
                    break;
                }
                case 5: {
                    jSONObject0.put("subtype", "METADATA");
                }
            }
            List list0 = this.zzi;
            if(list0 != null) {
                jSONObject0.put("roles", new JSONArray(list0));
            }
            JSONObject jSONObject1 = this.zzj;
            if(jSONObject1 != null) {
                jSONObject0.put("customData", jSONObject1);
            }
        }
        catch(JSONException unused_ex) {
        }
        return jSONObject0;
    }
}

