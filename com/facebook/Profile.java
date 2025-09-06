package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000F\u0018\u0000 22\u00020\u0001:\u00012BQ\b\u0017\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\u000B\u0010\fB\u0011\b\u0010\u0012\u0006\u0010\u000E\u001A\u00020\r\u00A2\u0006\u0004\b\u000B\u0010\u000FB\u0011\b\u0012\u0012\u0006\u0010\u0011\u001A\u00020\u0010\u00A2\u0006\u0004\b\u000B\u0010\u0012J\u001D\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u001A\u0010\u001B\u001A\u00020\u001A2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0096\u0002\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u0004\u0018\u00010\r\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b!\u0010\u001EJ\u001F\u0010%\u001A\u00020$2\u0006\u0010\"\u001A\u00020\u00102\u0006\u0010#\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b%\u0010&R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010\'\u001A\u0004\b(\u0010)R\u0019\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010\'\u001A\u0004\b*\u0010)R\u0019\u0010\u0005\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010\'\u001A\u0004\b+\u0010)R\u0019\u0010\u0006\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010\'\u001A\u0004\b,\u0010)R\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010\'\u001A\u0004\b-\u0010)R\u0019\u0010\t\u001A\u0004\u0018\u00010\b8\u0006\u00A2\u0006\f\n\u0004\b\t\u0010.\u001A\u0004\b/\u00100R\u0019\u0010\n\u001A\u0004\u0018\u00010\b8\u0006\u00A2\u0006\f\n\u0004\b\n\u0010.\u001A\u0004\b1\u00100\u00A8\u00063"}, d2 = {"Lcom/facebook/Profile;", "Landroid/os/Parcelable;", "", "id", "firstName", "middleName", "lastName", "name", "Landroid/net/Uri;", "linkUri", "pictureUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;)V", "Lorg/json/JSONObject;", "jsonObject", "(Lorg/json/JSONObject;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "", "width", "height", "getProfilePictureUri", "(II)Landroid/net/Uri;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toJSONObject", "()Lorg/json/JSONObject;", "describeContents", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getFirstName", "getMiddleName", "getLastName", "getName", "Landroid/net/Uri;", "getLinkUri", "()Landroid/net/Uri;", "getPictureUri", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Profile implements Parcelable {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0007¢\u0006\u0004\b\u000B\u0010\u0003R\u001A\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00040\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000ER\u0014\u0010\u0010\u001A\u00020\u000F8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u000F8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001A\u00020\u000F8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001A\u00020\u000F8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001A\u00020\u000F8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001A\u00020\u000F8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001A\u00020\u000F8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u001C\u0010\u0019\u001A\n \u0018*\u0004\u0018\u00010\u000F0\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011¨\u0006\u001A"}, d2 = {"Lcom/facebook/Profile$Companion;", "", "<init>", "()V", "Lcom/facebook/Profile;", "getCurrentProfile", "()Lcom/facebook/Profile;", "profile", "Lie/H;", "setCurrentProfile", "(Lcom/facebook/Profile;)V", "fetchProfileForCurrentAccessToken", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "FIRST_NAME_KEY", "Ljava/lang/String;", "ID_KEY", "LAST_NAME_KEY", "LINK_URI_KEY", "MIDDLE_NAME_KEY", "NAME_KEY", "PICTURE_URI_KEY", "kotlin.jvm.PlatformType", "TAG", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final void fetchProfileForCurrentAccessToken() {
            com.facebook.AccessToken.Companion accessToken$Companion0 = AccessToken.Companion;
            AccessToken accessToken0 = accessToken$Companion0.getCurrentAccessToken();
            if(accessToken0 == null) {
                return;
            }
            if(!accessToken$Companion0.isCurrentAccessTokenActive()) {
                this.setCurrentProfile(null);
                return;
            }
            Utility.getGraphMeRequestWithCacheAsync(accessToken0.getToken(), new com.facebook.Profile.Companion.fetchProfileForCurrentAccessToken.1());

            @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"com/facebook/Profile$Companion$fetchProfileForCurrentAccessToken$1", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "Lorg/json/JSONObject;", "userInfo", "Lie/H;", "onSuccess", "(Lorg/json/JSONObject;)V", "Lcom/facebook/FacebookException;", "error", "onFailure", "(Lcom/facebook/FacebookException;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
            public final class com.facebook.Profile.Companion.fetchProfileForCurrentAccessToken.1 implements GraphMeRequestWithCacheCallback {
                @Override  // com.facebook.internal.Utility$GraphMeRequestWithCacheCallback
                public void onFailure(@Nullable FacebookException facebookException0) {
                    Log.e("Profile", "Got unexpected exception: " + facebookException0);
                }

                @Override  // com.facebook.internal.Utility$GraphMeRequestWithCacheCallback
                public void onSuccess(@Nullable JSONObject jSONObject0) {
                    Uri uri0 = null;
                    String s = jSONObject0 == null ? null : jSONObject0.optString("id");
                    if(s == null) {
                        Log.w("Profile", "No user ID returned on Me request");
                        return;
                    }
                    String s1 = jSONObject0.optString("link");
                    String s2 = jSONObject0.optString("profile_picture", null);
                    String s3 = jSONObject0.optString("first_name");
                    String s4 = jSONObject0.optString("middle_name");
                    String s5 = jSONObject0.optString("last_name");
                    String s6 = jSONObject0.optString("name");
                    Uri uri1 = s1 == null ? null : Uri.parse(s1);
                    if(s2 != null) {
                        uri0 = Uri.parse(s2);
                    }
                    Profile profile0 = new Profile(s, s3, s4, s5, s6, uri1, uri0);
                    Profile.Companion.setCurrentProfile(profile0);
                }
            }

        }

        @Nullable
        public final Profile getCurrentProfile() {
            return ProfileManager.Companion.getInstance().getCurrentProfile();
        }

        public final void setCurrentProfile(@Nullable Profile profile0) {
            ProfileManager.Companion.getInstance().setCurrentProfile(profile0);
        }
    }

    @NotNull
    public static final Parcelable.Creator CREATOR = null;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String FIRST_NAME_KEY = "first_name";
    @NotNull
    private static final String ID_KEY = "id";
    @NotNull
    private static final String LAST_NAME_KEY = "last_name";
    @NotNull
    private static final String LINK_URI_KEY = "link_uri";
    @NotNull
    private static final String MIDDLE_NAME_KEY = "middle_name";
    @NotNull
    private static final String NAME_KEY = "name";
    @NotNull
    private static final String PICTURE_URI_KEY = "picture_uri";
    private static final String TAG;
    @Nullable
    private final String firstName;
    @Nullable
    private final String id;
    @Nullable
    private final String lastName;
    @Nullable
    private final Uri linkUri;
    @Nullable
    private final String middleName;
    @Nullable
    private final String name;
    @Nullable
    private final Uri pictureUri;

    static {
        Profile.Companion = new Companion(null);
        Profile.TAG = "Profile";
        Profile.CREATOR = new Profile.Companion.CREATOR.1();
    }

    private Profile(Parcel parcel0) {
        this.id = parcel0.readString();
        this.firstName = parcel0.readString();
        this.middleName = parcel0.readString();
        this.lastName = parcel0.readString();
        this.name = parcel0.readString();
        String s = parcel0.readString();
        Uri uri0 = null;
        this.linkUri = s == null ? null : Uri.parse(s);
        String s1 = parcel0.readString();
        if(s1 != null) {
            uri0 = Uri.parse(s1);
        }
        this.pictureUri = uri0;
    }

    public Profile(Parcel parcel0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(parcel0);
    }

    public Profile(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable Uri uri0) {
        this(s, s1, s2, s3, s4, uri0, null, 0x40, null);
    }

    public Profile(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable Uri uri0, @Nullable Uri uri1) {
        Validate.notNullOrEmpty(s, "id");
        this.id = s;
        this.firstName = s1;
        this.middleName = s2;
        this.lastName = s3;
        this.name = s4;
        this.linkUri = uri0;
        this.pictureUri = uri1;
    }

    public Profile(String s, String s1, String s2, String s3, String s4, Uri uri0, Uri uri1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, s1, s2, s3, s4, uri0, ((v & 0x40) == 0 ? uri1 : null));
    }

    public Profile(@NotNull JSONObject jSONObject0) {
        q.g(jSONObject0, "jsonObject");
        super();
        Uri uri0 = null;
        this.id = jSONObject0.optString("id", null);
        this.firstName = jSONObject0.optString("first_name", null);
        this.middleName = jSONObject0.optString("middle_name", null);
        this.lastName = jSONObject0.optString("last_name", null);
        this.name = jSONObject0.optString("name", null);
        String s = jSONObject0.optString("link_uri", null);
        this.linkUri = s == null ? null : Uri.parse(s);
        String s1 = jSONObject0.optString("picture_uri", null);
        if(s1 != null) {
            uri0 = Uri.parse(s1);
        }
        this.pictureUri = uri0;
    }

    public static final String access$getTAG$cp() [...] // 潜在的解密器

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    // 去混淆评级： 中等(73)
    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Profile ? (this.id == null && ((Profile)object0).id == null || q.b(this.id, ((Profile)object0).id)) && (this.firstName == null && ((Profile)object0).firstName == null || q.b(this.firstName, ((Profile)object0).firstName)) && (this.middleName == null && ((Profile)object0).middleName == null || q.b(this.middleName, ((Profile)object0).middleName)) && (this.lastName == null && ((Profile)object0).lastName == null || q.b(this.lastName, ((Profile)object0).lastName)) && (this.name == null && ((Profile)object0).name == null || q.b(this.name, ((Profile)object0).name)) && (this.linkUri == null && ((Profile)object0).linkUri == null || q.b(this.linkUri, ((Profile)object0).linkUri)) && (this.pictureUri == null && ((Profile)object0).pictureUri == null || q.b(this.pictureUri, ((Profile)object0).pictureUri)) : false;
    }

    public static final void fetchProfileForCurrentAccessToken() {
        Profile.Companion.fetchProfileForCurrentAccessToken();
    }

    @Nullable
    public static final Profile getCurrentProfile() {
        return Profile.Companion.getCurrentProfile();
    }

    @Nullable
    public final String getFirstName() {
        return this.firstName;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getLastName() {
        return this.lastName;
    }

    @Nullable
    public final Uri getLinkUri() {
        return this.linkUri;
    }

    @Nullable
    public final String getMiddleName() {
        return this.middleName;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Uri getPictureUri() {
        return this.pictureUri;
    }

    @NotNull
    public final Uri getProfilePictureUri(int v, int v1) {
        Uri uri0 = this.pictureUri;
        if(uri0 != null) {
            return uri0;
        }
        com.facebook.AccessToken.Companion accessToken$Companion0 = AccessToken.Companion;
        if(accessToken$Companion0.isCurrentAccessTokenActive()) {
            AccessToken accessToken0 = accessToken$Companion0.getCurrentAccessToken();
            return accessToken0 == null ? ImageRequest.Companion.getProfilePictureUri(this.id, v, v1, null) : ImageRequest.Companion.getProfilePictureUri(this.id, v, v1, accessToken0.getToken());
        }
        return ImageRequest.Companion.getProfilePictureUri(this.id, v, v1, "");
    }

    @Override
    public int hashCode() {
        int v = (this.id == null ? 0 : this.id.hashCode()) + 0x20F;
        String s = this.firstName;
        if(s != null) {
            v = v * 0x1F + s.hashCode();
        }
        String s1 = this.middleName;
        if(s1 != null) {
            v = v * 0x1F + s1.hashCode();
        }
        String s2 = this.lastName;
        if(s2 != null) {
            v = v * 0x1F + s2.hashCode();
        }
        String s3 = this.name;
        if(s3 != null) {
            v = v * 0x1F + s3.hashCode();
        }
        Uri uri0 = this.linkUri;
        if(uri0 != null) {
            v = v * 0x1F + uri0.hashCode();
        }
        return this.pictureUri == null ? v : this.pictureUri.hashCode() + v * 0x1F;
    }

    public static final void setCurrentProfile(@Nullable Profile profile0) {
        Profile.Companion.setCurrentProfile(profile0);
    }

    @Nullable
    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("id", this.id);
            jSONObject0.put("first_name", this.firstName);
            jSONObject0.put("middle_name", this.middleName);
            jSONObject0.put("last_name", this.lastName);
            jSONObject0.put("name", this.name);
            Uri uri0 = this.linkUri;
            if(uri0 != null) {
                jSONObject0.put("link_uri", uri0.toString());
            }
            Uri uri1 = this.pictureUri;
            if(uri1 != null) {
                jSONObject0.put("picture_uri", uri1.toString());
            }
            return jSONObject0;
        }
        catch(JSONException unused_ex) {
            return null;
        }
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.id);
        parcel0.writeString(this.firstName);
        parcel0.writeString(this.middleName);
        parcel0.writeString(this.lastName);
        parcel0.writeString(this.name);
        String s = null;
        parcel0.writeString((this.linkUri == null ? null : this.linkUri.toString()));
        Uri uri0 = this.pictureUri;
        if(uri0 != null) {
            s = uri0.toString();
        }
        parcel0.writeString(s);
    }
}

