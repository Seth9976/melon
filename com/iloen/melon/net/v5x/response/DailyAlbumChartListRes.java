package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ChartAlbumInfoBase;
import com.iloen.melon.net.v4x.common.GenreMenuListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DailyAlbumChartListRes extends ResponseV5Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CHARTINFO extends LinkInfoBase {
            private static final long serialVersionUID = 0x8A55FAE889588D0AL;

        }

        public static class CHARTLIST extends ChartAlbumInfoBase {
            private static final long serialVersionUID = 0x3330A939C111F23CL;

        }

        public static class GNRMENULIST extends GenreMenuListInfoBase {
            private static final long serialVersionUID = 0x4E91347FFE520475L;

        }

        @b("CHARTINFO")
        public CHARTINFO chartInfo;
        @b("CHARTLIST")
        public ArrayList chartList;
        @b("ENDDAY")
        public String endDay;
        @b("GNRMENULIST")
        public ArrayList gnrmenuList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = -6736605000924163677L;
        @b("STARTDAY")
        public String startDay;

        public RESPONSE() {
            this.gnrmenuList = null;
            this.chartList = null;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x6F5DA6850F47CF67L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE dailyAlbumChartListRes$RESPONSE0 = this.response;
        return dailyAlbumChartListRes$RESPONSE0 != null ? dailyAlbumChartListRes$RESPONSE0.chartList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() [...] // 潜在的解密器

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response == null ? false : this.response.hasMore;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

