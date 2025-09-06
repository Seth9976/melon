package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class DjPlaylistInformRes extends PlaylistInformBaseRes {
    public static class RESPONSE extends ResponseBase {
        public static class BANNER extends BannerBase {
            private static final long serialVersionUID = 0x8D000878078C352EL;

        }

        public static class OPTION implements Serializable {
            @b("ACTION")
            public String action;
            @b("LINKTYPE")
            public String linkType;
            @b("LINKURL")
            public String linkUrl;
            private static final long serialVersionUID = 0x1859C58B407DF9A6L;

            public OPTION() {
                this.action = "";
                this.linkType = "";
                this.linkUrl = "";
            }
        }

        public static class TAGLIST extends TagInfoBase {
            private static final long serialVersionUID = 0xB0051C4F50DF18D1L;

        }

        @b("BANNER")
        public BANNER banner;
        @b("BBSCHANNELSEQ")
        public String bbsChannelSeq;
        @b("DJMAGREGYN")
        public String djMagRegYN;
        @b("FAMEREGYN")
        public String fameRegYN;
        @b("INTRODMOBILEUPDTPOSBLYN")
        public String introdMobileUpdtPosblYN;
        @b("ISESSENTIAL")
        public boolean isEssential;
        @b("ISLABEL")
        public boolean isLabel;
        @b("ISPOWERDJ")
        public boolean isPowerDj;
        @b("LIKECNT")
        public String likeCnt;
        @b("LIKEYN")
        public String likeYN;
        @b("MAGAZNNAME")
        public String magaznName;
        @b("MEMBERDJTYPE")
        public String memberDjType;
        @b("MUSTORYYN")
        public String muStoryYN;
        @b("MUMSGIMG")
        public String mumsgImg;
        @b("OPENYN")
        public String openYN;
        @b("OPTION")
        public OPTION option;
        @b("OWNERMEMBERKEY")
        public String ownerMemberKey;
        @b("OWNERMYPAGEIMG")
        public String ownerMyPageImg;
        @b("OWNERNICKNAME")
        public String ownerNickname;
        @b("PLYLSTCNT")
        public String plylstCnt;
        @b("PLYLSTDESC")
        public String plylstDesc;
        @b("PLYLSTFAMEENDDT")
        public String plylstFameEndDt;
        @b("PLYLSTFAMESTARTDT")
        public String plylstFameStartDt;
        @b("PLYLSTFAMEWEEK")
        public String plylstFameWeek;
        @b("PLYLSTSEQ")
        public String plylstSeq;
        @b("PLYLSTTITLE")
        public String plylstTitle;
        @b("PLYLSTTYPECODE")
        public String plylstTypeCode;
        @b("POSTDATE")
        public String postDate;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        @b("REGDATE")
        public String regDate;
        private static final long serialVersionUID = 0xE31F429F81C6595AL;
        @b("SERIESPLYLSTSEQ")
        public String seriesPlaylistSeq;
        @b("SERIESYN")
        public String seriesYn;
        @b("SONGCNT")
        public String songCnt;
        @b("TAGLIST")
        public ArrayList tagList;
        @b("THUMBIMG")
        public String thumbImg;
        @b("UPDTDATE")
        public String updtDate;
        @b("UPDTDATETIME")
        public String updtDateTime;
        @b("WITHDRAWYN")
        public String withdrawYN;

        public RESPONSE() {
            this.plylstTypeCode = "";
            this.plylstTitle = "";
            this.plylstDesc = "";
            this.thumbImg = "";
            this.songCnt = "";
            this.openYN = "";
            this.likeYN = "";
            this.likeCnt = "";
            this.plylstCnt = "";
            this.regDate = "";
            this.updtDate = "";
            this.updtDateTime = "";
            this.magaznName = "";
            this.seriesPlaylistSeq = "";
            this.seriesYn = "";
            this.fameRegYN = "";
            this.plylstFameStartDt = "";
            this.plylstFameEndDt = "";
            this.plylstFameWeek = "";
            this.ownerMemberKey = "";
            this.ownerNickname = "";
            this.ownerMyPageImg = "";
            this.introdMobileUpdtPosblYN = "";
            this.bbsChannelSeq = "";
            this.djMagRegYN = "";
            this.plylstSeq = "";
            this.withdrawYN = "";
            this.postImg = "";
            this.postEditImg = "";
            this.mumsgImg = "";
            this.muStoryYN = "";
            this.option = null;
            this.isPowerDj = false;
            this.isLabel = false;
            this.isEssential = false;
            this.postDate = "";
            this.memberDjType = "";
            this.tagList = null;
            this.banner = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x981220681DBFC7A1L;

    public DjPlaylistInformRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.v4x.response.PlaylistInformBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

