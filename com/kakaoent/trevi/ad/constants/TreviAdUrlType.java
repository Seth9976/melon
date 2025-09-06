package com.kakaoent.trevi.ad.constants;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000E\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\tj\u0002\b\nj\u0002\b\u000B¨\u0006\f"}, d2 = {"Lcom/kakaoent/trevi/ad/constants/TreviAdUrlType;", "", "urlData", "Lcom/kakaoent/trevi/ad/constants/UrlData;", "(Ljava/lang/String;ILcom/kakaoent/trevi/ad/constants/UrlData;)V", "getUrl", "", "type", "Lcom/kakaoent/trevi/ad/constants/ServerConfig;", "CASH_FRIENDS_TRACK_SERVER", "CASH_FRIENDS_APPLY_SERVER", "CASH_FRIENDS_IMP_SERVER", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public enum TreviAdUrlType {
    CASH_FRIENDS_TRACK_SERVER(new UrlData("https://track.cashfriends.io", "https://track-qa.cashfriends.io", "https://track-qa.cashfriends.io", "https://track-dev.cashfriends.io")),
    CASH_FRIENDS_APPLY_SERVER(new UrlData("https://apply.cashfriends.io", "https://apply-qa.cashfriends.io", "https://apply-qa.cashfriends.io", "https://apply-dev.cashfriends.io")),
    CASH_FRIENDS_IMP_SERVER(new UrlData("https://imp.cashfriends.io", "https://imp-qa.cashfriends.io", "https://imp-qa.cashfriends.io", " https://imp-dev.cashfriends.io"));

    private static final a $ENTRIES;
    private static final TreviAdUrlType[] $VALUES;
    @NotNull
    private final UrlData urlData;

    private static final TreviAdUrlType[] $values() [...] // Inlined contents

    static {
        TreviAdUrlType.$VALUES = arr_treviAdUrlType;
        q.g(arr_treviAdUrlType, "entries");
        TreviAdUrlType.$ENTRIES = new b(arr_treviAdUrlType);
    }

    private TreviAdUrlType(UrlData urlData0) {
        this.urlData = urlData0;
    }

    @NotNull
    public final String getUrl(@NotNull ServerConfig serverConfig0) {
        q.g(serverConfig0, "type");
        return this.urlData.getUrl(serverConfig0);
    }
}

