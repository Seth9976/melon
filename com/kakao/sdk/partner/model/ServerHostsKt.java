package com.kakao.sdk.partner.model;

import com.kakao.sdk.common.model.ServerHosts.Companion;
import com.kakao.sdk.common.model.ServerHosts;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004¨\u0006\u0005"}, d2 = {"withPhase", "Lcom/kakao/sdk/common/model/ServerHosts;", "Lcom/kakao/sdk/common/model/ServerHosts$Companion;", "phase", "Lcom/kakao/sdk/partner/model/KakaoPhase;", "partner-common_release"}, k = 2, mv = {1, 8, 0}, xi = 0x30)
public final class ServerHostsKt {
    @NotNull
    public static final ServerHosts withPhase(@NotNull Companion serverHosts$Companion0, @NotNull KakaoPhase kakaoPhase0) {
        q.g(serverHosts$Companion0, "<this>");
        q.g(kakaoPhase0, "phase");
        return new PhasedServerHosts(kakaoPhase0);
    }
}

