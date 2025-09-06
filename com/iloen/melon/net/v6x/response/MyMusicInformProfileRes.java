package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MyMusicInformProfileRes extends ResponseV6Res {
    public static class RESPONSE extends ProfileBaseRes {
        public static class DjReport extends LinkInfoBase {
            private static final long serialVersionUID = 0x31773D9AD70595E5L;

        }

        public static class LIKEINFO implements Serializable {
            public static class LIKESONGIMGLIST implements Serializable {
                @b("ALBUMIMG")
                public String albumImg;
                @b("ALBUMIMGLARGE")
                public String albumImgLarge;
                @b("ALBUMIMGSMALL")
                public String albumImgSmall;
                private static final long serialVersionUID = -5002224413820152769L;

                public LIKESONGIMGLIST() {
                    this.albumImg = "";
                    this.albumImgLarge = "";
                    this.albumImgSmall = "";
                }
            }

            public static class PLYLSTINFO extends ArtistPlayListInfoBase {
                private static final long serialVersionUID = 0x15B7977E7B88A2E5L;

            }

            @b("ALBUMINFO")
            public ArrayList albumInfo;
            @b("GUIDETEXT")
            public String guideText;
            @b("LIKEALBUMCNT")
            public int likeAlbumCnt;
            @b("LIKEALBUMNAME")
            public String likeAlbumName;
            @b("LIKEPLYLSTCNT")
            public int likePlylstCnt;
            @b("LIKEPLYLSTNAME")
            public String likePlylstName;
            @b("LIKESONGCNT")
            public int likeSongCnt;
            @b("LIKESONGIMGLIST")
            public ArrayList likeSongImgList;
            @b("LIKESONGNAME")
            public String likeSongName;
            @b("PLYLSTINFO")
            public ArrayList plylstInfo;
            private static final long serialVersionUID = 0xD8ABDA8097521B5CL;

            public LIKEINFO() {
                this.likeSongName = "";
                this.likeSongCnt = 0;
                this.likeSongImgList = null;
                this.albumInfo = null;
                this.likeAlbumName = "";
                this.likeAlbumCnt = 0;
                this.plylstInfo = null;
                this.likePlylstName = "";
                this.likePlylstCnt = 0;
                this.guideText = "";
            }
        }

        public static class MYPROFILE implements Serializable {
            public static class DJPICKPLAYLIST extends ArtistPlayListInfoBase {
                private static final long serialVersionUID = 0x11163FD27DDF9B15L;

            }

            public static class FANLOUNGEINFO extends LinkInfoBase {
                @b("ARTISTNAME")
                public String artistName;
                @b("FANCLUBNAME")
                public String fanclubName;
                private static final long serialVersionUID = 0x11175543929AA315L;

                public FANLOUNGEINFO() {
                    this.artistName = "";
                    this.fanclubName = "";
                }
            }

            @b("ARTISTCHNFLAG")
            public String artistChnFlag;
            @b("ARTISTID")
            public String artistId;
            @b("COVERIMG")
            public String coverImg;
            @b("DJCMTOPENFLAG")
            public String djCmtOpenFlag;
            @b("DJPICKFLAG")
            public String djPickFlag;
            @b("DJPICKPLAYLIST")
            public DJPICKPLAYLIST djPickPlaylist;
            @b("DJPICKPLYLSTSEQ")
            public String djPickPlylstSeq;
            @b("DJTITLE")
            public String djTitle;
            @b("FANLOUNGEINFO")
            public FANLOUNGEINFO fanLoungeInfo;
            @b("FANLOUNGEOPENFLAG")
            public String fanLoungeOpenFlag;
            @b("FOLLOWERCNT")
            public String followerCnt;
            @b("FOLLOWINGCNT")
            public String followingCnt;
            @b("FRIENDOPENFLAG")
            public String friendOpenFlag;
            @b("GIFTBOXNEWCNT")
            public String giftBoxNewCnt;
            @b("GIFTBOXNEWFLAG")
            public String giftBoxNewFlag;
            @b("ISARTISTUSER")
            public boolean isArtistUser;
            @b("ISDJ")
            public boolean isDj;
            @b("ISESSENTIAL")
            public boolean isEssential;
            @b("ISLABEL")
            public boolean isLabel;
            @b("ISOFFICIAL")
            public boolean isOfficial;
            @b("ISPOWERDJ")
            public boolean isPowerDj;
            @b("ISUNDERFOURTEENMEMBER")
            public boolean isUnderFourTeenMember;
            @b("LIKEOPENFLAG")
            public String likeOpenFlag;
            @b("MEMBERDJICONTYPE")
            public String memberDjIconType;
            @b("MEMBERDJTYPE")
            public String memberDjType;
            @b("MEMBERKEY")
            public String memberKey;
            @b("MEMBERNICKNAME")
            public String memberNickName;
            @b("MEMBERTYPE")
            public String memberType;
            @b("MSGRECVFLAG")
            public String msgRecvFlag;
            @b("MUSICMSGNEWCNT")
            public String musicMsgNewCnt;
            @b("MUSICMSGNEWFLAG")
            public String musicMsgNewFlag;
            @b("MYPAGEDESC")
            public String myPageDesc;
            @b("MYPAGEIMG")
            public String myPageImg;
            @b("MYPAGEIMGORG")
            public String myPageImgOrg;
            @b("NEWFOLLOWERCNT")
            public String newFollowerCnt;
            @b("PLYLSTCNT")
            public String plylstCnt;
            @b("POSTEDITIMG")
            public String postEditImg;
            @b("POSTIMG")
            public String postImg;
            @b("REALNICKNAME")
            public String realNickName;
            private static final long serialVersionUID = 0xA989B6B521AF4EEBL;
            @b("SNSINFO")
            public ArrayList snsInfo;
            @b("TODAYVISITCNT")
            public String todayVisitCnt;
            @b("TOTVISITCNT")
            public String totalVisitCnt;

            public MYPROFILE() {
                this.memberKey = "";
                this.myPageImg = "";
                this.myPageImgOrg = "";
                this.memberDjIconType = "";
                this.postImg = "";
                this.postEditImg = "";
                this.coverImg = "";
                this.memberNickName = "";
                this.realNickName = "";
                this.myPageDesc = "";
                this.djCmtOpenFlag = "N";
                this.isDj = false;
                this.isPowerDj = false;
                this.isEssential = false;
                this.isLabel = false;
                this.isOfficial = false;
                this.memberDjType = "";
                this.todayVisitCnt = "";
                this.totalVisitCnt = "";
                this.likeOpenFlag = "N";
                this.msgRecvFlag = "N";
                this.followingCnt = "";
                this.newFollowerCnt = "";
                this.followerCnt = "";
                this.musicMsgNewFlag = "N";
                this.musicMsgNewCnt = "";
                this.giftBoxNewFlag = "N";
                this.giftBoxNewCnt = "";
                this.memberType = "";
                this.artistId = "";
                this.plylstCnt = "";
                this.djTitle = "";
                this.djPickPlylstSeq = "";
                this.djPickFlag = "N";
                this.snsInfo = null;
                this.artistChnFlag = "N";
                this.isArtistUser = false;
                this.isUnderFourTeenMember = false;
                this.fanLoungeOpenFlag = "N";
                this.fanLoungeInfo = null;
                this.friendOpenFlag = "N";
            }
        }

        public static class PLAYLIST implements Serializable {
            public static class SERIESPLAYLISTLIST extends ArtistPlayListInfoBase {
                @b("PLYLSTCNT")
                public String plylstCnt;
                private static final long serialVersionUID = 0xF28F591C5A00051L;

                public SERIESPLAYLISTLIST() {
                    this.plylstCnt = "";
                }
            }

            @b("DJPLAYLISTLIST")
            public ArrayList djPlaylistList;
            @b("PLAYLISTLIST")
            public ArrayList playlistList;
            @b("SCHEMEURL")
            public String schemeUrl;
            private static final long serialVersionUID = 3002592716072005713L;
            @b("SERIESPLAYLISTLIST")
            public ArrayList seriesPlaylistList;

            public PLAYLIST() {
                this.playlistList = null;
                this.djPlaylistList = null;
                this.seriesPlaylistList = null;
                this.schemeUrl = "";
            }
        }

        public static class POWERDJINDICATOR implements Serializable {
            @b("APPLYSTATUS")
            public String applyStatus;
            @b("APPLYSTATUSMESSAGE")
            public String applyStatusMessage;
            @b("APPORVEPOPMESSAGE")
            public String approvePopMessage;
            @b("BOTTOMMESSAGE")
            public String bottomMessage;
            @b("ISBLACKLIST")
            public boolean isBlackList;
            @b("ISSLOTDISP")
            public boolean isSlotDisp;
            @b("LINKTYPE")
            public String linkType;
            @b("LINKURL")
            public String linkUrl;
            private static final long serialVersionUID = 0x31773D9AD70595E5L;
            @b("TOTALRATE")
            public String totalRate;

            public POWERDJINDICATOR() {
                this.isSlotDisp = false;
                this.isBlackList = false;
                this.totalRate = "";
                this.applyStatus = "";
                this.applyStatusMessage = "";
                this.approvePopMessage = "";
                this.bottomMessage = "";
                this.linkType = "";
                this.linkUrl = "";
            }
        }

        @b("CPLANCODE")
        public String cPlanCode;
        @b("CASTLIST")
        public CASTLIST castList;
        @b("DJREPORT")
        public DjReport djReport;
        @b("ISMYFRIEND")
        public boolean isMyFriend;
        @b("LIKEINFO")
        public LIKEINFO likeInfo;
        @b("MYMUSICYN")
        public String myMusicYN;
        @b("MYPROFILE")
        public MYPROFILE myProfile;
        @b("PLAYLIST")
        public PLAYLIST playlist;
        @b("POWERDJINDICATOR")
        public POWERDJINDICATOR powerDjIndicator;
        private static final long serialVersionUID = 0xFC0B1EFB70C3AB5FL;

        public RESPONSE() {
            this.myMusicYN = "";
            this.cPlanCode = "";
            this.isMyFriend = false;
            this.myProfile = null;
            this.playlist = null;
            this.likeInfo = null;
            this.powerDjIndicator = null;
            this.djReport = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -7506100455388605791L;

    public MyMusicInformProfileRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

