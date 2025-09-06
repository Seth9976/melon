package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import android.view.accessibility.CaptioningManager;
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
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "TextTrackStyleCreator")
@Reserved({1})
public final class TextTrackStyle extends AbstractSafeParcelable {
    public static final int COLOR_UNSPECIFIED = 0;
    @KeepForSdk
    public static final Parcelable.Creator CREATOR = null;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    @Field(id = 13)
    String zza;
    @Field(getter = "getFontScale", id = 2)
    private float zzb;
    @Field(getter = "getForegroundColor", id = 3)
    private int zzc;
    @Field(getter = "getBackgroundColor", id = 4)
    private int zzd;
    @Field(getter = "getEdgeType", id = 5)
    private int zze;
    @Field(getter = "getEdgeColor", id = 6)
    private int zzf;
    @Field(getter = "getWindowType", id = 7)
    private int zzg;
    @Field(getter = "getWindowColor", id = 8)
    private int zzh;
    @Field(getter = "getWindowCornerRadius", id = 9)
    private int zzi;
    @Field(getter = "getFontFamily", id = 10)
    private String zzj;
    @Field(getter = "getFontGenericFamily", id = 11)
    private int zzk;
    @Field(getter = "getFontStyle", id = 12)
    private int zzl;
    private JSONObject zzm;

    static {
        TextTrackStyle.CREATOR = new zzdq();
    }

    public TextTrackStyle() {
        this(1.0f, 0, 0, -1, 0, -1, 0, 0, null, -1, -1, null);
    }

