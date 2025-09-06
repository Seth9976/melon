package com.kakaoent.trevi.ad.constants;

import java.util.regex.Pattern;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/kakaoent/trevi/ad/constants/UrlPatterns;", "", "()V", "ACCEPTED_URI_SCHEMA", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getACCEPTED_URI_SCHEMA", "()Ljava/util/regex/Pattern;", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class UrlPatterns {
    private static final Pattern ACCEPTED_URI_SCHEMA;
    @NotNull
    public static final UrlPatterns INSTANCE;

    static {
        UrlPatterns.INSTANCE = new UrlPatterns();
        UrlPatterns.ACCEPTED_URI_SCHEMA = Pattern.compile("(?i)((?:http|https|file|market):\\/\\/|(?:inline|data|about|content|javascript):)(.*)");
    }

    public final Pattern getACCEPTED_URI_SCHEMA() {
        return UrlPatterns.ACCEPTED_URI_SCHEMA;
    }
}

