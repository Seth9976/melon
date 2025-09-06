package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class HotTrackListRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class GENRECODELIST implements Serializable {
            public static class GNRLIST implements Serializable {
                @b("GNRCODE")
                public String gnrCode;
                @b("GNRMENUSEQ")
                public String gnrMenuSeq;
                @b("GNRNAME")
                public String gnrName;
                @b("GNRNAMEFULL")
                public String gnrNameFull;
                @b("GNRNAMESIMPLE")
                public String gnrNameSimple;
                @b("MENUID")
                public String menuId;
                private static final long serialVersionUID = 0x23CF9D652EAC075AL;

            }

            @b("DISPORDER")
            public String dispOrder;
            @b("DISPYN")
            public String dispYn;
            @b("GNRLIST")
            public ArrayList gnrList;
            @b("GNRMENUSEQ")
            public String gnrMenuSeq;
            @b("MENUNAME")
            public String menuName;
            private static final long serialVersionUID = 0x338D2BFAB7C28E0FL;

        }

        public static class HOTTRACKCODES implements Serializable {
            @b("HOTTRACKCODE")
            public String hotTrackCode;
            @b("HOTTRACKCODENAME")
            public String hotTrackCodeName;
            private static final long serialVersionUID = 0x2648C784330A17D6L;

        }

        public static class TAGINFO implements Serializable {
            public static class TAGLIST extends TagInfoBase {
                @b("IMGPATH")
                public String imgPath;
                @b("LIKECNT")
                public String likeCnt;
                @b("PLYLSTCNT")
                public String plylStCnt;
                private static final long serialVersionUID = 0x9BDE7E8ABFF1A263L;

                public TAGLIST() {
                    this.plylStCnt = "";
                    this.likeCnt = "";
                    this.imgPath = "";
                }
            }

            @b("BOARDSEQ")
            public String boardSeq;
            private static final long serialVersionUID = -6645385052395520280L;
            @b("SETNO")
            public String setNo;
            @b("TAGLIST")
            public ArrayList tagList;

        }

        @b("CHARTLIST")
        public ArrayList chartList;
        @b("GENRECODELIST")
        public ArrayList genreCodeList;
        @b("HOTTRACKCODE")
        public String hotTrackCode;
        @b("HOTTRACKCODES")
        public ArrayList hotTrackCodes;
        @b("HOTTRACKTITLE")
        public String hotTrackTitle;
        private static final long serialVersionUID = 0xDC9869B787F370FFL;
        @b("TAGINFO")
        public ArrayList tagInfo;
        @b("TAGNAME")
        public String tagName;
        @b("TAGSEQ")
        public String tagSeq;

        public RESPONSE() {
            this.tagSeq = "";
            this.tagName = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x50743EB51C417E95L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

