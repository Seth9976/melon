package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ChartSongInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class ChartHot100ListRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class CHARTINFO extends LinkInfoBase {
            private static final long serialVersionUID = -7660774238073807109L;

        }

        public static class SONGLIST extends ChartSongInfoBase {
            private static final long serialVersionUID = 0x49DC33AD6A6328BAL;

        }

        @b("CHARTINFO")
        public CHARTINFO chartinfo;
        @b("RANKDAY")
        public String rankDay;
        @b("RANKHOUR")
        public String rankHour;
        private static final long serialVersionUID = 0x3F5389317EC21563L;
        @b("SONGLIST")
        public ArrayList songList;

        public RESPONSE() {
            this.songList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x97606511AA782143L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

