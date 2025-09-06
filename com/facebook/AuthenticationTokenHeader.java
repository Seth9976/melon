package com.facebook;

import Tf.a;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.internal.Validate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u000E\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0010\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0004\u0010\u000BB!\b\u0017\u0012\u0006\u0010\f\u001A\u00020\u0002\u0012\u0006\u0010\r\u001A\u00020\u0002\u0012\u0006\u0010\u000E\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u000FJ\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u001A\u0010 \u001A\u00020\u00112\b\u0010\u001F\u001A\u0004\u0018\u00010\u001EH\u0096\u0002¢\u0006\u0004\b \u0010!J\u000F\u0010\"\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010\u001BJ\u000F\u0010%\u001A\u00020\tH\u0000¢\u0006\u0004\b#\u0010$J\u000F\u0010&\u001A\u00020\u0002H\u0007¢\u0006\u0004\b&\u0010\u001DR\u0017\u0010\f\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\'\u001A\u0004\b(\u0010\u001DR\u0017\u0010\r\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\'\u001A\u0004\b)\u0010\u001DR\u0017\u0010\u000E\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000E\u0010\'\u001A\u0004\b*\u0010\u001D¨\u0006,"}, d2 = {"Lcom/facebook/AuthenticationTokenHeader;", "Landroid/os/Parcelable;", "", "encodedHeaderString", "<init>", "(Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "Lorg/json/JSONObject;", "jsonObject", "(Lorg/json/JSONObject;)V", "alg", "typ", "kid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "headerString", "", "isValidHeader", "(Ljava/lang/String;)Z", "dest", "", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toJSONObject$facebook_core_release", "()Lorg/json/JSONObject;", "toJSONObject", "toEnCodedString", "Ljava/lang/String;", "getAlg", "getTyp", "getKid", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AuthenticationTokenHeader implements Parcelable {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/AuthenticationTokenHeader$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AuthenticationTokenHeader;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Parcelable.Creator CREATOR;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String alg;
    @NotNull
    private final String kid;
    @NotNull
    private final String typ;

    static {
        AuthenticationTokenHeader.Companion = new Companion(null);
        AuthenticationTokenHeader.CREATOR = new AuthenticationTokenHeader.Companion.CREATOR.1();
    }

    public AuthenticationTokenHeader(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        this.alg = Validate.notNullOrEmpty(parcel0.readString(), "alg");
        this.typ = Validate.notNullOrEmpty(parcel0.readString(), "typ");
        this.kid = Validate.notNullOrEmpty(parcel0.readString(), "kid");
    }

    public AuthenticationTokenHeader(@NotNull String s) {
        q.g(s, "encodedHeaderString");
        super();
        if(!this.isValidHeader(s)) {
            throw new IllegalArgumentException("Invalid Header");
        }
        byte[] arr_b = Base64.decode(s, 0);
        q.f(arr_b, "decodedBytes");
        JSONObject jSONObject0 = new JSONObject(new String(arr_b, a.a));
        String s1 = jSONObject0.getString("alg");
        q.f(s1, "jsonObj.getString(\"alg\")");
        this.alg = s1;
        String s2 = jSONObject0.getString("typ");
        q.f(s2, "jsonObj.getString(\"typ\")");
        this.typ = s2;
        String s3 = jSONObject0.getString("kid");
        q.f(s3, "jsonObj.getString(\"kid\")");
        this.kid = s3;
    }

    public AuthenticationTokenHeader(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        q.g(s, "alg");
        q.g(s1, "typ");
        q.g(s2, "kid");
        super();
        this.alg = s;
        this.typ = s1;
        this.kid = s2;
    }

    public AuthenticationTokenHeader(@NotNull JSONObject jSONObject0) {
        q.g(jSONObject0, "jsonObject");
        super();
        String s = jSONObject0.getString("alg");
        q.f(s, "jsonObject.getString(\"alg\")");
        this.alg = s;
        String s1 = jSONObject0.getString("typ");
        q.f(s1, "jsonObject.getString(\"typ\")");
        this.typ = s1;
        String s2 = jSONObject0.getString("kid");
        q.f(s2, "jsonObject.getString(\"kid\")");
        this.kid = s2;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof AuthenticationTokenHeader ? q.b(this.alg, ((AuthenticationTokenHeader)object0).alg) && q.b(this.typ, ((AuthenticationTokenHeader)object0).typ) && q.b(this.kid, ((AuthenticationTokenHeader)object0).kid) : false;
    }

    @NotNull
    public final String getAlg() {
        return this.alg;
    }

    @NotNull
    public final String getKid() {
        return this.kid;
    }

    @NotNull
    public final String getTyp() {
        return this.typ;
    }

    @Override
    public int hashCode() {
        return this.kid.hashCode() + x.b(x.b(0x20F, 0x1F, this.alg), 0x1F, this.typ);
    }

    private final boolean isValidHeader(String s) {
        Validate.notEmpty(s, "encodedHeaderString");
        byte[] arr_b = Base64.decode(s, 0);
        q.f(arr_b, "decodedBytes");
        try {
            JSONObject jSONObject0 = new JSONObject(new String(arr_b, a.a));
            String s1 = jSONObject0.optString("alg");
            q.f(s1, "alg");
            boolean z = s1.length() > 0 && s1.equals("RS256");
            String s2 = jSONObject0.optString("kid");
            q.f(s2, "jsonObj.optString(\"kid\")");
            boolean z1 = s2.length() > 0;
            String s3 = jSONObject0.optString("typ");
            q.f(s3, "jsonObj.optString(\"typ\")");
            if(s3.length() > 0) {
                return z && z1;
            }
        }
        catch(JSONException unused_ex) {
        }
        return false;
    }

    @NotNull
    public final String toEnCodedString() {
        byte[] arr_b = this.toString().getBytes(a.a);
        q.f(arr_b, "this as java.lang.String).getBytes(charset)");
        String s = Base64.encodeToString(arr_b, 0);
        q.f(s, "encodeToString(claimsJso…eArray(), Base64.DEFAULT)");
        return s;
    }

    @NotNull
    public final JSONObject toJSONObject$facebook_core_release() {
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("alg", this.alg);
        jSONObject0.put("typ", this.typ);
        jSONObject0.put("kid", this.kid);
        return jSONObject0;
    }

    @Override
    @NotNull
    public String toString() {
        String s = this.toJSONObject$facebook_core_release().toString();
        q.f(s, "headerJsonObject.toString()");
        return s;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.alg);
        parcel0.writeString(this.typ);
        parcel0.writeString(this.kid);
    }
}

