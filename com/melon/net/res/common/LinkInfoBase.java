package com.melon.net.res.common;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001A\u00020\u0005H\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R \u0010\r\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001A\u00020\u00148F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/melon/net/res/common/LinkInfoBase;", "Ljava/io/Serializable;", "<init>", "()V", "linkTitle", "", "getLinkTitle", "()Ljava/lang/String;", "setLinkTitle", "(Ljava/lang/String;)V", "linktype", "linkurl", "scheme", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "isLinkable", "", "()Z", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class LinkInfoBase implements Serializable {
    public static final int $stable = 8;
    @b(alternate = {"linkTitle"}, value = "LINKTITLE")
    @Nullable
    private String linkTitle;
    @b(alternate = {"linkType"}, value = "LINKTYPE")
    @Nullable
    public String linktype;
    @b(alternate = {"linkUrl"}, value = "LINKURL")
    @Nullable
    public String linkurl;
    @b(alternate = {"scheme"}, value = "SCHEME")
    @Nullable
    public String scheme;
    @b(alternate = {"statsElements"}, value = "STATSELEMENTS")
    @Nullable
    private StatsElementsBase statsElements;

    @Nullable
    public final String getLinkTitle() {
        return this.linkTitle;
    }

    @Nullable
    public final StatsElementsBase getStatsElements() {
        return this.statsElements;
    }

    public final boolean isLinkable() {
        return this.linktype != null && this.linktype.length() != 0 && !q.b(this.linktype, "NN");
    }

    public final void setLinkTitle(@Nullable String s) {
        this.linkTitle = s;
    }

    public final void setStatsElements(@Nullable StatsElementsBase statsElementsBase0) {
        this.statsElements = statsElementsBase0;
    }

    @Override
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

