package com.facebook.gamingservices.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001D\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000B\u0010\t\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\n\u001A\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000B\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001A\u00020\u0012J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateMedia;", "", "gif", "Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;", "video", "(Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;)V", "getGif", "()Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;", "getVideo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CustomUpdateMedia {
    @Nullable
    private final CustomUpdateMediaInfo gif;
    @Nullable
    private final CustomUpdateMediaInfo video;

    public CustomUpdateMedia() {
        this(null, null, 3, null);
    }

    public CustomUpdateMedia(@Nullable CustomUpdateMediaInfo customUpdateMediaInfo0, @Nullable CustomUpdateMediaInfo customUpdateMediaInfo1) {
        this.gif = customUpdateMediaInfo0;
        this.video = customUpdateMediaInfo1;
    }

    public CustomUpdateMedia(CustomUpdateMediaInfo customUpdateMediaInfo0, CustomUpdateMediaInfo customUpdateMediaInfo1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            customUpdateMediaInfo0 = null;
        }
        if((v & 2) != 0) {
            customUpdateMediaInfo1 = null;
        }
        this(customUpdateMediaInfo0, customUpdateMediaInfo1);
    }

    @Nullable
    public final CustomUpdateMediaInfo component1() {
        return this.gif;
    }

    @Nullable
    public final CustomUpdateMediaInfo component2() {
        return this.video;
    }

    @NotNull
    public final CustomUpdateMedia copy(@Nullable CustomUpdateMediaInfo customUpdateMediaInfo0, @Nullable CustomUpdateMediaInfo customUpdateMediaInfo1) {
        return new CustomUpdateMedia(customUpdateMediaInfo0, customUpdateMediaInfo1);
    }

    public static CustomUpdateMedia copy$default(CustomUpdateMedia customUpdateMedia0, CustomUpdateMediaInfo customUpdateMediaInfo0, CustomUpdateMediaInfo customUpdateMediaInfo1, int v, Object object0) {
        if((v & 1) != 0) {
            customUpdateMediaInfo0 = customUpdateMedia0.gif;
        }
        if((v & 2) != 0) {
            customUpdateMediaInfo1 = customUpdateMedia0.video;
        }
        return customUpdateMedia0.copy(customUpdateMediaInfo0, customUpdateMediaInfo1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CustomUpdateMedia)) {
            return false;
        }
        return q.b(this.gif, ((CustomUpdateMedia)object0).gif) ? q.b(this.video, ((CustomUpdateMedia)object0).video) : false;
    }

    @Nullable
    public final CustomUpdateMediaInfo getGif() {
        return this.gif;
    }

    @Nullable
    public final CustomUpdateMediaInfo getVideo() {
        return this.video;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.gif == null ? 0 : this.gif.hashCode();
        CustomUpdateMediaInfo customUpdateMediaInfo0 = this.video;
        if(customUpdateMediaInfo0 != null) {
            v = customUpdateMediaInfo0.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @NotNull
    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject();
        CustomUpdateMediaInfo customUpdateMediaInfo0 = this.gif;
        if(customUpdateMediaInfo0 != null) {
            JSONObject jSONObject1 = new JSONObject();
            jSONObject1.put("url", customUpdateMediaInfo0.getUrl());
            jSONObject0.put("gif", jSONObject1);
        }
        CustomUpdateMediaInfo customUpdateMediaInfo1 = this.video;
        if(customUpdateMediaInfo1 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("url", customUpdateMediaInfo1.getUrl());
            jSONObject0.put("video", jSONObject2);
        }
        return jSONObject0;
    }

    @Override
    @NotNull
    public String toString() {
        return "CustomUpdateMedia(gif=" + this.gif + ", video=" + this.video + ')';
    }
}

