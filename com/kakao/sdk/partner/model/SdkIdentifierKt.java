package com.kakao.sdk.partner.model;

import com.kakao.sdk.common.model.SdkIdentifier.Companion;
import com.kakao.sdk.common.model.SdkIdentifier;
import com.kakao.sdk.common.util.SdkLog;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0000\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"create", "Lcom/kakao/sdk/common/model/SdkIdentifier;", "Lcom/kakao/sdk/common/model/SdkIdentifier$Companion;", "infos", "", "", "partner-common_release"}, k = 2, mv = {1, 8, 0}, xi = 0x30)
public final class SdkIdentifierKt {
    @NotNull
    public static final SdkIdentifier create(@NotNull Companion sdkIdentifier$Companion0, @NotNull Map map0) {
        q.g(sdkIdentifier$Companion0, "<this>");
        q.g(map0, "infos");
        StringBuilder stringBuilder0 = new StringBuilder();
        for(Object object0: map0.entrySet()) {
            stringBuilder0.append(" " + ((String)((Map.Entry)object0).getKey()) + "/" + ((String)((Map.Entry)object0).getValue()));
        }
        String s = stringBuilder0.toString();
        q.f(s, "StringBuilder().apply {\n…       }\n    }.toString()");
        SdkLog.Companion.d(s);
        return new SdkIdentifier(s);
    }
}

