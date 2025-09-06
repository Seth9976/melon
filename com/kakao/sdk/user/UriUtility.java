package com.kakao.sdk.user;

import android.net.Uri.Builder;
import android.net.Uri;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ServerHosts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\bJ=\u0010\u000B\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\b2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000F\u001A\u00020\b2\b\b\u0002\u0010\u0010\u001A\u00020\b¢\u0006\u0002\u0010\u0011R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/kakao/sdk/user/UriUtility;", "", "hosts", "Lcom/kakao/sdk/common/model/ServerHosts;", "(Lcom/kakao/sdk/common/model/ServerHosts;)V", "kpidtUrl", "Landroid/net/Uri;", "agt", "", "continueUrl", "appKey", "shippingAddressUrl", "path", "addressId", "", "ka", "returnUrl", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class UriUtility {
    @NotNull
    private final ServerHosts hosts;

    public UriUtility() {
        this(null, 1, null);
    }

    public UriUtility(@NotNull ServerHosts serverHosts0) {
        q.g(serverHosts0, "hosts");
        super();
        this.hosts = serverHosts0;
    }

    public UriUtility(ServerHosts serverHosts0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            serverHosts0 = KakaoSdk.INSTANCE.getHosts();
        }
        this(serverHosts0);
    }

    @NotNull
    public final Uri kpidtUrl(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        q.g(s, "agt");
        q.g(s1, "continueUrl");
        q.g(s2, "appKey");
        Uri uri0 = new Uri.Builder().scheme("https").authority("apps.kakao.com").path("/auth/kpidt").appendQueryParameter("app_key", s2).appendQueryParameter("agt", s).appendQueryParameter("continue", s1).build();
        q.f(uri0, "Builder()\n        .schem…inueUrl)\n        .build()");
        return uri0;
    }

    public static Uri kpidtUrl$default(UriUtility uriUtility0, String s, String s1, String s2, int v, Object object0) {
        if((v & 4) != 0) {
            s2 = KakaoSdk.INSTANCE.getAppKey();
        }
        return uriUtility0.kpidtUrl(s, s1, s2);
    }

    @NotNull
    public final Uri shippingAddressUrl(@NotNull String s, @Nullable Long long0, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "path");
        q.g(s1, "appKey");
        q.g(s2, "ka");
        q.g(s3, "returnUrl");
        Uri.Builder uri$Builder0 = new Uri.Builder().scheme("https").authority("apps.kakao.com").path(s).appendQueryParameter("app_key", s1).appendQueryParameter("ka", s2).appendQueryParameter("return_url", s3).appendQueryParameter("enable_back_button", "false");
        if(long0 != null) {
            uri$Builder0.appendQueryParameter("address_id", String.valueOf(long0.longValue()));
        }
        Uri uri0 = uri$Builder0.build();
        q.f(uri0, "Builder()\n        .schem…       }\n        .build()");
        return uri0;
    }

    public static Uri shippingAddressUrl$default(UriUtility uriUtility0, String s, Long long0, String s1, String s2, String s3, int v, Object object0) {
        if((v & 2) != 0) {
            long0 = null;
        }
        if((v & 4) != 0) {
            s1 = KakaoSdk.INSTANCE.getAppKey();
        }
        if((v & 8) != 0) {
            s2 = KakaoSdk.INSTANCE.getKaHeader();
        }
        if((v & 16) != 0) {
            s3 = e.h(KakaoSdk.INSTANCE.getApplicationContextInfo().getCustomScheme(), "://address");
        }
        return uriUtility0.shippingAddressUrl(s, long0, s1, s2, s3);
    }
}