    @Constructor
    public TextTrackStyle(@Param(id = 2) float f, @Param(id = 3) int v, @Param(id = 4) int v1, @Param(id = 5) int v2, @Param(id = 6) int v3, @Param(id = 7) int v4, @Param(id = 8) int v5, @Param(id = 9) int v6, @Param(id = 10) String s, @Param(id = 11) int v7, @Param(id = 12) int v8, @Param(id = 13) String s1) {
        this.zzb = f;
        this.zzc = v;
        this.zzd = v1;
        this.zze = v2;
        this.zzf = v3;
        this.zzg = v4;
        this.zzh = v5;
        this.zzi = v6;
        this.zzj = s;
        this.zzk = v7;
        this.zzl = v8;
        this.zza = s1;
        if(s1 != null) {
            try {
                this.zzm = new JSONObject(this.zza);
            }
            catch(JSONException unused_ex) {
                this.zzm = null;
                this.zza = null;
            }
            return;
        }
        this.zzm = null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TextTrackStyle)) {
            return false;
        }
        JSONObject jSONObject0 = this.zzm;
        JSONObject jSONObject1 = ((TextTrackStyle)object0).zzm;
        if((jSONObject0 == null ? 1 : 0) != (jSONObject1 == null ? 1 : 0)) {
            return false;
        }
        return jSONObject0 == null || jSONObject1 == null || JsonUtils.areJsonValuesEquivalent(jSONObject0, jSONObject1) ? this.zzb == ((TextTrackStyle)object0).zzb && this.zzc == ((TextTrackStyle)object0).zzc && this.zzd == ((TextTrackStyle)object0).zzd && this.zze == ((TextTrackStyle)object0).zze && this.zzf == ((TextTrackStyle)object0).zzf && this.zzg == ((TextTrackStyle)object0).zzg && this.zzh == ((TextTrackStyle)object0).zzh && this.zzi == ((TextTrackStyle)object0).zzi && CastUtils.zze(this.zzj, ((TextTrackStyle)object0).zzj) && this.zzk == ((TextTrackStyle)object0).zzk && this.zzl == ((TextTrackStyle)object0).zzl : false;
    }

    @KeepForSdk
    public void fromJson(JSONObject jSONObject0) {
        this.zzb = (float)jSONObject0.optDouble("fontScale", 1.0);
        this.zzc = TextTrackStyle.zzb(jSONObject0.optString("foregroundColor"));
        this.zzd = TextTrackStyle.zzb(jSONObject0.optString("backgroundColor"));
        if(jSONObject0.has("edgeType")) {
            String s = jSONObject0.getString("edgeType");
            if("NONE".equals(s)) {
                this.zze = 0;
            }
            else if("OUTLINE".equals(s)) {
                this.zze = 1;
            }
            else if("DROP_SHADOW".equals(s)) {
                this.zze = 2;
            }
            else if("RAISED".equals(s)) {
                this.zze = 3;
            }
            else if("DEPRESSED".equals(s)) {
                this.zze = 4;
            }
        }
        this.zzf = TextTrackStyle.zzb(jSONObject0.optString("edgeColor"));
        if(jSONObject0.has("windowType")) {
            String s1 = jSONObject0.getString("windowType");
            if("NONE".equals(s1)) {
                this.zzg = 0;
            }
            else if("NORMAL".equals(s1)) {
                this.zzg = 1;
            }
            else if("ROUNDED_CORNERS".equals(s1)) {
                this.zzg = 2;
            }
        }
        this.zzh = TextTrackStyle.zzb(jSONObject0.optString("windowColor"));
        if(this.zzg == 2) {
            this.zzi = jSONObject0.optInt("windowRoundedCornerRadius", 0);
        }
        this.zzj = CastUtils.optStringOrNull(jSONObject0, "fontFamily");
        if(jSONObject0.has("fontGenericFamily")) {
            String s2 = jSONObject0.getString("fontGenericFamily");
            if("SANS_SERIF".equals(s2)) {
                this.zzk = 0;
            }
            else if("MONOSPACED_SANS_SERIF".equals(s2)) {
                this.zzk = 1;
            }
            else if("SERIF".equals(s2)) {
                this.zzk = 2;
            }
            else if("MONOSPACED_SERIF".equals(s2)) {
                this.zzk = 3;
            }
            else if("CASUAL".equals(s2)) {
                this.zzk = 4;
            }
            else if("CURSIVE".equals(s2)) {
                this.zzk = 5;
            }
            else if("SMALL_CAPITALS".equals(s2)) {
                this.zzk = 6;
            }
        }
        if(jSONObject0.has("fontStyle")) {
            String s3 = jSONObject0.getString("fontStyle");
            if("NORMAL".equals(s3)) {
                this.zzl = 0;
            }
            else if("BOLD".equals(s3)) {
                this.zzl = 1;
            }
            else if("ITALIC".equals(s3)) {
                this.zzl = 2;
            }
            else if("BOLD_ITALIC".equals(s3)) {
                this.zzl = 3;
            }
        }
        this.zzm = jSONObject0.optJSONObject("customData");
    }

    public static TextTrackStyle fromSystemSettings(Context context0) {
        TextTrackStyle textTrackStyle0 = new TextTrackStyle();
        CaptioningManager captioningManager0 = (CaptioningManager)context0.getSystemService("captioning");
        if(captioningManager0 != null) {
            textTrackStyle0.setFontScale(captioningManager0.getFontScale());
            CaptioningManager.CaptionStyle captioningManager$CaptionStyle0 = captioningManager0.getUserStyle();
            textTrackStyle0.setBackgroundColor(captioningManager$CaptionStyle0.backgroundColor);
            textTrackStyle0.setForegroundColor(captioningManager$CaptionStyle0.foregroundColor);
            switch(captioningManager$CaptionStyle0.edgeType) {
                case 1: {
                    textTrackStyle0.setEdgeType(1);
                    break;
                }
                case 2: {
                    textTrackStyle0.setEdgeType(2);
                    break;
                }
                default: {
                    textTrackStyle0.setEdgeType(0);
                }
            }
            textTrackStyle0.setEdgeColor(captioningManager$CaptionStyle0.edgeColor);
            Typeface typeface0 = captioningManager$CaptionStyle0.getTypeface();
            if(typeface0 != null) {
                if(Typeface.MONOSPACE.equals(typeface0)) {
                    textTrackStyle0.setFontGenericFamily(1);
                }
                else if(Typeface.SANS_SERIF.equals(typeface0)) {
                    textTrackStyle0.setFontGenericFamily(0);
                }
                else if(Typeface.SERIF.equals(typeface0)) {
                    textTrackStyle0.setFontGenericFamily(2);
                }
                else {
                    textTrackStyle0.setFontGenericFamily(0);
                }
                boolean z = typeface0.isBold();
                boolean z1 = typeface0.isItalic();
                if(z && z1) {
                    textTrackStyle0.setFontStyle(3);
                    return textTrackStyle0;
                }
                if(z) {
                    textTrackStyle0.setFontStyle(1);
                    return textTrackStyle0;
                }
                if(z1) {
                    textTrackStyle0.setFontStyle(2);
                    return textTrackStyle0;
                }
                textTrackStyle0.setFontStyle(0);
            }
        }
        return textTrackStyle0;
    }

    public int getBackgroundColor() {
        return this.zzd;
    }

    public JSONObject getCustomData() {
        return this.zzm;
    }

    public int getEdgeColor() {
        return this.zzf;
    }

    public int getEdgeType() {
        return this.zze;
    }

    public String getFontFamily() {
        return this.zzj;
    }

    public int getFontGenericFamily() {
        return this.zzk;
    }

    public float getFontScale() {
        return this.zzb;
    }

    public int getFontStyle() {
        return this.zzl;
    }

    public int getForegroundColor() {
        return this.zzc;
    }

    public int getWindowColor() {
        return this.zzh;
    }

    public int getWindowCornerRadius() {
        return this.zzi;
    }

    public int getWindowType() {
        return this.zzg;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, String.valueOf(this.zzm)});
    }

    public void setBackgroundColor(int v) {
        this.zzd = v;
    }

    public void setCustomData(JSONObject jSONObject0) {
        this.zzm = jSONObject0;
    }

    public void setEdgeColor(int v) {
        this.zzf = v;
    }

    public void setEdgeType(int v) {
        if(v < 0 || v > 4) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.zze = v;
    }

    public void setFontFamily(String s) {
        this.zzj = s;
    }

    public void setFontGenericFamily(int v) {
        if(v < 0 || v > 6) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.zzk = v;
    }

    public void setFontScale(float f) {
        this.zzb = f;
    }

    public void setFontStyle(int v) {
        if(v < 0 || v > 3) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.zzl = v;
    }

    public void setForegroundColor(int v) {
        this.zzc = v;
    }

    public void setWindowColor(int v) {
        this.zzh = v;
    }

    public void setWindowCornerRadius(int v) {
        if(v < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.zzi = v;
    }

    public void setWindowType(int v) {
        if(v < 0 || v > 2) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.zzg = v;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        this.zza = this.zzm == null ? null : this.zzm.toString();
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeFloat(parcel0, 2, this.getFontScale());
        SafeParcelWriter.writeInt(parcel0, 3, this.getForegroundColor());
        SafeParcelWriter.writeInt(parcel0, 4, this.getBackgroundColor());
        SafeParcelWriter.writeInt(parcel0, 5, this.getEdgeType());
        SafeParcelWriter.writeInt(parcel0, 6, this.getEdgeColor());
        SafeParcelWriter.writeInt(parcel0, 7, this.getWindowType());
        SafeParcelWriter.writeInt(parcel0, 8, this.getWindowColor());
        SafeParcelWriter.writeInt(parcel0, 9, this.getWindowCornerRadius());
        SafeParcelWriter.writeString(parcel0, 10, this.getFontFamily(), false);
        SafeParcelWriter.writeInt(parcel0, 11, this.getFontGenericFamily());
        SafeParcelWriter.writeInt(parcel0, 12, this.getFontStyle());
        SafeParcelWriter.writeString(parcel0, 13, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final JSONObject zza() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("fontScale", ((double)this.zzb));
            int v = this.zzc;
            if(v != 0) {
                jSONObject0.put("foregroundColor", TextTrackStyle.zzc(v));
            }
            int v1 = this.zzd;
            if(v1 != 0) {
                jSONObject0.put("backgroundColor", TextTrackStyle.zzc(v1));
            }
            int v2 = this.zze;
            switch(v2) {
                case 0: {
                    jSONObject0.put("edgeType", "NONE");
                    break;
                }
                case 1: {
                    jSONObject0.put("edgeType", "OUTLINE");
                    break;
                }
                case 2: {
                    jSONObject0.put("edgeType", "DROP_SHADOW");
                    break;
                }
                case 3: {
                    jSONObject0.put("edgeType", "RAISED");
                    break;
                }
                default: {
                    if(v2 == 4) {
                        jSONObject0.put("edgeType", "DEPRESSED");
                    }
                }
            }
            int v3 = this.zzf;
            if(v3 != 0) {
                jSONObject0.put("edgeColor", TextTrackStyle.zzc(v3));
            }
            switch(this.zzg) {
                case 0: {
                    jSONObject0.put("windowType", "NONE");
                    break;
                }
                case 1: {
                    jSONObject0.put("windowType", "NORMAL");
                    break;
                }
                case 2: {
                    jSONObject0.put("windowType", "ROUNDED_CORNERS");
                }
            }
            int v4 = this.zzh;
            if(v4 != 0) {
                jSONObject0.put("windowColor", TextTrackStyle.zzc(v4));
            }
            if(this.zzg == 2) {
                jSONObject0.put("windowRoundedCornerRadius", this.zzi);
            }
            String s = this.zzj;
            if(s != null) {
                jSONObject0.put("fontFamily", s);
            }
            switch(this.zzk) {
                case 0: {
                    jSONObject0.put("fontGenericFamily", "SANS_SERIF");
                    break;
                }
                case 1: {
                    jSONObject0.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                }
                case 2: {
                    jSONObject0.put("fontGenericFamily", "SERIF");
                    break;
                }
                case 3: {
                    jSONObject0.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                }
                case 4: {
                    jSONObject0.put("fontGenericFamily", "CASUAL");
                    break;
                }
                case 5: {
                    jSONObject0.put("fontGenericFamily", "CURSIVE");
                    break;
                }
                case 6: {
                    jSONObject0.put("fontGenericFamily", "SMALL_CAPITALS");
                }
            }
            switch(this.zzl) {
                case 0: {
                    jSONObject0.put("fontStyle", "NORMAL");
                    break;
                }
                case 1: {
                    jSONObject0.put("fontStyle", "BOLD");
                    break;
                }
                case 2: {
                    jSONObject0.put("fontStyle", "ITALIC");
                    break;
                }
                case 3: {
                    jSONObject0.put("fontStyle", "BOLD_ITALIC");
                }
            }
            JSONObject jSONObject1 = this.zzm;
            if(jSONObject1 != null) {
                jSONObject0.put("customData", jSONObject1);
            }
        }
        catch(JSONException unused_ex) {
        }
        return jSONObject0;
    }

    private static final int zzb(String s) {
        if(s != null && s.length() == 9 && s.charAt(0) == 35) {
            try {
                int v = Integer.parseInt(s.substring(1, 3), 16);
                int v1 = Integer.parseInt(s.substring(3, 5), 16);
                int v2 = Integer.parseInt(s.substring(5, 7), 16);
                return Color.argb(Integer.parseInt(s.substring(7, 9), 16), v, v1, v2);
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        return 0;
    }

    private static final String zzc(int v) {
        return String.format("#%02X%02X%02X%02X", Color.red(v), Color.green(v), Color.blue(v), Color.alpha(v));
    }
}

