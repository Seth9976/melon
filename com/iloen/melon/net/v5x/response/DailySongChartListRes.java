package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ChartSongInfoBase;
import com.iloen.melon.net.v4x.common.GenreMenuListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DailySongChartListRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class CHARTINFO extends LinkInfoBase {
            private static final long serialVersionUID = 0xE76AC94CCEBA7184L;

        }

        public static class CHARTLIST extends ChartSongInfoBase {
            private static final long serialVersionUID = 0xAB13E9B81A510871L;

        }

        public static class GNRMENULIST extends GenreMenuListInfoBase {
            private static final long serialVersionUID = 8043085870030112549L;

        }

        @b("CHARTINFO")
        public CHARTINFO chartInfo;
        @b("CHARTLIST")
        public ArrayList chartList;
        @b("GNRMENULIST")
        public ArrayList gnrmenuList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x3E6AB4325F79F102L;

        public RESPONSE() {
            this.gnrmenuList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xD3E00CFA81EDA5FFL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

