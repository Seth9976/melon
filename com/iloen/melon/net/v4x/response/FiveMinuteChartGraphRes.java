package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u000BH\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/net/v4x/response/FiveMinuteChartGraphRes;", "Lcom/iloen/melon/net/v4x/response/ResponseV4Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v4x/response/FiveMinuteChartGraphRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v4x/response/FiveMinuteChartGraphRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v4x/response/FiveMinuteChartGraphRes$RESPONSE;)V", "toString", "", "RESPONSE", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FiveMinuteChartGraphRes extends ResponseV4Res {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v4x/response/FiveMinuteChartGraphRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0007\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R&\u0010\u0011\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000E\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR \u0010\u0017\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/net/v4x/response/FiveMinuteChartGraphRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "fiveTime", "", "getFiveTime", "()Ljava/lang/String;", "setFiveTime", "(Ljava/lang/String;)V", "fiveChartGraphList", "", "Lcom/iloen/melon/net/v4x/common/GraphDataListInfo;", "getFiveChartGraphList", "()Ljava/util/List;", "setFiveChartGraphList", "(Ljava/util/List;)V", "xLabels", "getXLabels", "setXLabels", "rankDay", "getRankDay", "setRankDay", "rankHour", "getRankHour", "setRankHour", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v4x/response/FiveMinuteChartGraphRes$RESPONSE$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.net.v4x.response.FiveMinuteChartGraphRes.RESPONSE.Companion {
            private com.iloen.melon.net.v4x.response.FiveMinuteChartGraphRes.RESPONSE.Companion() {
            }

            public com.iloen.melon.net.v4x.response.FiveMinuteChartGraphRes.RESPONSE.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.net.v4x.response.FiveMinuteChartGraphRes.RESPONSE.Companion Companion = null;
        @b("GRAPHDATALIST")
        @Nullable
        private List fiveChartGraphList;
        @b("FIVETIME")
        @Nullable
        private String fiveTime;
        @b("RANKDAY")
        @Nullable
        private String rankDay;
        @b("RANKHOUR")
        @Nullable
        private String rankHour;
        private static final long serialVersionUID = 0xA8AE2C00C790A19AL;
        @b("XCATE")
        @Nullable
        private List xLabels;

        static {
            RESPONSE.Companion = new com.iloen.melon.net.v4x.response.FiveMinuteChartGraphRes.RESPONSE.Companion(null);
            RESPONSE.$stable = 8;
        }

        @Nullable
        public final List getFiveChartGraphList() {
            return this.fiveChartGraphList;
        }

        @Nullable
        public final String getFiveTime() {
            return this.fiveTime;
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
        public final List getXLabels() {
            return this.xLabels;
        }

        public final void setFiveChartGraphList(@Nullable List list0) {
            this.fiveChartGraphList = list0;
        }

        public final void setFiveTime(@Nullable String s) {
            this.fiveTime = s;
        }

        public final void setRankDay(@Nullable String s) {
            this.rankDay = s;
        }

        public final void setRankHour(@Nullable String s) {
            this.rankHour = s;
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
        FiveMinuteChartGraphRes.Companion = new Companion(null);
        FiveMinuteChartGraphRes.$stable = 8;
    }

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable RESPONSE fiveMinuteChartGraphRes$RESPONSE0) {
        this.response = fiveMinuteChartGraphRes$RESPONSE0;
    }

    @Override
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

