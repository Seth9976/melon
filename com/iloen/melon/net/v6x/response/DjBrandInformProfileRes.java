package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ArtistPlayListWrapperInfoBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.MvInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class DjBrandInformProfileRes extends ResponseV6Res {
    public static class RESPONSE extends ProfileBaseRes {
        public static class ARTISTLIST implements Serializable {
            public static class SUBCONTENTLIST extends ArtistInfoBase {
                @b("ACTTYPENAME")
                public String actTypeName;
                @b("BIRTHDAY")
                public String birthDay;
                @b("CONTSTYPECODE")
                public String contsTypeCode;
                @b("DEBUTDAY")
                public String debutDay;
                @b("IMAGETYPE")
                public String imageType;
                private static final long serialVersionUID = 0x73BAD31F4D0AD715L;

                public SUBCONTENTLIST() {
                    this.actTypeName = "";
                    this.birthDay = "";
                    this.contsTypeCode = "";
                    this.debutDay = "";
                    this.imageType = "";
                }
            }

            private static final long serialVersionUID = 0x5C1C3DB35DD43715L;
            @b("SUBCONTENTLIST")
            public ArrayList subContentList;
            @b("SUBCONTENTTITLE")
            public String subContentTitle;
            @b("SUBCONTENTTOTCNT")
            public String subContentTotCnt;

            public ARTISTLIST() {
                this.subContentList = null;
                this.subContentTitle = "";
                this.subContentTotCnt = "";
            }
        }

        public static class BANNERLIST implements Serializable {
            public static class com.iloen.melon.net.v6x.response.DjBrandInformProfileRes.RESPONSE.BANNERLIST.SUBCONTENTLIST extends BannerBase {
                @b("GUIDETYPE")
                public String guideType;
                @b("PLAYTIME")
                public String playTime;
                private static final long serialVersionUID = 0xC34BB2F37CCC06CL;

                public com.iloen.melon.net.v6x.response.DjBrandInformProfileRes.RESPONSE.BANNERLIST.SUBCONTENTLIST() {
                    this.guideType = "";
                    this.playTime = "";
                }
            }

            private static final long serialVersionUID = 0x489AEF9D3F450B5DL;
            @b("SUBCONTENTLIST")
            public ArrayList subContentList;

            public BANNERLIST() {
                this.subContentList = null;
            }
        }

        public static class BRANDDTLINFO implements Serializable {
            public static class APPINFO extends DtlInfoBase {
                private static final long serialVersionUID = 0x10E4D6C3296BB6DBL;

            }

            public static class DtlInfoBase implements Serializable {
                @b("DTLINFOTYPECODE")
                public String dtlInfoTypeCode;
                @b("DTLINFOVAL")
                public String dtlInfoVal;
                private static final long serialVersionUID = 0x112BF5EFC8D5ABDBL;

                public DtlInfoBase() {
                    this.dtlInfoTypeCode = "";
                    this.dtlInfoVal = "";
                }
            }

            public static class WEBSITEINFO extends DtlInfoBase {
                private static final long serialVersionUID = 0x10D69FDFC1ACA6DCL;

            }

            @b("APPINFO")
            public APPINFO appInfo;
            private static final long serialVersionUID = 0x315BEDC1802939FCL;
            @b("SUBCONTENTTITLE")
            public String subContentTitle;
            @b("WEBSITEINFO")
            public WEBSITEINFO websiteInfo;

            public BRANDDTLINFO() {
                this.subContentTitle = "";
            }
        }

        public static class DJPLAYLISTLIST implements Serializable {
            public static class com.iloen.melon.net.v6x.response.DjBrandInformProfileRes.RESPONSE.DJPLAYLISTLIST.SUBCONTENTLIST extends ArtistPlayListWrapperInfoBase {
                private static final long serialVersionUID = 0xC54B2D1597D206CL;

            }

            @b("BGCOLOR")
            public String bgColor;
            private static final long serialVersionUID = 0xD02DA467C848C6CL;
            @b("SUBCONTENTLIST")
            public ArrayList subContentList;
            @b("SUBCONTENTTITLE")
            public String subContentTitle;
            @b("SUBCONTENTTOTCNT")
            public String subContentTotCnt;

            public DJPLAYLISTLIST() {
                this.subContentTitle = "";
                this.subContentTotCnt = "";
                this.bgColor = "";
                this.subContentList = null;
            }
        }

        public static class MAGAZINELIST implements Serializable {
            public static class com.iloen.melon.net.v6x.response.DjBrandInformProfileRes.RESPONSE.MAGAZINELIST.SUBCONTENTLIST implements Serializable {
                @b("CATTENAME")
                public String catteName;
                @b("CONTSTYPECODE")
                public String contsTypeCode;
                @b("LINK")
                public LinkInfoBase link;
                @b("LISTIMG")
                public String listImg;
                @b("MSTORYSEQ")
                public String mStorySeq;
                @b("MSTORYTITLE")
                public String mStoryTitle;
                @b("RSRVDATE")
                public String rsrvDate;
                private static final long serialVersionUID = 0x15021535EB39D9FCL;

                public com.iloen.melon.net.v6x.response.DjBrandInformProfileRes.RESPONSE.MAGAZINELIST.SUBCONTENTLIST() {
                    this.mStorySeq = "";
                    this.mStoryTitle = "";
                    this.catteName = "";
                    this.listImg = "";
                    this.rsrvDate = "";
                    this.contsTypeCode = "";
                }
            }

            private static final long serialVersionUID = 0x49336090BC019D97L;
            @b("SUBCONTENTLIST")
            public ArrayList subContentList;
            @b("SUBCONTENTTITLE")
            public String subContentTitle;
            @b("SUBCONTENTTOTCNT")
            public String subContentTotCnt;

            public MAGAZINELIST() {
                this.subContentList = null;
                this.subContentTitle = "";
                this.subContentTotCnt = "";
            }
        }

        public static class SONGLIST implements Serializable {
            private static final long serialVersionUID = 0xCDF230FDF426065L;
            @b("SUBCONTENTLIST")
            public ArrayList subContentList;
            @b("SUBCONTENTTITLE")
            public String subContentTitle;
            @b("SUBCONTENTTOTCNT")
            public String subContentTotCnt;

            public SONGLIST() {
                this.subContentList = null;
                this.subContentTitle = "";
                this.subContentTotCnt = "";
            }
        }

        public static class VIDEOLIST implements Serializable {
            public static class com.iloen.melon.net.v6x.response.DjBrandInformProfileRes.RESPONSE.VIDEOLIST.SUBCONTENTLIST extends MvInfoBase {
                @b("CONTSTYPECODE")
                public String contsTypeCode;
                @b("LINK")
                public LinkInfoBase link;
                private static final long serialVersionUID = 0x18C3E580FA7B06CL;

                public com.iloen.melon.net.v6x.response.DjBrandInformProfileRes.RESPONSE.VIDEOLIST.SUBCONTENTLIST() {
                    this.contsTypeCode = "";
                    this.link = null;
                }
            }

            @b("BGCOLOR")
            public String bgColor;
            private static final long serialVersionUID = 0x2D70E27ECCD73217L;
            @b("SUBCONTENTLIST")
            public ArrayList subContentList;
            @b("SUBCONTENTTITLE")
            public String subContentTitle;
            @b("SUBCONTENTTOTCNT")
            public String subContentTotCnt;

            public VIDEOLIST() {
                this.subContentList = null;
                this.subContentTitle = "";
                this.subContentTotCnt = "";
                this.bgColor = "";
            }
        }

        @b("ARTISTLIST")
        public ARTISTLIST artistList;
        @b("BANNERLIST")
        public BANNERLIST bannerList;
        @b("BRANDDJKEY")
        public String brandDjKey;
        @b("BRANDDTLINFO")
        public BRANDDTLINFO brandDtlInfo;
        @b("CASTLIST")
        public CASTLIST castList;
        @b("DJPICKPLAYLIST")
        public ArtistPlayListInfoBase djPickPlaylist;
        @b("DJPLAYLISTLIST")
        public DJPLAYLISTLIST djPlaylistList;
        @b("DJTITLE")
        public String djTitle;
        @b("FOLLOWUSERCNT")
        public String followUserCnt;
        @b("ISMYFRIEND")
        public boolean isMyFriend;
        @b("ISOFFICIAL")
        public boolean isOfficial;
        @b("ISREPPLYLSTDISP")
        public boolean isRepPlylstDisp;
        @b("LIKECNT")
        public String likeCnt;
        @b("MAGAZINELIST")
        public MAGAZINELIST magazineList;
        @b("MEMBERDJICONTYPE")
        public String memberDjIconType;
        @b("MEMBERDJTYPE")
        public String memberDjType;
        @b("MEMBERNICKNAME")
        public String memberNickName;
        @b("MYPAGEDESC")
        public String myPageDesc;
        @b("MYPAGEIMG")
        public String myPageImg;
        @b("MYPAGEIMGORG")
        public String myPageImgOrg;
        @b("PLYLSTCNT")
        public String plylstCnt;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        private static final long serialVersionUID = 0x31067EDF6CC90E9FL;
        @b("SNSINFO")
        public ArrayList snsInfo;
        @b("SONGLIST")
        public SONGLIST songList;
        @b("VIDEOLIST")
        public VIDEOLIST videoList;

        public RESPONSE() {
            this.memberDjType = "";
            this.memberDjIconType = "";
            this.djTitle = "";
            this.brandDjKey = "";
            this.myPageImg = "";
            this.myPageImgOrg = "";
            this.memberNickName = "";
            this.followUserCnt = "";
            this.likeCnt = "";
            this.plylstCnt = "";
            this.myPageDesc = "";
            this.postImg = "";
            this.postEditImg = "";
            this.isOfficial = false;
            this.isRepPlylstDisp = false;
            this.isMyFriend = false;
            this.bannerList = null;
            this.snsInfo = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x15533541FC7C0D5FL;

    public DjBrandInformProfileRes() {
        this.response = null;
    }
}

