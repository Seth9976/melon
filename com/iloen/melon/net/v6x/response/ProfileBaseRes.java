package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v5x.response.CastInfoBase;
import com.melon.net.res.common.ArtistPlayListWrapperInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ProfileBaseRes extends ResponseBase {
    public static class CASTLIST implements Serializable {
        public static class SUBCONTENTLIST extends CastInfoBase {
            @b("CHNLSSEQ")
            public String chnlsSeq;
            @b("CREATORCONTSIDS")
            public String creatorContsIds;
            @b("CREATORCONTSTYPECODE")
            public String creatorContsTypeCode;
            @b("CREATORNAME")
            public String creatorName;
            @b("DISPSTARTDATE")
            public String dispStartDate;
            @b("DISPYN")
            public String dispYn;
            @b("IMGURL")
            public String imgUrl;
            @b("PROGTITLE")
            public String progTitle;
            @b("REGDATE")
            public String regDate;
            private static final long serialVersionUID = 0x1F6E7DC91C3045E5L;

            public SUBCONTENTLIST() {
                this.chnlsSeq = "";
                this.dispYn = "";
                this.regDate = "";
                this.dispStartDate = "";
                this.creatorContsTypeCode = "";
                this.creatorContsIds = "";
                this.progTitle = "";
                this.creatorName = "";
                this.imgUrl = "";
            }
        }

        private static final long serialVersionUID = 0x4A4BE5C90695D2DAL;
        @b("SUBCONTENTLIST")
        public ArrayList subContentList;
        @b("SUBCONTENTTITLE")
        public String subContentTitle;
        @b("SUBCONTENTTOTCNT")
        public String subContentTotCnt;

        public CASTLIST() {
            this.subContentTitle = "";
            this.subContentTotCnt = "";
            this.subContentList = null;
        }
    }

    public static class PLAYLIST implements Serializable {
        public static class com.iloen.melon.net.v6x.response.ProfileBaseRes.PLAYLIST.SUBCONTENTLIST extends ArtistPlayListWrapperInfoBase {
            private static final long serialVersionUID = 0x7225CD4F1F288589L;

        }

        private static final long serialVersionUID = 0x10F9E0ED6E580219L;
        @b("SUBCONTENTLIST")
        public ArrayList subContentList;
        @b("SUBCONTENTTITLE")
        public String subContentTitle;
        @b("SUBCONTENTTOTCNT")
        public String subContentTotCnt;

    }

    public static class SnsInfoBase implements Serializable {
        @b("DTLINFOCODE")
        public String dtlInfoCode;
        @b("DTLINFOCODESTR")
        public String dtlInfoCodeStr;
        @b("DTLINFODESC")
        public String dtlInfoDesc;
        @b("DTLINFOTYPE")
        public String dtlInfoType;
        @b("DTLINFOVAL")
        public String dtlInfoVal;
        @b("ISREPNT")
        public boolean isRepnt;
        @b("MEMBERKEY")
        public String memberKey;
        private static final long serialVersionUID = 0x11163FD3E676A415L;

        public SnsInfoBase() {
            this.memberKey = "";
            this.dtlInfoType = "";
            this.dtlInfoCode = "";
            this.dtlInfoCodeStr = "";
            this.dtlInfoVal = "";
            this.dtlInfoDesc = "";
            this.isRepnt = false;
        }
    }

    private static final long serialVersionUID = 0x793EC3A7FB4FC95FL;

}

