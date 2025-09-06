package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MelonTvVdoRelateContentsListRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class DJPLYLSTLIST extends DjPlayListInfoBase {
            private static final long serialVersionUID = -4107900895634757732L;

        }

        public static class MSTORYLIST implements Serializable {
            public static class LINK implements Serializable {
                @b("LINKTYPE")
                public String linkType;
                @b("LINKURL")
                public String linkUrl;
                private static final long serialVersionUID = 0x684E0C70E865310BL;

            }

            @b("LIKCNT")
            public String likeCnt;
            @b("LINK")
            public LINK link;
            @b("LISTIMG")
            public String listImg;
            @b("MSTORYSEQ")
            public String mStorySeq;
            @b("MSTORYTITLE")
            public String mStoryTitle;
            @b("READCNT")
            public String readCnt;
            @b("RSRVDATE")
            public String rsrvDate;
            private static final long serialVersionUID = -7240532506038253646L;

            public MSTORYLIST() {
                this.mStorySeq = "";
                this.mStoryTitle = "";
                this.rsrvDate = "";
                this.listImg = "";
                this.likeCnt = "";
                this.readCnt = "";
            }
        }

        public static class SONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 0x6FB531B737147D6EL;

            @Override  // com.melon.net.res.common.SongInfoBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class STORYLIST implements Serializable {
            @b("ARTISTLIST")
            public ArrayList artistList;
            @b("COMMENTCNT")
            public String commentCnt;
            @b("CONTSID")
            public String contsId;
            @b("CONTSIMG")
            public String contsImg;
            @b("CONTSNAME")
            public String contsName;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("LIKECNT")
            public String likeCnt;
            private static final long serialVersionUID = 0x51822C5DFC2137EDL;

        }

        public static class TICKETLIST extends BannerBase {
            public static class ARTISTLIST extends ArtistsInfoBase {
                @b("ARTISTIMGURL")
                public String artistImgUrl;
                @b("ARTISTROLENAME")
                public String artistRoleName;
                private static final long serialVersionUID = 0x684E0C70E865310BL;

            }

            @b("ARTISTLIST")
            public ArrayList artistList;
            @b("ENDDT")
            public String endDate;
            @b("PLACENAME")
            public String placeName;
            @b("POSTERIMG")
            public String posterImg;
            @b("PRODSEQ")
            public String prodSeq;
            private static final long serialVersionUID = 0xEF835DE0F19D368CL;
            @b("STARTDT")
            public String startDate;

        }

        @b("DJPLYLSTLIST")
        public ArrayList djplylstList;
        @b("MSTORYLIST")
        public ArrayList mstoryList;
        private static final long serialVersionUID = 0x9061479DCC58B431L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("STORYLIST")
        public ArrayList storyList;
        @b("TICKETLIST")
        public ArrayList ticketList;

        public RESPONSE() {
            this.songList = null;
            this.mstoryList = null;
            this.djplylstList = null;
            this.ticketList = null;
            this.storyList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xF47AFF0B1ACF86EFL;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }
}

