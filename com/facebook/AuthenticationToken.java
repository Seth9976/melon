package com.facebook;

import Tf.o;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.facebook.internal.Validate;
import com.facebook.internal.security.OidcSecurityUtil;
import java.io.IOException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u00014B\u0019\b\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0010\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB\u0011\b\u0010\u0012\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ/\u0010\u0012\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0016\u001A\u00020\nH\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001A\u0010\u0019\u001A\u00020\u00112\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001C\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010!\u001A\u00020 2\u0006\u0010\u001E\u001A\u00020\u00072\u0006\u0010\u001F\u001A\u00020\u001BH\u0016¢\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\u001BH\u0016¢\u0006\u0004\b#\u0010\u001DR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001A\u0004\b%\u0010&R\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001A\u0004\b\'\u0010&R\u0017\u0010)\u001A\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001A\u0004\b+\u0010,R\u0017\u0010.\u001A\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001A\u0004\b0\u00101R\u0017\u00102\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b2\u0010$\u001A\u0004\b3\u0010&¨\u00065"}, d2 = {"Lcom/facebook/AuthenticationToken;", "Landroid/os/Parcelable;", "", "token", "expectedNonce", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "Lorg/json/JSONObject;", "jsonObject", "(Lorg/json/JSONObject;)V", "headerString", "claimsString", "sigString", "kid", "", "isValidSignature", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "toJSONObject$facebook_core_release", "()Lorg/json/JSONObject;", "toJSONObject", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "getExpectedNonce", "Lcom/facebook/AuthenticationTokenHeader;", "header", "Lcom/facebook/AuthenticationTokenHeader;", "getHeader", "()Lcom/facebook/AuthenticationTokenHeader;", "Lcom/facebook/AuthenticationTokenClaims;", "claims", "Lcom/facebook/AuthenticationTokenClaims;", "getClaims", "()Lcom/facebook/AuthenticationTokenClaims;", "signature", "getSignature", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AuthenticationToken implements Parcelable {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001A\u00020\u000B8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000E\u0010\rR\u001A\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00040\u000F8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/facebook/AuthenticationToken$Companion;", "", "<init>", "()V", "Lcom/facebook/AuthenticationToken;", "getCurrentAuthenticationToken", "()Lcom/facebook/AuthenticationToken;", "authenticationToken", "Lie/H;", "setCurrentAuthenticationToken", "(Lcom/facebook/AuthenticationToken;)V", "", "AUTHENTICATION_TOKEN_KEY", "Ljava/lang/String;", "CLAIMS_KEY", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "EXPECTED_NONCE_KEY", "HEADER_KEY", "SIGNATURE_KEY", "TOKEN_STRING_KEY", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final AuthenticationToken getCurrentAuthenticationToken() {
            return AuthenticationTokenManager.Companion.getInstance().getCurrentAuthenticationToken();
        }

        public final void setCurrentAuthenticationToken(@Nullable AuthenticationToken authenticationToken0) {
            AuthenticationTokenManager.Companion.getInstance().setCurrentAuthenticationToken(authenticationToken0);
        }
    }

    @NotNull
    public static final String AUTHENTICATION_TOKEN_KEY = "id_token";
    @NotNull
    private static final String CLAIMS_KEY = "claims";
    @NotNull
    public static final Parcelable.Creator CREATOR = null;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String EXPECTED_NONCE_KEY = "expected_nonce";
    @NotNull
    private static final String HEADER_KEY = "header";
    @NotNull
    private static final String SIGNATURE_KEY = "signature";
    @NotNull
    private static final String TOKEN_STRING_KEY = "token_string";
    @NotNull
    private final AuthenticationTokenClaims claims;
    @NotNull
    private final String expectedNonce;
    @NotNull
    private final AuthenticationTokenHeader header;
    @NotNull
    private final String signature;
    @NotNull
    private final String token;

    static {
        AuthenticationToken.Companion = new Companion(null);
        AuthenticationToken.CREATOR = new AuthenticationToken.Companion.CREATOR.1();
    }

    public AuthenticationToken(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        this.token = Validate.notNullOrEmpty(parcel0.readString(), "token");
        this.expectedNonce = Validate.notNullOrEmpty(parcel0.readString(), "expectedNonce");
        Parcelable parcelable0 = parcel0.readParcelable(AuthenticationTokenHeader.class.getClassLoader());
        if(parcelable0 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.header = (AuthenticationTokenHeader)parcelable0;
        Parcelable parcelable1 = parcel0.readParcelable(AuthenticationTokenClaims.class.getClassLoader());
        if(parcelable1 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.claims = (AuthenticationTokenClaims)parcelable1;
        this.signature = Validate.notNullOrEmpty(parcel0.readString(), "signature");
    }

    public AuthenticationToken(@NotNull String s, @NotNull String s1) {
        q.g(s, "token");
        q.g(s1, "expectedNonce");
        super();
        Validate.notEmpty(s, "token");
        Validate.notEmpty(s1, "expectedNonce");
        List list0 = o.R0(s, new String[]{"."}, 0, 6);
        if(list0.size() != 3) {
            throw new IllegalArgumentException("Invalid IdToken string");
        }
        String s2 = (String)list0.get(0);
        String s3 = (String)list0.get(1);
        String s4 = (String)list0.get(2);
        this.token = s;
        this.expectedNonce = s1;
        AuthenticationTokenHeader authenticationTokenHeader0 = new AuthenticationTokenHeader(s2);
        this.header = authenticationTokenHeader0;
        this.claims = new AuthenticationTokenClaims(s3, s1);
        if(!this.isValidSignature(s2, s3, s4, authenticationTokenHeader0.getKid())) {
            throw new IllegalArgumentException("Invalid Signature");
        }
        this.signature = s4;
    }

    public AuthenticationToken(@NotNull JSONObject jSONObject0) {
        q.g(jSONObject0, "jsonObject");
        super();
        String s = jSONObject0.getString("token_string");
        q.f(s, "jsonObject.getString(TOKEN_STRING_KEY)");
        this.token = s;
        String s1 = jSONObject0.getString("expected_nonce");
        q.f(s1, "jsonObject.getString(EXPECTED_NONCE_KEY)");
        this.expectedNonce = s1;
        String s2 = jSONObject0.getString("signature");
        q.f(s2, "jsonObject.getString(SIGNATURE_KEY)");
        this.signature = s2;
        JSONObject jSONObject1 = jSONObject0.getJSONObject("header");
        JSONObject jSONObject2 = jSONObject0.getJSONObject("claims");
        q.f(jSONObject1, "headerJSONObject");
        this.header = new AuthenticationTokenHeader(jSONObject1);
        q.f(jSONObject2, "claimsJSONObject");
        this.claims = AuthenticationTokenClaims.Companion.createFromJSONObject$facebook_core_release(jSONObject2);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof AuthenticationToken ? q.b(this.token, ((AuthenticationToken)object0).token) && q.b(this.expectedNonce, ((AuthenticationToken)object0).expectedNonce) && q.b(this.header, ((AuthenticationToken)object0).header) && q.b(this.claims, ((AuthenticationToken)object0).claims) && q.b(this.signature, ((AuthenticationToken)object0).signature) : false;
    }

    @NotNull
    public final AuthenticationTokenClaims getClaims() {
        return this.claims;
    }

    @Nullable
    public static final AuthenticationToken getCurrentAuthenticationToken() {
        return AuthenticationToken.Companion.getCurrentAuthenticationToken();
    }

    @NotNull
    public final String getExpectedNonce() {
        return this.expectedNonce;
    }

    @NotNull
    public final AuthenticationTokenHeader getHeader() {
        return this.header;
    }

    @NotNull
    public final String getSignature() {
        return this.signature;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    @Override
    public int hashCode() {
        return this.signature.hashCode() + (this.claims.hashCode() + (this.header.hashCode() + x.b(x.b(0x20F, 0x1F, this.token), 0x1F, this.expectedNonce)) * 0x1F) * 0x1F;
    }

    private final boolean isValidSignature(String s, String s1, String s2, String s3) {
        try {
            String s4 = OidcSecurityUtil.getRawKeyFromEndPoint(s3);
            return s4 == null ? false : OidcSecurityUtil.verify(OidcSecurityUtil.getPublicKeyFromString(s4), s + '.' + s1, s2);
        }
        catch(InvalidKeySpecException | IOException unused_ex) {
            return false;
        }
    }

    public static final void setCurrentAuthenticationToken(@Nullable AuthenticationToken authenticationToken0) {
        AuthenticationToken.Companion.setCurrentAuthenticationToken(authenticationToken0);
    }

    @NotNull
    public final JSONObject toJSONObject$facebook_core_release() {
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("token_string", this.token);
        jSONObject0.put("expected_nonce", this.expectedNonce);
        jSONObject0.put("header", this.header.toJSONObject$facebook_core_release());
        jSONObject0.put("claims", this.claims.toJSONObject$facebook_core_release());
        jSONObject0.put("signature", this.signature);
        return jSONObject0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.token);
        parcel0.writeString(this.expectedNonce);
        parcel0.writeParcelable(this.header, v);
        parcel0.writeParcelable(this.claims, v);
        parcel0.writeString(this.signature);
    }
}

