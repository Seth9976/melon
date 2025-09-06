package com.facebook.gamingservices.model;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.util.Base64;
import com.facebook.gamingservices.GamingContext;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017BG\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000BJ\u0006\u0010\u0015\u001A\u00020\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\n\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u000F¨\u0006\u0018"}, d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateContent;", "", "contextTokenId", "", "text", "Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;", "cta", "image", "media", "Lcom/facebook/gamingservices/model/CustomUpdateMedia;", "data", "(Ljava/lang/String;Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;Ljava/lang/String;Lcom/facebook/gamingservices/model/CustomUpdateMedia;Ljava/lang/String;)V", "getContextTokenId", "()Ljava/lang/String;", "getCta", "()Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;", "getData", "getImage", "getMedia", "()Lcom/facebook/gamingservices/model/CustomUpdateMedia;", "getText", "toGraphRequestContent", "Lorg/json/JSONObject;", "Builder", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CustomUpdateContent {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bB\u001F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0002\u0010\u000BB-\b\u0002\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000EJ\u0014\u0010\u0016\u001A\u0004\u0018\u00010\r2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0007H\u0002J\u0006\u0010\u0018\u001A\u00020\u0019J\u000E\u0010\u001A\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u0005J\u000E\u0010\u001B\u001A\u00020\u00002\u0006\u0010\u0013\u001A\u00020\rR\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001A\u0004\u0018\u00010\u00052\b\u0010\u000F\u001A\u0004\u0018\u00010\u0005@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001A\u0004\u0018\u00010\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\r@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateContent$Builder;", "", "contextToken", "Lcom/facebook/gamingservices/GamingContext;", "text", "Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;", "image", "Landroid/graphics/Bitmap;", "(Lcom/facebook/gamingservices/GamingContext;Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;Landroid/graphics/Bitmap;)V", "media", "Lcom/facebook/gamingservices/model/CustomUpdateMedia;", "(Lcom/facebook/gamingservices/GamingContext;Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;Lcom/facebook/gamingservices/model/CustomUpdateMedia;)V", "contextTokenId", "", "(Ljava/lang/String;Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;Landroid/graphics/Bitmap;Lcom/facebook/gamingservices/model/CustomUpdateMedia;)V", "<set-?>", "cta", "getCta", "()Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;", "data", "getData", "()Ljava/lang/String;", "bitmapToBase64String", "bitmap", "build", "Lcom/facebook/gamingservices/model/CustomUpdateContent;", "setCta", "setData", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder {
        @Nullable
        private final String contextTokenId;
        @Nullable
        private CustomUpdateLocalizedText cta;
        @Nullable
        private String data;
        @Nullable
        private final Bitmap image;
        @Nullable
        private final CustomUpdateMedia media;
        @NotNull
        private final CustomUpdateLocalizedText text;

        public Builder(@NotNull GamingContext gamingContext0, @NotNull CustomUpdateLocalizedText customUpdateLocalizedText0, @NotNull Bitmap bitmap0) {
            q.g(gamingContext0, "contextToken");
            q.g(customUpdateLocalizedText0, "text");
            q.g(bitmap0, "image");
            this(gamingContext0.getContextID(), customUpdateLocalizedText0, bitmap0, null);
        }

        public Builder(@NotNull GamingContext gamingContext0, @NotNull CustomUpdateLocalizedText customUpdateLocalizedText0, @NotNull CustomUpdateMedia customUpdateMedia0) {
            q.g(gamingContext0, "contextToken");
            q.g(customUpdateLocalizedText0, "text");
            q.g(customUpdateMedia0, "media");
            this(gamingContext0.getContextID(), customUpdateLocalizedText0, null, customUpdateMedia0);
        }

        private Builder(String s, CustomUpdateLocalizedText customUpdateLocalizedText0, Bitmap bitmap0, CustomUpdateMedia customUpdateMedia0) {
            this.contextTokenId = s;
            this.text = customUpdateLocalizedText0;
            this.image = bitmap0;
            this.media = customUpdateMedia0;
        }

        private final String bitmapToBase64String(Bitmap bitmap0) {
            if(bitmap0 == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
            bitmap0.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream0);
            return "data:image/png;base64," + Base64.encodeToString(byteArrayOutputStream0.toByteArray(), 2);
        }

        @NotNull
        public final CustomUpdateContent build() {
            int v = 0;
            CustomUpdateMedia customUpdateMedia0 = this.media;
            if(customUpdateMedia0 != null) {
                int v1 = customUpdateMedia0.getGif() == null ? 0 : 1;
                if(this.media.getVideo() != null) {
                    v = 1;
                }
                if((v1 ^ v) == 0) {
                    throw new IllegalArgumentException("Invalid CustomUpdateMedia, please set either gif or video");
                }
            }
            String s = this.bitmapToBase64String(this.image);
            String s1 = this.contextTokenId;
            if(s1 == null) {
                throw new IllegalArgumentException("parameter contextToken must not be null");
            }
            return new CustomUpdateContent(s1, this.text, this.cta, s, this.media, this.data, null);
        }

        @Nullable
        public final CustomUpdateLocalizedText getCta() {
            return this.cta;
        }

        @Nullable
        public final String getData() {
            return this.data;
        }

        @NotNull
        public final Builder setCta(@NotNull CustomUpdateLocalizedText customUpdateLocalizedText0) {
            q.g(customUpdateLocalizedText0, "cta");
            this.cta = customUpdateLocalizedText0;
            return this;
        }

        @NotNull
        public final Builder setData(@NotNull String s) {
            q.g(s, "data");
            this.data = s;
            return this;
        }
    }

    @NotNull
    private final String contextTokenId;
    @Nullable
    private final CustomUpdateLocalizedText cta;
    @Nullable
    private final String data;
    @Nullable
    private final String image;
    @Nullable
    private final CustomUpdateMedia media;
    @NotNull
    private final CustomUpdateLocalizedText text;

    private CustomUpdateContent(String s, CustomUpdateLocalizedText customUpdateLocalizedText0, CustomUpdateLocalizedText customUpdateLocalizedText1, String s1, CustomUpdateMedia customUpdateMedia0, String s2) {
        this.contextTokenId = s;
        this.text = customUpdateLocalizedText0;
        this.cta = customUpdateLocalizedText1;
        this.image = s1;
        this.media = customUpdateMedia0;
        this.data = s2;
    }

    public CustomUpdateContent(String s, CustomUpdateLocalizedText customUpdateLocalizedText0, CustomUpdateLocalizedText customUpdateLocalizedText1, String s1, CustomUpdateMedia customUpdateMedia0, String s2, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            customUpdateLocalizedText1 = null;
        }
        if((v & 8) != 0) {
            s1 = null;
        }
        if((v & 16) != 0) {
            customUpdateMedia0 = null;
        }
        this(s, customUpdateLocalizedText0, customUpdateLocalizedText1, s1, customUpdateMedia0, ((v & 0x20) == 0 ? s2 : null));
    }

    public CustomUpdateContent(String s, CustomUpdateLocalizedText customUpdateLocalizedText0, CustomUpdateLocalizedText customUpdateLocalizedText1, String s1, CustomUpdateMedia customUpdateMedia0, String s2, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, customUpdateLocalizedText0, customUpdateLocalizedText1, s1, customUpdateMedia0, s2);
    }

    @NotNull
    public final String getContextTokenId() {
        return this.contextTokenId;
    }

    @Nullable
    public final CustomUpdateLocalizedText getCta() {
        return this.cta;
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final CustomUpdateMedia getMedia() {
        return this.media;
    }

    @NotNull
    public final CustomUpdateLocalizedText getText() {
        return this.text;
    }

    @NotNull
    public final JSONObject toGraphRequestContent() {
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("context_token_id", this.contextTokenId);
        jSONObject0.put("text", this.text.toJSONObject().toString());
        CustomUpdateLocalizedText customUpdateLocalizedText0 = this.cta;
        if(customUpdateLocalizedText0 != null) {
            jSONObject0.put("cta", customUpdateLocalizedText0.toJSONObject().toString());
        }
        String s = this.image;
        if(s != null) {
            jSONObject0.put("image", s);
        }
        CustomUpdateMedia customUpdateMedia0 = this.media;
        if(customUpdateMedia0 != null) {
            jSONObject0.put("media", customUpdateMedia0.toJSONObject().toString());
        }
        String s1 = this.data;
        if(s1 != null) {
            jSONObject0.put("data", s1);
        }
        return jSONObject0;
    }
}

