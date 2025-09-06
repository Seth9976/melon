package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class ChartHitsEdgeSongChartListRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class CHARTINFO extends LinkInfoBase {
            private static final long serialVersionUID = 0x8F43628B40DBCF54L;

        }

        public static class HITSSONGLIST extends SongInfoBase {
            @b("CURRANK")
            public String currentRank;
            @b("PASTRANK")
            public String pastRank;
            @b("RANKGAP")
            public String rankGap;
            @b("RANKTYPE")
            public String rankType;
            private static final long serialVersionUID = 0x75BA92A28288D2FCL;

        }

        @b("CHARTINFO")
        public CHARTINFO chartInfo;
        @b("HITSSONGLIST")
        public ArrayList hitsSongList;
        @b("RANKDAY")
        public String rankDay;
        @b("RANKHOUR")
        public String rankHour;
        private static final long serialVersionUID = 0x2122A2E07A2DD719L;
        @b("STATUS")
        public String status;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x512CF75B5117198BL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

