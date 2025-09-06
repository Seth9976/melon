package com.kakaoent.trevi.ad.webview.helper;

import b2.c;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001C\u0010\u000B\u001A\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/helper/URLUtils;", "", "<init>", "()V", "", "urlStr", "", "isValidUrl", "(Ljava/lang/String;)Z", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "STRIP_URL_PATTERN", "Ljava/util/regex/Pattern;", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class URLUtils {
    @NotNull
    public static final URLUtils INSTANCE;
    private static final Pattern STRIP_URL_PATTERN;

    static {
        URLUtils.INSTANCE = new URLUtils();
        URLUtils.STRIP_URL_PATTERN = Pattern.compile("^http://(.*?)/?$");
    }

    public final boolean isValidUrl(@NotNull String s) {
        q.g(s, "urlStr");
        return c.b.matcher(s).matches() || c.a.matcher(s).matches();
    }
}

