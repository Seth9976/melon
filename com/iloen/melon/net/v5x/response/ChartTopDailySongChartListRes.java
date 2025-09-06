package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ChartSongInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class ChartTopDailySongChartListRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class CHARTINFO extends LinkInfoBase {
            private static final long serialVersionUID = 0xA50354FC08CA42FFL;

        }

        public static class CHARTLIST extends ChartSongInfoBase {
            private static final long serialVersionUID = 0xAA83CEC12C744F0EL;

        }

        @b("CHARTLIST")
        public ArrayList chartList;
        @b("CHARTINFO")
        public CHARTINFO chartinfo;
        @b("HASMORE")
        public boolean hasMore;
        @b("RANKDAY")
        public String rankDay;
        private static final long serialVersionUID = 0x4A8BADC28A4A8540L;
        @b("STATUS")
        public String status;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1AACEC11DFDE14C9L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

