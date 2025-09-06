package com.melon.net.res.v3;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toCmtContentsSummary", "Lcom/melon/net/res/v3/CmtContentsSummary;", "Lcom/melon/net/res/v3/InformCmtContsSummRes$Result$CmtContsSumm;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class InformCmtContsSummResKt {
    @NotNull
    public static final CmtContentsSummary toCmtContentsSummary(@NotNull CmtContsSumm informCmtContsSummRes$Result$CmtContsSumm0) {
        q.g(informCmtContsSummRes$Result$CmtContsSumm0, "<this>");
        return new CmtContentsSummary(informCmtContsSummRes$Result$CmtContsSumm0.getChnlSeq(), (informCmtContsSummRes$Result$CmtContsSumm0.getContsRefValue() == null ? "" : informCmtContsSummRes$Result$CmtContsSumm0.getContsRefValue()), informCmtContsSummRes$Result$CmtContsSumm0.getValidCmtCnt(), informCmtContsSummRes$Result$CmtContsSumm0.getHotFlag(), informCmtContsSummRes$Result$CmtContsSumm0.getNewFlag());
    }
}

