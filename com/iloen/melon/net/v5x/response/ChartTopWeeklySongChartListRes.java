package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ChartSongInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ChartTopWeeklySongChartListRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class CHARTINFO extends LinkInfoBase {
            private static final long serialVersionUID = 0x6D0AAC93BBC9721CL;

        }

        public static class CHARTLIST extends ChartSongInfoBase {
            private static final long serialVersionUID = 0x57BEB72970A6F5BBL;

        }

        public static class MUSICAWARD implements Serializable {
            public static class WEEKRANKLIST implements Serializable {
                @b("ARTISTID")
                public String artistId;
                @b("ARTISTIMG")
                public String artistImg;
                @b("ARTISTIMGLARGE")
                public String artistImgLarge;
                @b("ARTISTIMGSMALL")
                public String artistImgSmall;
                @b("ARTISTNAME")
                public String artistName;
                @b("CURRANK")
                public String curRank;
                private static final long serialVersionUID = 0x5674273FE098582EL;
                @b("SONGNAME")
                public String songName;
                @b("STARTMONTH")
                public String startMonth;
                @b("STARTWEEK")
                public String startWeek;
                @b("VOTEPER")
                public String votePer;

            }

            private static final long serialVersionUID = 0x372AAE0633F3EDF2L;
            @b("SUBTITLE")
            public String subTitle;
            @b("TITLE")
            public String title;
            @b("WEEKSTATUS")
            public String weekStatus;
            @b("WEEKRANKLIST")
            public ArrayList weekranklists;

        }

        public static class REVIEW implements Serializable {
            @b("REVIEWOPENTYPE")
            public String reviewOpenType;
            @b("REVIEWURL")
            public String reviewUrl;
            private static final long serialVersionUID = 0x93A87702FC5A2630L;

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("CHARTLIST")
        public ArrayList chartList;
        @b("CHARTINFO")
        public CHARTINFO chartinfo;
        @b("ENDDAY")
        public String endDay;
        @b("HASMORE")
        public boolean hasMore;
        @b("MUSICAWARD")
        public MUSICAWARD musicAward;
        @b("REVIEW")
        public REVIEW review;
        private static final long serialVersionUID = 0x2A3E65ACD5BE640AL;
        @b("STARTDAY")
        public String startDay;
        @b("STATUS")
        public String status;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x8C00E72650EF1FACL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

