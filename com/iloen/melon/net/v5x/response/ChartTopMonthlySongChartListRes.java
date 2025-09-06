package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ChartSongInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class ChartTopMonthlySongChartListRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class CHARTINFO extends LinkInfoBase {
            private static final long serialVersionUID = 0xD03C278F5054E757L;

        }

        public static class CHARTLIST extends ChartSongInfoBase {
            private static final long serialVersionUID = 0x17CB8FB86466EA02L;

        }

        @b("CHARTLIST")
        public ArrayList chartList;
        @b("CHARTINFO")
        public CHARTINFO chartinfo;
        @b("ENDDAY")
        public String endDay;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xEED9E2180C59809BL;
        @b("STARTDAY")
        public String startDay;
        @b("STATUS")
        public String status;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xE290B80993A0EFB6L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

