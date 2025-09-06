package com.iloen.melon.net.v6x.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/net/v6x/common/TopicContentsTypeCode;", "", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TopicContentsTypeCode {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000F\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0014\u0010\f\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007R\u0014\u0010\u000E\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0007R\u0014\u0010\u0010\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/net/v6x/common/TopicContentsTypeCode$Companion;", "", "<init>", "()V", "IMAGE", "", "getIMAGE", "()Ljava/lang/String;", "TEXT", "getTEXT", "MV", "getMV", "SONG", "getSONG", "LINK", "getLINK", "YOUTUBE", "getYOUTUBE", "UNKNOWN", "getUNKNOWN", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getIMAGE() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        @NotNull
        public final String getLINK() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        @NotNull
        public final String getMV() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        @NotNull
        public final String getSONG() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        @NotNull
        public final String getTEXT() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        @NotNull
        public final String getUNKNOWN() {
            return "T10099";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getYOUTUBE() [...] // 潜在的解密器
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final String IMAGE;
    @NotNull
    private static final String LINK;
    @NotNull
    private static final String MV;
    @NotNull
    private static final String SONG;
    @NotNull
    private static final String TEXT;
    @NotNull
    private static final String UNKNOWN;
    @NotNull
    private static final String YOUTUBE;

    static {
        TopicContentsTypeCode.Companion = new Companion(null);
        TopicContentsTypeCode.IMAGE = "T10001";
        TopicContentsTypeCode.TEXT = "T10002";
        TopicContentsTypeCode.MV = "T10003";
        TopicContentsTypeCode.SONG = "T10004";
        TopicContentsTypeCode.LINK = "T10006";
        TopicContentsTypeCode.YOUTUBE = "T10007";
        TopicContentsTypeCode.UNKNOWN = "T10099";
    }

    public static final String access$getIMAGE$cp() [...] // 潜在的解密器

    public static final String access$getLINK$cp() [...] // 潜在的解密器

    public static final String access$getMV$cp() [...] // 潜在的解密器

    public static final String access$getSONG$cp() [...] // 潜在的解密器

    public static final String access$getTEXT$cp() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public static final String access$getUNKNOWN$cp() [...] // 潜在的解密器

    public static final String access$getYOUTUBE$cp() [...] // 潜在的解密器
}

