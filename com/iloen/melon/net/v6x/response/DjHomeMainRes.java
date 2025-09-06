package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.response.DetailBaseRes.OPTION;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PLAYLIST;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.List;

public class DjHomeMainRes extends ResponseV6Res {
    public static class DJGUIDEBTNS implements Serializable {
        public static class SUBCONTENTLIST extends OPTION {
            private static final long serialVersionUID = 0xEFD26C4B10A2470BL;
            @b("TITLE")
            public String title;

        }

        private static final long serialVersionUID = 0x3CCB4142CC609B2L;
        @b("SUBCONTENTLIST")
        public List subContentList;
        @b("SUBCONTENTTITLE")
        public String subContentTitle;

    }

    public static class DjInfoBase implements Serializable {
        @b("FOLLOWERCNT")
        public String followerCnt;
        @b("ISMYFRIEND")
        public boolean isMyFriend;
        @b("ISOFFICIAL")
        public boolean isOfficial;
        @b("MEMBERDJICONTYPE")
        public String memberDjIconType;
        @b("MEMBERDJTYPE")
        public String memberDjType;
        @b("MEMBERNICKNAME")
        public String memberNickName;
        @b("MEMBERKEY")
        public String memberkey;
        @b("MYPAGEDESC")
        public String myPageDesc;
        @b("MYPAGEIMG")
        public String myPageImg;
        @b("OFFERINTRODCONT")
        public String offerIntrodCont;
        @b("OFFERTITLE")
        public String offerTitle;
        @b("PLYLSTCNT")
        public String plylstCnt;
        private static final long serialVersionUID = 0xE7B09D7166204E06L;

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class NEWDJ implements Serializable {
        public static class com.iloen.melon.net.v6x.response.DjHomeMainRes.NEWDJ.SUBCONTENTLIST extends DjInfoBase {
            private static final long serialVersionUID = 0xC69ACB89F97AC6BBL;

        }

        private static final long serialVersionUID = -4957700749007744462L;
        @b("SUBCONTENTLIST")
        public List subContentList;
        @b("SUBCONTENTTITLE")
        public String subContentTitle;

    }

    public static class OFFICIALSERIESPLAYLISTS implements Serializable {
        public static class com.iloen.melon.net.v6x.response.DjHomeMainRes.OFFICIALSERIESPLAYLISTS.SUBCONTENTLIST extends PLAYLIST {
            private static final long serialVersionUID = 0x3FD9C6F81F80E309L;
            @b("SERIESTHEMELOGOIMG")
            public String seriesThemeLogoImg;

        }

        @b("MEMBERKEY")
        public String memberkey;
        @b("PLYLSTSEQ")
        public String plylstSeq;
        @b("PLYLSTTITLE")
        public String plylstTitle;
        private static final long serialVersionUID = 0xFD3379C291EC0BBAL;
        @b("SUBCONTENTLIST")
        public List subContentList;
        @b("SUBCONTENTTITLE")
        public String subContentTitle;
        @b("SUBCONTENTBGCOLOR")
        public String subcontentBgColor;

    }

    public static class com.iloen.melon.net.v6x.response.DjHomeMainRes.OPTION extends LinkInfoBase {
        @b("CONTSID")
        public String contsId;
        @b("CONTSTYPECODE")
        public String contsTypeCode;
        private static final long serialVersionUID = -3190174089319048856L;
        @b("TITLE")
        public String title;

    }

    public static class POPULARDJPLAYLISTS implements Serializable {
        public static class com.iloen.melon.net.v6x.response.DjHomeMainRes.POPULARDJPLAYLISTS.SUBCONTENTLIST extends PLAYLIST {
            @b("CURRANK")
            public String currentRank;
            @b("PASTRANK")
            public String pastRank;
            @b("RANKGAP")
            public String rankGap;
            @b("RANKTYPE")
            public String rankType;
            private static final long serialVersionUID = 1746111067330169906L;

        }

        private static final long serialVersionUID = 0x5CDC40E0D8A395C5L;
        @b("SUBCONTENTLIST")
        public List subContentList;
        @b("SUBCONTENTTITLE")
        public String subContentTitle;

    }

    public static class POWERDJLIST implements Serializable {
        public static class com.iloen.melon.net.v6x.response.DjHomeMainRes.POWERDJLIST.SUBCONTENTLIST extends DjInfoBase {
            @b("DJPLAYLISTLIST")
            public List djPlayListList;
            private static final long serialVersionUID = 368235940027000980L;

        }

