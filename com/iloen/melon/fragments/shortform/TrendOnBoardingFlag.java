package com.iloen.melon.fragments.shortform;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendOnBoardingFlag;", "", "<init>", "()V", "flag", "", "getFlag", "()Z", "setFlag", "(Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TrendOnBoardingFlag {
    public static final int $stable;
    @NotNull
    public static final TrendOnBoardingFlag INSTANCE;
    private static boolean flag;

    static {
        TrendOnBoardingFlag.INSTANCE = new TrendOnBoardingFlag();
        TrendOnBoardingFlag.$stable = 8;
    }

    public final boolean getFlag() [...] // 潜在的解密器

    public final void setFlag(boolean z) {
        TrendOnBoardingFlag.flag = z;
    }
}

