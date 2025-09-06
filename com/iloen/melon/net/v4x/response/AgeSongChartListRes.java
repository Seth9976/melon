package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class AgeSongChartListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CHARTLIST extends SongInfoBase {
            @b("CURRANK")
            public String currentRank;
            @b("PASTRANK")
            public String pastRank;
            @b("RANKGAP")
            public String rankGap;
            @b("RANKTYPE")
            public String rankType;
            private static final long serialVersionUID = 0x3330A939C111F23CL;

        }

        public static class REVIEW implements Serializable {
            @b("REVIEWOPENTYPE")
            public String reviewOpenType;
            @b("REVIEWURL")
            public String reviewUrl;
            private static final long serialVersionUID = 0xD47EFB1997726A28L;

        }

        public static class YEARLIST implements Serializable {
            public static class SUBLIST implements Serializable {
                @b("NAME")
                public String name;
                private static final long serialVersionUID = 8868504366629002414L;
                @b("TYPE")
                public String type;
                @b("YEAR")
                public String year;

            }

            @b("NAME")
            public String name;
            private static final long serialVersionUID = 0xE5D1E1F4011FAFA5L;
            @b("SUBLIST")
            public ArrayList subList;

        }

        @b("CHARTLIST")
        public ArrayList chartList;
        @b("GENRECODE")
        public String genreCode;
        @b("GENRENAME")
        public String genreName;
        @b("HASMORE")
        public boolean hasMore;
        @b("REVIEW")
        public REVIEW review;
        private static final long serialVersionUID = 0xF44893BB04BB18CAL;
        @b("YEARLIST")
        public ArrayList yearlist;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDA6900BD83D8314AL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE ageSongChartListRes$RESPONSE0 = this.response;
        return ageSongChartListRes$RESPONSE0 != null ? ageSongChartListRes$RESPONSE0.chartList : null;
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

