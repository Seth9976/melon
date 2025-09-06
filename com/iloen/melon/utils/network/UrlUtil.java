package com.iloen.melon.utils.network;

import A8.M;
import android.net.Uri;
import android.text.TextUtils;
import com.iloen.melon.utils.log.LogU;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001A\u0004\u0018\u00010\u00052\b\u0010\b\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000B\u001A\u0004\u0018\u00010\u00022\b\u0010\b\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u0007J\u000F\u0010\u000E\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000E\u0010\u0007J\u000F\u0010\u000F\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000F\u0010\u0007J\u000F\u0010\u0010\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/utils/network/UrlUtil;", "", "Landroid/net/Uri;", "getMelonAppMarketUri", "()Landroid/net/Uri;", "", "getMelonAppMarketUrl", "()Ljava/lang/String;", "packageName", "getAppMarketUrl", "(Ljava/lang/String;)Ljava/lang/String;", "getAppMarketUri", "(Ljava/lang/String;)Landroid/net/Uri;", "getSignUpMembershipUrl", "getSearchMelonIdUrl", "getSearchMelonPasswordUrl", "getUpdateMelonPasswordUrl", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class UrlUtil {
    public static final int $stable;
    @NotNull
    public static final UrlUtil INSTANCE;

    static {
        UrlUtil.INSTANCE = new UrlUtil();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static String a(String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.Companion.e("UrlUtil", "Invalid url");
            return null;
        }
        return String.format("%s?ts=%s", Arrays.copyOf(new Object[]{s, System.currentTimeMillis()}, 2));
    }

    @Nullable
    public final Uri getAppMarketUri(@Nullable String s) {
        String s1 = this.getAppMarketUrl(s);
        if(TextUtils.isEmpty(s1)) {
            LogU.Companion.w("UrlUtil", "getAppMarketUri() invalid url");
            return null;
        }
        return Uri.parse(s1);
    }

    @Nullable
    public final String getAppMarketUrl(@Nullable String s) [...] // 潜在的解密器

    @Nullable
    public static final Uri getMelonAppMarketUri() {
        UrlUtil urlUtil0 = UrlUtil.INSTANCE;
        if(TextUtils.isEmpty(urlUtil0.getMelonAppMarketUrl())) {
            LogU.Companion.w("UrlUtil", "getMelonAppMarketUri() invalid url");
            return null;
        }
        return Uri.parse(urlUtil0.getMelonAppMarketUrl());
    }

    // 去混淆评级： 低(20)
    @Nullable
    public final String getMelonAppMarketUrl() {
        return "market://details?id=com.iloen.melon";
    }

    @Nullable
    public final String getSearchMelonIdUrl() {
        q.f(M.T, "MELON_URL_SEARCH_MELON_ID");
        return UrlUtil.a(M.T);
    }

    @Nullable
    public final String getSearchMelonPasswordUrl() {
        q.f(M.U, "MELON_URL_SEARCH_MELON_PW");
        return UrlUtil.a(M.U);
    }

    @Nullable
    public final String getSignUpMembershipUrl() {
        q.f(M.N, "MELON_URL_SIGN_UP_MEMBERSHIP");
        return UrlUtil.a(M.N);
    }

    @Nullable
    public final String getUpdateMelonPasswordUrl() {
        q.f(M.V, "MELON_URL_UPDATE_MELON_PW");
        return UrlUtil.a(M.V);
    }
}

