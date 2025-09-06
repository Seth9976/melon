package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class HourlyChartListRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class CHARTINFO extends LinkInfoBase {
            private static final long serialVersionUID = 0x1C634C803EDFF97BL;

        }

        public static class CHARTLIST extends SongInfoBase {
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
        @b("CHARTLIST")
        public ArrayList chartList;
        @b("HASMORE")
        public boolean hasMore;
        @b("RANKDAY")
        public String rankDAy;
        @b("RANKHOUR")
        public String rankHour;
        private static final long serialVersionUID = 0x31D6D4DB6043974BL;

        public RESPONSE() {
            this.chartList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3072EC2AE8F2B835L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

