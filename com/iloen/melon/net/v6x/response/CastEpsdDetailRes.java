package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.response.CastInfoBase;
import com.iloen.melon.sns.model.ShareLinkData;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class CastEpsdDetailRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        public static class CastInfo extends CastInfoBase {
            public static class BUTTONINFO implements Serializable {
                @b("LINKNAME")
                public String linkName;
                @b("LINKTYPE")
                public String linkType;
                @b("LINKURL")
                public String linkUrl;
                private static final long serialVersionUID = 0x6CD15E2F9138075CL;

                public BUTTONINFO() {
                    this.linkName = "";
                    this.linkType = "";
                    this.linkUrl = "";
                }
            }

            @b("BUTTONINFO")
            public BUTTONINFO buttonInfo;
            @b("CMTCNT")
            public String cmtCnt;
            @b("PROGSEQ")
            public String progSeq;
            @b("PROGTHUMBIMAGEURL")
            public String progThumbImageUrl;
            @b("PROGTITLE")
            public String progTitle;
            private static final long serialVersionUID = 0x51980E7602E72B08L;
            @b("SNSINFO")
            public ShareLinkData snsInfo;

            public CastInfo() {
                this.progSeq = "";
                this.progTitle = "";
                this.progThumbImageUrl = "";
                this.cmtCnt = "";
                this.snsInfo = null;
                this.buttonInfo = null;
            }

            @Override  // com.iloen.melon.net.v5x.response.CastInfoBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class CastList implements Serializable {
            @b("CASTDATE")
            public String castDate;
            @b("CASTSEQ")
            public String castSeq;
            @b("CASTTITLE")
            public String castTitle;
            @b("PROGSEQ")
            public String progSeq;
            @b("PROGTITLE")
            public String progTitle;
            private static final long serialVersionUID = 0x148A141AAB4810L;
            @b("VERTICALIMGURL")
            public String verticalImgUrl;

            public CastList() {
                this.castSeq = "";
                this.verticalImgUrl = "";
                this.castTitle = "";
                this.castDate = "";
                this.progSeq = "";
                this.progTitle = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class OtherCastInfo implements Serializable {
            @b("CASTLIST")
            public ArrayList castList;
            @b("ISMORE")
            public boolean isMore;
            private static final long serialVersionUID = 0x6CE37C9BD992C75CL;
            @b("TITLE")
            public String title;

            public OtherCastInfo() {
                this.title = "";
                this.castList = null;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class RecmStationInfo implements Serializable {
            @b("CASTLIST")
            public ArrayList castList;
            private static final long serialVersionUID = 0xFEE908F1B2D4BFECL;
            @b("TITLE")
            public String title;

            public RecmStationInfo() {
                this.title = "";
                this.castList = null;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class RelatContsInfo implements Serializable {
            public static class RelatContsList implements Serializable {
                @b("CONTSID")
                public String contsId;
                @b("CONTSTYPECODE")
                public String contsTypeCode;
                @b("IMGURL")
                public String imgUrl;
                @b("LINKTYPE")
                public String linkType;
                @b("LINKURL")
                public String linkUrl;
                @b("PLAYTIME")
                public long playTime;
                private static final long serialVersionUID = 0xFFFF0F20C097D1A3L;
                @b("SUBTITLE")
                public String subTitle;
                @b("TITLE")
                public String title;

                public RelatContsList() {
                    this.contsTypeCode = "";
                    this.contsId = "";
                    this.imgUrl = "";
                    this.title = "";
                    this.subTitle = "";
                    this.playTime = 0L;
                    this.linkType = "";
                    this.linkUrl = "";
                }

                @Override
                public String toString() {
                    return ToStringUtil.toStringFields(this);
                }
            }

            @b("RELATCONTSLIST")
            public ArrayList relatContsList;
            private static final long serialVersionUID = 0xFFC901310DA76D3AL;
            @b("TITLE")
            public String title;

            public RelatContsInfo() {
                this.title = "";
                this.relatContsList = null;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class SongInfo implements Serializable {
            public static class SongList extends SongInfoBase {
                @b("DISPYN")
                public String dispYn;
                @b("ORDERNO")
                public String orderNo;
                private static final long serialVersionUID = 0xF1A9A836FB8AEA10L;

                public SongList() {
                    this.orderNo = "";
                    this.dispYn = "";
                }
            }

            private static final long serialVersionUID = 0x18B77363BB0L;
            @b("SONGLIST")
            public ArrayList songList;
            @b("TITLE")
            public String title;
            @b("TOTALPLAYTIME")
            public String totalPlayTime;

            public SongInfo() {
                this.title = "";
                this.totalPlayTime = "";
                this.songList = null;
            }
        }

        @b("BBSCHANNELSEQ")
        public String bbsChannelSeq;
        @b("BBSCONTSID")
        public String bbsContsId;
        @b("CASTINFO")
        public CastInfo castInfo;
        @b("OTHERCASTINFO")
        public OtherCastInfo otherCastInfo;
        @b("RECMSTATIONINFO")
        public RecmStationInfo recmStationInfo;
        @b("RELATCONTSINFO")
        public RelatContsInfo relatContsInfo;
        private static final long serialVersionUID = 0x4224DDBE4ABD328L;
        @b("SONGINFO")
        public SongInfo songInfo;

        public Response() {
            this.castInfo = null;
            this.otherCastInfo = null;
            this.songInfo = null;
            this.recmStationInfo = null;
            this.relatContsInfo = null;
            this.bbsChannelSeq = "";
            this.bbsContsId = "";
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x4ABB4E8F48EAC606L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

