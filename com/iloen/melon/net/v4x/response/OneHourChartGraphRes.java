package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u000BH\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/net/v4x/response/OneHourChartGraphRes;", "Lcom/iloen/melon/net/v4x/response/ResponseV4Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v4x/response/OneHourChartGraphRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v4x/response/OneHourChartGraphRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v4x/response/OneHourChartGraphRes$RESPONSE;)V", "toString", "", "RESPONSE", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class OneHourChartGraphRes extends ResponseV4Res {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v4x/response/OneHourChartGraphRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\b\"\u0004\b\u000E\u0010\nR&\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR \u0010\u0012\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R \u0010\u001A\u001A\u0004\u0018\u00010\u001B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR \u0010 \u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016¨\u0006$"}, d2 = {"Lcom/iloen/melon/net/v4x/response/OneHourChartGraphRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "chartGraphList", "", "Lcom/iloen/melon/net/v4x/common/GraphDataListInfo;", "getChartGraphList", "()Ljava/util/List;", "setChartGraphList", "(Ljava/util/List;)V", "xLabels", "", "getXLabels", "setXLabels", "entChartXLagels", "getEntChartXLagels", "setEntChartXLagels", "rankDay", "getRankDay", "()Ljava/lang/String;", "setRankDay", "(Ljava/lang/String;)V", "rankHour", "getRankHour", "setRankHour", "chartInfo", "Lcom/melon/net/res/common/LinkInfoBase;", "getChartInfo", "()Lcom/melon/net/res/common/LinkInfoBase;", "setChartInfo", "(Lcom/melon/net/res/common/LinkInfoBase;)V", "standard", "getStandard", "setStandard", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v4x/response/OneHourChartGraphRes$RESPONSE$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.net.v4x.response.OneHourChartGraphRes.RESPONSE.Companion {
            private com.iloen.melon.net.v4x.response.OneHourChartGraphRes.RESPONSE.Companion() {
            }

            public com.iloen.melon.net.v4x.response.OneHourChartGraphRes.RESPONSE.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.net.v4x.response.OneHourChartGraphRes.RESPONSE.Companion Companion = null;
        @b("GRAPHDATALIST")
        @Nullable
        private List chartGraphList;
        @b("CHARTINFO")
        @Nullable
        private LinkInfoBase chartInfo;
        @b("ENTCHARTXCATE")
        @Nullable
        private List entChartXLagels;
        @b("RANKDAY")
        @Nullable
        private String rankDay;
        @b("RANKHOUR")
        @Nullable
        private String rankHour;
        private static final long serialVersionUID = 0xA8AE2C00C790A19AL;
        @b("STANDARD")
        @Nullable
        private String standard;
        @b("XCATE")
        @Nullable
        private List xLabels;

        static {
            RESPONSE.Companion = new com.iloen.melon.net.v4x.response.OneHourChartGraphRes.RESPONSE.Companion(null);
            RESPONSE.$stable = 8;
        }

        @Nullable
        public final List getChartGraphList() {
            return this.chartGraphList;
        }

        @Nullable
        public final LinkInfoBase getChartInfo() {
            return this.chartInfo;
        }

        @Nullable
        public final List getEntChartXLagels() {
            return this.entChartXLagels;
        }

        @Nullable
        public final String getRankDay() {
            return this.rankDay;
        }

        @Nullable
        public final String getRankHour() {
            return this.rankHour;
        }

        @Nullable
        public final String getStandard() {
            return this.standard;
        }

        @Nullable
        public final List getXLabels() {
            return this.xLabels;
        }

        public final void setChartGraphList(@Nullable List list0) {
            this.chartGraphList = list0;
        }

        public final void setChartInfo(@Nullable LinkInfoBase linkInfoBase0) {
            this.chartInfo = linkInfoBase0;
        }

        public final void setEntChartXLagels(@Nullable List list0) {
            this.entChartXLagels = list0;
        }

        public final void setRankDay(@Nullable String s) {
            this.rankDay = s;
        }

        public final void setRankHour(@Nullable String s) {
            this.rankHour = s;
        }

        public final void setStandard(@Nullable String s) {
            this.standard = s;
        }

        public final void setXLabels(@Nullable List list0) {
            this.xLabels = list0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @b("response")
    @Nullable
    private RESPONSE response;
    private static final long serialVersionUID = 0x28A0CDEA3EF51807L;

    static {
        OneHourChartGraphRes.Companion = new Companion(null);
        OneHourChartGraphRes.$stable = 8;
    }

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable RESPONSE oneHourChartGraphRes$RESPONSE0) {
        this.response = oneHourChartGraphRes$RESPONSE0;
    }

    @Override
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

