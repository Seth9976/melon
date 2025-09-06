package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.appcompat.app.o;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "WebImageCreator")
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @VersionField(id = 1)
    final int zaa;
    @Field(getter = "getUrl", id = 2)
    private final Uri zab;
    @Field(getter = "getWidth", id = 3)
    private final int zac;
    @Field(getter = "getHeight", id = 4)
    private final int zad;

    static {
        WebImage.CREATOR = new zah();
    }

    @Constructor
    public WebImage(@Param(id = 1) int v, @Param(id = 2) Uri uri0, @Param(id = 3) int v1, @Param(id = 4) int v2) {
        this.zaa = v;
        this.zab = uri0;
        this.zac = v1;
        this.zad = v2;
    }

    public WebImage(Uri uri0) {
        this(uri0, 0, 0);
    }

    public WebImage(Uri uri0, int v, int v1) {
        this(1, uri0, v, v1);
        if(uri0 == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if(v < 0 || v1 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    @KeepForSdk
    public WebImage(JSONObject jSONObject0) {
        Uri uri0 = Uri.EMPTY;
        if(jSONObject0.has("url")) {
            try {
                uri0 = Uri.parse(jSONObject0.getString("url"));
            }
            catch(JSONException unused_ex) {
            }
        }
        this(uri0, jSONObject0.optInt("width", 0), jSONObject0.optInt("height", 0));
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && object0 instanceof WebImage && Objects.equal(this.zab, ((WebImage)object0).zab) && this.zac == ((WebImage)object0).zac && this.zad == ((WebImage)object0).zad;
    }

    public int getHeight() {
        return this.zad;
    }

    public Uri getUrl() {
        return this.zab;
    }

    public int getWidth() {
        return this.zac;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zab, this.zac, this.zad});
    }

    @KeepForSdk
    public JSONObject toJson() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("url", this.zab.toString());
            jSONObject0.put("width", this.zac);
            jSONObject0.put("height", this.zad);
        }
        catch(JSONException unused_ex) {
        }
        return jSONObject0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = o.t(this.zac, this.zad, "Image ", "x", " ");
        stringBuilder0.append(this.zab.toString());
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zaa);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.getUrl(), v, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.getWidth());
        SafeParcelWriter.writeInt(parcel0, 4, this.getHeight());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

