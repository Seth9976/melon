package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class TrendShortFormRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        public static class SLOTLIST implements Serializable {
            public static class BANNER extends LinkInfoBase {
                @b("BGCOLOR")
                public String bgColor;
                @b("IMGURL")
                public String imgUrl;
                private static final long serialVersionUID = 623335590754920467L;
                @b("TEXT")
                public String text;
                @b("USEIMGURL")
                public boolean useImgUrl;

                public BANNER() {
                    this.useImgUrl = false;
                    this.text = "";
                    this.imgUrl = "";
                    this.bgColor = "";
                }
            }

            public static class CHAT implements Serializable {
                @b("NAME")
                public String name;
                @b("PROFILEIMGURL")
                public String profileImgUrl;
                private static final long serialVersionUID = 0x3B7844FFCFA6EC43L;
                @b("TEXT")
                public String text;

                public CHAT() {
                    this.profileImgUrl = "";
                    this.name = "";
                    this.text = "";
                }
            }

            public static class Channel extends LinkInfoBase {
                @b("CHANNELTITLE")
                public String channelTitle;
                @b("CHATLIST")
                public CHAT chatList;
                @b("CONTSID")
                public String contsId;
                @b("CONTSTITLE")
                public String contsTitle;
                @b("CONTSTYPECODE")
                public String contsTypeCode;
                @b("IMGURL")
                public String imgUrl;
                @b("ISARTISTTYPE")
                public String isArtistType;
                @b("ISEVENT")
                public Boolean isEvent;
                @b("LIKECNT")
                public String likeCnt;
                private static final long serialVersionUID = 0x12C08E2581B829B8L;
                @b("VIEWCNT")
                public String viewCnt;

                public Channel() {
                    this.channelTitle = "";
                    this.chatList = null;
                    this.imgUrl = "";
                    this.viewCnt = "";
                    this.likeCnt = "";
                    this.isArtistType = "";
                    this.contsTypeCode = "";
                    this.contsId = "";
                    this.contsTitle = "";
                    this.isEvent = Boolean.FALSE;
                }
            }

            public static class MEDIAINFO implements Serializable {
                @b("C")
                public String c;
                @b("CONTENTIMGPATH")
                public String contentImgPath;
                @b("CONTSID")
                public String contsId;
                @b("CONTSTYPECODE")
                public String contsTypeCode;
                @b("FILEUPDTDATE")
                public String fileUpdate;
                @b("MEDIATYPE")
                public String mediaType;
                @b("PATH")
                public String path;
                @b("PROTOCOLTYPE")
                public String protocolType;
                private static final long serialVersionUID = 0xB761E1E1CA122630L;

                public MEDIAINFO() {
                    this.mediaType = "";
                    this.contsTypeCode = "";
                    this.contsId = "";
                    this.path = "";
                    this.contentImgPath = "";
                    this.c = "";
                    this.protocolType = "";
                    this.fileUpdate = "";
                }
            }

            public static class SONGINFO {
                @b("ALBUMIMG")
                public String albumImg;
                @b("ARTISTLIST")
                public ArrayList artistList;
                private static final long serialVersionUID = 0x12C08E2581AEB3D8L;
                @b("SONGID")
                public String songId;
                @b("SONGNAME")
                public String songName;

                public SONGINFO() {
                    this.songId = "";
                    this.songName = "";
                    this.albumImg = "";
                    this.artistList = null;
                }
            }

            public static class STATSELEMENTS extends StatsElementsBase {
                private static final long serialVersionUID = 0x3B7844FFCFA6EC43L;

            }

            @b("CMTCHNLSEQ")
            public String CmtChnlSeq;
            @b("ALBUMIMGLARGE")
            public String albumImgLarge;
            @b("ARTISTINFO")
            public ArtistsInfoBase artistInfo;
            @b("ARTISTLIST")
            public ArrayList artistlist;
            @b("BADGEIMGURL")
            public String badgeImgUrl;
            @b("BANNER")
            public BANNER banner;
            @b("BGIMGURL")
            public String bgmImgUrl;
            @b("CHANNELLIST")
            public ArrayList channelList;
            @b("CHATLIST")
            public ArrayList chatList;
            @b("CMTCNT")
            public String cmtCnt;
            @b("CONTSID")
            public String contsId;
            @b("CONTSTITLE")
            public String contsTitle;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("COVERIMGURL")
            public String coverImgUrl;
            @b("IMGDPTYPE")
            public String imgDpType;
            @b("IMGLIST")
            public ArrayList imgList;
            @b("ISARTISTTYPE")
            public Boolean isArtistType;
            @b("ISEVENT")
            public Boolean isEvent;
            @b("LIKECNT")
            public String likeCnt;
            @b("LIKEYN")
            public String likeYn;
            @b("LYRICSLIST")
            public ArrayList lyricList;
            @b("MEDIAINFO")
            public MEDIAINFO mediaInfo;
            @b("PATTCOLORTYPE")
            public String patternColorType;
            @b("PATTIMGTYPE")
            public String patternImgType;
            private static final long serialVersionUID = 0xB7ADE9087E113A30L;
            @b("SHAPEIMGURL")
            public String shapeImgUrl;
            @b("SLOTID")
            public String slotId;
            @b("SLOTNAME")
            public String slotName;
            @b("SLOTNO")
            public String slotNo;
            @b("SLOTTYPE")
            public String slotType;
            @b("SLOTTYPEDESC")
            public String slotTypeDesc;
            @b("SLOTUID")
            public String slotUid;
            @b("SONGINFO")
            public SONGINFO songInfo;
            @b("SONGNAME")
            public String songName;
            @b("STATSELEMENTS")
            public STATSELEMENTS statsElements;
            @b("SUBTITLE")
            public String subTitle;
            @b("TITLE")
            public String title;
            @b("UITYPE")
            public String uiType;
            @b("VIEWCNT")
            public String viewCnt;

            public SLOTLIST() {
                this.slotUid = "";
                this.slotId = "";
                this.slotNo = "";
                this.slotType = "";
                this.slotTypeDesc = "";
                this.slotName = "";
                this.uiType = "";
                this.contsTypeCode = "";
                this.contsId = "";
                this.contsTitle = "";
                this.title = "";
                this.subTitle = "";
                this.viewCnt = "";
                this.isEvent = Boolean.FALSE;
                this.isArtistType = Boolean.FALSE;
                this.imgList = null;
                this.chatList = null;
                this.artistInfo = null;
                this.songInfo = null;
                this.imgDpType = "";
                this.patternImgType = "";
                this.patternColorType = "";
                this.channelList = null;
                this.likeCnt = "";
                this.cmtCnt = "";
                this.CmtChnlSeq = "";
                this.likeYn = "";
                this.songName = "";
                this.albumImgLarge = "";
                this.artistlist = null;
                this.shapeImgUrl = "";
                this.bgmImgUrl = "";
                this.lyricList = null;
                this.badgeImgUrl = "";
                this.coverImgUrl = "";
                this.mediaInfo = null;
                this.banner = null;
                this.statsElements = null;
            }
        }

        @b("DUMMYTEXT")
        public String dummyText;
        private static final long serialVersionUID = 0x746D40BE9F40093DL;
        @b("SLOTLIST")
        public ArrayList slotList;
        @b("TITLE")
        public String title;

        public Response() {
            this.title = "";
            this.dummyText = "";
            this.slotList = null;
        }
    }

    public static final String TYPE_M01 = "M01";
    public static final String TYPE_M02 = "M02";
    public static final String TYPE_M03 = "M03";
    public static final String TYPE_S01 = "S01";
    public static final String TYPE_T01 = "T01";
    public static final String TYPE_T02 = "T02";
    public static final String TYPE_V01 = "V01";
    public static final String TYPE_V02 = "V02";
    @b("response")
    public Response response;
    private static final long serialVersionUID = 0xF424663266B384B0L;

    public TrendShortFormRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

