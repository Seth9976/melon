package com.kakaoent.trevi.ad.constants;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0005\u001A\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001A\u0004\b\n\u0010\b¨\u0006\u000B"}, d2 = {"Lcom/kakaoent/trevi/ad/constants/Properties;", "", "<init>", "()V", "", "logOn", "Z", "getLogOn$trevi_ad_android_sdk_release", "()Z", "canWebViewContentsDebug", "getCanWebViewContentsDebug$trevi_ad_android_sdk_release", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class Properties {
    @NotNull
    public static final Properties INSTANCE;
    private static final boolean canWebViewContentsDebug;
    private static final boolean logOn;

    static {
        String s2;
        Properties.INSTANCE = new Properties();
        String s = System.getProperty("LOG_ON");
        String s1 = null;
        if(s == null) {
            s2 = null;
        }
        else {
            s2 = s.toLowerCase(Locale.ROOT);
            q.f(s2, "toLowerCase(...)");
        }
        Properties.logOn = Boolean.parseBoolean(s2);
        String s3 = System.getProperty("WEBVIEW_CONTENTS_DEBUG");
        if(s3 != null) {
            s1 = s3.toLowerCase(Locale.ROOT);
            q.f(s1, "toLowerCase(...)");
        }
        Properties.canWebViewContentsDebug = Boolean.parseBoolean(s1);
    }

    public final boolean getCanWebViewContentsDebug$trevi_ad_android_sdk_release() [...] // 潜在的解密器

    public final boolean getLogOn$trevi_ad_android_sdk_release() [...] // 潜在的解密器
}

