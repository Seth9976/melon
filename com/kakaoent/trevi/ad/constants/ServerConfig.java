package com.kakaoent.trevi.ad.constants;

import com.kakaoent.trevi.ad.TreviAd;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001A\u00020\u0003R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\f¨\u0006\u000E"}, d2 = {"Lcom/kakaoent/trevi/ad/constants/ServerConfig;", "", "env", "", "offerWallHostPostfix", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getEnv$trevi_ad_android_sdk_release", "()Ljava/lang/String;", "getOfferWallUrl", "PRODUCTION", "STAGE", "QA", "DEBUG", "Companion", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public enum ServerConfig {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/kakaoent/trevi/ad/constants/ServerConfig$Companion;", "", "()V", "format", "", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    PRODUCTION("real", ""),
    STAGE("real", "-qa"),
    QA("sandbox", "-qa"),
    DEBUG("dev", "-dev");

    private static final a $ENTRIES;
    private static final ServerConfig[] $VALUES;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String env;
    @NotNull
    private final String offerWallHostPostfix;

    private static final ServerConfig[] $values() [...] // Inlined contents

    static {
        ServerConfig.$VALUES = arr_serverConfig;
        q.g(arr_serverConfig, "entries");
        ServerConfig.$ENTRIES = new b(arr_serverConfig);
        ServerConfig.Companion = new Companion(null);
    }

    private ServerConfig(String s1, String s2) {
        this.env = s1;
        this.offerWallHostPostfix = s2;
    }

    @NotNull
    public final String getEnv$trevi_ad_android_sdk_release() {
        return this.env;
    }

    @NotNull
    public final String getOfferWallUrl() {
        String s = TreviAd.INSTANCE.getServiceCode$trevi_ad_android_sdk_release();
        return Util.format("https://cashfriends%s.kakaopage.com/%s/offerwall", new Object[]{this.offerWallHostPostfix, s});
    }
}

