package com.iloen.melon.net.v6x.response;

import S7.b;
import java.util.ArrayList;

public class DjMelgunInformProfileRes extends ResponseV6Res {
    public static class RESPONSE extends ProfileBaseRes {
        @b("BBSCHANNELSEQ")
        public String bbschannelseq;
        @b("CASTLIST")
        public CASTLIST castList;
        @b("CONTSID")
        public String contsId;
        @b("CONTSTYPECODE")
        public String contsTypeCode;
        @b("DJPLAYLISTLIST")
        public ArrayList djPlaylistList;
        @b("DJTITLE")
        public String djTitle;
        @b("FOLLOWUSERCNT")
        public String followUserCnt;
        @b("ISOFFICIAL")
        public boolean isOfficial;
        @b("LIKECNT")
        public String likeCnt;
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
        @b("OFFER1PLYLST")
        public PLAYLIST offer1Plylst;
        @b("OFFER2PLYLST")
        public PLAYLIST offer2Plylst;
        @b("PLYLSTCNT")
        public String plylstCnt;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        private static final long serialVersionUID = 0x4D40A4E80108CE9FL;
        @b("SNSINFO")
        public ArrayList snsInfo;
        @b("SUBSCRIBEYN")
        public String subscribeYn;

        public RESPONSE() {
            this.myPageImg = "";
            this.myPageImgOrg = "";
            this.memberNickName = "";
            this.myPageDesc = "";
            this.memberDjType = "";
            this.memberDjIconType = "";
            this.isOfficial = false;
            this.djTitle = "";
            this.contsId = "";
            this.bbschannelseq = "";
            this.contsTypeCode = "";
            this.followUserCnt = "";
            this.likeCnt = "";
            this.plylstCnt = "";
            this.postImg = "";
            this.postEditImg = "";
            this.subscribeYn = "N";
            this.snsInfo = null;
            this.djPlaylistList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3114C0ACB48B1D5FL;

    public DjMelgunInformProfileRes() {
        this.response = null;
    }
}

