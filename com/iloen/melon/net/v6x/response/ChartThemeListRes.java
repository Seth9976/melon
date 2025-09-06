package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ChartThemeListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CHARTINFO extends LinkInfoBase {
            private static final long serialVersionUID = 0x82A329AD07F342C5L;

        }

        public static class THEMEINFO implements Serializable {
            public static class THEMELIST extends DjPlayListInfoBase {
                @b("DJPLYLSTSUMM")
                public String djplylstSumm;
                private static final long serialVersionUID = 0x64CAC10AF54515ADL;

            }

            @b("HASMORE")
            public boolean hasMore;
            private static final long serialVersionUID = 0x32332B83434E58F3L;
            @b("THEMELIST")
            public List themeList;
            @b("THEMEMANAGESEQ")
            public String themeManageSeq;
            @b("THEMEMANAGETITLE")
            public String themeManageTitle;

        }

        @b("CHARTINFO")
        public CHARTINFO chartInfo;
        private static final long serialVersionUID = 0x38582607C0C9FC7CL;
        @b("THEMEINFO")
        public THEMEINFO themeInfo;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x43343ED88F7C9FE5L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE chartThemeListRes$RESPONSE0 = this.response;
        if(chartThemeListRes$RESPONSE0 != null) {
            THEMEINFO chartThemeListRes$RESPONSE$THEMEINFO0 = chartThemeListRes$RESPONSE0.themeInfo;
            if(chartThemeListRes$RESPONSE$THEMEINFO0 != null) {
                return chartThemeListRes$RESPONSE$THEMEINFO0.themeList;
            }
        }
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response != null && this.response.themeInfo.hasMore;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

