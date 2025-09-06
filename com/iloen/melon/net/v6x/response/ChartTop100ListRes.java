package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ChartSongInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class ChartTop100ListRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class CHARTINFO extends LinkInfoBase {
            private static final long serialVersionUID = 0x9DEB55333441FD7CL;

        }

        public static class SONGLIST extends ChartSongInfoBase {
            private static final long serialVersionUID = 0x20D6F5429D30C95CL;

        }

        public static class STATSELEMENTS extends StatsElementsBase {
            private static final long serialVersionUID = 0x8788162E1AFA1F96L;

        }

        @b("CHARTINFO")
        public CHARTINFO chartinfo;
        @b("HASMORE")
        public boolean hasMore;
        @b("RANKDAY")
        public String rankDay;
        @b("RANKHOUR")
        public String rankHour;
        private static final long serialVersionUID = 0x4DF5C26EBE22AE9BL;
        @b("SONGLIST")
        public ArrayList songList;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;

        public RESPONSE() {
            this.songList = null;
            this.statsElements = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xBEC93AE280137451L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

