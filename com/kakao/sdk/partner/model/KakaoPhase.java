package com.kakao.sdk.partner.model;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.SerialName;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000B2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000BB\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/kakao/sdk/partner/model/KakaoPhase;", "", "phaseName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPhaseName", "()Ljava/lang/String;", "DEV", "SANDBOX", "CBT", "PRODUCTION", "Companion", "partner-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public enum KakaoPhase {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakao/sdk/partner/model/KakaoPhase$Companion;", "", "()V", "fromName", "Lcom/kakao/sdk/partner/model/KakaoPhase;", "value", "", "partner-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final KakaoPhase fromName(@NotNull String s) {
            q.g(s, "value");
            String s1 = s.toUpperCase(Locale.ROOT);
            q.f(s1, "toUpperCase(...)");
            return KakaoPhase.valueOf(s1);
        }
    }

    @SerialName("dev")
    DEV("dev"),
    @SerialName("sandbox")
    SANDBOX("sandbox"),
    @SerialName("cbt")
    CBT("cbt"),
    @SerialName("production")
    PRODUCTION("production");

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String phaseName;

    private static final KakaoPhase[] $values() [...] // Inlined contents

    static {
        KakaoPhase.Companion = new Companion(null);
    }

    private KakaoPhase(String s1) {
        this.phaseName = s1;
    }

    @NotNull
    public final String getPhaseName() {
        return this.phaseName;
    }
}

