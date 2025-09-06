package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class ArtistChartListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CHARTINFO implements Serializable {
            @b("OPENLINK")
            public String openLink;
            @b("OPENTYPE")
            public String openType;
            private static final long serialVersionUID = 0x3330A939C111F23CL;

        }

        public static class CHARTLIST implements Serializable {
            @b("AREATYPE")
            public String areaType;
            @b("ARTISTID")
            public String artistId;
            @b("ARTISTIMG")
            public String artistImg;
            @b("ARTISTNAME")
            public String artistName;
            @b("CHNLSEQ")
            public String chnlSeq;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("CURRANK")
            public String currRank;
            @b("FANIDX")
            public String fanIdx;
            @b("INCREMFANCNT")
            public String incremFanCnt;
            @b("INCREMTYPE")
            public String incremType;
            public String isFan;
            @b("LIKEIDX")
            public String likeIdx;
            @b("MVIDX")
            public String mvIdx;
            @b("PASTRANK")
            public String pastRank;
            @b("PASTWEEKRANK")
            public String pastWeekRank;
            @b("PHOTOIDX")
            public String photoIdx;
            @b("RANKGAP")
            public String rankGap;
            @b("RANKTYPE")
            public String rankType;
            private static final long serialVersionUID = 0x3330A939C111F23CL;
            @b("SONGIDX")
            public String songIdx;
            @b("TOCIDX")
            public String tocIdx;
            @b("TOPRANK")
            public String topRank;
            @b("TOTFANCNT")
            public String totFanCnt;

            public CHARTLIST() {
                this.isFan = "N";
            }
        }

        public static class SEARCHTYPELIST implements Serializable {
            private static final long serialVersionUID = 0x3330A939C111F23CL;
            @b("TYPECODE")
            public String typeCode;
            @b("TYPECODENAME")
            public String typeCodeName;

        }

        @b("CHARTINFO")
        public CHARTINFO chartInfo;
        @b("CHARTLIST")
        public ArrayList chartList;
        @b("HASMORE")
        public boolean hasMore;
        @b("RANKDAY")
        public String rankDay;
        @b("SEARCHTYPELIST")
        public ArrayList searchtypelists;
        private static final long serialVersionUID = 0xF44893BB04BB18CAL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDA6900BD83D8314AL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE artistChartListRes$RESPONSE0 = this.response;
        return artistChartListRes$RESPONSE0 != null ? artistChartListRes$RESPONSE0.chartList : null;
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

