package com.melon.net.res.common;

import S7.b;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/melon/net/res/common/ArtistPlayListWrapperInfoBase;", "Lcom/iloen/melon/net/v4x/common/ArtistPlayListInfoBase;", "<init>", "()V", "seriesThemeLogoImg", "", "getSeriesThemeLogoImg", "()Ljava/lang/String;", "setSeriesThemeLogoImg", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ArtistPlayListWrapperInfoBase extends ArtistPlayListInfoBase {
    public static final int $stable = 8;
    @b("SERIESTHEMELOGOIMG")
    @Nullable
    private String seriesThemeLogoImg;

    @Nullable
    public final String getSeriesThemeLogoImg() {
        return this.seriesThemeLogoImg;
    }

    public final void setSeriesThemeLogoImg(@Nullable String s) {
        this.seriesThemeLogoImg = s;
    }
}

