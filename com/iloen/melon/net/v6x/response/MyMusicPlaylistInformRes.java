package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.GenreInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.PlaylistInformBaseRes;
import com.melon.net.res.common.DjPlayListInfoBase;
import java.util.ArrayList;

public class MyMusicPlaylistInformRes extends PlaylistInformBaseRes {
    public static class RESPONSE extends DjPlayListInfoBase {
        public static class PLYLSTGENRELIST extends GenreInfoBase {
            private static final long serialVersionUID = 0xAAFAB8BFD3553705L;

        }

        @b("BBSCHANNELSEQ")
        public String bbsChannelSeq;
        @b("INTRODMOBILEUPDTPOSBLYN")
        public String introDMobileUpdtPosblYN;
        @b("ISFRIEND")
        public boolean isFriend;
        @b("ISLABEL")
        public boolean isLabel;
        @b("ISLIKE")
        public boolean isLike;
        @b("ISOFFICIAL")
        public boolean isOfficial;
        @b("ISPOSBLUPDATEINTROD")
        public boolean isPosblUpdateIntrod;
        @b("ISWITHDRAW")
        public boolean isWithdraw;
        @b("MEMBERDJICONTYPE")
        public String memberDjIconType;
        @b("MUMSGIMG")
        public String muMsgImg;
        @b("OPENYN")
        public String openYN;
        @b("PLAYTIME")
        public String playTime;
        @b("PLYLSTCNT")
        public String plylstCnt;
        @b("PLYLSTDESC")
        public String plylstDesc;
        @b("PLYLSTGENRELIST")
        public ArrayList plylstGenreList;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        @b("REGDATE")
        public String regDate;
        private static final long serialVersionUID = 0x90B2D28BDFACFA3CL;
        @b("STATUS")
        public String status;
        @b("UPDTDATE")
        public String updtDate;
        @b("UPDTDATESTR")
        public String updtDateStr;
        @b("UPDTDATETIME")
        public String updtDateTime;

        public RESPONSE() {
            this.updtDateTime = "";
            this.plylstGenreList = null;
            this.postEditImg = "";
            this.isLabel = false;
            this.isWithdraw = false;
            this.isPosblUpdateIntrod = false;
            this.memberDjIconType = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x366C6A03674C142CL;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override  // com.iloen.melon.net.v4x.response.PlaylistInformBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

