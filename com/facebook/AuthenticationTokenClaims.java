package com.facebook;

import A7.d;
import Tf.a;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\"\n\u0002\b\r\u0018\u0000 V2\u00020\u0001:\u0001VB\u0019\b\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0006B\u0087\u0002\b\u0017\u0012\u0006\u0010\u0007\u001A\u00020\u0002\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0002\u0012\u0006\u0010\n\u001A\u00020\u0002\u0012\u0006\u0010\f\u001A\u00020\u000B\u0012\u0006\u0010\r\u001A\u00020\u000B\u0012\u0006\u0010\u000E\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u001A\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u0016\b\u0002\u0010\u001B\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018\u0012\u0016\b\u0002\u0010\u001C\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u0005\u0010\u001FB\u0011\b\u0010\u0012\u0006\u0010!\u001A\u00020 \u00A2\u0006\u0004\b\u0005\u0010\"J\u001F\u0010&\u001A\u00020%2\u0006\u0010#\u001A\u00020 2\u0006\u0010$\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b&\u0010\'J\u001A\u0010+\u001A\u00020*2\b\u0010)\u001A\u0004\u0018\u00010(H\u0096\u0002\u00A2\u0006\u0004\b+\u0010,J\u000F\u0010-\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b-\u0010.J\u000F\u0010/\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b/\u00100J\u000F\u00101\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b1\u0010.J\u000F\u00102\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b2\u00100J\u000F\u00106\u001A\u000203H\u0001\u00A2\u0006\u0004\b4\u00105J\u001F\u00108\u001A\u00020*2\u0006\u00107\u001A\u0002032\u0006\u0010\u0004\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b8\u00109R\u0017\u0010\u0007\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010:\u001A\u0004\b;\u00100R\u0017\u0010\b\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\b\u0010:\u001A\u0004\b<\u00100R\u0017\u0010\t\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\t\u0010:\u001A\u0004\b=\u00100R\u0017\u0010\n\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\n\u0010:\u001A\u0004\b>\u00100R\u0017\u0010\f\u001A\u00020\u000B8\u0006\u00A2\u0006\f\n\u0004\b\f\u0010?\u001A\u0004\b@\u0010AR\u0017\u0010\r\u001A\u00020\u000B8\u0006\u00A2\u0006\f\n\u0004\b\r\u0010?\u001A\u0004\bB\u0010AR\u0017\u0010\u000E\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u000E\u0010:\u001A\u0004\bC\u00100R\u0019\u0010\u000F\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u000F\u0010:\u001A\u0004\bD\u00100R\u0019\u0010\u0010\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0010\u0010:\u001A\u0004\bE\u00100R\u0019\u0010\u0011\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0011\u0010:\u001A\u0004\bF\u00100R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0012\u0010:\u001A\u0004\bG\u00100R\u0019\u0010\u0013\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0013\u0010:\u001A\u0004\bH\u00100R\u0019\u0010\u0014\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0014\u0010:\u001A\u0004\bI\u00100R\u001F\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010J8\u0006\u00A2\u0006\f\n\u0004\b\u0016\u0010K\u001A\u0004\bL\u0010MR\u0019\u0010\u0017\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0017\u0010:\u001A\u0004\bN\u00100R%\u0010\u001A\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006\u00A2\u0006\f\n\u0004\b\u001A\u0010O\u001A\u0004\bP\u0010QR%\u0010\u001B\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00188\u0006\u00A2\u0006\f\n\u0004\b\u001B\u0010O\u001A\u0004\bR\u0010QR%\u0010\u001C\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00188\u0006\u00A2\u0006\f\n\u0004\b\u001C\u0010O\u001A\u0004\bS\u0010QR\u0019\u0010\u001D\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u001D\u0010:\u001A\u0004\bT\u00100R\u0019\u0010\u001E\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u001E\u0010:\u001A\u0004\bU\u00100\u00A8\u0006W"}, d2 = {"Lcom/facebook/AuthenticationTokenClaims;", "Landroid/os/Parcelable;", "", "encodedClaims", "expectedNonce", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "jti", "iss", "aud", "nonce", "", "exp", "iat", "sub", "name", "givenName", "middleName", "familyName", "email", "picture", "", "userFriends", "userBirthday", "", "", "userAgeRange", "userHometown", "userLocation", "userGender", "userLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "describeContents", "toEnCodedString", "Lorg/json/JSONObject;", "toJSONObject$facebook_core_release", "()Lorg/json/JSONObject;", "toJSONObject", "claimsJson", "isValidClaims", "(Lorg/json/JSONObject;Ljava/lang/String;)Z", "Ljava/lang/String;", "getJti", "getIss", "getAud", "getNonce", "J", "getExp", "()J", "getIat", "getSub", "getName", "getGivenName", "getMiddleName", "getFamilyName", "getEmail", "getPicture", "", "Ljava/util/Set;", "getUserFriends", "()Ljava/util/Set;", "getUserBirthday", "Ljava/util/Map;", "getUserAgeRange", "()Ljava/util/Map;", "getUserHometown", "getUserLocation", "getUserGender", "getUserLink", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AuthenticationTokenClaims implements Parcelable {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u001D\u001A\u00020\u00052\u0006\u0010\u001E\u001A\u00020\u001FH\u0001¢\u0006\u0002\b J\u001B\u0010!\u001A\u0004\u0018\u00010\u0007*\u00020\u001F2\u0006\u0010\"\u001A\u00020\u0007H\u0000¢\u0006\u0002\b#R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0086T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/facebook/AuthenticationTokenClaims$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AuthenticationTokenClaims;", "JSON_KEY_AUD", "", "JSON_KEY_EMAIL", "JSON_KEY_EXP", "JSON_KEY_FAMILY_NAME", "JSON_KEY_GIVEN_NAME", "JSON_KEY_IAT", "JSON_KEY_ISS", "JSON_KEY_JIT", "JSON_KEY_MIDDLE_NAME", "JSON_KEY_NAME", "JSON_KEY_NONCE", "JSON_KEY_PICTURE", "JSON_KEY_SUB", "JSON_KEY_USER_AGE_RANGE", "JSON_KEY_USER_BIRTHDAY", "JSON_KEY_USER_FRIENDS", "JSON_KEY_USER_GENDER", "JSON_KEY_USER_HOMETOWN", "JSON_KEY_USER_LINK", "JSON_KEY_USER_LOCATION", "MAX_TIME_SINCE_TOKEN_ISSUED", "", "createFromJSONObject", "jsonObject", "Lorg/json/JSONObject;", "createFromJSONObject$facebook_core_release", "getNullableString", "name", "getNullableString$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final AuthenticationTokenClaims createFromJSONObject$facebook_core_release(@NotNull JSONObject jSONObject0) {
            q.g(jSONObject0, "jsonObject");
            String s = jSONObject0.getString("jti");
            String s1 = jSONObject0.getString("iss");
            String s2 = jSONObject0.getString("aud");
            String s3 = jSONObject0.getString("nonce");
            long v = jSONObject0.getLong("exp");
            long v1 = jSONObject0.getLong("iat");
            String s4 = jSONObject0.getString("sub");
            String s5 = this.getNullableString$facebook_core_release(jSONObject0, "name");
            String s6 = this.getNullableString$facebook_core_release(jSONObject0, "given_name");
            String s7 = this.getNullableString$facebook_core_release(jSONObject0, "middle_name");
            String s8 = this.getNullableString$facebook_core_release(jSONObject0, "family_name");
            String s9 = this.getNullableString$facebook_core_release(jSONObject0, "email");
            String s10 = this.getNullableString$facebook_core_release(jSONObject0, "picture");
            JSONArray jSONArray0 = jSONObject0.optJSONArray("user_friends");
            String s11 = this.getNullableString$facebook_core_release(jSONObject0, "user_birthday");
            JSONObject jSONObject1 = jSONObject0.optJSONObject("user_age_range");
            JSONObject jSONObject2 = jSONObject0.optJSONObject("user_hometown");
            JSONObject jSONObject3 = jSONObject0.optJSONObject("user_location");
            String s12 = this.getNullableString$facebook_core_release(jSONObject0, "user_gender");
            String s13 = this.getNullableString$facebook_core_release(jSONObject0, "user_link");
            q.f(s, "jti");
            q.f(s1, "iss");
            q.f(s2, "aud");
            q.f(s3, "nonce");
            q.f(s4, "sub");
            List list0 = jSONArray0 == null ? null : Utility.jsonArrayToStringList(jSONArray0);
            Map map0 = jSONObject1 == null ? null : Utility.convertJSONObjectToHashMap(jSONObject1);
            Map map1 = jSONObject2 == null ? null : Utility.convertJSONObjectToStringMap(jSONObject2);
            return jSONObject3 == null ? new AuthenticationTokenClaims(s, s1, s2, s3, v, v1, s4, s5, s6, s7, s8, s9, s10, list0, s11, map0, map1, null, s12, s13) : new AuthenticationTokenClaims(s, s1, s2, s3, v, v1, s4, s5, s6, s7, s8, s9, s10, list0, s11, map0, map1, Utility.convertJSONObjectToStringMap(jSONObject3), s12, s13);
        }

        @Nullable
        public final String getNullableString$facebook_core_release(@NotNull JSONObject jSONObject0, @NotNull String s) {
            q.g(jSONObject0, "<this>");
            q.g(s, "name");
            return jSONObject0.has(s) ? jSONObject0.getString(s) : null;
        }
    }

    @NotNull
    public static final Parcelable.Creator CREATOR = null;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String JSON_KEY_AUD = "aud";
    @NotNull
    public static final String JSON_KEY_EMAIL = "email";
    @NotNull
    public static final String JSON_KEY_EXP = "exp";
    @NotNull
    public static final String JSON_KEY_FAMILY_NAME = "family_name";
    @NotNull
    public static final String JSON_KEY_GIVEN_NAME = "given_name";
    @NotNull
    public static final String JSON_KEY_IAT = "iat";
    @NotNull
    public static final String JSON_KEY_ISS = "iss";
    @NotNull
    public static final String JSON_KEY_JIT = "jti";
    @NotNull
    public static final String JSON_KEY_MIDDLE_NAME = "middle_name";
    @NotNull
    public static final String JSON_KEY_NAME = "name";
    @NotNull
    public static final String JSON_KEY_NONCE = "nonce";
    @NotNull
    public static final String JSON_KEY_PICTURE = "picture";
    @NotNull
    public static final String JSON_KEY_SUB = "sub";
    @NotNull
    public static final String JSON_KEY_USER_AGE_RANGE = "user_age_range";
    @NotNull
    public static final String JSON_KEY_USER_BIRTHDAY = "user_birthday";
    @NotNull
    public static final String JSON_KEY_USER_FRIENDS = "user_friends";
    @NotNull
    public static final String JSON_KEY_USER_GENDER = "user_gender";
    @NotNull
    public static final String JSON_KEY_USER_HOMETOWN = "user_hometown";
    @NotNull
    public static final String JSON_KEY_USER_LINK = "user_link";
    @NotNull
    public static final String JSON_KEY_USER_LOCATION = "user_location";
    public static final long MAX_TIME_SINCE_TOKEN_ISSUED = 600000L;
    @NotNull
    private final String aud;
    @Nullable
    private final String email;
    private final long exp;
    @Nullable
    private final String familyName;
    @Nullable
    private final String givenName;
    private final long iat;
    @NotNull
    private final String iss;
    @NotNull
    private final String jti;
    @Nullable
    private final String middleName;
    @Nullable
    private final String name;
    @NotNull
    private final String nonce;
    @Nullable
    private final String picture;
    @NotNull
    private final String sub;
    @Nullable
    private final Map userAgeRange;
    @Nullable
    private final String userBirthday;
    @Nullable
    private final Set userFriends;
    @Nullable
    private final String userGender;
    @Nullable
    private final Map userHometown;
    @Nullable
    private final String userLink;
    @Nullable
    private final Map userLocation;

    static {
        AuthenticationTokenClaims.Companion = new Companion(null);
        AuthenticationTokenClaims.CREATOR = new AuthenticationTokenClaims.Companion.CREATOR.1();
    }

    public AuthenticationTokenClaims(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        this.jti = Validate.notNullOrEmpty(parcel0.readString(), "jti");
        this.iss = Validate.notNullOrEmpty(parcel0.readString(), "iss");
        this.aud = Validate.notNullOrEmpty(parcel0.readString(), "aud");
        this.nonce = Validate.notNullOrEmpty(parcel0.readString(), "nonce");
        this.exp = parcel0.readLong();
        this.iat = parcel0.readLong();
        this.sub = Validate.notNullOrEmpty(parcel0.readString(), "sub");
        this.name = parcel0.readString();
        this.givenName = parcel0.readString();
        this.middleName = parcel0.readString();
        this.familyName = parcel0.readString();
        this.email = parcel0.readString();
        this.picture = parcel0.readString();
        ArrayList arrayList0 = parcel0.createStringArrayList();
        Map map0 = null;
        this.userFriends = arrayList0 == null ? null : Collections.unmodifiableSet(new HashSet(arrayList0));
        this.userBirthday = parcel0.readString();
        HashMap hashMap0 = parcel0.readHashMap(o.class.getClassLoader());
        if(hashMap0 == null) {
            hashMap0 = null;
        }
        this.userAgeRange = hashMap0 == null ? null : Collections.unmodifiableMap(hashMap0);
        Class class0 = M.class;
        HashMap hashMap1 = parcel0.readHashMap(class0.getClassLoader());
        if(hashMap1 == null) {
            hashMap1 = null;
        }
        this.userHometown = hashMap1 == null ? null : Collections.unmodifiableMap(hashMap1);
        HashMap hashMap2 = parcel0.readHashMap(class0.getClassLoader());
        if(hashMap2 == null) {
            hashMap2 = null;
        }
        if(hashMap2 != null) {
            map0 = Collections.unmodifiableMap(hashMap2);
        }
        this.userLocation = map0;
        this.userGender = parcel0.readString();
        this.userLink = parcel0.readString();
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1) {
        q.g(s, "encodedClaims");
        q.g(s1, "expectedNonce");
        super();
        Validate.notEmpty(s, "encodedClaims");
        byte[] arr_b = Base64.decode(s, 8);
        q.f(arr_b, "decodedBytes");
        JSONObject jSONObject0 = new JSONObject(new String(arr_b, a.a));
        if(!this.isValidClaims(jSONObject0, s1)) {
            throw new IllegalArgumentException("Invalid claims");
        }
        String s2 = jSONObject0.getString("jti");
        q.f(s2, "jsonObj.getString(JSON_KEY_JIT)");
        this.jti = s2;
        String s3 = jSONObject0.getString("iss");
        q.f(s3, "jsonObj.getString(JSON_KEY_ISS)");
        this.iss = s3;
        String s4 = jSONObject0.getString("aud");
        q.f(s4, "jsonObj.getString(JSON_KEY_AUD)");
        this.aud = s4;
        String s5 = jSONObject0.getString("nonce");
        q.f(s5, "jsonObj.getString(JSON_KEY_NONCE)");
        this.nonce = s5;
        this.exp = jSONObject0.getLong("exp");
        this.iat = jSONObject0.getLong("iat");
        String s6 = jSONObject0.getString("sub");
        q.f(s6, "jsonObj.getString(JSON_KEY_SUB)");
        this.sub = s6;
        Companion authenticationTokenClaims$Companion0 = AuthenticationTokenClaims.Companion;
        this.name = authenticationTokenClaims$Companion0.getNullableString$facebook_core_release(jSONObject0, "name");
        this.givenName = authenticationTokenClaims$Companion0.getNullableString$facebook_core_release(jSONObject0, "given_name");
        this.middleName = authenticationTokenClaims$Companion0.getNullableString$facebook_core_release(jSONObject0, "middle_name");
        this.familyName = authenticationTokenClaims$Companion0.getNullableString$facebook_core_release(jSONObject0, "family_name");
        this.email = authenticationTokenClaims$Companion0.getNullableString$facebook_core_release(jSONObject0, "email");
        this.picture = authenticationTokenClaims$Companion0.getNullableString$facebook_core_release(jSONObject0, "picture");
        JSONArray jSONArray0 = jSONObject0.optJSONArray("user_friends");
        Map map0 = null;
        this.userFriends = jSONArray0 == null ? null : Collections.unmodifiableSet(Utility.jsonArrayToSet(jSONArray0));
        this.userBirthday = authenticationTokenClaims$Companion0.getNullableString$facebook_core_release(jSONObject0, "user_birthday");
        JSONObject jSONObject1 = jSONObject0.optJSONObject("user_age_range");
        this.userAgeRange = jSONObject1 == null ? null : Collections.unmodifiableMap(Utility.convertJSONObjectToHashMap(jSONObject1));
        JSONObject jSONObject2 = jSONObject0.optJSONObject("user_hometown");
        this.userHometown = jSONObject2 == null ? null : Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(jSONObject2));
        JSONObject jSONObject3 = jSONObject0.optJSONObject("user_location");
        if(jSONObject3 != null) {
            map0 = Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(jSONObject3));
        }
        this.userLocation = map0;
        this.userGender = authenticationTokenClaims$Companion0.getNullableString$facebook_core_release(jSONObject0, "user_gender");
        this.userLink = authenticationTokenClaims$Companion0.getNullableString$facebook_core_release(jSONObject0, "user_link");
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        this(s, s1, s2, s3, v, v1, s4, null, null, null, null, null, null, null, null, null, null, null, null, null, 0xFFF80, null);
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4, @Nullable String s5) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        this(s, s1, s2, s3, v, v1, s4, s5, null, null, null, null, null, null, null, null, null, null, null, null, 0xFFF00, null);
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4, @Nullable String s5, @Nullable String s6) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        this(s, s1, s2, s3, v, v1, s4, s5, s6, null, null, null, null, null, null, null, null, null, null, null, 0xFFE00, null);
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        this(s, s1, s2, s3, v, v1, s4, s5, s6, s7, null, null, null, null, null, null, null, null, null, null, 0xFFC00, null);
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        this(s, s1, s2, s3, v, v1, s4, s5, s6, s7, s8, null, null, null, null, null, null, null, null, null, 0xFF800, null);
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        this(s, s1, s2, s3, v, v1, s4, s5, s6, s7, s8, s9, null, null, null, null, null, null, null, null, 0xFF000, null);
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        this(s, s1, s2, s3, v, v1, s4, s5, s6, s7, s8, s9, s10, null, null, null, null, null, null, null, 0xFE000, null);
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable Collection collection0) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        this(s, s1, s2, s3, v, v1, s4, s5, s6, s7, s8, s9, s10, collection0, null, null, null, null, null, null, 0xFC000, null);
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable Collection collection0, @Nullable String s11) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        this(s, s1, s2, s3, v, v1, s4, s5, s6, s7, s8, s9, s10, collection0, s11, null, null, null, null, null, 0xF8000, null);
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable Collection collection0, @Nullable String s11, @Nullable Map map0) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        this(s, s1, s2, s3, v, v1, s4, s5, s6, s7, s8, s9, s10, collection0, s11, map0, null, null, null, null, 0xF0000, null);
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable Collection collection0, @Nullable String s11, @Nullable Map map0, @Nullable Map map1) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        this(s, s1, s2, s3, v, v1, s4, s5, s6, s7, s8, s9, s10, collection0, s11, map0, map1, null, null, null, 0xE0000, null);
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable Collection collection0, @Nullable String s11, @Nullable Map map0, @Nullable Map map1, @Nullable Map map2) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        this(s, s1, s2, s3, v, v1, s4, s5, s6, s7, s8, s9, s10, collection0, s11, map0, map1, map2, null, null, 0xC0000, null);
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable Collection collection0, @Nullable String s11, @Nullable Map map0, @Nullable Map map1, @Nullable Map map2, @Nullable String s12) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        this(s, s1, s2, s3, v, v1, s4, s5, s6, s7, s8, s9, s10, collection0, s11, map0, map1, map2, s12, null, 0x80000, null);
    }

    public AuthenticationTokenClaims(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v, long v1, @NotNull String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable Collection collection0, @Nullable String s11, @Nullable Map map0, @Nullable Map map1, @Nullable Map map2, @Nullable String s12, @Nullable String s13) {
        q.g(s, "jti");
        q.g(s1, "iss");
        q.g(s2, "aud");
        q.g(s3, "nonce");
        q.g(s4, "sub");
        super();
        Validate.notEmpty(s, "jti");
        Validate.notEmpty(s1, "iss");
        Validate.notEmpty(s2, "aud");
        Validate.notEmpty(s3, "nonce");
        Validate.notEmpty(s4, "sub");
        this.jti = s;
        this.iss = s1;
        this.aud = s2;
        this.nonce = s3;
        this.exp = v;
        this.iat = v1;
        this.sub = s4;
        this.name = s5;
        this.givenName = s6;
        this.middleName = s7;
        this.familyName = s8;
        this.email = s9;
        this.picture = s10;
        Map map3 = null;
        this.userFriends = collection0 == null ? null : Collections.unmodifiableSet(new HashSet(collection0));
        this.userBirthday = s11;
        this.userAgeRange = map0 == null ? null : Collections.unmodifiableMap(new HashMap(map0));
        this.userHometown = map1 == null ? null : Collections.unmodifiableMap(new HashMap(map1));
        if(map2 != null) {
            map3 = Collections.unmodifiableMap(new HashMap(map2));
        }
        this.userLocation = map3;
        this.userGender = s12;
        this.userLink = s13;
    }

    public AuthenticationTokenClaims(String s, String s1, String s2, String s3, long v, long v1, String s4, String s5, String s6, String s7, String s8, String s9, String s10, Collection collection0, String s11, Map map0, Map map1, Map map2, String s12, String s13, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, s1, s2, s3, v, v1, s4, ((v2 & 0x80) == 0 ? s5 : null), ((v2 & 0x100) == 0 ? s6 : null), ((v2 & 0x200) == 0 ? s7 : null), ((v2 & 0x400) == 0 ? s8 : null), ((v2 & 0x800) == 0 ? s9 : null), ((v2 & 0x1000) == 0 ? s10 : null), ((v2 & 0x2000) == 0 ? collection0 : null), ((v2 & 0x4000) == 0 ? s11 : null), ((0x8000 & v2) == 0 ? map0 : null), ((0x10000 & v2) == 0 ? map1 : null), ((0x20000 & v2) == 0 ? map2 : null), ((0x40000 & v2) == 0 ? s12 : null), ((v2 & 0x80000) == 0 ? s13 : null));
    }

    @NotNull
    public static final AuthenticationTokenClaims createFromJSONObject$facebook_core_release(@NotNull JSONObject jSONObject0) {
        return AuthenticationTokenClaims.Companion.createFromJSONObject$facebook_core_release(jSONObject0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    // 去混淆评级： 低(31)
    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AuthenticationTokenClaims)) {
            return false;
        }
        AuthenticationTokenClaims authenticationTokenClaims0 = (AuthenticationTokenClaims)object0;
        return q.b(this.jti, authenticationTokenClaims0.jti) && q.b(this.iss, authenticationTokenClaims0.iss) && q.b(this.aud, authenticationTokenClaims0.aud) && q.b(this.nonce, authenticationTokenClaims0.nonce) && this.exp == authenticationTokenClaims0.exp && this.iat == authenticationTokenClaims0.iat && q.b(this.sub, authenticationTokenClaims0.sub) && q.b(this.name, authenticationTokenClaims0.name) && q.b(this.givenName, authenticationTokenClaims0.givenName) && q.b(this.middleName, authenticationTokenClaims0.middleName) && q.b(this.familyName, authenticationTokenClaims0.familyName) && q.b(this.email, authenticationTokenClaims0.email) && q.b(this.picture, authenticationTokenClaims0.picture) && q.b(this.userFriends, authenticationTokenClaims0.userFriends) && q.b(this.userBirthday, authenticationTokenClaims0.userBirthday) && q.b(this.userAgeRange, authenticationTokenClaims0.userAgeRange) && q.b(this.userHometown, authenticationTokenClaims0.userHometown) && q.b(this.userLocation, authenticationTokenClaims0.userLocation) && q.b(this.userGender, authenticationTokenClaims0.userGender) && q.b(this.userLink, authenticationTokenClaims0.userLink);
    }

    @NotNull
    public final String getAud() {
        return this.aud;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    public final long getExp() {
        return this.exp;
    }

    @Nullable
    public final String getFamilyName() {
        return this.familyName;
    }

    @Nullable
    public final String getGivenName() {
        return this.givenName;
    }

    public final long getIat() {
        return this.iat;
    }

    @NotNull
    public final String getIss() {
        return this.iss;
    }

    @NotNull
    public final String getJti() {
        return this.jti;
    }

    @Nullable
    public final String getMiddleName() {
        return this.middleName;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getNonce() {
        return this.nonce;
    }

    @Nullable
    public final String getPicture() {
        return this.picture;
    }

    @NotNull
    public final String getSub() {
        return this.sub;
    }

    @Nullable
    public final Map getUserAgeRange() {
        return this.userAgeRange;
    }

    @Nullable
    public final String getUserBirthday() {
        return this.userBirthday;
    }

    @Nullable
    public final Set getUserFriends() {
        return this.userFriends;
    }

    @Nullable
    public final String getUserGender() {
        return this.userGender;
    }

    @Nullable
    public final Map getUserHometown() {
        return this.userHometown;
    }

    @Nullable
    public final String getUserLink() {
        return this.userLink;
    }

    @Nullable
    public final Map getUserLocation() {
        return this.userLocation;
    }

    @Override
    public int hashCode() {
        int v = x.b(d.c(d.c(x.b(x.b(x.b(x.b(0x20F, 0x1F, this.jti), 0x1F, this.iss), 0x1F, this.aud), 0x1F, this.nonce), 0x1F, this.exp), 0x1F, this.iat), 0x1F, this.sub);
        int v1 = 0;
        int v2 = this.name == null ? 0 : this.name.hashCode();
        int v3 = this.givenName == null ? 0 : this.givenName.hashCode();
        int v4 = this.middleName == null ? 0 : this.middleName.hashCode();
        int v5 = this.familyName == null ? 0 : this.familyName.hashCode();
        int v6 = this.email == null ? 0 : this.email.hashCode();
        int v7 = this.picture == null ? 0 : this.picture.hashCode();
        int v8 = this.userFriends == null ? 0 : this.userFriends.hashCode();
        int v9 = this.userBirthday == null ? 0 : this.userBirthday.hashCode();
        int v10 = this.userAgeRange == null ? 0 : this.userAgeRange.hashCode();
        int v11 = this.userHometown == null ? 0 : this.userHometown.hashCode();
        int v12 = this.userLocation == null ? 0 : this.userLocation.hashCode();
        int v13 = this.userGender == null ? 0 : this.userGender.hashCode();
        String s = this.userLink;
        if(s != null) {
            v1 = s.hashCode();
        }
        return ((((((((((((v + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v10) * 0x1F + v11) * 0x1F + v12) * 0x1F + v13) * 0x1F + v1;
    }

    private final boolean isValidClaims(JSONObject jSONObject0, String s) {
        if(jSONObject0 == null) {
            return false;
        }
        String s1 = jSONObject0.optString("jti");
        q.f(s1, "jti");
        if(s1.length() == 0) {
            return false;
        }
        try {
            String s2 = jSONObject0.optString("iss");
            q.f(s2, "iss");
            if(s2.length() == 0 || !q.b(new URL(s2).getHost(), "facebook.com") && !q.b(new URL(s2).getHost(), "www.facebook.com")) {
                return false;
            }
        }
        catch(MalformedURLException unused_ex) {
            return false;
        }
        String s3 = jSONObject0.optString("aud");
        q.f(s3, "aud");
        if(s3.length() == 0 || !s3.equals(FacebookSdk.getApplicationId())) {
            return false;
        }
        Date date0 = new Date(jSONObject0.optLong("exp") * 1000L);
        if(new Date().after(date0)) {
            return false;
        }
        Date date1 = new Date(jSONObject0.optLong("iat") * 1000L + 600000L);
        if(new Date().after(date1)) {
            return false;
        }
        String s4 = jSONObject0.optString("sub");
        q.f(s4, "sub");
        if(s4.length() == 0) {
            return false;
        }
        String s5 = jSONObject0.optString("nonce");
        q.f(s5, "nonce");
        return s5.length() != 0 && s5.equals(s);
    }

    @NotNull
    public final String toEnCodedString() {
        byte[] arr_b = this.toString().getBytes(a.a);
        q.f(arr_b, "this as java.lang.String).getBytes(charset)");
        String s = Base64.encodeToString(arr_b, 8);
        q.f(s, "encodeToString(claimsJso…Array(), Base64.URL_SAFE)");
        return s;
    }

    @NotNull
    public final JSONObject toJSONObject$facebook_core_release() {
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("jti", this.jti);
        jSONObject0.put("iss", this.iss);
        jSONObject0.put("aud", this.aud);
        jSONObject0.put("nonce", this.nonce);
        jSONObject0.put("exp", this.exp);
        jSONObject0.put("iat", this.iat);
        String s = this.sub;
        if(s != null) {
            jSONObject0.put("sub", s);
        }
        String s1 = this.name;
        if(s1 != null) {
            jSONObject0.put("name", s1);
        }
        String s2 = this.givenName;
        if(s2 != null) {
            jSONObject0.put("given_name", s2);
        }
        String s3 = this.middleName;
        if(s3 != null) {
            jSONObject0.put("middle_name", s3);
        }
        String s4 = this.familyName;
        if(s4 != null) {
            jSONObject0.put("family_name", s4);
        }
        String s5 = this.email;
        if(s5 != null) {
            jSONObject0.put("email", s5);
        }
        String s6 = this.picture;
        if(s6 != null) {
            jSONObject0.put("picture", s6);
        }
        if(this.userFriends != null) {
            jSONObject0.put("user_friends", new JSONArray(this.userFriends));
        }
        String s7 = this.userBirthday;
        if(s7 != null) {
            jSONObject0.put("user_birthday", s7);
        }
        if(this.userAgeRange != null) {
            jSONObject0.put("user_age_range", new JSONObject(this.userAgeRange));
        }
        if(this.userHometown != null) {
            jSONObject0.put("user_hometown", new JSONObject(this.userHometown));
        }
        if(this.userLocation != null) {
            jSONObject0.put("user_location", new JSONObject(this.userLocation));
        }
        String s8 = this.userGender;
        if(s8 != null) {
            jSONObject0.put("user_gender", s8);
        }
        String s9 = this.userLink;
        if(s9 != null) {
            jSONObject0.put("user_link", s9);
        }
        return jSONObject0;
    }

    @Override
    @NotNull
    public String toString() {
        String s = this.toJSONObject$facebook_core_release().toString();
        q.f(s, "claimsJsonObject.toString()");
        return s;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.jti);
        parcel0.writeString(this.iss);
        parcel0.writeString(this.aud);
        parcel0.writeString(this.nonce);
        parcel0.writeLong(this.exp);
        parcel0.writeLong(this.iat);
        parcel0.writeString(this.sub);
        parcel0.writeString(this.name);
        parcel0.writeString(this.givenName);
        parcel0.writeString(this.middleName);
        parcel0.writeString(this.familyName);
        parcel0.writeString(this.email);
        parcel0.writeString(this.picture);
        if(this.userFriends == null) {
            parcel0.writeStringList(null);
        }
        else {
            parcel0.writeStringList(new ArrayList(this.userFriends));
        }
        parcel0.writeString(this.userBirthday);
        parcel0.writeMap(this.userAgeRange);
        parcel0.writeMap(this.userHometown);
        parcel0.writeMap(this.userLocation);
        parcel0.writeString(this.userGender);
        parcel0.writeString(this.userLink);
    }
}

