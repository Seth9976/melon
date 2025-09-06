package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.GenreInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class ArtistPlylstMainInfoRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class PLYLSTGENRELIST extends GenreInfoBase {
            private static final long serialVersionUID = 0xCC2E56AACBAD10E2L;

        }

        @b("ALBUMIMG1")
        public String albumImg1;
        @b("ALBUMIMG2")
        public String albumImg2;
        @b("ALBUMIMG3")
        public String albumImg3;
        @b("ALBUMIMG4")
        public String albumImg4;
        @b("ARTISTLIST")
        public ArrayList artistList;
        @b("BBSCHANNELSEQ")
        public String bbsChannelSeq;
        @b("FANYN")
        public String fanYN;
        @b("LIKECNT")
        public String likeCnt;
        @b("LIKEYN")
        public String likeYN;
        @b("MUMSGIMG")
        public String muMsgImg;
        @b("PLAYTIME")
        public String playTime;
        @b("PLYLSTDESC")
        public String plylstDesc;
        @b("PLYLSTGENRELIST")
        public ArrayList plylstGenreList;
        @b("PLYLSTSEQ")
        public String plylstSeq;
        @b("PLYLSTTITLE")
        public String plylstTitle;
        @b("POSTDATE")
        public String postDate;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        @b("REGDATE")
        public String regDate;
        private static final long serialVersionUID = 0x61F88BD8FB7E0C08L;
        @b("SONGCNT")
        public String songCnt;
        @b("THUMBIMG")
        public String thumbImg;
        @b("UPDTDATE")
        public String updtDate;
        @b("UPDTDATESTR")
        public String updtDateStr;
        @b("UPDTDATETIME")
        public String updtDateTime;
        @b("VIEWCNT")
        public String viewCnt;

        public RESPONSE() {
            this.plylstTitle = "";
            this.artistList = null;
            this.fanYN = "";
            this.plylstDesc = "";
            this.thumbImg = "";
            this.songCnt = "";
            this.likeYN = "";
            this.likeCnt = "";
            this.albumImg1 = "";
            this.albumImg2 = "";
            this.albumImg3 = "";
            this.albumImg4 = "";
            this.regDate = "";
            this.updtDate = "";
            this.updtDateTime = "";
            this.plylstGenreList = null;
            this.bbsChannelSeq = "";
            this.plylstSeq = "";
            this.viewCnt = "";
            this.postDate = "";
            this.postImg = "";
            this.postEditImg = "";
            this.muMsgImg = "";
            this.playTime = "";
            this.updtDateStr = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x21D01485CD178B05L;

    public ArtistPlylstMainInfoRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

