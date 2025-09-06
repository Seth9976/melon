package com.facebook.gamingservices.model;

import java.util.HashMap;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u0017\u0010\f\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J+\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0016\b\u0002\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001A\u00020\u0014J\t\u0010\u0015\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u001F\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;", "", "default", "", "localizations", "Ljava/util/HashMap;", "(Ljava/lang/String;Ljava/util/HashMap;)V", "getDefault", "()Ljava/lang/String;", "getLocalizations", "()Ljava/util/HashMap;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CustomUpdateLocalizedText {
    @NotNull
    private final String default;
    @Nullable
    private final HashMap localizations;

    public CustomUpdateLocalizedText(@NotNull String s, @Nullable HashMap hashMap0) {
        q.g(s, "default");
        super();
        this.default = s;
        this.localizations = hashMap0;
    }

    public CustomUpdateLocalizedText(String s, HashMap hashMap0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            hashMap0 = null;
        }
        this(s, hashMap0);
    }

    @NotNull
    public final String component1() {
        return this.default;
    }

    @Nullable
    public final HashMap component2() {
        return this.localizations;
    }

    @NotNull
    public final CustomUpdateLocalizedText copy(@NotNull String s, @Nullable HashMap hashMap0) {
        q.g(s, "default");
        return new CustomUpdateLocalizedText(s, hashMap0);
    }

    public static CustomUpdateLocalizedText copy$default(CustomUpdateLocalizedText customUpdateLocalizedText0, String s, HashMap hashMap0, int v, Object object0) {
        if((v & 1) != 0) {
            s = customUpdateLocalizedText0.default;
        }
        if((v & 2) != 0) {
            hashMap0 = customUpdateLocalizedText0.localizations;
        }
        return customUpdateLocalizedText0.copy(s, hashMap0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CustomUpdateLocalizedText)) {
            return false;
        }
        return q.b(this.default, ((CustomUpdateLocalizedText)object0).default) ? q.b(this.localizations, ((CustomUpdateLocalizedText)object0).localizations) : false;
    }

    @NotNull
    public final String getDefault() {
        return this.default;
    }

    @Nullable
    public final HashMap getLocalizations() {
        return this.localizations;
    }

    @Override
    public int hashCode() {
        int v = this.default.hashCode();
        return this.localizations == null ? v * 0x1F : v * 0x1F + this.localizations.hashCode();
    }

    @NotNull
    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("default", this.default);
        HashMap hashMap0 = this.localizations;
        if(hashMap0 != null) {
            JSONObject jSONObject1 = new JSONObject();
            for(Object object0: hashMap0.entrySet()) {
                jSONObject1.put(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
            }
            jSONObject0.put("localizations", jSONObject1);
        }
        return jSONObject0;
    }

    @Override
    @NotNull
    public String toString() {
        return "CustomUpdateLocalizedText(default=" + this.default + ", localizations=" + this.localizations + ')';
    }
}

