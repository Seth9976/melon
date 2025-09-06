package com.kakao.sdk.common.model;

import Gd.e;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.kakao.sdk.common.KakaoSdk.Type;
import com.kakao.sdk.common.util.Utility;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\rR\u0014\u0010\u0005\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000FR\u0011\u0010\u0012\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u000FR\u0014\u0010\u0016\u001A\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u000FR\u000E\u0010\u001C\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\'\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b(\u0010\u000FR\u0014\u0010)\u001A\u00020$8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b*\u0010+R\u0011\u0010,\u001A\u00020&8F¢\u0006\u0006\u001A\u0004\b-\u0010.R\u0014\u0010/\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b0\u0010\u000F¨\u00061"}, d2 = {"Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "Lcom/kakao/sdk/common/model/ContextInfo;", "context", "Landroid/content/Context;", "appKey", "", "customScheme", "sdkType", "Lcom/kakao/sdk/common/KakaoSdk$Type;", "sdkIdentifier", "Lcom/kakao/sdk/common/model/SdkIdentifier;", "customPackageName", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/common/KakaoSdk$Type;Lcom/kakao/sdk/common/model/SdkIdentifier;Ljava/lang/String;)V", "getAppKey", "()Ljava/lang/String;", "appVer", "getAppVer", "applicationContext", "getApplicationContext", "()Landroid/content/Context;", "getCustomScheme", "extras", "Lkotlinx/serialization/json/JsonObject;", "getExtras", "()Lkotlinx/serialization/json/JsonObject;", "kaHeader", "getKaHeader", "mAppVer", "mApplicationContext", "mClientId", "mCustomScheme", "mExtras", "mKaHeader", "mKeyHash", "mSalt", "", "mSharedPreferences", "Landroid/content/SharedPreferences;", "redirectUri", "getRedirectUri", "salt", "getSalt", "()[B", "sharedPreferences", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "signingKeyHash", "getSigningKeyHash", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ApplicationContextInfo implements ApplicationInfo, ContextInfo {
    @NotNull
    private final String mAppVer;
    @NotNull
    private final Context mApplicationContext;
    @NotNull
    private final String mClientId;
    @NotNull
    private final String mCustomScheme;
    @NotNull
    private final JsonObject mExtras;
    @NotNull
    private final String mKaHeader;
    @NotNull
    private final String mKeyHash;
    @NotNull
    private final byte[] mSalt;
    @NotNull
    private final SharedPreferences mSharedPreferences;

    public ApplicationContextInfo(@NotNull Context context0, @NotNull String s, @NotNull String s1, @NotNull Type kakaoSdk$Type0, @NotNull SdkIdentifier sdkIdentifier0, @Nullable String s2) {
        q.g(context0, "context");
        q.g(s, "appKey");
        q.g(s1, "customScheme");
        q.g(kakaoSdk$Type0, "sdkType");
        q.g(sdkIdentifier0, "sdkIdentifier");
        super();
        this.mClientId = s;
        this.mCustomScheme = s1;
        Utility utility0 = Utility.INSTANCE;
        this.mKaHeader = utility0.getKAHeader(context0, kakaoSdk$Type0, sdkIdentifier0, s2);
        this.mKeyHash = utility0.getKeyHash(context0);
        this.mExtras = utility0.getExtras(context0, kakaoSdk$Type0);
        SharedPreferences sharedPreferences0 = context0.getSharedPreferences(s, 0);
        q.f(sharedPreferences0, "context.getSharedPrefere…ey, Context.MODE_PRIVATE)");
        this.mSharedPreferences = sharedPreferences0;
        String s3 = Build.VERSION.SDK_INT < 33 ? context0.getPackageManager().getPackageInfo("com.iloen.melon", 0).versionName : e.a(context0.getPackageManager(), "com.iloen.melon", e.b()).versionName;
        if(s3 == null) {
            s3 = "";
        }
        this.mAppVer = s3;
        this.mSalt = utility0.androidId(context0);
        Context context1 = context0.getApplicationContext();
        q.f(context1, "context.applicationContext");
        this.mApplicationContext = context1;
    }

    public ApplicationContextInfo(Context context0, String s, String s1, Type kakaoSdk$Type0, SdkIdentifier sdkIdentifier0, String s2, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 0x20) != 0) {
            s2 = null;
        }
        this(context0, s, s1, kakaoSdk$Type0, sdkIdentifier0, s2);
    }

    @Override  // com.kakao.sdk.common.model.ApplicationInfo
    @NotNull
    public String getAppKey() {
        return this.mClientId;
    }

    @Override  // com.kakao.sdk.common.model.ContextInfo
    @NotNull
    public String getAppVer() {
        return this.mAppVer;
    }

    @NotNull
    public final Context getApplicationContext() {
        return this.mApplicationContext;
    }

    @Override  // com.kakao.sdk.common.model.ApplicationInfo
    @NotNull
    public String getCustomScheme() {
        return this.mCustomScheme;
    }

    @Override  // com.kakao.sdk.common.model.ContextInfo
    @NotNull
    public JsonObject getExtras() {
        return this.mExtras;
    }

    @Override  // com.kakao.sdk.common.model.ContextInfo
    @NotNull
    public String getKaHeader() {
        return this.mKaHeader;
    }

    @Override  // com.kakao.sdk.common.model.ApplicationInfo
    @NotNull
    public String getRedirectUri() {
        return this.mCustomScheme + "://oauth";
    }

    @Override  // com.kakao.sdk.common.model.ContextInfo
    @NotNull
    public byte[] getSalt() {
        return this.mSalt;
    }

    @NotNull
    public final SharedPreferences getSharedPreferences() {
        return this.mSharedPreferences;
    }

    @Override  // com.kakao.sdk.common.model.ContextInfo
    @NotNull
    public String getSigningKeyHash() {
        return this.mKeyHash;
    }
}