        private static final long serialVersionUID = 0xB714B2D43C854EA1L;
        @b("SUBCONTENTLIST")
        public List subContentList;
        @b("SUBCONTENTTITLE")
        public String subContentTitle;

    }

    public static class POWERDJPLAYLISTS implements Serializable {
        public static class com.iloen.melon.net.v6x.response.DjHomeMainRes.POWERDJPLAYLISTS.SUBCONTENTLIST extends PLAYLIST {
            private static final long serialVersionUID = 0x9A884F85609CBB8DL;

        }

        private static final long serialVersionUID = 0x4E0A581E617B56F9L;
        @b("SUBCONTENTLIST")
        public List subContentList;
        @b("SUBCONTENTTITLE")
        public String subContentTitle;

    }

    public static class RECMDJ implements Serializable {
        public static class com.iloen.melon.net.v6x.response.DjHomeMainRes.RECMDJ.SUBCONTENTLIST extends DjInfoBase {
            private static final long serialVersionUID = -7780577740954703130L;

        }

        private static final long serialVersionUID = 0x67F696E2A55B3C15L;
        @b("SUBCONTENTLIST")
        public List subContentList;
        @b("SUBCONTENTTITLE")
        public String subContentTitle;

    }

    public static class RESPONSE extends ResponseBase {
        @b("DJGUIDEBTNS")
        public DJGUIDEBTNS djGuideBtns;
        @b("NEWDJ")
        public NEWDJ newDj;
        @b("OFFICIALSERIESPLAYLISTS")
        public OFFICIALSERIESPLAYLISTS officialSeriesPlaylists;
        @b("POPULARDJPLAYLISTS")
        public POPULARDJPLAYLISTS popularDjplayLists;
        @b("POWERDJLIST")
        public POWERDJLIST powerDjList;
        @b("POWERDJPLAYLISTS")
        public POWERDJPLAYLISTS powerDjPlayLists;
        @b("RECMDJ")
        public RECMDJ recmDj;
        private static final long serialVersionUID = 0x73A0A1ADCBA47332L;
        @b("TAGBOARDLIST")
        public TAGBOARDLIST tagBoardList;
        @b("TPO1")
        public TPO1 tpo1;

    }

    public static class TAGBOARDLIST implements Serializable {
        public static class com.iloen.melon.net.v6x.response.DjHomeMainRes.TAGBOARDLIST.SUBCONTENTLIST {
            @b("TABTAGTYPECODE")
            public String tabTagTypeCode;
            @b("TABTITLE")
            public String tabTitle;
            @b("TAGLIST")
            public List tagList;

        }

        public static class TAGLIST {
            @b("IMGURL")
            public String imgUrl;
            @b("ISLIKE")
            public boolean isLike;
            @b("TAGNAME")
            public String tagName;
            @b("TAGSEQ")
            public String tagSeq;

        }

        private static final long serialVersionUID = 0x3F3D9B72A70AD969L;
        @b("SUBCONTENTLIST")
        public List subContentList;
        @b("SUBCONTENTTITLE")
        public String subContentTitle;

    }

    public static class TPO1 implements Serializable {
        public static class com.iloen.melon.net.v6x.response.DjHomeMainRes.TPO1.SUBCONTENTLIST {
            @b("OFFERIMGURL")
            public String offerImgUrl;
            @b("OFFERINTORDCONT")
            public String offerIntordCont;
            @b("OFFERTITLE")
            public String offerTitle;
            @b("OPTION")
            public com.iloen.melon.net.v6x.response.DjHomeMainRes.OPTION option;
            @b(alternate = {"ownerNickname"}, value = "OWNERNICKNAME")
            public String ownernickname;
            @b("PLYLSTSEQ")
            public String plylstSeq;
            @b(alternate = {"plylstTitle"}, value = "PLYLSTTITLE")
            public String plylsttitle;

        }

        private static final long serialVersionUID = 0x8F2290CC1F486C98L;
        @b("SUBCONTENTLIST")
        public List subContentList;
        @b("SUBCONTENTTITLE")
        public String subContentTitle;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x14218E0196CC500EL;

    public DjHomeMainRes() {
        this.response = null;
    }
}

