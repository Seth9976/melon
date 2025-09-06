package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.util.ArrayList;

public class MyMusicSettingInformProfileSimpleRes extends ResponseV6Res {
    public static class RESPONSE extends ProfileBaseRes {
        public static class DJPICKPLAYLIST extends ArtistPlayListInfoBase {
            @b("ALBUMIMAGE1PATH")
            public String albumImage1Path;
            @b("ALBUMIMAGE2PATH")
            public String albumImage2Path;
            @b("ALBUMIMAGE3PATH")
            public String albumImage3Path;
            @b("ALBUMIMAGE4PATH")
            public String albumImage4Path;
            @b("BRANDDJMEMTYPECODE")
            public String brandDjMemTypeCode;
            @b("CHARTRANK")
            public String chartRank;
            @b("DJPLAYLISTLIST")
            public ArrayList djPlaylistList;
            @b("ENDDT")
            public String endDt;
            @b("EPSDNO")
            public String epsdNo;
            @b("ISOFFICIAL")
            public boolean isOfficial;
            @b("ISREPPLYLST")
            public boolean isRepPlylst;
            @b("ISWITHDRAW")
            public boolean isWithDraw;
            @b("MSTORYREGYN")
            public String mStoryRegYn;
            @b("MSTORYSEQ")
            public String mStorySeq;
            @b("MEMBERDJICONTYPE")
            public String memberDjiconType;
            @b("MEMBERSTATUS")
            public String memberStatus;
            @b("PLYLSTDESC")
            public String plylstDesc;
            @b("PLYLSTTYPECODE")
            public String plylstTypeCode;
            @b("POWERDJYN")
            public String powerDjYn;
            private static final long serialVersionUID = 0xCE5FF658BE15D8B9L;
            @b("SPECIALITYFLAG")
            public String specialityFlag;
            @b("STARTDT")
            public String startDt;
            @b("SVCMEMBERKEY")
            public String svcMemberKey;
            @b("TAGGROUP")
            public String tagGroup;
            @b("UPDTDATE")
            public String updtDate;
            @b("UPDTPOSBLCATETYPECODE")
            public String updtPosblCateTypeCode;

            public DJPICKPLAYLIST() {
                this.albumImage1Path = "";
                this.albumImage2Path = "";
                this.albumImage3Path = "";
                this.albumImage4Path = "";
                this.startDt = "";
                this.endDt = "";
                this.svcMemberKey = "";
                this.memberStatus = "";
                this.updtDate = "";
                this.chartRank = "";
                this.updtPosblCateTypeCode = "";
                this.tagGroup = "";
                this.powerDjYn = "N";
                this.specialityFlag = "";
                this.plylstDesc = "";
                this.isWithDraw = false;
                this.mStoryRegYn = "N";
                this.mStorySeq = "";
                this.plylstTypeCode = "";
                this.isOfficial = false;
                this.memberDjiconType = "";
                this.brandDjMemTypeCode = "";
                this.epsdNo = "";
                this.isRepPlylst = false;
                this.djPlaylistList = null;
            }
        }

        @b("ARTISTCHNFLAG")
        public String artistChnFlag;
        @b("BLINDMSG")
        public String blindMsg;
        @b("BLINDTYPE")
        public String blindType;
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
        @b("DJPICKTOOLTIP")
        public String djPickToolTip;
        @b("DJTITLE")
        public String djTitle;
        @b("DJTITLETOOLTIP")
        public String djTitleToolTip;
        @b("FANLOUNGEOPENFLAG")
        public String fanLoungeOpenFlag;
        @b("FRIENDOPENFLAG")
        public String friendOpenFlag;
        @b("ISARTISTUSER")
        public boolean isArtistUser;
        @b("ISBLACKLIST")
        public boolean isBlackList;
        @b("ISDJ")
        public boolean isDj;
        @b("ISPOWERDJ")
        public boolean isPowerDj;
        @b("ISUNDERFOURTEENMEMBER")
        public boolean isUnderFourTeenMember;
        @b("LIKEOPENFLAG")
        public String likeOpenFlag;
        @b("MEMBERKEY")
        public String memberKey;
        @b("MEMBERNICKNAME")
        public String memberNickName;
        @b("MSGBANUSERCNT")
        public String msgBanUserCnt;
        @b("MSGRECVFLAG")
        public String msgRecvFlag;
        @b("MYPAGEDESC")
        public String myPageDesc;
        @b("MYPAGEIMG")
        public String myPageImg;
        @b("MYPAGEIMGORG")
        public String myPageImgOrg;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        @b("REALNICKNAME")
        public String realNickName;
        @b("REDIRECTAPPURL")
        public String redirectAppUrl;
        @b("REDIRECTURL")
        public String redirectUrl;
        private static final long serialVersionUID = 0x88FC5BA8BF0EA0B9L;
        @b("SITECHNLTOOLTIP")
        public String siteChnlToolTip;
        @b("SNSINFO")
        public ArrayList snsInfo;

        public RESPONSE() {
            this.memberKey = "";
            this.myPageImg = "";
            this.postImg = "";
            this.postEditImg = "";
            this.coverImg = "";
            this.memberNickName = "";
            this.realNickName = "";
            this.myPageDesc = "";
            this.djCmtOpenFlag = "N";
            this.isDj = false;
            this.likeOpenFlag = "N";
            this.msgRecvFlag = "Y";
            this.msgBanUserCnt = "";
            this.isBlackList = false;
            this.redirectAppUrl = "";
            this.redirectUrl = "";
            this.blindType = "";
            this.blindMsg = "";
            this.myPageImgOrg = "";
            this.artistChnFlag = "N";
            this.isPowerDj = false;
            this.isArtistUser = false;
            this.djTitleToolTip = "";
            this.djPickToolTip = "";
            this.siteChnlToolTip = "";
            this.djTitle = "";
            this.djPickPlylstSeq = "";
            this.djPickFlag = "N";
            this.snsInfo = null;
            this.isUnderFourTeenMember = false;
            this.fanLoungeOpenFlag = null;
            this.friendOpenFlag = "Y";
        }
    }

    public static String BLIND_TYPE_B = "B";
    public static String BLIND_TYPE_T = "T";
    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x5E104FD23B3C0AD1L;

    public MyMusicSettingInformProfileSimpleRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

